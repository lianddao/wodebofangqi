package com.ushareit.listenit;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class gag {
    public static void m21470a(Activity activity, String str) {
        ApplicationInfo applicationInfo = activity.getApplicationInfo();
        Intent intent = new Intent("android.intent.action.SEND");
        intent.putExtra("android.intent.extra.STREAM", Uri.fromFile(new File(applicationInfo.sourceDir)));
        intent.setType("*/*");
        intent.setPackage(str);
        activity.startActivity(intent);
    }

    public static boolean m21471a(Activity activity, int i) {
        if (BluetoothAdapter.getDefaultAdapter().isEnabled()) {
            m21469a(activity);
            return false;
        }
        activity.startActivityForResult(new Intent("android.bluetooth.adapter.action.REQUEST_ENABLE"), i);
        return true;
    }

    public static void m21469a(Activity activity) {
        try {
            ApplicationInfo applicationInfo = activity.getApplicationInfo();
            Intent intent = new Intent("android.intent.action.SEND");
            intent.putExtra("android.intent.extra.STREAM", Uri.fromFile(new File(applicationInfo.sourceDir)));
            intent.setType("*/*");
            if (m21472a((Context) activity, intent)) {
                activity.startActivityForResult(intent, 4098);
            }
        } catch (Exception e) {
            exw.m18449b("InviteHelper", e.toString());
            throw e;
        }
    }

    private static boolean m21472a(Context context, Intent intent) {
        try {
            ActivityInfo activityInfo;
            List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 65536);
            Map hashMap = new HashMap();
            for (ResolveInfo resolveInfo : queryIntentActivities) {
                activityInfo = resolveInfo.activityInfo;
                String str = activityInfo.applicationInfo.processName;
                if (str.contains("bluetooth")) {
                    hashMap.put(str, activityInfo);
                }
            }
            if (hashMap.size() == 0) {
                return false;
            }
            activityInfo = (ActivityInfo) hashMap.get("com.android.bluetooth");
            if (activityInfo == null) {
                activityInfo = (ActivityInfo) hashMap.get("com.mediatek.bluetooth");
            }
            if (activityInfo == null) {
                Iterator it = hashMap.values().iterator();
                if (it.hasNext()) {
                    activityInfo = (ActivityInfo) it.next();
                }
            }
            if (activityInfo != null) {
                intent.setComponent(new ComponentName(activityInfo.packageName, activityInfo.name));
                return true;
            }
            return false;
        } catch (Exception e) {
        }
    }
}
