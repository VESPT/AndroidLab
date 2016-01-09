package com.extreamvomit.androidcoolmouth;

/**
 * Created by vesp on 15/12/07.
 */
        import android.app.Service;
        import android.appwidget.AppWidgetManager;
        import android.content.Context;
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
        import com.extreamvomit.androidcoolmouth.WidgetEditors.ExeInService;
        import com.extreamvomit.androidcoolmouth.WidgetEditors.SetInitButton;
        import com.extreamvomit.androidcoolmouth.WidgetEditors.SetWidgetSound;
        import com.extreamvomit.androidcoolmouth.WidgetEditors.SetWidgetTimer;

        import java.util.Timer;
        import java.util.TimerTask;
        import static com.extreamvomit.androidcoolmouth.TypeDefine.ON_CLICK;

public class WidgetService extends Service {
    private final String BUTTON_CLICK_ACTION = "BUTTON_CLICK_ACTION";
    private final String TAG = "Test_ServiceLog"; // デバッグ用
    Context my_context;
    private SetWidgetSound widgetSound; //効果音用
    private ExeInService exeInService;  //サービス内で画像切り替えと音楽再生を実行するクラス

    @Override
    public void onCreate() {
        Log.d(TAG, "ServiceOnCreate_testes");
        my_context = getApplicationContext();
        //my_context = getBaseContext();
        widgetSound = new SetWidgetSound(my_context); // Soundの初期化
        exeInService = new ExeInService(my_context);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG, "onStart");
        super.onStart(intent, startId);
        Log.d(TAG, "ServiceへIntentやって来ました");
        RemoteViews remoteViews = new RemoteViews(getPackageName(), R.layout.main);
        Log.d(TAG, "remoteview作成");

        // ボタンが押された時に発行されたインテントの場合は文字を変更する
        if (BUTTON_CLICK_ACTION.equals(intent.getAction())) {//BUTTON_CLICK_ACTION.equals(intent.getAction())
            Log.d(TAG, "BUTTON_CLICK_ACTION");

            // WidgetButton動作開始
            exeInService.ExeFollowingType(intent, remoteViews, widgetSound, ON_CLICK);

            // シリアライズ
             //   WidgetIDNum data = new WidgetIDNum();
               // data.setString("TEST");
            //  data.setNumber(appWidgetId);
             //   try {
               //     FileOutputStream fos = openFileOutput("WidgetSaveData.dat", MODE_PRIVATE);
               //     ObjectOutputStream oos = new ObjectOutputStream(fos);
               //     oos.writeObject(data);
               //     oos.close();
              //  } catch (Exception e) {
              //      Log.d(TAG, "Error");
             //   }
        }
        return START_NOT_STICKY; // 強制終了した場合は勝手にサービスが起動されることを避ける
    }

    // Bindは使わないのでNULLで返す
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}