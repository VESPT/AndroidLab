package com.extreamvomit.androidcoolmouth.Widgets;

import android.util.Log;

import com.extreamvomit.androidcoolmouth.WidgetDatas.WidgetIDNum;
import static com.extreamvomit.androidcoolmouth.WidgetTypeNum.WTNUM2;

/**
 * Created by vesp on 15/12/27.
 */
public class A_Voistamp2 extends BaseWidget {
    private final String TAG = "A_Voistamp2";

    protected WidgetIDNum InitType(int appWidgetId){
        WidgetIDNum tmp_wNum = new WidgetIDNum(appWidgetId, WTNUM2);
        Log.d(TAG, "WV_house2作成");
        return tmp_wNum;
    }
}


