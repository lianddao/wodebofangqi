package com.ushareit.listenit;

import android.util.SparseArray;

public class ss {
    public int f16532a = 0;
    private int f16533b = -1;
    private SparseArray<Object> f16534c;
    private int f16535d = 0;
    private int f16536e = 0;
    private boolean f16537f = false;
    private boolean f16538g = false;
    private boolean f16539h = false;
    private boolean f16540i = false;
    private boolean f16541j = false;

    static /* synthetic */ int m26187a(ss ssVar, int i) {
        int i2 = ssVar.f16536e + i;
        ssVar.f16536e = i2;
        return i2;
    }

    public boolean m26201a() {
        return this.f16538g;
    }

    public boolean m26202b() {
        return this.f16540i;
    }

    public int m26203c() {
        return this.f16533b;
    }

    public boolean m26204d() {
        return this.f16533b != -1;
    }

    public int m26205e() {
        return this.f16538g ? this.f16535d - this.f16536e : this.f16532a;
    }

    public String toString() {
        return "State{mTargetPosition=" + this.f16533b + ", mData=" + this.f16534c + ", mItemCount=" + this.f16532a + ", mPreviousLayoutItemCount=" + this.f16535d + ", mDeletedInvisibleItemCountSincePreviousLayout=" + this.f16536e + ", mStructureChanged=" + this.f16537f + ", mInPreLayout=" + this.f16538g + ", mRunSimpleAnimations=" + this.f16539h + ", mRunPredictiveAnimations=" + this.f16540i + '}';
    }
}
