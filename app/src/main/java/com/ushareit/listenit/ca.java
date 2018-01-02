package com.ushareit.listenit;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.RemoteViews;
import java.util.ArrayList;

public class ca {
    int f7975A = 0;
    Notification f7976B;
    RemoteViews f7977C;
    RemoteViews f7978D;
    RemoteViews f7979E;
    public Notification f7980F = new Notification();
    public ArrayList<String> f7981G;
    public Context f7982a;
    public CharSequence f7983b;
    public CharSequence f7984c;
    PendingIntent f7985d;
    PendingIntent f7986e;
    RemoteViews f7987f;
    public Bitmap f7988g;
    public CharSequence f7989h;
    public int f7990i;
    int f7991j;
    boolean f7992k = true;
    public boolean f7993l;
    public cp f7994m;
    public CharSequence f7995n;
    public CharSequence[] f7996o;
    int f7997p;
    int f7998q;
    boolean f7999r;
    String f8000s;
    boolean f8001t;
    String f8002u;
    public ArrayList<bw> f8003v = new ArrayList();
    boolean f8004w = false;
    String f8005x;
    Bundle f8006y;
    int f8007z = 0;

    public ca(Context context) {
        this.f7982a = context;
        this.f7980F.when = System.currentTimeMillis();
        this.f7980F.audioStreamType = -1;
        this.f7991j = 0;
        this.f7981G = new ArrayList();
    }

    public ca m10535a(long j) {
        this.f7980F.when = j;
        return this;
    }

    public ca m10534a(int i) {
        this.f7980F.icon = i;
        return this;
    }

    public ca m10538a(CharSequence charSequence) {
        this.f7983b = m10532d(charSequence);
        return this;
    }

    public ca m10542b(CharSequence charSequence) {
        this.f7984c = m10532d(charSequence);
        return this;
    }

    public ca m10537a(RemoteViews remoteViews) {
        this.f7980F.contentView = remoteViews;
        return this;
    }

    public ca m10536a(PendingIntent pendingIntent) {
        this.f7985d = pendingIntent;
        return this;
    }

    public ca m10541b(PendingIntent pendingIntent) {
        this.f7980F.deleteIntent = pendingIntent;
        return this;
    }

    public ca m10546c(CharSequence charSequence) {
        this.f7980F.tickerText = m10532d(charSequence);
        return this;
    }

    public ca m10539a(boolean z) {
        m10531a(2, z);
        return this;
    }

    public ca m10543b(boolean z) {
        m10531a(16, z);
        return this;
    }

    public ca m10540b(int i) {
        this.f7980F.defaults = i;
        if ((i & 4) != 0) {
            Notification notification = this.f7980F;
            notification.flags |= 1;
        }
        return this;
    }

    private void m10531a(int i, boolean z) {
        if (z) {
            Notification notification = this.f7980F;
            notification.flags |= i;
            return;
        }
        notification = this.f7980F;
        notification.flags &= i ^ -1;
    }

    public ca m10545c(int i) {
        this.f7991j = i;
        return this;
    }

    public Notification m10533a() {
        return bv.f7787a.mo1308a(this, m10544b());
    }

    protected cb m10544b() {
        return new cb();
    }

    protected static CharSequence m10532d(CharSequence charSequence) {
        if (charSequence != null && charSequence.length() > 5120) {
            return charSequence.subSequence(0, 5120);
        }
        return charSequence;
    }
}
