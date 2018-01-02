package com.ushareit.listenit;

import com.google.android.gms.common.api.Status;

class gdt implements ceh<Status> {
    final /* synthetic */ gds f13973a;

    gdt(gds com_ushareit_listenit_gds) {
        this.f13973a = com_ushareit_listenit_gds;
    }

    public void m21788a(Status status) {
        if (status.m2257f()) {
            exw.m18454c("LOGIN.GOOGLE", "Google logout success");
        } else {
            exw.m18454c("LOGIN.GOOGLE", "Google logout failure : " + status.m2254c());
        }
    }
}
