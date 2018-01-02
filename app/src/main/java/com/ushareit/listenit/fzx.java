package com.ushareit.listenit;

import android.net.Uri;
import java.io.File;
import java.io.InputStream;
import java.util.concurrent.atomic.AtomicBoolean;

class fzx implements vc<InputStream> {
    private glh f13793a;
    private ze<Uri, InputStream> f13794b;
    private String f13795c;
    private vc<InputStream> f13796d;
    private int f13797e;
    private int f13798f;

    public /* synthetic */ Object mo584a(tv tvVar) {
        return m21459b(tvVar);
    }

    public fzx(glh com_ushareit_listenit_glh, int i, int i2, ze<Uri, InputStream> zeVar) {
        this.f13793a = com_ushareit_listenit_glh;
        this.f13795c = com_ushareit_listenit_glh.m22364a();
        this.f13797e = i;
        this.f13798f = i2;
        this.f13794b = zeVar;
    }

    public InputStream m21459b(tv tvVar) {
        this.f13796d = m21456d();
        return this.f13796d != null ? (InputStream) this.f13796d.mo584a(tvVar) : null;
    }

    private vc<InputStream> m21456d() {
        String a = this.f13793a.m22364a();
        if (fbb.m18763c(a)) {
            return null;
        }
        File file = new File(gyn.m23253l(a));
        if (!file.exists()) {
            long currentTimeMillis = System.currentTimeMillis();
            AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            try {
                fqn.m20403a(a).m17007a(file).m16927b(new fzz(this, atomicBoolean)).m16924a(new fzy(this, atomicBoolean));
                synchronized (atomicBoolean) {
                    atomicBoolean.wait(30000);
                }
            } catch (Exception e) {
                exw.m18457e("fds", "download avator error=" + e.getMessage());
            }
            if (!atomicBoolean.get() || !file.exists()) {
                return null;
            }
            fir.m19377a(System.currentTimeMillis() - currentTimeMillis);
            if (this.f13794b != null) {
                return this.f13794b.mo546a(Uri.fromFile(file), this.f13797e, this.f13798f);
            }
            return null;
        } else if (this.f13794b != null) {
            return this.f13794b.mo546a(Uri.fromFile(file), this.f13797e, this.f13798f);
        } else {
            return null;
        }
    }

    public void mo585a() {
        if (this.f13796d != null) {
            this.f13796d.mo585a();
        }
    }

    public String mo586b() {
        return this.f13795c;
    }

    public void mo587c() {
        if (this.f13796d != null) {
            this.f13796d.mo587c();
        }
    }
}
