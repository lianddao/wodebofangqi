package com.ushareit.listenit;

import com.google.android.exoplayer2.Format;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

final class blu extends blo {
    private final boolean f6930a;
    private final boolean f6931b;
    private final bmc f6932c;
    private final bmc f6933d;
    private final bmc f6934e;
    private long f6935f;
    private final boolean[] f6936g = new boolean[3];
    private bii f6937h;
    private bmg f6938i;
    private blw f6939j;
    private boolean f6940k;
    private long f6941l;
    private final bss f6942m;

    public blu(boolean z, boolean z2) {
        this.f6930a = z;
        this.f6931b = z2;
        this.f6932c = new bmc(7, 128);
        this.f6933d = new bmc(8, 128);
        this.f6934e = new bmc(6, 128);
        this.f6942m = new bss();
    }

    public void mo1007a() {
        bso.m9687a(this.f6936g);
        this.f6932c.m9015a();
        this.f6933d.m9015a();
        this.f6934e.m9015a();
        this.f6939j.m8979b();
        this.f6935f = 0;
    }

    public void mo1009a(bia com_ushareit_listenit_bia, blr com_ushareit_listenit_blr) {
        this.f6937h = com_ushareit_listenit_bia.mo1025a(com_ushareit_listenit_blr.m8954a());
        this.f6939j = new blw(this.f6937h, this.f6930a, this.f6931b);
        this.f6938i = new bmg(com_ushareit_listenit_bia.mo1025a(com_ushareit_listenit_blr.m8954a()));
    }

    public void mo1008a(long j, boolean z) {
        this.f6941l = j;
    }

    public void mo1010a(bss com_ushareit_listenit_bss) {
        int d = com_ushareit_listenit_bss.m9708d();
        int c = com_ushareit_listenit_bss.m9706c();
        byte[] bArr = com_ushareit_listenit_bss.f7639a;
        this.f6935f += (long) com_ushareit_listenit_bss.m9704b();
        this.f6937h.mo976a(com_ushareit_listenit_bss, com_ushareit_listenit_bss.m9704b());
        while (true) {
            int a = bso.m9683a(bArr, d, c, this.f6936g);
            if (a == c) {
                m8966a(bArr, d, c);
                return;
            }
            int b = bso.m9688b(bArr, a);
            int i = a - d;
            if (i > 0) {
                m8966a(bArr, d, a);
            }
            int i2 = c - a;
            long j = this.f6935f - ((long) i2);
            m8964a(j, i2, i < 0 ? -i : 0, this.f6941l);
            m8965a(j, b, this.f6941l);
            d = a + 3;
        }
    }

    public void mo1011b() {
    }

    private void m8965a(long j, int i, long j2) {
        if (!this.f6940k || this.f6939j.m8978a()) {
            this.f6932c.m9016a(i);
            this.f6933d.m9016a(i);
        }
        this.f6934e.m9016a(i);
        this.f6939j.m8974a(j, i, j2);
    }

    private void m8966a(byte[] bArr, int i, int i2) {
        if (!this.f6940k || this.f6939j.m8978a()) {
            this.f6932c.m9017a(bArr, i, i2);
            this.f6933d.m9017a(bArr, i, i2);
        }
        this.f6934e.m9017a(bArr, i, i2);
        this.f6939j.m8977a(bArr, i, i2);
    }

    private void m8964a(long j, int i, int i2, long j2) {
        if (!this.f6940k || this.f6939j.m8978a()) {
            this.f6932c.m9019b(i2);
            this.f6933d.m9019b(i2);
            if (this.f6940k) {
                if (this.f6932c.m9018b()) {
                    this.f6939j.m8976a(bso.m9684a(this.f6932c.f7031a, 3, this.f6932c.f7032b));
                    this.f6932c.m9015a();
                } else if (this.f6933d.m9018b()) {
                    this.f6939j.m8975a(bso.m9689b(this.f6933d.f7031a, 3, this.f6933d.f7032b));
                    this.f6933d.m9015a();
                }
            } else if (this.f6932c.m9018b() && this.f6933d.m9018b()) {
                List arrayList = new ArrayList();
                arrayList.add(Arrays.copyOf(this.f6932c.f7031a, this.f6932c.f7032b));
                arrayList.add(Arrays.copyOf(this.f6933d.f7031a, this.f6933d.f7032b));
                bsq a = bso.m9684a(this.f6932c.f7031a, 3, this.f6932c.f7032b);
                bsp b = bso.m9689b(this.f6933d.f7031a, 3, this.f6933d.f7032b);
                this.f6937h.mo975a(Format.m2064a(null, "video/avc", null, -1, -1, a.f7626b, a.f7627c, -1.0f, arrayList, -1, a.f7628d, null));
                this.f6940k = true;
                this.f6939j.m8976a(a);
                this.f6939j.m8975a(b);
                this.f6932c.m9015a();
                this.f6933d.m9015a();
            }
        }
        if (this.f6934e.m9019b(i2)) {
            this.f6942m.m9702a(this.f6934e.f7031a, bso.m9682a(this.f6934e.f7031a, this.f6934e.f7032b));
            this.f6942m.m9707c(4);
            this.f6938i.m9030a(j2, this.f6942m);
        }
        this.f6939j.m8973a(j, i);
    }
}
