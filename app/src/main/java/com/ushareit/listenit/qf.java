package com.ushareit.listenit;

import java.util.ArrayList;
import java.util.List;

public class qf implements rn {
    final ArrayList<qh> f16321a;
    final ArrayList<qh> f16322b;
    final qg f16323c;
    Runnable f16324d;
    final boolean f16325e;
    final rm f16326f;
    private ge<qh> f16327g;
    private int f16328h;

    public qf(qg qgVar) {
        this(qgVar, false);
    }

    qf(qg qgVar, boolean z) {
        this.f16327g = new gf(30);
        this.f16321a = new ArrayList();
        this.f16322b = new ArrayList();
        this.f16328h = 0;
        this.f16323c = qgVar;
        this.f16325e = z;
        this.f16326f = new rm(this);
    }

    public void m25719a() {
        m25722a(this.f16321a);
        m25722a(this.f16322b);
        this.f16328h = 0;
    }

    public void m25727b() {
        this.f16326f.m25960a(this.f16321a);
        int size = this.f16321a.size();
        for (int i = 0; i < size; i++) {
            qh qhVar = (qh) this.f16321a.get(i);
            switch (qhVar.f16329a) {
                case 1:
                    m25715f(qhVar);
                    break;
                case 2:
                    m25710c(qhVar);
                    break;
                case 4:
                    m25712d(qhVar);
                    break;
                case 8:
                    m25709b(qhVar);
                    break;
            }
            if (this.f16324d != null) {
                this.f16324d.run();
            }
        }
        this.f16321a.clear();
    }

    public void m25730c() {
        int size = this.f16322b.size();
        for (int i = 0; i < size; i++) {
            this.f16323c.mo3059b((qh) this.f16322b.get(i));
        }
        m25722a(this.f16322b);
        this.f16328h = 0;
    }

    private void m25709b(qh qhVar) {
        m25716g(qhVar);
    }

    private void m25710c(qh qhVar) {
        int i = qhVar.f16330b;
        int i2 = qhVar.f16330b + qhVar.f16332d;
        Object obj = -1;
        int i3 = qhVar.f16330b;
        int i4 = 0;
        while (i3 < i2) {
            Object obj2;
            int i5;
            if (this.f16323c.mo3054a(i3) != null || m25713d(i3)) {
                if (obj == null) {
                    m25714e(mo3000a(2, i, i4, null));
                    obj2 = 1;
                } else {
                    obj2 = null;
                }
                obj = 1;
            } else {
                if (obj == 1) {
                    m25716g(mo3000a(2, i, i4, null));
                    obj2 = 1;
                } else {
                    obj2 = null;
                }
                obj = null;
            }
            if (obj2 != null) {
                i5 = i3 - i4;
                i3 = i2 - i4;
                i2 = 1;
            } else {
                int i6 = i3;
                i3 = i2;
                i2 = i4 + 1;
                i5 = i6;
            }
            i4 = i2;
            i2 = i3;
            i3 = i5 + 1;
        }
        if (i4 != qhVar.f16332d) {
            mo3001a(qhVar);
            qhVar = mo3000a(2, i, i4, null);
        }
        if (obj == null) {
            m25714e(qhVar);
        } else {
            m25716g(qhVar);
        }
    }

    private void m25712d(qh qhVar) {
        int i = qhVar.f16330b;
        int i2 = qhVar.f16330b + qhVar.f16332d;
        int i3 = qhVar.f16330b;
        Object obj = -1;
        int i4 = 0;
        while (i3 < i2) {
            int i5;
            Object obj2;
            if (this.f16323c.mo3054a(i3) != null || m25713d(i3)) {
                if (obj == null) {
                    m25714e(mo3000a(4, i, i4, qhVar.f16331c));
                    i4 = 0;
                    i = i3;
                }
                i5 = i;
                i = i4;
                obj2 = 1;
            } else {
                if (obj == 1) {
                    m25716g(mo3000a(4, i, i4, qhVar.f16331c));
                    i4 = 0;
                    i = i3;
                }
                i5 = i;
                i = i4;
                obj2 = null;
            }
            i3++;
            Object obj3 = obj2;
            i4 = i + 1;
            i = i5;
            obj = obj3;
        }
        if (i4 != qhVar.f16332d) {
            Object obj4 = qhVar.f16331c;
            mo3001a(qhVar);
            qhVar = mo3000a(4, i, i4, obj4);
        }
        if (obj == null) {
            m25714e(qhVar);
        } else {
            m25716g(qhVar);
        }
    }

    private void m25714e(qh qhVar) {
        if (qhVar.f16329a == 1 || qhVar.f16329a == 8) {
            throw new IllegalArgumentException("should not dispatch add or move for pre layout");
        }
        int i;
        int d = m25711d(qhVar.f16330b, qhVar.f16329a);
        int i2 = qhVar.f16330b;
        switch (qhVar.f16329a) {
            case 2:
                i = 0;
                break;
            case 4:
                i = 1;
                break;
            default:
                throw new IllegalArgumentException("op should be remove or update." + qhVar);
        }
        int i3 = 1;
        int i4 = d;
        d = i2;
        for (i2 = 1; i2 < qhVar.f16332d; i2++) {
            Object obj;
            int d2 = m25711d(qhVar.f16330b + (i * i2), qhVar.f16329a);
            int i5;
            switch (qhVar.f16329a) {
                case 2:
                    if (d2 != i4) {
                        obj = null;
                        break;
                    } else {
                        i5 = 1;
                        break;
                    }
                case 4:
                    if (d2 != i4 + 1) {
                        obj = null;
                        break;
                    } else {
                        i5 = 1;
                        break;
                    }
                default:
                    obj = null;
                    break;
            }
            if (obj != null) {
                i3++;
            } else {
                qh a = mo3000a(qhVar.f16329a, i4, i3, qhVar.f16331c);
                m25721a(a, d);
                mo3001a(a);
                if (qhVar.f16329a == 4) {
                    d += i3;
                }
                i3 = 1;
                i4 = d2;
            }
        }
        Object obj2 = qhVar.f16331c;
        mo3001a(qhVar);
        if (i3 > 0) {
            qh a2 = mo3000a(qhVar.f16329a, i4, i3, obj2);
            m25721a(a2, d);
            mo3001a(a2);
        }
    }

    void m25721a(qh qhVar, int i) {
        this.f16323c.mo3057a(qhVar);
        switch (qhVar.f16329a) {
            case 2:
                this.f16323c.mo3055a(i, qhVar.f16332d);
                return;
            case 4:
                this.f16323c.mo3056a(i, qhVar.f16332d, qhVar.f16331c);
                return;
            default:
                throw new IllegalArgumentException("only remove and update ops can be dispatched in first pass");
        }
    }

    private int m25711d(int i, int i2) {
        int i3;
        int i4 = i;
        for (int size = this.f16322b.size() - 1; size >= 0; size--) {
            qh qhVar = (qh) this.f16322b.get(size);
            if (qhVar.f16329a == 8) {
                int i5;
                int i6;
                if (qhVar.f16330b < qhVar.f16332d) {
                    i5 = qhVar.f16330b;
                    i3 = qhVar.f16332d;
                } else {
                    i5 = qhVar.f16332d;
                    i3 = qhVar.f16330b;
                }
                if (i4 < i5 || i4 > r2) {
                    if (i4 < qhVar.f16330b) {
                        if (i2 == 1) {
                            qhVar.f16330b++;
                            qhVar.f16332d++;
                            i6 = i4;
                        } else if (i2 == 2) {
                            qhVar.f16330b--;
                            qhVar.f16332d--;
                        }
                    }
                    i6 = i4;
                } else if (i5 == qhVar.f16330b) {
                    if (i2 == 1) {
                        qhVar.f16332d++;
                    } else if (i2 == 2) {
                        qhVar.f16332d--;
                    }
                    i6 = i4 + 1;
                } else {
                    if (i2 == 1) {
                        qhVar.f16330b++;
                    } else if (i2 == 2) {
                        qhVar.f16330b--;
                    }
                    i6 = i4 - 1;
                }
                i4 = i6;
            } else if (qhVar.f16330b <= i4) {
                if (qhVar.f16329a == 1) {
                    i4 -= qhVar.f16332d;
                } else if (qhVar.f16329a == 2) {
                    i4 += qhVar.f16332d;
                }
            } else if (i2 == 1) {
                qhVar.f16330b++;
            } else if (i2 == 2) {
                qhVar.f16330b--;
            }
        }
        for (i3 = this.f16322b.size() - 1; i3 >= 0; i3--) {
            qhVar = (qh) this.f16322b.get(i3);
            if (qhVar.f16329a == 8) {
                if (qhVar.f16332d == qhVar.f16330b || qhVar.f16332d < 0) {
                    this.f16322b.remove(i3);
                    mo3001a(qhVar);
                }
            } else if (qhVar.f16332d <= 0) {
                this.f16322b.remove(i3);
                mo3001a(qhVar);
            }
        }
        return i4;
    }

    private boolean m25713d(int i) {
        int size = this.f16322b.size();
        for (int i2 = 0; i2 < size; i2++) {
            qh qhVar = (qh) this.f16322b.get(i2);
            if (qhVar.f16329a == 8) {
                if (m25717a(qhVar.f16332d, i2 + 1) == i) {
                    return true;
                }
            } else if (qhVar.f16329a == 1) {
                int i3 = qhVar.f16330b + qhVar.f16332d;
                for (int i4 = qhVar.f16330b; i4 < i3; i4++) {
                    if (m25717a(i4, i2 + 1) == i) {
                        return true;
                    }
                }
                continue;
            } else {
                continue;
            }
        }
        return false;
    }

    private void m25715f(qh qhVar) {
        m25716g(qhVar);
    }

    private void m25716g(qh qhVar) {
        this.f16322b.add(qhVar);
        switch (qhVar.f16329a) {
            case 1:
                this.f16323c.mo3060c(qhVar.f16330b, qhVar.f16332d);
                return;
            case 2:
                this.f16323c.mo3058b(qhVar.f16330b, qhVar.f16332d);
                return;
            case 4:
                this.f16323c.mo3056a(qhVar.f16330b, qhVar.f16332d, qhVar.f16331c);
                return;
            case 8:
                this.f16323c.mo3061d(qhVar.f16330b, qhVar.f16332d);
                return;
            default:
                throw new IllegalArgumentException("Unknown update op type for " + qhVar);
        }
    }

    public boolean m25732d() {
        return this.f16321a.size() > 0;
    }

    public boolean m25723a(int i) {
        return (this.f16328h & i) != 0;
    }

    int m25726b(int i) {
        return m25717a(i, 0);
    }

    int m25717a(int i, int i2) {
        int size = this.f16322b.size();
        int i3 = i;
        while (i2 < size) {
            qh qhVar = (qh) this.f16322b.get(i2);
            if (qhVar.f16329a == 8) {
                if (qhVar.f16330b == i3) {
                    i3 = qhVar.f16332d;
                } else {
                    if (qhVar.f16330b < i3) {
                        i3--;
                    }
                    if (qhVar.f16332d <= i3) {
                        i3++;
                    }
                }
            } else if (qhVar.f16330b > i3) {
                continue;
            } else if (qhVar.f16329a == 2) {
                if (i3 < qhVar.f16330b + qhVar.f16332d) {
                    return -1;
                }
                i3 -= qhVar.f16332d;
            } else if (qhVar.f16329a == 1) {
                i3 += qhVar.f16332d;
            }
            i2++;
        }
        return i3;
    }

    boolean m25725a(int i, int i2, Object obj) {
        this.f16321a.add(mo3000a(4, i, i2, obj));
        this.f16328h |= 4;
        if (this.f16321a.size() == 1) {
            return true;
        }
        return false;
    }

    boolean m25728b(int i, int i2) {
        this.f16321a.add(mo3000a(1, i, i2, null));
        this.f16328h |= 1;
        if (this.f16321a.size() == 1) {
            return true;
        }
        return false;
    }

    boolean m25731c(int i, int i2) {
        this.f16321a.add(mo3000a(2, i, i2, null));
        this.f16328h |= 2;
        if (this.f16321a.size() == 1) {
            return true;
        }
        return false;
    }

    boolean m25724a(int i, int i2, int i3) {
        boolean z = true;
        if (i == i2) {
            return false;
        }
        if (i3 != 1) {
            throw new IllegalArgumentException("Moving more than 1 item is not supported yet");
        }
        this.f16321a.add(mo3000a(8, i, i2, null));
        this.f16328h |= 8;
        if (this.f16321a.size() != 1) {
            z = false;
        }
        return z;
    }

    public void m25733e() {
        m25730c();
        int size = this.f16321a.size();
        for (int i = 0; i < size; i++) {
            qh qhVar = (qh) this.f16321a.get(i);
            switch (qhVar.f16329a) {
                case 1:
                    this.f16323c.mo3059b(qhVar);
                    this.f16323c.mo3060c(qhVar.f16330b, qhVar.f16332d);
                    break;
                case 2:
                    this.f16323c.mo3059b(qhVar);
                    this.f16323c.mo3055a(qhVar.f16330b, qhVar.f16332d);
                    break;
                case 4:
                    this.f16323c.mo3059b(qhVar);
                    this.f16323c.mo3056a(qhVar.f16330b, qhVar.f16332d, qhVar.f16331c);
                    break;
                case 8:
                    this.f16323c.mo3059b(qhVar);
                    this.f16323c.mo3061d(qhVar.f16330b, qhVar.f16332d);
                    break;
            }
            if (this.f16324d != null) {
                this.f16324d.run();
            }
        }
        m25722a(this.f16321a);
        this.f16328h = 0;
    }

    public int m25729c(int i) {
        int size = this.f16321a.size();
        int i2 = i;
        for (int i3 = 0; i3 < size; i3++) {
            qh qhVar = (qh) this.f16321a.get(i3);
            switch (qhVar.f16329a) {
                case 1:
                    if (qhVar.f16330b > i2) {
                        break;
                    }
                    i2 += qhVar.f16332d;
                    break;
                case 2:
                    if (qhVar.f16330b <= i2) {
                        if (qhVar.f16330b + qhVar.f16332d <= i2) {
                            i2 -= qhVar.f16332d;
                            break;
                        }
                        return -1;
                    }
                    continue;
                case 8:
                    if (qhVar.f16330b != i2) {
                        if (qhVar.f16330b < i2) {
                            i2--;
                        }
                        if (qhVar.f16332d > i2) {
                            break;
                        }
                        i2++;
                        break;
                    }
                    i2 = qhVar.f16332d;
                    break;
                default:
                    break;
            }
        }
        return i2;
    }

    public qh mo3000a(int i, int i2, int i3, Object obj) {
        qh qhVar = (qh) this.f16327g.mo2669a();
        if (qhVar == null) {
            return new qh(i, i2, i3, obj);
        }
        qhVar.f16329a = i;
        qhVar.f16330b = i2;
        qhVar.f16332d = i3;
        qhVar.f16331c = obj;
        return qhVar;
    }

    public void mo3001a(qh qhVar) {
        if (!this.f16325e) {
            qhVar.f16331c = null;
            this.f16327g.mo2670a(qhVar);
        }
    }

    void m25722a(List<qh> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            mo3001a((qh) list.get(i));
        }
        list.clear();
    }
}
