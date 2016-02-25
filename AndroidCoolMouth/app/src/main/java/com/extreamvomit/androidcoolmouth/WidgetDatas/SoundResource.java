package com.extreamvomit.androidcoolmouth.WidgetDatas;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.extreamvomit.androidcoolmouth.R;

import java.util.ArrayList;

/**
 * Created by vesp on 16/01/09.
 */
public class SoundResource {
    private ArrayList<Integer> sRArray = new ArrayList<Integer>();
    private Context context;

    public SoundResource(Context d_context){
        context =  d_context;
        SetResource();
    }

    private void SetResource() {
        sRArray.add(R.raw.gundam01);
        sRArray.add(R.raw.gundam02);
        sRArray.add(R.raw.gundam03);
        sRArray.add(R.raw.gundam04);
        sRArray.add(R.raw.gundam05);
        sRArray.add(R.raw.zaku01);
        sRArray.add(R.raw.zaku02);
        sRArray.add(R.raw.se_maoudamashii_system46);
        sRArray.add(R.raw.takara1);
        sRArray.add(R.raw.takara2);
    }

    public int getSoundResource(int i){
        if(sRArray.isEmpty()){
            Toast.makeText(context, "配列が生成されていません", Toast.LENGTH_SHORT).show();
            return -1;
        }
        else if(i>= sRArray.size()){
            Toast.makeText(context, "配列サイズを超える番号です", Toast.LENGTH_SHORT).show();
            return -1;
        }
        return sRArray.get(i);
    }

    public int getSoundSize(){
        return sRArray.size();
    }

    public boolean isEmpty(){
        return sRArray.isEmpty();
    }
}
