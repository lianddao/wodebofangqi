package com.songbirdnest.mediaplayer.layout;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.songbirdnest.mediaplayer.C0116R;

public class PlayButtonImageView extends ImageView {
    public static final int ID = 2131492935;
    private boolean isPlaying;

    public PlayButtonImageView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public PlayButtonImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public PlayButtonImageView(Context context) {
        super(context);
    }

    public void setPlaying(boolean isPlaying) {
        this.isPlaying = isPlaying;
        if (isPlaying) {
            setBackgroundResource(C0116R.drawable.pause_button);
        } else {
            setBackgroundResource(C0116R.drawable.play_button);
        }
        invalidate();
    }

    public boolean isPlaying() {
        return this.isPlaying;
    }
}
