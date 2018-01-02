package com.ushareit.listenit;

import android.text.Layout.Alignment;
import android.text.SpannableStringBuilder;
import android.util.Log;

public final class bpt {
    private long f7356a;
    private long f7357b;
    private SpannableStringBuilder f7358c;
    private Alignment f7359d;
    private float f7360e;
    private int f7361f;
    private int f7362g;
    private float f7363h;
    private int f7364i;
    private float f7365j;

    public bpt() {
        m9449a();
    }

    public void m9449a() {
        this.f7356a = 0;
        this.f7357b = 0;
        this.f7358c = null;
        this.f7359d = null;
        this.f7360e = Float.MIN_VALUE;
        this.f7361f = Integer.MIN_VALUE;
        this.f7362g = Integer.MIN_VALUE;
        this.f7363h = Float.MIN_VALUE;
        this.f7364i = Integer.MIN_VALUE;
        this.f7365j = Float.MIN_VALUE;
    }

    public bpr m9450b() {
        if (this.f7363h != Float.MIN_VALUE && this.f7364i == Integer.MIN_VALUE) {
            m9443c();
        }
        return new bpr(this.f7356a, this.f7357b, this.f7358c, this.f7359d, this.f7360e, this.f7361f, this.f7362g, this.f7363h, this.f7364i, this.f7365j);
    }

    public bpt m9446a(long j) {
        this.f7356a = j;
        return this;
    }

    public bpt m9453b(long j) {
        this.f7357b = j;
        return this;
    }

    public bpt m9448a(SpannableStringBuilder spannableStringBuilder) {
        this.f7358c = spannableStringBuilder;
        return this;
    }

    public bpt m9447a(Alignment alignment) {
        this.f7359d = alignment;
        return this;
    }

    public bpt m9444a(float f) {
        this.f7360e = f;
        return this;
    }

    public bpt m9445a(int i) {
        this.f7361f = i;
        return this;
    }

    public bpt m9452b(int i) {
        this.f7362g = i;
        return this;
    }

    public bpt m9451b(float f) {
        this.f7363h = f;
        return this;
    }

    public bpt m9455c(int i) {
        this.f7364i = i;
        return this;
    }

    public bpt m9454c(float f) {
        this.f7365j = f;
        return this;
    }

    private bpt m9443c() {
        if (this.f7359d != null) {
            switch (bps.f7355a[this.f7359d.ordinal()]) {
                case 1:
                    this.f7364i = 0;
                    break;
                case 2:
                    this.f7364i = 1;
                    break;
                case 3:
                    this.f7364i = 2;
                    break;
                default:
                    Log.w("WebvttCueBuilder", "Unrecognized alignment: " + this.f7359d);
                    this.f7364i = 0;
                    break;
            }
        }
        this.f7364i = Integer.MIN_VALUE;
        return this;
    }
}
