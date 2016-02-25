package com.extreamvomit.intent_test;

import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void ClickMainButton(View v){
        Log.d(TAG, "Start_onClick");
        Toast.makeText(this, "ClickMainButton", Toast.LENGTH_LONG).show();
        Intent intent = new Intent();
        intent.setClassName("com.extreamvomit.intent_test", "com.extreamvomit.intent_test.ActivityJava2");
        intent.putExtra("com.extreamvomit.intent_test.testString", "!TEST STRING!");

        startActivity(intent); // intent発行、画面遷移フラグ立つ
        Toast.makeText(this, "スタートし終わったよ", Toast.LENGTH_LONG).show();
        Log.i(TAG, "fin_onClick");
    }

    public void ClickMainButtonSecond(View v){
        Log.d(TAG, "Start_onClick_Second");
        Intent nIntent = new Intent();
        nIntent.setClassName("com.extreamvomit.intent_test", "com.extreamvomit.intent_test.ActivityJava2");
        PendingIntent pIntent = PendingIntent.getActivity(this, 0, nIntent, 0);
        // Intentを発行しないので、この時点では遷移しない


        Log.i(TAG, "fin_onClick_Second");
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
