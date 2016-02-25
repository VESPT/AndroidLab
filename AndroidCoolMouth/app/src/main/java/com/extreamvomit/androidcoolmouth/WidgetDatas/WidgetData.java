package com.extreamvomit.androidcoolmouth.WidgetDatas;

import android.util.Log;

import java.io.Serializable;

/**
 * Created by vesp on 16/01/03.
 * 個々のWidgetのDataを扱うクラス
 * Intentを受け取ったあと、サービスのところで扱うクラス
 */


public class WidgetData implements Serializable {
    private static final long serialVersionUID = 4L; //シリアルバージョンID

    private WidgetIDNum wNumID;  // WidgetID
    private WidgetImage wImage;
    private String TAG = "WidgetData";
    private int type = -1;

    public WidgetData(WidgetIDNum dWidgetId, WidgetImage dWidgetImage) {
        SetWidgetNumID(dWidgetId);
        SetWidgetImage(dWidgetImage);
    }
    public WidgetData(WidgetIDNum dWidgetId, WidgetImage dWidgetImage, int d_type) {
        SetWidgetNumID(dWidgetId);
        SetWidgetImage(dWidgetImage);
        SetWidgetType(d_type);
    }

    // WidgetIDとタイプのゲッターとセッター
    public WidgetIDNum GetWidgetNumID() {
        return this.wNumID;
    }
    public boolean SetWidgetNumID(WidgetIDNum dWidgetId) {
        boolean result = true;
        if(dWidgetId == null){
            Log.d(TAG, "WidgetDataのWidgetId == null");
            result = false;
        }
        this.wNumID = dWidgetId;
        return result;
    }
    public WidgetImage GetImage(){
        return wImage;
    }
    public boolean SetWidgetImage(WidgetImage dWidgetImage){
        boolean result = true;
        if(dWidgetImage == null){
            Log.d(TAG, "WidgetDataのWidgetImage == null");
            result = false;
        }
        wImage = dWidgetImage;
        return result;
    }
    public int GetWidgetType(){
        return type;
    }
    public void SetWidgetType(int d_type){
        type = d_type;
    }
}
