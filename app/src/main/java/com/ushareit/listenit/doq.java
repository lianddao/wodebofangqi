package com.ushareit.listenit;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.Map.Entry;
import java.util.WeakHashMap;

public final class doq extends ah implements doe {
    private static WeakHashMap<ak, WeakReference<doq>> f10096a = new WeakHashMap();
    private Map<String, dod> f10097b = new fq();
    private int f10098c = 0;
    private Bundle f10099d;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.ushareit.listenit.doq m15173a(com.ushareit.listenit.ak r3) {
        /*
        r0 = f10096a;
        r0 = r0.get(r3);
        r0 = (java.lang.ref.WeakReference) r0;
        if (r0 == 0) goto L_0x0013;
    L_0x000a:
        r0 = r0.get();
        r0 = (com.ushareit.listenit.doq) r0;
        if (r0 == 0) goto L_0x0013;
    L_0x0012:
        return r0;
    L_0x0013:
        r0 = r3.m709f();	 Catch:{ ClassCastException -> 0x0048 }
        r1 = "SupportLifecycleFragmentImpl";
        r0 = r0.mo796a(r1);	 Catch:{ ClassCastException -> 0x0048 }
        r0 = (com.ushareit.listenit.doq) r0;	 Catch:{ ClassCastException -> 0x0048 }
        if (r0 == 0) goto L_0x0027;
    L_0x0021:
        r1 = r0.m1334s();
        if (r1 == 0) goto L_0x003d;
    L_0x0027:
        r0 = new com.ushareit.listenit.doq;
        r0.<init>();
        r1 = r3.m709f();
        r1 = r1.mo797a();
        r2 = "SupportLifecycleFragmentImpl";
        r1 = r1.mo3093a(r0, r2);
        r1.mo3098c();
    L_0x003d:
        r1 = f10096a;
        r2 = new java.lang.ref.WeakReference;
        r2.<init>(r0);
        r1.put(r3, r2);
        goto L_0x0012;
    L_0x0048:
        r0 = move-exception;
        r1 = new java.lang.IllegalStateException;
        r2 = "Fragment with tag SupportLifecycleFragmentImpl is not a SupportLifecycleFragmentImpl";
        r1.<init>(r2, r0);
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ushareit.listenit.doq.a(com.ushareit.listenit.ak):com.ushareit.listenit.doq");
    }

    private void m15175b(String str, dod com_ushareit_listenit_dod) {
        if (this.f10098c > 0) {
            new Handler(Looper.getMainLooper()).post(new dor(this, com_ushareit_listenit_dod, str));
        }
    }

    public /* synthetic */ Activity mo2012a() {
        return m15182b();
    }

    public <T extends dod> T mo2013a(String str, Class<T> cls) {
        return (dod) cls.cast(this.f10097b.get(str));
    }

    public void mo200a(int i, int i2, Intent intent) {
        super.mo200a(i, i2, intent);
        for (dod a : this.f10097b.values()) {
            a.mo1947a(i, i2, intent);
        }
    }

    public void mo168a(Bundle bundle) {
        super.mo168a(bundle);
        this.f10098c = 1;
        this.f10099d = bundle;
        for (Entry entry : this.f10097b.entrySet()) {
            ((dod) entry.getValue()).mo1948a(bundle != null ? bundle.getBundle((String) entry.getKey()) : null);
        }
    }

    public void mo2014a(String str, dod com_ushareit_listenit_dod) {
        if (this.f10097b.containsKey(str)) {
            throw new IllegalArgumentException(new StringBuilder(String.valueOf(str).length() + 59).append("LifecycleCallback with tag ").append(str).append(" already added to this fragment.").toString());
        }
        this.f10097b.put(str, com_ushareit_listenit_dod);
        m15175b(str, com_ushareit_listenit_dod);
    }

    public void mo2015a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.mo2015a(str, fileDescriptor, printWriter, strArr);
        for (dod a : this.f10097b.values()) {
            a.mo1952a(str, fileDescriptor, printWriter, strArr);
        }
    }

    public ak m15182b() {
        return m1328m();
    }

    public void mo172e(Bundle bundle) {
        super.mo172e(bundle);
        if (bundle != null) {
            for (Entry entry : this.f10097b.entrySet()) {
                Bundle bundle2 = new Bundle();
                ((dod) entry.getValue()).mo1950b(bundle2);
                bundle.putBundle((String) entry.getKey(), bundle2);
            }
        }
    }

    public void mo173f() {
        super.mo174g();
        this.f10098c = 2;
        for (dod b : this.f10097b.values()) {
            b.mo1949b();
        }
    }

    public void mo174g() {
        super.mo174g();
        this.f10098c = 3;
        for (dod a : this.f10097b.values()) {
            a.mo1671a();
        }
    }

    public void mo203z() {
        super.mo174g();
        this.f10098c = 4;
        for (dod f : this.f10097b.values()) {
            f.m13528f();
        }
    }
}
