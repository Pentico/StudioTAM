package com.pencorp.data.media;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.fernandocejas.frodo.annotation.RxLogObservable;
import com.pencorp.data.entity.SongEntity;
import com.pencorp.data.entity.mapper.SongEntityDataMapper;
import com.pencorp.data.exception.NetworkConnectionException;
import com.pencorp.data.exception.SongNotFoundException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import rx.Observable;

/**
 * Created by Tuane on 4/02/17.
 */

public class RestSongsApiImpl implements RestSongsApi {

    private final Context context;
    private final SongEntityDataMapper songEntityDataMapper;
    private final LoadingSongs loadingSongs;

    /**
     *
     * @param context {@link android.content.Context}
     * @param songEntityDataMapper {@link SongEntityDataMapper}
     */
    public RestSongsApiImpl(Context context, SongEntityDataMapper songEntityDataMapper,
                            LoadingSongs loadingSongs) {
        if(context == null || songEntityDataMapper == null || loadingSongs == null){
            throw new IllegalArgumentException("The contructor parameters cannot be null.");
        }
        this.context = context;
        this.songEntityDataMapper = songEntityDataMapper;
        this.loadingSongs = loadingSongs;
    }

    @RxLogObservable
    @Override
    public Observable<List<SongEntity>> songEntityList() {

        return Observable.create(subscriber -> {
            List<SongEntity> repsonse = GetSongs();
            if( repsonse != null) {
                subscriber.onNext(repsonse);
                subscriber.onCompleted();
            }else {
                subscriber.onError(new NetworkConnectionException());
            }

        });
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

    /**
     * Check if we already Scanned songs TODO
     * @return
     */
    private boolean ifNotScannedSongs(){

        return false;
    }

    private List<SongEntity>   GetSongs() {
        return loadingSongs.scanSongs(context);
    }

}
