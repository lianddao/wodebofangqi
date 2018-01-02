package com.ushareit.listenit;

import android.view.View;
import com.mopub.volley.DefaultRetryPolicy;

class qw extends rd {
    final /* synthetic */ sv f16365a;
    final /* synthetic */ lj f16366b;
    final /* synthetic */ qs f16367c;

    qw(qs qsVar, sv svVar, lj ljVar) {
        this.f16367c = qsVar;
        this.f16365a = svVar;
        this.f16366b = ljVar;
        super();
    }

    public void mo2880a(View view) {
        this.f16367c.m25864k(this.f16365a);
    }

    public void mo2881b(View view) {
        this.f16366b.m24449a(null);
        ja.m24150c(view, (float) DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
        this.f16367c.m25861h(this.f16365a);
        this.f16367c.f16357k.remove(this.f16365a);
        this.f16367c.m25889j();
    }
}
