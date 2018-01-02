package com.ushareit.listenit;

public class aft {
    private Class<?> f4281a;
    private Class<?> f4282b;

    public aft(Class<?> cls, Class<?> cls2) {
        m5489a(cls, cls2);
    }

    public void m5489a(Class<?> cls, Class<?> cls2) {
        this.f4281a = cls;
        this.f4282b = cls2;
    }

    public String toString() {
        return "MultiClassKey{first=" + this.f4281a + ", second=" + this.f4282b + '}';
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        aft com_ushareit_listenit_aft = (aft) obj;
        if (!this.f4281a.equals(com_ushareit_listenit_aft.f4281a)) {
            return false;
        }
        if (this.f4282b.equals(com_ushareit_listenit_aft.f4282b)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (this.f4281a.hashCode() * 31) + this.f4282b.hashCode();
    }
}
