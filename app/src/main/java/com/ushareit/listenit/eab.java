package com.ushareit.listenit;

import java.util.concurrent.Executor;

class eab<TResult> implements ead<TResult> {
    private final Executor f10743a;
    private final Object f10744b = new Object();
    private dzm<? super TResult> f10745c;

    public eab(Executor executor, dzm<? super TResult> com_ushareit_listenit_dzm__super_TResult) {
        this.f10743a = executor;
        this.f10745c = com_ushareit_listenit_dzm__super_TResult;
    }

    public void mo2123a(dzo<TResult> com_ushareit_listenit_dzo_TResult) {
        if (com_ushareit_listenit_dzo_TResult.mo2130b()) {
            synchronized (this.f10744b) {
                if (this.f10745c == null) {
                    return;
                }
                this.f10743a.execute(new eac(this, com_ushareit_listenit_dzo_TResult));
            }
        }
    }
}
