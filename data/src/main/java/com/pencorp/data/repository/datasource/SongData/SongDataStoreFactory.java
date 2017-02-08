package com.pencorp.data.repository.datasource.SongData;

import android.content.Context;
import android.support.annotation.NonNull;

import com.pencorp.data.cache.Song.SongCache;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by Tuane on 3/02/17.
 */

@Singleton
public class SongDataStoreFactory {

    private final Context context;
    private final SongCache songCache;

    @Inject
    public SongDataStoreFactory(@NonNull Context context, @NonNull  SongCache songCache) {
        this.context = context.getApplicationContext();
        this.songCache = songCache;
    }

    /**
     * Create {@link SongDataStore} from a songId
     */
    public SongDataStore create(long songId) {
        SongDataStore songDataStore;
        songDataStore = new DiskSongDataStore(this.songCache);

        // TODO impliment CloudDataStore().
       /* if (!this.userCache.isExpired() && this.userCache.isCached(userId)) {
            userDataStore = new DiskUserDataStore(this.userCache);
        } else {
            userDataStore = createCloudDataStore();
        }*/

        return songDataStore;
    }

    /**
     * TODO
     * Create {@link SongDataStore} to retrieve data from the Cloud.
     * @return
     */
    public SongDataStore createCloudDataStore(){
        return null;
    }

    public SongDataStore createDiskDataStore() {

        return new DiskSongDataStore()
    }
}
