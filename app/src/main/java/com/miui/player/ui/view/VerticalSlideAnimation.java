package com.miui.player.ui.view;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;

public class VerticalSlideAnimation extends Animation {
    private int mDestination;
    private boolean mFinished;
    private View mSlidable;
    private int mStart;

    public VerticalSlideAnimation(View slidable) {
        this.mSlidable = slidable;
    }

    public void slideTo(int destination, long duration) {
        this.mDestination = destination;
        this.mStart = this.mSlidable.getScrollY();
        setDuration(duration);
        this.mSlidable.startAnimation(this);
        this.mFinished = false;
    }

    public void slideTo(int destination) {
        slideTo(destination, getDuration());
    }

    public void abort() {
        this.mFinished = true;
    }

    public void initialize(int width, int height, int parentWidth, int parentHeight) {
        super.initialize(width, height, parentWidth, parentHeight);
    }

    protected void applyTransformation(float interpolatedTime, Transformation t) {
        if (this.mFinished) {
            setDuration(0);
            return;
        }
        this.mSlidable.scrollTo(0, (int) (((float) this.mStart) + (((float) (this.mDestination - this.mStart)) * interpolatedTime)));
    }
}
