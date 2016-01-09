package com.extreamvomit.androidcoolmouth.Widgets;

/**
 * Created by vesp on 15/12/24.
 */
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.SoundPool;
import android.util.Log;
import android.widget.RemoteViews;

import com.extreamvomit.androidcoolmouth.R;
import com.extreamvomit.androidcoolmouth.WidgetService;
import com.extreamvomit.androidcoolmouth.WidgetDatas.WidgetIDNum;
import com.extreamvomit.androidcoolmouth.WidgetEditors.SetInitButton;

public abstract class BaseWidget extends AppWidgetProvider {
    private final String TAG = "BaseWidget";
    protected abstract WidgetIDNum InitType(int iType);

    @Override
    public void onEnabled(Context context) {
        Log.d(TAG, "onEnabled");
        super.onEnabled(context);
    }

    // ウィジェット登録した際に呼ばれる
    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager,
                         int[] appWidgetIds) {
        Log.d(TAG, "onUpdate");
        super.onUpdate(context, appWidgetManager, appWidgetIds);
        // デシリアライズ
        /*
        try {
            FileInputStream fis = context.openFileInput("WidgetSaveData.dat"); // contextが必要
            ObjectInputStream ois = new ObjectInputStream(fis);
            widgetID = (WidgetIDNum) ois.readObject();
            ois.close();
        } catch (Exception e) {
            Log.d(TAG, "Error");
            widgetID = null;
        }
        */

        // Widget更新
        for (int appWidgetId : appWidgetIds) {
            Log.d(TAG, "appWidgetId:" + appWidgetId);
            RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.main);
            SetInitButton setInitButton = new SetInitButton(context);
            // ボタンIntentの設定
            WidgetIDNum wNum = this.InitType(appWidgetId); // wNumの値をセット（抽象クラスで処理内容が変わる） インスタンスは内部で生成
            setInitButton.SetButtonIntent(remoteViews, wNum); // これ以降、ボタンを押すとIntentをserviceへと送るようになる
            appWidgetManager.updateAppWidget(appWidgetId, remoteViews); // Widgetを更新(RemoteViewを反映)

            // Delete処理
            // 今は入れてない
        }

        // サービスの起動
        Intent intent = new Intent(context, WidgetService.class);
        context.startService(intent);
    }

    @Override
    public void onDeleted(Context context, int[] appWidgetIds) {
        Log.d(TAG, "onDeleted");
        super.onDeleted(context, appWidgetIds);
        //Intent intent = new Intent(context, WidgetService.class); // これ入れるとバグる
        //context.stopService(intent);
    }

    @Override
    public void onDisabled(Context context) {
        Log.d(TAG, "onDisabled");
        super.onDisabled(context);
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d(TAG, "onReceive");
        super.onReceive(context, intent);
    }
}
