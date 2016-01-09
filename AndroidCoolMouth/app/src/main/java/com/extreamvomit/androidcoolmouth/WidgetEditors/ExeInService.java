package com.extreamvomit.androidcoolmouth.WidgetEditors;

import android.appwidget.AppWidgetManager;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;

import com.extreamvomit.androidcoolmouth.R;
import com.extreamvomit.androidcoolmouth.WidgetDatas.WidgetData;
import com.extreamvomit.androidcoolmouth.WidgetDatas.WidgetIDNum;

import static com.extreamvomit.androidcoolmouth.TypeDefine.NORMAL;
/**
 * Created by vesp on 16/01/09.
 */
public class ExeInService {
    private Context context;
    private SetWidgetTimer wTimer; // Timer

    public ExeInService(Context f_context){
        context = f_context;
        wTimer = new SetWidgetTimer(f_context); // Timer
    }

    // サービスで実行する関数
    public void ExeFollowingType(Intent intent, RemoteViews remoteViews, SetWidgetSound widgetSound, int WidgetState){
        WidgetIDNum wNumID = (WidgetIDNum)intent.getSerializableExtra("WidgetData");
        WidgetData wData = new WidgetData(wNumID); // シングルトンにスべき

        // Timer始動
        wTimer.StartWidgetTimer(remoteViews, wData);

        // 画像変更
        wData.SetDatas(wNumID.getTypeNumber()); // Typeごとに応じて画像取得
        SetWidgetImage.SetImageToRV(remoteViews, wData.GetImageData(), WidgetState); // 画像をリモートビューにセット
        remoteViews.setTextViewText(R.id.text, "Push Button" + wNumID.getWidgetID());

        // Sound
        widgetSound.RingWidgetSound(wData.getWidgetNumID().getTypeNumber());

        // 画像更新
        AppWidgetManager manager = AppWidgetManager.getInstance(context);
        manager.updateAppWidget(wNumID.getWidgetID(), remoteViews);
    }
}
