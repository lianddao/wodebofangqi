package com.ushareit.listenit;

import android.util.Log;
import android.util.Pair;
import com.google.android.exoplayer2.Format;
import com.umeng.analytics.pro.C0277j;
import java.util.Arrays;
import java.util.Collections;

final class bll extends blo {
    private static final byte[] f6879a = new byte[]{(byte) 73, (byte) 68, (byte) 51};
    private final boolean f6880b;
    private final bsr f6881c;
    private final bss f6882d;
    private final String f6883e;
    private bii f6884f;
    private bii f6885g;
    private int f6886h;
    private int f6887i;
    private int f6888j;
    private boolean f6889k;
    private boolean f6890l;
    private long f6891m;
    private int f6892n;
    private long f6893o;
    private bii f6894p;
    private long f6895q;

    public bll(boolean z) {
        this(z, null);
    }

    public bll(boolean z, String str) {
        this.f6881c = new bsr(new byte[7]);
        this.f6882d = new bss(Arrays.copyOf(f6879a, 10));
        m8933c();
        this.f6880b = z;
        this.f6883e = str;
    }

    public void mo1007a() {
        m8933c();
    }

    public void mo1009a(bia com_ushareit_listenit_bia, blr com_ushareit_listenit_blr) {
        this.f6884f = com_ushareit_listenit_bia.mo1025a(com_ushareit_listenit_blr.m8954a());
        if (this.f6880b) {
            this.f6885g = com_ushareit_listenit_bia.mo1025a(com_ushareit_listenit_blr.m8954a());
            this.f6885g.mo975a(Format.m2071a(null, "application/id3", null, -1, null));
            return;
        }
        this.f6885g = new bhx();
    }

    public void mo1008a(long j, boolean z) {
        this.f6893o = j;
    }

    public void mo1010a(bss com_ushareit_listenit_bss) {
        while (com_ushareit_listenit_bss.m9704b() > 0) {
            switch (this.f6886h) {
                case 0:
                    m8932b(com_ushareit_listenit_bss);
                    break;
                case 1:
                    if (!m8931a(com_ushareit_listenit_bss, this.f6882d.f7639a, 10)) {
                        break;
                    }
                    m8937f();
                    break;
                case 2:
                    if (!m8931a(com_ushareit_listenit_bss, this.f6881c.f7635a, this.f6889k ? 7 : 5)) {
                        break;
                    }
                    m8938g();
                    break;
                case 3:
                    m8934c(com_ushareit_listenit_bss);
                    break;
                default:
                    break;
            }
        }
    }

    public void mo1011b() {
    }

    private boolean m8931a(bss com_ushareit_listenit_bss, byte[] bArr, int i) {
        int min = Math.min(com_ushareit_listenit_bss.m9704b(), i - this.f6887i);
        com_ushareit_listenit_bss.m9703a(bArr, this.f6887i, min);
        this.f6887i = min + this.f6887i;
        return this.f6887i == i;
    }

    private void m8933c() {
        this.f6886h = 0;
        this.f6887i = 0;
        this.f6888j = C0277j.f3694e;
    }

    private void m8935d() {
        this.f6886h = 1;
        this.f6887i = f6879a.length;
        this.f6892n = 0;
        this.f6882d.m9707c(0);
    }

    private void m8930a(bii com_ushareit_listenit_bii, long j, int i, int i2) {
        this.f6886h = 3;
        this.f6887i = i;
        this.f6894p = com_ushareit_listenit_bii;
        this.f6895q = j;
        this.f6892n = i2;
    }

    private void m8936e() {
        this.f6886h = 2;
        this.f6887i = 0;
    }

    private void m8932b(bss com_ushareit_listenit_bss) {
        byte[] bArr = com_ushareit_listenit_bss.f7639a;
        int d = com_ushareit_listenit_bss.m9708d();
        int c = com_ushareit_listenit_bss.m9706c();
        while (d < c) {
            int i = d + 1;
            d = bArr[d] & 255;
            if (this.f6888j != C0277j.f3696g || d < 240 || d == 255) {
                switch (d | this.f6888j) {
                    case 329:
                        this.f6888j = 768;
                        d = i;
                        break;
                    case 511:
                        this.f6888j = C0277j.f3696g;
                        d = i;
                        break;
                    case 836:
                        this.f6888j = 1024;
                        d = i;
                        break;
                    case 1075:
                        m8935d();
                        com_ushareit_listenit_bss.m9707c(i);
                        return;
                    default:
                        if (this.f6888j == C0277j.f3694e) {
                            d = i;
                            break;
                        }
                        this.f6888j = C0277j.f3694e;
                        d = i - 1;
                        break;
                }
            }
            this.f6889k = (d & 1) == 0;
            m8936e();
            com_ushareit_listenit_bss.m9707c(i);
            return;
        }
        com_ushareit_listenit_bss.m9707c(d);
    }

    private void m8937f() {
        this.f6885g.mo976a(this.f6882d, 10);
        this.f6882d.m9707c(6);
        m8930a(this.f6885g, 0, 10, this.f6882d.m9725s() + 10);
    }

    private void m8938g() {
        int i = 2;
        this.f6881c.m9694a(0);
        if (this.f6890l) {
            this.f6881c.m9695b(10);
        } else {
            int c = this.f6881c.m9697c(2) + 1;
            if (c != 2) {
                Log.w("AdtsReader", "Detected audio object type: " + c + ", but assuming AAC LC.");
            } else {
                i = c;
            }
            c = this.f6881c.m9697c(4);
            this.f6881c.m9695b(1);
            Object a = bsh.m9661a(i, c, this.f6881c.m9697c(3));
            Pair a2 = bsh.m9660a(a);
            Format a3 = Format.m2068a(null, "audio/mp4a-latm", null, -1, -1, ((Integer) a2.second).intValue(), ((Integer) a2.first).intValue(), Collections.singletonList(a), null, 0, this.f6883e);
            this.f6891m = 1024000000 / ((long) a3.f1443q);
            this.f6884f.mo975a(a3);
            this.f6890l = true;
        }
        this.f6881c.m9695b(4);
        int c2 = (this.f6881c.m9697c(13) - 2) - 5;
        if (this.f6889k) {
            c2 -= 2;
        }
        m8930a(this.f6884f, this.f6891m, 0, c2);
    }

    private void m8934c(bss com_ushareit_listenit_bss) {
        int min = Math.min(com_ushareit_listenit_bss.m9704b(), this.f6892n - this.f6887i);
        this.f6894p.mo976a(com_ushareit_listenit_bss, min);
        this.f6887i = min + this.f6887i;
        if (this.f6887i == this.f6892n) {
            this.f6894p.mo974a(this.f6893o, 1, this.f6892n, 0, null);
            this.f6893o += this.f6895q;
            m8933c();
        }
    }
}
