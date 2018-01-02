package com.miui.player.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.miui.player.cloud.MusicSyncHelper;
import com.miui.player.plugin.onlinesync.baidu.BaiduSdkEnvironment;
import com.xiaomi.music.util.MusicLog;

public class AccountBroadcastReceiver extends BroadcastReceiver {
    private static final String TAG = "AccountBroadcastReceiver";

    public void onReceive(Context context, Intent intent) {
        BaiduSdkEnvironment env = BaiduSdkEnvironment.getInstance();
        String action = intent.getAction();
        MusicLog.m395d(TAG, "action=" + action);
        if (action != null && "android.accounts.LOGIN_ACCOUNTS_PRE_CHANGED".equals(action)) {
            switch (intent.getIntExtra("extra_update_type", -1)) {
                case 1:
                    env.clear();
                    break;
                case 2:
                    env.initialize();
                    break;
            }
            MusicSyncHelper.handleAccountChange(context, intent);
        }
    }
}
