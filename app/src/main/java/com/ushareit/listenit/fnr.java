package com.ushareit.listenit;

import android.content.Context;
import android.media.AudioManager.OnAudioFocusChangeListener;
import android.os.Binder;
import android.os.Handler;
import android.os.Looper;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import java.util.ArrayList;
import java.util.List;

public class fnr extends Binder implements gum {
    private int[] f13042a = new int[]{1, 2, 3};
    private WakeLock f13043b;
    private List<guo> f13044c = new ArrayList();
    private List<gun> f13045d = new ArrayList();
    private List<gup> f13046e = new ArrayList();
    private List<hgu> f13047f = new ArrayList();
    private List<hgt> f13048g = new ArrayList();
    private int f13049h = 0;
    private fod f13050i = new fod();
    private hgk f13051j;
    private hgi f13052k;
    private boolean f13053l = false;
    private boolean f13054m = true;
    private boolean f13055n = false;
    private boolean f13056o = true;
    private int f13057p;
    private long f13058q = 0;
    private Handler f13059r = new fns(this);
    private hgp f13060s = new fnx(this);
    private foe f13061t = new fny(this);
    private Handler f13062u = new foa(this, Looper.getMainLooper());
    private OnAudioFocusChangeListener f13063v = new foc(this);
    private hgu f13064w = new fnt(this);
    private hgt f13065x = new fnu(this);

    public fnr(Context context) {
        this.f13051j = new hgk(context);
        this.f13052k = new hgi(context, new hgy(context));
        this.f13052k.m23743a(gvj.ak(context), this.f13063v);
        this.f13051j.m23787a(this.f13052k);
        this.f13051j.m23792a(this.f13050i);
        this.f13051j.m23785a(this.f13060s);
        this.f13051j.m23789a(this.f13064w);
        this.f13051j.m23794a(true);
        this.f13051j.m23788a(this.f13065x);
        this.f13043b = ((PowerManager) context.getSystemService("power")).newWakeLock(1, getClass().getName());
        this.f13043b.setReferenceCounted(false);
        this.f13050i.m20173a(this.f13061t);
        this.f13053l = gvj.ad(context);
        this.f13054m = gvj.ae(context);
        this.f13055n = gvj.ah(context);
    }

    public void mo2423a(List<glg> list, List<glg> list2, glg com_ushareit_listenit_glg, int i, int i2, boolean z) {
        this.f13050i.m20179a(list, list2, com_ushareit_listenit_glg, i, z);
        if (!gyn.m23201a(com_ushareit_listenit_glg)) {
            hgw b = m20041b((List) list2, com_ushareit_listenit_glg);
        }
        if (b == null) {
            return;
        }
        if (!gyn.m23260p(b.f14342j) || hgg.m23704a(b.f14342j)) {
            this.f13050i.m20185b(b);
            this.f13051j.m23791a(b, i2);
        }
    }

    public void mo2422a(List<glg> list, glg com_ushareit_listenit_glg) {
        this.f13051j.m23793a((List) list, (hgw) com_ushareit_listenit_glg);
        this.f13050i.m20180a(this.f13050i.m20188c());
    }

    public void mo2413a(glg com_ushareit_listenit_glg) {
        this.f13051j.m23790a((hgw) com_ushareit_listenit_glg);
    }

    public boolean mo2425a() {
        return this.f13051j.m23804i();
    }

    public boolean mo2437b() {
        return this.f13056o;
    }

    public void mo2428b(glg com_ushareit_listenit_glg) {
        if (!mo2456m()) {
            mo2457n();
        }
        m20094d(com_ushareit_listenit_glg);
        String n = this.f13051j.m23809n();
        if (fbb.m18763c(n) || !n.equals(com_ushareit_listenit_glg.f14342j) || !this.f13051j.m23804i()) {
            mo2450g();
        }
    }

    public synchronized void mo2440c(glg com_ushareit_listenit_glg) {
        if (!mo2456m()) {
            mo2457n();
        }
        m20094d(com_ushareit_listenit_glg);
        this.f13051j.m23791a((hgw) com_ushareit_listenit_glg, 0);
    }

    public void mo2438c() {
        this.f13051j.m23799d();
    }

    public synchronized void mo2442d() {
        if (this.f13051j.m23804i()) {
            mo2444e();
        } else {
            this.f13051j.m23799d();
        }
    }

    public synchronized void mo2444e() {
        if (!this.f13054m) {
            this.f13051j.m23801f();
        } else if (gyn.m23260p(this.f13051j.m23809n()) && this.f13051j.m23798c()) {
            this.f13051j.m23801f();
        } else {
            m20036H();
        }
    }

    public synchronized void mo2447f() {
        this.f13051j.m23801f();
    }

    public synchronized void mo2450g() {
        this.f13051j.m23800e();
    }

    public synchronized void mo2424a(boolean z) {
        if (z) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.f13058q > 300) {
                this.f13051j.m23795b(0);
                m20033E();
            } else {
                m20034F();
            }
            this.f13058q = currentTimeMillis;
        } else {
            this.f13051j.m23803h();
        }
    }

    private void m20033E() {
        this.f13059r.removeCallbacksAndMessages(null);
        this.f13059r.sendMessageDelayed(this.f13059r.obtainMessage(0), 300);
    }

    private void m20034F() {
        this.f13059r.removeMessages(0);
        this.f13059r.sendEmptyMessage(1);
    }

    public synchronized void mo2451h() {
        this.f13051j.m23802g();
    }

    public synchronized void mo2411a(int i) {
        this.f13051j.m23795b(i);
    }

    public void mo2452i() {
        this.f13051j.m23784a(eys.m18562a());
    }

    public boolean mo2453j() {
        return this.f13050i.m20188c();
    }

    public void mo2436b(boolean z) {
        this.f13050i.m20180a(z);
        hhx.m23867a(new fnv(this, z));
        fiz.m19506c();
    }

    public synchronized void mo2426b(int i) {
        if (i != this.f13050i.m20181b()) {
            this.f13050i.m20172a(i);
            hhx.m23867a(new fnw(this, i));
            fiz.m19506c();
        }
    }

    public int mo2454k() {
        return this.f13050i.m20181b();
    }

    public int mo2455l() {
        int b = this.f13050i.m20181b();
        int i = 0;
        while (i < this.f13042a.length) {
            if (this.f13042a[i] == b) {
                break;
            }
            i++;
        }
        i = 0;
        if (i + 1 < this.f13042a.length) {
            return this.f13042a[i + 1];
        }
        return this.f13042a[0];
    }

    public boolean mo2456m() {
        return this.f13050i.m20190e();
    }

    public void mo2457n() {
        this.f13049h = mo2463t();
        this.f13050i.m20189d();
    }

    public void m20094d(glg com_ushareit_listenit_glg) {
        this.f13050i.m20174a(com_ushareit_listenit_glg);
    }

    public void mo2458o() {
        String k = this.f13050i.m20196k();
        this.f13050i.m20191f();
        if (!k.equals(this.f13050i.m20196k()) && this.f13050i.mo2499l() != null) {
            this.f13051j.m23791a(this.f13050i.mo2499l(), this.f13049h);
        }
    }

    public int mo2459p() {
        return this.f13051j.m23805j();
    }

    public List<glg> mo2460q() {
        return this.f13050i.m20198m();
    }

    public List<glg> mo2461r() {
        return this.f13050i.m20199n();
    }

    public int mo2462s() {
        return this.f13050i.m20200o();
    }

    public synchronized int mo2463t() {
        return this.f13051j.m23807l();
    }

    public long mo2464u() {
        return this.f13050i.m20195j();
    }

    public glg mo2465v() {
        return (glg) this.f13050i.mo2499l();
    }

    public glg mo2466w() {
        return (glg) this.f13050i.m20193h();
    }

    public glg mo2467x() {
        return (glg) this.f13050i.m20194i();
    }

    public synchronized void mo2445e(glg com_ushareit_listenit_glg) {
        this.f13050i.m20184b(com_ushareit_listenit_glg);
    }

    public synchronized void mo2421a(List<glg> list) {
        for (glg b : list) {
            this.f13050i.m20184b(b);
        }
    }

    public void mo2414a(glg com_ushareit_listenit_glg, glg com_ushareit_listenit_glg2) {
        this.f13050i.m20175a(com_ushareit_listenit_glg, com_ushareit_listenit_glg2);
    }

    public synchronized void mo2448f(glg com_ushareit_listenit_glg) {
        long j = this.f13050i.m20195j();
        boolean i = this.f13051j.m23804i();
        this.f13050i.m20187c(com_ushareit_listenit_glg);
        if (j != this.f13050i.m20195j()) {
            mo2450g();
            if (!i) {
                this.f13051j.m23801f();
            }
        }
    }

    public synchronized void mo2435b(List<glg> list) {
        long j = this.f13050i.m20195j();
        for (glg c : list) {
            this.f13050i.m20187c(c);
        }
        if (j != this.f13050i.m20195j()) {
            mo2450g();
        }
    }

    public synchronized void mo2468y() {
        this.f13051j.m23801f();
        this.f13050i.m20202q();
    }

    public void mo2412a(foe com_ushareit_listenit_foe) {
        this.f13050i.m20173a(com_ushareit_listenit_foe);
    }

    public void mo2427b(foe com_ushareit_listenit_foe) {
        this.f13050i.m20183b(com_ushareit_listenit_foe);
    }

    public void mo2469z() {
        this.f13050i.m20171a();
    }

    public void mo2416a(guo com_ushareit_listenit_guo) {
        if (com_ushareit_listenit_guo != null && !this.f13044c.contains(com_ushareit_listenit_guo)) {
            this.f13044c.add(com_ushareit_listenit_guo);
        }
    }

    public void mo2430b(guo com_ushareit_listenit_guo) {
        if (com_ushareit_listenit_guo != null && this.f13044c.contains(com_ushareit_listenit_guo)) {
            this.f13044c.remove(com_ushareit_listenit_guo);
        }
    }

    public void mo2407A() {
        this.f13044c.clear();
    }

    public void mo2418a(hgq com_ushareit_listenit_hgq) {
        this.f13051j.m23786a(com_ushareit_listenit_hgq);
    }

    public void mo2432b(hgq com_ushareit_listenit_hgq) {
        this.f13051j.m23796b(com_ushareit_listenit_hgq);
    }

    public void mo2408B() {
        this.f13051j.m23781a();
    }

    public void mo2415a(gun com_ushareit_listenit_gun) {
        if (com_ushareit_listenit_gun != null && !this.f13045d.contains(com_ushareit_listenit_gun)) {
            this.f13045d.add(com_ushareit_listenit_gun);
        }
    }

    public void mo2429b(gun com_ushareit_listenit_gun) {
        if (com_ushareit_listenit_gun != null && this.f13045d.contains(com_ushareit_listenit_gun)) {
            this.f13045d.remove(com_ushareit_listenit_gun);
        }
    }

    public void mo2417a(gup com_ushareit_listenit_gup) {
        if (com_ushareit_listenit_gup != null && !this.f13046e.contains(com_ushareit_listenit_gup)) {
            this.f13046e.add(com_ushareit_listenit_gup);
        }
    }

    public void mo2431b(gup com_ushareit_listenit_gup) {
        if (com_ushareit_listenit_gup != null && this.f13046e.contains(com_ushareit_listenit_gup)) {
            this.f13046e.remove(com_ushareit_listenit_gup);
        }
    }

    public void mo2420a(hgu com_ushareit_listenit_hgu) {
        if (com_ushareit_listenit_hgu != null && !this.f13047f.contains(com_ushareit_listenit_hgu)) {
            this.f13047f.add(com_ushareit_listenit_hgu);
        }
    }

    public void mo2434b(hgu com_ushareit_listenit_hgu) {
        if (com_ushareit_listenit_hgu != null && this.f13047f.contains(com_ushareit_listenit_hgu)) {
            this.f13047f.remove(com_ushareit_listenit_hgu);
        }
    }

    public void mo2419a(hgt com_ushareit_listenit_hgt) {
        if (com_ushareit_listenit_hgt != null && !this.f13048g.contains(com_ushareit_listenit_hgt)) {
            this.f13048g.add(com_ushareit_listenit_hgt);
            com_ushareit_listenit_hgt.mo2471a(this.f13051j.m23798c());
        }
    }

    public void mo2433b(hgt com_ushareit_listenit_hgt) {
        if (com_ushareit_listenit_hgt != null && this.f13048g.contains(com_ushareit_listenit_hgt)) {
            this.f13048g.remove(com_ushareit_listenit_hgt);
        }
    }

    private glg m20041b(List<glg> list, glg com_ushareit_listenit_glg) {
        if (list == null || list.size() == 0 || com_ushareit_listenit_glg == null) {
            return null;
        }
        glg com_ushareit_listenit_glg2;
        List arrayList = new ArrayList(list);
        int size = arrayList.size();
        int indexOf = arrayList.indexOf(com_ushareit_listenit_glg);
        for (int i = (indexOf + 1) % size; i != indexOf; i = (i + 1) % size) {
            com_ushareit_listenit_glg2 = (glg) arrayList.get(i);
            if (com_ushareit_listenit_glg2 != null && gyn.m23201a(com_ushareit_listenit_glg2)) {
                break;
            }
        }
        com_ushareit_listenit_glg2 = null;
        if (com_ushareit_listenit_glg2 != null) {
            return com_ushareit_listenit_glg2;
        }
        return !gyn.m23201a(com_ushareit_listenit_glg) ? null : com_ushareit_listenit_glg;
    }

    private boolean m20035G() {
        glg b = m20041b(this.f13050i.m20198m(), (glg) this.f13050i.mo2499l());
        if (b == null) {
            return false;
        }
        mo2413a(b);
        return true;
    }

    public void mo2441c(boolean z) {
        this.f13053l = z;
    }

    public void mo2443d(boolean z) {
        this.f13054m = z;
    }

    public void mo2446e(boolean z) {
        this.f13055n = z;
        m20049g(z);
    }

    public void mo2449f(boolean z) {
        this.f13052k.m23743a(z, this.f13063v);
    }

    public boolean mo2409C() {
        return this.f13051j.m23797b();
    }

    private void m20049g(boolean z) {
        if (!z || this.f13050i.m20190e()) {
            this.f13051j.m23783a(0);
        } else {
            m20046d(0);
        }
    }

    private void m20052h(boolean z) {
        if (!z) {
            this.f13051j.m23782a(0.0f);
        }
        this.f13062u.removeCallbacksAndMessages(null);
        this.f13062u.sendMessage(this.f13062u.obtainMessage(1));
    }

    private void m20036H() {
        hhx.m23867a(new fnz(this));
        this.f13062u.removeCallbacksAndMessages(null);
        this.f13062u.sendMessage(this.f13062u.obtainMessage(2));
    }

    private void m20037I() {
        this.f13062u.removeCallbacksAndMessages(null);
        this.f13062u.sendMessage(this.f13062u.obtainMessage(3));
    }

    private void m20046d(int i) {
        hhx.m23869a(new fob(this, "skipTail"), i, 0);
    }

    public int mo2410D() {
        return this.f13057p;
    }

    public void mo2439c(int i) {
        this.f13057p = i;
    }
}
