package com.ushareit.listenit;

import java.util.ArrayList;
import java.util.List;

class fkx implements dzk<Void> {
    final /* synthetic */ fjz f12874a;
    final /* synthetic */ List f12875b;
    final /* synthetic */ long f12876c;
    final /* synthetic */ fkv f12877d;

    fkx(fkv com_ushareit_listenit_fkv, fjz com_ushareit_listenit_fjz, List list, long j) {
        this.f12877d = com_ushareit_listenit_fkv;
        this.f12874a = com_ushareit_listenit_fjz;
        this.f12875b = list;
        this.f12876c = j;
    }

    public void mo2397a(dzo<Void> com_ushareit_listenit_dzo_java_lang_Void) {
        exw.m18443a("LibrarySongSync", "uploadAll: " + com_ushareit_listenit_dzo_java_lang_Void.mo2130b());
        if (com_ushareit_listenit_dzo_java_lang_Void.mo2130b()) {
            for (glg com_ushareit_listenit_glg : this.f12875b) {
                frf.m20668c(com_ushareit_listenit_glg, 0);
                frf.m20645a(com_ushareit_listenit_glg, this.f12876c);
            }
            fle.m19717b().m19732c(this.f12876c);
            fle.m19717b().m19733c(false);
            if (this.f12874a != null) {
                this.f12874a.m19586b(this.f12876c);
            }
            List arrayList = new ArrayList(this.f12875b.size());
            for (glg com_ushareit_listenit_glg2 : this.f12875b) {
                arrayList.add(new fnm(com_ushareit_listenit_glg2.m22362h(), this.f12876c));
            }
            fka.m19595a(arrayList, "uploadall");
        } else if (this.f12874a != null) {
            this.f12874a.m19584b();
        }
    }
}
