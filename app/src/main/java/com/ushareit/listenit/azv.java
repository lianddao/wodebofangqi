package com.ushareit.listenit;

import com.facebook.internal.cb;
import com.facebook.login.widget.LoginButton;

public class azv implements Runnable {
    final /* synthetic */ String f5751a;
    final /* synthetic */ LoginButton f5752b;

    public azv(LoginButton loginButton, String str) {
        this.f5752b = loginButton;
        this.f5751a = str;
    }

    public void run() {
        this.f5752b.getActivity().runOnUiThread(new azw(this, cb.m1557a(this.f5751a, false)));
    }
}
