package com.chenggoi.androidstudy.SMSTest;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.telephony.SmsMessage;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.chenggoi.androidstudy.R;

/**
 * Created by chenggoi on 16-8-4.
 */

public class SMSActivity extends Activity {
    private TextView sender;
    private TextView content;

    private IntentFilter intentFilter;
    private MessageReceiver messageReceiver;

    private EditText to;
    private EditText msgInput;
    private Button send;

    private IntentFilter sendFilter;
    private SendStatusReceiver sendStatusReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.sms_activity);

        sender = (TextView) findViewById(R.id.sms_text);
        content = (TextView) findViewById(R.id.sms_content);
        intentFilter = new IntentFilter();
        intentFilter.addAction("android.provider.Telephoney.SMS_RECEIVED");
        messageReceiver = new MessageReceiver();
        registerReceiver(messageReceiver, intentFilter);

        to = (EditText) findViewById(R.id.to);
        msgInput = (EditText) findViewById(R.id.msg_input);
        send = (Button) findViewById(R.id.send);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SmsManager smsManager = SmsManager.getDefault();
                Intent sentIntent = new Intent("SENT_SMS_ACTION");
                PendingIntent pi = PendingIntent.getBroadcast(SMSActivity.this, 0, sentIntent, 0);
                smsManager.sendTextMessage(to.getText().toString(), null, msgInput.getText().toString(), pi, null);
            }
        });

        sendFilter = new IntentFilter();
        sendFilter.addAction("SENT_SMS_ACTION");
        sendStatusReceiver = new SendStatusReceiver();
        registerReceiver(sendStatusReceiver, sendFilter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(messageReceiver);
        unregisterReceiver(sendStatusReceiver);
    }

    class MessageReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            Bundle bundle = intent.getExtras();
            Object[] pdus = (Object[]) bundle.get("pdus");
            SmsMessage[] smsMessages = new SmsMessage[pdus.length];
            for (int i = 0; i < smsMessages.length; i++) {
                smsMessages[i] = SmsMessage.createFromPdu((byte[]) pdus[i]);
            }
            String address = smsMessages[0].getOriginatingAddress();
            String fullMessage = "";
            for (SmsMessage message : smsMessages) {
                fullMessage += message.getMessageBody();
            }
            sender.setText(address);
            content.setText(fullMessage);
        }
    }

    class SendStatusReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            if (getResultCode() == RESULT_OK) {
                Toast.makeText(context, "Success", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(context, "Failed", Toast.LENGTH_LONG);
            }
        }
    }
}
