package com.ushareit.listenit;

import android.util.Log;

final class bmq {
    public static bmp m9082a(bhz com_ushareit_listenit_bhz) {
        bsg.m9654a((Object) com_ushareit_listenit_bhz);
        bss com_ushareit_listenit_bss = new bss(16);
        if (bmr.m9084a(com_ushareit_listenit_bhz, com_ushareit_listenit_bss).f7107a != btc.m9777e("RIFF")) {
            return null;
        }
        com_ushareit_listenit_bhz.mo970c(com_ushareit_listenit_bss.f7639a, 0, 4);
        com_ushareit_listenit_bss.m9707c(0);
        int n = com_ushareit_listenit_bss.m9720n();
        if (n != btc.m9777e("WAVE")) {
            Log.e("WavHeaderReader", "Unsupported RIFF format: " + n);
            return null;
        }
        bmr a = bmr.m9084a(com_ushareit_listenit_bhz, com_ushareit_listenit_bss);
        while (a.f7107a != btc.m9777e("fmt ")) {
            com_ushareit_listenit_bhz.mo969c((int) a.f7108b);
            a = bmr.m9084a(com_ushareit_listenit_bhz, com_ushareit_listenit_bss);
        }
        bsg.m9658b(a.f7108b >= 16);
        com_ushareit_listenit_bhz.mo970c(com_ushareit_listenit_bss.f7639a, 0, 16);
        com_ushareit_listenit_bss.m9707c(0);
        int i = com_ushareit_listenit_bss.m9715i();
        int i2 = com_ushareit_listenit_bss.m9715i();
        int u = com_ushareit_listenit_bss.m9727u();
        int u2 = com_ushareit_listenit_bss.m9727u();
        int i3 = com_ushareit_listenit_bss.m9715i();
        int i4 = com_ushareit_listenit_bss.m9715i();
        int i5 = (i2 * i4) / 8;
        if (i3 != i5) {
            throw new bfw("Expected block alignment: " + i5 + "; got: " + i3);
        }
        i5 = btc.m9759a(i4);
        if (i5 == 0) {
            Log.e("WavHeaderReader", "Unsupported WAV bit depth: " + i4);
            return null;
        } else if (i == 1 || i == 65534) {
            com_ushareit_listenit_bhz.mo969c(((int) a.f7108b) - 16);
            return new bmp(i2, u, u2, i3, i4, i5);
        } else {
            Log.e("WavHeaderReader", "Unsupported WAV format type: " + i);
            return null;
        }
    }

    public static void m9083a(bhz com_ushareit_listenit_bhz, bmp com_ushareit_listenit_bmp) {
        bsg.m9654a((Object) com_ushareit_listenit_bhz);
        bsg.m9654a((Object) com_ushareit_listenit_bmp);
        com_ushareit_listenit_bhz.mo962a();
        bss com_ushareit_listenit_bss = new bss(8);
        bmr a = bmr.m9084a(com_ushareit_listenit_bhz, com_ushareit_listenit_bss);
        while (a.f7107a != btc.m9777e("data")) {
            Log.w("WavHeaderReader", "Ignoring unknown WAV chunk: " + a.f7107a);
            long j = 8 + a.f7108b;
            if (a.f7107a == btc.m9777e("RIFF")) {
                j = 12;
            }
            if (j > 2147483647L) {
                throw new bfw("Chunk is too large (~2GB+) to skip; id: " + a.f7107a);
            }
            com_ushareit_listenit_bhz.mo965b((int) j);
            a = bmr.m9084a(com_ushareit_listenit_bhz, com_ushareit_listenit_bss);
        }
        com_ushareit_listenit_bhz.mo965b(8);
        com_ushareit_listenit_bmp.m9074a(com_ushareit_listenit_bhz.mo968c(), a.f7108b);
    }
}
