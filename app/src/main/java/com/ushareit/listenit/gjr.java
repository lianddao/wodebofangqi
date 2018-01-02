package com.ushareit.listenit;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.ushareit.listenit.invite.InviteActivity;
import com.ushareit.listenit.main.navigation.NavigationView;

public class gjr implements OnClickListener {
    final /* synthetic */ NavigationView f14205a;

    public gjr(NavigationView navigationView) {
        this.f14205a = navigationView;
    }

    public void onClick(View view) {
        this.f14205a.m24853a(new Intent(this.f14205a.f15919c, InviteActivity.class));
        fii.m19297a(this.f14205a.f15919c, "invite friends", "from_navigation");
    }
}
