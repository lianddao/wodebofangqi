package com.ushareit.listenit;

class qh {
    int f16329a;
    int f16330b;
    Object f16331c;
    int f16332d;

    qh(int i, int i2, int i3, Object obj) {
        this.f16329a = i;
        this.f16330b = i2;
        this.f16332d = i3;
        this.f16331c = obj;
    }

    String m25742a() {
        switch (this.f16329a) {
            case 1:
                return "add";
            case 2:
                return "rm";
            case 4:
                return "up";
            case 8:
                return "mv";
            default:
                return "??";
        }
    }

    public String toString() {
        return Integer.toHexString(System.identityHashCode(this)) + "[" + m25742a() + ",s:" + this.f16330b + "c:" + this.f16332d + ",p:" + this.f16331c + "]";
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        qh qhVar = (qh) obj;
        if (this.f16329a != qhVar.f16329a) {
            return false;
        }
        if (this.f16329a == 8 && Math.abs(this.f16332d - this.f16330b) == 1 && this.f16332d == qhVar.f16330b && this.f16330b == qhVar.f16332d) {
            return true;
        }
        if (this.f16332d != qhVar.f16332d) {
            return false;
        }
        if (this.f16330b != qhVar.f16330b) {
            return false;
        }
        if (this.f16331c != null) {
            if (this.f16331c.equals(qhVar.f16331c)) {
                return true;
            }
            return false;
        } else if (qhVar.f16331c != null) {
            return false;
        } else {
            return true;
        }
    }

    public int hashCode() {
        return (((this.f16329a * 31) + this.f16330b) * 31) + this.f16332d;
    }
}
