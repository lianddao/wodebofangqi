package com.miui.player.ui.base;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.preference.PreferenceManager;
import com.miui.player.asyncplayer.IPlayerHelper;
import com.miui.player.cloud.MusicSyncAdapter;
import com.miui.player.download.IDownloadInfoManager;
import com.miui.player.download.IDownloader;
import com.miui.player.network.DownloadInfoManager;
import com.miui.player.network.DownloadProvider;
import com.miui.player.network.OnlineMusicProxy.PlayerReporter;
import com.miui.player.network.PlayerHelper;
import com.miui.player.plugin.onlinesync.baidu.BaiduSdkEnvironment;
import com.miui.player.receiver.MediaButtonIntentReceiver;
import com.miui.player.reporter.IPlayerReporter;
import com.miui.player.service.MediaPlaybackService;
import com.miui.player.ui.model.AlbumListAdapter;
import com.miui.player.ui.model.ArtistListAdapter;
import com.miui.player.ui.model.MetaAdapter;
import com.miui.player.util.IDeviceCompat;
import com.miui.player.util.PhoneCompat;
import com.miui.player.util.PreferenceCache;
import com.xiaomi.music.util.MusicLog;

public class PhoneApplicationHelper extends ApplicationHelper {
    private final IDeviceCompat mDeviceCompat = new PhoneCompat();
    private final IDownloadInfoManager mDownloadInfoManager = new DownloadInfoManager();
    private final IDownloader mDownloader = new DownloadProvider();
    private final IPlayerHelper mPlayerHelper = new PlayerHelper();
    private final IPlayerReporter mReporter = new PlayerReporter();

    class C04781 extends BroadcastReceiver {
        C04781() {
        }

        public void onReceive(Context ctx, Intent intent) {
            BaiduSdkEnvironment env = BaiduSdkEnvironment.getInstance();
            String action = intent.getAction();
            MusicLog.m395d(ApplicationHelper.TAG, "action=" + action);
            if ("android.net.conn.CONNECTIVITY_CHANGE".equals(action)) {
                env.initialize();
            }
        }
    }

    static {
        AsyncTask.setDefaultExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
    }

    protected void ApplicationHelper() {
        MediaButtonIntentReceiver.setOneShot(false);
    }

    public void onApplicationCreate(Context context) {
        super.onApplicationCreate(context);
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(context);
        if (sp.contains(PreferenceCache.PREF_SYNCHRONIZE_PLAYLIST)) {
            boolean sync = sp.getBoolean(PreferenceCache.PREF_SYNCHRONIZE_PLAYLIST, false);
            MusicLog.m399i(TAG, "Music last sync state=" + sync);
            MusicSyncAdapter.setCloudSyncable(context, sync);
            sp.edit().remove(PreferenceCache.PREF_SYNCHRONIZE_PLAYLIST).apply();
        }
        IntentFilter i = new IntentFilter();
        i.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        context.registerReceiver(new C04781(), i);
    }

    public void onTrimMemory(int level) {
        super.onTrimMemory(level);
        AlbumListAdapter.removeCache();
        ArtistListAdapter.removeCache();
        MetaAdapter.removeCache();
    }

    public IPlayerReporter getReporter() {
        return this.mReporter;
    }

    public IDownloader getDownloader() {
        return this.mDownloader;
    }

    public Class<?> getServiceClass() {
        return MediaPlaybackService.class;
    }

    public IDownloadInfoManager getDownloadInfoManager() {
        return this.mDownloadInfoManager;
    }

    public IPlayerHelper getPlayerHelper() {
        return this.mPlayerHelper;
    }

    public IDeviceCompat getDeviceCompat() {
        return this.mDeviceCompat;
    }
}
