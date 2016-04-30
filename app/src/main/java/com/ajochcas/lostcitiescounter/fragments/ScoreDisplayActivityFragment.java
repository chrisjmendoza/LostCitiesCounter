package com.ajochcas.lostcitiescounter.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ajochcas.lostcitiescounter.R;


/**
 * A placeholder fragment containing a simple view
 */
public class ScoreDisplayActivityFragment extends Fragment {


    public ScoreDisplayActivityFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_score_display_activity, container, false);
    }

}
