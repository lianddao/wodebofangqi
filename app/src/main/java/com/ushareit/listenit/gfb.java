package com.ushareit.listenit;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.ushareit.listenit.login.SyncLogActivity;
import com.ushareit.listenit.login.UserProfileActivity;

public class gfb implements OnClickListener {
    final /* synthetic */ UserProfileActivity f14019a;

    public gfb(UserProfileActivity userProfileActivity) {
        this.f14019a = userProfileActivity;
    }

    public void onClick(View view) {
        this.f14019a.startActivity(new Intent(this.f14019a, SyncLogActivity.class));
    }
}
