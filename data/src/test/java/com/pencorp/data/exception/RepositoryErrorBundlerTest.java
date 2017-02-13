package com.pencorp.data.exception;

import com.pencorp.data.ApplicationTestCase;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.verify;

/**
 * Created by Tuane on 9/02/17.
 */

public class RepositoryErrorBundlerTest extends ApplicationTestCase {

    private RepositoryErrorBundle repositoryErrorBundle;

    @Mock
    private Exception mockException;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        repositoryErrorBundle = new RepositoryErrorBundle(mockException);
    }

    @Test
    public void testGetErrorMessageInteration() {
        repositoryErrorBundle.getErrorMessage();

        verify(mockException).getMessage();
    }
}
