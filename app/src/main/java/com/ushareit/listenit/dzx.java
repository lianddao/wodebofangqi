package com.ushareit.listenit;

import java.util.concurrent.Executor;

class dzx<TResult> implements ead<TResult> {
    private final Executor f10733a;
    private final Object f10734b = new Object();
    private dzk<TResult> f10735c;

    public dzx(Executor executor, dzk<TResult> com_ushareit_listenit_dzk_TResult) {
        this.f10733a = executor;
        this.f10735c = com_ushareit_listenit_dzk_TResult;
    }

    public void mo2123a(dzo<TResult> com_ushareit_listenit_dzo_TResult) {
        synchronized (this.f10734b) {
            if (this.f10735c == null) {
                return;
            }
            this.f10733a.execute(new dzy(this, com_ushareit_listenit_dzo_TResult));
        }
    }
}
