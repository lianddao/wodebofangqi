package com.ushareit.listenit;

import java.util.concurrent.Callable;

class ang implements Callable<Boolean> {
    final /* synthetic */ and f4924a;
    private final String f4925b;

    public ang(and com_ushareit_listenit_and, String str) {
        this.f4924a = com_ushareit_listenit_and;
        this.f4925b = str;
    }

    public Boolean m6376a() {
        this.f4924a.f4917d.m6382a(this.f4925b);
        return Boolean.valueOf(true);
    }

    public /* synthetic */ Object call() {
        return m6376a();
    }
}
