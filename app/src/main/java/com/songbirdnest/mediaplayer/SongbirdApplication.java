package com.songbirdnest.mediaplayer;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.os.IBinder;
import android.preference.PreferenceManager;
import android.util.Log;
import com.songbirdnest.analytics.Analytics;
import com.songbirdnest.database.friends.ArtistPhotoCache;
import com.songbirdnest.database.friends.FriendDatabaseHelper;
import com.songbirdnest.facebook.FacebookAPI;
import com.songbirdnest.mediaplayer.activities.MountedSDCard;
import com.songbirdnest.mediaplayer.service.IMediaServiceBinder;
import com.songbirdnest.mediaplayer.service.LockScreenService;
import com.songbirdnest.mediaplayer.service.SongbirdMedia;
import com.songbirdnest.mediaplayer.service.SongbirdMediaService;
import com.songbirdnest.mediaplayer.service.SongbirdMediaService.Stub;
import com.songbirdnest.soundboard.SoundBoardPrefs;
import com.songbirdnest.soundboard.SoundboardServer;
import com.songbirdnest.util.Logger;
import java.lang.Thread.UncaughtExceptionHandler;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SongbirdApplication extends Application {
    public static final String PROD_BUILD = "production";
    public static final String QA_BUILD = "qa";
    public static final String TAG = "SongbirdApplication";
    private BUILD_TYPE build_type;
    private int mActivityCount = 0;
    private ArrayList<IMediaServiceBinder> mBinders = new ArrayList();
    public String mBuild;
    private final ExecutorService mExecutor = Executors.newSingleThreadExecutor();
    private OnSharedPreferenceChangeListener mPrefsListener = new C01222();
    private boolean mSDCardMountedActivityShowing = false;
    private BroadcastReceiver mSDCardMountedReceiver = new C01211();
    private SongbirdMediaService mService = null;
    private boolean mServiceConnected = false;
    private ServiceConnection mServiceConnection = null;
    private SoundBoardPrefs soundBoardPrefs;

    class C01211 extends BroadcastReceiver {
        C01211() {
        }

        public void onReceive(Context context, Intent intent) {
            if (SongbirdApplication.this.mActivityCount != 0 && !SongbirdApplication.this.mSDCardMountedActivityShowing) {
                SongbirdApplication.this.mSDCardMountedActivityShowing = true;
                Log.e(SongbirdApplication.TAG, "Starting MountedSDCard");
                Intent i = new Intent(SongbirdApplication.this, MountedSDCard.class);
                i.addFlags(268435456);
                SongbirdApplication.this.startActivity(i);
            }
        }
    }

    class C01222 implements OnSharedPreferenceChangeListener {
        C01222() {
        }

        public void onSharedPreferenceChanged(SharedPreferences aSharedPreferences, String aKey) {
            if (aKey.equals(PrefKeys.ENABLE_LOCKSCREEN_WIDGET)) {
                boolean lockScreenWidgetEnabled = aSharedPreferences.getBoolean(aKey, true);
                Intent i = new Intent(SongbirdApplication.this, LockScreenService.class);
                if (lockScreenWidgetEnabled) {
                    SongbirdApplication.this.startService(i);
                } else {
                    SongbirdApplication.this.stopService(i);
                }
            }
        }
    }

    class C01233 implements UncaughtExceptionHandler {
        C01233() {
        }

        public void uncaughtException(Thread thread, Throwable ex) {
            Log.e(SongbirdApplication.TAG, "uncaughtException:", ex);
            Analytics.getAnalytics().trackError(Analytics.EVENT_UNCAUGHTEXCEPTION, ex);
        }
    }

    class C01244 implements ServiceConnection {
        C01244() {
        }

        public void onServiceConnected(ComponentName aName, IBinder aService) {
            SongbirdApplication.this.mService = Stub.asInterface(aService);
            SongbirdApplication.this.mServiceConnected = true;
            Iterator i$ = SongbirdApplication.this.mBinders.iterator();
            while (i$.hasNext()) {
                ((IMediaServiceBinder) i$.next()).onMediaServiceConnected(SongbirdApplication.this.mService);
            }
            SongbirdApplication.this.mBinders.clear();
        }

        public void onServiceDisconnected(ComponentName name) {
            SongbirdApplication.this.mServiceConnected = false;
            SongbirdApplication.this.mService = null;
        }
    }

    class C01255 implements Runnable {
        C01255() {
        }

        public void run() {
            try {
                FriendDatabaseHelper friendDatabaseHelper = FriendDatabaseHelper.getFriendDatabaseHelper(SongbirdApplication.this);
                friendDatabaseHelper.checkImageCapacity();
                friendDatabaseHelper.close();
                ArtistPhotoCache.get(SongbirdApplication.this.getApplicationContext()).cleanupPhotos();
            } catch (Exception e) {
                Logger.error(SongbirdApplication.this, "Problems cleaning up Photos", e);
            }
        }
    }

    public enum BUILD_TYPE {
        QA,
        PRODUCTION
    }

    public String getBuildType() {
        if (this.mBuild == null || this.mBuild.length() == 0) {
            return QA_BUILD;
        }
        return this.mBuild;
    }

    public BUILD_TYPE getAppBuildType() {
        if (this.build_type == null) {
            String buildType = getBuildType();
            this.build_type = BUILD_TYPE.QA;
            if (QA_BUILD.equalsIgnoreCase(buildType)) {
                this.build_type = BUILD_TYPE.QA;
            } else if ("production".equalsIgnoreCase(buildType)) {
                this.build_type = BUILD_TYPE.PRODUCTION;
            }
        }
        return this.build_type;
    }

    public void pegActivity() {
        this.mActivityCount++;
    }

    public void dePegActivity() {
        this.mActivityCount--;
    }

    public SongbirdMediaService getMediaService() {
        return this.mService;
    }

    public void getMediaService(IMediaServiceBinder aBinder) {
        if (this.mService == null) {
            this.mBinders.add(aBinder);
        } else {
            aBinder.onMediaServiceConnected(this.mService);
        }
    }

    public void setSDCardMountedActivityShowing(boolean aShowing) {
        this.mSDCardMountedActivityShowing = aShowing;
    }

    public SoundBoardPrefs getSoundBoardPrefs() {
        return this.soundBoardPrefs;
    }

    public void onCreate() {
        super.onCreate();
        this.mBuild = getResources().getString(C0116R.string.build_type);
        Analytics.getAnalytics().init(this);
        Thread.currentThread().setUncaughtExceptionHandler(new C01233());
        this.soundBoardPrefs = new SoundBoardPrefs(this);
        this.soundBoardPrefs.readPrefs();
        FacebookAPI.get().init(getApplicationContext());
        PreferenceManager.setDefaultValues(this, PrefKeys.PREFS_FILENAME, 0, C0116R.xml.preferences, false);
        Intent mediaServiceIntent = new Intent(this, SongbirdMedia.class);
        startService(mediaServiceIntent);
        if (this.mServiceConnection == null) {
            this.mServiceConnection = new C01244();
        }
        if (!this.mServiceConnected) {
            bindService(mediaServiceIntent, this.mServiceConnection, 1);
        }
        SharedPreferences prefs = getSharedPreferences(PrefKeys.PREFS_FILENAME, 0);
        if (prefs.getBoolean(PrefKeys.ENABLE_LOCKSCREEN_WIDGET, true)) {
            startService(new Intent(this, LockScreenService.class));
        }
        prefs.registerOnSharedPreferenceChangeListener(this.mPrefsListener);
        IntentFilter filter = new IntentFilter();
        filter.addAction("android.intent.action.MEDIA_EJECT");
        filter.addAction("android.intent.action.MEDIA_SHARED");
        filter.addDataScheme("file");
        registerReceiver(this.mSDCardMountedReceiver, filter);
    }

    protected void finalize() {
        Log.d(TAG, "finalize");
        unbindService(this.mServiceConnection);
        stopService(new Intent(this, SongbirdMedia.class));
        stopService(new Intent(this, LockScreenService.class));
        try {
            this.mExecutor.shutdown();
            SoundboardServer.get().shutdown();
            Analytics.getAnalytics().shutdown();
        } catch (Exception e) {
        }
        try {
            unregisterReceiver(this.mSDCardMountedReceiver);
        } catch (Exception e2) {
        }
    }

    public void cleanupPhotoImages() {
        executeTask(new C01255());
    }

    private boolean executeTask(Runnable aRunnable) {
        if (this.mExecutor.isShutdown() || this.mExecutor.isTerminated()) {
            return false;
        }
        try {
            this.mExecutor.execute(aRunnable);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
