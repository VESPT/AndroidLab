package com.extreamvomit.androidcoolmouth.WidgetDatas;

import android.util.Log;

import com.extreamvomit.androidcoolmouth.R;

import java.io.Serializable;

import static com.extreamvomit.androidcoolmouth.TypeDefine.TYPE_01;
import static com.extreamvomit.androidcoolmouth.TypeDefine.TYPE_02;
import static com.extreamvomit.androidcoolmouth.TypeDefine.TYPE_03;
import static com.extreamvomit.androidcoolmouth.TypeDefine.TYPE_04;
import static com.extreamvomit.androidcoolmouth.TypeDefine.TYPE_05;
import static com.extreamvomit.androidcoolmouth.TypeDefine.TYPE_06;
import static com.extreamvomit.androidcoolmouth.TypeDefine.TYPE_07;
import static com.extreamvomit.androidcoolmouth.TypeDefine.TYPE_08;
import static com.extreamvomit.androidcoolmouth.TypeDefine.TYPE_09;
import static com.extreamvomit.androidcoolmouth.TypeDefine.TYPE_10;

/**
 * Created by vesp on 16/01/04.
 * WidgetImage構造体
 */
public class WidgetImage implements Serializable {
    private static final long serialVersionUID = 2L; //シリアルバージョンID

    public int nImageID; // 通常時のアイコン画像
    public int cImageID; // クリック時のアイコン画像
    public WidgetImage(int d_type){
        SearchWidgetImage(d_type);
    }

    public void SearchWidgetImage(int d_type){
        switch(d_type){
            case TYPE_01:
                //画像セット
                nImageID = R.drawable.g_msz006;
                cImageID = R.drawable.g_rx93;
                break;
            case TYPE_02:
                nImageID = R.drawable.g_msz010;
                cImageID = R.drawable.g_fa010s;
                break;
            case TYPE_03:
                nImageID = R.drawable.g_rx93;
                cImageID = R.drawable.rx93_max;
                break;
            case TYPE_04:
                nImageID = R.drawable.rx105;
                cImageID = R.drawable.rx104ff;
                break;
            case TYPE_05:
                nImageID = R.drawable.msn03_quess;
                cImageID = R.drawable.msn03_gyunei;
                break;
            case TYPE_06:
                nImageID = R.drawable.msn04;
                cImageID = R.drawable.msn04_2;
                break;
            case TYPE_07:
                nImageID = R.drawable.rgm89;
                cImageID = R.drawable.rgm89s;
                break;
            case TYPE_08:
                nImageID = R.drawable.f91;
                cImageID = R.drawable.g_lm312v04;
                break;
            case TYPE_09:
                nImageID = R.drawable.img400_01;
                cImageID = R.drawable.img400_04;
                break;
            case TYPE_10:
                nImageID = R.drawable.img400_05;
                cImageID = R.drawable.img400_06;
                break;
            default:
                nImageID = -1;
                cImageID = -1;
                Log.d("WidgetImage", "WidgetImageのtypeが変です");
                break;
        }
    }
}
