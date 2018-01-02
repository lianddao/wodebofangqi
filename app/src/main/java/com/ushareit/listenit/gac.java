package com.ushareit.listenit;

import android.view.View;
import android.view.View.OnClickListener;
import com.ushareit.listenit.invite.InviteActivity;

public class gac implements OnClickListener {
    final /* synthetic */ InviteActivity f13807a;

    public gac(InviteActivity inviteActivity) {
        this.f13807a = inviteActivity;
    }

    public void onClick(View view) {
        this.f13807a.finish();
    }
}
