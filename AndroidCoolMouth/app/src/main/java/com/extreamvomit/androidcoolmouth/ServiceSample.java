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
        import android.os.IBinder;
        import android.util.Log;
        import android.widget.RemoteViews;

        import java.io.FileInputStream;
        import java.io.ObjectOutputStream;
        import java.io.FileOutputStream;
        import java.io.Serializable;

public class ServiceSample extends Service {
    private final String BUTTON_CLICK_ACTION = "BUTTON_CLICK_ACTION";
    private final String TAG = "Test_ServiceLog"; // デバッグ用

    //効果音用
    SoundPool sp;
    int sound_id;

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

        // ボタンが押された時に発行されるインテントを準備する
        /*
        Intent buttonIntent = new Intent();
        buttonIntent.setAction(BUTTON_CLICK_ACTION);
        buttonIntent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, appWidgetId);
        PendingIntent pendingIntent = PendingIntent.getService(this, appWidgetId, buttonIntent, 0); //Serviceへインテントを投げる設定
        Log.d(TAG, "pendingIntent準備完了");
        RemoteViews remoteViews = new RemoteViews(getPackageName(), R.layout.main);
        remoteViews.setOnClickPendingIntent(R.id.button, pendingIntent); // WidgetButtonをIntent発行者とする、これで押した時に発行される
        Log.d(TAG, "remoteview(Widgetボタン)へセット完了、これでボタン押した時にIntent発行");

        //AppWidgetManager mgr = AppWidgetManager.getInstance(this);
        AppWidgetManager manager = AppWidgetManager.getInstance(this);
        int widgetId = intent.getIntExtra(manager.EXTRA_APPWIDGET_ID, AppWidgetManager.INVALID_APPWIDGET_ID);
        Log.d(TAG, "WID ID" + widgetId);
*/
        Log.d(TAG, "ServiceへIntentやって来ました");
        RemoteViews remoteViews = new RemoteViews(getPackageName(), R.layout.main);
        // ボタンが押された時に発行されたインテントの場合は文字を変更する
        if (BUTTON_CLICK_ACTION.equals(intent.getAction())) {
            Log.d(TAG, "BUTTON_CLICK_ACTION");
            int appWidgetId = intent.getIntExtra( AppWidgetManager.EXTRA_APPWIDGET_ID, -1);
            Log.d(TAG, "WidgetID is " + appWidgetId);
            remoteViews.setTextViewText(R.id.text, "Push Button" + appWidgetId);
            sp.play(sound_id, 1.0F, 1.0F, 0, 0, 1.0F);
            // AppWidgetの画面更新
            Log.d(TAG, "appWidgetManager起動");
            ComponentName thisWidget = new ComponentName(this, MyWidget.class);
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
}