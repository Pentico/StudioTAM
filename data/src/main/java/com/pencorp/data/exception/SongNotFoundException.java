package com.pencorp.data.exception;

/**
 * Created by Tuane on 4/02/17.
 */

/**
 * Exception throw by the application when a Song search can't return a valid result.
 */
public class SongNotFoundException extends Exception {

    public SongNotFoundException(){
        super();
    }

    public SongNotFoundException(final String message){
        super(message);
    }

    public SongNotFoundException(final String message, final Throwable cause){
        super(message, cause);
    }

    public SongNotFoundException(final Throwable cause){
        super(cause);
    }
}
