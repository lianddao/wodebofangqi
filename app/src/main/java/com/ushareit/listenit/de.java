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

public class de implements bt, bu {
    private Builder f9644a;
    private final Bundle f9645b;
    private List<Bundle> f9646c = new ArrayList();
    private RemoteViews f9647d;
    private RemoteViews f9648e;

    public de(Context context, Notification notification, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, RemoteViews remoteViews, int i, PendingIntent pendingIntent, PendingIntent pendingIntent2, Bitmap bitmap, int i2, int i3, boolean z, boolean z2, int i4, CharSequence charSequence4, boolean z3, Bundle bundle, String str, boolean z4, String str2, RemoteViews remoteViews2, RemoteViews remoteViews3) {
        this.f9644a = new Builder(context).setWhen(notification.when).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, remoteViews).setSound(notification.sound, notification.audioStreamType).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS).setOngoing((notification.flags & 2) != 0).setOnlyAlertOnce((notification.flags & 8) != 0).setAutoCancel((notification.flags & 16) != 0).setDefaults(notification.defaults).setContentTitle(charSequence).setContentText(charSequence2).setSubText(charSequence4).setContentInfo(charSequence3).setContentIntent(pendingIntent).setDeleteIntent(notification.deleteIntent).setFullScreenIntent(pendingIntent2, (notification.flags & 128) != 0).setLargeIcon(bitmap).setNumber(i).setUsesChronometer(z2).setPriority(i4).setProgress(i2, i3, z);
        this.f9645b = new Bundle();
        if (bundle != null) {
            this.f9645b.putAll(bundle);
        }
        if (z3) {
            this.f9645b.putBoolean("android.support.localOnly", true);
        }
        if (str != null) {
            this.f9645b.putString("android.support.groupKey", str);
            if (z4) {
                this.f9645b.putBoolean("android.support.isGroupSummary", true);
            } else {
                this.f9645b.putBoolean("android.support.useSideChannel", true);
            }
        }
        if (str2 != null) {
            this.f9645b.putString("android.support.sortKey", str2);
        }
        this.f9647d = remoteViews2;
        this.f9648e = remoteViews3;
    }

    public void mo1567a(cx cxVar) {
        this.f9646c.add(dd.m13822a(this.f9644a, cxVar));
    }

    public Builder mo1566a() {
        return this.f9644a;
    }

    public Notification mo1568b() {
        Notification build = this.f9644a.build();
        Bundle a = dd.m13823a(build);
        Bundle bundle = new Bundle(this.f9645b);
        for (String str : this.f9645b.keySet()) {
            if (a.containsKey(str)) {
                bundle.remove(str);
            }
        }
        a.putAll(bundle);
        SparseArray a2 = dd.m13824a(this.f9646c);
        if (a2 != null) {
            dd.m13823a(build).putSparseParcelableArray("android.support.actionExtras", a2);
        }
        if (this.f9647d != null) {
            build.contentView = this.f9647d;
        }
        if (this.f9648e != null) {
            build.bigContentView = this.f9648e;
        }
        return build;
    }
}
