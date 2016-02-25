package com.extreamvomit.androidcoolmouth.RVEditors;

import android.content.Context;
import android.media.AudioManager;
import android.media.SoundPool;
import android.util.Log;
import android.widget.Toast;

import com.extreamvomit.androidcoolmouth.WidgetDatas.SoundResource;

import java.util.ArrayList;

import static com.extreamvomit.androidcoolmouth.TypeDefine.SOUND_ARRAY_NUM;

/**
 * Created by vesp on 16/01/06.
 */
public class SetWidgetSound {
    //private final static int SOUND_ARRAY_NUM= 2;
    private ArrayList<Integer> soundIdArray = new ArrayList<Integer>();
    public Context context;
    private SoundPool my_sound_pool;
    private SoundResource soundResource;
    private String TAG="SetWidgetSound";

    public SetWidgetSound(Context f_context){
        this.WidgetSoundInit(f_context);
    }

    // SoundPoolLoadを行う
    public void WidgetSoundInit(Context d_context){
        if(d_context == null){
            Log.d(TAG, "Error:Context == null");
        }
        context = d_context;
        soundResource = new SoundResource(context);
        my_sound_pool = new SoundPool(5, AudioManager.STREAM_MUSIC, 0);
        if(my_sound_pool == null){
            Log.d("SetWidgetSound", "サンドマンプールぬるぽ");
            return;
        }
        if(soundResource.isEmpty()){
            Log.d("SetWidgetSound", "soundResourceぬるぽ");
            return;
        };

        // soundResouceからロードし、soundIdArrayへSoundPoolLoadID登録
        for(int i=0; i<soundResource.getSoundSize(); ++i){
            int soundDataID = soundResource.getSoundResource(i);
            if(soundDataID == -1){
                Toast.makeText(context, "soundResource読み込み失敗", Toast.LENGTH_SHORT).show();
                Log.d("SetWidgetSound", "読み込み　soundResource読み込み失敗");
                continue;
            }
            Log.d("SetWidgetSound", "読み込み　Sound_id = ");
            soundIdArray.add(i, my_sound_pool.load(context, soundDataID, 1)); // シングルトンにスべき？
            //Log.d("SetWidgetSound", "読み込み　Sound_id = "+soundIdArray.get(i));
            Log.d("SetWidgetSound", "読み込み　Sound_id = ");
        }
    }

    //効果音を鳴らす
    public boolean RingWidgetSound(int d_type){
        int sp_playResult;
        boolean result = true;

        // nullチェック
        if(my_sound_pool == null){
            Toast.makeText(context, "SoundPoolNullpo", Toast.LENGTH_SHORT).show();
            return false;
        }

        // typeから音源を判定
        int sound_id = WidgetSoundJudge(d_type);
        Log.d("SetWidgetSound", "読み込み　Sound_id = " + sound_id);

        // 音を鳴らす
        sp_playResult = my_sound_pool.play(sound_id, 1.0F, 1.0F, 0, 0, 1.0F);
        if(sp_playResult == 0) {
            Toast.makeText(context, "SoundPlay読み込み失敗", Toast.LENGTH_SHORT).show();
            Log.d("SetWidgetSound", "失敗");
            Log.d("SetWidgetSound", "Sound_id = "+sound_id);
            result = false;
        }

        return result;
    }

    private int WidgetSoundJudge(int type){
        if(type >soundResource.getSoundSize()){
            Toast.makeText(context, "type指定が配列サイズを超えていまーす", Toast.LENGTH_SHORT).show();
            return -1;
        }
        return soundIdArray.get(type-1);
    }
}
