package com.chenggoi.androidstudy.Service;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

/**
 * Created by chenggoi on 16-8-10.
 */

public class MyIntentService extends IntentService {
    public MyIntentService() {
        super("MyIntentService");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("MyIntentService", "onDestroy");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        Log.d("MyIntentService", "Thread id : " + Thread.currentThread().getId());
    }
}
