package com.ajochcas.lostcitiescounter.helpers;

import android.view.View;

/**
 * Created by Casey on 5/7/2016.
 */
public class OnClickListenerWithArg implements View.OnClickListener {

    public int btnNum;

    public OnClickListenerWithArg(int btnNum) {
        this.btnNum = btnNum;
    }

    @Override
    public void onClick(View v) {
        throw new UnsupportedOperationException();
        //override me!
    }
}
