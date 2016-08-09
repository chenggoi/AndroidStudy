package com.chenggoi.androidstudy.Thread;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.chenggoi.androidstudy.R;

/**
 * Created by chenggoi on 16-8-9.
 */

public class ThreadActivity extends Activity implements View.OnClickListener {
    public static final int UPDATE_TEXT = 1;
    private TextView textView;
    private Button changeText;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case UPDATE_TEXT:
                    Log.d("Thread", "change");
                    textView.setText("NICE TO MEET YOU!");
                    break;
                default:
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.thread_activity);
        textView = (TextView) findViewById(R.id.thread_text);
        changeText = (Button) findViewById(R.id.change_text);
        changeText.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Log.d("Thread", v.getId() + " ");
        switch (v.getId()) {
            case R.id.change_text:
                Log.d("Thread", "Run");
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Message message = new Message();
                        message.what = UPDATE_TEXT;
                        handler.sendMessage(message);
                        Log.d("Thread", "send");
                    }
                }).start();
                break;
            default:
                break;
        }
    }
}
