package com.ushareit.listenit;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.animation.Interpolator;

public class sr {
    private int f16525a;
    private int f16526b;
    private int f16527c;
    private int f16528d;
    private Interpolator f16529e;
    private boolean f16530f;
    private int f16531g;

    public sr(int i, int i2) {
        this(i, i2, Integer.MIN_VALUE, null);
    }

    public sr(int i, int i2, int i3, Interpolator interpolator) {
        this.f16528d = -1;
        this.f16530f = false;
        this.f16531g = 0;
        this.f16525a = i;
        this.f16526b = i2;
        this.f16527c = i3;
        this.f16529e = interpolator;
    }

    public void m26184a(int i) {
        this.f16528d = i;
    }

    boolean m26186a() {
        return this.f16528d >= 0;
    }

    private void m26181a(RecyclerView recyclerView) {
        if (this.f16528d >= 0) {
            int i = this.f16528d;
            this.f16528d = -1;
            recyclerView.mo140h(i);
            this.f16530f = false;
        } else if (this.f16530f) {
            m26183b();
            if (this.f16529e != null) {
                recyclerView.ab.m26215a(this.f16525a, this.f16526b, this.f16527c, this.f16529e);
            } else if (this.f16527c == Integer.MIN_VALUE) {
                recyclerView.ab.m26217b(this.f16525a, this.f16526b);
            } else {
                recyclerView.ab.m26213a(this.f16525a, this.f16526b, this.f16527c);
            }
            this.f16531g++;
            if (this.f16531g > 10) {
                Log.e("RecyclerView", "Smooth Scroll action is being updated too frequently. Make sure you are not changing it unless necessary");
            }
            this.f16530f = false;
        } else {
            this.f16531g = 0;
        }
    }

    private void m26183b() {
        if (this.f16529e != null && this.f16527c < 1) {
            throw new IllegalStateException("If you provide an interpolator, you must set a positive duration");
        } else if (this.f16527c < 1) {
            throw new IllegalStateException("Scroll duration must be a positive number");
        }
    }

    public void m26185a(int i, int i2, int i3, Interpolator interpolator) {
        this.f16525a = i;
        this.f16526b = i2;
        this.f16527c = i3;
        this.f16529e = interpolator;
        this.f16530f = true;
    }
}
