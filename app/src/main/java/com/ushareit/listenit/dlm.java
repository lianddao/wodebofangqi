package com.ushareit.listenit;

import android.util.Log;
import android.util.SparseArray;
import java.util.Map;

public final class dlm extends dlk {
    public final dok<cdq> f9882e;
    public final dpb<cdq> f9883f;

    public dlm(int i, dol com_ushareit_listenit_dol, dzp<Void> com_ushareit_listenit_dzp_java_lang_Void, SparseArray<Map<doi<?>, dol>> sparseArray) {
        super(i, 3, com_ushareit_listenit_dzp_java_lang_Void, sparseArray);
        this.f9882e = com_ushareit_listenit_dol.f10092a;
        this.f9883f = com_ushareit_listenit_dol.f10093b;
    }

    public /* bridge */ /* synthetic */ boolean mo1945a() {
        return super.mo1945a();
    }

    public void mo1946b(cdq com_ushareit_listenit_cdq) {
        this.f9882e.m15165a(com_ushareit_listenit_cdq, this.d);
        Map map = (Map) this.c.get(this.a);
        if (map == null) {
            map = new fq(1);
            this.c.put(this.a, map);
        }
        String valueOf = String.valueOf(this.f9882e.m15164a());
        Log.d("reg", new StringBuilder(String.valueOf(valueOf).length() + 12).append("registered: ").append(valueOf).toString());
        if (this.f9882e.m15164a() != null) {
            map.put(this.f9882e.m15164a(), new dol(this.f9882e, this.f9883f));
        }
    }
}
