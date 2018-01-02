package com.songbirdnest.mediaplayer.widgets;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.widget.CheckedTextView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.songbirdnest.mediaplayer.C0116R;
import com.songbirdnest.util.Logger;

public class SlidingButton extends LinearLayout {
    private static final int SWIPE_MAX_OFF_PATH = 150;
    private static final int SWIPE_MIN_DISTANCE = 20;
    private static final int SWIPE_VELOCITY = 200;
    private int REL_SWIPE_MAX_OFF_PATH;
    private int REL_SWIPE_MIN_DISTANCE;
    private int REL_SWIPE_THRESHOLD_VELOCITY;
    private OnCheckedChangeListener checkedChangeListener;
    private boolean debugging = false;
    protected GestureDetector gestureDetector;
    protected GestureListener gestureListener;
    protected Handler handler = new Handler();
    private TextView offText;
    private TextView onText;
    private CheckedTextView toggleButton;

    public interface OnCheckedChangeListener {
        void onCheckedChanged(CheckedTextView checkedTextView, boolean z);
    }

    private class GestureListener extends SimpleOnGestureListener {
        protected boolean processingFling;

        class C04521 implements Runnable {
            C04521() {
            }

            public void run() {
                SlidingButton.this.toggleButton.toggle();
                if (SlidingButton.this.checkedChangeListener != null) {
                    SlidingButton.this.checkedChangeListener.onCheckedChanged(SlidingButton.this.toggleButton, SlidingButton.this.toggleButton.isChecked());
                }
            }
        }

        class C04532 implements Runnable {
            C04532() {
            }

            public void run() {
                SlidingButton.this.toggleButton.toggle();
                if (SlidingButton.this.checkedChangeListener != null) {
                    SlidingButton.this.checkedChangeListener.onCheckedChanged(SlidingButton.this.toggleButton, SlidingButton.this.toggleButton.isChecked());
                }
            }
        }

        private GestureListener() {
            this.processingFling = false;
        }

        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            this.processingFling = false;
            if (e1 == null || e2 == null) {
                return false;
            }
            float leftXDistance = e1.getX() - e2.getX();
            float rightXDistance = e2.getX() - e1.getX();
            float yDistance = Math.abs(e1.getY() - e2.getY());
            if (SlidingButton.this.debugging) {
                Logger.debug(this, "onFling: leftXDistance: " + leftXDistance + " rightXDistance: " + rightXDistance + " yDistance: " + yDistance);
            }
            if (yDistance > ((float) SlidingButton.this.REL_SWIPE_MAX_OFF_PATH)) {
                return false;
            }
            if (leftXDistance > ((float) SlidingButton.this.REL_SWIPE_MIN_DISTANCE) && Math.abs(velocityX) >= ((float) SlidingButton.this.REL_SWIPE_THRESHOLD_VELOCITY)) {
                this.processingFling = true;
                if (SlidingButton.this.debugging) {
                    Logger.debug(this, "Swipe left detected");
                }
                if (SlidingButton.this.toggleButton.isChecked()) {
                    SlidingButton.this.handler.post(new C04521());
                }
                return true;
            } else if (rightXDistance <= ((float) SlidingButton.this.REL_SWIPE_MIN_DISTANCE) || Math.abs(velocityX) < ((float) SlidingButton.this.REL_SWIPE_THRESHOLD_VELOCITY)) {
                return false;
            } else {
                this.processingFling = true;
                if (SlidingButton.this.debugging) {
                    Logger.debug(this, "Swipe right detected");
                }
                if (!SlidingButton.this.toggleButton.isChecked()) {
                    SlidingButton.this.handler.post(new C04532());
                }
                return true;
            }
        }
    }

    public SlidingButton(Context context) {
        super(context);
        init();
    }

    public SlidingButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        setOrientation(0);
        DisplayMetrics dm = getResources().getDisplayMetrics();
        this.REL_SWIPE_MIN_DISTANCE = (dm.densityDpi * 20) / 160;
        this.REL_SWIPE_MAX_OFF_PATH = (dm.densityDpi * SWIPE_MAX_OFF_PATH) / 160;
        this.REL_SWIPE_THRESHOLD_VELOCITY = (dm.densityDpi * SWIPE_VELOCITY) / 160;
        if (this.debugging) {
            Logger.debug(this, "REL_SWIPE_MIN_DISTANCE: " + this.REL_SWIPE_MIN_DISTANCE + " REL_SWIPE_MAX_OFF_PATH: " + this.REL_SWIPE_MAX_OFF_PATH + " REL_SWIPE_THRESHOLD_VELOCITY: " + this.REL_SWIPE_THRESHOLD_VELOCITY);
        }
        this.gestureListener = new GestureListener();
        this.gestureDetector = new GestureDetector(getContext(), this.gestureListener);
        this.offText = new TextView(getContext());
        this.offText.setText(C0116R.string.off);
        LayoutParams params = new LayoutParams(-2, -2);
        params.gravity = 16;
        params.rightMargin = 17;
        addView(this.offText, params);
        this.toggleButton = new CheckedTextView(getContext());
        params = new LayoutParams(-2, -2);
        params.gravity = 16;
        params.rightMargin = 17;
        addView(this.toggleButton, params);
        this.onText = new TextView(getContext());
        this.onText.setText(C0116R.string.on);
        params = new LayoutParams(-2, -2);
        params.gravity = 16;
        addView(this.onText, params);
    }

    public void setCheckedChangeListener(OnCheckedChangeListener listener) {
        this.checkedChangeListener = listener;
    }

    public TextView getOffText() {
        return this.offText;
    }

    public TextView getOnText() {
        return this.onText;
    }

    public CheckedTextView getToggleButton() {
        return this.toggleButton;
    }

    public boolean onTouchEvent(MotionEvent event) {
        if (this.gestureDetector.onTouchEvent(event)) {
            return true;
        }
        return super.onTouchEvent(event);
    }

    public void setChecked(boolean checked) {
        if (this.toggleButton != null) {
            this.toggleButton.setChecked(checked);
        }
    }

    public boolean isChecked() {
        if (this.toggleButton != null) {
            return this.toggleButton.isChecked();
        }
        return false;
    }

    public void toggle() {
        if (this.toggleButton != null) {
            this.toggleButton.toggle();
        }
    }

    public void setToggleButtonImage(int backgroundImage) {
        if (this.toggleButton != null) {
            this.toggleButton.setBackgroundResource(backgroundImage);
        }
    }
}
