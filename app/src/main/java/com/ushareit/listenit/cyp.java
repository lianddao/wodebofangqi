package com.ushareit.listenit;

public class cyp<T, U> {
    private final T f9367a;
    private final U f9368b;

    public cyp(T t, U u) {
        this.f9367a = t;
        this.f9368b = u;
    }

    public T m13380a() {
        return this.f9367a;
    }

    public U m13381b() {
        return this.f9368b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        cyp com_ushareit_listenit_cyp = (cyp) obj;
        if (this.f9367a == null ? com_ushareit_listenit_cyp.f9367a != null : !this.f9367a.equals(com_ushareit_listenit_cyp.f9367a)) {
            return false;
        }
        if (this.f9368b != null) {
            if (this.f9368b.equals(com_ushareit_listenit_cyp.f9368b)) {
                return true;
            }
        } else if (com_ushareit_listenit_cyp.f9368b == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = (this.f9367a != null ? this.f9367a.hashCode() : 0) * 31;
        if (this.f9368b != null) {
            i = this.f9368b.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        String valueOf = String.valueOf(this.f9367a);
        String valueOf2 = String.valueOf(this.f9368b);
        return new StringBuilder((String.valueOf(valueOf).length() + 7) + String.valueOf(valueOf2).length()).append("Pair(").append(valueOf).append(",").append(valueOf2).append(")").toString();
    }
}
