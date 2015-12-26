package com.extreamvomit.androidcoolmouth;

/**
 * Created by vesp on 15/12/24.
 */
import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.ComponentName;
import android.content.Intent;
import android.util.Log;
import android.widget.RemoteViews;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class BaseWidget extends AppWidgetProvider {
    private final String TAG = "BaseWidget";


    @Override
    public void onEnabled(Context context) {
        Log.d(TAG, "onEnabled");
        super.onEnabled(context);

    }

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager,
                         int[] appWidgetIds) {
        Log.d(TAG, "onUpdate");
        super.onUpdate(context, appWidgetManager, appWidgetIds);

        // デシリアライズ
        try {
            FileInputStream fis = context.openFileInput("WidgetSaveData.dat"); // contextが必要
            ObjectInputStream ois = new ObjectInputStream(fis);
            WidgetNum data = (WidgetNum) ois.readObject();
            ois.close();

            Log.d(TAG, data.getString());
            Log.d(TAG, ""+data.getNumber());
        } catch (Exception e) {
            Log.d(TAG, "Error");
        }

        for (int appWidgetId : appWidgetIds) {
            Log.d(TAG, "appWidgetId:" + appWidgetId);
            // ボタンが押された時に発行されるインテントを準備する
            Intent buttonIntent = new Intent();
            buttonIntent.setAction("BUTTON_CLICK_ACTION");
            buttonIntent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, appWidgetId);
            PendingIntent pendingIntent = PendingIntent.getService(context, appWidgetId, buttonIntent, 0); //Serviceへインテントを投げる設定
            Log.d(TAG, "pendingIntent準備完了");
            RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.main);
            remoteViews.setOnClickPendingIntent(R.id.button, pendingIntent); // WidgetButtonをIntent発行者とする、これで押した時に発行される
            Log.d(TAG, "remoteview(Widgetボタン)へセット完了、これでボタン押した時にIntent発行");
            remoteViews.setTextViewText(R.id.text, "Push test" + appWidgetId);

            ComponentName thisWidget = new ComponentName(context, MyWidget.class);
            //AppWidgetManager manager = AppWidgetManager.getInstance(context);
            appWidgetManager.updateAppWidget(appWidgetId, remoteViews);
        }

        // サービスの起動
        Intent intent = new Intent(context, ServiceSample.class);
        context.startService(intent);
    }

    @Override
    public void onDeleted(Context context, int[] appWidgetIds) {
        Log.d(TAG, "onDeleted");
        super.onDeleted(context, appWidgetIds);
        Intent intent = new Intent(context, ServiceSample.class);
        context.stopService(intent);
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
