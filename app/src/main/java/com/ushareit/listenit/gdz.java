package com.ushareit.listenit;

import android.view.View;
import android.view.View.OnClickListener;
import com.ushareit.listenit.login.LoginActivity;

public class gdz implements OnClickListener {
    final /* synthetic */ LoginActivity f13980a;

    public gdz(LoginActivity loginActivity) {
        this.f13980a = loginActivity;
    }

    public void onClick(View view) {
        fiw.m19475f(eys.m18562a(), "cancel" + (fbb.m18763c(this.f13980a.f15764F) ? "" : "_" + this.f13980a.f15764F));
        this.f13980a.finish();
    }
}
