package com.ushareit.listenit;

import android.graphics.Bitmap;
import android.util.Log;
import java.io.OutputStream;

public class aco implements uy<abx> {
    private static final acp f4124a = new acp();
    private final um f4125b;
    private final ws f4126c;
    private final acp f4127d;

    public boolean m5222a(com.ushareit.listenit.wk<com.ushareit.listenit.abx> r11, java.io.OutputStream r12) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.ssa.SSATransform.placePhi(SSATransform.java:82)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:50)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r10 = this;
        r3 = 0;
        r4 = com.ushareit.listenit.afq.m5477a();
        r0 = r11.mo553b();
        r0 = (com.ushareit.listenit.abx) r0;
        r6 = r0.m5149c();
        r1 = r6 instanceof com.ushareit.listenit.aam;
        if (r1 == 0) goto L_0x001c;
    L_0x0013:
        r0 = r0.m5150d();
        r3 = r10.m5220a(r0, r12);
    L_0x001b:
        return r3;
    L_0x001c:
        r1 = r0.m5150d();
        r7 = r10.m5218a(r1);
        r1 = r10.f4127d;
        r8 = r1.m5227b();
        r1 = r8.m26598a(r12);
        if (r1 == 0) goto L_0x001b;
    L_0x0030:
        r2 = r3;
    L_0x0031:
        r1 = r7.m26559c();
        if (r2 >= r1) goto L_0x0069;
    L_0x0037:
        r1 = r7.m26562f();
        r9 = r10.m5219a(r1, r6, r0);
        r1 = r9.mo553b();	 Catch:{ all -> 0x0064 }
        r1 = (android.graphics.Bitmap) r1;	 Catch:{ all -> 0x0064 }
        r1 = r8.m26597a(r1);	 Catch:{ all -> 0x0064 }
        if (r1 != 0) goto L_0x004f;
    L_0x004b:
        r9.mo555d();
        goto L_0x001b;
    L_0x004f:
        r1 = r7.m26560d();	 Catch:{ all -> 0x0064 }
        r1 = r7.m26555a(r1);	 Catch:{ all -> 0x0064 }
        r8.m26594a(r1);	 Catch:{ all -> 0x0064 }
        r7.m26556a();	 Catch:{ all -> 0x0064 }
        r9.mo555d();
        r1 = r2 + 1;
        r2 = r1;
        goto L_0x0031;
    L_0x0064:
        r0 = move-exception;
        r9.mo555d();
        throw r0;
    L_0x0069:
        r3 = r8.m26596a();
        r1 = "GifEncoder";
        r2 = 2;
        r1 = android.util.Log.isLoggable(r1, r2);
        if (r1 == 0) goto L_0x001b;
    L_0x0076:
        r1 = "GifEncoder";
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r6 = "Encoded gif with ";
        r2 = r2.append(r6);
        r6 = r7.m26559c();
        r2 = r2.append(r6);
        r6 = " frames and ";
        r2 = r2.append(r6);
        r0 = r0.m5150d();
        r0 = r0.length;
        r0 = r2.append(r0);
        r2 = " bytes in ";
        r0 = r0.append(r2);
        r4 = com.ushareit.listenit.afq.m5476a(r4);
        r0 = r0.append(r4);
        r2 = " ms";
        r0 = r0.append(r2);
        r0 = r0.toString();
        android.util.Log.v(r1, r0);
        goto L_0x001b;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ushareit.listenit.aco.a(com.ushareit.listenit.wk, java.io.OutputStream):boolean");
    }

    public aco(ws wsVar) {
        this(wsVar, f4124a);
    }

    aco(ws wsVar, acp com_ushareit_listenit_acp) {
        this.f4126c = wsVar;
        this.f4125b = new abw(wsVar);
        this.f4127d = com_ushareit_listenit_acp;
    }

    private boolean m5220a(byte[] bArr, OutputStream outputStream) {
        try {
            outputStream.write(bArr);
            return true;
        } catch (Throwable e) {
            if (Log.isLoggable("GifEncoder", 3)) {
                Log.d("GifEncoder", "Failed to write data to output stream in GifResourceEncoder", e);
            }
            return false;
        }
    }

    private ul m5218a(byte[] bArr) {
        up a = this.f4127d.m5225a();
        a.m26580a(bArr);
        uo b = a.m26582b();
        ul a2 = this.f4127d.m5224a(this.f4125b);
        a2.m26557a(b, bArr);
        a2.m26556a();
        return a2;
    }

    private wk<Bitmap> m5219a(Bitmap bitmap, uz<Bitmap> uzVar, abx com_ushareit_listenit_abx) {
        wk a = this.f4127d.m5226a(bitmap, this.f4126c);
        wk<Bitmap> a2 = uzVar.mo556a(a, com_ushareit_listenit_abx.getIntrinsicWidth(), com_ushareit_listenit_abx.getIntrinsicHeight());
        if (!a.equals(a2)) {
            a.mo555d();
        }
        return a2;
    }

    public String mo551a() {
        return "";
    }
}
