package com.ushareit.listenit;

abstract class bws<T> {
    final /* synthetic */ bwj f7893f;

    bws(bwj com_ushareit_listenit_bwj) {
        this.f7893f = com_ushareit_listenit_bwj;
    }

    protected abstract T mo1177b();

    protected abstract T mo1178b(bxu com_ushareit_listenit_bxu);

    protected final T m10234c() {
        T t = null;
        bxu a = this.f7893f.m10217b();
        if (a == null) {
            bze.m10490c("ClientApi class cannot be loaded.");
        } else {
            try {
                t = mo1178b(a);
            } catch (Throwable e) {
                bze.m10491c("Cannot invoke local loader using ClientApi class", e);
            }
        }
        return t;
    }

    protected final T m10235d() {
        try {
            return mo1177b();
        } catch (Throwable e) {
            bze.m10491c("Cannot invoke remote loader", e);
            return null;
        }
    }
}
