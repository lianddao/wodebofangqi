package com.ushareit.listenit;

import android.util.Log;
import android.util.Pair;
import java.util.UUID;

public final class bkc {
    public static UUID m8800a(byte[] bArr) {
        Pair b = m8801b(bArr);
        if (b == null) {
            return null;
        }
        return (UUID) b.first;
    }

    private static Pair<UUID, byte[]> m8801b(byte[] bArr) {
        bss com_ushareit_listenit_bss = new bss(bArr);
        if (com_ushareit_listenit_bss.m9706c() < 32) {
            return null;
        }
        com_ushareit_listenit_bss.m9707c(0);
        if (com_ushareit_listenit_bss.m9720n() != com_ushareit_listenit_bss.m9704b() + 4 || com_ushareit_listenit_bss.m9720n() != bji.f6582T) {
            return null;
        }
        int a = bji.m8700a(com_ushareit_listenit_bss.m9720n());
        if (a > 1) {
            Log.w("PsshAtomUtil", "Unsupported pssh version: " + a);
            return null;
        }
        UUID uuid = new UUID(com_ushareit_listenit_bss.m9722p(), com_ushareit_listenit_bss.m9722p());
        if (a == 1) {
            com_ushareit_listenit_bss.m9709d(com_ushareit_listenit_bss.m9726t() * 16);
        }
        a = com_ushareit_listenit_bss.m9726t();
        if (a != com_ushareit_listenit_bss.m9704b()) {
            return null;
        }
        Object obj = new byte[a];
        com_ushareit_listenit_bss.m9703a(obj, 0, a);
        return Pair.create(uuid, obj);
    }
}
