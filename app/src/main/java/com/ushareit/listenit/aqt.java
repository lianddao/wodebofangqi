package com.ushareit.listenit;

import java.io.File;
import java.util.concurrent.Callable;

class aqt implements Callable<Void> {
    final /* synthetic */ aqs f5190a;
    private final File f5191b;

    public aqt(aqs com_ushareit_listenit_aqs, File file) {
        this.f5190a = com_ushareit_listenit_aqs;
        this.f5191b = file;
    }

    public Void m6817a() {
        this.f5190a.m6814b(this.f5191b);
        return null;
    }

    public /* synthetic */ Object call() {
        return m6817a();
    }
}
