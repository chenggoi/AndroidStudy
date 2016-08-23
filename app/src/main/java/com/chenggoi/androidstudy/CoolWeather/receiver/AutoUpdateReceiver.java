package com.chenggoi.androidstudy.CoolWeather.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.chenggoi.androidstudy.CoolWeather.service.AutoUpdateService;

/**
 * Created by chenggoi on 16-8-23.
 */

public class AutoUpdateReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Intent i = new Intent(context, AutoUpdateService.class);
        context.startService(intent);
    }
}
