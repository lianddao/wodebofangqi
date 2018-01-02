package com.ushareit.listenit;

import com.google.android.gms.common.api.Status;

class gdv implements ceh<Status> {
    final /* synthetic */ gdu f13975a;

    gdv(gdu com_ushareit_listenit_gdu) {
        this.f13975a = com_ushareit_listenit_gdu;
    }

    public void m21792a(Status status) {
        exw.m18454c("LOGIN.GOOGLE", "onResult");
        if (status.m2257f()) {
            exw.m18454c("LOGIN.GOOGLE", "Google logout success");
        } else {
            exw.m18454c("LOGIN.GOOGLE", "Google logout failure : " + status.m2254c());
        }
    }
}
