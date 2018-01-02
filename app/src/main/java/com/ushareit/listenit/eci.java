package com.ushareit.listenit;

import java.util.Map;

class eci implements Runnable {
    final /* synthetic */ cpz f10827a;
    final /* synthetic */ cyp f10828b;
    final /* synthetic */ Map f10829c;
    final /* synthetic */ ecg f10830d;

    eci(ecg com_ushareit_listenit_ecg, cpz com_ushareit_listenit_cpz, cyp com_ushareit_listenit_cyp, Map map) {
        this.f10830d = com_ushareit_listenit_ecg;
        this.f10827a = com_ushareit_listenit_cpz;
        this.f10828b = com_ushareit_listenit_cyp;
        this.f10829c = map;
    }

    public void run() {
        this.f10830d.a.m12392a(this.f10830d.m16729c(), this.f10827a, (ecj) this.f10828b.m13381b(), this.f10829c);
    }
}
