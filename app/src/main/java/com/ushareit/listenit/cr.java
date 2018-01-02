package com.ushareit.listenit;

import android.app.Notification;
import android.app.Notification.Builder;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.RemoteViews;
import java.util.ArrayList;

public class cr implements bt, bu {
    private Builder f8765a;
    private Bundle f8766b;
    private RemoteViews f8767c;
    private RemoteViews f8768d;

    public cr(Context context, Notification notification, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, RemoteViews remoteViews, int i, PendingIntent pendingIntent, PendingIntent pendingIntent2, Bitmap bitmap, int i2, int i3, boolean z, boolean z2, boolean z3, int i4, CharSequence charSequence4, boolean z4, ArrayList<String> arrayList, Bundle bundle, String str, boolean z5, String str2, RemoteViews remoteViews2, RemoteViews remoteViews3) {
        this.f8765a = new Builder(context).setWhen(notification.when).setShowWhen(z2).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, remoteViews).setSound(notification.sound, notification.audioStreamType).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS).setOngoing((notification.flags & 2) != 0).setOnlyAlertOnce((notification.flags & 8) != 0).setAutoCancel((notification.flags & 16) != 0).setDefaults(notification.defaults).setContentTitle(charSequence).setContentText(charSequence2).setSubText(charSequence4).setContentInfo(charSequence3).setContentIntent(pendingIntent).setDeleteIntent(notification.deleteIntent).setFullScreenIntent(pendingIntent2, (notification.flags & 128) != 0).setLargeIcon(bitmap).setNumber(i).setUsesChronometer(z3).setPriority(i4).setProgress(i2, i3, z).setLocalOnly(z4).setGroup(str).setGroupSummary(z5).setSortKey(str2);
        this.f8766b = new Bundle();
        if (bundle != null) {
            this.f8766b.putAll(bundle);
        }
        if (!(arrayList == null || arrayList.isEmpty())) {
            this.f8766b.putStringArray("android.people", (String[]) arrayList.toArray(new String[arrayList.size()]));
        }
        this.f8767c = remoteViews2;
        this.f8768d = remoteViews3;
    }

    public void mo1567a(cx cxVar) {
        cq.m12249a(this.f8765a, cxVar);
    }

    public Builder mo1566a() {
        return this.f8765a;
    }

    public Notification mo1568b() {
        this.f8765a.setExtras(this.f8766b);
        Notification build = this.f8765a.build();
        if (this.f8767c != null) {
            build.contentView = this.f8767c;
        }
        if (this.f8768d != null) {
            build.bigContentView = this.f8768d;
        }
        return build;
    }
}
