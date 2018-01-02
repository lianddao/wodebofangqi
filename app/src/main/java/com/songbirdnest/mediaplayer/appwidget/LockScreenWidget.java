package com.songbirdnest.mediaplayer.appwidget;

import android.app.Activity;
import android.app.WallpaperManager;
import android.graphics.Bitmap;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.os.RemoteException;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.SlidingDrawer.OnDrawerCloseListener;
import com.songbirdnest.analytics.Analytics;
import com.songbirdnest.facebook.FacebookAPI;
import com.songbirdnest.mediaplayer.C0116R;
import com.songbirdnest.mediaplayer.SongbirdApplication;
import com.songbirdnest.mediaplayer.Utils;
import com.songbirdnest.mediaplayer.activities.ActivityOrientationHelper;
import com.songbirdnest.mediaplayer.service.IMediaEventCallback.Stub;
import com.songbirdnest.mediaplayer.service.IMediaServiceBinder;
import com.songbirdnest.mediaplayer.service.IPhotoStreamCallback;
import com.songbirdnest.mediaplayer.service.SongbirdMediaService;
import com.songbirdnest.mediaplayer.widgets.AnimationImage;
import com.songbirdnest.mediaplayer.widgets.MarqueeTextView;
import com.songbirdnest.mediaplayer.widgets.MiniSeekBar;
import com.songbirdnest.mediaplayer.widgets.Photostream;
import com.songbirdnest.mediaplayer.widgets.SlidingDrawer;
import com.songbirdnest.util.CheckLock;
import com.songbirdnest.util.ClickRunner;
import com.songbirdnest.util.EmptyClick;
import com.songbirdnest.util.HoldRunner;
import com.songbirdnest.util.ScrubberTouch;

public class LockScreenWidget extends Activity implements IMediaServiceBinder {
    private static final int RELEASE_SCREEN_WAKE_LOCK_DELAY = 8000;
    private static final int SEEKBAR_UPDATE_INTERVAL = 500;
    private static final int WINDOW_FLAGS = 4718848;
    private static final int WINDOW_TYPE = 2009;
    private static final int[] sAllowedKeys = new int[]{79, 24, 25, 87, 88, 85};
    private MarqueeTextView mArtistAlbumName = null;
    private final Stub mCallback = new C01592();
    private SlidingDrawer mDrawer = null;
    private final Handler mHandler = new Handler();
    private ImageView mNextButton = null;
    ScrubberTouch mNextTouch;
    private ActivityOrientationHelper mOrientationHelper;
    private Photostream mPhotostream = null;
    private PhotostreamAdapter mPhotostreamAdapter = null;
    private ImageView mPlayButton = null;
    private PowerManager mPowerManager = null;
    private ImageView mPreviousButton = null;
    ScrubberTouch mPreviousTouch;
    private WakeLock mScreenWakeLock = null;
    private final String mScreenWakeLockTag = "LockScreenWidget";
    private MiniSeekBar mSeekBar = null;
    private SongbirdMediaService mService = null;
    private MarqueeTextView mSongName = null;
    private final Runnable mUpdateSeekBarRunnable = new C01571();

    class C01571 implements Runnable {
        C01571() {
        }

        public void run() {
            if (LockScreenWidget.this.mService != null) {
                try {
                    LockScreenWidget.this.mSeekBar.setProgress(LockScreenWidget.this.mService.position());
                } catch (RemoteException e) {
                }
            }
            LockScreenWidget.this.mHandler.postDelayed(LockScreenWidget.this.mUpdateSeekBarRunnable, 500);
        }
    }

    class C01592 extends Stub {
        C01592() {
        }

        public void onMediaMessage(final int aEvent) throws RemoteException {
            LockScreenWidget.this.mHandler.post(new Runnable() {
                public void run() {
                    LockScreenWidget.this.onMediaMessage(aEvent);
                }
            });
        }
    }

    class C01603 implements OnDrawerCloseListener {
        C01603() {
        }

        public void onDrawerClosed() {
            LockScreenWidget.this.dismissLockScreenWidget();
        }
    }

    class C01614 implements CheckLock {
        C01614() {
        }

        public void unlock() {
            try {
                LockScreenWidget.this.mService.pause();
            } catch (RemoteException ex) {
                ex.printStackTrace();
            }
        }

        public boolean needsLock() {
            try {
                if (LockScreenWidget.this.mService.isPlaying()) {
                    return false;
                }
                return true;
            } catch (RemoteException ex) {
                ex.printStackTrace();
                return false;
            }
        }

        public void lock() {
            try {
                LockScreenWidget.this.mService.play();
            } catch (RemoteException ex) {
                ex.printStackTrace();
            }
        }
    }

    class C01625 implements ClickRunner {
        C01625() {
        }

        public void run() {
            LockScreenWidget.this.doPrevious();
        }
    }

    class C01636 implements OnClickListener {
        C01636() {
        }

        public void onClick(View v) {
            LockScreenWidget.this.doPlayPause();
        }
    }

    class C01647 implements ClickRunner {
        C01647() {
        }

        public void run() {
            LockScreenWidget.this.doNext();
        }
    }

    class PhotostreamAdapter extends BaseAdapter {
        AnimationImage mCurrentImage = null;

        class C01661 extends IPhotoStreamCallback.Stub {
            C01661() {
            }

            public void imageDone(final Bitmap aBitmap) throws RemoteException {
                LockScreenWidget.this.mHandler.post(new Runnable() {
                    public void run() {
                        if (PhotostreamAdapter.this.mCurrentImage != null) {
                            int[] size = new int[]{LockScreenWidget.this.mPhotostream.getWidth(), LockScreenWidget.this.mPhotostream.getHeight()};
                            if (LockScreenWidget.this.mPhotostream.getWidth() > 20 && LockScreenWidget.this.mPhotostream.getHeight() > 20) {
                                size[0] = LockScreenWidget.this.mPhotostream.getWidth() - 20;
                                size[1] = LockScreenWidget.this.mPhotostream.getHeight() - 20;
                            }
                            retValues = new int[2];
                            retValues = Utils.calcAspectRatio(new int[]{aBitmap.getWidth(), aBitmap.getHeight()}, size);
                            PhotostreamAdapter.this.mCurrentImage.setImageBitmap(Bitmap.createScaledBitmap(aBitmap, retValues[0], retValues[1], true));
                            PhotostreamAdapter.this.mCurrentImage.setBackgroundResource(C0116R.drawable.art_background2);
                            PhotostreamAdapter.this.mCurrentImage.setPadding(5, 5, 5, 5);
                            LockScreenWidget.this.mPhotostreamAdapter.notifyDataSetChanged();
                        }
                    }
                });
            }
        }

        public void invalidate() {
            this.mCurrentImage = null;
        }

        public int getCount() {
            return 1;
        }

        public Object getItem(int position) {
            return null;
        }

        public long getItemId(int position) {
            return 0;
        }

        public View getView(final int aPosition, View aConvertView, ViewGroup aParent) {
            if (this.mCurrentImage != null) {
                return this.mCurrentImage;
            }
            AnimationImage loadAnimation = new AnimationImage(LockScreenWidget.this);
            loadAnimation.setBackgroundResource(C0116R.drawable.holdershape);
            loadAnimation.setScaleType(ScaleType.CENTER_INSIDE);
            AnimationDrawable spinnerAnimation = (AnimationDrawable) LockScreenWidget.this.getResources().getDrawable(C0116R.drawable.spinner);
            loadAnimation.setImageDrawable(spinnerAnimation);
            loadAnimation.setAnimation(spinnerAnimation);
            this.mCurrentImage = loadAnimation;
            final IPhotoStreamCallback.Stub photoCallback = new C01661();
            LockScreenWidget.this.mHandler.post(new Runnable() {
                public void run() {
                    try {
                        LockScreenWidget.this.mService.getPhotoImage(photoCallback, aPosition);
                    } catch (RemoteException e) {
                    }
                }
            });
            return this.mCurrentImage;
        }
    }

    class SkipHolder implements HoldRunner {
        int mSkipValue;

        public SkipHolder(int pSkipValue) {
            this.mSkipValue = pSkipValue;
        }

        public void run() {
            try {
                LockScreenWidget.this.mService.seek(LockScreenWidget.this.mService.position() + this.mSkipValue);
            } catch (RemoteException ex) {
                ex.printStackTrace();
            }
        }
    }

    protected void onCreate(Bundle aSavedInstanceState) {
        super.onCreate(aSavedInstanceState);
        setOnTop();
        WallpaperManager wallpaperManager = WallpaperManager.getInstance(this);
        if (wallpaperManager != null) {
            getWindow().setBackgroundDrawable(wallpaperManager.getFastDrawable());
        }
        setContentView(C0116R.layout.lock_screen_appwidget);
        this.mDrawer = (SlidingDrawer) findViewById(C0116R.id.lockscreen_sliding_drawer);
        this.mDrawer.setOnDrawerCloseListener(new C01603());
        this.mPhotostream = (Photostream) findViewById(C0116R.id.lockscreen_album_art);
        this.mPhotostreamAdapter = new PhotostreamAdapter();
        this.mArtistAlbumName = (MarqueeTextView) findViewById(C0116R.id.lockscreen_artist_album_name);
        this.mSongName = (MarqueeTextView) findViewById(C0116R.id.lockscreen_song_name);
        this.mSeekBar = (MiniSeekBar) findViewById(C0116R.id.lockscreen_seekbar);
        CheckLock aLock = new C01614();
        this.mPreviousTouch = new ScrubberTouch(new C01625(), aLock, new SkipHolder(-2000), new SkipHolder(-3000), new SkipHolder(-5000), new SkipHolder(-8000), new SkipHolder(-13000), new SkipHolder(-21000), new SkipHolder(-34000));
        this.mPreviousButton = (ImageView) findViewById(C0116R.id.lockscreen_previous_song);
        this.mPreviousButton.setOnClickListener(new EmptyClick());
        this.mPreviousButton.setOnTouchListener(this.mPreviousTouch);
        this.mPlayButton = (ImageView) findViewById(C0116R.id.lockscreen_pause_button);
        this.mPlayButton.setOnClickListener(new C01636());
        this.mNextButton = (ImageView) findViewById(C0116R.id.lockscreen_next_song);
        this.mNextTouch = new ScrubberTouch(new C01647(), aLock, new SkipHolder(FacebookAPI.FACEBOOK_AUTHORIZE_RESULT_CODE), new SkipHolder(3000), new SkipHolder(5000), new SkipHolder(RELEASE_SCREEN_WAKE_LOCK_DELAY), new SkipHolder(13000), new SkipHolder(21000), new SkipHolder(34000));
        this.mNextButton.setOnClickListener(new EmptyClick());
        this.mNextButton.setOnTouchListener(this.mNextTouch);
        this.mDrawer.open();
        ((SongbirdApplication) getApplicationContext()).getMediaService(this);
        this.mPhotostream.setAdapter(this.mPhotostreamAdapter);
        this.mPowerManager = (PowerManager) getSystemService("power");
        this.mOrientationHelper = new ActivityOrientationHelper(this);
    }

    protected void onResume() {
        super.onResume();
        this.mOrientationHelper.onResume();
        if (this.mService != null) {
            boolean isPlaying = false;
            try {
                isPlaying = this.mService.isPlaying();
            } catch (Exception e) {
            }
            if (isPlaying) {
                this.mHandler.postDelayed(this.mUpdateSeekBarRunnable, 0);
            }
        }
        this.mScreenWakeLock = this.mPowerManager.newWakeLock(10, "LockScreenWidget");
        this.mScreenWakeLock.acquire(8000);
        Analytics.getAnalytics().track(Analytics.EVENT_LOCK_SCREEN);
    }

    protected void onPause() {
        super.onPause();
        this.mOrientationHelper.onPause();
        this.mHandler.removeCallbacks(this.mUpdateSeekBarRunnable);
        this.mPreviousTouch.stopHopping();
        this.mNextTouch.stopHopping();
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.mService != null) {
            try {
                this.mService.unregisterCallback(this.mCallback);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public boolean onKeyDown(int aKeyCode, KeyEvent aEvent) {
        for (int allowedKeyCode : sAllowedKeys) {
            if (allowedKeyCode == aKeyCode) {
                return super.onKeyDown(aKeyCode, aEvent);
            }
        }
        return true;
    }

    public boolean onKeyUp(int aKeyCode, KeyEvent aEvent) {
        if (aKeyCode == 24 || aKeyCode == 25) {
            return super.onKeyUp(aKeyCode, aEvent);
        }
        return true;
    }

    public void onMediaServiceConnected(SongbirdMediaService aMediaService) {
        this.mService = aMediaService;
        try {
            this.mService.registerCallback(this.mCallback);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    private void onMediaMessage(int aEvent) {
        switch (aEvent) {
            case 1:
                updatePlayPause(false);
                this.mHandler.removeCallbacks(this.mUpdateSeekBarRunnable);
                return;
            case 2:
                updatePlayPause(true);
                this.mHandler.postDelayed(this.mUpdateSeekBarRunnable, 500);
                return;
            case 3:
                this.mNextTouch.stopHopping();
                this.mPreviousTouch.stopHopping();
                updatePlayPause(false);
                resetSeekBar();
                return;
            case 4:
                this.mNextTouch.stopHopping();
                this.mPreviousTouch.stopHopping();
                updateMetadata();
                updateSeekBar();
                updateAlbumArt();
                return;
            default:
                return;
        }
    }

    private void dismissLockScreenWidget() {
        finish();
    }

    private void setOnTop() {
        Window window = getWindow();
        window.setType(WINDOW_TYPE);
        window.setFlags(WINDOW_FLAGS, WINDOW_FLAGS);
    }

    private void doPlayPause() {
        if (this.mService != null) {
            try {
                if (this.mService.isPlaying()) {
                    this.mService.pause();
                } else {
                    this.mService.play();
                }
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    private void doPrevious() {
        if (this.mService != null) {
            try {
                this.mService.prev();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    private void doNext() {
        if (this.mService != null) {
            try {
                this.mService.next();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    private void updateAlbumArt() {
        this.mPhotostreamAdapter.invalidate();
        this.mPhotostreamAdapter.notifyDataSetChanged();
        this.mPhotostream.setSelection(0);
    }

    private void updatePlayPause(boolean aPlaying) {
        if (aPlaying) {
            this.mPlayButton.setBackgroundResource(C0116R.drawable.pause_button);
        } else {
            this.mPlayButton.setBackgroundResource(C0116R.drawable.play_button);
        }
    }

    private void updateMetadata() {
        if (this.mService != null) {
            String albumName = null;
            String artistName = null;
            String songName = null;
            try {
                albumName = this.mService.getAlbumName();
            } catch (RemoteException e) {
            }
            if (albumName == null) {
                albumName = getString(C0116R.string.unknown);
            }
            try {
                artistName = this.mService.getArtistName();
            } catch (RemoteException e2) {
            }
            if (artistName == null) {
                artistName = getString(C0116R.string.unknown);
            }
            try {
                songName = this.mService.getTrackName();
            } catch (RemoteException e3) {
            }
            if (songName == null) {
                songName = getString(C0116R.string.unknown);
            }
            this.mSongName.setText(songName);
            this.mArtistAlbumName.setText(artistName + " " + getString(C0116R.string.artist_song_separator) + " " + albumName);
        }
    }

    private void updateSeekBar() {
        if (this.mService != null) {
            try {
                this.mSeekBar.setMax(this.mService.duration());
            } catch (RemoteException e) {
            }
        }
    }

    private void resetSeekBar() {
        this.mSeekBar.setProgress(0);
        this.mSeekBar.setMax(0);
    }
}
