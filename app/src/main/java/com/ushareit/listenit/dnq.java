package com.ushareit.listenit;

import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Message;
import android.util.Log;
import android.util.SparseArray;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Status;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

class dnq<O extends cdk> implements ceb, cec, dmf {
    final /* synthetic */ dnn f10050a;
    private final Queue<dlj> f10051b = new LinkedList();
    private final cdt f10052c;
    private final cdq f10053d;
    private final dlp<O> f10054e;
    private final SparseArray<dow> f10055f = new SparseArray();
    private final Set<dls> f10056g = new HashSet();
    private final SparseArray<Map<doi<?>, dol>> f10057h = new SparseArray();
    private boolean f10058i;
    private ConnectionResult f10059j = null;

    public dnq(dnn com_ushareit_listenit_dnn, ceo<O> com_ushareit_listenit_ceo_O) {
        this.f10050a = com_ushareit_listenit_dnn;
        this.f10052c = com_ushareit_listenit_ceo_O.m10974a(com_ushareit_listenit_dnn.f10041n.getLooper(), this, this);
        if (this.f10052c instanceof cfn) {
            this.f10053d = ((cfn) this.f10052c).mo1281f();
        } else {
            this.f10053d = this.f10052c;
        }
        this.f10054e = com_ushareit_listenit_ceo_O.m10983e();
    }

    private void m15099a(Status status) {
        for (dlj a : this.f10051b) {
            a.mo1943a(status);
        }
        this.f10051b.clear();
    }

    private void m15102b(ConnectionResult connectionResult) {
        for (dls a : this.f10056g) {
            a.m14815a(this.f10054e, connectionResult);
        }
        this.f10056g.clear();
    }

    private void m15103b(dlj com_ushareit_listenit_dlj) {
        com_ushareit_listenit_dlj.mo1942a(this.f10055f);
        try {
            com_ushareit_listenit_dlj.mo1944a(this.f10053d);
        } catch (DeadObjectException e) {
            this.f10052c.mo2075g();
            mo1956a(1);
        }
    }

    private void m15108e() {
        if (this.f10058i) {
            m15113j();
        }
    }

    private void m15109f() {
        if (this.f10058i) {
            this.f10050a.f10041n.removeMessages(10, this.f10054e);
            this.f10050a.f10041n.removeMessages(9, this.f10054e);
            this.f10058i = false;
        }
    }

    private void m15110g() {
        if (this.f10058i) {
            m15109f();
            m15099a(this.f10050a.f10034g.mo1287a(this.f10050a.f10033f) == 18 ? new Status(8, "Connection timed out while waiting for Google Play services update to complete.") : new Status(8, "API failed to connect while resuming due to an unknown error."));
            this.f10052c.mo2075g();
        }
    }

    private void m15111h() {
        this.f10050a.f10041n.removeMessages(11, this.f10054e);
        this.f10050a.f10041n.sendMessageDelayed(this.f10050a.f10041n.obtainMessage(11, this.f10054e), this.f10050a.f10032c);
    }

    private void m15112i() {
        if (this.f10052c.m10644h() && this.f10057h.size() == 0) {
            for (int i = 0; i < this.f10055f.size(); i++) {
                if (((dow) this.f10055f.get(this.f10055f.keyAt(i))).m15210c()) {
                    m15111h();
                    return;
                }
            }
            this.f10052c.mo2075g();
        }
    }

    private void m15113j() {
        if (!this.f10052c.m10644h() && !this.f10052c.m10645i()) {
            if (this.f10052c.mo1399k() && this.f10050a.f10035h != 0) {
                this.f10050a.f10035h = this.f10050a.f10034g.mo1287a(this.f10050a.f10033f);
                if (this.f10050a.f10035h != 0) {
                    mo1954a(new ConnectionResult(this.f10050a.f10035h, null));
                    return;
                }
            }
            this.f10052c.m10638a(new dns(this.f10050a, this.f10052c, this.f10054e));
        }
    }

    public void m15114a() {
        while (this.f10052c.m10644h() && !this.f10051b.isEmpty()) {
            m15103b((dlj) this.f10051b.remove());
        }
    }

    public void mo1956a(int i) {
        m15124b();
        this.f10058i = true;
        this.f10050a.f10041n.sendMessageDelayed(Message.obtain(this.f10050a.f10041n, 9, this.f10054e), this.f10050a.f10030a);
        this.f10050a.f10041n.sendMessageDelayed(Message.obtain(this.f10050a.f10041n, 10, this.f10054e), this.f10050a.f10031b);
        this.f10050a.f10035h = -1;
    }

    public void m15116a(int i, doi<?> com_ushareit_listenit_doi_, dzp<Void> com_ushareit_listenit_dzp_java_lang_Void) {
        Map map = (Map) this.f10057h.get(i);
        if (map == null || map.get(com_ushareit_listenit_doi_) == null) {
            com_ushareit_listenit_dzp_java_lang_Void.m16567a(new cel(Status.f1688c));
            Log.wtf("GoogleApiManager", "Received call to unregister a listener without a matching registration call.", new Exception());
            return;
        }
        m15122a(new dlo(i, ((dol) map.get(com_ushareit_listenit_doi_)).f10093b, com_ushareit_listenit_dzp_java_lang_Void, this.f10057h));
    }

    public void m15117a(int i, dol com_ushareit_listenit_dol, dzp<Void> com_ushareit_listenit_dzp_java_lang_Void) {
        m15122a(new dlm(i, com_ushareit_listenit_dol, com_ushareit_listenit_dzp_java_lang_Void, this.f10057h));
    }

    public void m15118a(int i, boolean z) {
        Iterator it = this.f10051b.iterator();
        while (it.hasNext()) {
            dlj com_ushareit_listenit_dlj = (dlj) it.next();
            if (com_ushareit_listenit_dlj.f9877a == i && com_ushareit_listenit_dlj.f9878b != 1 && com_ushareit_listenit_dlj.mo1945a()) {
                it.remove();
            }
        }
        ((dow) this.f10055f.get(i)).m15205a();
        this.f10057h.delete(i);
        if (!z) {
            this.f10055f.remove(i);
            this.f10050a.f10043p.remove(i);
            if (this.f10055f.size() == 0 && this.f10051b.isEmpty()) {
                m15109f();
                this.f10052c.mo2075g();
                this.f10050a.f10038k.remove(this.f10054e);
                synchronized (dnn.f10028d) {
                    this.f10050a.f10040m.remove(this.f10054e);
                }
            }
        }
    }

    public void mo1957a(Bundle bundle) {
        m15124b();
        m15102b(ConnectionResult.f1674a);
        m15109f();
        for (int i = 0; i < this.f10057h.size(); i++) {
            for (dol com_ushareit_listenit_dol : ((Map) this.f10057h.get(this.f10057h.keyAt(i))).values()) {
                try {
                    com_ushareit_listenit_dol.f10092a.m15165a(this.f10053d, new dzp());
                } catch (DeadObjectException e) {
                    this.f10052c.mo2075g();
                    mo1956a(1);
                }
            }
        }
        m15114a();
        m15111h();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo1954a(com.google.android.gms.common.ConnectionResult r6) {
        /*
        r5 = this;
        r5.m15124b();
        r0 = r5.f10050a;
        r1 = -1;
        r0.f10035h = r1;
        r5.m15102b(r6);
        r0 = r5.f10055f;
        r1 = 0;
        r0 = r0.keyAt(r1);
        r1 = r5.f10051b;
        r1 = r1.isEmpty();
        if (r1 == 0) goto L_0x001e;
    L_0x001b:
        r5.f10059j = r6;
    L_0x001d:
        return;
    L_0x001e:
        r1 = com.ushareit.listenit.dnn.f10028d;
        monitor-enter(r1);
        r2 = r5.f10050a;	 Catch:{ all -> 0x0044 }
        r2 = null;	 Catch:{ all -> 0x0044 }
        if (r2 == 0) goto L_0x0047;
    L_0x002b:
        r2 = r5.f10050a;	 Catch:{ all -> 0x0044 }
        r2 = r2.f10040m;	 Catch:{ all -> 0x0044 }
        r3 = r5.f10054e;	 Catch:{ all -> 0x0044 }
        r2 = r2.contains(r3);	 Catch:{ all -> 0x0044 }
        if (r2 == 0) goto L_0x0047;
    L_0x0039:
        r2 = r5.f10050a;	 Catch:{ all -> 0x0044 }
        r2 = null;	 Catch:{ all -> 0x0044 }
        r2.m14799b(r6, r0);	 Catch:{ all -> 0x0044 }
        monitor-exit(r1);	 Catch:{ all -> 0x0044 }
        goto L_0x001d;
    L_0x0044:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0044 }
        throw r0;
    L_0x0047:
        monitor-exit(r1);	 Catch:{ all -> 0x0044 }
        r1 = r5.f10050a;
        r0 = r1.m15093a(r6, r0);
        if (r0 != 0) goto L_0x001d;
    L_0x0050:
        r0 = r6.m2236c();
        r1 = 18;
        if (r0 != r1) goto L_0x005b;
    L_0x0058:
        r0 = 1;
        r5.f10058i = r0;
    L_0x005b:
        r0 = r5.f10058i;
        if (r0 == 0) goto L_0x007d;
    L_0x005f:
        r0 = r5.f10050a;
        r0 = r0.f10041n;
        r1 = r5.f10050a;
        r1 = r1.f10041n;
        r2 = 9;
        r3 = r5.f10054e;
        r1 = android.os.Message.obtain(r1, r2, r3);
        r2 = r5.f10050a;
        r2 = r2.f10030a;
        r0.sendMessageDelayed(r1, r2);
        goto L_0x001d;
    L_0x007d:
        r0 = new com.google.android.gms.common.api.Status;
        r1 = 17;
        r2 = r5.f10054e;
        r2 = r2.m14790a();
        r2 = java.lang.String.valueOf(r2);
        r3 = new java.lang.StringBuilder;
        r4 = java.lang.String.valueOf(r2);
        r4 = r4.length();
        r4 = r4 + 38;
        r3.<init>(r4);
        r4 = "API: ";
        r3 = r3.append(r4);
        r2 = r3.append(r2);
        r3 = " is not available on this device.";
        r2 = r2.append(r3);
        r2 = r2.toString();
        r0.<init>(r1, r2);
        r5.m15099a(r0);
        goto L_0x001d;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ushareit.listenit.dnq.a(com.google.android.gms.common.ConnectionResult):void");
    }

    public void mo2009a(ConnectionResult connectionResult, cdj<?> com_ushareit_listenit_cdj_, int i) {
        mo1954a(connectionResult);
    }

    public void m15122a(dlj com_ushareit_listenit_dlj) {
        if (this.f10052c.m10644h()) {
            m15103b(com_ushareit_listenit_dlj);
            m15111h();
            return;
        }
        this.f10051b.add(com_ushareit_listenit_dlj);
        if (this.f10059j == null || !this.f10059j.m2234a()) {
            m15113j();
        } else {
            mo1954a(this.f10059j);
        }
    }

    public void m15123a(dls com_ushareit_listenit_dls) {
        this.f10056g.add(com_ushareit_listenit_dls);
    }

    public void m15124b() {
        this.f10059j = null;
    }

    public void m15125b(int i) {
        this.f10055f.put(i, new dow(this.f10052c));
    }

    ConnectionResult m15126c() {
        return this.f10059j;
    }

    public void m15127c(int i) {
        ((dow) this.f10055f.get(i)).m15207a(new dnr(this, i));
    }

    boolean m15128d() {
        return this.f10052c.m10644h();
    }
}
