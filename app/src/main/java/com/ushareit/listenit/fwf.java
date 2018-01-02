package com.ushareit.listenit;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.widget.AbsListView.OnScrollListener;
import android.widget.Button;
import android.widget.TextView;
import com.ushareit.listenit.widget.AllPlayView;
import com.ushareit.listenit.widget.IndexableListView;
import com.ushareit.listenit.widget.PlaylistCoverView;
import java.util.List;

public class fwf extends fjm {
    private View aj;
    private View ak;
    private View al;
    private gla am;
    private gum an;
    private gal ao;
    private boolean ap;
    private boolean aq = true;
    private OnClickListener ar = new fwk(this);
    private OnClickListener as = new fwl(this);
    private OnClickListener at = new fwo(this);
    private OnClickListener au = new fwp(this);
    private fdw av = new fwq(this);
    private guo aw = new fwu(this);
    private OnScrollListener ax = new fwv(this);
    private fmb ay = new fwh(this);
    private fml az = new fwi(this);
    private IndexableListView f13616d;
    private fdt f13617e;
    private PlaylistCoverView f13618f;
    private AllPlayView f13619g;
    private TextView f13620h;
    private ViewGroup f13621i;

    public fwf(gal com_ushareit_listenit_gal, boolean z) {
        this.ao = com_ushareit_listenit_gal;
        this.ap = z;
        this.f13617e = new fdt(com_ushareit_listenit_gal);
    }

    public void mo2603U() {
        View c = m19541c((int) C0349R.layout.list_fragment_with_title);
        this.f13621i = (ViewGroup) c.findViewById(C0349R.id.container);
        this.f13616d = (IndexableListView) c.findViewById(C0349R.id.list_view);
        this.aj = c.findViewById(C0349R.id.no_music);
        this.ak = c.findViewById(C0349R.id.progress_view);
        if (this.ao instanceof gas) {
            m19540b(true);
        }
        m21164Y();
        m21165Z();
        aa();
        ab();
        mo2607d();
    }

    private void m21164Y() {
        int i;
        if (this.ao.mo2565a() == 8 || this.ao.mo2565a() == 6 || this.ao.mo2565a() == 17) {
            this.f13618f = new PlaylistCoverView(m1326l());
            this.f13618f.setMediaItem(this.am);
            this.f13616d.setOnScrollListener(this.ax);
            this.f13616d.addHeaderView(this.f13618f);
            i = 0;
        } else {
            if (this.ao.mo2565a() == 15) {
                m21191X();
            }
            i = gyn.m23206b(m1326l());
        }
        gyn.m23237e(this.f13621i, i);
    }

    private void m21165Z() {
        if (this.aq) {
            this.f13619g = new AllPlayView(m1326l());
            this.f13619g.m26791a(this.f13617e.getCount());
            this.f13619g.setOnManagementClickListener(this.au);
            this.f13619g.setOnAllPlayClickListener(this.at);
            if (this.ao.mo2565a() == 8) {
                this.f13619g.setShowAddSongs(this.ar);
            }
            if (this.ao.mo2565a() == 5 || this.ao.mo2565a() == 6) {
                this.f13619g.setShowRecommendPlaylist(this.as);
            }
            this.f13616d.addHeaderView(this.f13619g);
        }
    }

    private void aa() {
        this.f13617e.m18920a(this.av);
        if (this.ao.mo2565a() == 5 || this.ao.mo2565a() == 2 || this.ao.mo2565a() == 7) {
            this.f13616d.setFastScrollEnabled(true);
        }
        this.f13616d.setAdapter(this.f13617e);
    }

    private void ab() {
        if (this.ao.mo2565a() == 17 || this.ao.mo2565a() == 18) {
            m19545f(0);
            return;
        }
        m19538a(this.ao);
        m19544e(0);
    }

    public void mo2548a(gum com_ushareit_listenit_gum) {
        this.an = com_ushareit_listenit_gum;
        this.an.mo2416a(this.aw);
        if (gef.m21805a().m21835e()) {
            flw.m19819a().m19830a(this.ay);
            fmc.m19867a().m19887a(this.az);
        }
        if (this.ap) {
            mo2550c();
        }
    }

    public void mo2607d() {
        fez.m19057a(m1326l(), this.f13621i);
    }

    public void mo201x() {
        if (this.an != null) {
            this.an.mo2416a(this.aw);
            if (gef.m21805a().m21835e()) {
                flw.m19819a().m19830a(this.ay);
                fmc.m19867a().m19887a(this.az);
            }
            mo2550c();
        }
        super.mo201x();
    }

    public void mo202y() {
        if (this.an != null) {
            this.an.mo2430b(this.aw);
            if (gef.m21805a().m21835e()) {
                flw.m19819a().m19836b(this.ay);
                fmc.m19867a().m19892b(this.az);
            }
        }
        super.mo202y();
    }

    public void mo203z() {
        if (this.f13619g != null) {
            this.f13619g.setOnManagementClickListener(null);
            this.f13619g.setOnAllPlayClickListener(null);
            this.f13619g.setOnSortOrderListener(null);
        }
        if (this.an != null) {
            this.an.mo2430b(this.aw);
            if (gef.m21805a().m21835e()) {
                flw.m19819a().m19836b(this.ay);
                fmc.m19867a().m19892b(this.az);
            }
        }
        this.f13617e.m18928e();
        super.mo203z();
    }

    public void mo2550c() {
        hhx.m23867a(new fwg(this, "listTitleFragment.Load_" + this.ao.mo2565a()));
    }

    private long m21167a(List<gla> list) {
        long j = 0;
        for (gla com_ushareit_listenit_gla : list) {
            long d;
            if (j < com_ushareit_listenit_gla.mo2702d()) {
                d = com_ushareit_listenit_gla.mo2702d();
            } else {
                d = j;
            }
            j = d;
        }
        return j;
    }

    public void m21190W() {
        this.aq = false;
    }

    public void m21192a(gla com_ushareit_listenit_gla) {
        this.am = com_ushareit_listenit_gla;
    }

    public boolean mo2549b() {
        return false;
    }

    private void m21177g(boolean z) {
        if (z) {
            if (this.f13619g != null) {
                this.f13619g.setVisibility(8);
            }
            this.aj.setVisibility(0);
            int a = this.ao.mo2565a();
            TextView textView = (TextView) this.aj.findViewById(C0349R.id.no_music_title);
            TextView textView2 = (TextView) this.aj.findViewById(C0349R.id.no_music_hint);
            if (a == 8) {
                textView.setText(m1326l().getResources().getString(C0349R.string.playlist_no_music_title));
                textView2.setText(m1326l().getResources().getString(C0349R.string.playlist_no_music_hint));
                Button button = (Button) this.aj.findViewById(C0349R.id.no_music_button);
                button.setText(m1326l().getResources().getString(C0349R.string.playlist_no_music_button));
                button.setVisibility(0);
                button.setOnClickListener(this.ar);
                return;
            } else if (a == 11) {
                this.f13616d.setVisibility(8);
                textView.setText(m1326l().getResources().getString(C0349R.string.favorite_no_music_title));
                textView2.setText(m1326l().getResources().getString(C0349R.string.favorite_no_music_hint));
                gyn.m23237e(this.aj, (int) m1329n().getDimension(C0349R.dimen.common_dimens_50dp));
                return;
            } else if (a == 10 || a == 13) {
                this.f13616d.setVisibility(8);
                gyn.m23237e(this.aj, (int) m1329n().getDimension(C0349R.dimen.common_dimens_50dp));
                textView.setText(m1326l().getResources().getString(C0349R.string.last_played_no_music_title));
                textView2.setText(m1326l().getResources().getString(C0349R.string.last_played_no_music_hint));
                return;
            } else {
                return;
            }
        }
        this.aj.setVisibility(8);
        if (this.f13619g != null) {
            this.f13619g.setVisibility(0);
        }
        this.f13616d.setVisibility(0);
    }

    private void ac() {
        if (this.ao.mo2565a() == 0) {
            m19539a(m1329n().getString(C0349R.string.action_bar_song_select_title, new Object[]{Integer.valueOf(this.f13617e.m18926c())}), this.f13617e.m18926c(), this.f13617e.getCount());
            return;
        }
        m19539a(m1329n().getString(C0349R.string.action_bar_playlist_select_title, new Object[]{Integer.valueOf(this.f13617e.m18926c())}), this.f13617e.m18926c(), this.f13617e.getCount());
    }

    public void m21191X() {
        this.al = View.inflate(m1326l(), C0349R.layout.recommend_playlist_bar, null);
        this.f13616d.addHeaderView(this.al);
        this.f13620h = (TextView) this.al.findViewById(C0349R.id.create_to_playlist);
        this.f13620h.setOnClickListener(this.as);
        ((TextView) this.al.findViewById(C0349R.id.recommend_description)).setText(String.format(m1275a((int) C0349R.string.recommend_playlist_description), new Object[]{this.ao.m20816e().mo2562c()}));
        this.al.post(new fwj(this));
    }

    private void ad() {
        erl.m17583a(this.f13616d).mo2275b((float) (-this.al.getMeasuredHeight())).mo2273a(new AccelerateInterpolator()).mo2272a(400);
    }
}
