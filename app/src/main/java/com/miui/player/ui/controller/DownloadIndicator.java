package com.miui.player.ui.controller;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.RemoteException;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.miui.player.PlayerActions.Out;
import com.miui.player.meta.Audio;
import com.miui.player.meta.MetaManager;
import com.miui.player.network.DownloadInfoManager;
import com.miui.player.network.MP3Downloader;
import com.miui.player.network.OnlineMusicProxy;
import com.miui.player.provider.PlayerProvider;
import com.miui.player.service.IMediaPlaybackService;
import com.miui.player.service.ServiceHelper;
import com.miui.player.ui.UIHelper;
import com.miui.player.ui.base.MusicApplication;
import com.miui.player.util.Actions;
import com.miui.player.util.MusicAnalyticsUtils;
import com.miui.player.util.PreferenceCache;
import com.miui.player.util.Utils;
import java.io.File;
import miui.analytics.XiaomiAnalytics;

public class DownloadIndicator implements OnClickListener {
    private static final int DOWNLOAD_COMPLETED = 2;
    private static final int DOWNLOAD_NONE = 0;
    private static final int DOWNLOAD_PROCESSING = 1;
    private final Activity mActivity;
    private final BroadcastReceiver mDownloadCompleteListener = new C04801();
    private final ImageView mIndicator;
    DownloadObserver mObserver;

    class C04801 extends BroadcastReceiver {
        C04801() {
        }

        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (Out.STATUS_META_CHANGED.equals(action)) {
                if (Out.META_CHANGED_TRACK.equals(intent.getStringExtra(Out.KEY_OTHER))) {
                    DownloadIndicator.this.refresh();
                }
            } else if (Actions.ACTION_ONLINE_DOWNLOAD_COMPLETE.equals(action)) {
                DownloadIndicator.this.refresh();
            }
        }
    }

    class C04812 implements Runnable {
        C04812() {
        }

        public void run() {
            DownloadIndicator.this.refresh();
            if (DownloadIndicator.this.mObserver != null) {
                DownloadIndicator.this.mObserver.onDownloadChanged();
            }
        }
    }

    public interface DownloadObserver {
        void onDownloadChanged();
    }

    public DownloadIndicator(Activity activity, ImageView icon) {
        this.mActivity = activity;
        this.mIndicator = icon;
        this.mIndicator.setOnClickListener(this);
    }

    public ImageView getIconView() {
        return this.mIndicator;
    }

    public void register() {
        IntentFilter filter = new IntentFilter();
        filter.addAction(Actions.ACTION_ONLINE_DOWNLOAD_COMPLETE);
        filter.addAction(Out.STATUS_META_CHANGED);
        this.mIndicator.getContext().registerReceiver(this.mDownloadCompleteListener, filter);
        refresh();
    }

    public void unregister() {
        UIHelper.unregistBroadcastReceiverSafe(this.mIndicator.getContext(), this.mDownloadCompleteListener);
    }

    public void update() {
        refresh();
    }

    void downloadRefresh(int status) {
        IMediaPlaybackService service = ServiceHelper.sService;
        boolean isOnline = false;
        if (service != null) {
            try {
                if (PlayerProvider.isOnlineAudio(service.getAudioId())) {
                    isOnline = true;
                }
            } catch (RemoteException e) {
            }
        }
        if (isOnline && status != 2 && Utils.isExternalStorageMounted()) {
            switch (status) {
                case 0:
                    this.mIndicator.setEnabled(true);
                    break;
                case 1:
                    this.mIndicator.setEnabled(false);
                    break;
            }
            if (this.mIndicator.isEnabled() && PreferenceCache.getPrefAsBoolean(this.mIndicator.getContext().getApplicationContext(), PreferenceCache.PREF_PLAY_AND_DOWNLOAD)) {
                this.mIndicator.setEnabled(false);
                return;
            }
            return;
        }
        this.mIndicator.setEnabled(false);
    }

    public void refresh() {
        int status = 0;
        IMediaPlaybackService service = ServiceHelper.sService;
        if (service != null) {
            try {
                String onlineId = service.getOnlineId();
                if (DownloadInfoManager.isDownloading(this.mIndicator.getContext(), onlineId) || DownloadInfoManager.isAudioLinkRequested(onlineId)) {
                    status = 1;
                } else {
                    String tr = service.getTrackName();
                    String ar = service.getArtistName();
                    status = 2;
                    for (String type : MetaManager.META_TYPE_MP3_ALL) {
                        File file = MetaManager.getSavedFile(tr, ar, type);
                        if (file == null || !file.isFile()) {
                            status = 0;
                            break;
                        }
                    }
                }
            } catch (RemoteException e) {
            }
        }
        downloadRefresh(status);
    }

    private void toggleDownload() {
        IMediaPlaybackService service = ServiceHelper.sService;
        if (service != null) {
            try {
                Audio audio = OnlineMusicProxy.newAudio(service.getOnlineId(), service.getTrackName(), service.getArtistName(), service.getAlbumName());
                if (audio != null) {
                    Context ctx = this.mIndicator.getContext();
                    MP3Downloader.startOnUIThread(this.mActivity, audio, new C04812());
                }
            } catch (RemoteException e) {
            }
        }
    }

    public void onClick(View v) {
        toggleDownload();
        XiaomiAnalytics analytics = XiaomiAnalytics.getInstance();
        analytics.startSession(MusicApplication.getApplication());
        analytics.trackEvent(MusicAnalyticsUtils.CLICK_NOWPLAYING_TOOL_DOWNLOAD);
        analytics.endSession();
    }

    public void setDownloadObserver(DownloadObserver observer) {
        this.mObserver = observer;
    }
}
