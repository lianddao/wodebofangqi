package com.ushareit.listenit;

import com.umeng.analytics.C0154a;
import com.umeng.analytics.pro.C0277j;

public final class dru extends dgi {
    private static volatile dru[] f10237H;
    public Boolean f10238A;
    public drq[] f10239B;
    public String f10240C;
    public Integer f10241D;
    public Integer f10242E;
    public Integer f10243F;
    public String f10244G;
    public Integer f10245a;
    public drr[] f10246b;
    public drw[] f10247c;
    public Long f10248d;
    public Long f10249e;
    public Long f10250f;
    public Long f10251h;
    public Long f10252i;
    public String f10253j;
    public String f10254k;
    public String f10255l;
    public String f10256m;
    public Integer f10257n;
    public String f10258o;
    public String f10259p;
    public String f10260q;
    public Long f10261r;
    public Long f10262s;
    public String f10263t;
    public Boolean f10264u;
    public String f10265v;
    public Long f10266w;
    public Integer f10267x;
    public String f10268y;
    public String f10269z;

    public dru() {
        m15390c();
    }

    public static dru[] m15385a() {
        if (f10237H == null) {
            synchronized (dgg.f9776c) {
                if (f10237H == null) {
                    f10237H = new dru[0];
                }
            }
        }
        return f10237H;
    }

    public dru m15386a(dfz com_ushareit_listenit_dfz) {
        while (true) {
            int a = com_ushareit_listenit_dfz.m14126a();
            int b;
            Object obj;
            switch (a) {
                case 0:
                    break;
                case 8:
                    this.f10245a = Integer.valueOf(com_ushareit_listenit_dfz.m14140g());
                    continue;
                case C0349R.styleable.DragSortListView_use_default_controller /*18*/:
                    b = dgl.m14265b(com_ushareit_listenit_dfz, 18);
                    a = this.f10246b == null ? 0 : this.f10246b.length;
                    obj = new drr[(b + a)];
                    if (a != 0) {
                        System.arraycopy(this.f10246b, 0, obj, 0, a);
                    }
                    while (a < obj.length - 1) {
                        obj[a] = new drr();
                        com_ushareit_listenit_dfz.m14128a(obj[a]);
                        com_ushareit_listenit_dfz.m14126a();
                        a++;
                    }
                    obj[a] = new drr();
                    com_ushareit_listenit_dfz.m14128a(obj[a]);
                    this.f10246b = obj;
                    continue;
                case 26:
                    b = dgl.m14265b(com_ushareit_listenit_dfz, 26);
                    a = this.f10247c == null ? 0 : this.f10247c.length;
                    obj = new drw[(b + a)];
                    if (a != 0) {
                        System.arraycopy(this.f10247c, 0, obj, 0, a);
                    }
                    while (a < obj.length - 1) {
                        obj[a] = new drw();
                        com_ushareit_listenit_dfz.m14128a(obj[a]);
                        com_ushareit_listenit_dfz.m14126a();
                        a++;
                    }
                    obj[a] = new drw();
                    com_ushareit_listenit_dfz.m14128a(obj[a]);
                    this.f10247c = obj;
                    continue;
                case C0154a.f2957m /*32*/:
                    this.f10248d = Long.valueOf(com_ushareit_listenit_dfz.m14138f());
                    continue;
                case 40:
                    this.f10249e = Long.valueOf(com_ushareit_listenit_dfz.m14138f());
                    continue;
                case C0277j.f3690a /*48*/:
                    this.f10250f = Long.valueOf(com_ushareit_listenit_dfz.m14138f());
                    continue;
                case 56:
                    this.f10252i = Long.valueOf(com_ushareit_listenit_dfz.m14138f());
                    continue;
                case 66:
                    this.f10253j = com_ushareit_listenit_dfz.m14143j();
                    continue;
                case 74:
                    this.f10254k = com_ushareit_listenit_dfz.m14143j();
                    continue;
                case 82:
                    this.f10255l = com_ushareit_listenit_dfz.m14143j();
                    continue;
                case 90:
                    this.f10256m = com_ushareit_listenit_dfz.m14143j();
                    continue;
                case 96:
                    this.f10257n = Integer.valueOf(com_ushareit_listenit_dfz.m14140g());
                    continue;
                case 106:
                    this.f10258o = com_ushareit_listenit_dfz.m14143j();
                    continue;
                case 114:
                    this.f10259p = com_ushareit_listenit_dfz.m14143j();
                    continue;
                case 130:
                    this.f10260q = com_ushareit_listenit_dfz.m14143j();
                    continue;
                case 136:
                    this.f10261r = Long.valueOf(com_ushareit_listenit_dfz.m14138f());
                    continue;
                case 144:
                    this.f10262s = Long.valueOf(com_ushareit_listenit_dfz.m14138f());
                    continue;
                case 154:
                    this.f10263t = com_ushareit_listenit_dfz.m14143j();
                    continue;
                case C0277j.f3691b /*160*/:
                    this.f10264u = Boolean.valueOf(com_ushareit_listenit_dfz.m14142i());
                    continue;
                case 170:
                    this.f10265v = com_ushareit_listenit_dfz.m14143j();
                    continue;
                case 176:
                    this.f10266w = Long.valueOf(com_ushareit_listenit_dfz.m14138f());
                    continue;
                case 184:
                    this.f10267x = Integer.valueOf(com_ushareit_listenit_dfz.m14140g());
                    continue;
                case 194:
                    this.f10268y = com_ushareit_listenit_dfz.m14143j();
                    continue;
                case 202:
                    this.f10269z = com_ushareit_listenit_dfz.m14143j();
                    continue;
                case 208:
                    this.f10251h = Long.valueOf(com_ushareit_listenit_dfz.m14138f());
                    continue;
                case 224:
                    this.f10238A = Boolean.valueOf(com_ushareit_listenit_dfz.m14142i());
                    continue;
                case 234:
                    b = dgl.m14265b(com_ushareit_listenit_dfz, 234);
                    a = this.f10239B == null ? 0 : this.f10239B.length;
                    obj = new drq[(b + a)];
                    if (a != 0) {
                        System.arraycopy(this.f10239B, 0, obj, 0, a);
                    }
                    while (a < obj.length - 1) {
                        obj[a] = new drq();
                        com_ushareit_listenit_dfz.m14128a(obj[a]);
                        com_ushareit_listenit_dfz.m14126a();
                        a++;
                    }
                    obj[a] = new drq();
                    com_ushareit_listenit_dfz.m14128a(obj[a]);
                    this.f10239B = obj;
                    continue;
                case 242:
                    this.f10240C = com_ushareit_listenit_dfz.m14143j();
                    continue;
                case 248:
                    this.f10241D = Integer.valueOf(com_ushareit_listenit_dfz.m14140g());
                    continue;
                case C0277j.f3694e /*256*/:
                    this.f10242E = Integer.valueOf(com_ushareit_listenit_dfz.m14140g());
                    continue;
                case 264:
                    this.f10243F = Integer.valueOf(com_ushareit_listenit_dfz.m14140g());
                    continue;
                case 274:
                    this.f10244G = com_ushareit_listenit_dfz.m14143j();
                    continue;
                default:
                    if (!dgl.m14263a(com_ushareit_listenit_dfz, a)) {
                        break;
                    }
                    continue;
            }
            return this;
        }
    }

    public void mo1666a(dga com_ushareit_listenit_dga) {
        int i = 0;
        if (this.f10245a != null) {
            com_ushareit_listenit_dga.m14194a(1, this.f10245a.intValue());
        }
        if (this.f10246b != null && this.f10246b.length > 0) {
            for (dgi com_ushareit_listenit_dgi : this.f10246b) {
                if (com_ushareit_listenit_dgi != null) {
                    com_ushareit_listenit_dga.m14196a(2, com_ushareit_listenit_dgi);
                }
            }
        }
        if (this.f10247c != null && this.f10247c.length > 0) {
            for (dgi com_ushareit_listenit_dgi2 : this.f10247c) {
                if (com_ushareit_listenit_dgi2 != null) {
                    com_ushareit_listenit_dga.m14196a(3, com_ushareit_listenit_dgi2);
                }
            }
        }
        if (this.f10248d != null) {
            com_ushareit_listenit_dga.m14205b(4, this.f10248d.longValue());
        }
        if (this.f10249e != null) {
            com_ushareit_listenit_dga.m14205b(5, this.f10249e.longValue());
        }
        if (this.f10250f != null) {
            com_ushareit_listenit_dga.m14205b(6, this.f10250f.longValue());
        }
        if (this.f10252i != null) {
            com_ushareit_listenit_dga.m14205b(7, this.f10252i.longValue());
        }
        if (this.f10253j != null) {
            com_ushareit_listenit_dga.m14197a(8, this.f10253j);
        }
        if (this.f10254k != null) {
            com_ushareit_listenit_dga.m14197a(9, this.f10254k);
        }
        if (this.f10255l != null) {
            com_ushareit_listenit_dga.m14197a(10, this.f10255l);
        }
        if (this.f10256m != null) {
            com_ushareit_listenit_dga.m14197a(11, this.f10256m);
        }
        if (this.f10257n != null) {
            com_ushareit_listenit_dga.m14194a(12, this.f10257n.intValue());
        }
        if (this.f10258o != null) {
            com_ushareit_listenit_dga.m14197a(13, this.f10258o);
        }
        if (this.f10259p != null) {
            com_ushareit_listenit_dga.m14197a(14, this.f10259p);
        }
        if (this.f10260q != null) {
            com_ushareit_listenit_dga.m14197a(16, this.f10260q);
        }
        if (this.f10261r != null) {
            com_ushareit_listenit_dga.m14205b(17, this.f10261r.longValue());
        }
        if (this.f10262s != null) {
            com_ushareit_listenit_dga.m14205b(18, this.f10262s.longValue());
        }
        if (this.f10263t != null) {
            com_ushareit_listenit_dga.m14197a(19, this.f10263t);
        }
        if (this.f10264u != null) {
            com_ushareit_listenit_dga.m14198a(20, this.f10264u.booleanValue());
        }
        if (this.f10265v != null) {
            com_ushareit_listenit_dga.m14197a(21, this.f10265v);
        }
        if (this.f10266w != null) {
            com_ushareit_listenit_dga.m14205b(22, this.f10266w.longValue());
        }
        if (this.f10267x != null) {
            com_ushareit_listenit_dga.m14194a(23, this.f10267x.intValue());
        }
        if (this.f10268y != null) {
            com_ushareit_listenit_dga.m14197a(24, this.f10268y);
        }
        if (this.f10269z != null) {
            com_ushareit_listenit_dga.m14197a(25, this.f10269z);
        }
        if (this.f10251h != null) {
            com_ushareit_listenit_dga.m14205b(26, this.f10251h.longValue());
        }
        if (this.f10238A != null) {
            com_ushareit_listenit_dga.m14198a(28, this.f10238A.booleanValue());
        }
        if (this.f10239B != null && this.f10239B.length > 0) {
            while (i < this.f10239B.length) {
                dgi com_ushareit_listenit_dgi3 = this.f10239B[i];
                if (com_ushareit_listenit_dgi3 != null) {
                    com_ushareit_listenit_dga.m14196a(29, com_ushareit_listenit_dgi3);
                }
                i++;
            }
        }
        if (this.f10240C != null) {
            com_ushareit_listenit_dga.m14197a(30, this.f10240C);
        }
        if (this.f10241D != null) {
            com_ushareit_listenit_dga.m14194a(31, this.f10241D.intValue());
        }
        if (this.f10242E != null) {
            com_ushareit_listenit_dga.m14194a(32, this.f10242E.intValue());
        }
        if (this.f10243F != null) {
            com_ushareit_listenit_dga.m14194a(33, this.f10243F.intValue());
        }
        if (this.f10244G != null) {
            com_ushareit_listenit_dga.m14197a(34, this.f10244G);
        }
        super.mo1666a(com_ushareit_listenit_dga);
    }

    protected int mo1667b() {
        int i;
        int i2 = 0;
        int b = super.mo1667b();
        if (this.f10245a != null) {
            b += dga.m14167b(1, this.f10245a.intValue());
        }
        if (this.f10246b != null && this.f10246b.length > 0) {
            i = b;
            for (dgi com_ushareit_listenit_dgi : this.f10246b) {
                if (com_ushareit_listenit_dgi != null) {
                    i += dga.m14175c(2, com_ushareit_listenit_dgi);
                }
            }
            b = i;
        }
        if (this.f10247c != null && this.f10247c.length > 0) {
            i = b;
            for (dgi com_ushareit_listenit_dgi2 : this.f10247c) {
                if (com_ushareit_listenit_dgi2 != null) {
                    i += dga.m14175c(3, com_ushareit_listenit_dgi2);
                }
            }
            b = i;
        }
        if (this.f10248d != null) {
            b += dga.m14179d(4, this.f10248d.longValue());
        }
        if (this.f10249e != null) {
            b += dga.m14179d(5, this.f10249e.longValue());
        }
        if (this.f10250f != null) {
            b += dga.m14179d(6, this.f10250f.longValue());
        }
        if (this.f10252i != null) {
            b += dga.m14179d(7, this.f10252i.longValue());
        }
        if (this.f10253j != null) {
            b += dga.m14169b(8, this.f10253j);
        }
        if (this.f10254k != null) {
            b += dga.m14169b(9, this.f10254k);
        }
        if (this.f10255l != null) {
            b += dga.m14169b(10, this.f10255l);
        }
        if (this.f10256m != null) {
            b += dga.m14169b(11, this.f10256m);
        }
        if (this.f10257n != null) {
            b += dga.m14167b(12, this.f10257n.intValue());
        }
        if (this.f10258o != null) {
            b += dga.m14169b(13, this.f10258o);
        }
        if (this.f10259p != null) {
            b += dga.m14169b(14, this.f10259p);
        }
        if (this.f10260q != null) {
            b += dga.m14169b(16, this.f10260q);
        }
        if (this.f10261r != null) {
            b += dga.m14179d(17, this.f10261r.longValue());
        }
        if (this.f10262s != null) {
            b += dga.m14179d(18, this.f10262s.longValue());
        }
        if (this.f10263t != null) {
            b += dga.m14169b(19, this.f10263t);
        }
        if (this.f10264u != null) {
            b += dga.m14170b(20, this.f10264u.booleanValue());
        }
        if (this.f10265v != null) {
            b += dga.m14169b(21, this.f10265v);
        }
        if (this.f10266w != null) {
            b += dga.m14179d(22, this.f10266w.longValue());
        }
        if (this.f10267x != null) {
            b += dga.m14167b(23, this.f10267x.intValue());
        }
        if (this.f10268y != null) {
            b += dga.m14169b(24, this.f10268y);
        }
        if (this.f10269z != null) {
            b += dga.m14169b(25, this.f10269z);
        }
        if (this.f10251h != null) {
            b += dga.m14179d(26, this.f10251h.longValue());
        }
        if (this.f10238A != null) {
            b += dga.m14170b(28, this.f10238A.booleanValue());
        }
        if (this.f10239B != null && this.f10239B.length > 0) {
            while (i2 < this.f10239B.length) {
                dgi com_ushareit_listenit_dgi3 = this.f10239B[i2];
                if (com_ushareit_listenit_dgi3 != null) {
                    b += dga.m14175c(29, com_ushareit_listenit_dgi3);
                }
                i2++;
            }
        }
        if (this.f10240C != null) {
            b += dga.m14169b(30, this.f10240C);
        }
        if (this.f10241D != null) {
            b += dga.m14167b(31, this.f10241D.intValue());
        }
        if (this.f10242E != null) {
            b += dga.m14167b(32, this.f10242E.intValue());
        }
        if (this.f10243F != null) {
            b += dga.m14167b(33, this.f10243F.intValue());
        }
        return this.f10244G != null ? b + dga.m14169b(34, this.f10244G) : b;
    }

    public /* synthetic */ dgi mo1670b(dfz com_ushareit_listenit_dfz) {
        return m15386a(com_ushareit_listenit_dfz);
    }

    public dru m15390c() {
        this.f10245a = null;
        this.f10246b = drr.m15368a();
        this.f10247c = drw.m15396a();
        this.f10248d = null;
        this.f10249e = null;
        this.f10250f = null;
        this.f10251h = null;
        this.f10252i = null;
        this.f10253j = null;
        this.f10254k = null;
        this.f10255l = null;
        this.f10256m = null;
        this.f10257n = null;
        this.f10258o = null;
        this.f10259p = null;
        this.f10260q = null;
        this.f10261r = null;
        this.f10262s = null;
        this.f10263t = null;
        this.f10264u = null;
        this.f10265v = null;
        this.f10266w = null;
        this.f10267x = null;
        this.f10268y = null;
        this.f10269z = null;
        this.f10238A = null;
        this.f10239B = drq.m15362a();
        this.f10240C = null;
        this.f10241D = null;
        this.f10242E = null;
        this.f10243F = null;
        this.f10244G = null;
        this.g = -1;
        return this;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof dru)) {
            return false;
        }
        dru com_ushareit_listenit_dru = (dru) obj;
        if (this.f10245a == null) {
            if (com_ushareit_listenit_dru.f10245a != null) {
                return false;
            }
        } else if (!this.f10245a.equals(com_ushareit_listenit_dru.f10245a)) {
            return false;
        }
        if (!dgg.m14245a(this.f10246b, com_ushareit_listenit_dru.f10246b)) {
            return false;
        }
        if (!dgg.m14245a(this.f10247c, com_ushareit_listenit_dru.f10247c)) {
            return false;
        }
        if (this.f10248d == null) {
            if (com_ushareit_listenit_dru.f10248d != null) {
                return false;
            }
        } else if (!this.f10248d.equals(com_ushareit_listenit_dru.f10248d)) {
            return false;
        }
        if (this.f10249e == null) {
            if (com_ushareit_listenit_dru.f10249e != null) {
                return false;
            }
        } else if (!this.f10249e.equals(com_ushareit_listenit_dru.f10249e)) {
            return false;
        }
        if (this.f10250f == null) {
            if (com_ushareit_listenit_dru.f10250f != null) {
                return false;
            }
        } else if (!this.f10250f.equals(com_ushareit_listenit_dru.f10250f)) {
            return false;
        }
        if (this.f10251h == null) {
            if (com_ushareit_listenit_dru.f10251h != null) {
                return false;
            }
        } else if (!this.f10251h.equals(com_ushareit_listenit_dru.f10251h)) {
            return false;
        }
        if (this.f10252i == null) {
            if (com_ushareit_listenit_dru.f10252i != null) {
                return false;
            }
        } else if (!this.f10252i.equals(com_ushareit_listenit_dru.f10252i)) {
            return false;
        }
        if (this.f10253j == null) {
            if (com_ushareit_listenit_dru.f10253j != null) {
                return false;
            }
        } else if (!this.f10253j.equals(com_ushareit_listenit_dru.f10253j)) {
            return false;
        }
        if (this.f10254k == null) {
            if (com_ushareit_listenit_dru.f10254k != null) {
                return false;
            }
        } else if (!this.f10254k.equals(com_ushareit_listenit_dru.f10254k)) {
            return false;
        }
        if (this.f10255l == null) {
            if (com_ushareit_listenit_dru.f10255l != null) {
                return false;
            }
        } else if (!this.f10255l.equals(com_ushareit_listenit_dru.f10255l)) {
            return false;
        }
        if (this.f10256m == null) {
            if (com_ushareit_listenit_dru.f10256m != null) {
                return false;
            }
        } else if (!this.f10256m.equals(com_ushareit_listenit_dru.f10256m)) {
            return false;
        }
        if (this.f10257n == null) {
            if (com_ushareit_listenit_dru.f10257n != null) {
                return false;
            }
        } else if (!this.f10257n.equals(com_ushareit_listenit_dru.f10257n)) {
            return false;
        }
        if (this.f10258o == null) {
            if (com_ushareit_listenit_dru.f10258o != null) {
                return false;
            }
        } else if (!this.f10258o.equals(com_ushareit_listenit_dru.f10258o)) {
            return false;
        }
        if (this.f10259p == null) {
            if (com_ushareit_listenit_dru.f10259p != null) {
                return false;
            }
        } else if (!this.f10259p.equals(com_ushareit_listenit_dru.f10259p)) {
            return false;
        }
        if (this.f10260q == null) {
            if (com_ushareit_listenit_dru.f10260q != null) {
                return false;
            }
        } else if (!this.f10260q.equals(com_ushareit_listenit_dru.f10260q)) {
            return false;
        }
        if (this.f10261r == null) {
            if (com_ushareit_listenit_dru.f10261r != null) {
                return false;
            }
        } else if (!this.f10261r.equals(com_ushareit_listenit_dru.f10261r)) {
            return false;
        }
        if (this.f10262s == null) {
            if (com_ushareit_listenit_dru.f10262s != null) {
                return false;
            }
        } else if (!this.f10262s.equals(com_ushareit_listenit_dru.f10262s)) {
            return false;
        }
        if (this.f10263t == null) {
            if (com_ushareit_listenit_dru.f10263t != null) {
                return false;
            }
        } else if (!this.f10263t.equals(com_ushareit_listenit_dru.f10263t)) {
            return false;
        }
        if (this.f10264u == null) {
            if (com_ushareit_listenit_dru.f10264u != null) {
                return false;
            }
        } else if (!this.f10264u.equals(com_ushareit_listenit_dru.f10264u)) {
            return false;
        }
        if (this.f10265v == null) {
            if (com_ushareit_listenit_dru.f10265v != null) {
                return false;
            }
        } else if (!this.f10265v.equals(com_ushareit_listenit_dru.f10265v)) {
            return false;
        }
        if (this.f10266w == null) {
            if (com_ushareit_listenit_dru.f10266w != null) {
                return false;
            }
        } else if (!this.f10266w.equals(com_ushareit_listenit_dru.f10266w)) {
            return false;
        }
        if (this.f10267x == null) {
            if (com_ushareit_listenit_dru.f10267x != null) {
                return false;
            }
        } else if (!this.f10267x.equals(com_ushareit_listenit_dru.f10267x)) {
            return false;
        }
        if (this.f10268y == null) {
            if (com_ushareit_listenit_dru.f10268y != null) {
                return false;
            }
        } else if (!this.f10268y.equals(com_ushareit_listenit_dru.f10268y)) {
            return false;
        }
        if (this.f10269z == null) {
            if (com_ushareit_listenit_dru.f10269z != null) {
                return false;
            }
        } else if (!this.f10269z.equals(com_ushareit_listenit_dru.f10269z)) {
            return false;
        }
        if (this.f10238A == null) {
            if (com_ushareit_listenit_dru.f10238A != null) {
                return false;
            }
        } else if (!this.f10238A.equals(com_ushareit_listenit_dru.f10238A)) {
            return false;
        }
        if (!dgg.m14245a(this.f10239B, com_ushareit_listenit_dru.f10239B)) {
            return false;
        }
        if (this.f10240C == null) {
            if (com_ushareit_listenit_dru.f10240C != null) {
                return false;
            }
        } else if (!this.f10240C.equals(com_ushareit_listenit_dru.f10240C)) {
            return false;
        }
        if (this.f10241D == null) {
            if (com_ushareit_listenit_dru.f10241D != null) {
                return false;
            }
        } else if (!this.f10241D.equals(com_ushareit_listenit_dru.f10241D)) {
            return false;
        }
        if (this.f10242E == null) {
            if (com_ushareit_listenit_dru.f10242E != null) {
                return false;
            }
        } else if (!this.f10242E.equals(com_ushareit_listenit_dru.f10242E)) {
            return false;
        }
        if (this.f10243F == null) {
            if (com_ushareit_listenit_dru.f10243F != null) {
                return false;
            }
        } else if (!this.f10243F.equals(com_ushareit_listenit_dru.f10243F)) {
            return false;
        }
        return this.f10244G == null ? com_ushareit_listenit_dru.f10244G == null : this.f10244G.equals(com_ushareit_listenit_dru.f10244G);
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((this.f10243F == null ? 0 : this.f10243F.hashCode()) + (((this.f10242E == null ? 0 : this.f10242E.hashCode()) + (((this.f10241D == null ? 0 : this.f10241D.hashCode()) + (((this.f10240C == null ? 0 : this.f10240C.hashCode()) + (((((this.f10238A == null ? 0 : this.f10238A.hashCode()) + (((this.f10269z == null ? 0 : this.f10269z.hashCode()) + (((this.f10268y == null ? 0 : this.f10268y.hashCode()) + (((this.f10267x == null ? 0 : this.f10267x.hashCode()) + (((this.f10266w == null ? 0 : this.f10266w.hashCode()) + (((this.f10265v == null ? 0 : this.f10265v.hashCode()) + (((this.f10264u == null ? 0 : this.f10264u.hashCode()) + (((this.f10263t == null ? 0 : this.f10263t.hashCode()) + (((this.f10262s == null ? 0 : this.f10262s.hashCode()) + (((this.f10261r == null ? 0 : this.f10261r.hashCode()) + (((this.f10260q == null ? 0 : this.f10260q.hashCode()) + (((this.f10259p == null ? 0 : this.f10259p.hashCode()) + (((this.f10258o == null ? 0 : this.f10258o.hashCode()) + (((this.f10257n == null ? 0 : this.f10257n.hashCode()) + (((this.f10256m == null ? 0 : this.f10256m.hashCode()) + (((this.f10255l == null ? 0 : this.f10255l.hashCode()) + (((this.f10254k == null ? 0 : this.f10254k.hashCode()) + (((this.f10253j == null ? 0 : this.f10253j.hashCode()) + (((this.f10252i == null ? 0 : this.f10252i.hashCode()) + (((this.f10251h == null ? 0 : this.f10251h.hashCode()) + (((this.f10250f == null ? 0 : this.f10250f.hashCode()) + (((this.f10249e == null ? 0 : this.f10249e.hashCode()) + (((this.f10248d == null ? 0 : this.f10248d.hashCode()) + (((((((this.f10245a == null ? 0 : this.f10245a.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31) + dgg.m14242a(this.f10246b)) * 31) + dgg.m14242a(this.f10247c)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31) + dgg.m14242a(this.f10239B)) * 31)) * 31)) * 31)) * 31)) * 31;
        if (this.f10244G != null) {
            i = this.f10244G.hashCode();
        }
        return hashCode + i;
    }
}
