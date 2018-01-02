package com.ushareit.listenit;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;

class acc {
    private final acf f4096a;
    private final ul f4097b;
    private final Handler f4098c;
    private boolean f4099d;
    private boolean f4100e;
    private tq<ul, ul, Bitmap, Bitmap> f4101f;
    private ace f4102g;
    private boolean f4103h;

    public acc(Context context, acf com_ushareit_listenit_acf, ul ulVar, int i, int i2) {
        this(com_ushareit_listenit_acf, ulVar, null, m5161a(context, ulVar, i, i2, tt.m26449a(context).m26458a()));
    }

    acc(acf com_ushareit_listenit_acf, ul ulVar, Handler handler, tq<ul, ul, Bitmap, Bitmap> tqVar) {
        this.f4099d = false;
        this.f4100e = false;
        if (handler == null) {
            handler = new Handler(Looper.getMainLooper(), new acg());
        }
        this.f4096a = com_ushareit_listenit_acf;
        this.f4097b = ulVar;
        this.f4098c = handler;
        this.f4101f = tqVar;
    }

    public void m5165a(uz<Bitmap> uzVar) {
        if (uzVar == null) {
            throw new NullPointerException("Transformation must not be null");
        }
        this.f4101f = this.f4101f.mo3081b(uzVar);
    }

    public void m5163a() {
        if (!this.f4099d) {
            this.f4099d = true;
            this.f4103h = false;
            m5162e();
        }
    }

    public void m5166b() {
        this.f4099d = false;
    }

    public void m5167c() {
        m5166b();
        if (this.f4102g != null) {
            tt.m26452a(this.f4102g);
            this.f4102g = null;
        }
        this.f4103h = true;
    }

    public Bitmap m5168d() {
        return this.f4102g != null ? this.f4102g.m5189a() : null;
    }

    private void m5162e() {
        if (this.f4099d && !this.f4100e) {
            this.f4100e = true;
            this.f4097b.m26556a();
            this.f4101f.mo3076b(new ach()).m26359a(new ace(this.f4098c, this.f4097b.m26560d(), SystemClock.uptimeMillis() + ((long) this.f4097b.m26558b())));
        }
    }

    void m5164a(ace com_ushareit_listenit_ace) {
        if (this.f4103h) {
            this.f4098c.obtainMessage(2, com_ushareit_listenit_ace).sendToTarget();
            return;
        }
        ace com_ushareit_listenit_ace2 = this.f4102g;
        this.f4102g = com_ushareit_listenit_ace;
        this.f4096a.mo572b(com_ushareit_listenit_ace.f4108b);
        if (com_ushareit_listenit_ace2 != null) {
            this.f4098c.obtainMessage(2, com_ushareit_listenit_ace2).sendToTarget();
        }
        this.f4100e = false;
        m5162e();
    }

    private static tq<ul, ul, Bitmap, Bitmap> m5161a(Context context, ul ulVar, int i, int i2, ws wsVar) {
        ux com_ushareit_listenit_ack = new ack(wsVar);
        ze com_ushareit_listenit_aci = new aci();
        return tt.m26453b(context).m26481a(com_ushareit_listenit_aci, ul.class).m26492a((Object) ulVar).m26494a(Bitmap.class).mo3075b(aaj.m4984b()).mo3077b(com_ushareit_listenit_ack).mo3080b(true).mo3078b(vq.NONE).mo3073b(i, i2);
    }
}
