package com.ushareit.listenit;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.telephony.TelephonyManager;
import com.umeng.analytics.pro.C0321x;
import java.util.ArrayList;
import java.util.List;

public class hgk {
    private int f15415a = 0;
    private int f15416b = 0;
    private int f15417c = 0;
    private hgh f15418d = new hgh();
    private hgr f15419e;
    private boolean f15420f = false;
    private List<hgp> f15421g = new ArrayList();
    private List<hgq> f15422h = new ArrayList();
    private hgx f15423i;
    private hgs f15424j;
    private hgv f15425k = new hgn(this);
    private Handler f15426l = new hgo(this, Looper.getMainLooper());

    public hgk(Context context) {
        m23766b(context);
    }

    private void m23766b(Context context) {
        ((TelephonyManager) context.getSystemService("phone")).listen(this.f15418d, 32);
    }

    private void m23774c(Context context) {
        ((TelephonyManager) context.getSystemService("phone")).listen(this.f15418d, 0);
    }

    public void m23785a(hgp com_ushareit_listenit_hgp) {
        if (!this.f15421g.contains(com_ushareit_listenit_hgp)) {
            this.f15421g.add(com_ushareit_listenit_hgp);
        }
    }

    public void m23786a(hgq com_ushareit_listenit_hgq) {
        if (!this.f15422h.contains(com_ushareit_listenit_hgq)) {
            this.f15422h.add(com_ushareit_listenit_hgq);
        }
        if (this.f15423i.mo2499l() != null) {
            com_ushareit_listenit_hgq.mo2623a(this.f15423i.mo2499l().mo2557a(), m23807l(), m23808m());
        }
    }

    public void m23796b(hgq com_ushareit_listenit_hgq) {
        if (this.f15422h.contains(com_ushareit_listenit_hgq)) {
            this.f15422h.remove(com_ushareit_listenit_hgq);
        }
    }

    public void m23781a() {
        this.f15422h.clear();
    }

    public void m23787a(hgs com_ushareit_listenit_hgs) {
        this.f15424j = com_ushareit_listenit_hgs;
        this.f15424j.mo2767a(this.f15425k);
        this.f15418d.m23707a(this);
        this.f15419e = new hgr();
    }

    public void m23792a(hgx com_ushareit_listenit_hgx) {
        this.f15423i = com_ushareit_listenit_hgx;
    }

    public void m23794a(boolean z) {
        this.f15424j.mo2769a(z);
    }

    public boolean m23797b() {
        return this.f15424j.mo2782m();
    }

    public void m23789a(hgu com_ushareit_listenit_hgu) {
        this.f15424j.mo2766a(com_ushareit_listenit_hgu);
    }

    public void m23788a(hgt com_ushareit_listenit_hgt) {
        this.f15424j.mo2765a(com_ushareit_listenit_hgt);
    }

    public boolean m23798c() {
        return this.f15424j.mo2781l();
    }

    public void m23783a(int i) {
        this.f15417c = i;
    }

    public void m23799d() {
        hgw l = this.f15423i.mo2499l();
        if (this.f15424j.mo2770a() && l != null && l.mo2558g().equals(this.f15424j.mo2780k())) {
            m23763a(this.f15423i.mo2499l(), 1, 0);
            if (!this.f15424j.mo2771b()) {
                this.f15424j.mo2774e();
                return;
            }
            return;
        }
        m23768b(this.f15423i.mo2499l());
    }

    public void m23800e() {
        m23768b(this.f15423i.mo2499l());
    }

    public void m23790a(hgw com_ushareit_listenit_hgw) {
        this.f15423i.mo2495a(com_ushareit_listenit_hgw);
        m23769b(com_ushareit_listenit_hgw, 5);
        m23768b(com_ushareit_listenit_hgw);
    }

    public void m23793a(List<? extends hgw> list, hgw com_ushareit_listenit_hgw) {
        this.f15423i.mo2496a((List) list);
        this.f15423i.mo2495a(com_ushareit_listenit_hgw);
        m23769b(com_ushareit_listenit_hgw, 5);
        m23768b(com_ushareit_listenit_hgw);
    }

    private synchronized void m23768b(hgw com_ushareit_listenit_hgw) {
        m23780o();
        this.f15415a = 0;
        this.f15416b = 0;
        this.f15417c = 0;
        this.f15420f = true;
        m23763a(com_ushareit_listenit_hgw, 0, this.f15416b);
        hhx.m23869a(new hgl(this, com_ushareit_listenit_hgw), 300, 0);
    }

    public synchronized void m23791a(hgw com_ushareit_listenit_hgw, int i) {
        this.f15416b = i;
        m23763a(com_ushareit_listenit_hgw, 0, i);
        hhx.m23867a(new hgm(this, com_ushareit_listenit_hgw, i));
    }

    private void m23769b(hgw com_ushareit_listenit_hgw, int i) {
        m23763a(com_ushareit_listenit_hgw, i, 0);
    }

    private void m23763a(hgw com_ushareit_listenit_hgw, int i, int i2) {
        if (com_ushareit_listenit_hgw != null) {
            exw.m18443a("PlayerWrapper", "sendPlayStateMessage: state=" + m23773c(i));
            if (!(i == 6 || i == 0)) {
                this.f15420f = false;
            }
            Message obtainMessage = this.f15426l.obtainMessage(i);
            obtainMessage.obj = com_ushareit_listenit_hgw.mo2557a();
            if (i == 6 || i == 1 || i == 9) {
                obtainMessage.arg1 = i2;
            }
            this.f15426l.sendMessage(obtainMessage);
            if (i == 1 || (i == 6 && this.f15424j.mo2770a() && this.f15424j.mo2771b())) {
                m23771b(com_ushareit_listenit_hgw.mo2557a(), 0);
            } else if (i == 0) {
                m23764a(com_ushareit_listenit_hgw.mo2557a(), i2);
            } else if (i != 6) {
            } else {
                if (this.f15424j.mo2772c() || !this.f15424j.mo2771b()) {
                    m23764a(com_ushareit_listenit_hgw.mo2557a(), m23807l());
                }
            }
        }
    }

    public void m23801f() {
        if (this.f15424j.mo2772c()) {
            hhx.m23870a("play");
        } else if (this.f15424j.mo2771b()) {
            this.f15424j.mo2775f();
        }
        m23769b(this.f15423i.mo2499l(), 2);
        m23780o();
    }

    public void m23795b(int i) {
        this.f15424j.mo2764a(i);
        this.f15416b = i;
        m23769b(this.f15423i.mo2499l(), 6);
    }

    public void m23802g() {
        hgw b = this.f15423i.mo2497b(true);
        m23769b(b, 3);
        m23768b(b);
    }

    public void m23803h() {
        hgw c = this.f15423i.mo2498c(true);
        m23769b(c, 4);
        m23768b(c);
    }

    public boolean m23804i() {
        return this.f15424j.mo2771b() || this.f15420f;
    }

    public int m23805j() {
        return this.f15424j.mo2773d();
    }

    public void m23784a(Context context) {
        this.f15424j.mo2776g();
        m23780o();
        m23781a();
        m23774c(context);
    }

    public void m23782a(float f) {
        this.f15424j.mo2763a(f);
    }

    public float m23806k() {
        return this.f15424j.mo2777h();
    }

    public int m23807l() {
        int i = (this.f15424j == null || !this.f15424j.mo2770a() || this.f15420f) ? this.f15416b : this.f15424j.mo2778i();
        this.f15416b = i;
        return this.f15416b;
    }

    public int m23808m() {
        return this.f15424j.mo2779j();
    }

    private void m23764a(String str, int i) {
        hgw l = this.f15423i.mo2499l();
        if (!fbb.m18763c(str) && l != null && !fbb.m18763c(l.mo2557a()) && str.equals(l.mo2557a())) {
            this.f15419e.removeCallbacksAndMessages(null);
            Message obtainMessage = this.f15419e.obtainMessage(12, str);
            obtainMessage.arg1 = i;
            obtainMessage.arg2 = m23808m();
            this.f15419e.sendMessage(obtainMessage);
        }
    }

    private void m23771b(String str, int i) {
        hgw l = this.f15423i.mo2499l();
        if (!fbb.m18763c(str) && l != null && !fbb.m18763c(l.mo2557a()) && str.equals(l.mo2557a())) {
            this.f15419e.removeCallbacksAndMessages(null);
            Message obtainMessage = this.f15419e.obtainMessage(10, str);
            obtainMessage.arg1 = m23807l();
            obtainMessage.arg2 = m23808m();
            if (i == 0) {
                this.f15419e.sendMessage(obtainMessage);
            } else {
                this.f15419e.sendMessageDelayed(obtainMessage, (long) i);
            }
        }
    }

    private void m23770b(hgw com_ushareit_listenit_hgw, int i, int i2) {
        if (com_ushareit_listenit_hgw != null) {
            this.f15419e.removeCallbacksAndMessages(null);
            Message obtainMessage = this.f15419e.obtainMessage(11, com_ushareit_listenit_hgw.mo2557a());
            obtainMessage.arg1 = i;
            obtainMessage.arg2 = i2;
            this.f15419e.sendMessage(obtainMessage);
        }
    }

    private void m23780o() {
        this.f15419e.removeCallbacksAndMessages(null);
    }

    public String m23809n() {
        return this.f15424j.mo2780k();
    }

    private String m23773c(int i) {
        switch (i) {
            case 0:
                return "preparing";
            case 1:
                return "play";
            case 2:
                return "pause";
            case 3:
                return "skipToNext";
            case 4:
                return "skipToPrev";
            case 5:
                return "skipTo";
            case 6:
                return "seekto";
            case 7:
                return "rewind";
            case 8:
                return "complete";
            case 9:
                return C0321x.aF;
            case 10:
                return "progress";
            default:
                return "default";
        }
    }
}
