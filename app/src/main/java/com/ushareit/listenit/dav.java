package com.ushareit.listenit;

import java.lang.reflect.Type;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class dav {
    private dco f9479a = dco.f9537a;
    private dbk f9480b = dbk.DEFAULT;
    private dan f9481c = dah.IDENTITY;
    private final Map<Type, daw<?>> f9482d = new HashMap();
    private final List<dbr> f9483e = new ArrayList();
    private final List<dbr> f9484f = new ArrayList();
    private int f9485g = 2;
    private int f9486h = 2;
    private boolean f9487i = true;

    private void m13682a(String str, int i, int i2, List<dbr> list) {
        Object com_ushareit_listenit_dae;
        if (str != null && !"".equals(str.trim())) {
            com_ushareit_listenit_dae = new dae(str);
        } else if (i != 2 && i2 != 2) {
            com_ushareit_listenit_dae = new dae(i, i2);
        } else {
            return;
        }
        list.add(dbn.m13737a(dft.m14119b(Date.class), com_ushareit_listenit_dae));
        list.add(dbn.m13737a(dft.m14119b(Timestamp.class), com_ushareit_listenit_dae));
        list.add(dbn.m13737a(dft.m14119b(java.sql.Date.class), com_ushareit_listenit_dae));
    }

    public dav m13683a() {
        this.f9487i = false;
        return this;
    }

    public dav m13684a(Type type, Object obj) {
        boolean z = (obj instanceof dbi) || (obj instanceof daz) || (obj instanceof daw) || (obj instanceof dbq);
        dbw.m13749a(z);
        if (obj instanceof daw) {
            this.f9482d.put(type, (daw) obj);
        }
        if ((obj instanceof dbi) || (obj instanceof daz)) {
            this.f9483e.add(dbn.m13738b(dft.m14117a(type), obj));
        }
        if (obj instanceof dbq) {
            this.f9483e.add(dek.m14000a(dft.m14117a(type), (dbq) obj));
        }
        return this;
    }

    public dav m13685a(int... iArr) {
        this.f9479a = this.f9479a.m13800a(iArr);
        return this;
    }

    public dav m13686a(daf... com_ushareit_listenit_dafArr) {
        for (daf a : com_ushareit_listenit_dafArr) {
            this.f9479a = this.f9479a.m13799a(a, true, true);
        }
        return this;
    }

    public dao m13687b() {
        List arrayList = new ArrayList();
        arrayList.addAll(this.f9483e);
        Collections.reverse(arrayList);
        arrayList.addAll(this.f9484f);
        m13682a(null, this.f9485g, this.f9486h, arrayList);
        return new dao(this.f9479a, this.f9481c, this.f9482d, false, false, false, this.f9487i, false, false, this.f9480b, arrayList);
    }
}
