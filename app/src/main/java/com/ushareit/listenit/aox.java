package com.ushareit.listenit;

class aox implements Runnable {
    final /* synthetic */ aow f5122a;

    aox(aow com_ushareit_listenit_aow) {
        this.f5122a = com_ushareit_listenit_aow;
    }

    public void run() {
        this.f5122a.f5119k = false;
        if (this.f5122a.f5112d.getQueue().isEmpty()) {
            new aoy(this).executeOnExecutor(this.f5122a.f5112d, new Void[0]);
        }
    }
}
