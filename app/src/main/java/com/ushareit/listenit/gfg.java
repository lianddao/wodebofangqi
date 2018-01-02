package com.ushareit.listenit;

import com.ushareit.listenit.login.UserProfileActivity;

public class gfg implements flh {
    final /* synthetic */ UserProfileActivity f14024a;

    public gfg(UserProfileActivity userProfileActivity) {
        this.f14024a = userProfileActivity;
    }

    public void mo2671a() {
        int k = frf.m20685k();
        int j = frf.m20684j() + k;
        boolean a = fle.m19717b().m19727a();
        if (fkb.m19610a().m19649g() && a) {
            if (!((Boolean) eyw.m18568a(this.f14024a).second).booleanValue() || j <= 0) {
                this.f14024a.f15782A.setText(this.f14024a.getString(C0349R.string.sync_discover_playlist));
            } else {
                this.f14024a.f15782A.setText(this.f14024a.getString(C0349R.string.sync_discover_songs_detail, new Object[]{Integer.valueOf(k + r2)}));
            }
            if (fle.m19717b().m19752r()) {
                this.f14024a.f15805q.setText(String.valueOf(frf.m20670d()));
                this.f14024a.f15806r.setText(String.valueOf(frf.m20674e()));
            }
        }
    }
}
