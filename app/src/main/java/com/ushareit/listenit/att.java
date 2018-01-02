package com.ushareit.listenit;

import java.util.ArrayList;
import java.util.List;

public class att {
    private static final List<atq> f5461a = new ArrayList();

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String m7140a() {
        /*
        r1 = f5461a;
        monitor-enter(r1);
        r0 = f5461a;	 Catch:{ all -> 0x0039 }
        r0 = r0.isEmpty();	 Catch:{ all -> 0x0039 }
        if (r0 == 0) goto L_0x000f;
    L_0x000b:
        r0 = "";
        monitor-exit(r1);	 Catch:{ all -> 0x0039 }
    L_0x000e:
        return r0;
    L_0x000f:
        r0 = new java.util.ArrayList;	 Catch:{ all -> 0x0039 }
        r2 = f5461a;	 Catch:{ all -> 0x0039 }
        r0.<init>(r2);	 Catch:{ all -> 0x0039 }
        r2 = f5461a;	 Catch:{ all -> 0x0039 }
        r2.clear();	 Catch:{ all -> 0x0039 }
        monitor-exit(r1);	 Catch:{ all -> 0x0039 }
        r1 = new org.json.JSONArray;
        r1.<init>();
        r2 = r0.iterator();
    L_0x0025:
        r0 = r2.hasNext();
        if (r0 == 0) goto L_0x003c;
    L_0x002b:
        r0 = r2.next();
        r0 = (com.ushareit.listenit.atq) r0;
        r0 = r0.m7139a();
        r1.put(r0);
        goto L_0x0025;
    L_0x0039:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0039 }
        throw r0;
    L_0x003c:
        r0 = r1.toString();
        goto L_0x000e;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ushareit.listenit.att.a():java.lang.String");
    }

    public static void m7141a(atq com_ushareit_listenit_atq) {
        synchronized (f5461a) {
            f5461a.add(com_ushareit_listenit_atq);
        }
    }
}
