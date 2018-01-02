package com.ushareit.listenit;

import android.view.View;
import com.mopub.volley.DefaultRetryPolicy;

class qx extends rd {
    final /* synthetic */ sv f16368a;
    final /* synthetic */ lj f16369b;
    final /* synthetic */ qs f16370c;

    qx(qs qsVar, sv svVar, lj ljVar) {
        this.f16370c = qsVar;
        this.f16368a = svVar;
        this.f16369b = ljVar;
        super();
    }

    public void mo2880a(View view) {
        this.f16370c.m25866m(this.f16368a);
    }

    public void mo2882c(View view) {
        ja.m24150c(view, (float) DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
    }

    public void mo2881b(View view) {
        this.f16369b.m24449a(null);
        this.f16370c.m25863j(this.f16368a);
        this.f16370c.f16355i.remove(this.f16368a);
        this.f16370c.m25889j();
    }
}
