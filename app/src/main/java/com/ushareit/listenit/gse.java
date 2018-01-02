package com.ushareit.listenit;

import java.util.List;

public class gse {
    private static gse f14635a;
    private List<String> f14636b = gvj.m22863E(eys.m18562a());

    private gse() {
    }

    public static gse m22670a() {
        if (f14635a == null) {
            f14635a = new gse();
        }
        return f14635a;
    }

    public void m22672a(List<String> list) {
        this.f14636b.clear();
        this.f14636b.addAll(list);
        gvj.m22911b(eys.m18562a(), (List) list);
    }

    public void m22671a(String str) {
        if (!this.f14636b.contains(str)) {
            this.f14636b.add(str);
            gvj.m22911b(eys.m18562a(), this.f14636b);
        }
    }

    public boolean m22674b(String str) {
        for (String equals : this.f14636b) {
            if (equals.equals(str)) {
                return true;
            }
        }
        return false;
    }

    public boolean m22675b(List<String> list) {
        if (this.f14636b.size() != list.size()) {
            return false;
        }
        for (String contains : list) {
            if (!this.f14636b.contains(contains)) {
                return false;
            }
        }
        return true;
    }

    public void m22673b() {
        hhx.m23867a(new gsf(this));
    }

    public void m22676c(String str) {
        for (glg a : fqs.m20472g(str)) {
            frf.m20644a(a, 1);
        }
        m22671a(str);
    }
}
