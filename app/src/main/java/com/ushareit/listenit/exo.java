package com.ushareit.listenit;

import android.content.Context;
import android.util.Pair;
import java.util.List;

public class exo {
    public static void m18424a() {
        ewt.m18317a(new exn());
    }

    public static synchronized void m18425a(Context context, int i, boolean z, boolean z2) {
        synchronized (exo.class) {
            euu com_ushareit_listenit_euu = (euu) euu.f11907a.m18565a("CommandProxy.tryExecuteCmds");
            if (gvk.m23048a()) {
                List a = euu.m18035a();
                Pair a2 = eyw.m18568a(context);
                if (a2 != null && ((Boolean) a2.second).booleanValue()) {
                    a.add("cmd_type_feed");
                }
                com_ushareit_listenit_euu.m18047a(context, i, z2, a);
            } else {
                com_ushareit_listenit_euu.m18046a(context, i, z2);
            }
            com_ushareit_listenit_euu.m18048a(context, z2);
        }
    }
}
