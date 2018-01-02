package com.ushareit.listenit;

import java.io.EOFException;
import java.io.IOException;

final class bki implements bks {
    private final bkr f6757a = new bkr();
    private final long f6758b;
    private final long f6759c;
    private final bku f6760d;
    private int f6761e;
    private long f6762f;
    private volatile long f6763g;
    private long f6764h;
    private long f6765i;
    private long f6766j;
    private long f6767k;
    private long f6768l;
    private long f6769m;

    public /* synthetic */ bif mo1002d() {
        return m8827b();
    }

    public bki(long j, long j2, bku com_ushareit_listenit_bku) {
        boolean z = j >= 0 && j2 > j;
        bsg.m9656a(z);
        this.f6760d = com_ushareit_listenit_bku;
        this.f6758b = j;
        this.f6759c = j2;
        this.f6761e = 0;
    }

    public long mo1000a(bhz com_ushareit_listenit_bhz) {
        long j = 0;
        switch (this.f6761e) {
            case 0:
                this.f6764h = com_ushareit_listenit_bhz.mo968c();
                this.f6761e = 1;
                j = this.f6759c - 65307;
                if (j > this.f6764h) {
                    return j;
                }
                break;
            case 1:
                break;
            case 2:
                if (this.f6765i != 0) {
                    long a = m8823a(this.f6765i, com_ushareit_listenit_bhz);
                    if (a >= 0) {
                        return a;
                    }
                    bhz com_ushareit_listenit_bhz2 = com_ushareit_listenit_bhz;
                    j = m8825a(com_ushareit_listenit_bhz2, this.f6765i, -(a + 2));
                }
                this.f6761e = 3;
                return -(j + 2);
            case 3:
                return -1;
            default:
                throw new IllegalStateException();
        }
        this.f6762f = m8829c(com_ushareit_listenit_bhz);
        this.f6761e = 3;
        return this.f6764h;
    }

    public long a_() {
        boolean z = this.f6761e == 3 || this.f6761e == 2;
        bsg.m9656a(z);
        this.f6765i = this.f6763g;
        this.f6761e = 2;
        m8830c();
        return this.f6765i;
    }

    public bkk m8827b() {
        return this.f6762f != 0 ? new bkk() : null;
    }

    public void m8830c() {
        this.f6766j = this.f6758b;
        this.f6767k = this.f6759c;
        this.f6768l = 0;
        this.f6769m = this.f6762f;
    }

    public long m8823a(long j, bhz com_ushareit_listenit_bhz) {
        if (this.f6766j == this.f6767k) {
            return -(this.f6768l + 2);
        }
        long c = com_ushareit_listenit_bhz.mo968c();
        if (m8826a(com_ushareit_listenit_bhz, this.f6767k)) {
            this.f6757a.m8872a(com_ushareit_listenit_bhz, false);
            com_ushareit_listenit_bhz.mo962a();
            long j2 = j - this.f6757a.f6803c;
            int i = this.f6757a.f6808h + this.f6757a.f6809i;
            if (j2 < 0 || j2 > 72000) {
                if (j2 < 0) {
                    this.f6767k = c;
                    this.f6769m = this.f6757a.f6803c;
                } else {
                    this.f6766j = com_ushareit_listenit_bhz.mo968c() + ((long) i);
                    this.f6768l = this.f6757a.f6803c;
                    if ((this.f6767k - this.f6766j) + ((long) i) < 100000) {
                        com_ushareit_listenit_bhz.mo965b(i);
                        return -(this.f6768l + 2);
                    }
                }
                if (this.f6767k - this.f6766j < 100000) {
                    this.f6767k = this.f6766j;
                    return this.f6766j;
                }
                return Math.min(Math.max((com_ushareit_listenit_bhz.mo968c() - ((long) ((j2 <= 0 ? 2 : 1) * i))) + ((j2 * (this.f6767k - this.f6766j)) / (this.f6769m - this.f6768l)), this.f6766j), this.f6767k - 1);
            }
            com_ushareit_listenit_bhz.mo965b(i);
            return -(this.f6757a.f6803c + 2);
        } else if (this.f6766j != c) {
            return this.f6766j;
        } else {
            throw new IOException("No ogg page can be found.");
        }
    }

    private long m8816a(long j, long j2, long j3) {
        long j4 = ((((this.f6759c - this.f6758b) * j2) / this.f6762f) - j3) + j;
        if (j4 < this.f6758b) {
            j4 = this.f6758b;
        }
        if (j4 >= this.f6759c) {
            return this.f6759c - 1;
        }
        return j4;
    }

    void m8828b(bhz com_ushareit_listenit_bhz) {
        if (!m8826a(com_ushareit_listenit_bhz, this.f6759c)) {
            throw new EOFException();
        }
    }

    boolean m8826a(bhz com_ushareit_listenit_bhz, long j) {
        long min = Math.min(3 + j, this.f6759c);
        byte[] bArr = new byte[2048];
        int length = bArr.length;
        while (true) {
            if (com_ushareit_listenit_bhz.mo968c() + ((long) length) > min) {
                length = (int) (min - com_ushareit_listenit_bhz.mo968c());
                if (length < 4) {
                    return false;
                }
            }
            com_ushareit_listenit_bhz.mo967b(bArr, 0, length, false);
            int i = 0;
            while (i < length - 3) {
                if (bArr[i] == (byte) 79 && bArr[i + 1] == (byte) 103 && bArr[i + 2] == (byte) 103 && bArr[i + 3] == (byte) 83) {
                    com_ushareit_listenit_bhz.mo965b(i);
                    return true;
                }
                i++;
            }
            com_ushareit_listenit_bhz.mo965b(length - 3);
        }
    }

    long m8829c(bhz com_ushareit_listenit_bhz) {
        m8828b(com_ushareit_listenit_bhz);
        this.f6757a.m8871a();
        while ((this.f6757a.f6802b & 4) != 4 && com_ushareit_listenit_bhz.mo968c() < this.f6759c) {
            this.f6757a.m8872a(com_ushareit_listenit_bhz, false);
            com_ushareit_listenit_bhz.mo965b(this.f6757a.f6808h + this.f6757a.f6809i);
        }
        return this.f6757a.f6803c;
    }

    long m8825a(bhz com_ushareit_listenit_bhz, long j, long j2) {
        this.f6757a.m8872a(com_ushareit_listenit_bhz, false);
        while (this.f6757a.f6803c < j) {
            com_ushareit_listenit_bhz.mo965b(this.f6757a.f6808h + this.f6757a.f6809i);
            j2 = this.f6757a.f6803c;
            this.f6757a.m8872a(com_ushareit_listenit_bhz, false);
        }
        com_ushareit_listenit_bhz.mo962a();
        return j2;
    }
}
