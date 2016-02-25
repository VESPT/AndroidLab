package com.extreamvomit.androidcoolmouth.RVEditors;

import android.util.Log;
import android.widget.RemoteViews;

import com.extreamvomit.androidcoolmouth.R;
import com.extreamvomit.androidcoolmouth.WidgetDatas.WidgetData;
import com.extreamvomit.androidcoolmouth.WidgetDatas.WidgetImage;

import static com.extreamvomit.androidcoolmouth.TypeDefine.NORMAL;
import static com.extreamvomit.androidcoolmouth.TypeDefine.ON_CLICK;

/**
 * Created by vesp on 16/01/05.
 * 画像をリモートビューへセットするクラス
 */
public class RVSetWidgetImage {
    public static void SetButtonImage(RemoteViews remoteViews, WidgetData wData, int state){
        // Nullチェック
        if(remoteViews == null){
            Log.d("RVSetWidgetImage", "RemoteView is nullpo");
        }
        else if(wData == null){
            Log.d("RVSetWidgetImage", "wData == nullpo");
        }

        // 画像セット
        WidgetImage widgetImage = wData.GetImage();
        if(state == NORMAL) {
            Log.d("RVSetWidgetImage", "set_NORMAL_IMAGE");
            remoteViews.setImageViewResource(R.id.vgun_imageButton, widgetImage.nImageID);
        }
        else if(state == ON_CLICK) {
            Log.d("RVSetWidgetImage", "set_ON_CLICK_IMAGE");
            remoteViews.setImageViewResource(R.id.vgun_imageButton, widgetImage.cImageID);
        }
        else{
            Log.d("RVSetWidgetImage", "ERROR_STATE");
        }
        remoteViews.setTextViewText(R.id.text, "Push test" + wData.GetWidgetNumID().GetWidgetID());
    }
}
