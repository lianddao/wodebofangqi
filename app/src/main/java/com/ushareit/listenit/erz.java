package com.ushareit.listenit;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public final class erz {
    private final LinkedList<esi> f11664a = new LinkedList();

    public void m17686a(List<esi> list) {
        synchronized (this.f11664a) {
            this.f11664a.addAll(list);
        }
    }

    public List<esi> m17684a(ese com_ushareit_listenit_ese) {
        return m17685a(com_ushareit_listenit_ese, false);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List<com.ushareit.listenit.esi> m17685a(com.ushareit.listenit.ese r10, boolean r11) {
        /*
        r9 = this;
        r3 = 0;
        r9.m17683a();
        r5 = r9.f11664a;
        monitor-enter(r5);
        r1 = r9.f11664a;	 Catch:{ all -> 0x0087 }
        r1 = r1.size();	 Catch:{ all -> 0x0087 }
        r2 = r10.f11690g;	 Catch:{ all -> 0x0087 }
        if (r1 >= r2) goto L_0x0020;
    L_0x0011:
        if (r11 == 0) goto L_0x001d;
    L_0x0013:
        r1 = r9.f11664a;	 Catch:{ all -> 0x0087 }
        r1 = r1.size();	 Catch:{ all -> 0x0087 }
        r2 = r10.f11691h;	 Catch:{ all -> 0x0087 }
        if (r1 >= r2) goto L_0x0020;
    L_0x001d:
        monitor-exit(r5);	 Catch:{ all -> 0x0087 }
        r1 = r3;
    L_0x001f:
        return r1;
    L_0x0020:
        r4 = new java.util.ArrayList;	 Catch:{ all -> 0x0087 }
        r4.<init>();	 Catch:{ all -> 0x0087 }
        r6 = new java.util.HashSet;	 Catch:{ all -> 0x0087 }
        r6.<init>();	 Catch:{ all -> 0x0087 }
        r1 = r9.f11664a;	 Catch:{ all -> 0x0087 }
        r7 = r1.iterator();	 Catch:{ all -> 0x0087 }
    L_0x0030:
        r1 = r7.hasNext();	 Catch:{ all -> 0x0087 }
        if (r1 == 0) goto L_0x00a5;
    L_0x0036:
        r1 = r7.next();	 Catch:{ all -> 0x0087 }
        r1 = (com.ushareit.listenit.esi) r1;	 Catch:{ all -> 0x0087 }
        r0 = r10;
        r0 = (com.ushareit.listenit.ffl) r0;	 Catch:{ all -> 0x0087 }
        r2 = r0;
        r2 = r2.f12607l;	 Catch:{ all -> 0x0087 }
        r8 = r1.m17771e();	 Catch:{ all -> 0x0087 }
        r2 = r2.equals(r8);	 Catch:{ all -> 0x0087 }
        if (r2 == 0) goto L_0x0030;
    L_0x004c:
        r2 = r10.m17724b();	 Catch:{ all -> 0x0087 }
        if (r2 == 0) goto L_0x0091;
    L_0x0052:
        r2 = r1.m17770d();	 Catch:{ all -> 0x0087 }
        r8 = r10.m17723a(r2);	 Catch:{ all -> 0x0087 }
        if (r8 != 0) goto L_0x0066;
    L_0x005c:
        r8 = java.lang.Integer.valueOf(r2);	 Catch:{ all -> 0x0087 }
        r8 = r6.contains(r8);	 Catch:{ all -> 0x0087 }
        if (r8 == 0) goto L_0x008a;
    L_0x0066:
        r1 = "AD.Cache";
        r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0087 }
        r2.<init>();	 Catch:{ all -> 0x0087 }
        r8 = "popFromAdCache() ";
        r2 = r2.append(r8);	 Catch:{ all -> 0x0087 }
        r8 = r10.f11685b;	 Catch:{ all -> 0x0087 }
        r2 = r2.append(r8);	 Catch:{ all -> 0x0087 }
        r8 = " has repeat keyword";
        r2 = r2.append(r8);	 Catch:{ all -> 0x0087 }
        r2 = r2.toString();	 Catch:{ all -> 0x0087 }
        com.ushareit.listenit.exw.m18449b(r1, r2);	 Catch:{ all -> 0x0087 }
        goto L_0x0030;
    L_0x0087:
        r1 = move-exception;
        monitor-exit(r5);	 Catch:{ all -> 0x0087 }
        throw r1;
    L_0x008a:
        r2 = java.lang.Integer.valueOf(r2);	 Catch:{ all -> 0x0087 }
        r6.add(r2);	 Catch:{ all -> 0x0087 }
    L_0x0091:
        r4.add(r1);	 Catch:{ all -> 0x0087 }
        r1 = r4.size();	 Catch:{ all -> 0x0087 }
        r2 = r10.f11690g;	 Catch:{ all -> 0x0087 }
        if (r1 < r2) goto L_0x0030;
    L_0x009c:
        r1 = r9.f11664a;	 Catch:{ all -> 0x0087 }
        r1.removeAll(r4);	 Catch:{ all -> 0x0087 }
        monitor-exit(r5);	 Catch:{ all -> 0x0087 }
        r1 = r4;
        goto L_0x001f;
    L_0x00a5:
        if (r11 == 0) goto L_0x00b8;
    L_0x00a7:
        r1 = r4.size();	 Catch:{ all -> 0x0087 }
        r2 = r10.f11691h;	 Catch:{ all -> 0x0087 }
        if (r1 < r2) goto L_0x00b8;
    L_0x00af:
        r1 = r9.f11664a;	 Catch:{ all -> 0x0087 }
        r1.removeAll(r4);	 Catch:{ all -> 0x0087 }
        monitor-exit(r5);	 Catch:{ all -> 0x0087 }
        r1 = r4;
        goto L_0x001f;
    L_0x00b8:
        monitor-exit(r5);	 Catch:{ all -> 0x0087 }
        r1 = r3;
        goto L_0x001f;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ushareit.listenit.erz.a(com.ushareit.listenit.ese, boolean):java.util.List<com.ushareit.listenit.esi>");
    }

    public boolean m17687b(ese com_ushareit_listenit_ese) {
        m17683a();
        synchronized (this.f11664a) {
            if (this.f11664a.size() < com_ushareit_listenit_ese.f11690g) {
                return false;
            }
            List arrayList = new ArrayList();
            Set hashSet = new HashSet();
            Iterator it = this.f11664a.iterator();
            while (it.hasNext()) {
                esi com_ushareit_listenit_esi = (esi) it.next();
                if (((ffl) com_ushareit_listenit_ese).f12607l.equals(com_ushareit_listenit_esi.m17771e())) {
                    if (com_ushareit_listenit_ese.m17724b()) {
                        int d = com_ushareit_listenit_esi.m17770d();
                        if (!(com_ushareit_listenit_ese.m17723a(d) || hashSet.contains(Integer.valueOf(d)))) {
                            hashSet.add(Integer.valueOf(d));
                        }
                    }
                    arrayList.add(com_ushareit_listenit_esi);
                    if (arrayList.size() >= com_ushareit_listenit_ese.f11690g) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

    private void m17683a() {
        synchronized (this.f11664a) {
            Collection arrayList = new ArrayList();
            Iterator it = this.f11664a.iterator();
            while (it.hasNext()) {
                esi com_ushareit_listenit_esi = (esi) it.next();
                if (com_ushareit_listenit_esi.m17767a(-300000)) {
                    arrayList.add(com_ushareit_listenit_esi);
                }
            }
            this.f11664a.removeAll(arrayList);
        }
    }
}
