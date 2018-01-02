package com.ushareit.listenit;

class cnb implements Runnable {
    final /* synthetic */ String f8489a;
    final /* synthetic */ Throwable f8490b;
    final /* synthetic */ cna f8491c;

    cnb(cna com_ushareit_listenit_cna, String str, Throwable th) {
        this.f8491c = com_ushareit_listenit_cna;
        this.f8489a = str;
        this.f8490b = th;
    }

    public void run() {
        throw new RuntimeException(this.f8489a, this.f8490b);
    }
}
