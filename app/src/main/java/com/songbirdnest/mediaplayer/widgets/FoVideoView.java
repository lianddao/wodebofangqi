package com.songbirdnest.mediaplayer.widgets;

import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnBufferingUpdateListener;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.media.MediaPlayer.OnVideoSizeChangedListener;
import android.net.Uri;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.MediaController;
import android.widget.MediaController.MediaPlayerControl;
import java.io.IOException;
import java.util.Map;

public class FoVideoView extends SurfaceView implements MediaPlayerControl {
    private static final int STATE_ERROR = -1;
    private static final int STATE_IDLE = 0;
    private static final int STATE_PAUSED = 4;
    private static final int STATE_PLAYBACK_COMPLETED = 5;
    private static final int STATE_PLAYING = 3;
    private static final int STATE_PREPARED = 2;
    private static final int STATE_PREPARING = 1;
    private static final int STATE_RESUME = 7;
    private static final int STATE_SUSPEND = 6;
    private static final int STATE_SUSPEND_UNSUPPORTED = 8;
    private String TAG;
    private OnBufferingUpdateListener mBufferingUpdateListener;
    private boolean mCanPause;
    private boolean mCanSeekBack;
    private boolean mCanSeekForward;
    private OnCompletionListener mCompletionListener;
    private Context mContext;
    private int mCurrentBufferPercentage;
    private int mCurrentState;
    private int mDuration;
    private OnErrorListener mErrorListener;
    private Map<String, String> mHeaders;
    private MediaController mMediaController;
    private MediaPlayer mMediaPlayer;
    private OnCompletionListener mOnCompletionListener;
    private OnErrorListener mOnErrorListener;
    private OnPreparedListener mOnPreparedListener;
    OnPreparedListener mPreparedListener;
    Callback mSHCallback;
    private int mSeekWhenPrepared;
    OnVideoSizeChangedListener mSizeChangedListener;
    private int mStateWhenSuspended;
    private int mSurfaceHeight;
    private SurfaceHolder mSurfaceHolder;
    private int mSurfaceWidth;
    private int mTargetState;
    private Uri mUri;
    private int mVideoHeight;
    private int mVideoWidth;
    private int mWaitingAudioID;

    class C04401 implements OnVideoSizeChangedListener {
        C04401() {
        }

        public void onVideoSizeChanged(MediaPlayer mp, int width, int height) {
            FoVideoView.this.mVideoWidth = mp.getVideoWidth();
            FoVideoView.this.mVideoHeight = mp.getVideoHeight();
            if (FoVideoView.this.mVideoWidth != 0 && FoVideoView.this.mVideoHeight != 0) {
                FoVideoView.this.getHolder().setFixedSize(FoVideoView.this.mVideoWidth, FoVideoView.this.mVideoHeight);
            }
        }
    }

    class C04412 implements OnPreparedListener {
        C04412() {
        }

        public void onPrepared(MediaPlayer mp) {
            FoVideoView.this.mCurrentState = 2;
            FoVideoView.this.mCanPause = FoVideoView.this.mCanSeekBack = FoVideoView.this.mCanSeekForward = true;
            if (FoVideoView.this.mOnPreparedListener != null) {
                FoVideoView.this.mOnPreparedListener.onPrepared(FoVideoView.this.mMediaPlayer);
            }
            if (FoVideoView.this.mMediaController != null) {
                FoVideoView.this.mMediaController.setEnabled(true);
            }
            FoVideoView.this.mVideoWidth = mp.getVideoWidth();
            FoVideoView.this.mVideoHeight = mp.getVideoHeight();
            int seekToPosition = FoVideoView.this.mSeekWhenPrepared;
            if (seekToPosition != 0) {
                FoVideoView.this.seekTo(seekToPosition);
            }
            if (FoVideoView.this.mVideoWidth != 0 && FoVideoView.this.mVideoHeight != 0) {
                FoVideoView.this.getHolder().setFixedSize(FoVideoView.this.mVideoWidth, FoVideoView.this.mVideoHeight);
                if (FoVideoView.this.mSurfaceWidth != FoVideoView.this.mVideoWidth || FoVideoView.this.mSurfaceHeight != FoVideoView.this.mVideoHeight) {
                    return;
                }
                if (FoVideoView.this.mTargetState == 3) {
                    FoVideoView.this.start();
                    if (FoVideoView.this.mMediaController != null) {
                        FoVideoView.this.mMediaController.show();
                    }
                } else if (!FoVideoView.this.isPlaying()) {
                    if ((seekToPosition != 0 || FoVideoView.this.getCurrentPosition() > 0) && FoVideoView.this.mMediaController != null) {
                        FoVideoView.this.mMediaController.show(0);
                    }
                }
            } else if (FoVideoView.this.mTargetState == 3) {
                FoVideoView.this.start();
            }
        }
    }

    class C04423 implements OnCompletionListener {
        C04423() {
        }

        public void onCompletion(MediaPlayer mp) {
            FoVideoView.this.mCurrentState = 5;
            FoVideoView.this.mTargetState = 5;
            if (FoVideoView.this.mMediaController != null) {
                FoVideoView.this.mMediaController.hide();
            }
            if (FoVideoView.this.mOnCompletionListener != null) {
                FoVideoView.this.mOnCompletionListener.onCompletion(FoVideoView.this.mMediaPlayer);
            }
        }
    }

    class C04444 implements OnErrorListener {

        class C04431 implements OnClickListener {
            C04431() {
            }

            public void onClick(DialogInterface dialog, int whichButton) {
                if (FoVideoView.this.mOnCompletionListener != null) {
                    FoVideoView.this.mOnCompletionListener.onCompletion(FoVideoView.this.mMediaPlayer);
                }
            }
        }

        C04444() {
        }

        public boolean onError(MediaPlayer mp, int framework_err, int impl_err) {
            Log.d(FoVideoView.this.TAG, "Error: " + framework_err + "," + impl_err);
            FoVideoView.this.mCurrentState = -1;
            FoVideoView.this.mTargetState = -1;
            if (FoVideoView.this.mMediaController != null) {
                FoVideoView.this.mMediaController.hide();
            }
            if ((FoVideoView.this.mOnErrorListener == null || !FoVideoView.this.mOnErrorListener.onError(FoVideoView.this.mMediaPlayer, framework_err, impl_err)) && FoVideoView.this.getWindowToken() != null) {
                int messageId;
                if (framework_err == 200) {
                    messageId = 17039381;
                } else {
                    messageId = 17039377;
                }
                new Builder(FoVideoView.this.mContext).setTitle(17039378).setMessage(messageId).setPositiveButton(17039376, new C04431()).setCancelable(false).show();
            }
            return true;
        }
    }

    class C04455 implements OnBufferingUpdateListener {
        C04455() {
        }

        public void onBufferingUpdate(MediaPlayer mp, int percent) {
            FoVideoView.this.mCurrentBufferPercentage = percent;
        }
    }

    class C04466 implements Callback {
        C04466() {
        }

        public void surfaceChanged(SurfaceHolder holder, int format, int w, int h) {
            FoVideoView.this.mSurfaceWidth = w;
            FoVideoView.this.mSurfaceHeight = h;
            boolean isValidState;
            if (FoVideoView.this.mTargetState == 3) {
                isValidState = true;
            } else {
                isValidState = false;
            }
            boolean hasValidSize;
            if (FoVideoView.this.mVideoWidth == w && FoVideoView.this.mVideoHeight == h) {
                hasValidSize = true;
            } else {
                hasValidSize = false;
            }
            if (FoVideoView.this.mMediaPlayer != null && isValidState && hasValidSize) {
                if (FoVideoView.this.mSeekWhenPrepared != 0) {
                    FoVideoView.this.seekTo(FoVideoView.this.mSeekWhenPrepared);
                }
                FoVideoView.this.start();
                if (FoVideoView.this.mMediaController != null) {
                    if (FoVideoView.this.mMediaController.isShowing()) {
                        FoVideoView.this.mMediaController.hide();
                    }
                    FoVideoView.this.mMediaController.show();
                }
            }
        }

        public void surfaceCreated(SurfaceHolder holder) {
            FoVideoView.this.mSurfaceHolder = holder;
            if (FoVideoView.this.mMediaPlayer != null && FoVideoView.this.mCurrentState == 6 && FoVideoView.this.mTargetState == 7) {
                FoVideoView.this.mMediaPlayer.setDisplay(FoVideoView.this.mSurfaceHolder);
                FoVideoView.this.resume();
                return;
            }
            FoVideoView.this.openVideo();
        }

        public void surfaceDestroyed(SurfaceHolder holder) {
            FoVideoView.this.mSurfaceHolder = null;
            if (FoVideoView.this.mMediaController != null) {
                FoVideoView.this.mMediaController.hide();
            }
            if (FoVideoView.this.mCurrentState != 6) {
                FoVideoView.this.release(true);
            }
        }
    }

    public FoVideoView(Context context) {
        super(context);
        this.TAG = "VideoView";
        this.mWaitingAudioID = -1;
        this.mCurrentState = 0;
        this.mTargetState = 0;
        this.mSurfaceHolder = null;
        this.mMediaPlayer = null;
        this.mSizeChangedListener = new C04401();
        this.mPreparedListener = new C04412();
        this.mCompletionListener = new C04423();
        this.mErrorListener = new C04444();
        this.mBufferingUpdateListener = new C04455();
        this.mSHCallback = new C04466();
        this.mContext = context;
        initVideoView();
    }

    public FoVideoView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
        this.mContext = context;
        initVideoView();
    }

    public FoVideoView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.TAG = "VideoView";
        this.mWaitingAudioID = -1;
        this.mCurrentState = 0;
        this.mTargetState = 0;
        this.mSurfaceHolder = null;
        this.mMediaPlayer = null;
        this.mSizeChangedListener = new C04401();
        this.mPreparedListener = new C04412();
        this.mCompletionListener = new C04423();
        this.mErrorListener = new C04444();
        this.mBufferingUpdateListener = new C04455();
        this.mSHCallback = new C04466();
        this.mContext = context;
        initVideoView();
    }

    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int width = getDefaultSize(this.mVideoWidth, widthMeasureSpec);
        int height = getDefaultSize(this.mVideoHeight, heightMeasureSpec);
        if (this.mVideoWidth > 0 && this.mVideoHeight > 0) {
            if (this.mVideoWidth * height > this.mVideoHeight * width) {
                height = (this.mVideoHeight * width) / this.mVideoWidth;
            } else if (this.mVideoWidth * height < this.mVideoHeight * width) {
                width = (this.mVideoWidth * height) / this.mVideoHeight;
            }
        }
        setMeasuredDimension(width, height);
    }

    public int resolveAdjustedSize(int desiredSize, int measureSpec) {
        int result = desiredSize;
        int specMode = MeasureSpec.getMode(measureSpec);
        int specSize = MeasureSpec.getSize(measureSpec);
        switch (specMode) {
            case Integer.MIN_VALUE:
                return Math.min(desiredSize, specSize);
            case 0:
                return desiredSize;
            case 1073741824:
                return specSize;
            default:
                return result;
        }
    }

    private void initVideoView() {
        this.mVideoWidth = 0;
        this.mVideoHeight = 0;
        getHolder().addCallback(this.mSHCallback);
        getHolder().setType(3);
        setFocusable(true);
        setFocusableInTouchMode(true);
        requestFocus();
        this.mCurrentState = 0;
        this.mTargetState = 0;
    }

    public void setVideoPath(String path) {
        Log.i("FoVideoView", "Setting Path");
        setVideoURI(Uri.parse(path));
    }

    public void setVideoURI(Uri uri) {
        setVideoURI(uri, null);
    }

    public void setVideoURI(Uri uri, Map<String, String> headers) {
        this.mUri = uri;
        this.mHeaders = headers;
        this.mSeekWhenPrepared = 0;
        openVideo();
        requestLayout();
        invalidate();
    }

    public void stopPlayback() {
        if (this.mMediaPlayer != null) {
            this.mMediaPlayer.pause();
            this.mMediaPlayer.stop();
            this.mMediaPlayer.release();
            this.mMediaPlayer = null;
            this.mCurrentState = 0;
            this.mTargetState = 0;
        }
    }

    private void openVideo() {
        if (this.mUri != null && this.mSurfaceHolder != null) {
            Intent i = new Intent("com.android.music.musicservicecommand");
            i.putExtra("command", "pause");
            this.mContext.sendBroadcast(i);
            release(false);
            try {
                this.mMediaPlayer = new MediaPlayer();
                this.mMediaPlayer.setOnPreparedListener(this.mPreparedListener);
                this.mMediaPlayer.setOnVideoSizeChangedListener(this.mSizeChangedListener);
                this.mDuration = -1;
                this.mMediaPlayer.setOnCompletionListener(this.mCompletionListener);
                this.mMediaPlayer.setOnErrorListener(this.mErrorListener);
                this.mMediaPlayer.setOnBufferingUpdateListener(this.mBufferingUpdateListener);
                this.mCurrentBufferPercentage = 0;
                if (this.mWaitingAudioID != -1 && VERSION.SDK_INT >= 9) {
                    this.mMediaPlayer.setAudioSessionId(this.mWaitingAudioID);
                }
                this.mMediaPlayer.setDataSource(this.mContext, this.mUri);
                this.mMediaPlayer.setDisplay(this.mSurfaceHolder);
                this.mMediaPlayer.setAudioStreamType(3);
                this.mMediaPlayer.setScreenOnWhilePlaying(true);
                this.mMediaPlayer.prepareAsync();
                this.mCurrentState = 1;
                attachMediaController();
            } catch (IOException ex) {
                Log.w(this.TAG, "Unable to open content: " + this.mUri, ex);
                this.mCurrentState = -1;
                this.mTargetState = -1;
                this.mErrorListener.onError(this.mMediaPlayer, 1, 0);
            } catch (IllegalArgumentException ex2) {
                Log.w(this.TAG, "Unable to open content: " + this.mUri, ex2);
                this.mCurrentState = -1;
                this.mTargetState = -1;
                this.mErrorListener.onError(this.mMediaPlayer, 1, 0);
            }
        }
    }

    public void setMediaController(MediaController controller) {
        if (this.mMediaController != null) {
            this.mMediaController.hide();
        }
        this.mMediaController = controller;
        attachMediaController();
    }

    private void attachMediaController() {
        if (this.mMediaPlayer != null && this.mMediaController != null) {
            this.mMediaController.setMediaPlayer(this);
            this.mMediaController.setAnchorView(getParent() instanceof View ? (View) getParent() : this);
            this.mMediaController.setEnabled(isInPlaybackState());
        }
    }

    public void setOnPreparedListener(OnPreparedListener l) {
        this.mOnPreparedListener = l;
    }

    public void setOnCompletionListener(OnCompletionListener l) {
        this.mOnCompletionListener = l;
    }

    public void setOnErrorListener(OnErrorListener l) {
        this.mOnErrorListener = l;
    }

    private void release(boolean cleartargetstate) {
        if (this.mMediaPlayer != null) {
            this.mMediaPlayer.reset();
            this.mMediaPlayer.release();
            this.mMediaPlayer = null;
            this.mCurrentState = 0;
            if (cleartargetstate) {
                this.mTargetState = 0;
            }
        }
    }

    public boolean onTouchEvent(MotionEvent ev) {
        if (isInPlaybackState() && this.mMediaController != null) {
            toggleMediaControlsVisiblity();
        }
        return false;
    }

    public boolean onTrackballEvent(MotionEvent ev) {
        if (isInPlaybackState() && this.mMediaController != null) {
            toggleMediaControlsVisiblity();
        }
        return false;
    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        boolean isKeyCodeSupported = (keyCode == 4 || keyCode == 24 || keyCode == 25 || keyCode == 82 || keyCode == 5 || keyCode == 6) ? false : true;
        if (isInPlaybackState() && isKeyCodeSupported && this.mMediaController != null) {
            if (keyCode == 79 || keyCode == 85) {
                if (this.mMediaPlayer.isPlaying()) {
                    pause();
                    this.mMediaController.show();
                    return true;
                }
                start();
                this.mMediaController.hide();
                return true;
            } else if (keyCode == 86 && this.mMediaPlayer.isPlaying()) {
                pause();
                this.mMediaController.show();
            } else {
                toggleMediaControlsVisiblity();
            }
        }
        return super.onKeyDown(keyCode, event);
    }

    private void toggleMediaControlsVisiblity() {
        if (this.mMediaController.isShowing()) {
            this.mMediaController.hide();
        } else {
            this.mMediaController.show();
        }
    }

    public void start() {
        Log.i("FoVideoView", "Attempting Playback");
        if (isInPlaybackState()) {
            this.mMediaPlayer.start();
            this.mCurrentState = 3;
        }
        this.mTargetState = 3;
    }

    public void pause() {
        if (isInPlaybackState() && this.mMediaPlayer.isPlaying()) {
            this.mMediaPlayer.pause();
            this.mCurrentState = 4;
        }
        this.mTargetState = 4;
    }

    public void suspend() {
        if (isInPlaybackState()) {
            this.mMediaPlayer.stop();
            this.mStateWhenSuspended = this.mCurrentState;
            this.mCurrentState = 6;
            this.mTargetState = 6;
        }
    }

    public void resume() {
        if (this.mSurfaceHolder == null && this.mCurrentState == 6) {
            this.mTargetState = 7;
        } else if (this.mMediaPlayer != null && this.mCurrentState == 6) {
            this.mMediaPlayer.start();
            this.mCurrentState = this.mStateWhenSuspended;
            this.mTargetState = this.mStateWhenSuspended;
        } else if (this.mCurrentState == 8) {
            openVideo();
        }
    }

    public int getDuration() {
        if (!isInPlaybackState()) {
            this.mDuration = -1;
            return this.mDuration;
        } else if (this.mDuration > 0) {
            return this.mDuration;
        } else {
            this.mDuration = this.mMediaPlayer.getDuration();
            return this.mDuration;
        }
    }

    public int getCurrentPosition() {
        if (isInPlaybackState()) {
            return this.mMediaPlayer.getCurrentPosition();
        }
        return 0;
    }

    public int getAudioSessionID() {
        if (this.mMediaPlayer == null || VERSION.SDK_INT < 9) {
            return -1;
        }
        return this.mMediaPlayer.getAudioSessionId();
    }

    public void setAudioSessionID(int iAudioID) {
        this.mWaitingAudioID = iAudioID;
    }

    public void seekTo(int msec) {
        if (isInPlaybackState()) {
            this.mMediaPlayer.seekTo(msec);
            this.mSeekWhenPrepared = 0;
            return;
        }
        this.mSeekWhenPrepared = msec;
    }

    public boolean isPlaying() {
        return isInPlaybackState() && this.mMediaPlayer.isPlaying();
    }

    public int getBufferPercentage() {
        if (this.mMediaPlayer != null) {
            return this.mCurrentBufferPercentage;
        }
        return 0;
    }

    private boolean isInPlaybackState() {
        return (this.mMediaPlayer == null || this.mCurrentState == -1 || this.mCurrentState == 0 || this.mCurrentState == 1) ? false : true;
    }

    public boolean canPause() {
        return this.mCanPause;
    }

    public boolean canSeekBackward() {
        return this.mCanSeekBack;
    }

    public boolean canSeekForward() {
        return this.mCanSeekForward;
    }
}
