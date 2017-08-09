package com.dubinin.feedbackportal.adapter.adapter;

/**
 * Created by Vladyslav_Dubinin on 21/7/2017.
 */
public interface Adapter {
    <T> T adapt(Object source, Class<T> destinationClass);
}
