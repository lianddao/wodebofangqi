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
import com.ushareit.listenit.fni;
import com.ushareit.listenit.fzi;
import com.ushareit.listenit.glh;
import com.ushareit.listenit.gmw;
import com.ushareit.listenit.gmx;
import com.ushareit.listenit.gmz;
import com.ushareit.listenit.gxs;
import com.ushareit.listenit.gyn;
import com.ushareit.listenit.theme.entry.CustomThemeTextView;
import com.ushareit.listenit.tv;

public class MyHomePageBlurView extends FrameLayout {
    private View f16018a;
    private ImageView f16019b;
    private ImageView f16020c;
    private View f16021d;
    private CustomThemeTextView f16022e;
    private CustomThemeTextView f16023f;
    private View f16024g;
    private gxs f16025h = new gmx(this);

    public MyHomePageBlurView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m25203a(context);
    }

    public MyHomePageBlurView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m25203a(context);
    }

    public MyHomePageBlurView(Context context) {
        super(context);
        m25203a(context);
    }

    private void m25203a(Context context) {
        View inflate = View.inflate(context, C0349R.layout.my_home_page_blur_view, this);
        this.f16018a = inflate.findViewById(C0349R.id.container);
        this.f16019b = (ImageView) inflate.findViewById(C0349R.id.icon);
        this.f16020c = (ImageView) inflate.findViewById(C0349R.id.cover_bg);
        this.f16024g = inflate.findViewById(C0349R.id.meng_ceng);
        this.f16021d = inflate.findViewById(C0349R.id.status_fake_bar);
        this.f16022e = (CustomThemeTextView) inflate.findViewById(C0349R.id.sub_title1);
        this.f16023f = (CustomThemeTextView) inflate.findViewById(C0349R.id.sub_title2);
        if (gyn.m23217b()) {
            int e = fbb.m18766e(getContext());
            int dimension = (int) getResources().getDimension(C0349R.dimen.common_dimens_200dp);
            gyn.m23224c(this.f16021d, e);
            gyn.m23224c(this.f16018a, e + dimension);
            return;
        }
        removeView(this.f16021d);
    }

    public void m25208a(fni com_ushareit_listenit_fni) {
        this.f16022e.setText(com_ushareit_listenit_fni.getPlN() + "");
        this.f16023f.setText(com_ushareit_listenit_fni.getSgN() + "");
        Object com_ushareit_listenit_glh = new glh(com_ushareit_listenit_fni.getId());
        fzi.m21404a(getContext(), com_ushareit_listenit_glh, com_ushareit_listenit_glh.m22364a(), this.f16019b, (int) C0349R.drawable.profile_photo_default, C0349R.drawable.profile_photo_default, tv.NORMAL, this.f16019b.getWidth() > 0 ? this.f16019b.getWidth() : 100, new gmw(this));
    }

    private void m25202a() {
        this.f16020c.setVisibility(0);
        this.f16024g.setVisibility(0);
        eqy b = eqy.m17366b(0.0f, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
        b.mo2252c(400);
        b.m17384a(new gmz(this));
        b.mo2234a();
    }
}
