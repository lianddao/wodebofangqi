package com.ushareit.listenit;

import android.util.Log;
import java.io.File;

public class xq implements xg {
    private static xq f17536a = null;
    private final xk f17537b = new xk();
    private final yb f17538c;
    private final File f17539d;
    private final int f17540e;
    private ud f17541f;

    public static synchronized xg m27208a(File file, int i) {
        xg xgVar;
        synchronized (xq.class) {
            if (f17536a == null) {
                f17536a = new xq(file, i);
            }
            xgVar = f17536a;
        }
        return xgVar;
    }

    protected xq(File file, int i) {
        this.f17539d = file;
        this.f17540e = i;
        this.f17538c = new yb();
    }

    private synchronized ud m27207a() {
        if (this.f17541f == null) {
            this.f17541f = ud.m26498a(this.f17539d, 1, 1, (long) this.f17540e);
        }
        return this.f17541f;
    }

    public File mo3135a(uv uvVar) {
        File file = null;
        try {
            uh a = m27207a().m26517a(this.f17538c.m27236a(uvVar));
            if (a != null) {
                file = a.m26542a(0);
            }
        } catch (Throwable e) {
            if (Log.isLoggable("DiskLruCacheWrapper", 5)) {
                Log.w("DiskLruCacheWrapper", "Unable to get from disk cache", e);
            }
        }
        return file;
    }

    public void mo3136a(uv uvVar, xi xiVar) {
        String a = this.f17538c.m27236a(uvVar);
        this.f17537b.m27201a(uvVar);
        uf b;
        try {
            b = m27207a().m26519b(a);
            if (b != null) {
                if (xiVar.mo3108a(b.m26524a(0))) {
                    b.m26525a();
                }
                b.m26527c();
            }
            this.f17537b.m27202b(uvVar);
        } catch (Throwable e) {
            try {
                if (Log.isLoggable("DiskLruCacheWrapper", 5)) {
                    Log.w("DiskLruCacheWrapper", "Unable to put to disk cache", e);
                }
                this.f17537b.m27202b(uvVar);
            } catch (Throwable th) {
                this.f17537b.m27202b(uvVar);
            }
        } catch (Throwable th2) {
            b.m26527c();
        }
    }

    public void mo3137b(uv uvVar) {
        try {
            m27207a().m26520c(this.f17538c.m27236a(uvVar));
        } catch (Throwable e) {
            if (Log.isLoggable("DiskLruCacheWrapper", 5)) {
                Log.w("DiskLruCacheWrapper", "Unable to delete from disk cache", e);
            }
        }
    }
}
