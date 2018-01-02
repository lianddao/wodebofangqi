package com.ushareit.listenit;

class cmu implements dzl {
    final /* synthetic */ cpx f8474a;
    final /* synthetic */ cmt f8475b;

    cmu(cmt com_ushareit_listenit_cmt, cpx com_ushareit_listenit_cpx) {
        this.f8475b = com_ushareit_listenit_cmt;
        this.f8474a = com_ushareit_listenit_cpx;
    }

    private boolean m11764b(Exception exception) {
        return (exception instanceof eag) || (exception instanceof cza);
    }

    public void mo1447a(Exception exception) {
        if (m11764b(exception)) {
            this.f8474a.mo1548a(null);
        } else {
            this.f8474a.mo1549b(exception.getMessage());
        }
    }
}
