package com.ushareit.listenit;

import android.os.Handler;
import android.os.Looper;

class gwl extends Handler {
    final /* synthetic */ gwk f14829a;

    gwl(gwk com_ushareit_listenit_gwk, Looper looper) {
        this.f14829a = com_ushareit_listenit_gwk;
        super(looper);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void handleMessage(android.os.Message r11) {
        /*
        r10 = this;
        r8 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r6 = 0;
        r2 = r10.f14829a;
        monitor-enter(r2);
        r0 = r10.f14829a;	 Catch:{ all -> 0x0054 }
        r0 = r0.f14823b;	 Catch:{ all -> 0x0054 }
        if (r0 != 0) goto L_0x0018;
    L_0x000f:
        r0 = "sleep";
        r1 = "clock not running";
        com.ushareit.listenit.exw.m18454c(r0, r1);	 Catch:{ all -> 0x0054 }
        monitor-exit(r2);	 Catch:{ all -> 0x0054 }
    L_0x0017:
        return;
    L_0x0018:
        r0 = r10.f14829a;	 Catch:{ all -> 0x0054 }
        r0 = r0.f14826e;	 Catch:{ all -> 0x0054 }
        r4 = android.os.SystemClock.elapsedRealtime();	 Catch:{ all -> 0x0054 }
        r0 = r0 - r4;
        r3 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1));
        if (r3 > 0) goto L_0x0057;
    L_0x0027:
        r0 = r10.f14829a;	 Catch:{ all -> 0x0054 }
        r0.m23069g();	 Catch:{ all -> 0x0054 }
        r0 = r10.f14829a;	 Catch:{ all -> 0x0054 }
        r0 = r0.f14824c;	 Catch:{ all -> 0x0054 }
        if (r0 == 0) goto L_0x004d;
    L_0x0034:
        r0 = r10.f14829a;	 Catch:{ all -> 0x0054 }
        r0 = r0.f14824c;	 Catch:{ all -> 0x0054 }
        r0 = r0.getResources();	 Catch:{ all -> 0x0054 }
        r1 = 2131165574; // 0x7f070186 float:1.7945369E38 double:1.0529356957E-314;
        r0 = r0.getString(r1);	 Catch:{ all -> 0x0054 }
        r1 = 0;
        r0 = com.ushareit.listenit.heb.m23597a(r0, r1);	 Catch:{ all -> 0x0054 }
        r0.show();	 Catch:{ all -> 0x0054 }
    L_0x004d:
        r0 = r10.f14829a;	 Catch:{ all -> 0x0054 }
        r0.m23076d();	 Catch:{ all -> 0x0054 }
    L_0x0052:
        monitor-exit(r2);	 Catch:{ all -> 0x0054 }
        goto L_0x0017;
    L_0x0054:
        r0 = move-exception;
        monitor-exit(r2);	 Catch:{ all -> 0x0054 }
        throw r0;
    L_0x0057:
        r4 = android.os.SystemClock.elapsedRealtime();	 Catch:{ all -> 0x0054 }
        r3 = r10.f14829a;	 Catch:{ all -> 0x0054 }
        r3.m23071a(r0);	 Catch:{ all -> 0x0054 }
        r0 = r4 + r8;
        r4 = android.os.SystemClock.elapsedRealtime();	 Catch:{ all -> 0x0054 }
        r0 = r0 - r4;
    L_0x0067:
        r3 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1));
        if (r3 >= 0) goto L_0x006d;
    L_0x006b:
        r0 = r0 + r8;
        goto L_0x0067;
    L_0x006d:
        r3 = 0;
        r3 = r10.obtainMessage(r3);	 Catch:{ all -> 0x0054 }
        r10.sendMessageDelayed(r3, r0);	 Catch:{ all -> 0x0054 }
        goto L_0x0052;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ushareit.listenit.gwl.handleMessage(android.os.Message):void");
    }
}
