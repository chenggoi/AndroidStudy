package com.chenggoi.androidstudy.CoolWeather.util;

/**
 * Created by chenggoi on 16-8-17.
 */

public interface HttpCallbackListener {
    void onFinish(String response);

    void onError(Exception e);
}
