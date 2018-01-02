package com.ushareit.listenit;

import com.facebook.AccessToken;
import java.util.Collection;
import java.util.Date;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

class ahs implements ajf {
    final /* synthetic */ AccessToken f4379a;
    final /* synthetic */ AtomicBoolean f4380b;
    final /* synthetic */ aht f4381c;
    final /* synthetic */ Set f4382d;
    final /* synthetic */ Set f4383e;
    final /* synthetic */ aho f4384f;

    ahs(aho com_ushareit_listenit_aho, AccessToken accessToken, AtomicBoolean atomicBoolean, aht com_ushareit_listenit_aht, Set set, Set set2) {
        this.f4384f = com_ushareit_listenit_aho;
        this.f4379a = accessToken;
        this.f4380b = atomicBoolean;
        this.f4381c = com_ushareit_listenit_aht;
        this.f4382d = set;
        this.f4383e = set2;
    }

    public void mo634a(aje com_ushareit_listenit_aje) {
        if (aho.m5655a().m5664b() != null && aho.m5655a().m5664b().m685i() == this.f4379a.m685i()) {
            try {
                if (this.f4380b.get() || this.f4381c.f4385a != null || this.f4381c.f4386b != 0) {
                    String str;
                    Collection collection;
                    Collection collection2;
                    Date date;
                    if (this.f4381c.f4385a != null) {
                        str = this.f4381c.f4385a;
                    } else {
                        str = this.f4379a.m678b();
                    }
                    String h = this.f4379a.m684h();
                    String i = this.f4379a.m685i();
                    if (this.f4380b.get()) {
                        collection = this.f4382d;
                    } else {
                        collection = this.f4379a.m680d();
                    }
                    if (this.f4380b.get()) {
                        collection2 = this.f4383e;
                    } else {
                        collection2 = this.f4379a.m681e();
                    }
                    ahu f = this.f4379a.m682f();
                    if (this.f4381c.f4386b != 0) {
                        date = new Date(((long) this.f4381c.f4386b) * 1000);
                    } else {
                        date = this.f4379a.m679c();
                    }
                    aho.m5655a().m5663a(new AccessToken(str, h, i, collection, collection2, f, date, new Date()));
                    this.f4384f.f4370e.set(false);
                }
            } finally {
                this.f4384f.f4370e.set(false);
            }
        }
    }
}
