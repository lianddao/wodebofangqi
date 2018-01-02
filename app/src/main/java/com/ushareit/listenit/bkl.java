package com.ushareit.listenit;

import com.google.android.exoplayer2.Format;
import com.umeng.analytics.pro.C0277j;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

final class bkl extends bku {
    private bsk f6784a;
    private bkn f6785b;

    bkl() {
    }

    public static boolean m8847a(bss com_ushareit_listenit_bss) {
        return com_ushareit_listenit_bss.m9704b() >= 5 && com_ushareit_listenit_bss.m9713g() == 127 && com_ushareit_listenit_bss.m9718l() == 1179402563;
    }

    protected void mo1003a(boolean z) {
        super.mo1003a(z);
        if (z) {
            this.f6784a = null;
            this.f6785b = null;
        }
    }

    private static boolean m8848a(byte[] bArr) {
        return bArr[0] == (byte) -1;
    }

    protected long mo1005b(bss com_ushareit_listenit_bss) {
        if (m8848a(com_ushareit_listenit_bss.f7639a)) {
            return (long) m8849c(com_ushareit_listenit_bss);
        }
        return -1;
    }

    protected boolean mo1004a(bss com_ushareit_listenit_bss, long j, bkw com_ushareit_listenit_bkw) {
        byte[] bArr = com_ushareit_listenit_bss.f7639a;
        if (this.f6784a == null) {
            this.f6784a = new bsk(bArr, 17);
            Object copyOfRange = Arrays.copyOfRange(bArr, 9, com_ushareit_listenit_bss.m9706c());
            copyOfRange[4] = Byte.MIN_VALUE;
            List singletonList = Collections.singletonList(copyOfRange);
            com_ushareit_listenit_bkw.f6815a = Format.m2068a(null, "audio/x-flac", null, -1, this.f6784a.m9671a(), this.f6784a.f7613f, this.f6784a.f7612e, singletonList, null, 0, null);
        } else if ((bArr[0] & 127) == 3) {
            this.f6785b = new bkn();
            this.f6785b.m8855a(com_ushareit_listenit_bss);
        } else if (m8848a(bArr)) {
            if (this.f6785b == null) {
                return false;
            }
            this.f6785b.m8854a(j);
            com_ushareit_listenit_bkw.f6816b = this.f6785b;
            return false;
        }
        return true;
    }

    private int m8849c(bss com_ushareit_listenit_bss) {
        int i = (com_ushareit_listenit_bss.f7639a[2] & 255) >> 4;
        switch (i) {
            case 1:
                return 192;
            case 2:
            case 3:
            case 4:
            case 5:
                return 576 << (i - 2);
            case 6:
            case 7:
                com_ushareit_listenit_bss.m9709d(4);
                com_ushareit_listenit_bss.m9731y();
                i = i == 6 ? com_ushareit_listenit_bss.m9713g() : com_ushareit_listenit_bss.m9714h();
                com_ushareit_listenit_bss.m9707c(0);
                return i + 1;
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case C0349R.styleable.DragSortListView_drag_handle_id /*15*/:
                return C0277j.f3694e << (i - 8);
            default:
                return -1;
        }
    }
}
