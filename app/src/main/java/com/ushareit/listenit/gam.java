package com.ushareit.listenit;

import java.util.List;

public class gam extends gax {
    private List<? extends gla> f13811b;

    public gam(List<? extends gla> list) {
        this.f13811b = list;
    }

    public List<? extends gla> mo2568d() {
        List<? extends gla> a = fqs.m20451a(eys.m18562a());
        if (this.f13811b != null && this.f13811b.size() > 0 && (this.f13811b.get(0) instanceof glg)) {
            a.removeAll(this.f13811b);
        }
        return a;
    }
}
