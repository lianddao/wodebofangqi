package com.ushareit.listenit;

import com.ushareit.listenit.login.UserProfileActivity;

public class gfc implements gnh {
    final /* synthetic */ UserProfileActivity f14020a;

    public gfc(UserProfileActivity userProfileActivity) {
        this.f14020a = userProfileActivity;
    }

    public void mo2404a(int i, int i2) {
        long j = 995;
        if (fkb.m19610a().m19647e() == fkq.DOWNLOADING_SONGS || fkb.m19610a().m19647e() == fkq.UPLOADING_SONGS) {
            long j2 = (((long) i) * 1000) / ((long) i2);
            if (j2 < 995) {
                j = j2;
            }
            this.f14020a.f15786E.setMax(1000);
            this.f14020a.f15786E.setProgress((int) j);
        }
    }
}
