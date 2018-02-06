package cn.ldm.player.ui;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.media.MediaMetadata;
import android.media.session.MediaController;
import android.media.session.PlaybackState;
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
    private MediaController mMediaController;
    //    private ControllerCallback mControllerCallback;
    private boolean mIsTracking = false;

    private OnSeekBarChangeListener mOnSeekBarChangeListener = new OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {
            mIsTracking = true;
        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {
            ((Activity)getContext()).getMediaController().getTransportControls().seekTo(getProgress());
            mIsTracking = false;
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
                if (mProgressAnimator != null) {
                    Log.i(TAG, "onMetadataChanged: 清空动画");
                    mProgressAnimator.cancel();
                    mProgressAnimator = null;
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

    //    public void setMediaController(final MediaController mediaController) {
    //        Log.i(TAG, "setMediaController: ");
    //        if (mediaController != null) {
    //            mControllerCallback = new ControllerCallback();
    //            mediaController.registerCallback(mControllerCallback);
    //        } else if (mMediaController != null) {
    //            mMediaController.unregisterCallback(mControllerCallback);
    //            mControllerCallback = null;
    //        }
    //        mMediaController = mediaController;
    //    }


    private Fragment _fragment;

    public void startAnimator(Context context, Fragment fragment) {
        _fragment = fragment;
        Log.i(TAG, "startAnimator: ");
        float speed = ((Activity) context).getMediaController().getPlaybackState().getPlaybackSpeed();
        final int timeToEnd = (int) ((getMax() - getProgress()) / speed);//除数为播放速度,计算出到终点还需要走多少个点

        mProgressAnimator = ValueAnimator.ofInt(getProgress(), getMax()).setDuration(timeToEnd);
        mProgressAnimator.setInterpolator(new LinearInterpolator());
        mProgressAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                // 如果用户正在更改滑块，则取消动画。
                if (mIsTracking) {
                    animation.cancel();
                    return;
                }

                final int animatedIntValue = (int) animation.getAnimatedValue();
                setProgress(animatedIntValue);

                if (_fragment instanceof TimeChangeListener) {
                    _timeChangeListener = (TimeChangeListener) _fragment;
                    _timeChangeListener.onProgressChanged(MediaSeekBar.this);
                }
            }
        });
        mProgressAnimator.start();
    }

    // TODO: 2018.02.06.0006 拖动进度条,同步更新通知栏当前进度时间

    //    public void disconnectController() {
    //        if (mMediaController != null) {
    //            mMediaController.unregisterCallback(mControllerCallback);
    //            mControllerCallback = null;
    //            mMediaController = null;
    //        }
    //    }

    private class ControllerCallback extends MediaController.Callback implements ValueAnimator.AnimatorUpdateListener {

        @Override
        public void onPlaybackStateChanged(PlaybackState state) {
            super.onPlaybackStateChanged(state);

            Log.i(TAG, "onPlaybackStateChanged: " + state.toString());

            // 如果有一个正在进行的动画，现在就停止它
            if (mProgressAnimator != null) {
                Log.i(TAG, "onPlaybackStateChanged: 停止动画");
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
                Log.i(TAG, "onPlaybackStateChanged: 开始动画");
                final int timeToEnd = (int) ((getMax() - progress) / state.getPlaybackSpeed());//除数为播放速度,计算出到终点还需要走多少个点

                mProgressAnimator = ValueAnimator.ofInt(progress, getMax()).setDuration(timeToEnd);
                mProgressAnimator.setInterpolator(new LinearInterpolator());
                mProgressAnimator.addUpdateListener(this);
                mProgressAnimator.start();
            }
        }

        @Override
        public void onMetadataChanged(MediaMetadata metadata) {
            super.onMetadataChanged(metadata);
            Log.i(TAG, "onMetadataChanged: " + metadata.toString());

            final int max = metadata != null
                    ? (int) metadata.getLong(MediaMetadata.METADATA_KEY_DURATION)
                    : 0;
            setProgress(0);
            setMax(max);//将 seekBar 的 max 设置为歌曲的时间长度
        }

        @Override
        public void onAnimationUpdate(final ValueAnimator valueAnimator) {
            // 如果用户正在更改滑块，则取消动画。
            if (mIsTracking) {
                valueAnimator.cancel();
                return;
            }

            final int animatedIntValue = (int) valueAnimator.getAnimatedValue();
            setProgress(animatedIntValue);
        }
    }
}
