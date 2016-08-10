package com.chenggoi.androidstudy.Service;

import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.chenggoi.androidstudy.R;

/**
 * Created by chenggoi on 16-8-10.
 */

public class MyService extends Service {
    private static final String TAG = "MyServicce";

    private DownloadBinder downloadBinder = new DownloadBinder();

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG, "onStartCommand");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate");
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        Intent notificationIntent = new Intent(this, ServiceActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, notificationIntent, 0);
        builder.setTicker("Notification comes").setSmallIcon(R.drawable.ic_launcher).setContentTitle("This is title").setContentText("This is content").setContentIntent(pendingIntent);
        startForeground(1, builder.build());
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return downloadBinder;
    }

    class DownloadBinder extends Binder {
        public void startDownload() {
            Log.d(TAG, "start Download");
        }

        public int getProgress() {
            Log.d(TAG, "get Progress");
            return 0;
        }

    }
}
