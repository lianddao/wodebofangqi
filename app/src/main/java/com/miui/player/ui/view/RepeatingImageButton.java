package com.miui.player.ui.view;

import android.content.Context;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import com.miui.player.ui.menu.common.BaseMenuId;

public class RepeatingImageButton extends ImageView {
    long mInterval;
    private RepeatListener mListener;
    private int mRepeatCount;
    private Runnable mRepeater;
    private long mStartTime;

    public interface RepeatListener {
        void onRepeat(View view, long j, int i);
    }

    class C05291 implements Runnable {
        C05291() {
        }

        public void run() {
            RepeatingImageButton.this.doRepeat(false);
            if (RepeatingImageButton.this.isPressed()) {
                RepeatingImageButton.this.postDelayed(this, RepeatingImageButton.this.mInterval);
            }
        }
    }

    public RepeatingImageButton(Context context) {
        this(context, null);
    }

    public RepeatingImageButton(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public RepeatingImageButton(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.mInterval = 500;
        this.mRepeater = new C05291();
        setFocusable(true);
        setLongClickable(true);
    }

    public void setRepeatListener(RepeatListener l, long interval) {
        this.mListener = l;
        this.mInterval = interval;
    }

    public boolean performLongClick() {
        this.mStartTime = SystemClock.elapsedRealtime();
        this.mRepeatCount = 0;
        post(this.mRepeater);
        return true;
    }

    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == 1) {
            removeCallbacks(this.mRepeater);
            if (this.mStartTime != 0) {
                doRepeat(true);
                this.mStartTime = 0;
            }
        }
        return super.onTouchEvent(event);
    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch (keyCode) {
            case BaseMenuId.SEARCH_LYRIC /*23*/:
            case 66:
                super.onKeyDown(keyCode, event);
                return true;
            default:
                return super.onKeyDown(keyCode, event);
        }
    }

    public boolean onKeyUp(int keyCode, KeyEvent event) {
        switch (keyCode) {
            case BaseMenuId.SEARCH_LYRIC /*23*/:
            case 66:
                removeCallbacks(this.mRepeater);
                if (this.mStartTime != 0) {
                    doRepeat(true);
                    this.mStartTime = 0;
                    break;
                }
                break;
        }
        return super.onKeyUp(keyCode, event);
    }

    void doRepeat(boolean last) {
        long now = SystemClock.elapsedRealtime();
        if (this.mListener != null) {
            int i;
            RepeatListener repeatListener = this.mListener;
            long j = now - this.mStartTime;
            if (last) {
                i = -1;
            } else {
                i = this.mRepeatCount;
                this.mRepeatCount = i + 1;
            }
            repeatListener.onRepeat(this, j, i);
        }
    }
}
