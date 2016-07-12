package com.chenggoi.androidstudy;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

/**
 * Created by chenggoi on 16-7-12.
 */

public class UITestActivity extends Activity implements View.OnClickListener {
    private Button button;
    private EditText editText;
    private ImageView imageView;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.uitest);

        button = (Button) findViewById(R.id.button);
        editText = (EditText) findViewById(R.id.edit_text);
        imageView = (ImageView) findViewById(R.id.image_view);
        progressBar = (ProgressBar) findViewById(R.id.progress_bar);

        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.button:
//                String inputText = editText.getText().toString();
//                imageView.setImageResource(R.drawable.ic_launcher);
//
//                if (progressBar.getVisibility() == View.GONE) {
//                    progressBar.setVisibility(View.VISIBLE);
//                } else {
//                    progressBar.setVisibility(View.GONE);
//                }
//                Toast.makeText(UITestActivity.this, inputText, Toast.LENGTH_SHORT).show();
//                int progress = progressBar.getProgress();
//                progress += 10;
//                progressBar.setProgress(progress);

//                AlertDialog.Builder builder = new AlertDialog.Builder(UITestActivity.this);
//                builder.setTitle("Dialog aaa")
//                        .setMessage("Sth imp")
//                        .setCancelable(false)
//                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//
//                            }
//                        })
//                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//
//                            }
//                        }).show();

                ProgressDialog progressDialog = new ProgressDialog(UITestActivity.this);
                progressDialog.setTitle("Progress Dialog");
                progressDialog.setMessage("Loading...");
                progressDialog.setCancelable(true);
                progressDialog.show();
        }
    }
}
