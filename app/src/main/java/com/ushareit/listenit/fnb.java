package com.ushareit.listenit;

class fnb implements dzk<Void> {
    final /* synthetic */ fjz f13023a;
    final /* synthetic */ long f13024b;
    final /* synthetic */ fmp f13025c;

    fnb(fmp com_ushareit_listenit_fmp, fjz com_ushareit_listenit_fjz, long j) {
        this.f13025c = com_ushareit_listenit_fmp;
        this.f13023a = com_ushareit_listenit_fjz;
        this.f13024b = j;
    }

    public void mo2397a(dzo<Void> com_ushareit_listenit_dzo_java_lang_Void) {
        exw.m18443a("UserInfoSync", "uploadAll: " + com_ushareit_listenit_dzo_java_lang_Void.mo2130b());
        if (com_ushareit_listenit_dzo_java_lang_Void.mo2130b()) {
            fle.m19717b().m19723a(this.f13024b);
            fle.m19717b().m19735d(this.f13024b);
            fle.m19717b().m19738e(this.f13024b);
            fle.m19717b().m19726a(false);
            fle.m19717b().m19739e(false);
            fle.m19717b().m19736d(false);
            fka.m19593a(fle.m19717b().m19741g());
            if (this.f13023a != null) {
                this.f13023a.m19586b(this.f13024b);
            }
        } else if (this.f13023a != null) {
            this.f13023a.m19584b();
        }
    }
}
