package com.ushareit.listenit;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;

class csm implements Callable<List<cux>> {
    static final /* synthetic */ boolean f8882a = (!csd.class.desiredAssertionStatus());
    final /* synthetic */ cvg f8883b;
    final /* synthetic */ cqh f8884c;
    final /* synthetic */ ece f8885d;
    final /* synthetic */ csd f8886e;

    csm(csd com_ushareit_listenit_csd, cvg com_ushareit_listenit_cvg, cqh com_ushareit_listenit_cqh, ece com_ushareit_listenit_ece) {
        this.f8886e = com_ushareit_listenit_csd;
        this.f8883b = com_ushareit_listenit_cvg;
        this.f8884c = com_ushareit_listenit_cqh;
        this.f8885d = com_ushareit_listenit_ece;
    }

    public List<cux> m12532a() {
        cqq a = this.f8883b.m13002a();
        csc com_ushareit_listenit_csc = (csc) this.f8886e.f8845b.m12754e(a);
        List<cux> arrayList = new ArrayList();
        if (com_ushareit_listenit_csc != null && (this.f8883b.m13005d() || com_ushareit_listenit_csc.m12475b(this.f8883b))) {
            Object obj;
            cyp a2 = com_ushareit_listenit_csc.m12470a(this.f8883b, this.f8884c, this.f8885d);
            if (com_ushareit_listenit_csc.m12473a()) {
                this.f8886e.f8845b = this.f8886e.f8845b.m12752d(a);
            }
            List<cvg> list = (List) a2.m13380a();
            arrayList = (List) a2.m13381b();
            Object obj2 = null;
            for (cvg com_ushareit_listenit_cvg : list) {
                this.f8886e.f8851h.mo1607c(this.f8883b);
                obj = (obj2 != null || com_ushareit_listenit_cvg.m13006e()) ? 1 : null;
                obj2 = obj;
            }
            cui d = this.f8886e.f8845b;
            obj = (d.m12746b() == null || !((csc) d.m12746b()).m12476c()) ? null : 1;
            Iterator it = a.iterator();
            cui com_ushareit_listenit_cui = d;
            Object obj3 = obj;
            while (it.hasNext()) {
                com_ushareit_listenit_cui = com_ushareit_listenit_cui.m12742a((cwc) it.next());
                obj = (obj3 != null || (com_ushareit_listenit_cui.m12746b() != null && ((csc) com_ushareit_listenit_cui.m12746b()).m12476c())) ? 1 : null;
                if (obj != null) {
                    obj3 = obj;
                    break;
                } else if (com_ushareit_listenit_cui.m12753d()) {
                    obj3 = obj;
                    break;
                } else {
                    obj3 = obj;
                }
            }
            if (obj2 != null && obj3 == null) {
                cui c = this.f8886e.f8845b.m12750c(a);
                if (!c.m12753d()) {
                    for (cvh com_ushareit_listenit_cvh : this.f8886e.m12489a(c)) {
                        css com_ushareit_listenit_css = new css(this.f8886e, com_ushareit_listenit_cvh);
                        this.f8886e.f8850g.mo1570a(this.f8886e.m12482a(com_ushareit_listenit_cvh.m13008a()), com_ushareit_listenit_css.f8906c, com_ushareit_listenit_css, com_ushareit_listenit_css);
                    }
                }
            }
            if (obj3 == null && !list.isEmpty() && this.f8885d == null) {
                if (obj2 != null) {
                    this.f8886e.f8850g.mo1569a(this.f8886e.m12482a(this.f8883b), null);
                } else {
                    for (cvg com_ushareit_listenit_cvg2 : list) {
                        csu a3 = this.f8886e.m12497b(com_ushareit_listenit_cvg2);
                        if (f8882a || a3 != null) {
                            this.f8886e.f8850g.mo1569a(this.f8886e.m12482a(com_ushareit_listenit_cvg2), a3);
                        } else {
                            throw new AssertionError();
                        }
                    }
                }
            }
            this.f8886e.m12496a((List) list);
        }
        return arrayList;
    }

    public /* synthetic */ Object call() {
        return m12532a();
    }
}
