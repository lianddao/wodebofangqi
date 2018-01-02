package com.ushareit.listenit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

public class fod implements hgx {
    public List<foe> f13081a = new ArrayList();
    private int f13082b = 0;
    private int f13083c = 1;
    private boolean f13084d = false;
    private List<hgw> f13085e = new CopyOnWriteArrayList();
    private List<hgw> f13086f = new CopyOnWriteArrayList();
    private List<hgw> f13087g = new CopyOnWriteArrayList();
    private List<hgw> f13088h = new CopyOnWriteArrayList();
    private int f13089i = 1;
    private hgw f13090j;
    private boolean f13091k = false;

    public void m20173a(foe com_ushareit_listenit_foe) {
        if (com_ushareit_listenit_foe != null && !this.f13081a.contains(com_ushareit_listenit_foe)) {
            this.f13081a.add(com_ushareit_listenit_foe);
        }
    }

    public void m20183b(foe com_ushareit_listenit_foe) {
        if (com_ushareit_listenit_foe != null && !this.f13081a.contains(com_ushareit_listenit_foe)) {
            this.f13081a.remove(com_ushareit_listenit_foe);
        }
    }

    public void m20171a() {
        this.f13081a.clear();
    }

    public int m20181b() {
        return this.f13091k ? this.f13089i : this.f13083c;
    }

    public void m20172a(int i) {
        this.f13083c = i;
    }

    public void m20180a(boolean z) {
        this.f13084d = z;
        if (z) {
            m20192g();
            return;
        }
        hgw l = mo2499l();
        this.f13086f.clear();
        this.f13086f.addAll(this.f13085e);
        m20185b(l);
    }

    public boolean m20188c() {
        return this.f13084d;
    }

    public void m20189d() {
        if (!this.f13091k) {
            this.f13089i = this.f13083c;
            this.f13083c = 4;
            this.f13090j = mo2499l();
            this.f13088h.clear();
            this.f13088h.addAll(this.f13086f);
            this.f13087g.clear();
            this.f13087g.addAll(this.f13085e);
            this.f13091k = true;
        }
    }

    public boolean m20190e() {
        return this.f13091k;
    }

    public void m20174a(glg com_ushareit_listenit_glg) {
        this.f13086f.clear();
        this.f13086f.add(com_ushareit_listenit_glg);
        this.f13085e.clear();
        this.f13085e.add(com_ushareit_listenit_glg);
        m20185b((hgw) com_ushareit_listenit_glg);
    }

    public void m20191f() {
        if (this.f13091k) {
            this.f13091k = false;
            this.f13083c = this.f13089i;
            this.f13086f.clear();
            this.f13086f.addAll(this.f13088h);
            this.f13085e.clear();
            this.f13085e.addAll(this.f13087g);
            m20185b(this.f13090j);
            this.f13087g.clear();
            this.f13088h.clear();
            this.f13090j = null;
        }
    }

    public synchronized void m20179a(List<glg> list, List<glg> list2, glg com_ushareit_listenit_glg, int i, boolean z) {
        if (!(list == null || list2 == null || com_ushareit_listenit_glg == null)) {
            this.f13086f.clear();
            this.f13086f.addAll(list2);
            this.f13085e.clear();
            List list3 = this.f13085e;
            if (list.size() == list2.size()) {
                list2 = list;
            }
            list3.addAll(list2);
            m20185b((hgw) com_ushareit_listenit_glg);
            this.f13083c = i;
            this.f13084d = z;
        }
    }

    public synchronized void m20178a(List<? extends hgw> list, hgw com_ushareit_listenit_hgw) {
        if (this.f13085e.size() <= 0 || !this.f13085e.equals(list)) {
            this.f13085e.clear();
            this.f13085e.addAll(list);
            this.f13086f.clear();
            this.f13086f.addAll(list);
            m20185b(com_ushareit_listenit_hgw);
        } else {
            m20185b(com_ushareit_listenit_hgw);
        }
    }

    public synchronized void mo2496a(List<? extends hgw> list) {
        m20178a((List) list, (hgw) list.get(0));
    }

    public synchronized void mo2495a(hgw com_ushareit_listenit_hgw) {
        m20185b(com_ushareit_listenit_hgw);
    }

    public synchronized void m20192g() {
        if (this.f13086f.size() != 0) {
            Object l = mo2499l();
            if (l == null) {
                l = (hgw) this.f13086f.get(0);
            }
            this.f13086f.remove(l);
            Collections.shuffle(this.f13086f, new Random(System.currentTimeMillis()));
            this.f13086f.add(0, l);
            this.f13082b = 0;
        }
    }

    public hgw mo2497b(boolean z) {
        this.f13082b = m20168d(z);
        return m20166b(this.f13082b) ? (hgw) this.f13086f.get(this.f13082b) : null;
    }

    public hgw mo2498c(boolean z) {
        this.f13082b = m20169e(z);
        return m20166b(this.f13082b) ? (hgw) this.f13086f.get(this.f13082b) : null;
    }

    public hgw m20193h() {
        int e = m20169e(true);
        return m20166b(e) ? (hgw) this.f13086f.get(e) : null;
    }

    public hgw m20194i() {
        int d = m20168d(true);
        return m20166b(d) ? (hgw) this.f13086f.get(d) : null;
    }

    public hgw mo2494a(String str) {
        for (hgw com_ushareit_listenit_hgw : this.f13086f) {
            if (com_ushareit_listenit_hgw.mo2557a().equals(str)) {
                return com_ushareit_listenit_hgw;
            }
        }
        return null;
    }

    public void m20185b(hgw com_ushareit_listenit_hgw) {
        this.f13082b = this.f13086f.indexOf(com_ushareit_listenit_hgw);
        this.f13082b = this.f13082b == -1 ? 0 : this.f13082b;
    }

    public long m20195j() {
        return m20167c(this.f13082b);
    }

    public String m20196k() {
        return m20166b(this.f13082b) ? ((hgw) this.f13086f.get(this.f13082b)).mo2558g() : null;
    }

    public hgw mo2499l() {
        return m20166b(this.f13082b) ? (hgw) this.f13086f.get(this.f13082b) : null;
    }

    private boolean m20166b(int i) {
        return i >= 0 && i < this.f13086f.size();
    }

    public List<? extends hgw> m20198m() {
        return this.f13086f;
    }

    public List<? extends hgw> m20199n() {
        return this.f13085e;
    }

    public int m20200o() {
        return this.f13086f.size();
    }

    public boolean mo2500p() {
        return ((this.f13083c == 1 && this.f13082b == this.f13086f.size() - 1) || this.f13083c == 4) ? false : true;
    }

    public synchronized void m20175a(glg com_ushareit_listenit_glg, glg com_ushareit_listenit_glg2) {
        boolean z = this.f13084d;
        int indexOf = this.f13086f.indexOf(com_ushareit_listenit_glg);
        int indexOf2 = this.f13086f.indexOf(com_ushareit_listenit_glg2);
        if (!(indexOf == -1 || indexOf2 == -1)) {
            hgw l = mo2499l();
            this.f13086f.remove(com_ushareit_listenit_glg);
            this.f13086f.add(indexOf2, com_ushareit_listenit_glg);
            this.f13082b = this.f13086f.indexOf(l);
            if (!z) {
                this.f13085e.remove(com_ushareit_listenit_glg);
                this.f13085e.add(indexOf2, com_ushareit_listenit_glg);
            }
        }
    }

    public synchronized void m20184b(glg com_ushareit_listenit_glg) {
        if (this.f13086f.size() == 0) {
            this.f13082b = 0;
            this.f13086f.add(this.f13082b, com_ushareit_listenit_glg);
            this.f13085e.add(com_ushareit_listenit_glg);
        } else {
            hgw com_ushareit_listenit_hgw = (hgw) this.f13086f.get(this.f13082b);
            if (this.f13082b >= this.f13086f.size() || !com_ushareit_listenit_glg.equals(com_ushareit_listenit_hgw)) {
                if (this.f13086f.contains(com_ushareit_listenit_glg)) {
                    m20187c(com_ushareit_listenit_glg);
                }
                this.f13085e.add(this.f13085e.indexOf(com_ushareit_listenit_hgw) + 1, com_ushareit_listenit_glg);
                this.f13086f.add(this.f13082b + 1, com_ushareit_listenit_glg);
            }
        }
    }

    public void m20187c(glg com_ushareit_listenit_glg) {
        if (this.f13086f.contains(com_ushareit_listenit_glg)) {
            int indexOf = this.f13086f.indexOf(com_ushareit_listenit_glg);
            this.f13085e.remove(com_ushareit_listenit_glg);
            this.f13086f.remove(com_ushareit_listenit_glg);
            if (indexOf == this.f13082b) {
                this.f13082b = this.f13082b + 1 < this.f13086f.size() ? this.f13082b : 0;
            } else if (indexOf < this.f13082b) {
                this.f13082b--;
            }
            if (this.f13086f.size() == 0) {
                for (foe a : this.f13081a) {
                    a.mo2482a();
                }
            }
        }
    }

    public void m20202q() {
        this.f13085e.clear();
        this.f13086f.clear();
        this.f13082b = 0;
        for (foe a : this.f13081a) {
            a.mo2482a();
        }
    }

    private long m20167c(int i) {
        return m20166b(i) ? ((glg) this.f13086f.get(i)).f14334b : -1;
    }

    private int m20168d(boolean z) {
        if (!z) {
            switch (this.f13083c) {
                case 1:
                    return this.f13082b < this.f13086f.size() + -1 ? this.f13082b + 1 : this.f13086f.size() - 1;
                case 2:
                    if (this.f13082b < this.f13086f.size() - 1) {
                        return this.f13082b + 1;
                    }
                    return 0;
                case 3:
                    return this.f13082b;
                case 4:
                    return this.f13082b;
                default:
                    return 0;
            }
        } else if (this.f13082b < this.f13086f.size() - 1) {
            return this.f13082b + 1;
        } else {
            return 0;
        }
    }

    private int m20169e(boolean z) {
        if (!z) {
            switch (this.f13083c) {
                case 1:
                    if (this.f13082b > 0) {
                        return this.f13082b - 1;
                    }
                    return 0;
                case 2:
                    return this.f13082b > 0 ? this.f13082b - 1 : this.f13086f.size() - 1;
                case 3:
                    return this.f13082b;
                case 4:
                    return this.f13082b;
                default:
                    return 0;
            }
        } else if (this.f13082b > 0) {
            return this.f13082b - 1;
        } else {
            return this.f13086f.size() - 1;
        }
    }
}
