package com.ushareit.listenit;

class dvd implements Runnable {
    final /* synthetic */ String f10394a;
    final /* synthetic */ String f10395b;
    final /* synthetic */ Object f10396c;
    final /* synthetic */ long f10397d;
    final /* synthetic */ dva f10398e;

    dvd(dva com_ushareit_listenit_dva, String str, String str2, Object obj, long j) {
        this.f10398e = com_ushareit_listenit_dva;
        this.f10394a = str;
        this.f10395b = str2;
        this.f10396c = obj;
        this.f10397d = j;
    }

    public void run() {
        this.f10398e.m15745a(this.f10394a, this.f10395b, this.f10396c, this.f10397d);
    }
}
