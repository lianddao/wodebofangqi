package com.miui.player.ui.controller;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.AsyncTask.Status;
import android.os.Handler;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.miui.player.C0329R;
import com.miui.player.meta.AlbumManager;
import com.miui.player.provider.MediaProviderHelper;
import com.miui.player.service.IMediaPlaybackService;
import com.miui.player.service.ServiceHelper;
import com.miui.player.ui.UIHelper;
import com.miui.player.util.MusicAnalyticsUtils;
import com.miui.player.util.PreferenceCache;
import miui.analytics.XiaomiAnalytics;
import miui.widget.MarqueeTextView;

public class MusicBrowserController implements OnClickListener {
    static final String TAG = "MusicBrowserController";
    final Activity mActivity;
    final AlbumBackground mAlbumBackground;
    AsyncTask<Void, Void, Bitmap> mAlbumLoadTask = null;
    boolean mFirstVisible = true;
    Handler mHandler = new Handler();
    private final ImageView mPlayButton;
    private final MarqueeTextView mPrimaryText;
    final ImageView mTabLight;
    private final ImageView mTopRoundCorner;
    int mUpdateVersion = -1;

    public MusicBrowserController(Activity a) {
        this.mActivity = a;
        View container = a.findViewById(C0329R.id.action_bar_title);
        this.mPrimaryText = (MarqueeTextView) container.findViewById(C0329R.id.primary_text);
        this.mAlbumBackground = AlbumBackground.createByType(container, AlbumBackground.TYPE_VIDEO_SMALL);
        container.findViewById(C0329R.id.album_shadow).setOnClickListener(this);
        this.mPlayButton = (ImageView) container.findViewById(C0329R.id.main_play_button);
        this.mPlayButton.setOnClickListener(this);
        this.mTabLight = (ImageView) container.findViewById(C0329R.id.tab_light);
        this.mTopRoundCorner = (ImageView) container.findViewById(C0329R.id.top_round_corner);
        this.mPlayButton.setVisibility(0);
        container.findViewById(C0329R.id.tab_indicator).setVisibility(0);
        container.findViewById(C0329R.id.album_shadow).setVisibility(0);
    }

    public void refreshTrackCount() {
        if (!ServiceHelper.isMusicLoaded()) {
            int count = MediaProviderHelper.getTrackCount(this.mActivity, -1);
            setSecondaryText(this.mActivity.getResources().getQuantityString(C0329R.plurals.Ntrack_in_sdcard_format, count, new Object[]{Integer.valueOf(count)}), null);
        }
    }

    public void onPause() {
        this.mAlbumBackground.onPause();
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.mAlbumLoadTask != null) {
            this.mAlbumLoadTask.cancel(true);
            this.mAlbumLoadTask = null;
        }
    }

    public void onDestroy() {
        this.mAlbumBackground.onDestroy();
    }

    public void onResume() {
        this.mTopRoundCorner.setVisibility(UIHelper.maskWindowCorner(this.mActivity) ? 8 : 0);
        this.mAlbumBackground.onResume();
        refreshMediaInfo(true, ServiceHelper.getUpdateVersion());
    }

    private void refreshPlayingMeteInfo(boolean updateAlbum, int version) {
        IMediaPlaybackService service = ServiceHelper.sService;
        if (service != null) {
            try {
                String tr = service.getTrackName();
                String al = service.getAlbumName();
                String ar = service.getArtistName();
                this.mPrimaryText.setText(tr);
                setSecondaryText(al, ar);
                if (updateAlbum) {
                    loadAlbum(al, ar, service.getAlbumId(), version);
                }
            } catch (RemoteException e) {
            }
        }
    }

    private void setSecondaryText(String first, String second) {
        int visibility = (TextUtils.isEmpty(first) || TextUtils.isEmpty(second)) ? 8 : 0;
        this.mActivity.findViewById(C0329R.id.secondary_text_separator).setVisibility(visibility);
        ((TextView) this.mActivity.findViewById(C0329R.id.album_text)).setText(first);
        ((TextView) this.mActivity.findViewById(C0329R.id.artist_text)).setText(second);
    }

    void loadAlbum(String al, String ar, long albumId, int updateVersion) {
        if (PreferenceCache.getPrefAsBoolean(this.mActivity, PreferenceCache.PREF_DISPLAY_ALBUM)) {
            this.mHandler.removeCallbacksAndMessages(null);
            if (this.mAlbumLoadTask != null) {
                this.mAlbumLoadTask.cancel(true);
                this.mAlbumLoadTask = null;
            }
            final long j = albumId;
            final String str = al;
            final String str2 = ar;
            final int i = updateVersion;
            final AsyncTask<Void, Void, Bitmap> task = new AsyncTask<Void, Void, Bitmap>() {
                protected Bitmap doInBackground(Void... params) {
                    return AlbumManager.getDisplayedAlbum(MusicBrowserController.this.mActivity, j, str, str2, true, MusicBrowserController.this.mAlbumBackground.getWidth(), MusicBrowserController.this.mAlbumBackground.getHeight(), false);
                }

                protected void onPostExecute(Bitmap bm) {
                    MusicBrowserController.this.mAlbumBackground.setBitmap(bm);
                    MusicBrowserController.this.mTabLight.setVisibility(bm == null ? 0 : 8);
                    MusicBrowserController.this.mAlbumLoadTask = null;
                    MusicBrowserController.this.mUpdateVersion = i;
                }
            };
            if (this.mFirstVisible) {
                this.mFirstVisible = false;
                this.mHandler.postDelayed(new Runnable() {
                    public void run() {
                        if (MusicBrowserController.this.mAlbumLoadTask == null || MusicBrowserController.this.mAlbumLoadTask.getStatus() != Status.FINISHED) {
                            MusicBrowserController.this.mAlbumLoadTask = task;
                            task.execute(new Void[0]);
                            return;
                        }
                        Log.w(MusicBrowserController.TAG, "bad task !");
                    }
                }, 100);
                return;
            }
            this.mAlbumLoadTask = task;
            task.execute(new Void[0]);
            return;
        }
        this.mFirstVisible = false;
        this.mAlbumBackground.setBitmap(null);
        this.mTabLight.setVisibility(0);
        this.mUpdateVersion = updateVersion;
    }

    public void refreshMediaInfo(boolean updateAlbum, int updateVersion) {
        if (ServiceHelper.sService != null) {
            try {
                this.mPlayButton.setImageResource(ServiceHelper.sService.isPlaying() ? C0329R.drawable.main_button_pause : C0329R.drawable.main_button_play);
            } catch (RemoteException e) {
            }
            if (this.mUpdateVersion == updateVersion) {
                return;
            }
            if (ServiceHelper.isMusicLoaded()) {
                refreshPlayingMeteInfo(updateAlbum, ServiceHelper.getUpdateVersion());
                return;
            }
            this.mPrimaryText.setText(C0329R.string.click_to_shuffle);
            refreshTrackCount();
            this.mAlbumBackground.setDrawable(null);
        }
    }

    public void onClick(View v) {
        if (v == this.mPlayButton) {
            XiaomiAnalytics.getInstance().trackEvent(MusicAnalyticsUtils.CLICK_HOMEPAGE_PLAY);
            if (ServiceHelper.sService != null) {
                try {
                    if (ServiceHelper.sService.isPlaying()) {
                        ServiceHelper.sService.pause();
                    } else {
                        ServiceHelper.sService.play();
                    }
                } catch (RemoteException e) {
                }
            }
        } else if (ServiceHelper.isMusicLoaded()) {
            XiaomiAnalytics.getInstance().trackEvent(MusicAnalyticsUtils.CLICK_HOMEPAGE_ENTER_NOWPLAYING);
            this.mActivity.startActivity(new Intent("com.miui.player.PLAYBACK_VIEWER").setFlags(67108864));
        } else if (ServiceHelper.sService != null) {
            try {
                ServiceHelper.sService.play();
            } catch (RemoteException e2) {
            }
        }
    }

    public void setAlbumBackgroundTranslationX(float translationX) {
        this.mAlbumBackground.setTranslationX(translationX);
    }

    public void setAlbumBackgroundTranslationY(float translationY) {
        this.mAlbumBackground.setTranslationY(translationY);
    }

    public boolean isVideoPlaying() {
        return this.mAlbumBackground.isVideoPlaying();
    }
}
