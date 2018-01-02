package com.ushareit.listenit;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Fragment;
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

@TargetApi(11)
public final class dof extends Fragment implements doe {
    private static WeakHashMap<Activity, WeakReference<dof>> f10080a = new WeakHashMap();
    private Map<String, dod> f10081b = new fq();
    private int f10082c = 0;
    private Bundle f10083d;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.ushareit.listenit.dof m15155a(android.app.Activity r3) {
        /*
        r0 = f10080a;
        r0 = r0.get(r3);
        r0 = (java.lang.ref.WeakReference) r0;
        if (r0 == 0) goto L_0x0013;
    L_0x000a:
        r0 = r0.get();
        r0 = (com.ushareit.listenit.dof) r0;
        if (r0 == 0) goto L_0x0013;
    L_0x0012:
        return r0;
    L_0x0013:
        r0 = r3.getFragmentManager();	 Catch:{ ClassCastException -> 0x0048 }
        r1 = "LifecycleFragmentImpl";
        r0 = r0.findFragmentByTag(r1);	 Catch:{ ClassCastException -> 0x0048 }
        r0 = (com.ushareit.listenit.dof) r0;	 Catch:{ ClassCastException -> 0x0048 }
        if (r0 == 0) goto L_0x0027;
    L_0x0021:
        r1 = r0.isRemoving();
        if (r1 == 0) goto L_0x003d;
    L_0x0027:
        r0 = new com.ushareit.listenit.dof;
        r0.<init>();
        r1 = r3.getFragmentManager();
        r1 = r1.beginTransaction();
        r2 = "LifecycleFragmentImpl";
        r1 = r1.add(r0, r2);
        r1.commitAllowingStateLoss();
    L_0x003d:
        r1 = f10080a;
        r2 = new java.lang.ref.WeakReference;
        r2.<init>(r0);
        r1.put(r3, r2);
        goto L_0x0012;
    L_0x0048:
        r0 = move-exception;
        r1 = new java.lang.IllegalStateException;
        r2 = "Fragment with tag LifecycleFragmentImpl is not a LifecycleFragmentImpl";
        r1.<init>(r2, r0);
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ushareit.listenit.dof.a(android.app.Activity):com.ushareit.listenit.dof");
    }

    private void m15157b(String str, dod com_ushareit_listenit_dod) {
        if (this.f10082c > 0) {
            new Handler(Looper.getMainLooper()).post(new dog(this, com_ushareit_listenit_dod, str));
        }
    }

    public Activity mo2012a() {
        return getActivity();
    }

    public <T extends dod> T mo2013a(String str, Class<T> cls) {
        return (dod) cls.cast(this.f10081b.get(str));
    }

    public void mo2014a(String str, dod com_ushareit_listenit_dod) {
        if (this.f10081b.containsKey(str)) {
            throw new IllegalArgumentException(new StringBuilder(String.valueOf(str).length() + 59).append("LifecycleCallback with tag ").append(str).append(" already added to this fragment.").toString());
        }
        this.f10081b.put(str, com_ushareit_listenit_dod);
        m15157b(str, com_ushareit_listenit_dod);
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        for (dod a : this.f10081b.values()) {
            a.mo1952a(str, fileDescriptor, printWriter, strArr);
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        for (dod a : this.f10081b.values()) {
            a.mo1947a(i, i2, intent);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f10082c = 1;
        this.f10083d = bundle;
        for (Entry entry : this.f10081b.entrySet()) {
            ((dod) entry.getValue()).mo1948a(bundle != null ? bundle.getBundle((String) entry.getKey()) : null);
        }
    }

    public void onDestroy() {
        super.onStop();
        this.f10082c = 4;
        for (dod f : this.f10081b.values()) {
            f.m13528f();
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (bundle != null) {
            for (Entry entry : this.f10081b.entrySet()) {
                Bundle bundle2 = new Bundle();
                ((dod) entry.getValue()).mo1950b(bundle2);
                bundle.putBundle((String) entry.getKey(), bundle2);
            }
        }
    }

    public void onStart() {
        super.onStop();
        this.f10082c = 2;
        for (dod b : this.f10081b.values()) {
            b.mo1949b();
        }
    }

    public void onStop() {
        super.onStop();
        this.f10082c = 3;
        for (dod a : this.f10081b.values()) {
            a.mo1671a();
        }
    }
}
