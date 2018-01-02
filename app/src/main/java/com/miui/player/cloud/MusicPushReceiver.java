package com.miui.player.cloud;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import com.xiaomi.music.util.MusicLog;
import miui.accounts.ExtraAccountManager;

public class MusicPushReceiver extends BroadcastReceiver {
    private static final String TAG = "MusicPushReceiver";

    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (action != null) {
            String pushType = intent.getStringExtra("pushType");
            String pushName = intent.getStringExtra("pushName");
            String pushData = intent.getStringExtra("pushData");
            MusicLog.m395d(TAG, "receive broadcast { action=" + action + ", pushType=" + pushType + ", pushName=" + pushName + ", pushData=" + pushData + "}");
            if (!"watermark".equals(pushType)) {
                return;
            }
            if (ExtraAccountManager.getXiaomiAccount(context) == null) {
                Log.d(TAG, "account is null, don't start any sync.");
            } else if (!TextUtils.equals(String.valueOf(MusicSyncHelper.getCurrentVersion(context)), pushData)) {
                MusicSyncAdapter.requestSync(context);
            }
        }
    }
}
