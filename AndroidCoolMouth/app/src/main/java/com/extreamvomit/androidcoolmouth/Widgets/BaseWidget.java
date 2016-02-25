package com.extreamvomit.androidcoolmouth.Widgets;

/**
 * Created by vesp on 15/12/24.
 */
import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.RemoteViews;

import com.extreamvomit.androidcoolmouth.R;
import com.extreamvomit.androidcoolmouth.RVEditors.SelectWidget;
import com.extreamvomit.androidcoolmouth.WidgetDatas.WidgetIDNum;

import java.util.ArrayList;

public abstract class BaseWidget extends AppWidgetProvider {
    private final String TAG = "BaseWidget";
    private ArrayList<Integer> widgetIds;
    protected abstract WidgetIDNum InitType(int iType);
    private WidgetIDNum wNum;

    @Override
    public void onEnabled(Context context) {
        Log.d(TAG, "onEnabled");
        super.onEnabled(context);

        widgetIds = new ArrayList<Integer>();
    }

    // ウィジェット登録した際に呼ばれる
    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager,
                         int[] appWidgetIds) {
        Log.d(TAG, "onUpdate");
        super.onUpdate(context, appWidgetManager, appWidgetIds);

        // Widget更新
        for (int appWidgetId : appWidgetIds) {
            Log.d(TAG, "appWidgetId:" + appWidgetId);
            wNum = this.InitType(appWidgetId);

            //RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.widget_main);
            //RVSetInitButton setInitButton = new RVSetInitButton(context);

            // 等しいのがあるか調べる
            //if(widgetIds.contains(appWidgetId)){ // あれば通常処理
                // ボタンIntentの設定
                //WidgetIDNum wNum = this.InitType(appWidgetId); // wNumの値をセット（抽象クラスで処理内容が変わる） インスタンスは内部で生成
                //setInitButton.SetButtonIntent(remoteViews, wNum); // これ以降、ボタンを押すとIntentをserviceへと送るようになる
                //appWidgetManager.updateAppWidget(appWidgetId, remoteViews); // Widgetを更新(RemoteViewを反映)
                // Delete処理
                // 今は入れてない
            //}
            //else{ // なければ初期化処理
            //}
        }
        // SelectWidgetアクティビティの指定
        Intent intent = new Intent(context, SelectWidget.class);
        // WidgetIDとタイプをIntentへ登録
        intent.putExtra("WidgetIDNum", wNum);
        // PendingIntentの取得
        PendingIntent pendingIntent = PendingIntent.getActivity(context, wNum.GetWidgetID(), intent, 0);
        RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.widget_main);
        // インテントによるアクティビティ起動
        remoteViews.setOnClickPendingIntent(R.id.vgun_imageButton, pendingIntent);
        appWidgetManager.updateAppWidget(appWidgetIds, remoteViews);

        // サービスの起動
        /*
        Intent service_intent = new Intent(context, WidgetService.class);
        context.startService(service_intent);
        */
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
    }
}
