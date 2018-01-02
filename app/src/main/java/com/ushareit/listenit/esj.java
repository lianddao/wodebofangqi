package com.ushareit.listenit;

import java.util.LinkedList;
import java.util.List;

public abstract class esj {
    protected int f11708a = 2;
    protected esa f11709b;
    protected esn f11710c;
    protected final Object f11711d = new Object();
    protected final LinkedList<ese> f11712e = new LinkedList();
    protected final LinkedList<ese> f11713f = new LinkedList();

    public abstract int mo2369a(ese com_ushareit_listenit_ese);

    protected abstract void mo2370a(ese com_ushareit_listenit_ese, int i);

    public esj(esa com_ushareit_listenit_esa) {
        this.f11709b = com_ushareit_listenit_esa;
    }

    public void m17786a(esn com_ushareit_listenit_esn) {
        this.f11710c = com_ushareit_listenit_esn;
    }

    public void m17788b(ese com_ushareit_listenit_ese) {
        m17778d(com_ushareit_listenit_ese);
        m17782a();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void m17782a() {
        /*
        r7 = this;
        r1 = new java.util.ArrayList;
        r1.<init>();
        r2 = r7.f11711d;
        monitor-enter(r2);
        r0 = r7.f11712e;	 Catch:{ all -> 0x0029 }
        r0 = r0.isEmpty();	 Catch:{ all -> 0x0029 }
        if (r0 == 0) goto L_0x001a;
    L_0x0010:
        r0 = r7.f11713f;	 Catch:{ all -> 0x0029 }
        r0 = r0.isEmpty();	 Catch:{ all -> 0x0029 }
        if (r0 == 0) goto L_0x001a;
    L_0x0018:
        monitor-exit(r2);	 Catch:{ all -> 0x0029 }
    L_0x0019:
        return;
    L_0x001a:
        r0 = r7.f11709b;	 Catch:{ all -> 0x0029 }
        r0 = r0.m17699e();	 Catch:{ all -> 0x0029 }
        if (r0 != 0) goto L_0x002c;
    L_0x0022:
        r0 = r7.f11709b;	 Catch:{ all -> 0x0029 }
        r0.m17702h();	 Catch:{ all -> 0x0029 }
        monitor-exit(r2);	 Catch:{ all -> 0x0029 }
        goto L_0x0019;
    L_0x0029:
        r0 = move-exception;
        monitor-exit(r2);	 Catch:{ all -> 0x0029 }
        throw r0;
    L_0x002c:
        r0 = r7.f11712e;	 Catch:{ all -> 0x0029 }
        r3 = r0.iterator();	 Catch:{ all -> 0x0029 }
    L_0x0032:
        r0 = r3.hasNext();	 Catch:{ all -> 0x0029 }
        if (r0 == 0) goto L_0x0057;
    L_0x0038:
        r0 = r3.next();	 Catch:{ all -> 0x0029 }
        r0 = (com.ushareit.listenit.ese) r0;	 Catch:{ all -> 0x0029 }
        r4 = r7.f11713f;	 Catch:{ all -> 0x0029 }
        r4 = r7.m17776b(r0, r4);	 Catch:{ all -> 0x0029 }
        if (r4 != 0) goto L_0x0032;
    L_0x0046:
        r4 = r7.m17776b(r0, r1);	 Catch:{ all -> 0x0029 }
        if (r4 != 0) goto L_0x0032;
    L_0x004c:
        r1.add(r0);	 Catch:{ all -> 0x0029 }
        r0 = r1.size();	 Catch:{ all -> 0x0029 }
        r4 = r7.f11708a;	 Catch:{ all -> 0x0029 }
        if (r0 < r4) goto L_0x0032;
    L_0x0057:
        r0 = r1.isEmpty();	 Catch:{ all -> 0x0029 }
        if (r0 != 0) goto L_0x0067;
    L_0x005d:
        r0 = r7.f11712e;	 Catch:{ all -> 0x0029 }
        r0.removeAll(r1);	 Catch:{ all -> 0x0029 }
        r0 = r7.f11713f;	 Catch:{ all -> 0x0029 }
        r0.addAll(r1);	 Catch:{ all -> 0x0029 }
    L_0x0067:
        monitor-exit(r2);	 Catch:{ all -> 0x0029 }
        r2 = r1.iterator();
    L_0x006c:
        r0 = r2.hasNext();
        if (r0 == 0) goto L_0x0019;
    L_0x0072:
        r0 = r2.next();
        r0 = (com.ushareit.listenit.ese) r0;
        r1 = r7.f11709b;
        r1 = r1.m17697c();
        r1 = r1.m17684a(r0);
        if (r1 == 0) goto L_0x0099;
    L_0x0084:
        r3 = r1.size();
        r4 = r0.f11690g;
        if (r3 != r4) goto L_0x0099;
    L_0x008c:
        r7.m17780f(r0);
        r3 = r7.f11710c;
        if (r3 == 0) goto L_0x006c;
    L_0x0093:
        r3 = r7.f11710c;
        r3.mo2283a(r0, r1);
        goto L_0x006c;
    L_0x0099:
        r1 = android.os.Looper.getMainLooper();	 Catch:{ Throwable -> 0x00ab }
        r1 = r1.getThread();	 Catch:{ Throwable -> 0x00ab }
        r3 = java.lang.Thread.currentThread();	 Catch:{ Throwable -> 0x00ab }
        if (r1 != r3) goto L_0x00cc;
    L_0x00a7:
        r7.m17777c(r0);	 Catch:{ Throwable -> 0x00ab }
        goto L_0x006c;
    L_0x00ab:
        r1 = move-exception;
        r7.m17780f(r0);
        r3 = r7.f11710c;
        if (r3 == 0) goto L_0x00c2;
    L_0x00b3:
        r3 = r7.f11710c;
        r4 = new com.ushareit.listenit.esd;
        r5 = 1;
        r6 = r1.getMessage();
        r4.<init>(r5, r6);
        r3.mo2282a(r0, r4);
    L_0x00c2:
        r3 = r7.f11709b;
        r3 = r3.m17691a();
        com.ushareit.listenit.esh.m17762a(r3, r0, r1);
        goto L_0x006c;
    L_0x00cc:
        r1 = new com.ushareit.listenit.esk;	 Catch:{ Throwable -> 0x00ab }
        r1.<init>(r7, r0);	 Catch:{ Throwable -> 0x00ab }
        com.ushareit.listenit.faq.m18735a(r1);	 Catch:{ Throwable -> 0x00ab }
        goto L_0x006c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ushareit.listenit.esj.a():void");
    }

    private void m17777c(ese com_ushareit_listenit_ese) {
        try {
            com_ushareit_listenit_ese.m17714a("startTime", System.currentTimeMillis());
            mo2370a(com_ushareit_listenit_ese, com_ushareit_listenit_ese.f11689f);
            esh.m17758a(this.f11709b.m17691a(), com_ushareit_listenit_ese, this.f11709b.m17698d());
        } catch (Throwable th) {
            m17780f(com_ushareit_listenit_ese);
            if (this.f11710c != null) {
                this.f11710c.mo2282a(com_ushareit_listenit_ese, new esd(1, th.getMessage()));
            }
            esh.m17762a(this.f11709b.m17691a(), com_ushareit_listenit_ese, th);
        }
    }

    protected void m17785a(ese com_ushareit_listenit_ese, List<esi> list) {
        com_ushareit_listenit_ese.m17714a("endTime", System.currentTimeMillis());
        this.f11709b.m17697c().m17686a((List) list);
        List a = this.f11709b.m17697c().m17684a(com_ushareit_listenit_ese);
        m17780f(com_ushareit_listenit_ese);
        if (this.f11710c != null) {
            if (a == null) {
                this.f11710c.mo2282a(com_ushareit_listenit_ese, new esd(2002, "loaded count is less than request count"));
            } else {
                this.f11710c.mo2283a(com_ushareit_listenit_ese, a);
            }
        }
        if (a == null) {
            esh.m17761a(this.f11709b.m17691a(), com_ushareit_listenit_ese, "loaded_less_count", null, this.f11709b.m17698d());
        } else {
            esh.m17761a(this.f11709b.m17691a(), com_ushareit_listenit_ese, "loaded_success", null, this.f11709b.m17698d());
        }
        m17782a();
    }

    protected void m17784a(ese com_ushareit_listenit_ese, esd com_ushareit_listenit_esd) {
        esh.m17760a(this.f11709b.m17691a(), com_ushareit_listenit_ese, com_ushareit_listenit_esd, this.f11709b.m17698d());
        int a = com_ushareit_listenit_esd != null ? com_ushareit_listenit_esd.mo2345a() : 1;
        if (a != 1000 || (com_ushareit_listenit_ese.f11692i && this.f11709b.m17699e())) {
            if (a == 2001 || a == 1003) {
                Boolean f = this.f11709b.m17700f();
                if (f == null) {
                    faq.m18736a(new esl(this, "ad_check_reachable", com_ushareit_listenit_ese, com_ushareit_listenit_esd));
                    return;
                } else if (!f.booleanValue()) {
                    m17779e(com_ushareit_listenit_ese);
                    this.f11709b.m17702h();
                    return;
                }
            }
            m17774b(com_ushareit_listenit_ese, com_ushareit_listenit_esd);
            return;
        }
        m17779e(com_ushareit_listenit_ese);
        this.f11709b.m17702h();
    }

    protected void m17787a(Object obj) {
        if (this.f11710c != null) {
            this.f11710c.mo2284a(obj);
        }
    }

    protected void m17789b(Object obj) {
        if (this.f11710c != null) {
            this.f11710c.mo2285b(obj);
        }
    }

    private void m17774b(ese com_ushareit_listenit_ese, esd com_ushareit_listenit_esd) {
        m17780f(com_ushareit_listenit_ese);
        if (this.f11710c != null) {
            this.f11710c.mo2282a(com_ushareit_listenit_ese, com_ushareit_listenit_esd);
        }
        esh.m17761a(this.f11709b.m17691a(), com_ushareit_listenit_ese, "load_failed", com_ushareit_listenit_esd, this.f11709b.m17698d());
        m17782a();
    }

    private void m17778d(ese com_ushareit_listenit_ese) {
        synchronized (this.f11711d) {
            if (this.f11712e.contains(com_ushareit_listenit_ese)) {
                exw.m18449b("AD.BaseLoader", "doAddAd(): " + com_ushareit_listenit_ese.mo2366a() + " is in waiting queue");
            } else if (this.f11713f.contains(com_ushareit_listenit_ese)) {
                exw.m18449b("AD.BaseLoader", "doAddAd(): " + com_ushareit_listenit_ese.mo2366a() + " is in running queue");
            } else {
                this.f11712e.add(com_ushareit_listenit_ese);
            }
        }
    }

    private void m17779e(ese com_ushareit_listenit_ese) {
        synchronized (this.f11711d) {
            this.f11713f.remove(com_ushareit_listenit_ese);
            if (!this.f11712e.contains(com_ushareit_listenit_ese)) {
                this.f11712e.add(com_ushareit_listenit_ese);
            }
        }
    }

    private void m17780f(ese com_ushareit_listenit_ese) {
        synchronized (this.f11711d) {
            this.f11712e.remove(com_ushareit_listenit_ese);
            this.f11713f.remove(com_ushareit_listenit_ese);
        }
    }

    private boolean m17776b(ese com_ushareit_listenit_ese, List<ese> list) {
        for (ese com_ushareit_listenit_ese2 : list) {
            if (com_ushareit_listenit_ese.f11686c.equals(com_ushareit_listenit_ese2.f11686c)) {
                return true;
            }
        }
        return false;
    }
}
