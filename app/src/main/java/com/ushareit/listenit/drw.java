package com.ushareit.listenit;

import com.mopub.mobileads.resource.DrawableConstants.RadialCountdown;
import com.umeng.analytics.C0154a;

public final class drw extends dgi {
    private static volatile drw[] f10272h;
    public Long f10273a;
    public String f10274b;
    public String f10275c;
    public Long f10276d;
    public Float f10277e;
    public Double f10278f;

    public drw() {
        m15401c();
    }

    public static drw[] m15396a() {
        if (f10272h == null) {
            synchronized (dgg.f9776c) {
                if (f10272h == null) {
                    f10272h = new drw[0];
                }
            }
        }
        return f10272h;
    }

    public drw m15397a(dfz com_ushareit_listenit_dfz) {
        while (true) {
            int a = com_ushareit_listenit_dfz.m14126a();
            switch (a) {
                case 0:
                    break;
                case 8:
                    this.f10273a = Long.valueOf(com_ushareit_listenit_dfz.m14138f());
                    continue;
                case C0349R.styleable.DragSortListView_use_default_controller /*18*/:
                    this.f10274b = com_ushareit_listenit_dfz.m14143j();
                    continue;
                case 26:
                    this.f10275c = com_ushareit_listenit_dfz.m14143j();
                    continue;
                case C0154a.f2957m /*32*/:
                    this.f10276d = Long.valueOf(com_ushareit_listenit_dfz.m14138f());
                    continue;
                case RadialCountdown.SIDE_LENGTH_DIPS /*45*/:
                    this.f10277e = Float.valueOf(com_ushareit_listenit_dfz.m14134d());
                    continue;
                case 49:
                    this.f10278f = Double.valueOf(com_ushareit_listenit_dfz.m14132c());
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
        if (this.f10273a != null) {
            com_ushareit_listenit_dga.m14205b(1, this.f10273a.longValue());
        }
        if (this.f10274b != null) {
            com_ushareit_listenit_dga.m14197a(2, this.f10274b);
        }
        if (this.f10275c != null) {
            com_ushareit_listenit_dga.m14197a(3, this.f10275c);
        }
        if (this.f10276d != null) {
            com_ushareit_listenit_dga.m14205b(4, this.f10276d.longValue());
        }
        if (this.f10277e != null) {
            com_ushareit_listenit_dga.m14193a(5, this.f10277e.floatValue());
        }
        if (this.f10278f != null) {
            com_ushareit_listenit_dga.m14192a(6, this.f10278f.doubleValue());
        }
        super.mo1666a(com_ushareit_listenit_dga);
    }

    protected int mo1667b() {
        int b = super.mo1667b();
        if (this.f10273a != null) {
            b += dga.m14179d(1, this.f10273a.longValue());
        }
        if (this.f10274b != null) {
            b += dga.m14169b(2, this.f10274b);
        }
        if (this.f10275c != null) {
            b += dga.m14169b(3, this.f10275c);
        }
        if (this.f10276d != null) {
            b += dga.m14179d(4, this.f10276d.longValue());
        }
        if (this.f10277e != null) {
            b += dga.m14166b(5, this.f10277e.floatValue());
        }
        return this.f10278f != null ? b + dga.m14165b(6, this.f10278f.doubleValue()) : b;
    }

    public /* synthetic */ dgi mo1670b(dfz com_ushareit_listenit_dfz) {
        return m15397a(com_ushareit_listenit_dfz);
    }

    public drw m15401c() {
        this.f10273a = null;
        this.f10274b = null;
        this.f10275c = null;
        this.f10276d = null;
        this.f10277e = null;
        this.f10278f = null;
        this.g = -1;
        return this;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof drw)) {
            return false;
        }
        drw com_ushareit_listenit_drw = (drw) obj;
        if (this.f10273a == null) {
            if (com_ushareit_listenit_drw.f10273a != null) {
                return false;
            }
        } else if (!this.f10273a.equals(com_ushareit_listenit_drw.f10273a)) {
            return false;
        }
        if (this.f10274b == null) {
            if (com_ushareit_listenit_drw.f10274b != null) {
                return false;
            }
        } else if (!this.f10274b.equals(com_ushareit_listenit_drw.f10274b)) {
            return false;
        }
        if (this.f10275c == null) {
            if (com_ushareit_listenit_drw.f10275c != null) {
                return false;
            }
        } else if (!this.f10275c.equals(com_ushareit_listenit_drw.f10275c)) {
            return false;
        }
        if (this.f10276d == null) {
            if (com_ushareit_listenit_drw.f10276d != null) {
                return false;
            }
        } else if (!this.f10276d.equals(com_ushareit_listenit_drw.f10276d)) {
            return false;
        }
        if (this.f10277e == null) {
            if (com_ushareit_listenit_drw.f10277e != null) {
                return false;
            }
        } else if (!this.f10277e.equals(com_ushareit_listenit_drw.f10277e)) {
            return false;
        }
        return this.f10278f == null ? com_ushareit_listenit_drw.f10278f == null : this.f10278f.equals(com_ushareit_listenit_drw.f10278f);
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((this.f10277e == null ? 0 : this.f10277e.hashCode()) + (((this.f10276d == null ? 0 : this.f10276d.hashCode()) + (((this.f10275c == null ? 0 : this.f10275c.hashCode()) + (((this.f10274b == null ? 0 : this.f10274b.hashCode()) + (((this.f10273a == null ? 0 : this.f10273a.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31)) * 31)) * 31)) * 31)) * 31;
        if (this.f10278f != null) {
            i = this.f10278f.hashCode();
        }
        return hashCode + i;
    }
}
