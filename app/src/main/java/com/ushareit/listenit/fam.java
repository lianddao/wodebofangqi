package com.ushareit.listenit;

public class fam {
    public String f12322a;
    public String f12323b;
    public String f12324c;

    public boolean m18723a() {
        return this.f12322a != null && this.f12322a.length() > 0 && ((this.f12323b != null && this.f12323b.length() >= 10) || (this.f12324c != null && this.f12324c.length() >= 10));
    }

    public String m18724b() {
        return (this.f12324c == null || this.f12324c.length() < 10) ? this.f12323b : this.f12324c;
    }

    public String toString() {
        String str = "";
        if (!m18723a()) {
            return str;
        }
        return ((str + "ChipType: " + this.f12322a + "\n") + "IMEI1: " + this.f12323b + "\n") + "IMEI2: " + this.f12324c + "\n";
    }
}
