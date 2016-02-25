package com.extreamvomit.androidcoolmouth.RVEditors;

import android.appwidget.AppWidgetManager;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;

import com.extreamvomit.androidcoolmouth.R;
import com.extreamvomit.androidcoolmouth.WidgetDatas.WidgetData;
import com.extreamvomit.androidcoolmouth.WidgetDatas.WidgetIDNum;

import java.util.ArrayList;

import static com.extreamvomit.androidcoolmouth.TypeDefine.NORMAL;

/**
 * Created by vesp on 16/01/09.
 */
public class ExeInService {
    private Context context;
    private SetWidgetTimer wTimer;              // Timer
    private ArrayList<WidgetData> wDataList;   // WidgetDataのListを作る
    private String TAG = "ExeInService";

    public ExeInService(Context f_context){
        context = f_context;
        wTimer = new SetWidgetTimer(f_context); // Timer
        wDataList = new ArrayList<WidgetData>();
    }

    // サービスで実行する関数
    public void ExeFollowingType(Intent intent, RemoteViews remoteViews, int WidgetState, SetWidgetSound sWSound){
        // intent情報引き抜き
        WidgetData wData = (WidgetData)intent.getSerializableExtra("WidgetData");

        // RemoteViewへセット
        RVSetWidgetImage.SetButtonImage(remoteViews, wData, WidgetState);

        // Timer始動
        wTimer.StartWidgetTimer(remoteViews, wData);

        // Sound
        sWSound.RingWidgetSound(wData.GetWidgetType());

        // 画像更新
        remoteViews.setTextViewText(R.id.text, "Push Button" + wData.GetWidgetNumID().GetWidgetID());
        AppWidgetManager manager = AppWidgetManager.getInstance(context);
        manager.updateAppWidget(wData.GetWidgetNumID().GetWidgetID(), remoteViews);

        /*
        // 新規か既にあるものか判定
        indexNum = this.WidgetNumIDSearch(wNumID);
        // 見つからなかった場合、新規作成
        if (indexNum == -1){
            // 新規作成
            // ここでインテント渡す処理？
            //

            // wDataの中身を確認する
            wData = new WidgetData(wNumID);
            wData.SetDatas(wNumID.GetTypeNumber()); // Typeごとに応じて画像取得
            wDataList.add(wData); // リストに追加
            //indexNum = wDataList.size()-1;
            // シリアライズデータを新規登録する処理をここに

            intent.setClassName("com.extreamvomit.androidcoolmouth", "com.extreamvomit.androidcoolmouth.WidgetEditor.SelectWidget");
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            int requestCode = 1000;
            //context.startActivi;
            return ;
        }
        // 既存のモノの場合
        else if(0 <= indexNum && indexNum < wDataList.size()){
            wData = wDataList.get(indexNum);
            // Timer始動
            wTimer.StartWidgetTimer(remoteViews, wData);
            // Sound
            widgetSound.RingWidgetSound(wData.GetWidgetNumID().GetTypeNumber());
        }
        // そうでない人
        else{
            Log.d(TAG, "wDataIndexError");
            return ;
        }

        // 画像更新
        updateImage(wData, remoteViews, WidgetState);

        */
    }

    // 画像更新処理
    void updateImage(WidgetData wData, RemoteViews remoteViews, int WidgetState){
        // 画像変更

        //wData.SetDatas(wNumID.GetTypeNumber()); // Typeごとに応じて画像取得
        //RVSetWidgetImage.SetImageToRV(remoteViews, wData.GetImage(), WidgetState); // 画像をリモートビューにセット
        remoteViews.setTextViewText(R.id.text, "Push Button" + wData.GetWidgetNumID().GetWidgetID());
        // 画像更新
        AppWidgetManager manager = AppWidgetManager.getInstance(context);
        manager.updateAppWidget(wData.GetWidgetNumID().GetWidgetID(), remoteViews);

    }

}
