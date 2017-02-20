package com.pencorp.studiotam.test.exception;

import android.test.AndroidTestCase;

import com.pencorp.data.exception.NetworkConnectionException;
import com.pencorp.data.exception.SongNotFoundException;

import com.pencorp.studiotam.R;


import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


/**
 * Created by Tuane on 16/02/17.
 */

public class ErrorMessageFactoryTest extends AndroidTestCase {

    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }

    public void testNetworkConnectinErrorMessage() {

        String expectedMessage = getContext().getString(R.string.exception_message_no_connection);
        String actualMessage = ErrorMessageFactory.create(getContext(),
                new NetworkConnectionException());

        assertThat(actualMessage, is(equalTo(expectedMessage)));
    }

    public void testUserNotFoundErrorMessage() {

        String expectedMessage = getContext().getString(R.string.exception_message_song_not_found);
        String actualMessage = ErrorMessageFactory.create(getContext(), new SongNotFoundException());
        assertThat(actualMessage, is(equalTo(expectedMessage)));
    }
}
