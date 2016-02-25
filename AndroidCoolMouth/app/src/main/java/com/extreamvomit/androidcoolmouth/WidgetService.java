package com.extreamvomit.androidcoolmouth;

/**
 * Created by vesp on 15/12/07.
 */
        import android.app.Service;
        import android.content.Context;
        import android.content.Intent;
        import android.os.IBinder;
        import android.util.Log;
        import android.widget.RemoteViews;

        import static com.extreamvomit.androidcoolmouth.TypeDefine.ON_CLICK;

        import com.extreamvomit.androidcoolmouth.RVEditors.ExeInService;
        import com.extreamvomit.androidcoolmouth.RVEditors.SetWidgetSound;

public class WidgetService extends Service {
    private final String BUTTON_CLICK_ACTION = "BUTTON_CLICK_ACTION";
    private final String TAG = "Test_ServiceLog"; // デバッグ用
    Context my_context;
    private SetWidgetSound widgetSound; //効果音用
    private ExeInService exeInService;  //サービス内で画像切り替えと音楽再生を実行するクラス
    private int service_debug_int=0;

    @Override
    public void onCreate() {
        Log.d(TAG, "ServiceOnCreate_testes");
        my_context = getApplicationContext();
        widgetSound = new SetWidgetSound(my_context); // Soundの初期化
        exeInService = new ExeInService(my_context);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG, "onStart");
        super.onStartCommand(intent, flags, startId);
        RemoteViews remoteViews = new RemoteViews(getPackageName(), R.layout.widget_main);

        // ボタンが押された時に発行されたインテントの場合は文字を変更する
        if (BUTTON_CLICK_ACTION.equals(intent.getAction())) {//BUTTON_CLICK_ACTION.equals(intent.getAction())
            Log.d(TAG, "BUTTON_CLICK_ACTION");

            // WidgetButton動作開始
            exeInService.ExeFollowingType(intent, remoteViews, ON_CLICK, widgetSound);
            /*
            // Debug
            debug_int++;
            service_debug_int++;
            Log.d(TAG, "debug_int="+debug_int+" \n service_debug_int="+service_debug_int);
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
             */
        }
        else{
            Log.d(TAG,"BUTTON_ACCTION以外のインテント受信");
        }
        Log.d(TAG,"Flag="+flags);
        Log.d(TAG, "startID=" + startId);
        return START_STICKY; // 強制終了した場合は勝手にサービスが起動される
    }

    @Override
    public void onDestroy(){
        Log.d(TAG,"onDestroy");
        // ここにF91の画像に差し替えるものを用意←appID取得が面倒だから無理
    }
    // Bindは使わないのでNULLで返す
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}