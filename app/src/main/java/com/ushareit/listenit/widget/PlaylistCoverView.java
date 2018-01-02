package com.ushareit.listenit.widget;

import android.content.Context;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.mopub.volley.DefaultRetryPolicy;
import com.ushareit.listenit.C0349R;
import com.ushareit.listenit.eqy;
import com.ushareit.listenit.fbb;
import com.ushareit.listenit.fsg;
import com.ushareit.listenit.fzi;
import com.ushareit.listenit.gla;
import com.ushareit.listenit.gxs;
import com.ushareit.listenit.gyn;
import com.ushareit.listenit.hdq;
import com.ushareit.listenit.hdr;
import com.ushareit.listenit.hds;
import com.ushareit.listenit.hdt;
import com.ushareit.listenit.tv;

public class PlaylistCoverView extends FrameLayout {
    private ImageView f17344a;
    private ImageView f17345b;
    private gxs f17346c = new hds(this);

    public PlaylistCoverView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m26968a(context);
    }

    public PlaylistCoverView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m26968a(context);
    }

    public PlaylistCoverView(Context context) {
        super(context);
        m26968a(context);
    }

    private void m26968a(Context context) {
        View inflate = View.inflate(context, C0349R.layout.playlist_cover_view, this);
        View findViewById = inflate.findViewById(C0349R.id.container);
        this.f17344a = (ImageView) inflate.findViewById(C0349R.id.cover);
        this.f17345b = (ImageView) inflate.findViewById(C0349R.id.cover_bg);
        View findViewById2 = inflate.findViewById(C0349R.id.status_fake_bar);
        if (gyn.m23217b()) {
            int e = fbb.m18766e(getContext());
            int dimension = (int) getResources().getDimension(C0349R.dimen.common_dimens_250dp);
            gyn.m23224c(findViewById2, e);
            gyn.m23224c(findViewById, dimension + e);
            return;
        }
        removeView(findViewById2);
    }

    public void setMediaItem(gla com_ushareit_listenit_gla) {
        int dimension = (int) getResources().getDimension(C0349R.dimen.common_dimens_155dp);
        if (com_ushareit_listenit_gla instanceof fsg) {
            fzi.m21397a(getContext(), Uri.parse(((fsg) com_ushareit_listenit_gla).f13358d), this.f17344a, tv.HIGH, dimension, new hdq(this));
            return;
        }
        fzi.m21402a(getContext(), com_ushareit_listenit_gla, this.f17344a, tv.HIGH, dimension, new hdr(this));
    }

    private void m26967a() {
        this.f17345b.setVisibility(0);
        eqy b = eqy.m17366b(0.0f, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
        b.mo2252c(400);
        b.m17384a(new hdt(this));
        b.mo2234a();
    }
}
