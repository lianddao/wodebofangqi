package com.ushareit.listenit;

import com.google.android.exoplayer2.Format;
import java.io.EOFException;

public final class bhx implements bii {
    public void mo975a(Format format) {
    }

    public int mo973a(bhz com_ushareit_listenit_bhz, int i, boolean z) {
        int a = com_ushareit_listenit_bhz.mo960a(i);
        if (a != -1) {
            return a;
        }
        if (z) {
            return -1;
        }
        throw new EOFException();
    }

    public void mo976a(bss com_ushareit_listenit_bss, int i) {
        com_ushareit_listenit_bss.m9709d(i);
    }

    public void mo974a(long j, int i, int i2, int i3, byte[] bArr) {
    }
}
