package com.miui.player.ui.controller;

import android.content.Context;
import android.os.RemoteException;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import com.miui.player.C0329R;
import com.miui.player.service.ServiceHelper;
import com.miui.player.ui.UIHelper;

public class TimeIndicatorController {
    final Context mContext;
    final TextView mCurrentTimeTextView;
    long mDuration = 0;
    private final SeekBar mProgressBar;
    final OnProgressSeekListener mSeekListener;
    private final View mTimeIndicatorView;
    private final TextView mTotalTimeTextView;
    boolean mUserTouch = false;

    public interface OnProgressSeekListener {
        void seek(int i, int i2);
    }

    class OnSeekPlayerPositionListener implements OnSeekBarChangeListener {
        OnSeekPlayerPositionListener() {
        }

        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            if (TimeIndicatorController.this.mDuration > 0) {
                TimeIndicatorController.this.mCurrentTimeTextView.setText(UIHelper.makeTimeString(TimeIndicatorController.this.mContext, (TimeIndicatorController.this.mDuration * ((long) progress)) / 1000, C0329R.string.durationformatshort_padding_with_0));
            }
        }

        public void onStartTrackingTouch(SeekBar seekBar) {
            TimeIndicatorController.this.mUserTouch = true;
        }

        public void onStopTrackingTouch(SeekBar seekBar) {
            int progress = seekBar.getProgress();
            TimeIndicatorController.this.mUserTouch = false;
            if (TimeIndicatorController.this.mSeekListener != null) {
                TimeIndicatorController.this.mSeekListener.seek(progress, seekBar.getMax());
            }
            if (TimeIndicatorController.this.mDuration > 0) {
                TimeIndicatorController.this.mCurrentTimeTextView.setText(UIHelper.makeTimeString(TimeIndicatorController.this.mContext, (TimeIndicatorController.this.mDuration * ((long) progress)) / 1000, C0329R.string.durationformatshort_padding_with_0));
            }
        }
    }

    public TimeIndicatorController(View container, OnProgressSeekListener listener) {
        this.mContext = container.getContext();
        this.mSeekListener = listener;
        this.mTimeIndicatorView = container.findViewById(C0329R.id.time_indicator);
        this.mProgressBar = (SeekBar) this.mTimeIndicatorView.findViewById(16908301);
        this.mProgressBar.setMax(1000);
        this.mProgressBar.setOnSeekBarChangeListener(new OnSeekPlayerPositionListener());
        this.mProgressBar.setProgressDrawable(this.mContext.getResources().getDrawable(C0329R.drawable.time_indicator_progress_drawable));
        this.mCurrentTimeTextView = (TextView) this.mTimeIndicatorView.findViewById(C0329R.id.currenttime);
        this.mTotalTimeTextView = (TextView) this.mTimeIndicatorView.findViewById(C0329R.id.totaltime);
    }

    public void refresh(long pos, long dur, float bufferedPer, boolean isPlaying, boolean isBuffering, boolean forceRefreshTotal) {
        if (pos >= 0) {
            if (forceRefreshTotal || this.mDuration != dur) {
                setTotalTime(dur);
            }
            if (this.mDuration > 0) {
                if (isPlaying) {
                    this.mCurrentTimeTextView.setVisibility(0);
                }
                if (!this.mUserTouch) {
                    this.mProgressBar.setProgress((int) ((1000 * pos) / this.mDuration));
                    this.mCurrentTimeTextView.setText(UIHelper.makeTimeString(this.mContext, pos, C0329R.string.durationformatshort_padding_with_0));
                }
            } else {
                return;
            }
        }
        this.mCurrentTimeTextView.setText("--:--");
        this.mProgressBar.setProgress(0);
        this.mProgressBar.setSecondaryProgress((int) (1000.0f * bufferedPer));
    }

    public void setVisible(boolean visible) {
        View v = this.mTimeIndicatorView;
        int visibility = visible ? 0 : 4;
        if (v.getVisibility() != visibility) {
            v.setVisibility(visibility);
            v.startAnimation(AnimationUtils.loadAnimation(v.getContext(), visible ? C0329R.anim.fade_in : C0329R.anim.fade_out));
        }
    }

    public View getView() {
        return this.mTimeIndicatorView;
    }

    private void setTotalTime(long dur) {
        try {
            if (ServiceHelper.sService == null || !ServiceHelper.sService.isBuffering()) {
                this.mDuration = dur;
                this.mTotalTimeTextView.setText(UIHelper.makeTimeString(this.mContext, dur, C0329R.string.durationformatshort_padding_with_0));
                return;
            }
            this.mTotalTimeTextView.setText(C0329R.string.buffering);
        } catch (RemoteException e) {
        }
    }
}
