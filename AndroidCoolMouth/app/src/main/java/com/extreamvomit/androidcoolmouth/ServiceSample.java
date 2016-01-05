package com.extreamvomit.androidcoolmouth;

/**
 * Created by vesp on 15/12/07.
 */
        import android.app.Service;
        import android.appwidget.AppWidgetManager;
        import android.content.Intent;
        import android.media.AudioManager;
        import android.media.SoundPool;
        import android.os.Handler;
        import android.os.IBinder;
        import android.util.Log;
        import android.widget.Button;
        import android.widget.RemoteViews;
        import android.widget.TextView;
        import com.extreamvomit.androidcoolmouth.WidgetDatas.WidgetIDNum;
        import com.extreamvomit.androidcoolmouth.WidgetEditors.SetInitButton;
        import java.util.Timer;
        import java.util.TimerTask;
        import static com.extreamvomit.androidcoolmouth.TypeDefine.ON_CLICK;

public class ServiceSample extends Service {
    private final String BUTTON_CLICK_ACTION = "BUTTON_CLICK_ACTION";
    private final String TAG = "Test_ServiceLog"; // デバッグ用

    //効果音用
    SoundPool sp;
    int sound_id;

    // タイマー
    /*
    TextView text1;
    Button button1;
    Timer timer = null;
    Handler handle = new Handler();
    */

    @Override
    public void onCreate() {
        // 効果音用
        sp = new SoundPool(10, AudioManager.STREAM_MUSIC, 0);
        sound_id = sp.load(getApplicationContext(), R.raw.se_maoudamashii_system46, 1 ); // デフォルト
    }

    @Override
    public void onStart(Intent intent, int startId) {
        Log.d(TAG, "onStart");
        super.onStart(intent, startId);
        // Remote
        RemoteViews remoteViews;
        // Widget
        //int appWidgetId = -1;

        Log.d(TAG, "ServiceへIntentやって来ました");
        remoteViews = new RemoteViews(getPackageName(), R.layout.main);
        // ボタンが押された時に発行されたインテントの場合は文字を変更する
        if (BUTTON_CLICK_ACTION.equals(intent.getAction())) {
            Log.d(TAG, "BUTTON_CLICK_ACTION");
            // WidgetIDとタイプを取得
            //WidgetIDNum wNum = (WidgetIDNum)intent.getSerializableExtra("WidgetData");
            //Log.d(TAG, "WidgetID is " + wNum.getWidgetID());
            //sp.play(sound_id, 1.0F, 1.0F, 0, 0, 1.0F);

            // Timer起動
            /*
            if (timer != null) {
                timer.cancel();
                ここに画像戻す処理を入れる
            }
            timer = null;
            timer = new Timer();
            timer.schedule(new MyTimer(), 1000); // ミリ秒でセット
            */

            // WidgetButton動作開始
            SetInitButton setInitButton = new SetInitButton();
            setInitButton.ExeFollowingType(getApplicationContext(), intent, remoteViews, ON_CLICK);



            // AppWidgetの画面更新
            // Log.d(TAG, "appWidgetManager起動");
            //ComponentName thisWidget = new ComponentName(this, MyWidget.class);
            /*
            AppWidgetManager manager = AppWidgetManager.getInstance(this);
            manager.updateAppWidget(wNum.getWidgetID(), remoteViews);
            */
           //  Log.d(TAG, "updateAppwidget終了");

            // シリアライズ
            /*
            WidgetIDNum data = new WidgetIDNum();
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
            */
        }
    }

    // Bindは使わないのでNULLで返す
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}