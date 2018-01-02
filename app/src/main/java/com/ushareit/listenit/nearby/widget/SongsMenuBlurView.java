package com.ushareit.listenit.nearby.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.mopub.volley.DefaultRetryPolicy;
import com.ushareit.listenit.C0349R;
import com.ushareit.listenit.eqy;
import com.ushareit.listenit.fbb;
import com.ushareit.listenit.fnl;
import com.ushareit.listenit.gnb;
import com.ushareit.listenit.gnc;
import com.ushareit.listenit.gne;
import com.ushareit.listenit.gxs;
import com.ushareit.listenit.gyn;
import com.ushareit.listenit.hhx;

public class SongsMenuBlurView extends FrameLayout {
    private View f16031a;
    private ImageView f16032b;
    private ImageView f16033c;
    private View f16034d;
    private gxs f16035e = new gnc(this);

    public SongsMenuBlurView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m25213a(context);
    }

    public SongsMenuBlurView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m25213a(context);
    }

    public SongsMenuBlurView(Context context) {
        super(context);
        m25213a(context);
    }

    private void m25213a(Context context) {
        View inflate = View.inflate(context, C0349R.layout.playlist_cover_view, this);
        this.f16031a = inflate.findViewById(C0349R.id.container);
        this.f16032b = (ImageView) inflate.findViewById(C0349R.id.cover);
        this.f16033c = (ImageView) inflate.findViewById(C0349R.id.cover_bg);
        this.f16034d = inflate.findViewById(C0349R.id.status_fake_bar);
        if (gyn.m23217b()) {
            int e = fbb.m18766e(getContext());
            int dimension = (int) getResources().getDimension(C0349R.dimen.common_dimens_250dp);
            gyn.m23224c(this.f16034d, e);
            gyn.m23224c(this.f16031a, e + dimension);
            return;
        }
        removeView(this.f16034d);
    }

    public void m25217a(fnl com_ushareit_listenit_fnl) {
        hhx.m23867a(new gnb(this, com_ushareit_listenit_fnl));
    }

    private void m25212a() {
        this.f16033c.setVisibility(0);
        eqy b = eqy.m17366b(0.0f, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
        b.mo2252c(1000);
        b.m17384a(new gne(this));
        b.mo2234a();
    }
}
