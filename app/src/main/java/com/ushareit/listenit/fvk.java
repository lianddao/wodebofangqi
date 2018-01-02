package com.ushareit.listenit;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;

public class fvk extends fjm {
    private gal aj;
    private boolean ak;
    private OnClickListener al = new fvm(this);
    private fdw am = new fvn(this);
    private guo an = new fvr(this);
    private GridView f13578d;
    private fdt f13579e;
    private View f13580f;
    private View f13581g;
    private ViewGroup f13582h;
    private gum f13583i;

    public fvk(gal com_ushareit_listenit_gal, boolean z) {
        this.aj = com_ushareit_listenit_gal;
        this.ak = z;
        this.f13579e = new fdt(com_ushareit_listenit_gal);
    }

    public void mo2603U() {
        View c = m19541c((int) C0349R.layout.grid_fragment_with_title);
        this.f13578d = (GridView) c.findViewById(C0349R.id.grid_view);
        this.f13580f = c.findViewById(C0349R.id.no_music);
        this.f13581g = c.findViewById(C0349R.id.progress_view);
        this.f13582h = (ViewGroup) c.findViewById(C0349R.id.container);
        if (this.aj instanceof gas) {
            m19540b(true);
        }
        gyn.m23237e(this.f13582h, gyn.m23206b(m1326l()));
        m21083W();
        m21084X();
        mo2607d();
    }

    private void m21083W() {
        this.f13579e.m18920a(this.am);
        if (this.aj.mo2565a() == 5 || this.aj.mo2565a() == 2 || this.aj.mo2565a() == 7) {
            this.f13578d.setFastScrollEnabled(true);
        }
        this.f13578d.setAdapter(this.f13579e);
    }

    private void m21084X() {
        if (this.aj.mo2565a() == 17 || this.aj.mo2565a() == 18) {
            m19545f(0);
            return;
        }
        m19538a(this.aj);
        m19544e(0);
    }

    public void mo2548a(gum com_ushareit_listenit_gum) {
        this.f13583i = com_ushareit_listenit_gum;
        if (this.f13583i != null) {
            this.f13583i.mo2416a(this.an);
        }
        if (this.ak) {
            mo2550c();
        }
    }

    public void mo201x() {
        if (this.f13583i != null) {
            this.f13583i.mo2416a(this.an);
            mo2550c();
        }
        super.mo201x();
    }

    public void mo2607d() {
        fez.m19057a(m1326l(), this.f13582h);
    }

    public void mo202y() {
        if (this.f13583i != null) {
            this.f13583i.mo2430b(this.an);
        }
        super.mo202y();
    }

    public void mo203z() {
        if (this.f13583i != null) {
            this.f13583i.mo2430b(this.an);
        }
        this.f13579e.m18928e();
        super.mo203z();
    }

    public void mo2550c() {
        hhx.m23867a(new fvl(this, "listTitleFragment.Load_" + this.aj.mo2565a()));
    }

    public boolean mo2549b() {
        return false;
    }

    private void m21095g(boolean z) {
        if (z) {
            this.f13580f.setVisibility(0);
            int a = this.aj.mo2565a();
            TextView textView = (TextView) this.f13580f.findViewById(C0349R.id.no_music_title);
            TextView textView2 = (TextView) this.f13580f.findViewById(C0349R.id.no_music_hint);
            if (a == 8) {
                textView.setText(m1326l().getResources().getString(C0349R.string.playlist_no_music_title));
                textView2.setText(m1326l().getResources().getString(C0349R.string.playlist_no_music_hint));
                Button button = (Button) this.f13580f.findViewById(C0349R.id.no_music_button);
                button.setText(m1326l().getResources().getString(C0349R.string.playlist_no_music_button));
                button.setVisibility(0);
                button.setOnClickListener(this.al);
                return;
            } else if (a == 11) {
                this.f13578d.setVisibility(8);
                textView.setText(m1326l().getResources().getString(C0349R.string.favorite_no_music_title));
                textView2.setText(m1326l().getResources().getString(C0349R.string.favorite_no_music_hint));
                gyn.m23237e(this.f13580f, (int) m1329n().getDimension(C0349R.dimen.common_dimens_50dp));
                return;
            } else if (a == 10 || a == 13) {
                this.f13578d.setVisibility(8);
                gyn.m23237e(this.f13580f, (int) m1329n().getDimension(C0349R.dimen.common_dimens_50dp));
                textView.setText(m1326l().getResources().getString(C0349R.string.last_played_no_music_title));
                textView2.setText(m1326l().getResources().getString(C0349R.string.last_played_no_music_hint));
                return;
            } else {
                return;
            }
        }
        this.f13580f.setVisibility(8);
        this.f13578d.setVisibility(0);
    }

    private void m21085Y() {
        if (this.aj.mo2565a() == 0) {
            m19539a(m1329n().getString(C0349R.string.action_bar_song_select_title, new Object[]{Integer.valueOf(this.f13579e.m18926c())}), this.f13579e.m18926c(), this.f13579e.getCount());
            return;
        }
        m19539a(m1329n().getString(C0349R.string.action_bar_playlist_select_title, new Object[]{Integer.valueOf(this.f13579e.m18926c())}), this.f13579e.m18926c(), this.f13579e.getCount());
    }
}
