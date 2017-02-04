package com.pencorp.data.media;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.pencorp.data.entity.SongEntity;
import com.pencorp.data.entity.mapper.SongEntityDataMapper;

import java.util.List;

import rx.Observable;

/**
 * Created by Tuane on 4/02/17.
 */

public class RestSongsApiImpl implements RestSongsApi {

    private final Context context;
    private final SongEntityDataMapper songEntityDataMapper;

    /**
     *
     * @param context {@link android.content.Context}
     * @param songEntityDataMapper {@link SongEntityDataMapper}
     */
    public RestSongsApiImpl(Context context, SongEntityDataMapper songEntityDataMapper) {
        if(context == null || songEntityDataMapper == null){
            throw new IllegalArgumentException("The contructor parameters cannot be null.");
        }
        this.context = context;
        this.songEntityDataMapper = songEntityDataMapper;
    }

    @Override
    public Observable<List<SongEntity>> userEntityList() {
        return null;
    }



    /**
     * Checks if the device has any active internet connection.
     *
     * @return true device with internet connection, otherwise false.
     */
    private boolean isThereInternetConnection() {
        boolean isConnected;

        ConnectivityManager connectivityManager =
                (ConnectivityManager) this.context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        isConnected = (networkInfo != null && networkInfo.isConnectedOrConnecting());

        return isConnected;
    }
}
