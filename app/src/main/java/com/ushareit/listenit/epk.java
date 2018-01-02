package com.ushareit.listenit;

import java.util.ArrayList;

public abstract class epk implements Cloneable {
    ArrayList<epl> f11434a = null;

    public abstract epk mo2233a(long j);

    public abstract boolean mo2236c();

    public /* synthetic */ Object clone() {
        return mo2239f();
    }

    public void mo2234a() {
    }

    public void mo2235b() {
    }

    public boolean mo2238d() {
        return mo2236c();
    }

    public void m17274a(epl com_ushareit_listenit_epl) {
        if (this.f11434a == null) {
            this.f11434a = new ArrayList();
        }
        this.f11434a.add(com_ushareit_listenit_epl);
    }

    public void m17276b(epl com_ushareit_listenit_epl) {
        if (this.f11434a != null) {
            this.f11434a.remove(com_ushareit_listenit_epl);
            if (this.f11434a.size() == 0) {
                this.f11434a = null;
            }
        }
    }

    public ArrayList<epl> m17279e() {
        return this.f11434a;
    }

    public epk mo2239f() {
        try {
            epk com_ushareit_listenit_epk = (epk) super.clone();
            if (this.f11434a != null) {
                ArrayList arrayList = this.f11434a;
                com_ushareit_listenit_epk.f11434a = new ArrayList();
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    com_ushareit_listenit_epk.f11434a.add(arrayList.get(i));
                }
            }
            return com_ushareit_listenit_epk;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
