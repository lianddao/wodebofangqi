package com.ushareit.listenit;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.os.Build.VERSION;
import android.util.Log;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class ww implements ws {
    private static final Config f17497a = Config.ARGB_8888;
    private final xa f17498b;
    private final Set<Config> f17499c;
    private final int f17500d;
    private final wy f17501e;
    private int f17502f;
    private int f17503g;
    private int f17504h;
    private int f17505i;
    private int f17506j;
    private int f17507k;

    ww(int i, xa xaVar, Set<Config> set) {
        this.f17500d = i;
        this.f17502f = i;
        this.f17498b = xaVar;
        this.f17499c = set;
        this.f17501e = new wz();
    }

    public ww(int i) {
        this(i, m27165e(), m27166f());
    }

    public synchronized boolean mo3131a(Bitmap bitmap) {
        boolean z;
        if (bitmap == null) {
            throw new NullPointerException("Bitmap must not be null");
        } else if (bitmap.isMutable() && this.f17498b.mo3125c(bitmap) <= this.f17502f && this.f17499c.contains(bitmap.getConfig())) {
            int c = this.f17498b.mo3125c(bitmap);
            this.f17498b.mo3122a(bitmap);
            this.f17501e.mo3133a(bitmap);
            this.f17506j++;
            this.f17503g = c + this.f17503g;
            if (Log.isLoggable("LruBitmapPool", 2)) {
                Log.v("LruBitmapPool", "Put bitmap in pool=" + this.f17498b.mo3124b(bitmap));
            }
            m27163c();
            m27161b();
            z = true;
        } else {
            if (Log.isLoggable("LruBitmapPool", 2)) {
                Log.v("LruBitmapPool", "Reject bitmap from pool, bitmap: " + this.f17498b.mo3124b(bitmap) + ", is mutable: " + bitmap.isMutable() + ", is allowed config: " + this.f17499c.contains(bitmap.getConfig()));
            }
            z = false;
        }
        return z;
    }

    private void m27161b() {
        m27162b(this.f17502f);
    }

    public synchronized Bitmap mo3128a(int i, int i2, Config config) {
        Bitmap b;
        b = mo3132b(i, i2, config);
        if (b != null) {
            b.eraseColor(0);
        }
        return b;
    }

    @TargetApi(12)
    public synchronized Bitmap mo3132b(int i, int i2, Config config) {
        Bitmap a;
        a = this.f17498b.mo3121a(i, i2, config != null ? config : f17497a);
        if (a == null) {
            if (Log.isLoggable("LruBitmapPool", 3)) {
                Log.d("LruBitmapPool", "Missing bitmap=" + this.f17498b.mo3123b(i, i2, config));
            }
            this.f17505i++;
        } else {
            this.f17504h++;
            this.f17503g -= this.f17498b.mo3125c(a);
            this.f17501e.mo3134b(a);
            if (VERSION.SDK_INT >= 12) {
                a.setHasAlpha(true);
            }
        }
        if (Log.isLoggable("LruBitmapPool", 2)) {
            Log.v("LruBitmapPool", "Get bitmap=" + this.f17498b.mo3123b(i, i2, config));
        }
        m27163c();
        return a;
    }

    public void mo3129a() {
        if (Log.isLoggable("LruBitmapPool", 3)) {
            Log.d("LruBitmapPool", "clearMemory");
        }
        m27162b(0);
    }

    @SuppressLint({"InlinedApi"})
    public void mo3130a(int i) {
        if (Log.isLoggable("LruBitmapPool", 3)) {
            Log.d("LruBitmapPool", "trimMemory, level=" + i);
        }
        if (i >= 60) {
            mo3129a();
        } else if (i >= 40) {
            m27162b(this.f17502f / 2);
        }
    }

    private synchronized void m27162b(int i) {
        while (this.f17503g > i) {
            Bitmap a = this.f17498b.mo3120a();
            if (a == null) {
                if (Log.isLoggable("LruBitmapPool", 5)) {
                    Log.w("LruBitmapPool", "Size mismatch, resetting");
                    m27164d();
                }
                this.f17503g = 0;
            } else {
                this.f17501e.mo3134b(a);
                this.f17503g -= this.f17498b.mo3125c(a);
                a.recycle();
                this.f17507k++;
                if (Log.isLoggable("LruBitmapPool", 3)) {
                    Log.d("LruBitmapPool", "Evicting bitmap=" + this.f17498b.mo3124b(a));
                }
                m27163c();
            }
        }
    }

    private void m27163c() {
        if (Log.isLoggable("LruBitmapPool", 2)) {
            m27164d();
        }
    }

    private void m27164d() {
        Log.v("LruBitmapPool", "Hits=" + this.f17504h + ", misses=" + this.f17505i + ", puts=" + this.f17506j + ", evictions=" + this.f17507k + ", currentSize=" + this.f17503g + ", maxSize=" + this.f17502f + "\nStrategy=" + this.f17498b);
    }

    private static xa m27165e() {
        if (VERSION.SDK_INT >= 19) {
            return new xc();
        }
        return new wo();
    }

    private static Set<Config> m27166f() {
        Set hashSet = new HashSet();
        hashSet.addAll(Arrays.asList(Config.values()));
        if (VERSION.SDK_INT >= 19) {
            hashSet.add(null);
        }
        return Collections.unmodifiableSet(hashSet);
    }
}
