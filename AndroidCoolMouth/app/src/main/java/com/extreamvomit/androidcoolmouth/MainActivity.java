package com.extreamvomit.androidcoolmouth;

import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;
import android.media.MediaPlayer; // 音声用
import android.widget.Button;
import java.io.IOException;
import android.media.SoundPool; // 効果音用
import java.util.Timer;
import java.util.TimerTask;
import android.os.Handler;
import static com.extreamvomit.androidcoolmouth.WidgetTypeNum.WTNUM1;
import static com.extreamvomit.androidcoolmouth.TypeDefine.TYPE_02;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private final String TAG = "MainActivity"; // デバッグ用
    // 音声再生ボタン
    //MediaPlayer mp = null;
    Button play_button;

    // 効果音用
    SoundPool sp;
    int sound_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        /*
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        */

        /*
        // 音声再生用
        mp = MediaPlayer.create(this, R.raw.hit01);
        play_button = (Button) findViewById(R.id.PlayButton);
        play_button.setOnClickListener(this);
*/
        // 効果音用
        sp = new SoundPool(10, AudioManager.STREAM_MUSIC, 0);
        sound_id = sp.load(this, R.raw.se_maoudamashii_system46, 1 );
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

    /*
    public void MyOnClickMethod(View v){
        Toast.makeText(this, "(´・ω・｀)", Toast.LENGTH_SHORT).show();
        WTNUM1 = TYPE_02;

        // サービスの停止
        Context app_context = getApplicationContext();
        Intent service_intent = new Intent(app_context, WidgetService.class);
        app_context.stopService(service_intent);

        // Activity終了
        finish();
    }

    */
    public void onClick(View v) {
        // アイコン選択Activiti召喚
        Intent icon_intent = new Intent(this, ReceiveIntent.class);
        icon_intent.putExtra("org.jpn.techbooster.demo.intent.testString", "!TEST STRING!");
        //startActivity(icon_intent);

        WTNUM1 = TYPE_02;

        Log.d("SetWidgetSound", "Activity　Sound_id = " + sound_id);
        sp.play(sound_id, 1.0F, 1.0F, 0, 0, 1.0F);

    }

}
