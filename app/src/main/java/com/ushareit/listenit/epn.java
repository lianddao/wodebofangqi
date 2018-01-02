package com.ushareit.listenit;

import com.mopub.volley.DefaultRetryPolicy;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public final class epn extends epk {
    boolean f11435b = false;
    private ArrayList<epk> f11436c = new ArrayList();
    private HashMap<epk, ept> f11437d = new HashMap();
    private ArrayList<ept> f11438e = new ArrayList();
    private ArrayList<ept> f11439f = new ArrayList();
    private boolean f11440g = true;
    private epp f11441h = null;
    private boolean f11442i = false;
    private long f11443j = 0;
    private eqy f11444k = null;
    private long f11445l = -1;

    public /* synthetic */ epk mo2233a(long j) {
        return m17299b(j);
    }

    public /* synthetic */ Object clone() {
        return m17304g();
    }

    public /* synthetic */ epk mo2239f() {
        return m17304g();
    }

    public void m17298a(epk... com_ushareit_listenit_epkArr) {
        int i = 0;
        if (com_ushareit_listenit_epkArr != null) {
            this.f11440g = true;
            if (com_ushareit_listenit_epkArr.length == 1) {
                m17296a(com_ushareit_listenit_epkArr[0]);
                return;
            }
            while (i < com_ushareit_listenit_epkArr.length - 1) {
                m17296a(com_ushareit_listenit_epkArr[i]).m17312b(com_ushareit_listenit_epkArr[i + 1]);
                i++;
            }
        }
    }

    public epq m17296a(epk com_ushareit_listenit_epk) {
        if (com_ushareit_listenit_epk == null) {
            return null;
        }
        this.f11440g = true;
        return new epq(this, com_ushareit_listenit_epk);
    }

    public void mo2235b() {
        this.f11435b = true;
        if (mo2238d()) {
            Iterator it;
            ArrayList arrayList;
            if (this.a != null) {
                ArrayList arrayList2 = (ArrayList) this.a.clone();
                it = arrayList2.iterator();
                while (it.hasNext()) {
                    ((epl) it.next()).mo2231c(this);
                }
                arrayList = arrayList2;
            } else {
                arrayList = null;
            }
            if (this.f11444k != null && this.f11444k.mo2236c()) {
                this.f11444k.mo2235b();
            } else if (this.f11439f.size() > 0) {
                it = this.f11439f.iterator();
                while (it.hasNext()) {
                    ((ept) it.next()).f11458a.mo2235b();
                }
            }
            if (arrayList != null) {
                Iterator it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    ((epl) it2.next()).mo2230b(this);
                }
            }
            this.f11442i = false;
        }
    }

    public boolean mo2236c() {
        Iterator it = this.f11438e.iterator();
        while (it.hasNext()) {
            if (((ept) it.next()).f11458a.mo2236c()) {
                return true;
            }
        }
        return false;
    }

    public boolean mo2238d() {
        return this.f11442i;
    }

    public epn m17299b(long j) {
        if (j < 0) {
            throw new IllegalArgumentException("duration must be a value of zero or greater");
        }
        Iterator it = this.f11438e.iterator();
        while (it.hasNext()) {
            ((ept) it.next()).f11458a.mo2233a(j);
        }
        this.f11445l = j;
        return this;
    }

    public void mo2234a() {
        int i;
        int i2;
        ArrayList arrayList;
        int i3 = 0;
        this.f11435b = false;
        this.f11442i = true;
        m17294h();
        int size = this.f11439f.size();
        for (i = 0; i < size; i++) {
            ept com_ushareit_listenit_ept = (ept) this.f11439f.get(i);
            Collection e = com_ushareit_listenit_ept.f11458a.m17279e();
            if (e != null && e.size() > 0) {
                Iterator it = new ArrayList(e).iterator();
                while (it.hasNext()) {
                    epl com_ushareit_listenit_epl = (epl) it.next();
                    if ((com_ushareit_listenit_epl instanceof eps) || (com_ushareit_listenit_epl instanceof epp)) {
                        com_ushareit_listenit_ept.f11458a.m17276b(com_ushareit_listenit_epl);
                    }
                }
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (i2 = 0; i2 < size; i2++) {
            com_ushareit_listenit_ept = (ept) this.f11439f.get(i2);
            if (this.f11441h == null) {
                this.f11441h = new epp(this, this);
            }
            if (com_ushareit_listenit_ept.f11459b == null || com_ushareit_listenit_ept.f11459b.size() == 0) {
                arrayList2.add(com_ushareit_listenit_ept);
            } else {
                int size2 = com_ushareit_listenit_ept.f11459b.size();
                for (i = 0; i < size2; i++) {
                    epr com_ushareit_listenit_epr = (epr) com_ushareit_listenit_ept.f11459b.get(i);
                    com_ushareit_listenit_epr.f11453a.f11458a.m17274a(new eps(this, com_ushareit_listenit_ept, com_ushareit_listenit_epr.f11454b));
                }
                com_ushareit_listenit_ept.f11460c = (ArrayList) com_ushareit_listenit_ept.f11459b.clone();
            }
            com_ushareit_listenit_ept.f11458a.m17274a(this.f11441h);
        }
        if (this.f11443j <= 0) {
            Iterator it2 = arrayList2.iterator();
            while (it2.hasNext()) {
                com_ushareit_listenit_ept = (ept) it2.next();
                com_ushareit_listenit_ept.f11458a.mo2234a();
                this.f11436c.add(com_ushareit_listenit_ept.f11458a);
            }
        } else {
            this.f11444k = eqy.m17366b(0.0f, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
            this.f11444k.mo2252c(this.f11443j);
            this.f11444k.m17274a(new epo(this, arrayList2));
            this.f11444k.mo2234a();
        }
        if (this.a != null) {
            arrayList = (ArrayList) this.a.clone();
            i2 = arrayList.size();
            for (i = 0; i < i2; i++) {
                ((epl) arrayList.get(i)).mo2229a(this);
            }
        }
        if (this.f11438e.size() == 0 && this.f11443j == 0) {
            this.f11442i = false;
            if (this.a != null) {
                arrayList = (ArrayList) this.a.clone();
                i = arrayList.size();
                while (i3 < i) {
                    ((epl) arrayList.get(i3)).mo2230b(this);
                    i3++;
                }
            }
        }
    }

    public epn m17304g() {
        epn com_ushareit_listenit_epn = (epn) super.mo2239f();
        com_ushareit_listenit_epn.f11440g = true;
        com_ushareit_listenit_epn.f11435b = false;
        com_ushareit_listenit_epn.f11442i = false;
        com_ushareit_listenit_epn.f11436c = new ArrayList();
        com_ushareit_listenit_epn.f11437d = new HashMap();
        com_ushareit_listenit_epn.f11438e = new ArrayList();
        com_ushareit_listenit_epn.f11439f = new ArrayList();
        HashMap hashMap = new HashMap();
        Iterator it = this.f11438e.iterator();
        while (it.hasNext()) {
            ept com_ushareit_listenit_ept = (ept) it.next();
            ept a = com_ushareit_listenit_ept.m17318a();
            hashMap.put(com_ushareit_listenit_ept, a);
            com_ushareit_listenit_epn.f11438e.add(a);
            com_ushareit_listenit_epn.f11437d.put(a.f11458a, a);
            a.f11459b = null;
            a.f11460c = null;
            a.f11462e = null;
            a.f11461d = null;
            ArrayList e = a.f11458a.m17279e();
            if (e != null) {
                Iterator it2 = e.iterator();
                ArrayList arrayList = null;
                while (it2.hasNext()) {
                    epl com_ushareit_listenit_epl = (epl) it2.next();
                    if (com_ushareit_listenit_epl instanceof epp) {
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        arrayList.add(com_ushareit_listenit_epl);
                    }
                }
                if (arrayList != null) {
                    Iterator it3 = arrayList.iterator();
                    while (it3.hasNext()) {
                        e.remove((epl) it3.next());
                    }
                }
            }
        }
        it = this.f11438e.iterator();
        while (it.hasNext()) {
            com_ushareit_listenit_ept = (ept) it.next();
            a = (ept) hashMap.get(com_ushareit_listenit_ept);
            if (com_ushareit_listenit_ept.f11459b != null) {
                Iterator it4 = com_ushareit_listenit_ept.f11459b.iterator();
                while (it4.hasNext()) {
                    epr com_ushareit_listenit_epr = (epr) it4.next();
                    a.m17319a(new epr((ept) hashMap.get(com_ushareit_listenit_epr.f11453a), com_ushareit_listenit_epr.f11454b));
                }
            }
        }
        return com_ushareit_listenit_epn;
    }

    private void m17294h() {
        int size;
        ept com_ushareit_listenit_ept;
        int i;
        if (this.f11440g) {
            this.f11439f.clear();
            ArrayList arrayList = new ArrayList();
            size = this.f11438e.size();
            for (int i2 = 0; i2 < size; i2++) {
                com_ushareit_listenit_ept = (ept) this.f11438e.get(i2);
                if (com_ushareit_listenit_ept.f11459b == null || com_ushareit_listenit_ept.f11459b.size() == 0) {
                    arrayList.add(com_ushareit_listenit_ept);
                }
            }
            Object arrayList2 = new ArrayList();
            while (arrayList.size() > 0) {
                int size2 = arrayList.size();
                for (i = 0; i < size2; i++) {
                    com_ushareit_listenit_ept = (ept) arrayList.get(i);
                    this.f11439f.add(com_ushareit_listenit_ept);
                    if (com_ushareit_listenit_ept.f11462e != null) {
                        int size3 = com_ushareit_listenit_ept.f11462e.size();
                        for (size = 0; size < size3; size++) {
                            ept com_ushareit_listenit_ept2 = (ept) com_ushareit_listenit_ept.f11462e.get(size);
                            com_ushareit_listenit_ept2.f11461d.remove(com_ushareit_listenit_ept);
                            if (com_ushareit_listenit_ept2.f11461d.size() == 0) {
                                arrayList2.add(com_ushareit_listenit_ept2);
                            }
                        }
                    }
                }
                arrayList.clear();
                arrayList.addAll(arrayList2);
                arrayList2.clear();
            }
            this.f11440g = false;
            if (this.f11439f.size() != this.f11438e.size()) {
                throw new IllegalStateException("Circular dependencies cannot exist in AnimatorSet");
            }
            return;
        }
        int size4 = this.f11438e.size();
        for (i = 0; i < size4; i++) {
            com_ushareit_listenit_ept = (ept) this.f11438e.get(i);
            if (com_ushareit_listenit_ept.f11459b != null && com_ushareit_listenit_ept.f11459b.size() > 0) {
                int size5 = com_ushareit_listenit_ept.f11459b.size();
                for (size = 0; size < size5; size++) {
                    epr com_ushareit_listenit_epr = (epr) com_ushareit_listenit_ept.f11459b.get(size);
                    if (com_ushareit_listenit_ept.f11461d == null) {
                        com_ushareit_listenit_ept.f11461d = new ArrayList();
                    }
                    if (!com_ushareit_listenit_ept.f11461d.contains(com_ushareit_listenit_epr.f11453a)) {
                        com_ushareit_listenit_ept.f11461d.add(com_ushareit_listenit_epr.f11453a);
                    }
                }
            }
            com_ushareit_listenit_ept.f11463f = false;
        }
    }
}
