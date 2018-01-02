package com.ushareit.listenit;

import android.util.Log;

final class bmk extends bmm {
    private final blo f7074a;
    private final bih f7075b;
    private final bsr f7076c = new bsr(new byte[10]);
    private int f7077d = 0;
    private int f7078e;
    private boolean f7079f;
    private boolean f7080g;
    private boolean f7081h;
    private int f7082i;
    private int f7083j;
    private boolean f7084k;
    private long f7085l;

    public bmk(blo com_ushareit_listenit_blo, bih com_ushareit_listenit_bih) {
        super();
        this.f7074a = com_ushareit_listenit_blo;
        this.f7075b = com_ushareit_listenit_bih;
    }

    public void mo1013a() {
        this.f7077d = 0;
        this.f7078e = 0;
        this.f7081h = false;
        this.f7074a.mo1007a();
    }

    public void mo1014a(bss com_ushareit_listenit_bss, boolean z, bia com_ushareit_listenit_bia) {
        if (z) {
            switch (this.f7077d) {
                case 2:
                    Log.w("TsExtractor", "Unexpected start indicator reading extended header");
                    break;
                case 3:
                    if (this.f7083j != -1) {
                        Log.w("TsExtractor", "Unexpected start indicator: expected " + this.f7083j + " more bytes");
                    }
                    this.f7074a.mo1011b();
                    break;
            }
            m9054a(1);
        }
        while (com_ushareit_listenit_bss.m9704b() > 0) {
            switch (this.f7077d) {
                case 0:
                    com_ushareit_listenit_bss.m9709d(com_ushareit_listenit_bss.m9704b());
                    break;
                case 1:
                    if (!m9055a(com_ushareit_listenit_bss, this.f7076c.f7635a, 9)) {
                        break;
                    }
                    m9054a(m9056b() ? 2 : 0);
                    break;
                case 2:
                    if (m9055a(com_ushareit_listenit_bss, this.f7076c.f7635a, Math.min(10, this.f7082i)) && m9055a(com_ushareit_listenit_bss, null, this.f7082i)) {
                        m9057c();
                        this.f7074a.mo1008a(this.f7085l, this.f7084k);
                        m9054a(3);
                        break;
                    }
                case 3:
                    int i;
                    int b = com_ushareit_listenit_bss.m9704b();
                    if (this.f7083j == -1) {
                        i = 0;
                    } else {
                        i = b - this.f7083j;
                    }
                    if (i > 0) {
                        b -= i;
                        com_ushareit_listenit_bss.m9705b(com_ushareit_listenit_bss.m9708d() + b);
                    }
                    this.f7074a.mo1010a(com_ushareit_listenit_bss);
                    if (this.f7083j == -1) {
                        break;
                    }
                    this.f7083j -= b;
                    if (this.f7083j != 0) {
                        break;
                    }
                    this.f7074a.mo1011b();
                    m9054a(1);
                    break;
                default:
                    break;
            }
        }
    }

    private void m9054a(int i) {
        this.f7077d = i;
        this.f7078e = 0;
    }

    private boolean m9055a(bss com_ushareit_listenit_bss, byte[] bArr, int i) {
        int min = Math.min(com_ushareit_listenit_bss.m9704b(), i - this.f7078e);
        if (min <= 0) {
            return true;
        }
        if (bArr == null) {
            com_ushareit_listenit_bss.m9709d(min);
        } else {
            com_ushareit_listenit_bss.m9703a(bArr, this.f7078e, min);
        }
        this.f7078e = min + this.f7078e;
        if (this.f7078e != i) {
            return false;
        }
        return true;
    }

    private boolean m9056b() {
        this.f7076c.m9694a(0);
        int c = this.f7076c.m9697c(24);
        if (c != 1) {
            Log.w("TsExtractor", "Unexpected start code prefix: " + c);
            this.f7083j = -1;
            return false;
        }
        this.f7076c.m9695b(8);
        int c2 = this.f7076c.m9697c(16);
        this.f7076c.m9695b(5);
        this.f7084k = this.f7076c.m9696b();
        this.f7076c.m9695b(2);
        this.f7079f = this.f7076c.m9696b();
        this.f7080g = this.f7076c.m9696b();
        this.f7076c.m9695b(6);
        this.f7082i = this.f7076c.m9697c(8);
        if (c2 == 0) {
            this.f7083j = -1;
        } else {
            this.f7083j = ((c2 + 6) - 9) - this.f7082i;
        }
        return true;
    }

    private void m9057c() {
        this.f7076c.m9694a(0);
        this.f7085l = -9223372036854775807L;
        if (this.f7079f) {
            this.f7076c.m9695b(4);
            long c = ((long) this.f7076c.m9697c(3)) << 30;
            this.f7076c.m9695b(1);
            c |= (long) (this.f7076c.m9697c(15) << 15);
            this.f7076c.m9695b(1);
            c |= (long) this.f7076c.m9697c(15);
            this.f7076c.m9695b(1);
            if (!this.f7081h && this.f7080g) {
                this.f7076c.m9695b(4);
                long c2 = ((long) this.f7076c.m9697c(3)) << 30;
                this.f7076c.m9695b(1);
                c2 |= (long) (this.f7076c.m9697c(15) << 15);
                this.f7076c.m9695b(1);
                c2 |= (long) this.f7076c.m9697c(15);
                this.f7076c.m9695b(1);
                this.f7075b.m8563a(c2);
                this.f7081h = true;
            }
            this.f7085l = this.f7075b.m8563a(c);
        }
    }
}
