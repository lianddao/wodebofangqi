package com.ushareit.listenit;

import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.mopub.volley.DefaultRetryPolicy;
import com.ushareit.listenit.popupview.BasePopupView;
import com.ushareit.listenit.popupview.ConfirmPopupView;

public class fyi extends fji {
    private View f13721a;
    private FrameLayout f13722b;
    private BasePopupView f13723c;
    private fyv f13724d;
    private boolean f13725e = false;
    private boolean f13726f = false;
    private Runnable f13727g = new fyj(this);
    private OnClickListener f13728h = new fyk(this);
    private fyw f13729i = new fyl(this);

    public fyi(BasePopupView basePopupView) {
        this.f13723c = basePopupView;
    }

    public View mo2388a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View inflate = layoutInflater.inflate(C0349R.layout.popup_fragment_view, viewGroup, false);
        this.f13722b = (FrameLayout) inflate.findViewById(C0349R.id.container);
        this.f13721a = inflate.findViewById(C0349R.id.bg_mask);
        this.f13721a.setOnClickListener(this.f13728h);
        return inflate;
    }

    public void mo2548a(gum com_ushareit_listenit_gum) {
        this.f13723c.mo2995a(com_ushareit_listenit_gum);
    }

    public void mo201x() {
        if (!this.f13726f) {
            this.f13726f = true;
            m21334a(this.f13723c);
        }
        this.f13723c.mo2996b();
        super.mo201x();
    }

    public void mo202y() {
        this.f13723c.mo2997c();
        super.mo202y();
    }

    public void mo2550c() {
    }

    public void m21347a(fyv com_ushareit_listenit_fyv) {
        this.f13724d = com_ushareit_listenit_fyv;
    }

    public boolean mo2549b() {
        m21328V();
        return true;
    }

    private void m21334a(BasePopupView basePopupView) {
        if (basePopupView != null) {
            this.f13722b.removeAllViews();
            gyn.m23245h(this.f13722b, basePopupView.getGravity());
            basePopupView.setVisibility(4);
            basePopupView.setOnPopupNextListener(this.f13729i);
            this.f13722b.addView(basePopupView, -1, -2);
            basePopupView.postDelayed(this.f13727g, basePopupView.getGravity() == 17 ? 150 : 300);
        }
    }

    private void m21327U() {
        int d;
        if ((this.f13723c instanceof ConfirmPopupView) && ((ConfirmPopupView) this.f13723c).m25560i()) {
            d = fbb.m18764d(eys.m18562a()) / 2;
            int height = this.f13723c.getHeight();
            d = height + 30 < d ? (height / 2) + 30 : height < d ? height / 2 : d - (height / 2);
        } else {
            d = 0;
        }
        gyn.m23243g(this.f13722b, d);
    }

    private void m21338b(boolean z) {
        this.f13723c.setVisibility(0);
        int gravity = this.f13723c.getGravity();
        if (gravity == 80) {
            m21344g(z);
        } else if (gravity == 17) {
            m21345h(z);
        }
    }

    private void m21344g(boolean z) {
        eqy b = eqy.m17366b((float) this.f13723c.getHeight(), 0.0f);
        b.mo2252c(250);
        b.m17384a(new fyn(this));
        b.m17274a(new fyo(this));
        b.mo2234a();
        this.f13721a.setVisibility(0);
    }

    private void m21345h(boolean z) {
        eqy b = eqy.m17366b(0.0f, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
        b.mo2252c(250);
        b.m17384a(new fyp(this));
        b.m17274a(new fyq(this));
        b.mo2234a();
        this.f13721a.setVisibility(0);
    }

    private void m21330a(epm com_ushareit_listenit_epm) {
        int gravity = this.f13723c.getGravity();
        if (gravity == 80) {
            m21336b(com_ushareit_listenit_epm);
        } else if (gravity == 17) {
            m21340c(com_ushareit_listenit_epm);
        }
    }

    private void m21336b(epm com_ushareit_listenit_epm) {
        int height = this.f13723c.getHeight();
        eqy b = eqy.m17366b(0.0f, (float) height);
        b.mo2252c(100);
        b.m17384a(new fyr(this));
        b.m17274a(new fys(this, com_ushareit_listenit_epm));
        b.mo2234a();
    }

    private void m21340c(epm com_ushareit_listenit_epm) {
        eqy b = eqy.m17366b(DefaultRetryPolicy.DEFAULT_BACKOFF_MULT, 0.0f);
        b.mo2252c(100);
        b.m17384a(new fyt(this));
        b.m17274a(new fyu(this, com_ushareit_listenit_epm));
        b.mo2234a();
    }

    private void m21328V() {
        gyn.m23196a(m1328m(), (fji) this);
        if (this.f13724d != null) {
            this.f13724d.mo2507a();
        }
    }
}
