package com.ushareit.listenit;

import java.util.List;

class rm {
    final rn f16429a;

    public rm(rn rnVar) {
        this.f16429a = rnVar;
    }

    void m25960a(List<qh> list) {
        while (true) {
            int b = m25958b(list);
            if (b != -1) {
                m25957a(list, b, b + 1);
            } else {
                return;
            }
        }
    }

    private void m25957a(List<qh> list, int i, int i2) {
        qh qhVar = (qh) list.get(i);
        qh qhVar2 = (qh) list.get(i2);
        switch (qhVar2.f16329a) {
            case 1:
                m25959c(list, i, qhVar, i2, qhVar2);
                return;
            case 2:
                m25961a(list, i, qhVar, i2, qhVar2);
                return;
            case 4:
                m25962b(list, i, qhVar, i2, qhVar2);
                return;
            default:
                return;
        }
    }

    void m25961a(List<qh> list, int i, qh qhVar, int i2, qh qhVar2) {
        int i3;
        qh qhVar3;
        int i4 = 0;
        if (qhVar.f16330b < qhVar.f16332d) {
            i3 = (qhVar2.f16330b == qhVar.f16330b && qhVar2.f16332d == qhVar.f16332d - qhVar.f16330b) ? 1 : 0;
        } else if (qhVar2.f16330b == qhVar.f16332d + 1 && qhVar2.f16332d == qhVar.f16330b - qhVar.f16332d) {
            i4 = 1;
            i3 = 1;
        } else {
            i3 = 0;
            i4 = 1;
        }
        if (qhVar.f16332d < qhVar2.f16330b) {
            qhVar2.f16330b--;
        } else if (qhVar.f16332d < qhVar2.f16330b + qhVar2.f16332d) {
            qhVar2.f16332d--;
            qhVar.f16329a = 2;
            qhVar.f16332d = 1;
            if (qhVar2.f16332d == 0) {
                list.remove(i2);
                this.f16429a.mo3001a(qhVar2);
                return;
            }
            return;
        }
        if (qhVar.f16330b <= qhVar2.f16330b) {
            qhVar2.f16330b++;
            qhVar3 = null;
        } else if (qhVar.f16330b < qhVar2.f16330b + qhVar2.f16332d) {
            qhVar3 = this.f16429a.mo3000a(2, qhVar.f16330b + 1, (qhVar2.f16330b + qhVar2.f16332d) - qhVar.f16330b, null);
            qhVar2.f16332d = qhVar.f16330b - qhVar2.f16330b;
        } else {
            qhVar3 = null;
        }
        if (i3 != 0) {
            list.set(i, qhVar2);
            list.remove(i2);
            this.f16429a.mo3001a(qhVar);
            return;
        }
        if (i4 != 0) {
            if (qhVar3 != null) {
                if (qhVar.f16330b > qhVar3.f16330b) {
                    qhVar.f16330b -= qhVar3.f16332d;
                }
                if (qhVar.f16332d > qhVar3.f16330b) {
                    qhVar.f16332d -= qhVar3.f16332d;
                }
            }
            if (qhVar.f16330b > qhVar2.f16330b) {
                qhVar.f16330b -= qhVar2.f16332d;
            }
            if (qhVar.f16332d > qhVar2.f16330b) {
                qhVar.f16332d -= qhVar2.f16332d;
            }
        } else {
            if (qhVar3 != null) {
                if (qhVar.f16330b >= qhVar3.f16330b) {
                    qhVar.f16330b -= qhVar3.f16332d;
                }
                if (qhVar.f16332d >= qhVar3.f16330b) {
                    qhVar.f16332d -= qhVar3.f16332d;
                }
            }
            if (qhVar.f16330b >= qhVar2.f16330b) {
                qhVar.f16330b -= qhVar2.f16332d;
            }
            if (qhVar.f16332d >= qhVar2.f16330b) {
                qhVar.f16332d -= qhVar2.f16332d;
            }
        }
        list.set(i, qhVar2);
        if (qhVar.f16330b != qhVar.f16332d) {
            list.set(i2, qhVar);
        } else {
            list.remove(i2);
        }
        if (qhVar3 != null) {
            list.add(i, qhVar3);
        }
    }

    private void m25959c(List<qh> list, int i, qh qhVar, int i2, qh qhVar2) {
        int i3 = 0;
        if (qhVar.f16332d < qhVar2.f16330b) {
            i3 = -1;
        }
        if (qhVar.f16330b < qhVar2.f16330b) {
            i3++;
        }
        if (qhVar2.f16330b <= qhVar.f16330b) {
            qhVar.f16330b += qhVar2.f16332d;
        }
        if (qhVar2.f16330b <= qhVar.f16332d) {
            qhVar.f16332d += qhVar2.f16332d;
        }
        qhVar2.f16330b = i3 + qhVar2.f16330b;
        list.set(i, qhVar2);
        list.set(i2, qhVar);
    }

    void m25962b(List<qh> list, int i, qh qhVar, int i2, qh qhVar2) {
        Object obj;
        Object obj2 = null;
        if (qhVar.f16332d < qhVar2.f16330b) {
            qhVar2.f16330b--;
            obj = null;
        } else if (qhVar.f16332d < qhVar2.f16330b + qhVar2.f16332d) {
            qhVar2.f16332d--;
            obj = this.f16429a.mo3000a(4, qhVar.f16330b, 1, qhVar2.f16331c);
        } else {
            obj = null;
        }
        if (qhVar.f16330b <= qhVar2.f16330b) {
            qhVar2.f16330b++;
        } else if (qhVar.f16330b < qhVar2.f16330b + qhVar2.f16332d) {
            int i3 = (qhVar2.f16330b + qhVar2.f16332d) - qhVar.f16330b;
            obj2 = this.f16429a.mo3000a(4, qhVar.f16330b + 1, i3, qhVar2.f16331c);
            qhVar2.f16332d -= i3;
        }
        list.set(i2, qhVar);
        if (qhVar2.f16332d > 0) {
            list.set(i, qhVar2);
        } else {
            list.remove(i);
            this.f16429a.mo3001a(qhVar2);
        }
        if (obj != null) {
            list.add(i, obj);
        }
        if (obj2 != null) {
            list.add(i, obj2);
        }
    }

    private int m25958b(List<qh> list) {
        Object obj = null;
        int size = list.size() - 1;
        while (size >= 0) {
            Object obj2;
            if (((qh) list.get(size)).f16329a != 8) {
                obj2 = 1;
            } else if (obj != null) {
                return size;
            } else {
                obj2 = obj;
            }
            size--;
            obj = obj2;
        }
        return -1;
    }
}
