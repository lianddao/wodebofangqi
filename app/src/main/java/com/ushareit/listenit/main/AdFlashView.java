package com.ushareit.listenit.main;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.ushareit.listenit.C0349R;
import com.ushareit.listenit.esi;
import com.ushareit.listenit.fet;
import com.ushareit.listenit.ffl;
import com.ushareit.listenit.fql;
import com.ushareit.listenit.fqo;
import com.ushareit.listenit.gii;
import com.ushareit.listenit.gij;
import com.ushareit.listenit.gik;

public class AdFlashView extends FrameLayout {
    private FrameLayout f15890a;
    private Runnable f15891b;
    private esi f15892c;
    private gik f15893d;
    private View f15894e;
    private OnClickListener f15895f = new gij(this);

    public AdFlashView(Context context) {
        super(context);
        m24797a(context);
    }

    public AdFlashView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m24797a(context);
    }

    public AdFlashView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m24797a(context);
    }

    private void m24797a(Context context) {
        this.f15894e = View.inflate(context, C0349R.layout.ad_flash_view, this);
        this.f15890a = (FrameLayout) this.f15894e.findViewById(C0349R.id.ad_container);
        this.f15894e.findViewById(C0349R.id.skip_button).setOnClickListener(this.f15895f);
        ((TextView) this.f15894e.findViewById(C0349R.id.app_version)).setText(fql.m20392d());
    }

    public void m24801a(ffl com_ushareit_listenit_ffl, esi com_ushareit_listenit_esi) {
        this.f15892c = com_ushareit_listenit_esi;
        fet.m19019a(this.f15890a, com_ushareit_listenit_esi, com_ushareit_listenit_ffl);
        this.f15891b = new gii(this);
        this.f15890a.postDelayed(this.f15891b, (long) fqo.m20425g());
    }

    public void setFlashCallback(gik com_ushareit_listenit_gik) {
        this.f15893d = com_ushareit_listenit_gik;
    }
}
