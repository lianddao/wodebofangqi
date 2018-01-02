package com.miui.player.ui.controller;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnErrorListener;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.widget.ImageView;
import com.miui.player.C0329R;
import com.miui.player.service.ShakeListener;
import com.miui.player.ui.view.AsyncVideoView;
import com.miui.player.util.BitmapHelper;
import java.io.File;
import java.lang.ref.WeakReference;

public class AlbumBackground implements OnErrorListener {
    private static final int MSG_SET_IMAGE_DEFAULT = 1;
    static final String TAG = "AlbumBackground";
    public static int TYPE_VIDEO_LARGE = 1;
    public static int TYPE_VIDEO_SMALL = 2;
    private static final String VIDEO_LARGE_PATH = "/system/media/video/.music/video_large_720p.mp4";
    private static final String VIDEO_SMALL_PATH = "/system/media/video/.music/video_small_720p.mp4";
    private final int mAlbumHeight;
    private final int mAlbumWidth;
    private Animator mAnimator;
    private final View mContainer;
    final Context mContext;
    private FadeAnimatorListener mFadeAnimatorListener;
    private final Handler mHandler = new C04791();
    private final ImageView mImageAlbum1;
    private final ImageView mImageAlbum2;
    private ImageView mImageCurrent;
    private ImageView mImageDefault;
    private final ViewStub mImageDefaultStub;
    boolean mResumed = false;
    private float mTranslateX;
    private float mTranslateY;
    private String mVideoPath;
    private final int mVideoStubId;
    private WeakReference<Drawable> mVideoStubRef;
    private boolean mVideoStubVisible = false;
    private AsyncVideoView mVideoView;
    private final ViewStub mVideoViewStub;

    class C04791 extends Handler {
        C04791() {
        }

        public void handleMessage(Message msg) {
            boolean z = true;
            switch (msg.what) {
                case 1:
                    AlbumBackground albumBackground = AlbumBackground.this;
                    if (msg.arg1 != 1) {
                        z = false;
                    }
                    albumBackground.setImageDefaultVisibleInMain(z);
                    return;
                default:
                    return;
            }
        }
    }

    class FadeAnimatorListener implements AnimatorUpdateListener, AnimatorListener {
        private ImageView mFadeInView;
        private ImageView mFadeOutView;

        FadeAnimatorListener() {
        }

        public void setAnimationView(ImageView fadeIn, ImageView fadeOut) {
            this.mFadeInView = fadeIn;
            this.mFadeOutView = fadeOut;
        }

        public void onAnimationUpdate(ValueAnimator animation) {
            if (AlbumBackground.this.mResumed) {
                float percent = animation.getAnimatedFraction();
                if (this.mFadeInView != null) {
                    this.mFadeInView.setAlpha(percent);
                }
                if (this.mFadeOutView != null) {
                    this.mFadeOutView.setAlpha(ShakeListener.ACCELATION_FACTOR_X - percent);
                }
            }
        }

        public void onAnimationCancel(Animator animation) {
            reset();
        }

        public void onAnimationEnd(Animator animation) {
            reset();
        }

        public void onAnimationRepeat(Animator animation) {
        }

        public void onAnimationStart(Animator animation) {
            if (this.mFadeInView != null) {
                this.mFadeInView.setVisibility(0);
            }
            if (this.mFadeOutView != null) {
                this.mFadeOutView.setVisibility(0);
            }
        }

        public void reset() {
            if (!AlbumBackground.this.mResumed) {
                return;
            }
            if (this.mFadeOutView != null || this.mFadeInView != null) {
                if (this.mFadeInView != null) {
                    this.mFadeInView.setVisibility(0);
                    this.mFadeInView.setAlpha(ShakeListener.ACCELATION_FACTOR_X);
                    this.mFadeInView = null;
                }
                if (this.mFadeOutView != null) {
                    if (this.mFadeOutView.getDrawable() != AlbumBackground.this.getDefaultDrawable(false)) {
                        BitmapHelper.recycleImageView(this.mFadeOutView, null);
                    }
                    this.mFadeOutView.setVisibility(4);
                    this.mFadeOutView.setAlpha(ShakeListener.ACCELATION_FACTOR_X);
                    this.mFadeOutView = null;
                    return;
                }
                AlbumBackground.this.setVideoVisible(false);
            }
        }
    }

    public static AlbumBackground createForNoVideo(View container, int videoStubId) {
        Drawable videoStub = container.getResources().getDrawable(videoStubId);
        return new AlbumBackground(container, videoStub.getIntrinsicWidth(), videoStub.getIntrinsicHeight(), videoStubId, null);
    }

    public static AlbumBackground createByType(View container, int type) {
        int w;
        int h;
        String videoPath;
        int videoStubId;
        Resources res = container.getResources();
        if (type == TYPE_VIDEO_LARGE) {
            w = res.getDimensionPixelSize(C0329R.dimen.nowplaying_video_width);
            h = res.getDimensionPixelSize(C0329R.dimen.nowplaying_video_height);
            videoPath = VIDEO_LARGE_PATH;
            videoStubId = C0329R.drawable.video_stub_large;
        } else {
            w = res.getDimensionPixelSize(C0329R.dimen.mainpage_video_width);
            h = res.getDimensionPixelSize(C0329R.dimen.mainpage_video_height);
            videoPath = VIDEO_SMALL_PATH;
            videoStubId = C0329R.drawable.video_stub_small;
        }
        return new AlbumBackground(container, w, h, videoStubId, videoPath);
    }

    private AlbumBackground(View container, int w, int h, int videoStubId, String videoPath) {
        this.mContainer = container;
        this.mContext = container.getContext();
        this.mVideoViewStub = (ViewStub) container.findViewById(C0329R.id.video);
        this.mImageDefaultStub = (ViewStub) container.findViewById(C0329R.id.defaultAlbum);
        this.mImageAlbum1 = (ImageView) container.findViewById(C0329R.id.album1);
        this.mImageAlbum2 = (ImageView) container.findViewById(C0329R.id.album2);
        this.mVideoStubId = videoStubId;
        setViewSize(this.mImageAlbum1, w, h);
        setViewSize(this.mImageAlbum2, w, h);
        this.mAlbumWidth = w;
        this.mAlbumHeight = h;
        this.mVideoPath = videoPath;
        initImageCurrent();
    }

    Drawable getDefaultDrawable(boolean createIfNeeded) {
        Drawable d = null;
        if (this.mVideoStubRef != null) {
            d = (Drawable) this.mVideoStubRef.get();
        }
        if (d != null || !createIfNeeded) {
            return d;
        }
        d = this.mContext.getResources().getDrawable(this.mVideoStubId);
        this.mVideoStubRef = new WeakReference(d);
        return d;
    }

    private void setViewSize(View v, int w, int h) {
        LayoutParams lp = v.getLayoutParams();
        lp.width = w;
        lp.height = h;
        v.requestLayout();
    }

    private void initImageCurrent() {
        this.mImageCurrent = this.mImageAlbum1;
        this.mImageCurrent.setVisibility(0);
        this.mImageCurrent.setImageDrawable(getDefaultDrawable(true));
        this.mVideoStubVisible = true;
    }

    public int getWidth() {
        return this.mAlbumWidth;
    }

    public int getHeight() {
        return this.mAlbumHeight;
    }

    public void setBitmap(Bitmap bm) {
        if (bm != null) {
            setDrawable(new BitmapDrawable(this.mContext.getResources(), bm));
        } else {
            setDrawable(null);
        }
    }

    public void setDrawable(Drawable d) {
        long dur = (long) this.mContext.getResources().getInteger(C0329R.integer.anim_duration_normal);
        if (this.mVideoStubVisible && d == null) {
            dur *= 4;
        }
        setDrawableInternel(d, dur);
        this.mVideoStubVisible = false;
    }

    void setDrawableInternel(Drawable d, long duration) {
        if (this.mImageCurrent == null && d == null) {
            startVideo();
        } else if (this.mImageCurrent == null && d != null) {
            boolean isPlaying = this.mVideoView != null && this.mVideoView.isPlaying();
            pauseVideo();
            fadeIn = this.mImageAlbum1;
            this.mImageCurrent = fadeIn;
            fadeOut = null;
            if (!isPlaying) {
                fadeOut = this.mImageAlbum2;
                fadeOut.setImageDrawable(getDefaultDrawable(true));
            }
            getAnimator(fadeIn, fadeOut, duration).start();
        } else if (this.mImageCurrent == null || d != null) {
            pauseVideo();
            fadeOut = this.mImageCurrent;
            fadeIn = fadeOut != this.mImageAlbum1 ? this.mImageAlbum1 : this.mImageAlbum2;
            this.mImageCurrent = fadeIn;
            getAnimator(fadeIn, fadeOut, duration).start();
        } else {
            startVideo();
            fadeOut = this.mImageCurrent;
            this.mImageCurrent = null;
            getAnimator(null, fadeOut, duration).start();
        }
        if (this.mImageCurrent != null) {
            this.mImageCurrent.setImageDrawable(d);
        }
    }

    public void setTranslationX(float translationX) {
        this.mTranslateX = translationX;
        this.mImageAlbum1.setTranslationX(translationX);
        this.mImageAlbum2.setTranslationX(translationX);
        if (this.mVideoView != null) {
            this.mVideoView.setTranslationX(translationX);
        }
        if (this.mImageDefault != null) {
            this.mImageDefault.setTranslationX(translationX);
        }
    }

    public void setTranslationY(float translationY) {
        this.mTranslateY = translationY;
        this.mImageAlbum1.setTranslationY(translationY);
        this.mImageAlbum2.setTranslationY(translationY);
        if (this.mVideoView != null) {
            this.mVideoView.setTranslationY(translationY);
        }
        if (this.mImageDefault != null) {
            this.mImageDefault.setTranslationY(translationY);
        }
    }

    public void onResume() {
        this.mResumed = true;
        if (this.mFadeAnimatorListener != null) {
            this.mFadeAnimatorListener.reset();
        }
        if (this.mImageCurrent == null) {
            initImageCurrent();
            setDrawable(null);
        }
    }

    public void onPause() {
        this.mResumed = false;
        releaseVideo();
        if (this.mAnimator != null && this.mAnimator.isStarted()) {
            this.mAnimator.cancel();
        }
    }

    public void onDestroy() {
        releaseVideo();
        this.mImageAlbum1.setImageDrawable(null);
        this.mImageAlbum2.setImageDrawable(null);
    }

    private void setImageDefaultVisible(boolean visible, boolean direct) {
        this.mHandler.removeMessages(1);
        if (direct) {
            setImageDefaultVisibleInMain(true);
        } else {
            this.mHandler.sendMessage(Message.obtain(this.mHandler, 1, visible ? 1 : 0, 0));
        }
    }

    private void setImageDefaultVisibleInMain(boolean visible) {
        int i = 0;
        if (this.mImageDefault == null) {
            ViewStub viewStub = this.mImageDefaultStub;
            if (!visible) {
                i = 8;
            }
            viewStub.setVisibility(i);
            if (visible) {
                this.mImageDefault = (ImageView) this.mContainer.findViewById(this.mImageDefaultStub.getId());
                this.mImageDefault.setImageDrawable(getDefaultDrawable(true));
                this.mImageDefault.setTranslationX(this.mTranslateX);
                this.mImageDefault.setTranslationY(this.mTranslateY);
                setViewSize(this.mImageDefault, this.mAlbumWidth, this.mAlbumHeight);
            }
        } else if (visible) {
            this.mImageDefault.setVisibility(0);
            this.mImageDefault.setImageDrawable(getDefaultDrawable(true));
        } else {
            this.mImageDefault.setVisibility(8);
            this.mImageDefault.setImageDrawable(null);
        }
    }

    private void setVideoVisible(boolean visible) {
        int i = 8;
        if (this.mVideoView != null) {
            AsyncVideoView asyncVideoView = this.mVideoView;
            if (visible) {
                i = 0;
            }
            asyncVideoView.setVisibility(i);
            return;
        }
        ViewStub viewStub = this.mVideoViewStub;
        if (visible) {
            i = 0;
        }
        viewStub.setVisibility(i);
        if (visible) {
            this.mVideoView = (AsyncVideoView) this.mContainer.findViewById(this.mVideoViewStub.getId());
            this.mVideoView.setFocusable(false);
            this.mVideoView.setTranslationX(this.mTranslateX);
            this.mVideoView.setTranslationY(this.mTranslateY);
            this.mVideoView.setFixedSize(this.mAlbumWidth, this.mAlbumHeight);
        }
    }

    private boolean isShowVideo() {
        if (this.mVideoPath != null) {
            return new File(this.mVideoPath).exists();
        }
        return false;
    }

    private void startVideo() {
        if (isShowVideo()) {
            setVideoVisible(true);
            initVideo();
            return;
        }
        setImageDefaultVisible(true, true);
    }

    private void pauseVideo() {
        if (isShowVideo()) {
            releaseVideo();
        } else {
            setImageDefaultVisible(false, true);
        }
    }

    public boolean onError(MediaPlayer mp, int what, int extra) {
        setImageDefaultVisible(true, false);
        return true;
    }

    private Animator getAnimator(ImageView fadeIn, ImageView fadeOut, long duration) {
        if (this.mAnimator != null) {
            this.mAnimator.cancel();
        } else {
            ValueAnimator anim = ValueAnimator.ofFloat(new float[]{0.0f, ShakeListener.ACCELATION_FACTOR_X});
            this.mFadeAnimatorListener = new FadeAnimatorListener();
            anim.addListener(this.mFadeAnimatorListener);
            anim.addUpdateListener(this.mFadeAnimatorListener);
            this.mAnimator = anim;
        }
        this.mAnimator.setDuration(duration);
        this.mFadeAnimatorListener.setAnimationView(fadeIn, fadeOut);
        return this.mAnimator;
    }

    public boolean isVideoPlaying() {
        return this.mVideoView.isPlaying();
    }

    private void initVideo() {
        this.mVideoView.setOnErrorListener(this);
        this.mVideoView.setVideoPath(this.mVideoPath);
    }

    private void releaseVideo() {
        if (this.mVideoView != null) {
            this.mVideoView.release();
        }
    }
}
