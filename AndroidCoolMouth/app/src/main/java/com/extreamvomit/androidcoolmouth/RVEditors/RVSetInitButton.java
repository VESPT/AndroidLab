package com.extreamvomit.androidcoolmouth.RVEditors;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.RemoteViews;

import com.extreamvomit.androidcoolmouth.R;
import com.extreamvomit.androidcoolmouth.WidgetDatas.WidgetData;
import com.extreamvomit.androidcoolmouth.WidgetDatas.WidgetIDNum;

/**
 * Created by vesp on 16/01/04.
 * IntentやRemoteViewへの登録を司るクラス
 * Widgetの初期化で用いる
 */
public class RVSetInitButton {
    private final String TAG = "RVSetInitButton";
    private Context context;

    public RVSetInitButton(Context d_context){
        if(d_context == null){
            Log.d(TAG, "Error:Context == null");
        }
        context = d_context;
    }
    // ボタンクリック時に発行するIntentの設定 wTypeDataクラス型がIntentに付加されるように設定
    public void SetButtonIntent(RemoteViews remoteViews, WidgetData widgetData) {
        if(remoteViews == null){
            Log.d(TAG, "RemoteView is nullpo");
            return;
        }
        if(widgetData == null){
            Log.d(TAG, "wData == nullpo");
            return;
        }

        // widget情報を含み、シリアライズされたintent付加用クラスを用意
        // ボタンが発行するインテントを準備する
        Intent buttonIntent = new Intent();
        buttonIntent.putExtra("WidgetData", widgetData); // WidgetIDとタイプをIntentへ登録（今は使っていない）
        buttonIntent.setAction("BUTTON_CLICK_ACTION");
        // ボタンへintentを登録する
        int wID = widgetData.GetWidgetNumID().GetWidgetID();
        PendingIntent pendingIntent = PendingIntent.getService(context, wID, buttonIntent, 0); //Serviceへインテントを投げる設定
        remoteViews.setOnClickPendingIntent(R.id.vgun_imageButton, pendingIntent); // WidgetButtonをIntent発行者とする、これで押した時に発行される
    }
}
