package com.miui.player.ui.view;

import android.content.Context;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnErrorListener;
import android.net.Uri;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.view.View.MeasureSpec;
import java.io.IOException;

public class AsyncVideoView extends SurfaceView {
    static final int MSG_INIT = 1;
    static final int MSG_RELEASE = 2;
    static final String TAG = "AsyncVideoView";
    private final Handler mAsyncHandler;
    private final HandlerThread mAsyncThread;
    private int mFixedHeight;
    private int mFixedWidth;
    private OnErrorListener mOnErrorListener;
    private OnErrorListener mOnErrorListenerProxy;
    private MediaPlayer mPlayer;
    private final Callback mSHCallback;
    private SurfaceHolder mSurfaceHolder;
    private Uri mVideoUri;

    class C05211 implements OnErrorListener {
        C05211() {
        }

        public boolean onError(MediaPlayer mp, int what, int extra) {
            AsyncVideoView.this.sendMessage(2);
            if (AsyncVideoView.this.mOnErrorListener != null) {
                return AsyncVideoView.this.mOnErrorListener.onError(mp, what, extra);
            }
            return true;
        }
    }

    class C05222 implements Callback {
        C05222() {
        }

        public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
            Log.d(AsyncVideoView.TAG, "surfaceChanged");
        }

        public void surfaceCreated(SurfaceHolder holder) {
            AsyncVideoView.this.mSurfaceHolder = holder;
            holder.setFixedSize(AsyncVideoView.this.mFixedWidth, AsyncVideoView.this.mFixedHeight);
            AsyncVideoView.this.sendMessage(1);
        }

        public void surfaceDestroyed(SurfaceHolder holder) {
            AsyncVideoView.this.mSurfaceHolder = null;
            AsyncVideoView.this.sendMessage(2);
        }
    }

    private class AsyncHandler extends Handler {
        public AsyncHandler(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1:
                    AsyncVideoView.this.openInBackground();
                    return;
                case 2:
                    AsyncVideoView.this.releaseInBackground();
                    return;
                default:
                    return;
            }
        }
    }

    public AsyncVideoView(Context context) {
        this(context, null);
    }

    public AsyncVideoView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public AsyncVideoView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.mSurfaceHolder = null;
        this.mOnErrorListenerProxy = new C05211();
        this.mSHCallback = new C05222();
        getHolder().addCallback(this.mSHCallback);
        this.mAsyncThread = new HandlerThread(TAG + this);
        this.mAsyncThread.start();
        this.mAsyncHandler = new AsyncHandler(this.mAsyncThread.getLooper());
        setFocusable(true);
        setFocusableInTouchMode(true);
        requestFocus();
    }

    public void setOnErrorListener(OnErrorListener l) {
        this.mOnErrorListener = l;
    }

    public boolean isPlaying() {
        return this.mPlayer != null;
    }

    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(MeasureSpec.makeMeasureSpec(this.mFixedWidth, 1073741824), MeasureSpec.makeMeasureSpec(this.mFixedHeight, 1073741824));
    }

    public void setFixedSize(int width, int height) {
        this.mFixedWidth = width;
        this.mFixedHeight = height;
        if (this.mSurfaceHolder != null) {
            this.mSurfaceHolder.setFixedSize(this.mFixedWidth, this.mFixedHeight);
        }
        requestLayout();
    }

    public void setVideoPath(String path) {
        if (path == null) {
            this.mVideoUri = null;
        } else {
            this.mVideoUri = Uri.parse(path);
        }
        sendMessage(1);
    }

    public void release() {
        sendMessage(2);
    }

    private void sendMessage(int msg) {
        this.mAsyncHandler.removeMessages(1);
        this.mAsyncHandler.removeMessages(2);
        this.mAsyncHandler.sendEmptyMessage(msg);
    }

    void releaseInBackground() {
        if (this.mPlayer != null) {
            this.mPlayer.release();
            this.mPlayer = null;
        }
    }

    void openInBackground() {
        Uri uri = this.mVideoUri;
        SurfaceHolder holder = this.mSurfaceHolder;
        if (uri != null && holder != null) {
            releaseInBackground();
            MediaPlayer player = new MediaPlayer();
            try {
                player.setOnErrorListener(this.mOnErrorListenerProxy);
                player.setDataSource(getContext(), uri, null);
                player.setLooping(true);
                player.setDisplay(holder);
                player.setAudioStreamType(3);
                player.setScreenOnWhilePlaying(false);
                player.prepare();
                player.start();
                this.mPlayer = player;
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            } catch (SecurityException e2) {
                e2.printStackTrace();
            } catch (IllegalStateException e3) {
                e3.printStackTrace();
            } catch (IOException e4) {
                e4.printStackTrace();
            }
        }
    }
}
