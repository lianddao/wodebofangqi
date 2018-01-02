package com.ushareit.listenit;

import java.util.concurrent.Callable;

class are implements Callable<Boolean> {
    final /* synthetic */ ara f5224a;
    private final String f5225b;

    public are(ara com_ushareit_listenit_ara, String str) {
        this.f5224a = com_ushareit_listenit_ara;
        this.f5225b = str;
    }

    public Boolean m6880a() {
        return Boolean.valueOf(this.f5224a.m6865c(this.f5225b));
    }

    public /* synthetic */ Object call() {
        return m6880a();
    }
}
