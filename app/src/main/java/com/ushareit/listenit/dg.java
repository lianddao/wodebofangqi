package com.ushareit.listenit;

import android.app.Notification;
import android.app.Notification.Builder;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.SparseArray;
import android.widget.RemoteViews;
import java.util.ArrayList;
import java.util.List;

public class dg implements bt, bu {
    private Builder f9756a;
    private Bundle f9757b;
    private List<Bundle> f9758c = new ArrayList();
    private RemoteViews f9759d;
    private RemoteViews f9760e;

    public dg(Context context, Notification notification, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, RemoteViews remoteViews, int i, PendingIntent pendingIntent, PendingIntent pendingIntent2, Bitmap bitmap, int i2, int i3, boolean z, boolean z2, boolean z3, int i4, CharSequence charSequence4, boolean z4, ArrayList<String> arrayList, Bundle bundle, String str, boolean z5, String str2, RemoteViews remoteViews2, RemoteViews remoteViews3) {
        this.f9756a = new Builder(context).setWhen(notification.when).setShowWhen(z2).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, remoteViews).setSound(notification.sound, notification.audioStreamType).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS).setOngoing((notification.flags & 2) != 0).setOnlyAlertOnce((notification.flags & 8) != 0).setAutoCancel((notification.flags & 16) != 0).setDefaults(notification.defaults).setContentTitle(charSequence).setContentText(charSequence2).setSubText(charSequence4).setContentInfo(charSequence3).setContentIntent(pendingIntent).setDeleteIntent(notification.deleteIntent).setFullScreenIntent(pendingIntent2, (notification.flags & 128) != 0).setLargeIcon(bitmap).setNumber(i).setUsesChronometer(z3).setPriority(i4).setProgress(i2, i3, z);
        this.f9757b = new Bundle();
        if (bundle != null) {
            this.f9757b.putAll(bundle);
        }
        if (!(arrayList == null || arrayList.isEmpty())) {
            this.f9757b.putStringArray("android.people", (String[]) arrayList.toArray(new String[arrayList.size()]));
        }
        if (z4) {
            this.f9757b.putBoolean("android.support.localOnly", true);
        }
        if (str != null) {
            this.f9757b.putString("android.support.groupKey", str);
            if (z5) {
                this.f9757b.putBoolean("android.support.isGroupSummary", true);
            } else {
                this.f9757b.putBoolean("android.support.useSideChannel", true);
            }
        }
        if (str2 != null) {
            this.f9757b.putString("android.support.sortKey", str2);
        }
        this.f9759d = remoteViews2;
        this.f9760e = remoteViews3;
    }

    public void mo1567a(cx cxVar) {
        this.f9758c.add(dd.m13822a(this.f9756a, cxVar));
    }

    public Builder mo1566a() {
        return this.f9756a;
    }

    public Notification mo1568b() {
        SparseArray a = dd.m13824a(this.f9758c);
        if (a != null) {
            this.f9757b.putSparseParcelableArray("android.support.actionExtras", a);
        }
        this.f9756a.setExtras(this.f9757b);
        Notification build = this.f9756a.build();
        if (this.f9759d != null) {
            build.contentView = this.f9759d;
        }
        if (this.f9760e != null) {
            build.bigContentView = this.f9760e;
        }
        return build;
    }
}
