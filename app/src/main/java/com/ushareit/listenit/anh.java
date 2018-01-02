package com.ushareit.listenit;

import java.util.concurrent.Callable;

class anh implements Callable<Boolean> {
    final /* synthetic */ and f4926a;
    private final String f4927b;

    public anh(and com_ushareit_listenit_and, String str) {
        this.f4926a = com_ushareit_listenit_and;
        this.f4927b = str;
    }

    public Boolean m6377a() {
        this.f4926a.f4918e.m6386a(this.f4927b);
        return Boolean.valueOf(true);
    }

    public /* synthetic */ Object call() {
        return m6377a();
    }
}
