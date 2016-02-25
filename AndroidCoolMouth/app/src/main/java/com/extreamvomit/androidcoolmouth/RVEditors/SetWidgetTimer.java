package com.extreamvomit.androidcoolmouth.RVEditors;

import android.appwidget.AppWidgetManager;
import android.content.Context;
import android.os.Handler;
import android.util.Log;
import android.widget.RemoteViews;

import com.extreamvomit.androidcoolmouth.WidgetDatas.WidgetData;

import java.util.Timer;
import java.util.TimerTask;

import static com.extreamvomit.androidcoolmouth.TypeDefine.NORMAL;

/**
 * Created by vesp on 16/01/05.
 */
public class SetWidgetTimer{
    private final String TAG = "TimerWidget";
    static Context context;
    static RemoteViews tRemoteViews;
    static WidgetData tWidgetData;
    static Timer timer = null;

    public SetWidgetTimer(Context d_context){
        if(d_context == null){
            Log.d(TAG, "Error:Context == null");
        }
        context = d_context; // runするときにつかう
    }

    // Timer起動
    public void StartWidgetTimer(RemoteViews remoteViews, WidgetData wData){
        if(remoteViews == null){
            Log.d(TAG, "Error:remoteview == null");
            return;
        }
        if(wData == null){
            Log.d(TAG, "Error:wData == null");
            return;
        }

        tRemoteViews = remoteViews;
        tWidgetData = wData;

        if (timer != null) {
            timer.cancel();
            //RVSetWidgetImage.SetButtonImage(remoteViews, wData, NORMAL); // 画像をリモートビューにセット
        }
        timer = null;
        timer = new Timer();
        timer.schedule(new WidgetTimer(), 1000); // ミリ秒でセット
    }

    private class WidgetTimer extends TimerTask {
        Handler handle = new Handler();
        @Override
        public void run() { // ここのRunはTimerスレッドが行うRun
            Log.d(TAG, "TimerRun");
            //if(appWidgetId == -1) return; // appWidgetに正しい値が入っていなかったら実行しない
            handle.post(new Runnable() {
                @Override
                public void run() { // ここのRunはUIスレッドが行うRun
                    Log.d(TAG, "TimerRunDo");
                    //remoteViews.setTextViewText(R.id.text, "1秒経過");
                    // 画像切り替え
                    RVSetWidgetImage.SetButtonImage(tRemoteViews, tWidgetData, NORMAL); // 画像をリモートビューにセット
                    AppWidgetManager manager = AppWidgetManager.getInstance(context);
                    manager.updateAppWidget(tWidgetData.GetWidgetNumID().GetWidgetID(), tRemoteViews);
                }
            });
        }
    }

}
