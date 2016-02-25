package com.extreamvomit.androidcoolmouth.Widgets;

import android.util.Log;

import com.extreamvomit.androidcoolmouth.WidgetDatas.WidgetIDNum;
import static com.extreamvomit.androidcoolmouth.WidgetTypeNum.WTNUM1;

/**
 * Created by vesp on 15/12/27.
 */
public class A_Voistamp1 extends BaseWidget {
    private final String TAG = "A_Voistamp1";

    protected WidgetIDNum InitType(int appWidgetId){
        WidgetIDNum tmp_wNum = new WidgetIDNum(appWidgetId, WTNUM1);
        Log.d(TAG, "WV_house1作成");
        return tmp_wNum;
    }
}


