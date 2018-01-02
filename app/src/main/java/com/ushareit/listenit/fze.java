package com.ushareit.listenit;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.ushareit.listenit.widget.LISTENitViewPager;
import com.ushareit.listenit.widget.ViewPagerTabBar;
import java.util.ArrayList;
import java.util.List;

public class fze extends fjm {
    private OnClickListener aj = new fzf(this);
    private hed ak = new fzg(this);
    private kx al = new fzh(this);
    private ViewGroup f13754d;
    private ViewPagerTabBar f13755e;
    private LISTENitViewPager f13756f;
    private fdi f13757g;
    private List<fvs> f13758h = new ArrayList();
    private int f13759i = 0;

    public void mo2603U() {
        View c = m19541c((int) C0349R.layout.main_song_fragment);
        this.f13754d = (ViewGroup) c.findViewById(C0349R.id.container);
        this.f13755e = (ViewPagerTabBar) c.findViewById(C0349R.id.viewpager_tabbar);
        this.f13756f = (LISTENitViewPager) c.findViewById(C0349R.id.viewpager);
        this.f13756f.setOffscreenPageLimit(4);
        m19543d(C0349R.string.song_fragment_title);
        m19544e(0);
        fvs com_ushareit_listenit_fvs = new fvs(new gax(), true);
        com_ushareit_listenit_fvs.m21137W();
        com_ushareit_listenit_fvs.m21141a(this.aj);
        this.f13758h.add(com_ushareit_listenit_fvs);
        this.f13755e.m27023a(m1275a((int) C0349R.string.song_fragment_songs));
        this.f13758h.add(new fvs(new gaj(), false));
        this.f13755e.m27023a(m1275a((int) C0349R.string.song_fragment_artist));
        this.f13758h.add(new fvs(new gah(), false));
        this.f13755e.m27023a(m1275a((int) C0349R.string.song_fragment_album));
        this.f13758h.add(new fvs(new gao(), false));
        this.f13755e.m27023a(m1275a((int) C0349R.string.song_fragment_folder));
        this.f13757g = new fdi(m1328m().m709f(), this.f13758h);
        this.f13756f.setAdapter(this.f13757g);
        this.f13755e.setOnTabClickListener(this.ak);
        this.f13756f.setOnPageChangeListener(this.al);
        if (gyn.m23217b()) {
            gyn.m23237e(this.f13754d, (int) (((double) gyn.m23206b(m1326l())) + 0.5d));
        }
        mo2607d();
    }

    public void mo2548a(gum com_ushareit_listenit_gum) {
    }

    public void mo2550c() {
    }

    public void mo2607d() {
        fez.m19057a(m1326l(), this.f13754d);
    }

    public void mo203z() {
        m21375W();
        gyo.m23264a().m23271c(m1326l());
        super.mo203z();
    }

    public void mo201x() {
        if (this.f13759i < this.f13758h.size()) {
            ((fvs) this.f13758h.get(this.f13759i)).m21135U();
        }
        super.mo201x();
    }

    public void mo202y() {
        for (fvs V : this.f13758h) {
            V.m21136V();
        }
        super.mo202y();
    }

    public boolean mo2549b() {
        return false;
    }

    private void m21375W() {
        if (this.f13758h != null && this.f13758h.size() != 0) {
            try {
                this.f13756f.setOnPageChangeListener(null);
                bh a = m1328m().m709f().mo797a();
                for (ah ahVar : this.f13758h) {
                    try {
                        if (ahVar.m1338w() != null) {
                            ((ViewGroup) ahVar.m1338w()).removeAllViews();
                        }
                    } catch (Exception e) {
                    } catch (Throwable th) {
                        if (this.f13758h != null) {
                            this.f13758h.clear();
                        }
                    }
                    a.mo3092a(ahVar);
                }
                a.mo3098c();
                if (this.f13758h != null) {
                    this.f13758h.clear();
                }
            } catch (Exception e2) {
                if (this.f13758h != null) {
                    this.f13758h.clear();
                }
            } catch (Throwable th2) {
                if (this.f13758h != null) {
                    this.f13758h.clear();
                }
            }
        }
    }
}
