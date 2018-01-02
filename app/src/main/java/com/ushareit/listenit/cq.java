package com.ushareit.listenit;

import android.app.Notification.Action;
import android.app.Notification.Builder;
import android.app.RemoteInput;
import android.os.Bundle;

class cq {
    public static void m12249a(Builder builder, cx cxVar) {
        Bundle bundle;
        Action.Builder builder2 = new Action.Builder(cxVar.mo1164a(), cxVar.mo1165b(), cxVar.mo1166c());
        if (cxVar.mo1169g() != null) {
            for (RemoteInput addRemoteInput : dn.m14983a(cxVar.mo1169g())) {
                builder2.addRemoteInput(addRemoteInput);
            }
        }
        if (cxVar.mo1167d() != null) {
            bundle = new Bundle(cxVar.mo1167d());
        } else {
            bundle = new Bundle();
        }
        bundle.putBoolean("android.support.allowGeneratedReplies", cxVar.mo1168e());
        builder2.addExtras(cxVar.mo1167d());
        builder.addAction(builder2.build());
    }
}
