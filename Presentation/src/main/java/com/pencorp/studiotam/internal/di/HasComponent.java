package com.pencorp.studiotam.internal.di;

/**
 * Created by Tuane on 3/02/17.
 */

/**
 * Interface representing a contract for clients that contains a component for dependency injection.
 */
public interface HasComponent<C> {
    C getComponent();
}