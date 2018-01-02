package com.ushareit.listenit;

import android.util.Pair;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class fhk {
    private List<gnj> f12733a = new ArrayList();
    private int f12734b = 1;

    public void m19195a(String str, fhn com_ushareit_listenit_fhn) {
        this.f12734b = 1;
        this.f12733a.clear();
        Pair a = eyw.m18568a(eys.m18562a());
        if (((Boolean) a.first).booleanValue() || ((Boolean) a.second).booleanValue()) {
            hhx.m23867a(new fhl(this, "loadAlbumArts", str, com_ushareit_listenit_fhn));
        } else {
            com_ushareit_listenit_fhn.mo2380a();
        }
    }

    private void m19194a(String str) {
        Collection a = gnf.m22472a(str, this.f12734b, 12);
        if (a != null) {
            this.f12733a.addAll(a);
        }
    }

    private List<gnj> m19191a() {
        int i = 6;
        if (this.f12733a.size() < 6) {
            i = this.f12733a.size();
        }
        List<gnj> arrayList = new ArrayList();
        for (int i2 = 0; i2 < i; i2++) {
            arrayList.add(this.f12733a.get(0));
            this.f12733a.remove(0);
        }
        return arrayList;
    }

    public void m19196b(String str, fhn com_ushareit_listenit_fhn) {
        if (this.f12733a.size() >= 6) {
            com_ushareit_listenit_fhn.mo2381a(m19191a());
            return;
        }
        Pair a = eyw.m18568a(eys.m18562a());
        if (((Boolean) a.first).booleanValue() || ((Boolean) a.second).booleanValue()) {
            this.f12734b++;
            hhx.m23867a(new fhm(this, "loadAlbumArts", str, com_ushareit_listenit_fhn));
            return;
        }
        com_ushareit_listenit_fhn.mo2380a();
    }
}
