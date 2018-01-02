package com.ushareit.listenit;

import java.util.Stack;

final class biq implements bit {
    private final byte[] f6439a = new byte[8];
    private final Stack<bis> f6440b = new Stack();
    private final bja f6441c = new bja();
    private biu f6442d;
    private int f6443e;
    private int f6444f;
    private long f6445g;

    biq() {
    }

    public void mo985a(biu com_ushareit_listenit_biu) {
        this.f6442d = com_ushareit_listenit_biu;
    }

    public void mo984a() {
        this.f6443e = 0;
        this.f6440b.clear();
        this.f6441c.m8665a();
    }

    public boolean mo986a(bhz com_ushareit_listenit_bhz) {
        bsg.m9658b(this.f6442d != null);
        while (true) {
            if (this.f6440b.isEmpty() || com_ushareit_listenit_bhz.mo968c() < ((bis) this.f6440b.peek()).f6447b) {
                if (this.f6443e == 0) {
                    long a = this.f6441c.m8664a(com_ushareit_listenit_bhz, true, false, 4);
                    if (a == -2) {
                        a = m8604b(com_ushareit_listenit_bhz);
                    }
                    if (a == -1) {
                        return false;
                    }
                    this.f6444f = (int) a;
                    this.f6443e = 1;
                }
                if (this.f6443e == 1) {
                    this.f6445g = this.f6441c.m8664a(com_ushareit_listenit_bhz, false, true, 8);
                    this.f6443e = 2;
                }
                int a2 = this.f6442d.mo987a(this.f6444f);
                switch (a2) {
                    case 0:
                        com_ushareit_listenit_bhz.mo965b((int) this.f6445g);
                        this.f6443e = 0;
                    case 1:
                        long c = com_ushareit_listenit_bhz.mo968c();
                        this.f6440b.add(new bis(this.f6444f, this.f6445g + c));
                        this.f6442d.mo991a(this.f6444f, c, this.f6445g);
                        this.f6443e = 0;
                        return true;
                    case 2:
                        if (this.f6445g > 8) {
                            throw new bfw("Invalid integer size: " + this.f6445g);
                        }
                        this.f6442d.mo990a(this.f6444f, m8602a(com_ushareit_listenit_bhz, (int) this.f6445g));
                        this.f6443e = 0;
                        return true;
                    case 3:
                        if (this.f6445g > 2147483647L) {
                            throw new bfw("String element size: " + this.f6445g);
                        }
                        this.f6442d.mo992a(this.f6444f, m8605c(com_ushareit_listenit_bhz, (int) this.f6445g));
                        this.f6443e = 0;
                        return true;
                    case 4:
                        this.f6442d.mo989a(this.f6444f, (int) this.f6445g, com_ushareit_listenit_bhz);
                        this.f6443e = 0;
                        return true;
                    case 5:
                        if (this.f6445g == 4 || this.f6445g == 8) {
                            this.f6442d.mo988a(this.f6444f, m8603b(com_ushareit_listenit_bhz, (int) this.f6445g));
                            this.f6443e = 0;
                            return true;
                        }
                        throw new bfw("Invalid float size: " + this.f6445g);
                    default:
                        throw new bfw("Invalid element type " + a2);
                }
            }
            this.f6442d.mo994c(((bis) this.f6440b.pop()).f6446a);
            return true;
        }
    }

    private long m8604b(bhz com_ushareit_listenit_bhz) {
        com_ushareit_listenit_bhz.mo962a();
        while (true) {
            com_ushareit_listenit_bhz.mo970c(this.f6439a, 0, 4);
            int a = bja.m8662a(this.f6439a[0]);
            if (a != -1 && a <= 4) {
                int a2 = (int) bja.m8663a(this.f6439a, a, false);
                if (this.f6442d.mo993b(a2)) {
                    com_ushareit_listenit_bhz.mo965b(a);
                    return (long) a2;
                }
            }
            com_ushareit_listenit_bhz.mo965b(1);
        }
    }

    private long m8602a(bhz com_ushareit_listenit_bhz, int i) {
        int i2 = 0;
        com_ushareit_listenit_bhz.mo966b(this.f6439a, 0, i);
        long j = 0;
        while (i2 < i) {
            j = (j << 8) | ((long) (this.f6439a[i2] & 255));
            i2++;
        }
        return j;
    }

    private double m8603b(bhz com_ushareit_listenit_bhz, int i) {
        long a = m8602a(com_ushareit_listenit_bhz, i);
        if (i == 4) {
            return (double) Float.intBitsToFloat((int) a);
        }
        return Double.longBitsToDouble(a);
    }

    private String m8605c(bhz com_ushareit_listenit_bhz, int i) {
        if (i == 0) {
            return "";
        }
        byte[] bArr = new byte[i];
        com_ushareit_listenit_bhz.mo966b(bArr, 0, i);
        return new String(bArr);
    }
}
