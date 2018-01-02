package com.ushareit.listenit;

import android.app.Notification;
import android.app.Notification.Builder;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.RemoteViews;
import java.util.ArrayList;
import java.util.Iterator;

public class ct implements bt, bu {
    private Builder f8917a;
    private Bundle f8918b;
    private RemoteViews f8919c;
    private RemoteViews f8920d;
    private RemoteViews f8921e;

    public ct(Context context, Notification notification, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, RemoteViews remoteViews, int i, PendingIntent pendingIntent, PendingIntent pendingIntent2, Bitmap bitmap, int i2, int i3, boolean z, boolean z2, boolean z3, int i4, CharSequence charSequence4, boolean z4, String str, ArrayList<String> arrayList, Bundle bundle, int i5, int i6, Notification notification2, String str2, boolean z5, String str3, RemoteViews remoteViews2, RemoteViews remoteViews3, RemoteViews remoteViews4) {
        this.f8917a = new Builder(context).setWhen(notification.when).setShowWhen(z2).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, remoteViews).setSound(notification.sound, notification.audioStreamType).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS).setOngoing((notification.flags & 2) != 0).setOnlyAlertOnce((notification.flags & 8) != 0).setAutoCancel((notification.flags & 16) != 0).setDefaults(notification.defaults).setContentTitle(charSequence).setContentText(charSequence2).setSubText(charSequence4).setContentInfo(charSequence3).setContentIntent(pendingIntent).setDeleteIntent(notification.deleteIntent).setFullScreenIntent(pendingIntent2, (notification.flags & 128) != 0).setLargeIcon(bitmap).setNumber(i).setUsesChronometer(z3).setPriority(i4).setProgress(i2, i3, z).setLocalOnly(z4).setGroup(str2).setGroupSummary(z5).setSortKey(str3).setCategory(str).setColor(i5).setVisibility(i6).setPublicVersion(notification2);
        this.f8918b = new Bundle();
        if (bundle != null) {
            this.f8918b.putAll(bundle);
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            this.f8917a.addPerson((String) it.next());
        }
        this.f8919c = remoteViews2;
        this.f8920d = remoteViews3;
        this.f8921e = remoteViews4;
    }

    public void mo1567a(cx cxVar) {
        cq.m12249a(this.f8917a, cxVar);
    }

    public Builder mo1566a() {
        return this.f8917a;
    }

    public Notification mo1568b() {
        this.f8917a.setExtras(this.f8918b);
        Notification build = this.f8917a.build();
        if (this.f8919c != null) {
            build.contentView = this.f8919c;
        }
        if (this.f8920d != null) {
            build.bigContentView = this.f8920d;
        }
        if (this.f8921e != null) {
            build.headsUpContentView = this.f8921e;
        }
        return build;
    }
}
