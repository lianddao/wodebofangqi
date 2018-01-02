package com.songbirdnest.mediaplayer.view;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.RemoteException;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SlidingDrawer;
import android.widget.SlidingDrawer.OnDrawerCloseListener;
import android.widget.SlidingDrawer.OnDrawerOpenListener;
import android.widget.SlidingDrawer.OnDrawerScrollListener;
import com.songbirdnest.analytics.Analytics;
import com.songbirdnest.facebook.FacebookAPI;
import com.songbirdnest.mediaplayer.C0116R;
import com.songbirdnest.mediaplayer.PlayableItem;
import com.songbirdnest.mediaplayer.SongbirdApplication;
import com.songbirdnest.mediaplayer.Utils;
import com.songbirdnest.mediaplayer.layout.PlayButtonImageView;
import com.songbirdnest.mediaplayer.service.IMediaEventCallback.Stub;
import com.songbirdnest.mediaplayer.service.IMediaServiceBinder;
import com.songbirdnest.mediaplayer.service.SongbirdMediaService;
import com.songbirdnest.mediaplayer.viewInterface.Listener;
import com.songbirdnest.mediaplayer.widgets.MarqueeTextView;
import com.songbirdnest.mediaplayer.widgets.MiniSeekBar;
import com.songbirdnest.util.CheckLock;
import com.songbirdnest.util.ClickRunner;
import com.songbirdnest.util.EmptyClick;
import com.songbirdnest.util.HoldRunner;
import com.songbirdnest.util.Logger;
import com.songbirdnest.util.MediaUtils;
import com.songbirdnest.util.ScrubberTouch;
import java.util.HashMap;
import java.util.Map;

public class MiniPlayerAndroidImpl implements IMediaServiceBinder {
    protected static final int GUIUPDATE = 257;
    protected static final int SEEKBAR_UPDATE_INTERVAL = 500;
    private static MiniPlayerAndroidImpl gMiniPlayer = null;
    private ImageView backToListIcon;
    private Stub callback = new Stub() {
        public void onMediaMessage(int aEvent) throws RemoteException {
            final int event = aEvent;
            MiniPlayerAndroidImpl.this.mHandler.post(new Runnable() {
                public void run() {
                    if (MiniPlayerAndroidImpl.this.serviceConnected) {
                        switch (event) {
                            case 1:
                                try {
                                    MiniPlayerAndroidImpl.this.progressBar.setProgress(MiniPlayerAndroidImpl.this.mService.position());
                                } catch (RemoteException e) {
                                }
                                MiniPlayerAndroidImpl.this.playPauseButton.setPlaying(false);
                                return;
                            case 2:
                                MiniPlayerAndroidImpl.this.mHandler.removeCallbacks(MiniPlayerAndroidImpl.this.mUpdateSeekbarTask);
                                MiniPlayerAndroidImpl.this.mHandler.postDelayed(MiniPlayerAndroidImpl.this.mUpdateSeekbarTask, 500);
                                MiniPlayerAndroidImpl.this.playPauseButton.setPlaying(true);
                                return;
                            case 3:
                                MiniPlayerAndroidImpl.this.mNextTouch.stopHopping();
                                MiniPlayerAndroidImpl.this.mPreviousTouch.stopHopping();
                                MiniPlayerAndroidImpl.this.progressBar.setProgress(0);
                                MiniPlayerAndroidImpl.this.playPauseButton.setPlaying(false);
                                MiniPlayerAndroidImpl.this.updateFacebookLikedState(true);
                                return;
                            case 4:
                                if (MiniPlayerAndroidImpl.this.mNextTouch.isHopping()) {
                                    MiniPlayerAndroidImpl.this.mNextTouch.stopHopping();
                                }
                                if (MiniPlayerAndroidImpl.this.mPreviousTouch.isHopping()) {
                                    MiniPlayerAndroidImpl.this.mPreviousTouch.stopHopping();
                                }
                                MiniPlayerAndroidImpl.this.progressBar.setProgress(0);
                                try {
                                    MiniPlayerAndroidImpl.this.progressBar.setMax(MiniPlayerAndroidImpl.this.mService.duration());
                                    if (MiniPlayerAndroidImpl.this.mService.getTrackName() != null) {
                                        MiniPlayerAndroidImpl.this.setSongArtistText(MiniPlayerAndroidImpl.this.mService.getTrackName());
                                    }
                                } catch (RemoteException e2) {
                                }
                                MiniPlayerAndroidImpl.this.updateFacebookLikedState(false);
                                return;
                            case 5:
                                try {
                                    MiniPlayerAndroidImpl.this.progressBar.setProgress(MiniPlayerAndroidImpl.this.mService.position());
                                    return;
                                } catch (RemoteException e3) {
                                    return;
                                }
                            default:
                                return;
                        }
                    }
                }
            });
        }
    };
    private Listener closeListener;
    public int downClick;
    private ImageView facebookLikeButton;
    private Button facebookUnlikeButton;
    private Activity mActivity;
    private Handler mHandler = new Handler();
    ScrubberTouch mNextTouch;
    ScrubberTouch mPreviousTouch;
    private SongbirdMediaService mService;
    private Runnable mUpdateSeekbarTask = new Runnable() {
        public void run() {
            if (!MiniPlayerAndroidImpl.this.slider.isMoving() && !MiniPlayerAndroidImpl.this.slider.isOpened() && !MiniPlayerAndroidImpl.this.player.tracking) {
                int position;
                boolean isPlaying = false;
                try {
                    position = MiniPlayerAndroidImpl.this.mService.position();
                    isPlaying = MiniPlayerAndroidImpl.this.mService.isPlaying();
                } catch (Exception e) {
                    position = 0;
                }
                MiniPlayerAndroidImpl.this.progressBar.setProgress(position);
                if (isPlaying) {
                    MiniPlayerAndroidImpl.this.mHandler.postDelayed(this, 500);
                } else {
                    MiniPlayerAndroidImpl.this.mHandler.removeCallbacks(this);
                }
            }
        }
    };
    private View mainButtonTrayTop;
    private Handler movingHandler = new Handler() {
        public void handleMessage(Message msg) {
            if (MiniPlayerAndroidImpl.this.slider.isMoving()) {
                MiniPlayerAndroidImpl.this.backToListIcon.setVisibility(4);
                MiniPlayerAndroidImpl.this.facebookLikeButton.setVisibility(4);
                MiniPlayerAndroidImpl.this.songArtistLabel.setVisibility(4);
                MiniPlayerAndroidImpl.this.adjustDrawerForScreenOrientation();
                removeMessages(0);
                sendMessageDelayed(Message.obtain(MiniPlayerAndroidImpl.this.movingHandler, 0), 100);
            } else if (!MiniPlayerAndroidImpl.this.slider.isMoving() && !MiniPlayerAndroidImpl.this.slider.isOpened()) {
                MiniPlayerAndroidImpl.this.backToListIcon.setVisibility(0);
                MiniPlayerAndroidImpl.this.facebookLikeButton.setVisibility(0);
                MiniPlayerAndroidImpl.this.songArtistLabel.setVisibility(0);
                MiniPlayerAndroidImpl.this.mainButtonTrayTop.setVisibility(4);
            }
        }
    };
    private ImageView nextSongButton;
    private Listener openListener;
    private PlayButtonImageView playPauseButton;
    private PlayerViewImpl player;
    private ImageView previousSongButton;
    private MiniSeekBar progressBar;
    private volatile boolean serviceConnected = false;
    private SlidingDrawer slider;
    private MarqueeTextView songArtistLabel;

    class C02601 implements OnTouchListener {
        C02601() {
        }

        public boolean onTouch(View v, MotionEvent event) {
            return true;
        }
    }

    class C02612 implements ClickRunner {
        C02612() {
        }

        public void run() {
            MiniPlayerAndroidImpl.this.nextSong();
            MiniPlayerAndroidImpl.this.progressBar.setProgress(0);
        }
    }

    class C02623 implements CheckLock {
        C02623() {
        }

        public void unlock() {
            try {
                MiniPlayerAndroidImpl.this.mService.pause();
            } catch (RemoteException ex) {
                ex.printStackTrace();
            }
        }

        public boolean needsLock() {
            try {
                if (MiniPlayerAndroidImpl.this.mService.isPlaying()) {
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
                MiniPlayerAndroidImpl.this.mService.play();
            } catch (RemoteException ex) {
                ex.printStackTrace();
            }
        }
    }

    class C02634 implements OnClickListener {
        C02634() {
        }

        public void onClick(View v) {
            if (MiniPlayerAndroidImpl.this.isPlaying()) {
                MiniPlayerAndroidImpl.this.pause();
            } else {
                MiniPlayerAndroidImpl.this.play();
            }
        }
    }

    class C02645 implements ClickRunner {
        C02645() {
        }

        public void run() {
            MiniPlayerAndroidImpl.this.previousSong();
            MiniPlayerAndroidImpl.this.progressBar.setProgress(0);
        }
    }

    class C02666 implements OnDrawerScrollListener {

        class C02651 implements Runnable {
            C02651() {
            }

            public void run() {
                if (MiniPlayerAndroidImpl.this.slider.isMoving()) {
                    MiniPlayerAndroidImpl.this.mHandler.postDelayed(this, 200);
                } else {
                    MiniPlayerAndroidImpl.this.player.setOpen(MiniPlayerAndroidImpl.this.slider.isOpened());
                }
            }
        }

        C02666() {
        }

        public void onScrollStarted() {
            MiniPlayerAndroidImpl.this.backToListIcon.setVisibility(4);
            MiniPlayerAndroidImpl.this.facebookLikeButton.setVisibility(4);
            MiniPlayerAndroidImpl.this.songArtistLabel.setVisibility(4);
            MiniPlayerAndroidImpl.this.player.startScrolling();
            MiniPlayerAndroidImpl.this.adjustDrawerForScreenOrientation();
        }

        public void onScrollEnded() {
            MiniPlayerAndroidImpl.this.mHandler.removeCallbacks(MiniPlayerAndroidImpl.this.mUpdateSeekbarTask);
            MiniPlayerAndroidImpl.this.mHandler.postDelayed(MiniPlayerAndroidImpl.this.mUpdateSeekbarTask, 500);
            if (!(MiniPlayerAndroidImpl.this.slider.isMoving() || MiniPlayerAndroidImpl.this.slider.isOpened())) {
                MiniPlayerAndroidImpl.this.backToListIcon.setVisibility(0);
                MiniPlayerAndroidImpl.this.facebookLikeButton.setVisibility(0);
                MiniPlayerAndroidImpl.this.songArtistLabel.setVisibility(0);
                MiniPlayerAndroidImpl.this.mainButtonTrayTop.setVisibility(4);
            }
            if (!MiniPlayerAndroidImpl.this.slider.isMoving() && MiniPlayerAndroidImpl.this.slider.isOpened()) {
                MiniPlayerAndroidImpl.this.player.updateFacebookLikedState(false);
            }
            MiniPlayerAndroidImpl.this.player.stopScrolling();
            MiniPlayerAndroidImpl.this.mHandler.postDelayed(new C02651(), 200);
            MiniPlayerAndroidImpl.this.movingHandler.removeMessages(0);
            MiniPlayerAndroidImpl.this.movingHandler.sendMessage(Message.obtain(MiniPlayerAndroidImpl.this.movingHandler, 0));
        }
    }

    class C02677 implements OnClickListener {
        C02677() {
        }

        public void onClick(View v) {
            try {
                String targetActivity = MiniPlayerAndroidImpl.this.mService.getCurrentListActivity();
                String targetToken = MiniPlayerAndroidImpl.this.mService.getCurrentListToken();
                if (targetActivity != null && targetToken != null) {
                    Intent intent = Utils.buildIntent(targetActivity, targetToken, true, MiniPlayerAndroidImpl.this.mActivity);
                    intent.addFlags(65536);
                    intent.addFlags(536870912);
                    MiniPlayerAndroidImpl.this.mActivity.startActivity(intent);
                }
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    class C02688 implements OnClickListener {
        C02688() {
        }

        public void onClick(View v) {
            RelativeLayout layout = (RelativeLayout) MiniPlayerAndroidImpl.this.mActivity.findViewById(C0116R.id.facebook_toast_liked);
            layout.setVisibility(4);
            AlphaAnimation fadeOut = new AlphaAnimation(0.9f, 0.0f);
            fadeOut.setDuration(1000);
            layout.startAnimation(fadeOut);
            PlayableItem item = null;
            try {
                item = MiniPlayerAndroidImpl.this.mService.getCurrentItem();
            } catch (RemoteException e) {
            }
            if (item != null) {
                FacebookAPI.get().unlikeMediaRequest(MiniPlayerAndroidImpl.this.mActivity, item, new MiniPlayerFacebookCallback(MiniPlayerAndroidImpl.this.mActivity, FacebookAPI.sRequestTypeUnlikeMedia));
            }
        }
    }

    class C02709 implements OnClickListener {

        class C02691 implements OnClickListener {
            C02691() {
            }

            public void onClick(View aView) {
                MiniPlayerAndroidImpl.this.dismissFacebookLikedToast();
            }
        }

        C02709() {
        }

        public void onClick(View v) {
            PlayableItem item = null;
            try {
                item = MiniPlayerAndroidImpl.this.mService.getCurrentItem();
            } catch (RemoteException e) {
            }
            if (item != null && item.mID != -1) {
                FacebookAPI fbApi = FacebookAPI.get();
                if (FacebookAPI.getDB().isMediaLiked(item)) {
                    RelativeLayout layout = (RelativeLayout) MiniPlayerAndroidImpl.this.mActivity.findViewById(C0116R.id.facebook_toast_liked);
                    layout.setOnClickListener(new C02691());
                    AlphaAnimation fadeIn = new AlphaAnimation(0.0f, 0.9f);
                    fadeIn.setDuration(500);
                    layout.startAnimation(fadeIn);
                    layout.setVisibility(0);
                    return;
                }
                String message = "";
                try {
                    message = MiniPlayerAndroidImpl.this.mActivity.getString(C0116R.string.facebook_default_like_message, new Object[]{MiniPlayerAndroidImpl.this.mService.getTrackName(), MiniPlayerAndroidImpl.this.mService.getArtistName()});
                } catch (RemoteException e2) {
                }
                Bundle params = new Bundle();
                params.putString("message", message);
                try {
                    if (fbApi.likeMediaRequest(MiniPlayerAndroidImpl.this.mActivity, item, params, new MiniPlayerFacebookCallback(MiniPlayerAndroidImpl.this.mActivity, FacebookAPI.sRequestTypeLikeMedia, MiniPlayerAndroidImpl.this.mService.getArtistName(), MiniPlayerAndroidImpl.this.mService.getTrackName(), MiniPlayerAndroidImpl.this.mService.getTrackID()))) {
                        Map<String, String> properties = new HashMap();
                        properties.put("artist", MiniPlayerAndroidImpl.this.mService.getArtistName());
                        properties.put(Analytics.TRACK_KEY, MiniPlayerAndroidImpl.this.mService.getTrackName());
                        Map<String, String> map = properties;
                        map.put(Analytics.GENRE_KEY, MediaUtils.getGenreForTrackId(MiniPlayerAndroidImpl.this.mActivity, MiniPlayerAndroidImpl.this.mService.getTrackID()));
                        Analytics.getAnalytics().trackEvent(Analytics.EVENT_FACEBOOK_LIKE, null, properties);
                        return;
                    }
                    FacebookAPI.get().showErrorToast();
                } catch (RemoteException e3) {
                    Logger.error(this, "Problems getting with service", e3);
                }
            }
        }
    }

    class SkipHolder implements HoldRunner {
        int mSkipValue;

        public SkipHolder(int pSkipValue) {
            this.mSkipValue = pSkipValue;
        }

        public void run() {
            try {
                MiniPlayerAndroidImpl.this.mService.seek(MiniPlayerAndroidImpl.this.getCurrentPosition() + this.mSkipValue);
            } catch (RemoteException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static final MiniPlayerAndroidImpl getMiniPlayer(Activity aActivity) {
        if (gMiniPlayer == null) {
            gMiniPlayer = new MiniPlayerAndroidImpl(aActivity);
        } else {
            gMiniPlayer.bindMiniPlayerToActivity(aActivity);
        }
        return gMiniPlayer;
    }

    private MiniPlayerAndroidImpl(Activity aActivity) {
        bindMiniPlayerToActivity(aActivity);
    }

    public void bindMiniPlayerToActivity(Activity aActivity) {
        if (aActivity != this.mActivity) {
            unbindMiniPlayer();
            this.mActivity = aActivity;
            this.songArtistLabel = (MarqueeTextView) this.mActivity.findViewById(C0116R.id.mini_player_song_artist_label);
            this.progressBar = (MiniSeekBar) this.mActivity.findViewById(C0116R.id.mini_player_seeker_bar);
            this.nextSongButton = (ImageView) this.mActivity.findViewById(C0116R.id.mini_player_next_song);
            this.playPauseButton = (PlayButtonImageView) this.mActivity.findViewById(C0116R.id.mini_player_pause_button);
            this.previousSongButton = (ImageView) this.mActivity.findViewById(C0116R.id.mini_player_previous_song);
            this.backToListIcon = (ImageView) this.mActivity.findViewById(C0116R.id.back_to_list_icon);
            this.facebookLikeButton = (ImageView) this.mActivity.findViewById(C0116R.id.mini_player_fb_like_button);
            this.facebookUnlikeButton = (Button) this.mActivity.findViewById(C0116R.id.facebook_toast_unlike_button);
            this.mainButtonTrayTop = this.mActivity.findViewById(C0116R.id.main_player_top_button_tray);
            this.progressBar.setOnTouchListener(new C02601());
            ClickRunner aNextClickListener = new C02612();
            CheckLock aLock = new C02623();
            this.mNextTouch = new ScrubberTouch(aNextClickListener, aLock, new SkipHolder(FacebookAPI.FACEBOOK_AUTHORIZE_RESULT_CODE), new SkipHolder(3000), new SkipHolder(5000), new SkipHolder(8000), new SkipHolder(13000), new SkipHolder(21000), new SkipHolder(34000));
            this.nextSongButton.setOnTouchListener(this.mNextTouch);
            this.nextSongButton.setOnClickListener(new EmptyClick());
            this.playPauseButton.setOnClickListener(new C02634());
            this.mPreviousTouch = new ScrubberTouch(new C02645(), aLock, new SkipHolder(-2000), new SkipHolder(-3000), new SkipHolder(-5000), new SkipHolder(-8000), new SkipHolder(-13000), new SkipHolder(-21000), new SkipHolder(-34000));
            this.previousSongButton.setOnTouchListener(this.mPreviousTouch);
            this.previousSongButton.setOnClickListener(new EmptyClick());
            this.slider = (SlidingDrawer) this.mActivity.findViewById(C0116R.id.sliding_drawer);
            if (this.player == null) {
                this.player = new PlayerViewImpl(this.mActivity);
            } else {
                this.player.bindPlayerToActivity(this.mActivity);
            }
            this.player.setDrawer(this.slider);
            this.slider.setOnDrawerScrollListener(new C02666());
            this.backToListIcon.setOnClickListener(new C02677());
            this.facebookUnlikeButton.setOnClickListener(new C02688());
            this.facebookLikeButton.setOnClickListener(new C02709());
            this.slider.setOnDrawerCloseListener(new OnDrawerCloseListener() {
                public void onDrawerClosed() {
                    MiniPlayerAndroidImpl.this.slider.setClickable(false);
                    MiniPlayerAndroidImpl.this.progressBar.setVisibility(0);
                    if (MiniPlayerAndroidImpl.this.closeListener != null) {
                        MiniPlayerAndroidImpl.this.closeListener.onAction();
                    }
                    MiniPlayerAndroidImpl.this.backToListIcon.setVisibility(0);
                    MiniPlayerAndroidImpl.this.songArtistLabel.setVisibility(0);
                    MiniPlayerAndroidImpl.this.facebookLikeButton.setVisibility(0);
                    MiniPlayerAndroidImpl.this.mainButtonTrayTop.setVisibility(4);
                    MiniPlayerAndroidImpl.this.player.setOpen(false);
                    MiniPlayerAndroidImpl.this.updateFacebookLikedState(false);
                }
            });
            this.slider.setOnDrawerOpenListener(new OnDrawerOpenListener() {
                public void onDrawerOpened() {
                    MiniPlayerAndroidImpl.this.progressBar.setVisibility(4);
                    MiniPlayerAndroidImpl.this.slider.setClickable(true);
                    if (MiniPlayerAndroidImpl.this.openListener != null) {
                        MiniPlayerAndroidImpl.this.openListener.onAction();
                    }
                    MiniPlayerAndroidImpl.this.songArtistLabel.setVisibility(4);
                    MiniPlayerAndroidImpl.this.backToListIcon.setVisibility(4);
                    MiniPlayerAndroidImpl.this.facebookLikeButton.setVisibility(4);
                    MiniPlayerAndroidImpl.this.adjustDrawerForScreenOrientation();
                    MiniPlayerAndroidImpl.this.player.updateFacebookLikedState(false);
                    MiniPlayerAndroidImpl.this.player.setOpen(true);
                    Analytics.getAnalytics().track(Analytics.EVENT_MUSIC_DRAWER);
                }
            });
            registerMediaEventCallback();
        }
    }

    public void unbindMiniPlayer() {
        if (this.mActivity != null) {
            unregisterMediaEventCallback();
            this.mActivity = null;
            this.player.unbindMiniPlayer();
        }
    }

    private void registerMediaEventCallback() {
        ((SongbirdApplication) this.mActivity.getApplicationContext()).getMediaService(this);
    }

    private void unregisterMediaEventCallback() {
        try {
            if (this.serviceConnected) {
                this.mService.unregisterCallback(this.callback);
            }
        } catch (Exception e) {
            this.serviceConnected = false;
        }
        this.serviceConnected = false;
    }

    private void adjustDrawerForScreenOrientation() {
        int orientation = this.mActivity.getResources().getConfiguration().orientation;
        ImageView backToListButton = (ImageView) this.mActivity.findViewById(C0116R.id.main_player_back_to_list_handle);
        if (orientation == 1) {
            backToListButton.setVisibility(4);
        } else if (orientation == 2) {
            backToListButton.setVisibility(0);
        }
        this.mainButtonTrayTop.setVisibility(0);
    }

    public void onMediaServiceConnected(SongbirdMediaService aMediaService) {
        this.mService = aMediaService;
        this.serviceConnected = true;
        boolean isPlaying = false;
        int duration = 0;
        int position = 0;
        try {
            isPlaying = this.mService.isPlaying();
            duration = this.mService.duration();
            position = this.mService.position();
            this.mService.registerCallback(this.callback);
        } catch (RemoteException e) {
        }
        this.playPauseButton.setPlaying(isPlaying);
        this.progressBar.setMax(duration);
        this.progressBar.setProgress(position);
    }

    public void updateFacebookLikedState(boolean aResetToDefault) {
        if (aResetToDefault) {
            this.facebookLikeButton.setImageDrawable(this.mActivity.getResources().getDrawable(C0116R.drawable.button_fb_default));
        } else if (this.mService != null) {
            PlayableItem item = new PlayableItem("<UNKNOWN>", null, -1, -1);
            try {
                item = this.mService.getCurrentItem();
            } catch (Exception e) {
            }
            if (item == null || item.mStorageUri != null) {
                Drawable d;
                if (FacebookAPI.getDB().isMediaLiked(item)) {
                    d = this.mActivity.getResources().getDrawable(C0116R.drawable.button_fb_liked);
                } else {
                    d = this.mActivity.getResources().getDrawable(C0116R.drawable.button_fb_default);
                }
                this.facebookLikeButton.setImageDrawable(d);
            }
        }
    }

    public boolean isFacebookLikedToastShowing() {
        return ((RelativeLayout) this.mActivity.findViewById(C0116R.id.facebook_toast_liked)).getVisibility() == 0;
    }

    public void dismissFacebookLikedToast() {
        final RelativeLayout layout = (RelativeLayout) this.mActivity.findViewById(C0116R.id.facebook_toast_liked);
        layout.setOnClickListener(null);
        AlphaAnimation fadeOut = new AlphaAnimation(0.9f, 0.0f);
        fadeOut.setDuration(500);
        fadeOut.setAnimationListener(new AnimationListener() {
            public void onAnimationEnd(Animation animation) {
                layout.setVisibility(4);
            }

            public void onAnimationRepeat(Animation animation) {
            }

            public void onAnimationStart(Animation animation) {
            }
        });
        layout.startAnimation(fadeOut);
    }

    public int getCurrentPosition() {
        try {
            return this.mService.position();
        } catch (RemoteException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public String getCurrentSongArtist() {
        try {
            String tempArtist = this.mService.getArtistName();
            if (tempArtist != null) {
                return tempArtist;
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void setCloseListener(Listener closeListener) {
        this.closeListener = closeListener;
    }

    public void setOpenListener(Listener openListener) {
        this.openListener = openListener;
    }

    public String getCurrentSongName() {
        try {
            String tempSong = this.mService.getTrackName();
            if (tempSong != null) {
                return tempSong;
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return null;
    }

    public int getDuration() {
        try {
            return this.mService.duration();
        } catch (RemoteException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public boolean isPlaying() {
        try {
            return this.mService.isPlaying();
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void nextSong() {
        try {
            this.mService.next();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public boolean onBackPressed() {
        if (this.mActivity == null) {
            return false;
        }
        boolean handledBack = false;
        if (this.player != null) {
            handledBack = this.player.onBackPressed();
        }
        if (!isFacebookLikedToastShowing()) {
            return handledBack;
        }
        dismissFacebookLikedToast();
        return true;
    }

    public void onPause() {
        if (this.player != null) {
            this.player.onPause();
        }
        this.mHandler.removeCallbacks(this.mUpdateSeekbarTask);
        unregisterMediaEventCallback();
        this.mNextTouch.stopHopping();
        this.mPreviousTouch.stopHopping();
    }

    public void onStart(Activity aActivity) {
    }

    public void onResume(Activity aActivity) {
        bindMiniPlayerToActivity(aActivity);
        if (this.player != null) {
            this.player.onResume();
        }
        registerMediaEventCallback();
        if (this.mService != null) {
            this.progressBar.post(this.mUpdateSeekbarTask);
        }
    }

    public void onStop() {
        if (this.player != null) {
            this.player.onStop();
        }
    }

    public void onDestroy() {
        if (this.player != null) {
            this.player.onDestroy();
        }
    }

    public void pause() {
        try {
            this.mService.pause();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public void play() {
        try {
            this.mService.play();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public void previousSong() {
        try {
            this.mService.prev();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public void setProgressMax(int inSet) {
        this.progressBar.setMax(inSet);
    }

    public void setSongArtistText(String inText) {
        this.songArtistLabel.setText(inText);
    }

    public void setDrawerOpen(boolean aOpenDrawer) {
        if (aOpenDrawer && !this.slider.isOpened()) {
            this.slider.animateOpen();
        } else if (!aOpenDrawer && this.slider.isOpened()) {
            this.slider.animateClose();
        }
    }

    public boolean isDrawerOpen() {
        return this.slider.isOpened();
    }

    public PlayerViewImpl getPlayer() {
        return this.player;
    }
}
