package com.ushareit.listenit;

import android.view.View;
import android.view.View.OnClickListener;
import com.ushareit.listenit.invite.InviteActivity;

public class gae implements OnClickListener {
    final /* synthetic */ InviteActivity f13809a;

    public gae(InviteActivity inviteActivity) {
        this.f13809a = inviteActivity;
    }

    public void onClick(View view) {
        if (gyn.m23199a(this.f13809a)) {
            try {
                gag.m21471a(this.f13809a, 4097);
                fil.m19345a(this.f13809a.getApplicationContext(), "bluetooth");
                return;
            } catch (Throwable e) {
                exw.m18446a("InviteActivity", e);
                return;
            }
        }
        heb.m23597a(this.f13809a.getResources().getString(C0349R.string.invite_bluetooth_unsupported), 0).show();
    }
}
