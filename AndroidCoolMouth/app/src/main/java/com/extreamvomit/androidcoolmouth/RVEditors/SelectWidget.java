package com.extreamvomit.androidcoolmouth.RVEditors;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.CompoundButton;
import android.widget.RemoteViews;
import android.widget.Toast;
import android.widget.ToggleButton;
import android.appwidget.AppWidgetManager;

import com.extreamvomit.androidcoolmouth.R;
import com.extreamvomit.androidcoolmouth.WidgetDatas.WidgetData;
import com.extreamvomit.androidcoolmouth.WidgetDatas.WidgetIDNum;
import com.extreamvomit.androidcoolmouth.WidgetDatas.WidgetImage;
import com.extreamvomit.androidcoolmouth.WidgetService;

import static com.extreamvomit.androidcoolmouth.TypeDefine.NORMAL;
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


import java.util.ArrayList;

/**
 * Created by vesp on 16/01/24.
 */
public class SelectWidget extends Activity implements CompoundButton.OnCheckedChangeListener {
    private Context context;
    private WidgetIDNum wNumID;
    //private ArrayList<WidgetData> wDataList;   // WidgetDataのListを作る
    private String TAG = "SelectWidget";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.select_type);

        // Context取得
        context = getApplicationContext();
        // Intent受け取り
        Intent intent = getIntent();
        if(intent == null){
            //String str = intent.getStringExtra("org.jpn.techbooster.demo.intent.testString");
            Toast.makeText(this, "空のIntent", Toast.LENGTH_LONG).show();
            return;
        }
        // intent情報引き抜き
        wNumID = (WidgetIDNum)intent.getSerializableExtra("WidgetIDNum");
        if(wNumID == null){
            Toast.makeText(this, "wNumIDぬるぽ", Toast.LENGTH_LONG).show();
            return;
        }
        Log.d(TAG, "WidgetID="+wNumID.GetWidgetID()+" WidgetNum="+wNumID.GetTypeNumber());

        // トグルボタンインスタンス生成
        ToggleButton tb1 = (ToggleButton) findViewById(R.id.toggleButton1);
        ToggleButton tb2 = (ToggleButton) findViewById(R.id.toggleButton2);
        ToggleButton tb3 = (ToggleButton) findViewById(R.id.toggleButton3);
        ToggleButton tb4 = (ToggleButton) findViewById(R.id.toggleButton4);
        ToggleButton tb5 = (ToggleButton) findViewById(R.id.toggleButton5);
        ToggleButton tb6 = (ToggleButton) findViewById(R.id.toggleButton6);
        ToggleButton tb7 = (ToggleButton) findViewById(R.id.toggleButton7);
        ToggleButton tb8 = (ToggleButton) findViewById(R.id.toggleButton8);
        ToggleButton tb9 = (ToggleButton) findViewById(R.id.toggleButton9);
        ToggleButton tb10 = (ToggleButton) findViewById(R.id.toggleButton10);
        // ToggleButtonのクリック時に呼び出されるOnCheckedChangeListenerクラスを登録
        tb1.setOnCheckedChangeListener(this);
        tb2.setOnCheckedChangeListener(this);
        tb3.setOnCheckedChangeListener(this);
        tb4.setOnCheckedChangeListener(this);
        tb5.setOnCheckedChangeListener(this);
        tb6.setOnCheckedChangeListener(this);
        tb7.setOnCheckedChangeListener(this);
        tb8.setOnCheckedChangeListener(this);
        tb9.setOnCheckedChangeListener(this);
        tb10.setOnCheckedChangeListener(this);
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        int type;
        switch(buttonView.getId()){
            case R.id.toggleButton1:
                Toast.makeText(this, "clicked togglebutton1: " + isChecked,
                        Toast.LENGTH_SHORT).show();
                type = TYPE_01;
                break;
            case R.id.toggleButton2:
                Toast.makeText(this, "clicked togglebutton2: " + isChecked,
                        Toast.LENGTH_SHORT).show();
                type = TYPE_02;
                break;
            case R.id.toggleButton3:
                Toast.makeText(this, "clicked togglebutton3: " + isChecked,
                        Toast.LENGTH_SHORT).show();
                type = TYPE_03;
                break;
            case R.id.toggleButton4:
                Toast.makeText(this, "clicked togglebutton4: " + isChecked,
                        Toast.LENGTH_SHORT).show();
                type = TYPE_04;
                break;
            case R.id.toggleButton5:
                Toast.makeText(this, "clicked togglebutton5: " + isChecked,
                        Toast.LENGTH_SHORT).show();
                type = TYPE_05;
                break;
            case R.id.toggleButton6:
                Toast.makeText(this, "clicked togglebutton6: " + isChecked,
                        Toast.LENGTH_SHORT).show();
                type = TYPE_06;
                break;
            case R.id.toggleButton7:
                Toast.makeText(this, "clicked togglebutton7: " + isChecked,
                        Toast.LENGTH_SHORT).show();
                type = TYPE_07;
                break;
            case R.id.toggleButton8:
                Toast.makeText(this, "clicked togglebutton8: " + isChecked,
                        Toast.LENGTH_SHORT).show();
                type = TYPE_08;
                break;
            case R.id.toggleButton9:
                Toast.makeText(this, "clicked togglebutton9: " + isChecked,
                        Toast.LENGTH_SHORT).show();
                type = TYPE_09;
                break;
            case R.id.toggleButton10:
                Toast.makeText(this, "clicked togglebutton10: " + isChecked,
                        Toast.LENGTH_SHORT).show();
                type = TYPE_10;
                break;
            default:
                Toast.makeText(this, "clicked togglebutton Error: " + isChecked,
                        Toast.LENGTH_SHORT).show();
                return;
        }

        // RemoteViewの作成
        RemoteViews remoteViews = new RemoteViews(getPackageName(), R.layout.widget_main);

        // 画像取得
        WidgetImage wImage = new WidgetImage(type);
        // wData作成
        WidgetData wData = new WidgetData(wNumID, wImage, type);

        // ボタン画像セット
        RVSetWidgetImage.SetButtonImage(remoteViews, wData, NORMAL);

        // ボタンIntentのセット
        RVSetInitButton RVSetInitButton = new RVSetInitButton(context);
        RVSetInitButton.SetButtonIntent(remoteViews, wData); // これ以降、ボタンを押すとIntentをserviceへと送るようになる

        // RemoteViewへセット
        remoteViews.setTextViewText(R.id.text, "Push Button_Debug" + wData.GetWidgetNumID().GetWidgetID());
        RVSetWidgetImage.SetButtonImage(remoteViews, wData, NORMAL);

        // RemoteView(画面)更新処理
        AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(context);
        appWidgetManager.updateAppWidget(wNumID.GetWidgetID(), remoteViews); // Widgetを更新(RemoteViewを反映)

        // serviceの起動
        Intent service_intent = new Intent(context, WidgetService.class);
        context.startService(service_intent);

        // Activity終了
        Toast.makeText(this, "セット完了", Toast.LENGTH_SHORT).show();
        finish();
    }

    // 検索関数
    /*
    int WidgetNumIDSearch(WidgetIDNum d_wIDNum){
        int result = -1;
        int i=0;
        WidgetIDNum thisClassWNumID;

        // 空なら即効で撤退
        if(wDataList.isEmpty()){
            return result;
        }

        // 検索
        while(i >= wDataList.size()){
            thisClassWNumID = wDataList.get(i).GetWidgetNumID();
            // WidgetIDがいっちするまでやる
            if(thisClassWNumID.GetWidgetID() == d_wIDNum.GetWidgetID()){
                result = i;
                break;
            }
            ++i;
        }
        return result;
    }
    */
}
