package com.ushareit.listenit;

import java.util.ArrayList;
import java.util.List;

class flk implements dzk<Void> {
    final /* synthetic */ fjz f12914a;
    final /* synthetic */ List f12915b;
    final /* synthetic */ long f12916c;
    final /* synthetic */ fli f12917d;

    flk(fli com_ushareit_listenit_fli, fjz com_ushareit_listenit_fjz, List list, long j) {
        this.f12917d = com_ushareit_listenit_fli;
        this.f12914a = com_ushareit_listenit_fjz;
        this.f12915b = list;
        this.f12916c = j;
    }

    public void mo2397a(dzo<Void> com_ushareit_listenit_dzo_java_lang_Void) {
        exw.m18443a("PlaylistSync", "uploadAll: " + com_ushareit_listenit_dzo_java_lang_Void.mo2130b());
        if (com_ushareit_listenit_dzo_java_lang_Void.mo2130b()) {
            List arrayList = new ArrayList(this.f12915b.size());
            for (glc com_ushareit_listenit_glc : this.f12915b) {
                arrayList.add(com_ushareit_listenit_glc.f14283c);
            }
            frd.m20606a(arrayList, 0);
            frd.m20607a(arrayList, this.f12916c);
            fle.m19717b().m19728b(this.f12916c);
            fle.m19717b().m19730b(false);
            if (this.f12914a != null) {
                this.f12914a.m19586b(this.f12916c);
            }
            arrayList = new ArrayList(this.f12915b.size());
            for (glc com_ushareit_listenit_glc2 : this.f12915b) {
                arrayList.add(new fnj(com_ushareit_listenit_glc2.f14283c, this.f12916c));
            }
            fka.m19594a(arrayList);
        } else if (this.f12914a != null) {
            this.f12914a.m19584b();
        }
    }
}
