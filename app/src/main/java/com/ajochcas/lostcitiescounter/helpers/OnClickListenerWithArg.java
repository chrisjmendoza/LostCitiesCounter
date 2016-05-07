package com.ajochcas.lostcitiescounter.helpers;

import android.view.View;

/**
 * Helper class used to reduce code stress by carrying the button
 * number with the listener. onClick should be overwritten.
 */
public class OnClickListenerWithArg implements View.OnClickListener {

    /**
     * What button number does this listener relate to?
     */
    public int btnNum;

    /**
     * Constructor that accepts which button number this is
     * referencing.
     * @param btnNum What button number does this relate to?
     */
    public OnClickListenerWithArg(int btnNum) {
        this.btnNum = btnNum;
    }

    /**
     * This is meant to be overridden, please override!
     * @param v
     */
    @Override
    public void onClick(View v) {
        throw new UnsupportedOperationException();
    }
}
