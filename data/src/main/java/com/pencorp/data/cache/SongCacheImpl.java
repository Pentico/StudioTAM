package com.pencorp.data.cache;

import android.content.Context;

import com.pencorp.data.cache.JsonSerializer.JsonSerializer;
import com.pencorp.data.entity.SongEntity;
import com.pencorp.domain.executor.ThreadExecutor;

import java.io.File;

import rx.Observable;

/**
 * Created by Tuane on 3/02/17.
 */

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
    public SongCacheImpl(Context context, File cacheDir, JsonSerializer serializer,
                         FileManager fileManager, ThreadExecutor threadExecutor) {
        if (context == null || serializer == null || fileManager == null || threadExecutor == null) {
            throw new IllegalArgumentException("Invalid null parameter");
        }
        this.context = context;
        this.cacheDir = cacheDir;
        this.serializer = serializer;
        this.fileManager = fileManager;
        this.threadExecutor = threadExecutor;
    }

    //TODO finish this one

    @Override
    public Observable<SongEntity> get(long songId) {
        return null;
    }

    @Override
    public void put(SongEntity songEntity) {

    }

    @Override
    public boolean isCached(long songId) {
        return false;
    }

    @Override
    public boolean isExpired() {
        return false;
    }

    @Override
    public void evictAll() {

    }
}
