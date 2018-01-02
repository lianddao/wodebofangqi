package com.ushareit.listenit;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AbsListView.OnScrollListener;
import android.widget.FrameLayout;
import com.ushareit.listenit.widget.OperatorView;
import com.ushareit.listenit.widget.dragsortlistview.DragSortListView;
import java.util.ArrayList;
import java.util.List;

public class fva extends fjm {
    private OperatorView aj;
    private boolean ak;
    private String al;
    private gal am;
    private boolean an = false;
    private boolean ao = false;
    private OnClickListener ap = new fvc(this);
    private OnClickListener aq = new fvd(this);
    private OnClickListener ar = new fve(this);
    private OnClickListener as = new fvf(this);
    private het at = new fvh(this);
    private fdn au = new fvi(this);
    private OnScrollListener av = new fvj(this);
    private View f13560d;
    private List<gld> f13561e = new ArrayList();
    private DragSortListView f13562f;
    private fdl f13563g;
    private View f13564h;
    private FrameLayout f13565i;

    public fva(gal com_ushareit_listenit_gal, boolean z) {
        this.am = com_ushareit_listenit_gal;
        this.ak = z;
        m19526a(true);
        fii.m19287a(m1326l(), this.am.mo2565a());
    }

    public void mo2603U() {
        View c = m19541c((int) C0349R.layout.drag_sort_list_fragment_with_title);
        this.f13560d = c.findViewById(C0349R.id.container);
        this.f13565i = (FrameLayout) c.findViewById(C0349R.id.operator_view);
        this.f13562f = (DragSortListView) c.findViewById(C0349R.id.list_view);
        this.f13564h = c.findViewById(C0349R.id.progress_view);
        this.f13563g = new fdl(this.am.mo2565a(), this.f13562f);
        this.f13563g.m18897a(this.au);
        this.f13562f.setAdapter(this.f13563g);
        this.f13562f.setOnScrollListener(this.av);
        m19537a(this.ap);
        if (gyn.m23217b()) {
            gyn.m23237e(this.f13560d, gyn.m23206b(m1326l()));
        }
        m21060W();
        this.f13562f.setDropListener(this.at);
        if (this.am.m20816e() != null && (this.am.m20816e() instanceof glc)) {
            this.an = m21071d(((glc) this.am.m20816e()).f14285e);
        }
    }

    private boolean m21071d(String str) {
        if (gyp.m23305s()) {
            String q = gyp.m23303q();
            if (!fbb.m18763c(q)) {
                return q.equals(str);
            }
        }
        return false;
    }

    public void mo2548a(gum com_ushareit_listenit_gum) {
        if (this.ak) {
            mo2550c();
        }
    }

    public void mo203z() {
        this.f13563g.m18902c();
        if (this.ao) {
            fxh.m21246Z();
        }
        super.mo203z();
    }

    public void mo2550c() {
        hhx.m23867a(new fvb(this));
    }

    public void mo2604c(String str) {
        this.al = str;
    }

    public boolean mo2549b() {
        return false;
    }

    private void m21060W() {
        if (this.aj == null) {
            this.aj = new OperatorView(m1326l());
            this.aj.setShowDelete(this.as);
            if (!(this.am.mo2565a() == 8 || this.am.mo2565a() == 4)) {
                this.aj.setShowAddToPlaylist(this.ar);
                this.aj.setShowPlayNext(this.aq);
            }
            this.aj.setVisibility(8);
        }
        gyn.m23243g(this.f13562f, 0);
        if (this.aj.getVisibility() != 0) {
            this.aj.setVisibility(0);
            this.f13565i.addView(this.aj);
            this.f13565i.setVisibility(0);
        }
    }

    private void m21064a(int i, int i2) {
        gld com_ushareit_listenit_gld = (gld) this.f13561e.get(i);
        this.f13561e.remove(com_ushareit_listenit_gld);
        this.f13561e.add(i2, com_ushareit_listenit_gld);
        if (this.an && gyp.m23285b()) {
            gyp.m23272a().mo2414a((glg) this.f13563g.m18899b(i), (glg) this.f13563g.m18899b(i2));
        }
    }

    private void m21061X() {
        if (this.am.mo2565a() == 8) {
            m19539a(m1329n().getString(C0349R.string.action_bar_song_select_title, new Object[]{Integer.valueOf(this.f13563g.m18894a())}), this.f13563g.m18894a(), this.f13563g.getCount());
            return;
        }
        m19539a(m1329n().getString(C0349R.string.action_bar_playlist_select_title, new Object[]{Integer.valueOf(this.f13563g.m18894a())}), this.f13563g.m18894a(), this.f13563g.getCount());
    }
}
