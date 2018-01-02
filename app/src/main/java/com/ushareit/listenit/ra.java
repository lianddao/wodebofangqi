package com.ushareit.listenit;

import android.view.View;
import com.mopub.volley.DefaultRetryPolicy;

class ra extends rd {
    final /* synthetic */ rb f16379a;
    final /* synthetic */ lj f16380b;
    final /* synthetic */ View f16381c;
    final /* synthetic */ qs f16382d;

    ra(qs qsVar, rb rbVar, lj ljVar, View view) {
        this.f16382d = qsVar;
        this.f16379a = rbVar;
        this.f16380b = ljVar;
        this.f16381c = view;
        super();
    }

    public void mo2880a(View view) {
        this.f16382d.m25854b(this.f16379a.f16386b, false);
    }

    public void mo2881b(View view) {
        this.f16380b.m24449a(null);
        ja.m24150c(this.f16381c, (float) DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
        ja.m24135a(this.f16381c, 0.0f);
        ja.m24147b(this.f16381c, 0.0f);
        this.f16382d.m25848a(this.f16379a.f16386b, false);
        this.f16382d.f16358l.remove(this.f16379a.f16386b);
        this.f16382d.m25889j();
    }
}
