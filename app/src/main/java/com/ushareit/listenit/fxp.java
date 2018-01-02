package com.ushareit.listenit;

import android.graphics.Rect;
import android.support.v4.widget.DrawerLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.ushareit.listenit.main.navigation.NavigationView;
import com.ushareit.listenit.widget.LISTENitViewPager;
import com.ushareit.listenit.widget.MainActionBar;
import java.util.ArrayList;
import java.util.List;

public class fxp extends fji {
    private MainActionBar f13688a;
    private int aj = 0;
    private fru ak;
    private final int al = 0;
    private of am = new fxr(this);
    private OnClickListener an = new fxs(this);
    private gju ao = new fxt(this);
    private OnClickListener ap = new fxu(this);
    private kx aq = new fxv(this);
    private hcd ar = new fxw(this);
    private LISTENitViewPager f13689b;
    private DrawerLayout f13690c;
    private NavigationView f13691d;
    private of f13692e;
    private Runnable f13693f;
    private List<fji> f13694g = new ArrayList();
    private fji f13695h;
    private fdi f13696i;

    public View mo2388a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View inflate = layoutInflater.inflate(C0349R.layout.main_fragment, viewGroup, false);
        this.f13688a = (MainActionBar) inflate.findViewById(C0349R.id.actionbar_view);
        this.f13690c = (DrawerLayout) inflate.findViewById(C0349R.id.drawer);
        this.f13690c.setDrawerListener(this.am);
        this.f13691d = (NavigationView) inflate.findViewById(C0349R.id.navigation_view);
        this.f13691d.setMainFragment(this);
        this.f13691d.setNightModeClickListener(this.ap);
        this.f13688a.setSearchVisibility(0);
        this.f13688a.setOnHomeClickListener(this.an);
        this.f13688a.setOnTabClickListener(this.ar);
        if (fqk.m20385k()) {
            this.f13688a.m26867a();
            this.f13691d.setNearbyClickListener(this.ao);
        }
        this.f13689b = (LISTENitViewPager) inflate.findViewById(C0349R.id.main_viewpager);
        this.f13695h = new fxh();
        this.f13694g.add(this.f13695h);
        if (fqo.m20421c()) {
            this.ak = new fru();
            this.f13694g.add(this.ak);
            this.f13689b.setOnPageChangeListener(this.aq);
            fij.m19323a();
        }
        this.f13696i = new fdi(m1328m().m709f(), this.f13694g);
        this.f13689b.setAdapter(this.f13696i);
        mo2607d();
        return inflate;
    }

    public void m21281U() {
        if (this.f13689b != null && this.f13696i != null && this.f13694g.size() == 1 && fqo.m20421c()) {
            this.f13689b.post(new fxq(this));
        }
    }

    public void m21282V() {
        if (this.f13690c != null && !this.f13690c.m110j(this.f13691d)) {
            this.f13690c.m108h(this.f13691d);
        }
    }

    public void mo2607d() {
        fez.m19057a(m1326l(), this.f13689b);
    }

    public void m21283W() {
        if (this.f13688a != null && fqk.m20385k()) {
            this.f13688a.m26867a();
        }
    }

    public void m21284X() {
        if (this.f13688a != null) {
            this.f13688a.m26870b();
        }
    }

    public void m21290a(Runnable runnable) {
        this.f13693f = runnable;
    }

    public void m21285Y() {
        this.f13693f = null;
    }

    public Rect m21286Z() {
        return this.f13691d.getRectOfNearbyItem();
    }

    public void mo2548a(gum com_ushareit_listenit_gum) {
    }

    public void mo201x() {
        if (this.f13690c.m110j(this.f13691d)) {
            this.f13691d.m24864a();
        }
        this.f13691d.m24866b();
        if (this.f13695h != null) {
            this.f13695h.mo201x();
        }
        m21281U();
        super.mo201x();
    }

    public void mo202y() {
        super.mo202y();
    }

    public boolean mo2549b() {
        if (this.f13690c != null && this.f13690c.m110j(this.f13691d)) {
            this.f13690c.m109i(this.f13691d);
            return true;
        } else if (this.f13689b == null || this.aj == 0) {
            return false;
        } else {
            this.f13689b.setCurrentItem(0);
            return true;
        }
    }

    public void mo171e() {
        super.mo171e();
    }

    public void mo203z() {
        this.f13691d.m24867c();
        super.mo203z();
    }

    public void m21289a(of ofVar) {
        this.f13692e = ofVar;
    }
}
