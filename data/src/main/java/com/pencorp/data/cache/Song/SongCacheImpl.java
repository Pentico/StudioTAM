package com.pencorp.data.cache.Song;

import android.content.Context;

import com.pencorp.data.cache.FileManager;
import com.pencorp.data.cache.JsonSerializer.JsonSerializer;
import com.pencorp.data.entity.SongEntity;
import com.pencorp.data.exception.SongNotFoundException;
import com.pencorp.domain.executor.ThreadExecutor;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import rx.Observable;

/**
 * Created by Tuane on 3/02/17.
 */
@Singleton
public class SongCacheImpl implements SongCache {


    private static final String SETTINGS_FILE_NAME = "com.pencorp.SETTINGS";
    private static final String SETTINGS_KEY_LAST_CACHE_UPDATE = "last_cache_update";

    private static final String DEFAULT_FILE_NAME = "user_";
    private static final long EXPIRATION_TIME = 60 * 10 * 1000;

    private final Context context;
    private final File cacheDir;
    private final JsonSerializer serializer;
    private final FileManager fileManager;
    private final ThreadExecutor threadExecutor;

    /**
     * Constructor of the class {@link SongCacheImpl}.
     *
     * @param context A
     * @param serializer {@link JsonSerializer} for object serialization.
     * @param fileManager {@link FileManager} for saving serialized objects to the file system.
     */
    @Inject
    public SongCacheImpl(Context context, JsonSerializer serializer,
                         FileManager fileManager, ThreadExecutor threadExecutor) {
        if (context == null || serializer == null || fileManager == null || threadExecutor == null) {
            throw new IllegalArgumentException("Invalid null parameter");
        }
        this.context = context;
        this.cacheDir = this.context.getCacheDir();
        this.serializer = serializer;
        this.fileManager = fileManager;
        this.threadExecutor = threadExecutor;
    }


    @Override
    public Observable<SongEntity> get(final long songId) {

        return Observable.create(subscriber -> {
            File songEntityFile = SongCacheImpl.this.buildFile(songId);
            String fileContent = SongCacheImpl.this.fileManager.readFileContent(songEntityFile);
            SongEntity songEntity = SongCacheImpl.this.serializer.deserializeSong(fileContent);

            if(songEntity != null) {
                subscriber.onNext(songEntity);
                subscriber.onCompleted();
            }else {
                subscriber.onError(new SongNotFoundException());
            }
        });
    }

    @Override
    public Observable<List<SongEntity>> get() {
        return Observable.create(subscriber -> {
            File songEntityFile = SongCacheImpl.this.buildFile(1934);
            String fileContent  = SongCacheImpl.this.fileManager.readFileContent(songEntityFile);
            List<SongEntity> songEntityList = SongCacheImpl.this.serializer.deserializeSongList(fileContent);

            if(songEntityList != null) {
                subscriber.onNext(songEntityList);
                subscriber.onCompleted();
            } else {
                subscriber.onError(new SongNotFoundException("Song list returned NULL"));
            }
        });
    }

    /**
     *
     * @param songEntityList Element to insert in the cache.
     */
    @Override
    public void put(List<SongEntity> songEntityList) {

        if(songEntityList != null){
            File songEntityListFile = this.buildFile(1934); // Random number to build the file
            String jsonString = this.serializer.serializeSongList(songEntityList);
        }
    }

    @Override
    public void put(SongEntity songEntity) {

        if(songEntity != null) {
            File songEntityFile = this.buildFile(songEntity.getId());
            if (!isCached(songEntity.getId())) {
                String jsonString = this.serializer.serializeSong(songEntity);
                this.executeAsynchronously(new CacheWriter(this.fileManager, songEntityFile,
                       jsonString ));
                setLastCacheUpdateTimeMillis(); // TODO check this !!!! important
            }
        }
    }

    @Override
    public boolean isCached(long songId) {
        File songEntitiyFile = this.buildFile(songId);
        return this.fileManager.exists(songEntitiyFile);
    }

    @Override
    public boolean isExpired() {
        long currentTime = System.currentTimeMillis();
        long lastUpdateTime = this.getLastCacheUpdateTimeMillis();

        boolean expired = ((currentTime - lastUpdateTime) > EXPIRATION_TIME);

        if (expired) {
            this.evictAll();
        }

        return expired;
    }

    @Override
    public void evictAll() {
        this.executeAsynchronously(new CacheEvictor(this.fileManager, this.cacheDir));
    }

    /**
     * Build a file, used to be inserted in the disk cache.
     *
     * @param songId The id song to build the file.
     * @return A valid file.
     */
    private File buildFile(long songId) {
        StringBuilder fileNameBuilder = new StringBuilder();
        fileNameBuilder.append(this.cacheDir.getPath());
        fileNameBuilder.append(File.separator);
        fileNameBuilder.append(DEFAULT_FILE_NAME);
        fileNameBuilder.append(songId);

        return new File(fileNameBuilder.toString());
    }

    /**
     * Set in millis, the last time the cache was accessed.
     */
    private void setLastCacheUpdateTimeMillis() {
        long currentMillis = System.currentTimeMillis();
        this.fileManager.writeToPreferences(this.context, SETTINGS_FILE_NAME,
                SETTINGS_KEY_LAST_CACHE_UPDATE, currentMillis);
    }

    /**
     * Get in millis, the last time the cache was accessed.
     */
    private long getLastCacheUpdateTimeMillis() {
        return this.fileManager.getFromPreferences(this.context, SETTINGS_FILE_NAME,
                SETTINGS_KEY_LAST_CACHE_UPDATE);
    }

    /**
     * Executes a {@link Runnable} in another Thread.
     *
     * @param runnable {@link Runnable} to execute
     */
    private void executeAsynchronously(Runnable runnable) {
        this.threadExecutor.execute(runnable);
    }

    /**
     * {@link Runnable} class for writing to disk.
     */
    private static class CacheWriter implements Runnable {
        private final FileManager fileManager;
        private final File fileToWrite;
        private final String fileContent;

        CacheWriter(FileManager fileManager, File fileToWrite, String fileContent) {
            this.fileManager = fileManager;
            this.fileToWrite = fileToWrite;
            this.fileContent = fileContent;
        }

        @Override public void run() {
            this.fileManager.writeToFile(fileToWrite, fileContent);
        }
    }

    /**
     * {@link Runnable} class for evicting all the cached files
     */
    private static class CacheEvictor implements Runnable {
        private final FileManager fileManager;
        private final File cacheDir;

        CacheEvictor(FileManager fileManager, File cacheDir) {
            this.fileManager = fileManager;
            this.cacheDir = cacheDir;
        }

        @Override public void run() {
            this.fileManager.clearDirectory(this.cacheDir);
        }
    }
}
