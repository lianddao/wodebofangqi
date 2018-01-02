package com.ushareit.listenit;

import android.view.View;
import android.view.View.OnClickListener;
import com.ushareit.listenit.login.LoginActivity;

public class gdy implements OnClickListener {
    final /* synthetic */ LoginActivity f13979a;

    public gdy(LoginActivity loginActivity) {
        this.f13979a = loginActivity;
    }

    public void onClick(View view) {
        this.f13979a.finish();
    }
}
