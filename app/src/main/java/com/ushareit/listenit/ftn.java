package com.ushareit.listenit;

import android.graphics.Bitmap;
import com.mopub.volley.DefaultRetryPolicy;

class ftn implements gxs {
    final /* synthetic */ ftl f13489a;

    ftn(ftl com_ushareit_listenit_ftl) {
        this.f13489a = com_ushareit_listenit_ftl;
    }

    public void mo2368a(Bitmap bitmap) {
        erj.m17570a(this.f13489a.f13483e, 0.0f);
        erj.m17570a(this.f13489a.f13481c, 0.0f);
        erj.m17570a(this.f13489a.f13484f, 0.0f);
        erj.m17570a(this.f13489a.f13485g, 0.0f);
        this.f13489a.f13483e.setVisibility(0);
        this.f13489a.f13481c.setVisibility(0);
        this.f13489a.f13481c.setText(this.f13489a.f13487i);
        this.f13489a.f13484f.setVisibility(0);
        this.f13489a.f13485g.setImageBitmap(bitmap);
        this.f13489a.f13485g.setVisibility(0);
        this.f13489a.f13482d.setVisibility(0);
        erl.m17583a(this.f13489a.f13483e).mo2272a(140).mo2278e(DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
        erl.m17583a(this.f13489a.f13481c).mo2272a(140).mo2278e(DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
        erl.m17583a(this.f13489a.f13484f).mo2272a(140).mo2278e(DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
        erl.m17583a(this.f13489a.f13485g).mo2272a(140).mo2278e(DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
    }
}
