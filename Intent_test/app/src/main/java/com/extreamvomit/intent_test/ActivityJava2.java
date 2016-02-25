package com.extreamvomit.intent_test;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

/**
 * Created by vesp on 15/12/18.
 */
public class ActivityJava2 extends AppCompatActivity {
    private static final String TAG = "Activity2";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity2);

        Intent intent = getIntent();
        if(intent != null){
            String str = intent.getStringExtra("com.extreamvomit.intent_test.testString");
            Toast.makeText(this, str, Toast.LENGTH_LONG).show();
            Log.i(TAG, "インテント情報あり");
        }
        Log.i(TAG, "fin_onClick");
    }

    public void ClickMainButton2(View v){
        Log.d(TAG, "onClick");
        Toast.makeText(this, "ClickActivity2", Toast.LENGTH_LONG).show();
        //画面を終了する（そして、呼び出し元のActivityに画面が戻る）
        finish();
        Log.d(TAG, "わてfinしますわ");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "onResume");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, "onRestart");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy");
    }

}
