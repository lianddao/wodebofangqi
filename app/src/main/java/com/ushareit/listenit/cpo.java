package com.ushareit.listenit;

class cpo implements Runnable {
    final /* synthetic */ cpn f8651a;

    cpo(cpn com_ushareit_listenit_cpn) {
        this.f8651a = com_ushareit_listenit_cpn;
    }

    public void run() {
        this.f8651a.f8649a.f8643i.cancel(false);
        this.f8651a.f8649a.f8637c = true;
        if (this.f8651a.f8649a.f8646l.m13094a()) {
            this.f8651a.f8649a.f8646l.m13093a("websocket opened", new Object[0]);
        }
        this.f8651a.f8649a.m12185d();
    }
}
