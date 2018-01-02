package com.songbirdnest.mediaplayer.widgets;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.TextView;

public class MarqueeTextView extends TextView {
    public MarqueeTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        isFocused();
    }

    public boolean isFocused() {
        return true;
    }

    public void onWindowFocusChanged(boolean hasWindowFocus) {
        super.onWindowFocusChanged(hasWindowFocus);
        isFocused();
    }

    protected void onFocusChanged(boolean focused, int direction, Rect previouslyFocusedRect) {
        if (focused) {
            super.onFocusChanged(focused, direction, previouslyFocusedRect);
        }
    }
}
