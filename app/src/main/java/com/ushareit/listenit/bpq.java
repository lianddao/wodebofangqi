package com.ushareit.listenit;

import android.text.Layout.Alignment;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

final class bpq {
    private String f7337a;
    private String f7338b;
    private List<String> f7339c;
    private String f7340d;
    private String f7341e;
    private int f7342f;
    private boolean f7343g;
    private int f7344h;
    private boolean f7345i;
    private int f7346j;
    private int f7347k;
    private int f7348l;
    private int f7349m;
    private int f7350n;
    private float f7351o;
    private Alignment f7352p;

    public bpq() {
        m9422a();
    }

    public void m9422a() {
        this.f7337a = "";
        this.f7338b = "";
        this.f7339c = Collections.emptyList();
        this.f7340d = "";
        this.f7341e = null;
        this.f7343g = false;
        this.f7345i = false;
        this.f7346j = -1;
        this.f7347k = -1;
        this.f7348l = -1;
        this.f7349m = -1;
        this.f7350n = -1;
        this.f7352p = null;
    }

    public void m9423a(String str) {
        this.f7337a = str;
    }

    public void m9428b(String str) {
        this.f7338b = str;
    }

    public void m9424a(String[] strArr) {
        this.f7339c = Arrays.asList(strArr);
    }

    public void m9430c(String str) {
        this.f7340d = str;
    }

    public int m9419a(String str, String str2, String[] strArr, String str3) {
        if (!this.f7337a.isEmpty() || !this.f7338b.isEmpty() || !this.f7339c.isEmpty() || !this.f7340d.isEmpty()) {
            int a = m9418a(m9418a(m9418a(0, this.f7337a, str, 1073741824), this.f7338b, str2, 2), this.f7340d, str3, 4);
            if (a == -1 || !Arrays.asList(strArr).containsAll(this.f7339c)) {
                return 0;
            }
            return (this.f7339c.size() * 4) + a;
        } else if (str2.isEmpty()) {
            return 1;
        } else {
            return 0;
        }
    }

    public int m9425b() {
        int i = 0;
        if (this.f7348l == -1 && this.f7349m == -1) {
            return -1;
        }
        int i2 = this.f7348l == 1 ? 1 : 0;
        if (this.f7349m == 1) {
            i = 2;
        }
        return i2 | i;
    }

    public boolean m9431c() {
        return this.f7346j == 1;
    }

    public boolean m9433d() {
        return this.f7347k == 1;
    }

    public bpq m9421a(boolean z) {
        this.f7347k = z ? 1 : 0;
        return this;
    }

    public bpq m9427b(boolean z) {
        this.f7348l = z ? 1 : 0;
        return this;
    }

    public bpq m9429c(boolean z) {
        this.f7349m = z ? 1 : 0;
        return this;
    }

    public String m9434e() {
        return this.f7341e;
    }

    public bpq m9432d(String str) {
        this.f7341e = btc.m9776d(str);
        return this;
    }

    public int m9435f() {
        if (this.f7343g) {
            return this.f7342f;
        }
        throw new IllegalStateException("Font color not defined");
    }

    public bpq m9420a(int i) {
        this.f7342f = i;
        this.f7343g = true;
        return this;
    }

    public boolean m9436g() {
        return this.f7343g;
    }

    public int m9437h() {
        if (this.f7345i) {
            return this.f7344h;
        }
        throw new IllegalStateException("Background color not defined.");
    }

    public bpq m9426b(int i) {
        this.f7344h = i;
        this.f7345i = true;
        return this;
    }

    public boolean m9438i() {
        return this.f7345i;
    }

    public Alignment m9439j() {
        return this.f7352p;
    }

    public int m9440k() {
        return this.f7350n;
    }

    public float m9441l() {
        return this.f7351o;
    }

    private static int m9418a(int i, String str, String str2, int i2) {
        if (str.isEmpty() || i == -1) {
            return i;
        }
        if (str.equals(str2)) {
            return i + i2;
        }
        return -1;
    }
}
