package com.ushareit.listenit;

import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AbsListView.OnScrollListener;
import android.widget.FrameLayout;
import com.ushareit.listenit.popupview.BasePopupView;
import com.ushareit.listenit.popupview.ConfirmPopupView;
import com.ushareit.listenit.popupview.MenuPopupView;
import com.ushareit.listenit.widget.AllPlayView;
import com.ushareit.listenit.widget.IndexableListView;
import java.util.List;

public class fvs extends fji {
    private IndexableListView f13593a;
    private boolean aj = false;
    private boolean ak = false;
    private boolean al = false;
    private OnClickListener am;
    private OnClickListener an = new fvv(this);
    private OnClickListener ao = new fvw(this);
    private fdw ap = new fvx(this);
    private guo aq = new fwb(this);
    private OnScrollListener ar = new fwc(this);
    private fmb as = new fwe(this);
    private fml at = new fvu(this);
    private View f13594b;
    private FrameLayout f13595c;
    private AllPlayView f13596d;
    private fdt f13597e;
    private gum f13598f;
    private gal f13599g;
    private boolean f13600h;
    private boolean f13601i;

    public fvs(gal com_ushareit_listenit_gal, boolean z) {
        this.f13599g = com_ushareit_listenit_gal;
        this.f13600h = z;
        this.f13597e = new fdt(com_ushareit_listenit_gal);
    }

    public View mo2388a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View inflate = layoutInflater.inflate(C0349R.layout.list_fragment_no_title, viewGroup, false);
        this.f13593a = (IndexableListView) inflate.findViewById(C0349R.id.list_view);
        this.f13594b = inflate.findViewById(C0349R.id.progress_view);
        if (this.f13601i) {
            this.aj = gvj.m23034t(m1326l());
            this.f13593a.m26827a(!this.aj);
            m21118Z();
        } else {
            this.f13593a.setFastScrollEnabled(true);
        }
        this.f13597e.m18920a(this.ap);
        this.f13593a.setAdapter(this.f13597e);
        this.f13593a.setOnScrollListener(this.ar);
        if (fem.m18971b() && this.f13599g.mo2565a() == 0) {
            this.ak = true;
            this.f13595c = (FrameLayout) inflate.findViewById(C0349R.id.ad_container);
        }
        return inflate;
    }

    public void mo2548a(gum com_ushareit_listenit_gum) {
        this.f13598f = com_ushareit_listenit_gum;
        com_ushareit_listenit_gum.mo2416a(this.aq);
        if (this.f13599g.mo2565a() == 0 && gef.m21805a().m21835e()) {
            flw.m19819a().m19830a(this.as);
            fmc.m19867a().m19887a(this.at);
        }
        if (this.f13600h) {
            mo2611b(400);
        }
    }

    public void mo2550c() {
        mo2611b(0);
    }

    public void mo2611b(int i) {
        hhx.m23869a(new fvt(this, "ListFragment.load_" + this.f13599g.mo2565a()), 0, i);
    }

    public void m21135U() {
        if (this.f13598f != null) {
            this.f13598f.mo2416a(this.aq);
            if (this.f13599g.mo2565a() == 0 && gef.m21805a().m21835e()) {
                flw.m19819a().m19830a(this.as);
                fmc.m19867a().m19887a(this.at);
            }
            mo2550c();
        }
        if (this.f13595c != null && this.f13595c.getChildCount() > 0 && !fem.m18971b()) {
            this.f13595c.removeAllViews();
        }
    }

    public void m21136V() {
        if (this.f13598f != null) {
            this.f13598f.mo2430b(this.aq);
            if (this.f13599g.mo2565a() == 0 && gef.m21805a().m21835e()) {
                flw.m19819a().m19836b(this.as);
                fmc.m19867a().m19892b(this.at);
            }
        }
    }

    public void mo203z() {
        this.am = null;
        if (this.f13596d != null) {
            this.f13596d.setOnManagementClickListener(null);
            this.f13596d.setOnAllPlayClickListener(null);
            this.f13596d.setOnSortOrderListener(null);
        }
        if (this.f13598f != null) {
            this.f13598f.mo2430b(this.aq);
            if (this.f13599g.mo2565a() == 0 && gef.m21805a().m21835e()) {
                flw.m19819a().m19836b(this.as);
                fmc.m19867a().m19892b(this.at);
            }
        }
        super.mo203z();
    }

    public void m21137W() {
        this.f13601i = true;
    }

    public List<? extends gla> m21138X() {
        return this.f13597e.m18924b();
    }

    public int m21139Y() {
        return this.f13597e.getCount();
    }

    public boolean mo2549b() {
        return false;
    }

    private void m21118Z() {
        if (this.f13596d == null) {
            this.f13596d = new AllPlayView(m1326l());
            this.f13596d.setOnManagementClickListener(this.am);
            this.f13596d.setOnAllPlayClickListener(this.an);
            this.f13596d.setOnSortOrderListener(this.ao);
            this.f13596d.setVisibility(8);
        }
        this.f13596d.m26791a(this.f13597e.getCount());
        this.f13596d.setSortOrderIcon(this.aj ? C0349R.drawable.timestamps_sort : C0349R.drawable.music_name_sort);
        if (this.f13596d.getVisibility() != 0) {
            this.f13596d.setVisibility(0);
            this.f13593a.addHeaderView(this.f13596d);
        }
    }

    public void m21141a(OnClickListener onClickListener) {
        this.am = onClickListener;
    }

    private void m21121a(glg com_ushareit_listenit_glg) {
        if (!gef.m21805a().m21835e()) {
            m21127c(com_ushareit_listenit_glg);
        } else if (flw.m19819a().m19812e(com_ushareit_listenit_glg)) {
            flw.m19819a().m19840c(com_ushareit_listenit_glg);
        } else if (flw.m19819a().m19814g(com_ushareit_listenit_glg)) {
            flw.m19819a().m19831a(com_ushareit_listenit_glg);
        } else if (flw.m19819a().m19813f(com_ushareit_listenit_glg)) {
            flw.m19819a().m19837b(com_ushareit_listenit_glg);
        } else if (com_ushareit_listenit_glg.f14352t > 0) {
            m21124b(com_ushareit_listenit_glg);
        } else {
            m21127c(com_ushareit_listenit_glg);
        }
    }

    private void m21124b(glg com_ushareit_listenit_glg) {
        BasePopupView menuPopupView = new MenuPopupView(m1326l(), new gjy(m1328m(), com_ushareit_listenit_glg), com_ushareit_listenit_glg);
        menuPopupView.setTitle(m1329n().getString(C0349R.string.sync_song_item_menu_title));
        fyi com_ushareit_listenit_fyi = new fyi(menuPopupView);
        com_ushareit_listenit_fyi.m21347a(new fvz(this));
        gyn.m23197a(m1328m(), com_ushareit_listenit_fyi);
    }

    private void m21127c(glg com_ushareit_listenit_glg) {
        BasePopupView confirmPopupView = new ConfirmPopupView(m1326l());
        confirmPopupView.m25554a().setTitle((int) C0349R.string.sync_song_item_menu_title);
        confirmPopupView.m25556d().setContent((int) C0349R.string.sync_song_item_menu_content);
        confirmPopupView.setConfirmListener(new fwa(this, com_ushareit_listenit_glg));
        gyn.m23197a(m1328m(), new fyi(confirmPopupView));
    }
}
