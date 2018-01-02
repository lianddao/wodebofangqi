package com.songbirdnest.mediaplayer.widgets;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.SeekBar;

public class MiniSeekBar extends SeekBar {
    public MiniSeekBar(Context context) {
        super(context);
    }

    public MiniSeekBar(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MiniSeekBar(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public void setThumb(Drawable thumb) {
        super.setThumb(null);
    }

    public void setThumbOffset(int thumbOffset) {
        super.setThumbOffset(0);
    }
}
