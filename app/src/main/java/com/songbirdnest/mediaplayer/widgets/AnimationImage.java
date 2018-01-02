package com.songbirdnest.mediaplayer.widgets;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.AnimationDrawable;
import android.util.AttributeSet;
import android.widget.ImageView;

public class AnimationImage extends ImageView {
    AnimationDrawable myAnimation;

    public AnimationImage(Context context, AttributeSet attrs) {
        super(context, attrs, 0);
    }

    public AnimationImage(Context context, AttributeSet attrs, int defstyle) {
        super(context, attrs, defstyle);
    }

    public AnimationImage(Context context) {
        super(context, null);
    }

    public void setAnimation(AnimationDrawable inAnimation) {
        if (this.myAnimation != null && this.myAnimation.isRunning()) {
            this.myAnimation.stop();
        }
        this.myAnimation = inAnimation;
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.myAnimation != null && !this.myAnimation.isRunning()) {
            this.myAnimation.start();
        }
    }
}
