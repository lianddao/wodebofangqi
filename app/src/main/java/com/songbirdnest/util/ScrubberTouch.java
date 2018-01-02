package com.songbirdnest.util;

import android.os.Handler;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

public class ScrubberTouch implements OnTouchListener {
    private static final int SCRUBBER_HOP = 1000;
    private static final int SCRUBBER_WAIT = 500;
    static final int mHopSentinal = 0;
    private Runnable initialRunner = new InitialRunner();
    ClickRunner mClickAction;
    Handler mHandler = new Handler();
    HoldRunner[] mHoldAction;
    int mHoldIndex = 0;
    int mHopChange;
    int mHopCount = 0;
    boolean mIsHopping = false;
    CheckLock mLock;
    boolean mLockAcquired = false;
    private Runnable scrubberRun = new ScrubberHopRun();

    class InitialRunner implements Runnable {
        InitialRunner() {
        }

        public void run() {
            ScrubberTouch.this.mIsHopping = true;
            if (!(ScrubberTouch.this.mLock == null || !ScrubberTouch.this.mLock.needsLock() || ScrubberTouch.this.mLockAcquired)) {
                ScrubberTouch.this.mLock.lock();
                ScrubberTouch.this.mLockAcquired = true;
            }
            ScrubberTouch.this.mHandler.post(ScrubberTouch.this.scrubberRun);
        }
    }

    class ScrubberHopRun implements Runnable {
        ScrubberHopRun() {
        }

        public void run() {
            Log.i("Tracker", "Index: " + ScrubberTouch.this.mHoldIndex);
            ScrubberTouch.this.mHoldAction[ScrubberTouch.this.mHoldIndex].run();
            if (ScrubberTouch.this.mHopChange != 0) {
                ScrubberTouch scrubberTouch;
                if (ScrubberTouch.this.mHopCount < ScrubberTouch.this.mHopChange) {
                    scrubberTouch = ScrubberTouch.this;
                    scrubberTouch.mHopCount++;
                }
                if (ScrubberTouch.this.mHopCount >= ScrubberTouch.this.mHopChange && ScrubberTouch.this.mHoldIndex < ScrubberTouch.this.mHoldAction.length - 1) {
                    scrubberTouch = ScrubberTouch.this;
                    scrubberTouch.mHoldIndex++;
                    ScrubberTouch.this.mHopCount = 0;
                }
            }
            ScrubberTouch.this.mHandler.postDelayed(this, 1000);
        }
    }

    public ScrubberTouch(ClickRunner pClickAction, HoldRunner pHoldAction) {
        init(pClickAction, 0, pHoldAction);
    }

    public ScrubberTouch(ClickRunner pClickAction, int pHopChange, HoldRunner... pHoldAction) {
        init(pClickAction, pHopChange, pHoldAction);
    }

    public ScrubberTouch(ClickRunner pClickAction, HoldRunner... pHoldAction) {
        init(pClickAction, 1, pHoldAction);
    }

    public ScrubberTouch(ClickRunner pClickAction, CheckLock pLock, HoldRunner... pHoldAction) {
        this.mLock = pLock;
        init(pClickAction, 1, pHoldAction);
    }

    private void init(ClickRunner pClickAction, int pHopChange, HoldRunner... pHoldAction) {
        this.mHopChange = pHopChange;
        this.mHandler = new Handler();
        this.mClickAction = pClickAction;
        this.mHoldAction = pHoldAction;
    }

    public boolean isHopping() {
        return this.mIsHopping;
    }

    public void stopHopping() {
        this.mHandler.removeCallbacks(this.scrubberRun);
        this.mHandler.removeCallbacks(this.initialRunner);
    }

    public boolean onTouch(View v, MotionEvent event) {
        if (event.getAction() == 1) {
            if (this.mIsHopping) {
                if (this.mLock != null && this.mLockAcquired) {
                    this.mLock.unlock();
                    this.mLockAcquired = false;
                }
                this.mHandler.removeCallbacks(this.scrubberRun);
            } else {
                this.mHandler.removeCallbacks(this.initialRunner);
                this.mHandler.post(this.mClickAction);
            }
            this.mHopCount = 0;
            this.mHoldIndex = 0;
        } else if (event.getAction() == 0) {
            this.mIsHopping = false;
            this.mHandler.postDelayed(this.initialRunner, 500);
        }
        return false;
    }
}
