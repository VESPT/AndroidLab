package com.extreamvomit.androidcoolmouth.Widgets;

import android.util.Log;

import com.extreamvomit.androidcoolmouth.WidgetDatas.WidgetIDNum;
import static com.extreamvomit.androidcoolmouth.TypeDefine.TYPE_02;

/**
 * Created by vesp on 15/12/27.
 */
public class WV_house2 extends BaseWidget {
    private final String TAG = "WV_house2";

    protected WidgetIDNum InitType(int appWidgetId){
        WidgetIDNum tmp_wNum = new WidgetIDNum(appWidgetId, TYPE_02);
        Log.d(TAG, "WV_house2作成");
        return tmp_wNum;
    }
}


