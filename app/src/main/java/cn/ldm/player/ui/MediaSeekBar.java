package cn.ldm.player.ui;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.media.MediaMetadata;
import android.media.session.MediaController;
import android.media.session.PlaybackState;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.media.session.MediaSessionCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.animation.LinearInterpolator;
import android.widget.SeekBar;
import android.widget.TextView;

import cn.ldm.player.fragments.PlayingFragment;

/**
 * SeekBar，可以与 {@link android.media.session.MediaSession} 一起使用来跟踪和查找播放媒体。
 */

public class MediaSeekBar extends SeekBar implements ValueAnimator.AnimatorUpdateListener {

    public interface TimeChangeListener {
        void onProgressChanged(MediaSeekBar seekBar);
    }

    @Override
    public void onAnimationUpdate(ValueAnimator animation) {
        // 如果用户正在更改滑块，则取消动画。
        if (mIsTracking) {
            animation.cancel();
            return;
        }

        final int animatedIntValue = (int) animation.getAnimatedValue();
        setProgress(animatedIntValue);
        _timeChangeListener.onProgressChanged(MediaSeekBar.this);
    }

    private static final String TAG = MediaSeekBar.class.getSimpleName();
    private boolean mIsTracking = false;

    private OnSeekBarChangeListener mOnSeekBarChangeListener = new OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {
            mIsTracking = true;
            ((Activity) getContext()).getMediaController().getTransportControls().pause();
        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {
            ((Activity) getContext()).getMediaController().getTransportControls().seekTo(getProgress());
            mIsTracking = false;
            ((Activity) getContext()).getMediaController().getTransportControls().play();
        }
    };

    private ValueAnimator mProgressAnimator;
    private TimeChangeListener _timeChangeListener;

    public MediaSeekBar(Context context) {
        super(context);
        super.setOnSeekBarChangeListener(mOnSeekBarChangeListener);
    }

    public MediaSeekBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        super.setOnSeekBarChangeListener(mOnSeekBarChangeListener);

        ((Activity) getContext()).getMediaController().registerCallback(new MediaController.Callback() {
            @Override
            public void onPlaybackStateChanged(@NonNull PlaybackState state) {
                // 如果有一个正在进行的动画，现在就停止它
                if (mProgressAnimator != null) {
                    mProgressAnimator.cancel();
                    mProgressAnimator = null;
                }

                final int progress = state != null
                        ? (int) state.getPosition()
                        : 0;
                setProgress(progress);

                // 如果媒体在播放，那么 seekBar 应该跟随它，
                // 而最简单的方法就是创建一个 ValueAnimator 来更新它，这样当播放完成时，进度条会到达它的的末尾(或者足够近)。
                if (state != null && state.getState() == PlaybackState.STATE_PLAYING) {
                    final int timeToEnd = (int) ((getMax() - progress) / state.getPlaybackSpeed());//除数为播放速度,计算出到终点还需要走多少个点
                    mProgressAnimator = ValueAnimator.ofInt(progress, getMax()).setDuration(timeToEnd);
                    mProgressAnimator.setInterpolator(new LinearInterpolator());
                    mProgressAnimator.addUpdateListener(MediaSeekBar.this);
                    mProgressAnimator.start();
                }
            }

            @Override
            public void onMetadataChanged(@Nullable MediaMetadata metadata) {
                // 如果有一个正在进行的动画，现在就停止它
                Log.i(TAG, "onMetadataChanged: 清空动画");
                if (mProgressAnimator != null) {
                    mProgressAnimator.cancel();
                    mProgressAnimator = null;
                    mIsTracking = false;
                }
            }

        });

    }


    public MediaSeekBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        super.setOnSeekBarChangeListener(mOnSeekBarChangeListener);
    }

    @Override
    public void setOnSeekBarChangeListener(OnSeekBarChangeListener l) {
        // 禁止再向这个子类添加 OnSeekBarChangeListener。
    }

    public void startAnimator(Fragment fragment) {
        Log.i(TAG, "startAnimator: ");
        _timeChangeListener = (TimeChangeListener) fragment;
        float speed = ((Activity) getContext()).getMediaController().getPlaybackState().getPlaybackSpeed();
        final int timeToEnd = (int) ((getMax() - getProgress()) / speed);//除数为播放速度,计算出到终点还需要走多少个点

        mProgressAnimator = ValueAnimator.ofInt(getProgress(), getMax()).setDuration(timeToEnd);
        mProgressAnimator.setInterpolator(new LinearInterpolator());
        mProgressAnimator.addUpdateListener(this);

        if (((Activity) getContext()).getMediaController().getPlaybackState().getState() == PlaybackState.STATE_PLAYING) {
            mProgressAnimator.start();
        } else {
            mProgressAnimator.cancel();
        }
    }

}
