package com.ushareit.listenit;

abstract class dnk {
    private final dni f9932a;

    protected dnk(dni com_ushareit_listenit_dni) {
        this.f9932a = com_ushareit_listenit_dni;
    }

    protected abstract void mo1989a();

    public final void m14917a(dnj com_ushareit_listenit_dnj) {
        com_ushareit_listenit_dnj.f10019i.lock();
        try {
            if (com_ushareit_listenit_dnj.f10024n == this.f9932a) {
                mo1989a();
                com_ushareit_listenit_dnj.f10019i.unlock();
            }
        } finally {
            com_ushareit_listenit_dnj.f10019i.unlock();
        }
    }
}
