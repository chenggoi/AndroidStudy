package com.chenggoi.androidstudy;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

/**
 * Created by chenggoi on 16-7-12.
 */

public class BaseActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("BaseActivity",getClass().getSimpleName());

    }
}
