package com.miui.player.cloud;

import android.accounts.Account;
import android.content.ContentResolver;
import android.content.Context;
import android.os.Bundle;
import android.os.SystemClock;
import com.miui.player.cloud.MusicSyncHelper.SyncInfo;
import com.miui.player.util.Utils;
import com.xiaomi.music.cloud.AccountUtils;
import com.xiaomi.music.cloud.MusicAuthToken;
import com.xiaomi.music.cloud.MusicCloudServerException;
import com.xiaomi.music.util.MusicLog;
import com.xiaomi.music.util.ScheduleExecutor;
import java.io.IOException;
import java.util.concurrent.Callable;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import miui.accounts.ExtraAccountManager;
import miui.net.MiCloudSyncAdapterBase;
import miui.net.exception.MiCloudServerException;
import org.json.JSONException;

public class MusicSyncAdapter extends MiCloudSyncAdapterBase {
    public static final String AUTHORITY = "com.miui.player";
    private static final long PERIOD_BAIDU_SYNC = 172800;
    private static final long PERIOD_LOCAL_SYNC = 172800;
    private static final String PREF_BAIDU_SYNC = "MusicSyncAdapter_baidu_sync";
    private static final String PREF_LOCAL_SYNC = "MusicSyncAdapter_local_sync";
    static final String TAG = "MusicSyncAdapter";

    class C03431 implements Callable<Boolean> {
        C03431() {
        }

        public Boolean call() throws Exception {
            return Boolean.valueOf(MusicSyncDBHelper.syncFromBaidu(MusicSyncAdapter.this.mContext));
        }
    }

    public MusicSyncAdapter(Context context, boolean autoInitialize) {
        super(context, autoInitialize, AccountUtils.AUTH_TOKEN_TYPE);
    }

    protected void onPerformMiCloudSync(Bundle extras) throws MiCloudServerException {
        String str;
        String str2;
        long c = SystemClock.uptimeMillis();
        try {
            MusicLog.m399i(TAG, "-----------------------sync start--------------------");
            MusicSyncDBHelper.updateDatabase(this.mContext);
            MusicSyncDBHelper.syncByLocal(this.mContext);
            performSync(extras);
            performBaiduSync();
            MusicLog.m399i(TAG, "-----------------------sync success------------------");
            MusicLog.m399i(TAG, "-----------------------sync end----------------------");
            str = TAG;
            str2 = "Spend time=" + (SystemClock.uptimeMillis() - c);
        } catch (MusicCloudServerException e) {
            MusicLog.m397e(TAG, "MusicCloudServerException exception, code=" + e.getWrapped());
            MusicLog.m398e(TAG, "-----------------------sync exception----------------", e);
            MusicLog.m399i(TAG, "-----------------------sync end----------------------");
            str = TAG;
            str2 = "Spend time=" + (SystemClock.uptimeMillis() - c);
        } catch (Throwable th) {
            MusicLog.m399i(TAG, "-----------------------sync end----------------------");
            MusicLog.m401p(TAG, "Spend time=" + (SystemClock.uptimeMillis() - c));
        }
        MusicLog.m401p(str, str2);
    }

    private void performSync(Bundle extras) throws IllegalBlockSizeException, BadPaddingException, JSONException, IOException, MusicCloudServerException {
        if (Utils.isOnlineVaild()) {
            SyncInfo lastInfo = MusicSyncHelper.readSyncInfo(this.mContext);
            MusicLog.m395d(TAG, "Download start, tag=" + lastInfo);
            Account account = AccountUtils.getAccount(this.mContext);
            MusicAuthToken token = AccountUtils.getToken(this.mContext, account);
            SyncInfo newInfo = MusicSyncHelper.download(this.mContext, account, token, lastInfo);
            MusicSyncHelper.saveSyncInfo(this.mContext, newInfo);
            MusicLog.m395d(TAG, "Download end, tag=" + newInfo);
            MusicLog.m395d(TAG, "Upload start");
            MusicSyncHelper.upload(this.mContext, account, token);
            MusicLog.m395d(TAG, "Upload end");
        }
    }

    private static void requestSyncInternal(Context context) {
        Account xiaomiAccount = ExtraAccountManager.getXiaomiAccount(context);
        if (xiaomiAccount != null) {
            ContentResolver.requestSync(xiaomiAccount, "com.miui.player", new Bundle());
        }
    }

    public static boolean requestSync(Context context) {
        if (isCloudSyncable(context)) {
            MusicLog.m399i(TAG, "Request sync, syncable=true");
            requestSyncInternal(context);
            return true;
        }
        MusicLog.m399i(TAG, "Request sync, syncable=false");
        requestWithoutAccount(context);
        return false;
    }

    public static boolean isCloudSyncable(Context context) {
        if (!Utils.isCloudSyncEnable()) {
            return false;
        }
        Account account = ExtraAccountManager.getXiaomiAccount(context);
        if (account != null && ContentResolver.getMasterSyncAutomatically() && ContentResolver.getSyncAutomatically(account, "com.miui.player")) {
            return true;
        }
        return false;
    }

    public static void setCloudSyncable(Context context, boolean sync) {
        Account account = ExtraAccountManager.getXiaomiAccount(context);
        if (account != null) {
            ContentResolver.setSyncAutomatically(account, "com.miui.player", sync);
        }
    }

    private void performBaiduSync() {
        ScheduleExecutor.executeOnceInPeriod(this.mContext, PREF_BAIDU_SYNC, 172800, new C03431());
    }

    private static void requestWithoutAccount(final Context context) {
        ScheduleExecutor.executeOnceInPeriod(context, PREF_LOCAL_SYNC, 172800, new Callable<Boolean>() {
            public Boolean call() throws Exception {
                MusicSyncDBHelper.syncByLocal(context);
                return Boolean.valueOf(true);
            }
        });
    }
}
