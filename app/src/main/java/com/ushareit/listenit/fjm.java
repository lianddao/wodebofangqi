package com.ushareit.listenit;

import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.ushareit.listenit.widget.ActionBarView;

public abstract class fjm extends fji {
    protected FrameLayout f12811a;
    protected int f12812b;
    protected String f12813c;
    private ActionBarView f12814d;
    private OnClickListener f12815e = new fjn(this);

    public abstract void mo2603U();

    public View mo2388a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View inflate = layoutInflater.inflate(C0349R.layout.common_activity_base, viewGroup, false);
        this.f12811a = (FrameLayout) inflate.findViewById(C0349R.id.content_view);
        this.f12814d = (ActionBarView) inflate.findViewById(C0349R.id.actionbar_view);
        this.f12814d.setOnHomeClickListener(this.f12815e);
        if (this.f12812b > 0) {
            this.f12814d.setTitle(this.f12812b);
        } else if (!fbb.m18763c(this.f12813c)) {
            this.f12814d.setTitle(this.f12813c);
        }
        mo2603U();
        return inflate;
    }

    public View m19541c(int i) {
        return View.inflate(m1326l(), i, this.f12811a);
    }

    public void m19543d(int i) {
        this.f12812b = i;
        if (this.f12814d != null) {
            this.f12814d.setTitle(i);
        }
    }

    public void mo2604c(String str) {
        this.f12813c = str;
        if (this.f12814d != null) {
            this.f12814d.setTitle(str);
        }
    }

    public void m19544e(int i) {
        if (this.f12814d != null) {
            this.f12814d.setSearchVisibility(i);
        }
    }

    public void m19545f(int i) {
        this.f12814d.setPartnerLogoVisibility(i);
    }

    public void m19538a(gal com_ushareit_listenit_gal) {
        this.f12814d.setListParams(com_ushareit_listenit_gal);
    }

    public void m19540b(boolean z) {
        this.f12814d.setSearchIconColor(z);
    }

    public void m19537a(OnClickListener onClickListener) {
        this.f12814d.setOnSelectAllClickListener(onClickListener);
    }

    public void m19539a(String str, int i, int i2) {
        this.f12814d.m26788a(str, i, i2);
    }

    public void m19536a(float f) {
        this.f12814d.m26787a(f);
    }

    public int m19534V() {
        return this.f12814d.getActionBarHeight();
    }
}
