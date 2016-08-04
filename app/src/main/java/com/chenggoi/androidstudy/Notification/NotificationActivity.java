package com.chenggoi.androidstudy.Notification;

import android.app.Activity;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.view.View;
import android.widget.Button;

import com.chenggoi.androidstudy.MainActivity;
import com.chenggoi.androidstudy.R;

/**
 * Created by chenggoi on 16-8-3.
 */

public class NotificationActivity extends Activity implements View.OnClickListener {
    private Button sendButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notification_activity);
        sendButton = (Button) findViewById(R.id.notification_button);
        sendButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.notification_button:
                NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                NotificationCompat.Builder builder = new NotificationCompat.Builder(this).setSmallIcon(R.drawable.ic_launcher).setTicker("This is a ticker").setContentTitle("Title").setContentText("Text");
                Intent intent = new Intent(this, MainActivity.class);
                PendingIntent pi = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_CANCEL_CURRENT);
                builder.setContentIntent(pi);

                notificationManager.notify(1, builder.build());

        }
    }
}
