package com.chenggoi.androidstudy;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by chenggoi on 16-7-11.
 * Close all Activity
 */

public class NormalActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.normal_activity);
    }
}
