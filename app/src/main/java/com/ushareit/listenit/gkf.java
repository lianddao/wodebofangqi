package com.ushareit.listenit;

import android.content.Context;
import com.ushareit.listenit.popupview.BasePopupView;
import com.ushareit.listenit.popupview.MenuPopupView;
import java.util.ArrayList;
import java.util.List;

public abstract class gkf {
    private MenuPopupView f13398a;
    private String f13399b;
    private Context f13400c;
    private gla f13401d;
    private String f13402e;
    private List<gla> f13403f = new ArrayList();
    private fyv f13404g;
    private boolean f13405h;
    private int f13406i = -1;

    public abstract void mo2569a();

    public gkf(int i) {
        this.f13406i = i;
    }

    public int m20846r() {
        return this.f13406i;
    }

    public gkf m20821a(MenuPopupView menuPopupView) {
        this.f13398a = menuPopupView;
        return this;
    }

    public Context m20847s() {
        return this.f13398a != null ? this.f13398a.getContext() : this.f13400c;
    }

    public void m20823a(Context context) {
        this.f13400c = context;
    }

    public MenuPopupView m20848t() {
        return this.f13398a;
    }

    public gla m20849u() {
        return this.f13398a != null ? this.f13398a.getMediaItem() : this.f13401d;
    }

    public List<? extends gla> m20850v() {
        return this.f13403f;
    }

    public void m20827a(List<? extends gla> list) {
        if (list != null && list.size() != 0) {
            this.f13403f.addAll(list);
        }
    }

    public void m20826a(String str) {
        this.f13399b = str;
    }

    public String m20851w() {
        return this.f13398a != null ? this.f13398a.getParentName() : this.f13402e;
    }

    public void m20830b(String str) {
        this.f13402e = str;
    }

    public void m20825a(BasePopupView basePopupView) {
        if (this.f13398a != null) {
            this.f13398a.m12832a(basePopupView);
            return;
        }
        fyi com_ushareit_listenit_fyi = new fyi(basePopupView);
        com_ushareit_listenit_fyi.m21347a(this.f13404g);
        gyn.m23197a((ak) m20847s(), com_ushareit_listenit_fyi);
    }

    public void m20824a(fyv com_ushareit_listenit_fyv) {
        this.f13404g = com_ushareit_listenit_fyv;
    }

    public void m20828a(boolean z) {
        this.f13405h = z;
    }

    public boolean m20852x() {
        return this.f13405h;
    }

    public void m20853y() {
        if (this.f13398a != null) {
            this.f13398a.mo3063e();
        }
    }

    public void mo2691j() {
    }

    public void mo2571c() {
    }

    public void mo2700z() {
    }

    public void mo2579h() {
    }

    public void mo2570b() {
    }

    public void mo2573e() {
    }

    public void mo2575g() {
    }

    public void mo2692q() {
    }

    public void mo2698o() {
    }

    public void mo2699p() {
    }

    public void mo2694k() {
    }

    public void mo2574f() {
    }

    public void mo2572d() {
    }

    public void mo2695l() {
    }

    public void mo2696m() {
    }

    public void mo2697n() {
    }

    public void mo2693i() {
    }
}
