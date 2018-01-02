package com.ushareit.listenit;

import android.view.View;
import android.view.View.OnClickListener;
import com.ushareit.listenit.widget.IndexableListView;
import com.ushareit.listenit.widget.OperatorView;
import java.util.List;

public class fww extends fjm {
    private gal aj;
    private boolean ak = false;
    private OnClickListener al = new fwy(this);
    private OnClickListener am = new fxa(this);
    private OnClickListener an = new fxb(this);
    private OnClickListener ao = new fxc(this);
    private OnClickListener ap = new fxe(this);
    private fdw aq = new fxg(this);
    private View f13640d;
    private IndexableListView f13641e;
    private fdt f13642f;
    private View f13643g;
    private OperatorView f13644h;
    private boolean f13645i;

    public fww(gal com_ushareit_listenit_gal, boolean z) {
        this.aj = com_ushareit_listenit_gal;
        this.ak = z;
        this.f13642f = new fdt(com_ushareit_listenit_gal);
        m19526a(true);
    }

    public void mo2603U() {
        View c = m19541c((int) C0349R.layout.list_manage_fragment_with_title);
        this.f13640d = c.findViewById(C0349R.id.container);
        this.f13644h = (OperatorView) c.findViewById(C0349R.id.operator_view);
        this.f13641e = (IndexableListView) c.findViewById(C0349R.id.list_view);
        this.f13643g = c.findViewById(C0349R.id.progress_view);
        if (gyn.m23217b()) {
            gyn.m23237e(this.f13640d, gyn.m23206b(m1326l()));
        }
        if (this.f13645i) {
            this.f13644h.setShowAddToCurrPlaylist(this.al);
        } else {
            if (!(this.aj.mo2565a() == 9 || this.aj.mo2565a() == 17)) {
                this.f13644h.setShowDelete(this.ap);
            }
            if (!(this.aj.mo2565a() == 8 || this.aj.mo2565a() == 4)) {
                this.f13644h.setShowAddToPlaylist(this.ao);
                this.f13644h.setShowPlayNext(this.an);
            }
        }
        this.f13642f.m18920a(this.aq);
        this.f13642f.m18922a(true);
        m19537a(this.am);
        this.f13641e.setFastScrollEnabled(true);
        this.f13641e.setAdapter(this.f13642f);
        m21220W();
        if (!this.f13645i) {
            fii.m19287a(m1326l(), this.aj.mo2565a());
        }
    }

    public void mo2548a(gum com_ushareit_listenit_gum) {
    }

    public void mo201x() {
        if (this.ak) {
            this.ak = false;
            mo2550c();
        }
        super.mo201x();
    }

    public void mo202y() {
        super.mo202y();
    }

    public void mo203z() {
        this.f13642f.m18928e();
        super.mo203z();
    }

    public void mo2550c() {
        hhx.m23867a(new fwx(this));
    }

    public void m21235g(boolean z) {
        this.f13645i = z;
    }

    public void m21232a(List<? extends gla> list) {
        this.f13642f.m18921a((List) list);
    }

    public boolean mo2549b() {
        return false;
    }

    private void m21220W() {
        if (this.aj.mo2565a() == 4) {
            m19539a(m1329n().getString(C0349R.string.action_bar_playlist_select_title, new Object[]{Integer.valueOf(this.f13642f.m18926c())}), this.f13642f.m18926c(), this.f13642f.getCount());
            return;
        }
        m19539a(m1329n().getString(C0349R.string.action_bar_song_select_title, new Object[]{Integer.valueOf(this.f13642f.m18926c())}), this.f13642f.m18926c(), this.f13642f.getCount());
    }

    private void m21223a(List<glg> list, String str) {
        if (list.size() != 0 && !fbb.m18763c(str)) {
            String e = frd.m20621e(str);
            if (!fbb.m18763c(e)) {
                frd.m20608a((List) list, e);
            }
        }
    }
}
