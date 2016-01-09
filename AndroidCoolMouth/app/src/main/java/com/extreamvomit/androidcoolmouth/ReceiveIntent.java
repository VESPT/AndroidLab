package com.extreamvomit.androidcoolmouth;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

/**
 * Created by vesp on 15/12/20.
 */
public class ReceiveIntent extends Activity {
    private final String TAG = "Test_Recieve"; // デバッグ用

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //Log.d(TAG, "Intentもらうで");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.resource_view);

        // intent get
        Intent intent = getIntent();
        if(intent != null){
            String str = intent.getStringExtra("org.jpn.techbooster.demo.intent.testString");
            Toast.makeText(this, str, Toast.LENGTH_LONG).show();
        }
        else{
         //   Log.d(TAG, "Intentもろうた");
        }
    }

    public void receive_button(View v){
        Toast.makeText(this, "(´ω｀)", Toast.LENGTH_SHORT).show();
        finish();
    }
}
