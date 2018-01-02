package com.ushareit.listenit;

import java.io.File;
import java.util.concurrent.Callable;

class ahe implements Callable<Void> {
    final /* synthetic */ ahd f4359a;
    private final File f4360b;

    public /* synthetic */ Object call() {
        return m5626a();
    }

    public ahe(ahd com_ushareit_listenit_ahd, File file) {
        this.f4359a = com_ushareit_listenit_ahd;
        this.f4360b = file;
    }

    public Void m5626a() {
        this.f4359a.m5623b(this.f4360b);
        return null;
    }
}
