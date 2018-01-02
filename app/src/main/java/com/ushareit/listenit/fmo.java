package com.ushareit.listenit;

class fmo implements dzk<Void> {
    final /* synthetic */ fjz f12994a;
    final /* synthetic */ fno f12995b;
    final /* synthetic */ fmm f12996c;

    fmo(fmm com_ushareit_listenit_fmm, fjz com_ushareit_listenit_fjz, fno com_ushareit_listenit_fno) {
        this.f12996c = com_ushareit_listenit_fmm;
        this.f12994a = com_ushareit_listenit_fjz;
        this.f12995b = com_ushareit_listenit_fno;
    }

    public void mo2397a(dzo<Void> com_ushareit_listenit_dzo_java_lang_Void) {
        if (com_ushareit_listenit_dzo_java_lang_Void.mo2130b()) {
            if (this.f12994a != null) {
                this.f12994a.m19582a(System.currentTimeMillis());
            }
            exw.m18443a("UserDeviceSync", "uploadUserDevices: success, device:+" + this.f12995b);
        } else if (this.f12994a != null) {
            this.f12994a.m19580a();
        }
    }
}
