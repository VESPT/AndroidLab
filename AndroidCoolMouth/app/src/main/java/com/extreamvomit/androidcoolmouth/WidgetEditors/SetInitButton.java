package com.extreamvomit.androidcoolmouth.WidgetEditors;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.SoundPool;
import android.util.Log;
import android.widget.RemoteViews;

import com.extreamvomit.androidcoolmouth.R;
import com.extreamvomit.androidcoolmouth.WidgetDatas.WidgetData;
import com.extreamvomit.androidcoolmouth.WidgetDatas.WidgetIDNum;
import com.extreamvomit.androidcoolmouth.WidgetDatas.WidgetImageStr;

import static com.extreamvomit.androidcoolmouth.TypeDefine.NORMAL;
import static com.extreamvomit.androidcoolmouth.TypeDefine.ON_CLICK;
/**
 * Created by vesp on 16/01/04.
 * IntentやRemoteViewへの登録を司るクラス
 * Widgetの初期化でもサービスで画像を変更するのにも用いる
 */
public class SetInitButton {
    private final String TAG = "SetType";
    private SetWidgetTimer wTimer = new SetWidgetTimer(); // Timer

    // ボタンクリック時に発行するIntentの設定 wTypeDataクラス型がIntentに付加されるように設定
    public void SetButtonIntent(Context context, RemoteViews remoteViews, WidgetIDNum wNumID){
        // widget情報を含み、シリアライズされたintent付加用クラスを用意
        // ボタンが発行するインテントを準備する
        Intent buttonIntent = new Intent();
        buttonIntent.putExtra("WidgetData", wNumID); // WidgetIDとタイプをIntentへ登録（今は使っていない）
        buttonIntent.setAction("BUTTON_CLICK_ACTION");
        PendingIntent pendingIntent = PendingIntent.getService(context, wNumID.getWidgetID(), buttonIntent, 0); //Serviceへインテントを投げる設定
        remoteViews.setOnClickPendingIntent(R.id.vgun_imageButton, pendingIntent); // WidgetButtonをIntent発行者とする、これで押した時に発行される

        // 初期画像セット
        WidgetData wData = new WidgetData(wNumID);
        wData.SetImageID(wNumID.getTypeNumber()); // Typeごとに応じて画像取得
        SetWidgetImage.SetImageToRV(context, remoteViews, wData.GetImageData(), NORMAL); // 画像セット ココらへんポインタじゃなきゃダメかも
        remoteViews.setTextViewText(R.id.text, "Push test" + wNumID.getWidgetID());
    }



    // サービスで実行する関数
    public void ExeFollowingType(Context context, Intent intent, RemoteViews remoteViews, int WidgetState){
        WidgetIDNum wNumID = (WidgetIDNum)intent.getSerializableExtra("WidgetData");
        WidgetData wData = new WidgetData(wNumID);

        wData.SetImageID(wNumID.getTypeNumber()); // Typeごとに応じて画像取得
        SetWidgetImage.SetImageToRV(context, remoteViews, wData.GetImageData(), WidgetState); // 画像をリモートビューにセット
        remoteViews.setTextViewText(R.id.text, "Push Button" + wNumID.getWidgetID());

        // Timer始動
        wTimer.StartWidgetTimer(context, remoteViews, wData);

        // 画像更新
        AppWidgetManager manager = AppWidgetManager.getInstance(context);
        manager.updateAppWidget(wNumID.getWidgetID(), remoteViews);
    }


}
