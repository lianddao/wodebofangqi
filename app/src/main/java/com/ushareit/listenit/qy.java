package com.ushareit.listenit;

import android.view.View;

class qy extends rd {
    final /* synthetic */ sv f16371a;
    final /* synthetic */ int f16372b;
    final /* synthetic */ int f16373c;
    final /* synthetic */ lj f16374d;
    final /* synthetic */ qs f16375e;

    qy(qs qsVar, sv svVar, int i, int i2, lj ljVar) {
        this.f16375e = qsVar;
        this.f16371a = svVar;
        this.f16372b = i;
        this.f16373c = i2;
        this.f16374d = ljVar;
        super();
    }

    public void mo2880a(View view) {
        this.f16375e.m25865l(this.f16371a);
    }

    public void mo2882c(View view) {
        if (this.f16372b != 0) {
            ja.m24135a(view, 0.0f);
        }
        if (this.f16373c != 0) {
            ja.m24147b(view, 0.0f);
        }
    }

    public void mo2881b(View view) {
        this.f16374d.m24449a(null);
        this.f16375e.m25862i(this.f16371a);
        this.f16375e.f16356j.remove(this.f16371a);
        this.f16375e.m25889j();
    }
}
