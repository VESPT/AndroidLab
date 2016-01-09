package com.extreamvomit.androidcoolmouth.WidgetEditors;

import android.content.Context;
import android.media.AudioManager;
import android.media.SoundPool;
import android.util.Log;
import com.extreamvomit.androidcoolmouth.R;

/**
 * Created by vesp on 16/01/06.
 */
public class SetWidgetSound {
    private final static int SOUND_ARRAY_NUM= 2;
    private int soundIdArray[] = new int[SOUND_ARRAY_NUM];
    public Context context;
    private SoundPool my_sound_pool;

    public SetWidgetSound(Context f_context){
        this.WidgetSoundInit(f_context);
    }

    public void WidgetSoundInit(Context f_context){
        context = f_context;
        //my_sound_pool = null;
        my_sound_pool = new SoundPool(5, AudioManager.STREAM_MUSIC, 0);
        if(my_sound_pool == null){
            Log.d("SetWidgetSound", "サンドマンぬるぽ");
        }
        else{
            Log.d("SetWidgetSound", "サンドマンOK");
        }
        for(int i=0; i<SOUND_ARRAY_NUM; ++i){
            int sound_data = R.raw.se_maoudamashii_system46;
            soundIdArray[i]=my_sound_pool.load(f_context, sound_data, 1 ); // シングルトンにスべき？
            Log.d("SetWidgetSound", "読み込み　Sound_id = "+soundIdArray[i]);
            //sound_pool.play(soundIdArray[i], 1.0F, 1.0F, 0, 0, 1.0F);
        }
        int test =my_sound_pool.load(context, R.raw.se_maoudamashii_system46, 1);
        Log.d("SetWidgetSound", "WidgetSoundInit終了");
    }

    //効果音用
    public boolean RingWidgetSound(int type){
        int debug_result;
        int sound_id = WidgetSoundJudge(type);
        int soundId=my_sound_pool.load(context, R.raw.se_maoudamashii_system46, 1 ); // デフォルト
        Log.d("SetWidgetSound", "読み込み　Sound_id = " + soundId);
        my_sound_pool.play(soundId, 1.0F, 1.0F, 0, 0, 1.0F);

        debug_result = my_sound_pool.play(sound_id, 1.0F, 1.0F, 0, 0, 1.0F);
        if(debug_result == 0) {
            Log.d("SetWidgetSound", "しっぱい");
            Log.d("SetWidgetSound", "Sound_id = "+sound_id);
        }
        else Log.d("SetWidgetSound", "せいこう");

        return true;
    }

    private int WidgetSoundJudge(int type){
        return soundIdArray[type-1];
    }
}
