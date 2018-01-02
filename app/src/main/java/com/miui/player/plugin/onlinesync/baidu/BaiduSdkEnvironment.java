package com.miui.player.plugin.onlinesync.baidu;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.miui.player.plugin.onlinepay.AccountPermissionHelper;
import com.miui.player.util.Utils;
import java.util.HashSet;
import java.util.Iterator;

public class BaiduSdkEnvironment {
    public static final int FAILURE = 2;
    private static final int MSG_FAILURE = 2;
    private static final int MSG_REQUEST_CLEAR = 1;
    private static final int MSG_REQUEST_INIT = 0;
    private static final int MSG_SUCCESS = 1;
    private static final int MSG_UNINIT = 0;
    public static final int SUCCESS = 1;
    public static final String TAG = "BaiduSdkEnvironment";
    public static final int UNINIT = 0;
    private static BaiduSdkEnvironment sInstance;
    private final Handler mBgHandler;
    private final HandlerThread mBgThread = new HandlerThread("BaiduSdkEnvironmentBackgroundThread");
    private HashSet<EnvironmentListener> mListeners = new HashSet();
    private int mStatus = 0;
    private final Handler mUIHandler = new Handler(Looper.getMainLooper()) {
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 0:
                    BaiduSdkEnvironment.this.mStatus = 0;
                    break;
                case 1:
                    BaiduSdkEnvironment.this.mStatus = 1;
                    break;
                case 2:
                    BaiduSdkEnvironment.this.mStatus = 2;
                    break;
            }
            if (msg.obj instanceof Runnable) {
                ((Runnable) msg.obj).run();
            }
            Log.d(BaiduSdkEnvironment.TAG, "baidu sdk env state: " + msg.what + ", notifyListener...");
            BaiduSdkEnvironment.this.notifyListeners();
        }
    };

    public interface EnvironmentListener {
        void onEnvironmentChanged(int i);
    }

    private BaiduSdkEnvironment() {
        this.mBgThread.start();
        this.mBgHandler = new Handler(this.mBgThread.getLooper()) {
            public void handleMessage(Message msg) {
                switch (msg.what) {
                    case 0:
                        BaiduSdkEnvironment.this.mUIHandler.obtainMessage(BaiduSdkManager.initSdkEnvironment() ? 1 : 2, msg.obj).sendToTarget();
                        return;
                    case 1:
                        BaiduSdkManager.clearSdkEnvironment();
                        BaiduSdkEnvironment.this.mUIHandler.obtainMessage(0).sendToTarget();
                        return;
                    default:
                        return;
                }
            }
        };
    }

    public static synchronized BaiduSdkEnvironment getInstance() {
        BaiduSdkEnvironment baiduSdkEnvironment;
        synchronized (BaiduSdkEnvironment.class) {
            if (sInstance == null) {
                sInstance = new BaiduSdkEnvironment();
            }
            baiduSdkEnvironment = sInstance;
        }
        return baiduSdkEnvironment;
    }

    public int getStatus() {
        return this.mStatus;
    }

    public void addListener(EnvironmentListener l) {
        synchronized (this.mListeners) {
            this.mListeners.add(l);
        }
    }

    public void removeListener(EnvironmentListener l) {
        synchronized (this.mListeners) {
            this.mListeners.remove(l);
        }
    }

    private void notifyListeners() {
        synchronized (this.mListeners) {
            Iterator i$ = this.mListeners.iterator();
            while (i$.hasNext()) {
                ((EnvironmentListener) i$.next()).onEnvironmentChanged(this.mStatus);
            }
        }
    }

    public void init() {
        init(null);
    }

    public void init(Runnable callback) {
        if (!Utils.isOnlineVaild()) {
            Log.e(TAG, "Cannot init Sdk Environment: online service is not valid.");
        }
        if (this.mStatus != 1) {
            this.mBgHandler.obtainMessage(0, callback).sendToTarget();
        } else if (callback != null) {
            callback.run();
        }
    }

    public void clear() {
        this.mBgHandler.obtainMessage(1).sendToTarget();
    }

    public void initialize() {
        addListener(AccountPermissionHelper.getEnvironmentListener());
        init();
    }
}
