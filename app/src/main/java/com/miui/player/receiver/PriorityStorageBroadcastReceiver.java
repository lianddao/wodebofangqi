package com.miui.player.receiver;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.miui.player.C0329R;

public class PriorityStorageBroadcastReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
    }

    public static boolean isPriorityStorage(Context context) {
        int state = context.getPackageManager().getComponentEnabledSetting(new ComponentName(context, PriorityStorageBroadcastReceiver.class));
        if (state == 0) {
            return context.getResources().getBoolean(C0329R.bool.priority_storage);
        }
        if (state != 1) {
            return false;
        }
        return true;
    }

    public static void setPriorityStorage(Context context, boolean enabled) {
        context.getPackageManager().setComponentEnabledSetting(new ComponentName(context, PriorityStorageBroadcastReceiver.class), enabled ? 1 : 2, 1);
    }
}
