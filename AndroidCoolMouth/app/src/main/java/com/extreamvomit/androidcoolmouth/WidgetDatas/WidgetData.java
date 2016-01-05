package com.extreamvomit.androidcoolmouth.WidgetDatas;

/**
 * Created by vesp on 16/01/03.
 * 個々のWidgetのDataを扱うクラス
 * Intentを受け取ったあと、サービスのところで扱うクラス
 */

import com.extreamvomit.androidcoolmouth.R;

import static com.extreamvomit.androidcoolmouth.TypeDefine.TYPE_01;
import static com.extreamvomit.androidcoolmouth.TypeDefine.TYPE_02;

public class WidgetData {
    private WidgetIDNum wNumID;  // WidgetID
    private WidgetImageStr imageStr;

    // コンストラクタ WidgetIDとWidgetタイプを登録
    public WidgetData(int iWidgetId, int iNumber) {
        wNumID.setWidgetID(iWidgetId);
        wNumID.setTypeNumber(iNumber);
    }
    public WidgetData(WidgetIDNum iWidgetId) {
        setWidgetNumID(iWidgetId);
    }

    // WidgetIDとタイプのゲッターとセッター
    public WidgetIDNum getWidgetNumID() {
        return wNumID;
    }
    public void setWidgetNumID(WidgetIDNum iWidgetId) {
        this.wNumID = iWidgetId;
    }

    // WidgetアイコンIDのゲッターとセッター
    // ImageID変数に値を格納する
    public void SetImageID(int type){
        switch(type){
            case TYPE_01:
                imageStr.nImageID = R.drawable.g_msz006;
                imageStr.cImageID = R.drawable.g_rx93;
                break;
            case TYPE_02:
                imageStr.nImageID = R.drawable.g_msz010;
                imageStr.cImageID = R.drawable.g_fa010s;
                break;
            default:
                break;
        }
    }
    public WidgetImageStr GetImageData(){
        return imageStr;
    }
}
