package com.chenggoi.androidstudy;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

/**
 * Created by chenggoi on 16-7-11.
 */

public class SecondActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);

        Intent getIntent = getIntent();
        String data = getIntent.getStringExtra("extra_data");
        Log.d("SecondActivity",data);
        Button button2 = (Button) findViewById(R.id.button_2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(Intent.ACTION_VIEW);
//                intent.setData(Uri.parse("http://chenggoi.com"));
//                startActivity(intent);

                Intent intent=new Intent();
                intent.putExtra("data_return","BackBackBack");
                setResult(RESULT_OK,intent);
                finish();
            }
        });
    }
}
