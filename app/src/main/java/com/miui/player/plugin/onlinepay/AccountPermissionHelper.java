package com.miui.player.plugin.onlinepay;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.music.login.LoginManager;
import com.baidu.music.model.User;
import com.miui.player.C0329R;
import com.miui.player.plugin.onlinesync.baidu.BaiduSdkEnvironment;
import com.miui.player.plugin.onlinesync.baidu.BaiduSdkEnvironment.EnvironmentListener;
import com.miui.player.ui.base.MusicApplication;
import com.miui.player.util.PreferenceCache;
import com.xiaomi.music.util.MusicLog;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AccountPermissionHelper {
    private static final Object BOUGHT_LOCK = new Object();
    public static final long DELAY_TIME = 10000;
    private static final String INPUT_DATE_FORMATE = "yyyy-MM-dd hh:mm:ss";
    private static final int LEVEL_VIP = 1;
    private static final long MILLISECOND_OF_ONE_DAY = 86400000;
    private static final int MSG_REFRESH_BOUGHT = 1;
    private static final int MSG_REFRESH_PERMISSION = 0;
    private static final String OUTPUT_DATE_FORMATE = "yyyy.MM.dd";
    private static final Object PERMISSION_LOCK = new Object();
    private static final String TAG = "AccountPermissionHelper";
    private static final long TIME_REMIND = 604800000;
    private static final Handler sBgHandler = new Handler(sBgThread.getLooper()) {
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 0:
                    ValueCallback<Boolean> callback = null;
                    if (msg.obj instanceof ValueCallback) {
                        callback = msg.obj;
                    }
                    AccountPermissionHelper.doRefreshVipPermission(callback);
                    return;
                case 1:
                    boolean hasBoughtVip = VipOrderHelper.doRefreshBoughtVip();
                    synchronized (AccountPermissionHelper.BOUGHT_LOCK) {
                        AccountPermissionHelper.sHasBoughtVip = hasBoughtVip;
                    }
                    MusicLog.m395d(AccountPermissionHelper.TAG, "sHasBoughtVip=" + AccountPermissionHelper.sHasBoughtVip);
                    return;
                default:
                    return;
            }
        }
    };
    private static final HandlerThread sBgThread = new HandlerThread("AccountPermissionHelperBgThread");
    private static EnvironmentListener sEnvListener = new C03706();
    private static boolean sHasBoughtVip = false;
    private static boolean sIsBind;
    private static boolean sIsVip;
    private static List<AccountPermissionListener> sListeners = new ArrayList();
    private static int sPermission = 2;
    private static boolean sVipInitialized;
    private static boolean sVipTimeOut;

    static class C03706 implements EnvironmentListener {
        C03706() {
        }

        public void onEnvironmentChanged(int state) {
            switch (state) {
                case 1:
                    AccountPermissionHelper.refreshVipPermission(true, null);
                    AccountPermissionHelper.refreshBoughtVip();
                    break;
                default:
                    AccountPermissionHelper.clear();
                    break;
            }
            AccountPermissionHelper.resetPerssion();
        }
    }

    public interface AccountPermissionListener {
        void onPeriodChanged(String str, String str2);

        void onPermissionChanged(int i);
    }

    static {
        sBgThread.start();
    }

    public static void addListener(AccountPermissionListener listener) {
        synchronized (sListeners) {
            sListeners.add(listener);
        }
    }

    public static boolean removeListener(AccountPermissionListener listener) {
        boolean remove;
        synchronized (sListeners) {
            remove = sListeners.remove(listener);
        }
        return remove;
    }

    private static void notifyPermissionChanged() {
        synchronized (sListeners) {
            for (final AccountPermissionListener l : sListeners) {
                executeInUIThread(new Runnable() {
                    public void run() {
                        l.onPermissionChanged(AccountPermissionHelper.sPermission);
                    }
                });
            }
        }
    }

    private static void notifyPeriodChanged() {
        synchronized (sListeners) {
            for (final AccountPermissionListener l : sListeners) {
                executeInUIThread(new Runnable() {
                    public void run() {
                        l.onPeriodChanged(AccountPermissionHelper.getVipStartDate(), AccountPermissionHelper.getVipEndDate());
                    }
                });
            }
        }
    }

    public static boolean allowNormalMusic() {
        return true;
    }

    public static boolean allowHDMusic() {
        boolean z;
        synchronized (PERMISSION_LOCK) {
            z = sIsBind;
        }
        return z;
    }

    public static boolean allowUHDMusic() {
        boolean z;
        synchronized (PERMISSION_LOCK) {
            z = sIsBind && sIsVip;
        }
        return z;
    }

    public static boolean allowMusic(int quality) {
        switch (quality) {
            case 0:
                return allowUHDMusic();
            case 1:
                return allowHDMusic();
            case 2:
                return allowNormalMusic();
            default:
                return false;
        }
    }

    public static void refreshVipPermission() {
        refreshVipPermission(false, null);
    }

    private static void refreshVipPermissionAsync(ValueCallback<Boolean> callback) {
        if (!sBgHandler.hasMessages(0)) {
            sBgHandler.sendMessage(sBgHandler.obtainMessage(0, callback));
        }
    }

    public static void refreshVipPermission(boolean forceRefresh, ValueCallback<Boolean> callback) {
        refreshVipPermission(forceRefresh, callback, 0);
    }

    public static void refreshVipPermission(boolean forceRefresh, final ValueCallback<Boolean> callback, long delayTime) {
        if (!sVipInitialized || forceRefresh) {
            Handler handler = new Handler(Looper.getMainLooper());
            Runnable c03684 = new Runnable() {
                public void run() {
                    AccountPermissionHelper.refreshVipPermissionInternal(callback);
                }
            };
            if (delayTime <= 0) {
                delayTime = 0;
            }
            handler.postDelayed(c03684, delayTime);
            return;
        }
        executeInUIThread((ValueCallback) callback);
    }

    private static void refreshVipPermissionInternal(final ValueCallback<Boolean> callback) {
        if (BaiduSdkEnvironment.getInstance().getStatus() == 1) {
            refreshVipPermissionAsync(callback);
        } else {
            BaiduSdkEnvironment.getInstance().init(new Runnable() {
                public void run() {
                    if (BaiduSdkEnvironment.getInstance().getStatus() == 1) {
                        AccountPermissionHelper.refreshVipPermissionAsync(callback);
                    } else {
                        AccountPermissionHelper.executeInUIThread(callback);
                    }
                }
            });
        }
    }

    private static void doRefreshVipPermission(ValueCallback<Boolean> callback) {
        MusicLog.m395d(TAG, "Refresh vip permission");
        boolean isVip = false;
        Context context = MusicApplication.getApplication();
        User user = LoginManager.getInstance(context).getUserVipLevel(context);
        if (user != null) {
            int errorCode = user.getErrorCode();
            MusicLog.m395d(TAG, "user.getErrorCode() = " + user.getErrorCode());
            MusicLog.m395d(TAG, "user.getErrorDescription() = " + user.getErrorDescription());
            if (errorCode == 50000) {
                int level = user.getLevel();
                if (level == 1) {
                    isVip = true;
                } else {
                    isVip = false;
                }
                if (!(TextUtils.isEmpty(user.getVipStartTime()) || TextUtils.isEmpty(user.getVipEndTime()))) {
                    refreshDate(user.getVipStartTime(), user.getVipEndTime());
                    sVipInitialized = true;
                }
                MusicLog.m395d(TAG, "vip level = " + level);
            }
        } else {
            MusicLog.m395d(TAG, "user is null");
        }
        setPermissionValue(true, isVip);
        if (isVip) {
            synchronized (BOUGHT_LOCK) {
                sHasBoughtVip = true;
            }
            PreferenceCache.setPrefAsBoolean(context, PreferenceCache.PREF_VIP_TIME_OUT, false);
        }
        resetPerssion();
        executeInUIThread((ValueCallback) callback);
        MusicLog.m395d(TAG, "Refresh vip permission end: isVip=" + isVip);
    }

    private static void refreshDate(String startTime, String endTime) {
        MusicLog.m395d(TAG, "vip start time = " + startTime + ", vip end time = " + endTime);
        SimpleDateFormat inputDateFormate = new SimpleDateFormat(INPUT_DATE_FORMATE);
        Date startDate = null;
        Date endDate = null;
        try {
            startDate = inputDateFormate.parse(startTime);
            endDate = inputDateFormate.parse(endTime);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (startDate != null && endDate != null) {
            boolean isVip;
            Date currentDate = new Date();
            sVipTimeOut = currentDate.after(endDate);
            Context context = MusicApplication.getApplication();
            PreferenceCache.setPrefAsString(context, PreferenceCache.PREF_VIP_START_TIME, startTime);
            PreferenceCache.setPrefAsString(context, PreferenceCache.PREF_VIP_END_TIME, endTime);
            synchronized (PERMISSION_LOCK) {
                isVip = sIsVip;
            }
            if (isVip && currentDate.after(startDate) && currentDate.before(endDate) && endDate.getTime() - currentDate.getTime() > 604800000) {
                PreferenceCache.setPrefAsBoolean(context, PreferenceCache.PREF_VIP_REMINDED, false);
            }
            notifyPeriodChanged();
        }
    }

    public static int getPermission() {
        return sPermission;
    }

    private static void resetPerssion() {
        int newPerssion;
        if (allowUHDMusic()) {
            newPerssion = 0;
        } else if (allowHDMusic()) {
            newPerssion = 1;
        } else {
            newPerssion = 2;
        }
        if (sPermission != newPerssion) {
            sPermission = newPerssion;
        }
        notifyPermissionChanged();
    }

    public static EnvironmentListener getEnvironmentListener() {
        return sEnvListener;
    }

    public static String getVipStartDate() {
        return getOutputDate(getInputDate(PreferenceCache.PREF_VIP_START_TIME));
    }

    public static String getVipEndDate() {
        return getOutputDate(getInputDate(PreferenceCache.PREF_VIP_END_TIME));
    }

    private static Date getInputDate(String prefKey) {
        String dateString = PreferenceCache.getPrefAsString(MusicApplication.getApplication(), prefKey);
        Date date = null;
        if (dateString != null) {
            try {
                date = new SimpleDateFormat(INPUT_DATE_FORMATE).parse(dateString);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return date;
    }

    private static String getOutputDate(Date date) {
        if (date != null) {
            return new SimpleDateFormat(OUTPUT_DATE_FORMATE).format(date);
        }
        return null;
    }

    public static boolean needRemind() {
        Date startDate = getInputDate(PreferenceCache.PREF_VIP_START_TIME);
        Date endDate = getInputDate(PreferenceCache.PREF_VIP_END_TIME);
        if (!(startDate == null || endDate == null)) {
            Date currentDate = new Date();
            if (currentDate.after(startDate) && currentDate.before(endDate) && endDate.getTime() - currentDate.getTime() <= 604800000) {
                return true;
            }
        }
        return false;
    }

    public static String getVipRemindText() {
        int remainDays = getVipRemainDays();
        if (remainDays < 0) {
            return null;
        }
        return MusicApplication.getApplication().getResources().getQuantityString(C0329R.plurals.Nvip_expired_remind, remainDays, new Object[]{Integer.valueOf(remainDays)});
    }

    public static int getVipRemainDays() {
        if (!needRemind()) {
            return -1;
        }
        return (int) Math.ceil((1.0d * ((double) (getInputDate(PreferenceCache.PREF_VIP_END_TIME).getTime() - new Date().getTime()))) / 8.64E7d);
    }

    public static boolean isVipTimeOut() {
        return sVipTimeOut;
    }

    public static boolean hasInitialized() {
        return sVipInitialized;
    }

    public static boolean hasBoughtVip() {
        boolean z;
        synchronized (PERMISSION_LOCK) {
            boolean isBind = sIsBind;
        }
        synchronized (BOUGHT_LOCK) {
            if (isBind) {
                if (sHasBoughtVip) {
                    z = true;
                }
            }
            z = false;
        }
        return z;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void refreshBoughtVip() {
        /*
        r2 = 1;
        r1 = BOUGHT_LOCK;
        monitor-enter(r1);
        r0 = sHasBoughtVip;	 Catch:{ all -> 0x0019 }
        if (r0 == 0) goto L_0x000a;
    L_0x0008:
        monitor-exit(r1);	 Catch:{ all -> 0x0019 }
    L_0x0009:
        return;
    L_0x000a:
        monitor-exit(r1);	 Catch:{ all -> 0x0019 }
        r0 = sBgHandler;
        r0 = r0.hasMessages(r2);
        if (r0 != 0) goto L_0x0009;
    L_0x0013:
        r0 = sBgHandler;
        r0.sendEmptyMessage(r2);
        goto L_0x0009;
    L_0x0019:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0019 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.miui.player.plugin.onlinepay.AccountPermissionHelper.refreshBoughtVip():void");
    }

    private static void clear() {
        MusicLog.m395d(TAG, "clear");
        setPermissionValue(false, false);
        sVipInitialized = false;
        sVipTimeOut = false;
        synchronized (BOUGHT_LOCK) {
            sHasBoughtVip = false;
        }
        resetPerssion();
        Context context = MusicApplication.getApplication();
        PreferenceCache.setPrefAsString(context, PreferenceCache.PREF_VIP_START_TIME, null);
        PreferenceCache.setPrefAsString(context, PreferenceCache.PREF_VIP_END_TIME, null);
        notifyPeriodChanged();
    }

    private static void executeInUIThread(Runnable run) {
        if (run != null) {
            new Handler(MusicApplication.getApplication().getMainLooper()).post(run);
        }
    }

    private static void executeInUIThread(final ValueCallback<Boolean> callback) {
        if (callback != null) {
            executeInUIThread(new Runnable() {
                public void run() {
                    boolean isVip;
                    synchronized (AccountPermissionHelper.PERMISSION_LOCK) {
                        isVip = AccountPermissionHelper.sIsVip;
                    }
                    callback.execute(Boolean.valueOf(isVip));
                }
            });
        }
    }

    private static void setPermissionValue(boolean isBind, boolean isVip) {
        MusicLog.m395d(TAG, "set sIsBind=" + isBind + ", sIsVip=" + isVip);
        synchronized (PERMISSION_LOCK) {
            sIsBind = isBind;
            sIsVip = isVip;
        }
    }
}
