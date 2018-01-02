package com.ushareit.listenit;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.ushareit.listenit.cloudsync.CloudSyncService;
import com.ushareit.listenit.login.UserProfileActivity;

public class gfi implements OnCheckedChangeListener {
    final /* synthetic */ UserProfileActivity f14026a;

    public gfi(UserProfileActivity userProfileActivity) {
        this.f14026a = userProfileActivity;
    }

    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        fiw.m19460a(this.f14026a, z);
        gvj.m22943e(this.f14026a, z);
        boolean booleanValue = ((Boolean) eyw.m18568a(this.f14026a).second).booleanValue();
        if (gef.m21805a().m21835e() && z && booleanValue && fkb.m19610a().m19649g()) {
            CloudSyncService.m11590a(1);
        }
    }
}
