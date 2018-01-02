package com.ushareit.listenit;

import android.app.Notification;
import android.app.Notification.Action;
import android.app.Notification.Builder;
import android.app.PendingIntent;
import android.app.RemoteInput;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.RemoteViews;
import java.util.ArrayList;
import java.util.Iterator;

public class cv implements bt, bu {
    private Builder f9177a;

    public cv(Context context, Notification notification, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, RemoteViews remoteViews, int i, PendingIntent pendingIntent, PendingIntent pendingIntent2, Bitmap bitmap, int i2, int i3, boolean z, boolean z2, boolean z3, int i4, CharSequence charSequence4, boolean z4, String str, ArrayList<String> arrayList, Bundle bundle, int i5, int i6, Notification notification2, String str2, boolean z5, String str3, CharSequence[] charSequenceArr, RemoteViews remoteViews2, RemoteViews remoteViews3, RemoteViews remoteViews4) {
        this.f9177a = new Builder(context).setWhen(notification.when).setShowWhen(z2).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, remoteViews).setSound(notification.sound, notification.audioStreamType).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS).setOngoing((notification.flags & 2) != 0).setOnlyAlertOnce((notification.flags & 8) != 0).setAutoCancel((notification.flags & 16) != 0).setDefaults(notification.defaults).setContentTitle(charSequence).setContentText(charSequence2).setSubText(charSequence4).setContentInfo(charSequence3).setContentIntent(pendingIntent).setDeleteIntent(notification.deleteIntent).setFullScreenIntent(pendingIntent2, (notification.flags & 128) != 0).setLargeIcon(bitmap).setNumber(i).setUsesChronometer(z3).setPriority(i4).setProgress(i2, i3, z).setLocalOnly(z4).setExtras(bundle).setGroup(str2).setGroupSummary(z5).setSortKey(str3).setCategory(str).setColor(i5).setVisibility(i6).setPublicVersion(notification2).setRemoteInputHistory(charSequenceArr);
        if (remoteViews2 != null) {
            this.f9177a.setCustomContentView(remoteViews2);
        }
        if (remoteViews3 != null) {
            this.f9177a.setCustomBigContentView(remoteViews3);
        }
        if (remoteViews4 != null) {
            this.f9177a.setCustomHeadsUpContentView(remoteViews4);
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            this.f9177a.addPerson((String) it.next());
        }
    }

    public void mo1567a(cx cxVar) {
        Action.Builder builder = new Action.Builder(cxVar.mo1164a(), cxVar.mo1165b(), cxVar.mo1166c());
        if (cxVar.mo1169g() != null) {
            for (RemoteInput addRemoteInput : dn.m14983a(cxVar.mo1169g())) {
                builder.addRemoteInput(addRemoteInput);
            }
        }
        if (cxVar.mo1167d() != null) {
            builder.addExtras(cxVar.mo1167d());
        }
        builder.setAllowGeneratedReplies(cxVar.mo1168e());
        this.f9177a.addAction(builder.build());
    }

    public Builder mo1566a() {
        return this.f9177a;
    }

    public Notification mo1568b() {
        return this.f9177a.build();
    }
}
