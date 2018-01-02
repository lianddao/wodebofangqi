package com.ushareit.listenit;

import java.util.Map;

class fld implements dzk<Void> {
    final /* synthetic */ fjz f12897a;
    final /* synthetic */ Map f12898b;
    final /* synthetic */ long f12899c;
    final /* synthetic */ fkv f12900d;

    fld(fkv com_ushareit_listenit_fkv, fjz com_ushareit_listenit_fjz, Map map, long j) {
        this.f12900d = com_ushareit_listenit_fkv;
        this.f12897a = com_ushareit_listenit_fjz;
        this.f12898b = map;
        this.f12899c = j;
    }

    public void mo2397a(dzo<Void> com_ushareit_listenit_dzo_java_lang_Void) {
        if (com_ushareit_listenit_dzo_java_lang_Void.mo2130b()) {
            exw.m18443a("LibrarySongSync", "uploadSongs: result=" + com_ushareit_listenit_dzo_java_lang_Void.mo2130b());
            for (glg com_ushareit_listenit_glg : this.f12898b.values()) {
                frf.m20668c(com_ushareit_listenit_glg, 0);
                frf.m20645a(com_ushareit_listenit_glg, this.f12899c);
            }
            if (this.f12897a != null) {
                this.f12897a.m19586b(this.f12899c);
            }
        } else if (this.f12897a != null) {
            this.f12897a.m19584b();
        }
    }
}
