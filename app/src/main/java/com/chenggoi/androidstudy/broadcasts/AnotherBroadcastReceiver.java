package com.chenggoi.androidstudy.broadcasts;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by chenggoi on 16-7-26.
 */

public class AnotherBroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "Another Broadcast Receiver", Toast.LENGTH_LONG).show();
    }
}
