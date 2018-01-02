package com.ushareit.listenit;

import android.support.v7.widget.StaggeredGridLayoutManager;

public class te {
    public int f16578a;
    public int f16579b;
    public boolean f16580c;
    public boolean f16581d;
    final /* synthetic */ StaggeredGridLayoutManager f16582e;

    public void m26252a() {
        this.f16578a = -1;
        this.f16579b = Integer.MIN_VALUE;
        this.f16580c = false;
        this.f16581d = false;
    }

    public void m26254b() {
        this.f16579b = this.f16580c ? this.f16582e.f392a.mo3034d() : this.f16582e.f392a.mo3032c();
    }

    public void m26253a(int i) {
        if (this.f16580c) {
            this.f16579b = this.f16582e.f392a.mo3034d() - i;
        } else {
            this.f16579b = this.f16582e.f392a.mo3032c() + i;
        }
    }
}
