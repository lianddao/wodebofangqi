package com.ushareit.listenit;

import android.view.View;
import com.ushareit.listenit.login.LoginActivity;

public class gdx implements Runnable {
    final /* synthetic */ View f13977a;
    final /* synthetic */ LoginActivity f13978b;

    public gdx(LoginActivity loginActivity, View view) {
        this.f13978b = loginActivity;
        this.f13977a = view;
    }

    public void run() {
        this.f13977a.requestFocus();
        this.f13977a.setFocusable(true);
        this.f13978b.f15762D.showSoftInput(this.f13977a, 1);
    }
}
