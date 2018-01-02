package com.ushareit.listenit;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView.OnItemClickListener;
import java.util.ArrayList;
import java.util.List;

public class fxh extends fji {
    private RecyclerView f13659a;
    private sh f13660b;
    private fdj f13661c;
    private List<gjc> f13662d = new ArrayList();
    private gum f13663e;
    private boolean f13664f = false;
    private OnItemClickListener f13665g = new fxm(this);
    private guo f13666h = new fxn(this);
    private BroadcastReceiver f13667i = new fxo(this);

    public View mo2388a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View inflate = layoutInflater.inflate(C0349R.layout.local_fragment, viewGroup, false);
        this.f13659a = (RecyclerView) inflate.findViewById(C0349R.id.recycler_view);
        this.f13660b = new LinearLayoutManager(m1326l());
        this.f13659a.setLayoutManager(this.f13660b);
        this.f13661c = new fdj(m1326l());
        this.f13661c.m18888a(this.f13665g);
        this.f13662d.clear();
        ab();
        this.f13661c.m18891a(this.f13662d);
        this.f13659a.setAdapter(this.f13661c);
        m21250b(m1326l());
        return inflate;
    }

    private void ab() {
        if (fqk.m20376b()) {
            this.f13662d.add(new gje());
        }
        this.f13662d.add(new gjb());
        this.f13662d.add(new gjd());
        this.f13662d.add(new gjf());
    }

    public void mo2548a(gum com_ushareit_listenit_gum) {
        this.f13663e = com_ushareit_listenit_gum;
        com_ushareit_listenit_gum.mo2416a(this.f13666h);
        mo2550c();
    }

    public void mo201x() {
        if (this.f13663e != null) {
            this.f13663e.mo2416a(this.f13666h);
            mo2550c();
        }
        super.mo201x();
    }

    public void mo202y() {
        if (this.f13663e != null) {
            this.f13663e.mo2430b(this.f13666h);
        }
        super.mo202y();
    }

    public void mo2550c() {
        hhx.m23867a(new fxi(this, "MainFragment.load"));
    }

    public void m21254U() {
        hhx.m23867a(new fxj(this, "MainFragment.asyncRefreshLocalSongs"));
    }

    public void m21255V() {
        hhx.m23867a(new fxk(this, "MainFragment.asyncRefreshPlaylist"));
    }

    public void m21256W() {
        hhx.m23867a(new fxl(this, "MainFragment.asyncRefreshFeatureCard"));
    }

    public boolean mo2549b() {
        return false;
    }

    public void mo171e() {
        super.mo171e();
    }

    public void mo203z() {
        m21253c(m1326l());
        super.mo203z();
    }

    private void m21250b(Context context) {
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("action_refresh_main_page");
            intentFilter.addAction("action_refresh_local_song");
            intentFilter.addAction("action_refresh_playlist");
            intentFilter.addAction("action_refresh_feature_card");
            ec.m16689a(context).m16693a(this.f13667i, intentFilter);
        } catch (Exception e) {
        }
    }

    private void m21253c(Context context) {
        try {
            ec.m16689a(context).m16692a(this.f13667i);
        } catch (Exception e) {
        }
    }

    public static void m21244X() {
        ec.m16689a(eys.m18562a()).m16694a(new Intent("action_refresh_main_page"));
    }

    public static void m21245Y() {
        ec.m16689a(eys.m18562a()).m16694a(new Intent("action_refresh_local_song"));
    }

    public static void m21246Z() {
        ec.m16689a(eys.m18562a()).m16694a(new Intent("action_refresh_playlist"));
    }

    public static void aa() {
        ec.m16689a(eys.m18562a()).m16694a(new Intent("action_refresh_feature_card"));
    }

    private void m21248a(int i, List<glc> list, int i2, int i3, int i4) {
        if (!this.f13664f) {
            this.f13664f = true;
            fii.m19289a(m1326l(), i, list, i2, i3, i4);
        }
    }
}
