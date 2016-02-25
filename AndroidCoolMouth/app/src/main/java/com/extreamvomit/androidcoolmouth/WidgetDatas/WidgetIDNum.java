package com.extreamvomit.androidcoolmouth.WidgetDatas;

import java.io.Serializable;

/**
 * Created by vesp on 15/12/23.
 * Widgetの番号とIDを格納しているクラス
 * Intentに使うため、シリアライズ化している
 */
public class WidgetIDNum implements Serializable {
    private static final long serialVersionUID = 3L; //シリアルバージョンID

    private int appWidgetId = -1;
    private int type_number;
    private int init_flag;

    // コンストラクタ
    public WidgetIDNum(int widgetId, int number){
        SetWidgetID(widgetId);
        SetTypeNumber(number);
        init_flag=1;
    }

    // ゲッターセッター
    public int GetWidgetID() {
        return appWidgetId;
    }
    public void SetWidgetID(int widgetId) {
        appWidgetId = widgetId;
    }
    public int GetTypeNumber() {
        return type_number;
    }
    public void SetTypeNumber(int number) {
        type_number = number;
    }
    public void RiseInitFlag(){init_flag=1;}
}
