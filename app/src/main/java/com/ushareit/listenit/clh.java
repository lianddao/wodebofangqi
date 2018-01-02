package com.ushareit.listenit;

import com.google.android.gms.common.api.Status;

class clh<ResultT, CallbackT> extends dos<cln, ResultT> implements cmd<ResultT> {
    final /* synthetic */ cld f8420a;
    private cme<ResultT, CallbackT> f8421b;
    private dzp<ResultT> f8422c;

    public clh(cld com_ushareit_listenit_cld, cme<ResultT, CallbackT> com_ushareit_listenit_cme_ResultT__CallbackT) {
        this.f8420a = com_ushareit_listenit_cld;
        this.f8421b = com_ushareit_listenit_cme_ResultT__CallbackT;
        this.f8421b.m11550a((cmd) this);
    }

    protected /* synthetic */ void mo1396a(cdq com_ushareit_listenit_cdq, dzp com_ushareit_listenit_dzp) {
        m11569a((cln) com_ushareit_listenit_cdq, com_ushareit_listenit_dzp);
    }

    protected void m11569a(cln com_ushareit_listenit_cln, dzp<ResultT> com_ushareit_listenit_dzp_ResultT) {
        this.f8422c = com_ushareit_listenit_dzp_ResultT;
        this.f8421b.m11556a(com_ushareit_listenit_cln.mo1281f());
    }

    public final void mo1397a(ResultT resultT, Status status) {
        cfi.m11081a(this.f8422c, (Object) "doExecute must be called before onComplete");
        if (status != null) {
            this.f8422c.m16567a(clp.m11601a(status));
        } else {
            this.f8422c.m16568a((Object) resultT);
        }
    }
}
