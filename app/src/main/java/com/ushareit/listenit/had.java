package com.ushareit.listenit;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class had extends hbh {
    private final TextView f15035k;
    private final View f15036l;
    private final ImageView f15037m;
    private final TextView f15038n;
    private final TextView f15039p;
    private Context f15040q;
    private fkp f15041r = new haf(this);
    private flh f15042s = new hag(this);
    private fko f15043t = new hah(this);
    private Runnable f15044u = new hai(this);

    public static View m23437a(ViewGroup viewGroup) {
        return LayoutInflater.from(viewGroup.getContext()).inflate(C0349R.layout.main_card_login_bar, viewGroup, false);
    }

    public had(Context context, View view) {
        super(context, view);
        this.f15040q = context;
        this.f15035k = (TextView) view.findViewById(C0349R.id.login_bar_slogan);
        m23443t();
        this.f15036l = view.findViewById(C0349R.id.login_bar_button);
        this.f15037m = (ImageView) view.findViewById(C0349R.id.login_bar_user_portrait);
        this.f15038n = (TextView) view.findViewById(C0349R.id.login_bar_user_name);
        this.f15039p = (TextView) view.findViewById(C0349R.id.login_bar_sync_state);
        m23444u();
    }

    private void m23443t() {
        switch ((int) (Math.random() * 4.0d)) {
            case 0:
                this.f15035k.setText(this.f15040q.getString(C0349R.string.login_bar_slogan));
                return;
            case 1:
                this.f15035k.setText(this.f15040q.getString(C0349R.string.login_bar_slogan2));
                return;
            case 2:
                this.f15035k.setText(this.f15040q.getString(C0349R.string.login_bar_slogan3));
                return;
            case 3:
                this.f15035k.setText(this.f15040q.getString(C0349R.string.login_bar_slogan4));
                return;
            default:
                return;
        }
    }

    private void m23444u() {
        this.f15036l.setOnClickListener(new hae(this));
    }

    public void mo2564a(gjc com_ushareit_listenit_gjc, int i) {
        if (gef.m21805a().m21835e()) {
            this.f15035k.setVisibility(8);
            this.f15036l.setVisibility(8);
            this.f15037m.setVisibility(0);
            Bitmap i2 = gyn.m23247i();
            if (i2 != null) {
                this.f15037m.setImageBitmap(i2);
            } else {
                this.f15037m.setImageResource(C0349R.drawable.profile_photo_default);
            }
            this.f15038n.setVisibility(0);
            this.f15038n.setText(gef.m21805a().m21836f());
            fkb.m19610a().m19640a(this.f15041r);
            fkb.m19610a().m19639a(this.f15043t);
            fle.m19717b().m19724a(this.f15042s);
            m23438a(fkb.m19610a().m19647e());
            return;
        }
        this.f15039p.setVisibility(8);
        this.f15035k.setVisibility(0);
        this.f15036l.setVisibility(0);
        this.f15037m.setVisibility(8);
        this.f15038n.setVisibility(8);
    }

    public void mo2563s() {
        if (gef.m21805a().m21835e()) {
            fkb.m19610a().m19644b(this.f15041r);
            fkb.m19610a().m19643b(this.f15043t);
            fle.m19717b().m19729b(this.f15042s);
        }
    }

    private void m23438a(fkq com_ushareit_listenit_fkq) {
        exw.m18443a("LoginBarViewHolder", "initSyncState=" + com_ushareit_listenit_fkq);
        this.f15039p.setVisibility(gef.m21805a().m21835e() ? 0 : 8);
        if (!m23447x()) {
            com_ushareit_listenit_fkq = fkq.FINISH;
        }
        switch (haj.f15051a[com_ushareit_listenit_fkq.ordinal()]) {
            case 1:
            case 2:
            case 3:
                m23448y();
                return;
            case 4:
                m23449z();
                m23445v();
                return;
            default:
                return;
        }
    }

    private void m23445v() {
        Pair a = eyw.m18568a(this.f15040q);
        ((Boolean) a.first).booleanValue();
        boolean booleanValue = ((Boolean) a.second).booleanValue();
        int k = frf.m20685k() + frf.m20684j();
        boolean a2 = fle.m19717b().m19727a();
        if (booleanValue) {
            if (k > 0 || a2) {
                this.f15039p.setText(this.f15040q.getString(C0349R.string.sync_unsynced));
            } else {
                this.f15039p.setText(this.f15040q.getString(C0349R.string.sync_synced));
            }
        } else if (a2) {
            this.f15039p.setText(this.f15040q.getString(C0349R.string.sync_unsynced));
        } else {
            this.f15039p.setText(this.f15040q.getString(C0349R.string.sync_synced));
        }
    }

    private void m23446w() {
        boolean a = fle.m19717b().m19727a();
        if (fkb.m19610a().m19649g() && a) {
            this.f15039p.setText(this.f15040q.getString(C0349R.string.sync_unsynced));
        }
    }

    private boolean m23447x() {
        boolean S = gvj.m22880S(this.f15040q);
        boolean c = fkb.m19610a().m19645c();
        Pair a = eyw.m18568a(this.f15040q);
        ((Boolean) a.first).booleanValue();
        return S || c || (((Boolean) a.second).booleanValue() && gvj.m22879R(eys.m18562a()));
    }

    private void m23448y() {
        this.f15039p.post(this.f15044u);
    }

    private void m23449z() {
        this.f15039p.removeCallbacks(this.f15044u);
    }
}
