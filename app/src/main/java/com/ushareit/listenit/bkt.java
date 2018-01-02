package com.ushareit.listenit;

import com.google.android.exoplayer2.Format;
import com.mopub.common.Constants;
import com.mopub.volley.DefaultRetryPolicy;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

final class bkt extends bku {
    private static final int f6812a = btc.m9777e("Opus");
    private static final byte[] f6813b = new byte[]{(byte) 79, (byte) 112, (byte) 117, (byte) 115, (byte) 72, (byte) 101, (byte) 97, (byte) 100};
    private boolean f6814c;

    bkt() {
    }

    public static boolean m8875a(bss com_ushareit_listenit_bss) {
        if (com_ushareit_listenit_bss.m9704b() < f6813b.length) {
            return false;
        }
        byte[] bArr = new byte[f6813b.length];
        com_ushareit_listenit_bss.m9703a(bArr, 0, f6813b.length);
        return Arrays.equals(bArr, f6813b);
    }

    protected void mo1003a(boolean z) {
        super.mo1003a(z);
        if (z) {
            this.f6814c = false;
        }
    }

    protected long mo1005b(bss com_ushareit_listenit_bss) {
        return m8844c(m8873a(com_ushareit_listenit_bss.f7639a));
    }

    protected boolean mo1004a(bss com_ushareit_listenit_bss, long j, bkw com_ushareit_listenit_bkw) {
        if (this.f6814c) {
            boolean z = com_ushareit_listenit_bss.m9720n() == f6812a;
            com_ushareit_listenit_bss.m9707c(0);
            return z;
        }
        Object copyOf = Arrays.copyOf(com_ushareit_listenit_bss.f7639a, com_ushareit_listenit_bss.m9706c());
        int i = copyOf[9] & 255;
        int i2 = ((copyOf[11] & 255) << 8) | (copyOf[10] & 255);
        List arrayList = new ArrayList(3);
        arrayList.add(copyOf);
        m8874a(arrayList, i2);
        m8874a(arrayList, 3840);
        com_ushareit_listenit_bkw.f6815a = Format.m2068a(null, "audio/opus", null, -1, -1, i, 48000, arrayList, null, 0, "und");
        this.f6814c = true;
        return true;
    }

    private void m8874a(List<byte[]> list, int i) {
        list.add(ByteBuffer.allocate(8).order(ByteOrder.nativeOrder()).putLong((((long) i) * 1000000000) / 48000).array());
    }

    private long m8873a(byte[] bArr) {
        int i;
        int i2 = bArr[0] & 255;
        switch (i2 & 3) {
            case 0:
                i = 1;
                break;
            case 1:
            case 2:
                i = 2;
                break;
            default:
                i = bArr[1] & 63;
                break;
        }
        int i3 = i2 >> 3;
        i2 = i3 & 3;
        if (i3 >= 16) {
            i3 = DefaultRetryPolicy.DEFAULT_TIMEOUT_MS << i2;
        } else if (i3 >= 12) {
            i3 = Constants.TEN_SECONDS_MILLIS << (i2 & 1);
        } else if (i2 == 3) {
            i3 = 60000;
        } else {
            i3 = Constants.TEN_SECONDS_MILLIS << i2;
        }
        return (long) (i3 * i);
    }
}
