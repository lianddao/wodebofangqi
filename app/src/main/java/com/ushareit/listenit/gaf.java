package com.ushareit.listenit;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.ushareit.listenit.invite.InviteActivity;

public class gaf implements OnClickListener {
    final /* synthetic */ InviteActivity f13810a;

    public gaf(InviteActivity inviteActivity) {
        this.f13810a = inviteActivity;
    }

    public void onClick(View view) {
        Activity activity = (Activity) view.getContext();
        if (fbj.m18787b(activity, "com.lenovo.anyshare.gps")) {
            gag.m21470a(activity, "com.lenovo.anyshare.gps");
        } else if (fbj.m18787b(activity, "com.lenovo.anyshare")) {
            gag.m21470a(activity, "com.lenovo.anyshare");
        } else if (fbj.m18787b(activity, "com.android.vending")) {
            fad.m18688a(activity, "com.lenovo.anyshare.gps", fql.m20387a(), "invite_us_navigation", true);
        } else {
            fad.m18688a(activity, "com.lenovo.anyshare", fql.m20387a(), "invite_us_navigation", true);
        }
        fil.m19345a(this.f13810a.getApplicationContext(), "shareit");
    }
}
