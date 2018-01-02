package com.ushareit.listenit.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.ushareit.listenit.C0349R;
import com.ushareit.listenit.ListenItApp;
import com.ushareit.listenit.eys;
import com.ushareit.listenit.fjf;
import com.ushareit.listenit.fji;
import com.ushareit.listenit.fju;
import com.ushareit.listenit.foe;
import com.ushareit.listenit.fxx;
import com.ushareit.listenit.fxy;
import com.ushareit.listenit.fxz;
import com.ushareit.listenit.fya;
import com.ushareit.listenit.fyb;
import com.ushareit.listenit.fyc;
import com.ushareit.listenit.fyd;
import com.ushareit.listenit.fye;
import com.ushareit.listenit.fyf;
import com.ushareit.listenit.fyg;
import com.ushareit.listenit.fyh;
import com.ushareit.listenit.gum;
import com.ushareit.listenit.guo;
import com.ushareit.listenit.hbj;
import com.ushareit.listenit.hdo;
import com.ushareit.listenit.hgq;
import com.ushareit.listenit.hgt;
import com.ushareit.listenit.hgu;
import com.ushareit.listenit.hhx;
import com.ushareit.listenit.widget.MiniPlayerView;
import com.ushareit.listenit.widget.NormalPlayerView;

public class PlayerFragment extends fji {
    public MiniPlayerView f13250a;
    private hgq aj = new fyg(this);
    private fju ak = new fyh(this);
    private hgt al = new fxy(this);
    private hgu am = new fxz(this);
    private gum f13251b;
    private hbj f13252c;
    private NormalPlayerView f13253d;
    private hdo f13254e = new fyb(this);
    private OnClickListener f13255f = new fyc(this);
    private OnClickListener f13256g = new fyd(this);
    private foe f13257h = new fye(this);
    private guo f13258i = new fyf(this);

    public View mo2388a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View inflate = layoutInflater.inflate(C0349R.layout.player_fragment, viewGroup, false);
        this.f13250a = (MiniPlayerView) inflate.findViewById(C0349R.id.mini_player);
        this.f13253d = (NormalPlayerView) inflate.findViewById(C0349R.id.normal_player);
        this.f13253d.setOnBackClickListener(this.f13255f);
        this.f13253d.setOnDragHideListener(this.f13254e);
        this.f13250a.setOnMiniPlayerClickListener(this.f13256g);
        ((fjf) m1328m()).m4856b(this.ak);
        this.f13252c = this.f13250a;
        return inflate;
    }

    public void mo2387a(View view, Bundle bundle) {
        super.mo2387a(view, bundle);
    }

    public void mo2548a(gum com_ushareit_listenit_gum) {
        this.f13251b = com_ushareit_listenit_gum;
        com_ushareit_listenit_gum.mo2416a(this.f13258i);
        com_ushareit_listenit_gum.mo2412a(this.f13257h);
        com_ushareit_listenit_gum.mo2418a(this.aj);
        com_ushareit_listenit_gum.mo2420a(this.am);
        com_ushareit_listenit_gum.mo2419a(this.al);
        this.f13250a.m26893b(com_ushareit_listenit_gum);
        this.f13253d.m26958b(com_ushareit_listenit_gum);
    }

    public void mo2550c() {
    }

    public void mo201x() {
        if (this.f13251b != null) {
            this.f13251b.mo2416a(this.f13258i);
            this.f13251b.mo2412a(this.f13257h);
            this.f13251b.mo2418a(this.aj);
            this.f13252c.mo3119a(this.f13251b);
        }
        super.mo201x();
    }

    public void mo202y() {
        super.mo202y();
    }

    public void mo203z() {
        ((fjf) m1328m()).m4857c(this.ak);
        if (this.f13251b != null) {
            this.f13251b.mo2430b(this.f13258i);
            this.f13251b.mo2427b(this.f13257h);
            this.f13251b.mo2432b(this.aj);
            this.f13251b.mo2434b(this.am);
            this.f13251b.mo2433b(this.al);
        }
        super.mo203z();
    }

    public boolean mo2549b() {
        if (this.f13253d == null || this.f13252c != this.f13253d || !this.f13253d.isShown() || this.f13251b == null) {
            return false;
        }
        m20551V();
        return true;
    }

    public void m20550U() {
        if (this.f13252c != this.f13253d) {
            this.f13252c = this.f13253d;
            hhx.m23869a(new fxx(this), 0, 300);
        }
    }

    private void m20545W() {
        this.f13252c = this.f13253d;
        this.f13253d.setVisibility(0);
        this.f13253d.m26961d();
        this.f13253d.mo3119a(this.f13251b);
        ListenItApp listenItApp = (ListenItApp) eys.m18562a();
        if (listenItApp != null) {
            listenItApp.m4936b(true);
        }
    }

    public void m20551V() {
        this.f13252c = this.f13250a;
        this.f13250a.mo3119a(this.f13251b);
        this.f13253d.m26953a(new fya(this));
        ListenItApp listenItApp = (ListenItApp) eys.m18562a();
        if (listenItApp != null) {
            listenItApp.m4936b(false);
        }
    }
}
