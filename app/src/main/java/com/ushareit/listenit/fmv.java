package com.ushareit.listenit;

class fmv implements dzk<Void> {
    final /* synthetic */ fjz f13008a;
    final /* synthetic */ long f13009b;
    final /* synthetic */ fmp f13010c;

    fmv(fmp com_ushareit_listenit_fmp, fjz com_ushareit_listenit_fjz, long j) {
        this.f13010c = com_ushareit_listenit_fmp;
        this.f13008a = com_ushareit_listenit_fjz;
        this.f13009b = j;
    }

    public void mo2397a(dzo<Void> com_ushareit_listenit_dzo_java_lang_Void) {
        exw.m18443a("UserInfoSync", "uploadUserAvator: result=" + com_ushareit_listenit_dzo_java_lang_Void.mo2130b());
        if (com_ushareit_listenit_dzo_java_lang_Void.mo2130b()) {
            fle.m19717b().m19738e(this.f13009b);
            fle.m19717b().m19739e(false);
            if (this.f13008a != null) {
                this.f13008a.m19586b(this.f13009b);
            }
        } else if (this.f13008a != null) {
            this.f13008a.m19584b();
        }
    }
}
