package com.ushareit.listenit;

import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import java.io.FileDescriptor;
import java.io.PrintWriter;

class dlr implements cec {
    public final int f9899a;
    public final cdz f9900b;
    public final cec f9901c;
    final /* synthetic */ dlq f9902d;

    public dlr(dlq com_ushareit_listenit_dlq, int i, cdz com_ushareit_listenit_cdz, cec com_ushareit_listenit_cec) {
        this.f9902d = com_ushareit_listenit_dlq;
        this.f9899a = i;
        this.f9900b = com_ushareit_listenit_cdz;
        this.f9901c = com_ushareit_listenit_cec;
        com_ushareit_listenit_cdz.mo1972a((cec) this);
    }

    public void m14810a() {
        this.f9900b.mo1975b((cec) this);
        this.f9900b.mo1978g();
    }

    public void mo1954a(ConnectionResult connectionResult) {
        String valueOf = String.valueOf(connectionResult);
        Log.d("AutoManageHelper", new StringBuilder(String.valueOf(valueOf).length() + 27).append("beginFailureResolution for ").append(valueOf).toString());
        this.f9902d.m14799b(connectionResult, this.f9899a);
    }

    public void m14812a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.append(str).append("GoogleApiClient #").print(this.f9899a);
        printWriter.println(":");
        this.f9900b.mo1973a(String.valueOf(str).concat("  "), fileDescriptor, printWriter, strArr);
    }
}
