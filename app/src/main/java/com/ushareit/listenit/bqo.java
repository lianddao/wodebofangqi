package com.ushareit.listenit;

import android.os.Handler;
import java.util.concurrent.CopyOnWriteArraySet;

public abstract class bqo<T> {
    private final Handler f7407a;
    private final CopyOnWriteArraySet<bqq<? super T>> f7408b = new CopyOnWriteArraySet();
    private bqr f7409c;
    private bqn<T> f7410d;

    public abstract bqn<T> mo1083a(bfy[] com_ushareit_listenit_bfyArr, bok com_ushareit_listenit_bok);

    public bqo(Handler handler) {
        this.f7407a = (Handler) bsg.m9654a((Object) handler);
    }

    public final void m9506a(bqq<? super T> com_ushareit_listenit_bqq__super_T) {
        this.f7408b.add(com_ushareit_listenit_bqq__super_T);
    }

    public final void m9507a(bqr com_ushareit_listenit_bqr) {
        this.f7409c = com_ushareit_listenit_bqr;
    }

    public final void m9505a(bqn<T> com_ushareit_listenit_bqn_T) {
        this.f7410d = com_ushareit_listenit_bqn_T;
        m9503b(com_ushareit_listenit_bqn_T);
    }

    private void m9503b(bqn<T> com_ushareit_listenit_bqn_T) {
        if (this.f7407a != null) {
            this.f7407a.post(new bqp(this, com_ushareit_listenit_bqn_T));
        }
    }
}
