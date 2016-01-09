package com.extreamvomit.androidcoolmouth.WidgetEditors;

import android.content.Context;
import android.media.AudioManager;
import android.media.SoundPool;
import android.util.Log;
import android.widget.RemoteViews;

import com.extreamvomit.androidcoolmouth.R;
import com.extreamvomit.androidcoolmouth.WidgetDatas.WidgetImageStr;

import static com.extreamvomit.androidcoolmouth.TypeDefine.NORMAL;
import static com.extreamvomit.androidcoolmouth.TypeDefine.ON_CLICK;

/**
 * Created by vesp on 16/01/05.
 */
public class SetWidgetImage {
    // ImageIDをwidgetのボタンアイコンへと登録する（RemoteViewへ登録）
    public static void SetImageToRV(RemoteViews remoteViews, WidgetImageStr imageStr, int state){
        if(state == NORMAL)
            remoteViews.setImageViewResource(R.id.vgun_imageButton, imageStr.nImageID);
        else if(state == ON_CLICK) {
            remoteViews.setImageViewResource(R.id.vgun_imageButton, imageStr.cImageID);
        }
        else{
            Log.d("SetWidgetImage", "ERROR_STATE");
        }
    }
}
