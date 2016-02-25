package com.example.vesp.myapplication_handler;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by vesp on 15/11/18.
 */
public class SubFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle saveInstanceState){
        return inflater.inflate(
                R.layout.fragment_sub, container, false
        );
    }
}

