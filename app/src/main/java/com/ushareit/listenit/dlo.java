package com.ushareit.listenit;

import android.util.Log;
import android.util.SparseArray;
import com.google.android.gms.common.api.Status;
import java.util.Map;

public final class dlo extends dlk {
    public final dpb<cdq> f9887e;

    public dlo(int i, dpb<cdq> com_ushareit_listenit_dpb_com_ushareit_listenit_cdq, dzp<Void> com_ushareit_listenit_dzp_java_lang_Void, SparseArray<Map<doi<?>, dol>> sparseArray) {
        super(i, 4, com_ushareit_listenit_dzp_java_lang_Void, sparseArray);
        this.f9887e = com_ushareit_listenit_dpb_com_ushareit_listenit_cdq;
    }

    public /* bridge */ /* synthetic */ boolean mo1945a() {
        return super.mo1945a();
    }

    public void mo1946b(cdq com_ushareit_listenit_cdq) {
        Map map = (Map) this.c.get(this.a);
        if (map == null || this.f9887e.m15215a() == null) {
            Log.wtf("UnregisterListenerTask", "Received call to unregister a listener without a matching registration call.", new Exception());
            this.d.m16567a(new cel(Status.f1688c));
            return;
        }
        map.remove(this.f9887e.m15215a());
        this.f9887e.m15216a(com_ushareit_listenit_cdq, this.d);
    }
}
