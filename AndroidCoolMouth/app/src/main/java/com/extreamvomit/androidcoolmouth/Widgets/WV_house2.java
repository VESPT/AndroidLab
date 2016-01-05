package com.extreamvomit.androidcoolmouth.Widgets;

import com.extreamvomit.androidcoolmouth.WidgetDatas.WidgetIDNum;

import static com.extreamvomit.androidcoolmouth.TypeDefine.TYPE_02;

/**
 * Created by vesp on 15/12/27.
 */
public class WV_house2 extends BaseWidget {
    protected WidgetIDNum InitType(int appWidgetId){
        WidgetIDNum tmp_wNum = new WidgetIDNum(appWidgetId, TYPE_02);
        return tmp_wNum;
    }
}


