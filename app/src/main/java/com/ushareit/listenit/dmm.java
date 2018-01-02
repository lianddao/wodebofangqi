package com.ushareit.listenit;

import android.os.Bundle;
import android.os.DeadObjectException;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Status;

public class dmm implements dni {
    private final dnj f9930a;
    private boolean f9931b = false;

    public dmm(dnj com_ushareit_listenit_dnj) {
        this.f9930a = com_ushareit_listenit_dnj;
    }

    private <A extends cdq> void m14906c(dlu<? extends ceg, A> com_ushareit_listenit_dlu__extends_com_ushareit_listenit_ceg__A) {
        this.f9930a.f10017g.f9983i.m15206a((dma) com_ushareit_listenit_dlu__extends_com_ushareit_listenit_ceg__A);
        cdq b = this.f9930a.f10017g.m15015b(com_ushareit_listenit_dlu__extends_com_ushareit_listenit_ceg__A.mo1275b());
        if (b.m10644h() || !this.f9930a.f10012b.containsKey(com_ushareit_listenit_dlu__extends_com_ushareit_listenit_ceg__A.mo1275b())) {
            if (b instanceof cfn) {
                b = ((cfn) b).mo1281f();
            }
            com_ushareit_listenit_dlu__extends_com_ushareit_listenit_ceg__A.m10808b(b);
            return;
        }
        com_ushareit_listenit_dlu__extends_com_ushareit_listenit_ceg__A.m10810c(new Status(17));
    }

    public <A extends cdq, R extends ceg, T extends dlu<R, A>> T mo1981a(T t) {
        return mo1986b(t);
    }

    public void mo1982a() {
    }

    public void mo1983a(int i) {
        this.f9930a.m15048a(null);
        this.f9930a.f10018h.mo1968a(i, this.f9931b);
    }

    public void mo1984a(Bundle bundle) {
    }

    public void mo1985a(ConnectionResult connectionResult, cdj<?> com_ushareit_listenit_cdj_, int i) {
    }

    public <A extends cdq, T extends dlu<? extends ceg, A>> T mo1986b(T t) {
        try {
            m14906c(t);
        } catch (DeadObjectException e) {
            this.f9930a.m15050a(new dmn(this, this));
        }
        return t;
    }

    public boolean mo1987b() {
        if (this.f9931b) {
            return false;
        }
        if (this.f9930a.f10017g.m15031o()) {
            this.f9931b = true;
            for (dot a : this.f9930a.f10017g.f9982h) {
                a.m15199a();
            }
            return false;
        }
        this.f9930a.m15048a(null);
        return true;
    }

    public void mo1988c() {
        if (this.f9931b) {
            this.f9931b = false;
            this.f9930a.m15050a(new dmo(this, this));
        }
    }

    void m14915d() {
        if (this.f9931b) {
            this.f9931b = false;
            this.f9930a.f10017g.f9983i.m15205a();
            mo1987b();
        }
    }
}
