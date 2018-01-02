package com.ushareit.listenit;

import android.util.Log;
import android.util.SparseArray;
import com.google.android.gms.common.ConnectionResult;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public class dlq extends dlw {
    private final SparseArray<dlr> f9898e = new SparseArray();

    private dlq(doe com_ushareit_listenit_doe) {
        super(com_ushareit_listenit_doe);
        this.d.mo2014a("AutoManageHelper", (dod) this);
    }

    public static dlq m14802a(doc com_ushareit_listenit_doc) {
        doe b = dod.m13520b(com_ushareit_listenit_doc);
        dlq com_ushareit_listenit_dlq = (dlq) b.mo2013a("AutoManageHelper", dlq.class);
        return com_ushareit_listenit_dlq != null ? com_ushareit_listenit_dlq : new dlq(b);
    }

    public void mo1671a() {
        super.mo1671a();
        for (int i = 0; i < this.f9898e.size(); i++) {
            ((dlr) this.f9898e.valueAt(i)).f9900b.mo1978g();
        }
    }

    public void m14804a(int i) {
        dlr com_ushareit_listenit_dlr = (dlr) this.f9898e.get(i);
        this.f9898e.remove(i);
        if (com_ushareit_listenit_dlr != null) {
            com_ushareit_listenit_dlr.m14810a();
        }
    }

    public void m14805a(int i, cdz com_ushareit_listenit_cdz, cec com_ushareit_listenit_cec) {
        cfi.m11081a((Object) com_ushareit_listenit_cdz, (Object) "GoogleApiClient instance cannot be null");
        cfi.m11086a(this.f9898e.indexOfKey(i) < 0, "Already managing a GoogleApiClient with id " + i);
        Log.d("AutoManageHelper", "starting AutoManage for client " + i + " " + this.a + " " + this.b);
        this.f9898e.put(i, new dlr(this, i, com_ushareit_listenit_cdz, com_ushareit_listenit_cec));
        if (this.a && !this.b) {
            String valueOf = String.valueOf(com_ushareit_listenit_cdz);
            Log.d("AutoManageHelper", new StringBuilder(String.valueOf(valueOf).length() + 11).append("connecting ").append(valueOf).toString());
            com_ushareit_listenit_cdz.mo1976e();
        }
    }

    protected void mo1951a(ConnectionResult connectionResult, int i) {
        Log.w("AutoManageHelper", "Unresolved error while connecting client. Stopping auto-manage.");
        if (i < 0) {
            Log.wtf("AutoManageHelper", "AutoManageLifecycleHelper received onErrorResolutionFailed callback but no failing client ID is set", new Exception());
            return;
        }
        dlr com_ushareit_listenit_dlr = (dlr) this.f9898e.get(i);
        if (com_ushareit_listenit_dlr != null) {
            m14804a(i);
            cec com_ushareit_listenit_cec = com_ushareit_listenit_dlr.f9901c;
            if (com_ushareit_listenit_cec != null) {
                com_ushareit_listenit_cec.mo1954a(connectionResult);
            }
        }
    }

    public void mo1952a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        for (int i = 0; i < this.f9898e.size(); i++) {
            ((dlr) this.f9898e.valueAt(i)).m14812a(str, fileDescriptor, printWriter, strArr);
        }
    }

    public void mo1949b() {
        super.mo1949b();
        boolean z = this.a;
        String valueOf = String.valueOf(this.f9898e);
        Log.d("AutoManageHelper", new StringBuilder(String.valueOf(valueOf).length() + 14).append("onStart ").append(z).append(" ").append(valueOf).toString());
        if (!this.b) {
            for (int i = 0; i < this.f9898e.size(); i++) {
                ((dlr) this.f9898e.valueAt(i)).f9900b.mo1976e();
            }
        }
    }

    protected void mo1953c() {
        for (int i = 0; i < this.f9898e.size(); i++) {
            ((dlr) this.f9898e.valueAt(i)).f9900b.mo1976e();
        }
    }
}
