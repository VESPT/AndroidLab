package com.extreamvomit.androidcoolmouth;

/**
 * Created by vesp on 15/12/07.
 */


        import android.app.PendingIntent;
        import android.app.Service;
        import android.appwidget.AppWidgetManager;
        import android.content.ComponentName;
        import android.content.Intent;
        import android.media.AudioManager;
        import android.media.SoundPool;
        import android.os.Handler;
        import android.os.IBinder;
        import android.util.Log;
        import android.widget.Button;
        import android.widget.RemoteViews;
        import android.widget.TextView;

        import java.io.FileInputStream;
        import java.io.ObjectOutputStream;
        import java.io.FileOutputStream;
        import java.io.Serializable;
        import java.util.Timer;
        import java.util.TimerTask;

public class ServiceSample extends Service {
    private final String BUTTON_CLICK_ACTION = "BUTTON_CLICK_ACTION";
    private final String TAG = "Test_ServiceLog"; // デバッグ用

    //効果音用
    SoundPool sp;
    int sound_id;

    // タイマー
    TextView text1;
    Button button1;
    Timer timer = null;
    Handler handle = new Handler();

    // Remote
    RemoteViews remoteViews;

    // Widget
    int appWidgetId = -1;

    @Override
    public void onCreate() {
        // 効果音用
        sp = new SoundPool(10, AudioManager.STREAM_MUSIC, 0);
        sound_id = sp.load(getApplicationContext(), R.raw.se_maoudamashii_system46, 1 );
    }

    @Override
    public void onStart(Intent intent, int startId) {
        Log.d(TAG, "onStart");
        super.onStart(intent, startId);

        Log.d(TAG, "ServiceへIntentやって来ました");
        remoteViews = new RemoteViews(getPackageName(), R.layout.main);
        // ボタンが押された時に発行されたインテントの場合は文字を変更する
        if (BUTTON_CLICK_ACTION.equals(intent.getAction())) {
            Log.d(TAG, "BUTTON_CLICK_ACTION");
            appWidgetId = intent.getIntExtra( AppWidgetManager.EXTRA_APPWIDGET_ID, -1);
            Log.d(TAG, "WidgetID is " + appWidgetId);
            remoteViews.setTextViewText(R.id.text, "Push Button" + appWidgetId);
            sp.play(sound_id, 1.0F, 1.0F, 0, 0, 1.0F);

            // 画像切り替え
            remoteViews.setImageViewResource(R.id.vgun_imageButton, R.drawable.g_fa010s);

            // Timer起動
            if (timer != null) {
                timer.cancel();
            }
            timer = null;
            timer = new Timer();
            timer.schedule(new MyTimer(), 1000); // ミリ秒でセット

            // AppWidgetの画面更新
            Log.d(TAG, "appWidgetManager起動");
            //ComponentName thisWidget = new ComponentName(this, MyWidget.class);
            AppWidgetManager manager = AppWidgetManager.getInstance(this);
            manager.updateAppWidget(appWidgetId, remoteViews);
            Log.d(TAG, "updateAppwidget終了");

            // シリアライズ
            WidgetNum data = new WidgetNum();
            data.setString("TEST");
            data.setNumber(appWidgetId);
            try {
                FileOutputStream fos = openFileOutput("WidgetSaveData.dat", MODE_PRIVATE);
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                oos.writeObject(data);
                oos.close();
            } catch (Exception e) {
                Log.d(TAG, "Error");
            }
        }
    }

    // Bindは使わないのでNULLで返す
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    class MyTimer extends TimerTask {
        @Override
        public void run() { // ここのRunはTimerスレッドが行うRun
            Log.d(TAG, "TimerRun");
            if(appWidgetId == -1) return; // appWidgetに正しい値が入っていなかったら実行しない
            handle.post(new Runnable() {
                @Override
                public void run() { // ここのRunはUIスレッドが行うRun
                    Log.d(TAG, "TimerRunDo");
                    remoteViews.setTextViewText(R.id.text, "1秒経過");
                    // 画像切り替え
                    remoteViews.setImageViewResource(R.id.vgun_imageButton, R.drawable.g_msz006);
                    AppWidgetManager manager = AppWidgetManager.getInstance(getApplicationContext());
                    manager.updateAppWidget(appWidgetId, remoteViews);
                }
            });
        }
    }
}