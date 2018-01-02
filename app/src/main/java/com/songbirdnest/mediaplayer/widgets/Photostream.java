package com.songbirdnest.mediaplayer.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.widget.Gallery;

public class Photostream extends Gallery {
    public Photostream(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        if (0.0f > velocityX) {
            dispatchKeyEvent(new KeyEvent(0, 22));
        } else {
            dispatchKeyEvent(new KeyEvent(0, 21));
        }
        return true;
    }
}
