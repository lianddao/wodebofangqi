package com.ushareit.listenit;

import android.net.Uri;
import com.google.firebase.auth.UserProfileChangeRequest;

public class ebr {
    private String f10798a;
    private Uri f10799b;
    private boolean f10800c;
    private boolean f10801d;

    public UserProfileChangeRequest m16663a() {
        return new UserProfileChangeRequest(1, this.f10798a, this.f10799b == null ? null : this.f10799b.toString(), this.f10800c, this.f10801d);
    }

    public ebr m16664a(String str) {
        if (str == null) {
            this.f10800c = true;
        } else {
            this.f10798a = str;
        }
        return this;
    }
}
