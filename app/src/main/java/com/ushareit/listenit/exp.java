package com.ushareit.listenit;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class exp extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if ("android.intent.action.PACKAGE_ADDED".equalsIgnoreCase(action) || "android.intent.action.PACKAGE_REPLACED".equalsIgnoreCase(action)) {
            try {
                Intent intent2 = new Intent("com.ushareit.cmd.action.COMMAND_SYSTEM_EVENT");
                intent2.setPackage(context.getPackageName());
                intent2.putExtra("system_uri", intent.toUri(0));
                context.startService(intent2);
            } catch (Exception e) {
            }
        } else if ("com.ushareit.cmd.action.UPDATE_SETTING".equalsIgnoreCase(action)) {
            action = intent.getStringExtra("name");
            r1 = intent.getStringExtra("key");
            String stringExtra = intent.getStringExtra("value");
            exz com_ushareit_listenit_exz = new exz(context, action);
            action = com_ushareit_listenit_exz.m17993b(r1);
            com_ushareit_listenit_exz.m17991a(r1, stringExtra);
            euz.m18094a(context, r1, stringExtra, action);
        } else if ("com.ushareit.cmd.action.QUERY_SETTING".equalsIgnoreCase(action)) {
            action = intent.getStringExtra("name");
            r1 = intent.getStringExtra("key");
            euz.m18092a(context, r1, String.valueOf(new exz(context, action).m17999d(r1)));
        }
    }
}
