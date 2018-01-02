package com.ushareit.listenit;

import android.content.Context;
import android.util.Log;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.config.internal.CustomVariable;
import com.google.android.gms.config.internal.FetchConfigIpcRequest;
import java.util.HashMap;
import java.util.Map.Entry;

class cjo extends cjr {
    final /* synthetic */ dqh f8375a;
    final /* synthetic */ cjn f8376b;

    cjo(cjn com_ushareit_listenit_cjn, cdz com_ushareit_listenit_cdz, dqh com_ushareit_listenit_dqh) {
        this.f8376b = com_ushareit_listenit_cjn;
        this.f8375a = com_ushareit_listenit_dqh;
        super(com_ushareit_listenit_cdz);
    }

    protected dqj m11456a(Status status) {
        return new cjt(status, new HashMap());
    }

    protected void mo1378a(Context context, ckc com_ushareit_listenit_ckc) {
        String b;
        String c;
        Throwable e;
        cev c2 = cey.m11007c();
        for (Entry entry : this.f8375a.m15270b().entrySet()) {
            cey.m11006a(c2, new CustomVariable((String) entry.getKey(), (String) entry.getValue()));
        }
        DataHolder a = c2.m11001a(0);
        String a2 = dnw.m15139a(context) == Status.f1686a ? dnw.m15141a() : null;
        try {
            b = een.m16846a().m16847b();
            try {
                c = een.m16846a().m16848c();
            } catch (IllegalStateException e2) {
                e = e2;
                if (Log.isLoggable("ConfigApiImpl", 3)) {
                    Log.d("ConfigApiImpl", "Cannot retrieve instanceId or instanceIdToken.", e);
                }
                c = null;
                com_ushareit_listenit_ckc.mo1386a(this.c, new FetchConfigIpcRequest(context.getPackageName(), this.f8375a.m15269a(), a, a2, b, c, null, this.f8375a.m15271c(), cjm.m11446b(context)));
                a.close();
            }
        } catch (IllegalStateException e3) {
            e = e3;
            b = null;
            if (Log.isLoggable("ConfigApiImpl", 3)) {
                Log.d("ConfigApiImpl", "Cannot retrieve instanceId or instanceIdToken.", e);
            }
            c = null;
            com_ushareit_listenit_ckc.mo1386a(this.c, new FetchConfigIpcRequest(context.getPackageName(), this.f8375a.m15269a(), a, a2, b, c, null, this.f8375a.m15271c(), cjm.m11446b(context)));
            a.close();
        }
        com_ushareit_listenit_ckc.mo1386a(this.c, new FetchConfigIpcRequest(context.getPackageName(), this.f8375a.m15269a(), a, a2, b, c, null, this.f8375a.m15271c(), cjm.m11446b(context)));
        a.close();
    }

    protected /* synthetic */ ceg mo1278b(Status status) {
        return m11456a(status);
    }
}
