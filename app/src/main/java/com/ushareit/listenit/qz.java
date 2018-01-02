package com.ushareit.listenit;

import android.view.View;
import com.mopub.volley.DefaultRetryPolicy;

class qz extends rd {
    final /* synthetic */ rb f16376a;
    final /* synthetic */ lj f16377b;
    final /* synthetic */ qs f16378c;

    qz(qs qsVar, rb rbVar, lj ljVar) {
        this.f16378c = qsVar;
        this.f16376a = rbVar;
        this.f16377b = ljVar;
        super();
    }

    public void mo2880a(View view) {
        this.f16378c.m25854b(this.f16376a.f16385a, true);
    }

    public void mo2881b(View view) {
        this.f16377b.m24449a(null);
        ja.m24150c(view, (float) DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
        ja.m24135a(view, 0.0f);
        ja.m24147b(view, 0.0f);
        this.f16378c.m25848a(this.f16376a.f16385a, true);
        this.f16378c.f16358l.remove(this.f16376a.f16385a);
        this.f16378c.m25889j();
    }
}
