package com.ushareit.listenit;

import android.os.Bundle;

class dvc implements Runnable {
    final /* synthetic */ String f10385a;
    final /* synthetic */ String f10386b;
    final /* synthetic */ long f10387c;
    final /* synthetic */ Bundle f10388d;
    final /* synthetic */ boolean f10389e;
    final /* synthetic */ boolean f10390f;
    final /* synthetic */ boolean f10391g;
    final /* synthetic */ String f10392h;
    final /* synthetic */ dva f10393i;

    dvc(dva com_ushareit_listenit_dva, String str, String str2, long j, Bundle bundle, boolean z, boolean z2, boolean z3, String str3) {
        this.f10393i = com_ushareit_listenit_dva;
        this.f10385a = str;
        this.f10386b = str2;
        this.f10387c = j;
        this.f10388d = bundle;
        this.f10389e = z;
        this.f10390f = z2;
        this.f10391g = z3;
        this.f10392h = str3;
    }

    public void run() {
        this.f10393i.m15746b(this.f10385a, this.f10386b, this.f10387c, this.f10388d, this.f10389e, this.f10390f, this.f10391g, this.f10392h);
    }
}
