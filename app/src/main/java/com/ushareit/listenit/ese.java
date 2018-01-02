package com.ushareit.listenit;

import java.util.Set;

public class ese extends eyr {
    public String f11684a;
    public String f11685b;
    public String f11686c;
    public int f11687d;
    public Set<Integer> f11688e = null;
    public int f11689f = 1;
    public int f11690g = 1;
    public int f11691h = 1;
    public boolean f11692i = false;

    public ese(String str) {
    }

    public String mo2366a() {
        return this.f11685b + "|" + this.f11684a + ":" + this.f11686c;
    }

    public boolean m17724b() {
        return this.f11688e != null;
    }

    public boolean m17723a(int i) {
        try {
            return this.f11688e != null && this.f11688e.contains(Integer.valueOf(i));
        } catch (Exception e) {
            return false;
        }
    }

    public boolean equals(Object obj) {
        return (obj instanceof ese) && obj.hashCode() == hashCode();
    }

    public int hashCode() {
        return mo2366a().hashCode();
    }
}
