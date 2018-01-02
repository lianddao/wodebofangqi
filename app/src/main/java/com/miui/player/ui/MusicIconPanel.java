package com.miui.player.ui;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.miui.player.C0329R;
import com.miui.player.PlayerActions.In;
import com.miui.player.PlayerActions.Out;
import com.miui.player.meta.AlbumManager;
import com.miui.player.service.IMediaPlaybackService;
import com.miui.player.service.IMediaPlaybackService.Stub;
import com.miui.player.service.ServiceHelper;
import com.miui.player.service.ServiceHelper.ServiceToken;
import com.miui.player.ui.base.MusicApplication;
import com.miui.player.ui.controller.AlbumBackground;
import com.miui.player.util.BitmapHelper;
import com.miui.player.util.PreferenceCache;
import miui.v5.widget.Views;
import miui.widget.CircleProgressBar;
import miui.widget.IconPanelActivity;
import miui.widget.SpectrumVisualizer;

public class MusicIconPanel extends IconPanelActivity implements ServiceConnection, OnClickListener {
    private static final int INTERVAL_REFRESH = 500;
    static final int MSG_ENABLE_VISUALIZER = 1;
    static final int MSG_REFRESH_NOW = 2;
    static final String TAG = "MusicIconPanel";
    static int sAlbumHeight = -1;
    static int sAlbumWidth = -1;
    AlbumBackground mAlbum;
    AsyncTask<Void, Void, Bitmap> mAlbumLoader;
    private final Handler mHandler = new C04464();
    private ImageView mNextImage;
    private ImageView mPrevImage;
    private TextView mPrimaryText;
    private CircleProgressBar mProgressBar;
    private TextView mSecondaryText;
    private IMediaPlaybackService mService;
    private ServiceToken mServiceToken;
    private final BroadcastReceiver mStatusListener = new C04442();
    private ImageView mTogglePauseImage;
    SpectrumVisualizer mVisualizer;
    private boolean mVisualizerEnabled = false;

    class C04431 implements OnClickListener {
        C04431() {
        }

        public void onClick(View v) {
            MusicIconPanel.this.startActivity(new Intent(In.ACTION_MUSIC_MAIN));
        }
    }

    class C04442 extends BroadcastReceiver {
        C04442() {
        }

        public void onReceive(Context context, Intent intent) {
            if (Out.STATUS_META_CHANGED.equals(intent.getAction())) {
                String extra = intent.getStringExtra(Out.KEY_OTHER);
                if (Out.META_CHANGED_ALBUM.equals(extra) || Out.META_CHANGED_TRACK.equals(extra)) {
                    MusicIconPanel.this.updateTrackInfo();
                    return;
                }
                return;
            }
            MusicIconPanel.this.queueNextRefresh(MusicIconPanel.this.refreshNow());
            MusicIconPanel.this.updateControl();
        }
    }

    class C04464 extends Handler {
        C04464() {
        }

        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1:
                    if (MusicIconPanel.this.mVisualizer != null) {
                        try {
                            MusicIconPanel.this.mVisualizer.enableUpdate(true);
                            return;
                        } catch (ExceptionInInitializerError e) {
                            Log.e(MusicIconPanel.TAG, e.toString());
                            return;
                        }
                    }
                    return;
                case 2:
                    MusicIconPanel.this.queueNextRefresh(MusicIconPanel.this.refreshNow());
                    return;
                default:
                    return;
            }
        }
    }

    protected View createWidget(ViewGroup parent) {
        return Views.inflate(this, C0329R.layout.music_icon_panel, parent, false);
    }

    protected void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        this.mServiceToken = ServiceHelper.bindToService(this, this);
    }

    protected void onDestroy() {
        if (this.mServiceToken != null) {
            ServiceHelper.unbindFromService(this.mServiceToken);
            this.mServiceToken = null;
        }
        if (this.mAlbumLoader != null) {
            this.mAlbumLoader.cancel(true);
            this.mAlbumLoader = null;
        }
        this.mAlbum.onDestroy();
        super.onDestroy();
    }

    protected void onResume() {
        super.onResume();
        IntentFilter filter = new IntentFilter();
        filter.addAction(Out.STATUS_META_CHANGED);
        filter.addAction(Out.STATUS_PLAYBACK_COMPLETE);
        filter.addAction(Out.STATUS_PLAYSTATE_CHANGED);
        registerReceiver(this.mStatusListener, filter);
        updateTrackInfo();
        updateControl();
        this.mAlbum.onResume();
    }

    protected void onPause() {
        unregisterReceiver(this.mStatusListener);
        this.mHandler.removeMessages(2);
        setVisualizerEnabled(false);
        this.mAlbum.onPause();
        super.onPause();
    }

    public void onServiceConnected(ComponentName name, IBinder service) {
        if (service == null) {
            finish();
            return;
        }
        this.mService = Stub.asInterface(service);
        updateTrackInfo();
        updateControl();
    }

    public void onServiceDisconnected(ComponentName name) {
        this.mService = null;
    }

    protected void onWidgetAttached(View widget) {
        widget.findViewById(C0329R.id.album_foreground).setOnClickListener(new C04431());
        MarginLayoutParams params = (MarginLayoutParams) widget.getLayoutParams();
        params.width = computWidth();
        params.height = computHeight();
        params.topMargin = computTop();
        widget.requestLayout();
        UIHelper.measureHeightByBackground(findViewById(C0329R.id.control));
        this.mProgressBar = (CircleProgressBar) findViewById(C0329R.id.progress);
        this.mProgressBar.setIndeterminate(false);
        this.mProgressBar.setDrawablesForLevels(null, new int[]{C0329R.drawable.icon_panel_progress_bar}, null);
        this.mProgressBar.setThumb(C0329R.drawable.icon_panel_progress_thumb);
        this.mVisualizer = (SpectrumVisualizer) findViewById(C0329R.id.spectrum_visualizer);
        if (!isSupportVisualizer()) {
            this.mVisualizer.setVisibility(4);
        }
        this.mPrimaryText = (TextView) findViewById(C0329R.id.primary);
        this.mSecondaryText = (TextView) findViewById(C0329R.id.secondary);
        this.mTogglePauseImage = (ImageView) findViewById(C0329R.id.togglepause);
        alignVerticalCenter(this.mTogglePauseImage, this.mProgressBar);
        this.mTogglePauseImage.setOnClickListener(this);
        this.mPrevImage = (ImageView) findViewById(C0329R.id.prev);
        alignVerticalCenter(this.mPrevImage, this.mProgressBar);
        this.mPrevImage.setOnClickListener(this);
        this.mNextImage = (ImageView) findViewById(C0329R.id.next);
        alignVerticalCenter(this.mNextImage, this.mProgressBar);
        this.mNextImage.setOnClickListener(this);
        this.mAlbum = AlbumBackground.createForNoVideo(findViewById(C0329R.id.content), C0329R.drawable.icon_panel_album);
        if (sAlbumWidth < 0) {
            Drawable album = getResources().getDrawable(C0329R.drawable.icon_panel_album);
            sAlbumWidth = album.getIntrinsicWidth();
            sAlbumHeight = album.getIntrinsicHeight();
        }
    }

    public void onClick(View v) {
        IMediaPlaybackService service = this.mService;
        if (service != null) {
            try {
                if (v == this.mPrevImage) {
                    service.prev();
                } else if (v == this.mNextImage) {
                    service.next();
                } else if (v != this.mTogglePauseImage) {
                    throw new UnsupportedOperationException("Bad view, id=" + v.getId() + "  " + v);
                } else if (service.isPlaying()) {
                    service.pause();
                    ((ImageView) v).setImageResource(C0329R.drawable.icon_panel_play);
                } else {
                    service.play();
                    ((ImageView) v).setImageResource(C0329R.drawable.icon_panel_pause);
                }
            } catch (RemoteException e) {
                Log.e(TAG, "onClick", e);
            }
        }
    }

    void updateControl() {
        IMediaPlaybackService service = this.mService;
        if (service != null) {
            try {
                this.mTogglePauseImage.setImageResource(service.isPlaying() ? C0329R.drawable.icon_panel_pause : C0329R.drawable.icon_panel_play);
                this.mPrevImage.setVisibility(service.getChannelName() == null ? 0 : 4);
            } catch (RemoteException e) {
                Log.e(TAG, "updateControl", e);
            }
        }
    }

    void updateTrackInfo() {
        IMediaPlaybackService service = this.mService;
        if (service != null) {
            try {
                if (service.getPath() == null) {
                    this.mPrimaryText.setText(C0329R.string.click_to_shuffle);
                    this.mSecondaryText.setText(null);
                    this.mAlbum.setDrawable(null);
                } else {
                    final long albumId = service.getAlbumId();
                    final String albumName = service.getAlbumName();
                    final String artistName = service.getArtistName();
                    this.mPrimaryText.setText(service.getTrackName());
                    this.mSecondaryText.setText(UIHelper.getDescript(this, artistName, albumName));
                    this.mProgressBar.setMax((int) service.duration());
                    final Application app = getApplication();
                    if (PreferenceCache.getPrefAsBoolean(this, PreferenceCache.PREF_DISPLAY_ALBUM)) {
                        if (this.mAlbumLoader != null) {
                            this.mAlbumLoader.cancel(true);
                        }
                        this.mAlbumLoader = new AsyncTask<Void, Void, Bitmap>() {
                            protected Bitmap doInBackground(Void... params) {
                                Bitmap src = AlbumManager.getDisplayedAlbum(app, albumId, albumName, artistName, true, MusicIconPanel.sAlbumWidth, MusicIconPanel.sAlbumHeight, false);
                                if (src == null) {
                                    return null;
                                }
                                Bitmap mask = BitmapFactory.decodeResource(MusicIconPanel.this.getResources(), C0329R.drawable.icon_panel_album_mask);
                                Bitmap bm = BitmapHelper.transferMode(src, mask, new PorterDuffXfermode(Mode.DST_IN));
                                mask.recycle();
                                src.recycle();
                                return bm;
                            }

                            protected void onPostExecute(Bitmap bm) {
                                MusicIconPanel.this.mAlbum.setBitmap(bm);
                                MusicIconPanel.this.mAlbumLoader = null;
                            }
                        }.execute(new Void[0]);
                    } else {
                        this.mAlbum.setBitmap(null);
                    }
                }
                queueNextRefresh(refreshNow());
            } catch (RemoteException e) {
                Log.e(TAG, "updateTrackInfo", e);
            }
        }
    }

    long refreshNow() {
        IMediaPlaybackService service = this.mService;
        int next = -1;
        if (service != null) {
            try {
                this.mProgressBar.setMax((int) service.duration());
                this.mProgressBar.setProgress((int) service.position());
                next = service.isPlaying() ? 500 : -1;
            } catch (RemoteException e) {
                Log.e(TAG, "refreshNow", e);
            }
        }
        setVisualizerEnabled(next >= 0);
        return (long) next;
    }

    void queueNextRefresh(long delay) {
        if (delay >= 0 && isResumed() && this.mService != null) {
            this.mHandler.removeMessages(2);
            this.mHandler.sendEmptyMessageDelayed(2, delay);
        }
    }

    private boolean isSupportVisualizer() {
        return MusicApplication.getApplication().getResources().getBoolean(C0329R.bool.support_icon_panel_spectrum_visualizer);
    }

    private void setVisualizerEnabled(boolean enabled) {
        if (isSupportVisualizer() && this.mVisualizerEnabled != enabled) {
            this.mVisualizerEnabled = enabled;
            if (enabled) {
                this.mHandler.sendEmptyMessageDelayed(1, 1000);
                return;
            }
            this.mHandler.removeMessages(1);
            this.mVisualizer.enableUpdate(false);
        }
    }

    private int computWidth() {
        return getResources().getDrawable(C0329R.drawable.icon_panel_footer_bg).getIntrinsicWidth();
    }

    private int computHeight() {
        return getResources().getDimensionPixelSize(C0329R.dimen.icon_panel_height);
    }

    private int computTop() {
        return getResources().getDimensionPixelOffset(C0329R.dimen.icon_panel_top);
    }

    private static void alignVerticalCenter(ImageView v, View anchor) {
        ((MarginLayoutParams) v.getLayoutParams()).topMargin = (Views.getBackgroundHeight(anchor) - v.getDrawable().getIntrinsicHeight()) / 2;
        v.requestLayout();
    }
}
