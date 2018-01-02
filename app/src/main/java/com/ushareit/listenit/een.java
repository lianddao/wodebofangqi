package com.ushareit.listenit;

import com.google.firebase.iid.FirebaseInstanceId;

public class een {
    private final FirebaseInstanceId f10877a;

    private een(FirebaseInstanceId firebaseInstanceId) {
        this.f10877a = firebaseInstanceId;
    }

    public static een m16846a() {
        return new een(FirebaseInstanceId.m2550a());
    }

    public String m16847b() {
        return this.f10877a.m2562c();
    }

    public String m16848c() {
        return this.f10877a.m2563d();
    }
}
