package com.ushareit.listenit;

public final class czl extends dgc<czl> {
    public czh f9417a;
    public czh f9418b;
    public czh f9419c;
    public czj f9420d;
    public czm[] f9421e;

    public czl() {
        m13503a();
    }

    public czl m13503a() {
        this.f9417a = null;
        this.f9418b = null;
        this.f9419c = null;
        this.f9420d = null;
        this.f9421e = czm.m13508a();
        this.f = null;
        this.g = -1;
        return this;
    }

    public czl m13504a(dfz com_ushareit_listenit_dfz) {
        while (true) {
            int a = com_ushareit_listenit_dfz.m14126a();
            switch (a) {
                case 0:
                    break;
                case 10:
                    if (this.f9417a == null) {
                        this.f9417a = new czh();
                    }
                    com_ushareit_listenit_dfz.m14128a(this.f9417a);
                    continue;
                case C0349R.styleable.DragSortListView_use_default_controller /*18*/:
                    if (this.f9418b == null) {
                        this.f9418b = new czh();
                    }
                    com_ushareit_listenit_dfz.m14128a(this.f9418b);
                    continue;
                case 26:
                    if (this.f9419c == null) {
                        this.f9419c = new czh();
                    }
                    com_ushareit_listenit_dfz.m14128a(this.f9419c);
                    continue;
                case 34:
                    if (this.f9420d == null) {
                        this.f9420d = new czj();
                    }
                    com_ushareit_listenit_dfz.m14128a(this.f9420d);
                    continue;
                case 42:
                    int b = dgl.m14265b(com_ushareit_listenit_dfz, 42);
                    a = this.f9421e == null ? 0 : this.f9421e.length;
                    Object obj = new czm[(b + a)];
                    if (a != 0) {
                        System.arraycopy(this.f9421e, 0, obj, 0, a);
                    }
                    while (a < obj.length - 1) {
                        obj[a] = new czm();
                        com_ushareit_listenit_dfz.m14128a(obj[a]);
                        com_ushareit_listenit_dfz.m14126a();
                        a++;
                    }
                    obj[a] = new czm();
                    com_ushareit_listenit_dfz.m14128a(obj[a]);
                    this.f9421e = obj;
                    continue;
                default:
                    if (!super.m13477a(com_ushareit_listenit_dfz, a)) {
                        break;
                    }
                    continue;
            }
            return this;
        }
    }

    public void mo1666a(dga com_ushareit_listenit_dga) {
        if (this.f9417a != null) {
            com_ushareit_listenit_dga.m14196a(1, this.f9417a);
        }
        if (this.f9418b != null) {
            com_ushareit_listenit_dga.m14196a(2, this.f9418b);
        }
        if (this.f9419c != null) {
            com_ushareit_listenit_dga.m14196a(3, this.f9419c);
        }
        if (this.f9420d != null) {
            com_ushareit_listenit_dga.m14196a(4, this.f9420d);
        }
        if (this.f9421e != null && this.f9421e.length > 0) {
            for (dgi com_ushareit_listenit_dgi : this.f9421e) {
                if (com_ushareit_listenit_dgi != null) {
                    com_ushareit_listenit_dga.m14196a(5, com_ushareit_listenit_dgi);
                }
            }
        }
        super.mo1666a(com_ushareit_listenit_dga);
    }

    protected int mo1667b() {
        int b = super.mo1667b();
        if (this.f9417a != null) {
            b += dga.m14175c(1, this.f9417a);
        }
        if (this.f9418b != null) {
            b += dga.m14175c(2, this.f9418b);
        }
        if (this.f9419c != null) {
            b += dga.m14175c(3, this.f9419c);
        }
        if (this.f9420d != null) {
            b += dga.m14175c(4, this.f9420d);
        }
        if (this.f9421e == null || this.f9421e.length <= 0) {
            return b;
        }
        int i = b;
        for (dgi com_ushareit_listenit_dgi : this.f9421e) {
            if (com_ushareit_listenit_dgi != null) {
                i += dga.m14175c(5, com_ushareit_listenit_dgi);
            }
        }
        return i;
    }

    public /* synthetic */ dgi mo1670b(dfz com_ushareit_listenit_dfz) {
        return m13504a(com_ushareit_listenit_dfz);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof czl)) {
            return false;
        }
        czl com_ushareit_listenit_czl = (czl) obj;
        if (this.f9417a == null) {
            if (com_ushareit_listenit_czl.f9417a != null) {
                return false;
            }
        } else if (!this.f9417a.equals(com_ushareit_listenit_czl.f9417a)) {
            return false;
        }
        if (this.f9418b == null) {
            if (com_ushareit_listenit_czl.f9418b != null) {
                return false;
            }
        } else if (!this.f9418b.equals(com_ushareit_listenit_czl.f9418b)) {
            return false;
        }
        if (this.f9419c == null) {
            if (com_ushareit_listenit_czl.f9419c != null) {
                return false;
            }
        } else if (!this.f9419c.equals(com_ushareit_listenit_czl.f9419c)) {
            return false;
        }
        if (this.f9420d == null) {
            if (com_ushareit_listenit_czl.f9420d != null) {
                return false;
            }
        } else if (!this.f9420d.equals(com_ushareit_listenit_czl.f9420d)) {
            return false;
        }
        return dgg.m14245a(this.f9421e, com_ushareit_listenit_czl.f9421e) ? (this.f == null || this.f.m14234b()) ? com_ushareit_listenit_czl.f == null || com_ushareit_listenit_czl.f.m14234b() : this.f.equals(com_ushareit_listenit_czl.f) : false;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((((this.f9420d == null ? 0 : this.f9420d.hashCode()) + (((this.f9419c == null ? 0 : this.f9419c.hashCode()) + (((this.f9418b == null ? 0 : this.f9418b.hashCode()) + (((this.f9417a == null ? 0 : this.f9417a.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31)) * 31)) * 31)) * 31) + dgg.m14242a(this.f9421e)) * 31;
        if (!(this.f == null || this.f.m14234b())) {
            i = this.f.hashCode();
        }
        return hashCode + i;
    }
}
