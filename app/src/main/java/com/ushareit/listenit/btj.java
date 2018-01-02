package com.ushareit.listenit;

import android.annotation.TargetApi;
import android.content.Context;
import android.view.WindowManager;

@TargetApi(16)
public final class btj {
    private final btk f7706a;
    private final boolean f7707b;
    private final long f7708c;
    private final long f7709d;
    private long f7710e;
    private long f7711f;
    private long f7712g;
    private boolean f7713h;
    private long f7714i;
    private long f7715j;
    private long f7716k;

    public btj() {
        this(-1.0d, false);
    }

    public btj(Context context) {
        this((double) m9818a(context), true);
    }

    private btj(double d, boolean z) {
        this.f7707b = z;
        if (z) {
            this.f7706a = btk.m9825a();
            this.f7708c = (long) (1.0E9d / d);
            this.f7709d = (this.f7708c * 80) / 100;
            return;
        }
        this.f7706a = null;
        this.f7708c = -1;
        this.f7709d = -1;
    }

    public void m9822a() {
        this.f7713h = false;
        if (this.f7707b) {
            this.f7706a.m9829b();
        }
    }

    public void m9823b() {
        if (this.f7707b) {
            this.f7706a.m9830c();
        }
    }

    public long m9821a(long j, long j2) {
        long j3;
        long j4;
        long j5 = j * 1000;
        if (this.f7713h) {
            if (j != this.f7710e) {
                this.f7716k++;
                this.f7711f = this.f7712g;
            }
            if (this.f7716k >= 6) {
                j3 = this.f7711f + ((j5 - this.f7715j) / this.f7716k);
                if (m9820b(j3, j2)) {
                    this.f7713h = false;
                    j4 = j2;
                    j3 = j5;
                } else {
                    j4 = (this.f7714i + j3) - this.f7715j;
                }
                if (!this.f7713h) {
                    this.f7715j = j5;
                    this.f7714i = j2;
                    this.f7716k = 0;
                    this.f7713h = true;
                    m9824c();
                }
                this.f7710e = j;
                this.f7712g = j3;
                return (this.f7706a == null || this.f7706a.f7718a == 0) ? j4 : m9819a(j4, this.f7706a.f7718a, this.f7708c) - this.f7709d;
            } else if (m9820b(j5, j2)) {
                this.f7713h = false;
            }
        }
        j4 = j2;
        j3 = j5;
        if (this.f7713h) {
            this.f7715j = j5;
            this.f7714i = j2;
            this.f7716k = 0;
            this.f7713h = true;
            m9824c();
        }
        this.f7710e = j;
        this.f7712g = j3;
        if (this.f7706a == null) {
            return j4;
        }
    }

    protected void m9824c() {
    }

    private boolean m9820b(long j, long j2) {
        return Math.abs((j2 - this.f7714i) - (j - this.f7715j)) > 20000000;
    }

    private static long m9819a(long j, long j2, long j3) {
        long j4;
        long j5 = (((j - j2) / j3) * j3) + j2;
        if (j <= j5) {
            j4 = j5 - j3;
        } else {
            j4 = j5;
            j5 += j3;
        }
        if (j5 - j < j - j4) {
            return j5;
        }
        return j4;
    }

    private static float m9818a(Context context) {
        return ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getRefreshRate();
    }
}
