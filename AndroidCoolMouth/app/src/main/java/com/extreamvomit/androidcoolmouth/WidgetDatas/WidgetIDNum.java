package com.extreamvomit.androidcoolmouth.WidgetDatas;

import java.io.Serializable;

/**
 * Created by vesp on 15/12/23.
 * Widgetの番号とIDを格納しているクラス
 * Intentに使うため、シリアライズ化している
 * Widgetの初期化で用いる
 */
public class WidgetIDNum implements Serializable {
    private static final long serialVersionUID = 1L; //シリアルバージョンID

    private int appWidgetId = -1;
    private int type_number;

    // コンストラクタ
    public WidgetIDNum(int widgetId, int number){
        setWidgetID(widgetId);
        setTypeNumber(number);
    }
    // ゲッターセッター
    public int getWidgetID() {
        return appWidgetId;
    }
    public void setWidgetID(int widgetId) {
        appWidgetId = widgetId;
    }
    public int getTypeNumber() {
        return type_number;
    }
    public void setTypeNumber(int number) {
        type_number = number;
    }
}
