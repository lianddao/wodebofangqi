package com.ushareit.listenit;

import android.view.View;
import android.view.View.OnClickListener;
import com.ushareit.listenit.login.UserProfileActivity;

public class gfh implements OnClickListener {
    final /* synthetic */ UserProfileActivity f14025a;

    public gfh(UserProfileActivity userProfileActivity) {
        this.f14025a = userProfileActivity;
    }

    public void onClick(View view) {
        this.f14025a.finish();
    }
}
