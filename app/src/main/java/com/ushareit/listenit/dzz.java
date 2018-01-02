package com.ushareit.listenit;

import java.util.concurrent.Executor;

class dzz<TResult> implements ead<TResult> {
    private final Executor f10738a;
    private final Object f10739b = new Object();
    private dzl f10740c;

    public dzz(Executor executor, dzl com_ushareit_listenit_dzl) {
        this.f10738a = executor;
        this.f10740c = com_ushareit_listenit_dzl;
    }

    public void mo2123a(dzo<TResult> com_ushareit_listenit_dzo_TResult) {
        if (!com_ushareit_listenit_dzo_TResult.mo2130b()) {
            synchronized (this.f10739b) {
                if (this.f10740c == null) {
                    return;
                }
                this.f10738a.execute(new eaa(this, com_ushareit_listenit_dzo_TResult));
            }
        }
    }
}
