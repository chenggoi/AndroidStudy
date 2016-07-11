package com.chenggoi.androidstudy;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by chenggoi on 16-7-11.
 */

public class MainActivity extends Activity {
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.add_item:
                Toast.makeText(MainActivity.this, "Click Add", Toast.LENGTH_SHORT).show();
                break;
            case R.id.remove_item:
                Toast.makeText(MainActivity.this, "Click Remove", Toast.LENGTH_SHORT).show();
                break;
            default:
        }
        return true;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode){
            case 1:
                if (resultCode == RESULT_OK){
                    String resultData=data.getStringExtra("data_return");
                    Log.d("MainActivity",resultData);
                }
                break;
            default:
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.main_activity);
        Button button1 = (Button) findViewById(R.id.button_1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Click Button 1", Toast.LENGTH_SHORT).show();
//                finish();

//                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                Intent intent = new Intent("com.chenggoi.androidstudy.ACTION_START");
                intent.addCategory("com.chenggoi.androidstudy.MY_CATEGORY");
                String data = "GoGoGo";
                intent.putExtra("extra_data", data);
//                startActivity(intent);
                startActivityForResult(intent, 1);
            }
        });


    }
}
