package com.ushareit.listenit;

import java.sql.Timestamp;
import java.util.Date;

class des extends dbq<Timestamp> {
    final /* synthetic */ dbq f9715a;
    final /* synthetic */ der f9716b;

    des(der com_ushareit_listenit_der, dbq com_ushareit_listenit_dbq) {
        this.f9716b = com_ushareit_listenit_der;
        this.f9715a = com_ushareit_listenit_dbq;
    }

    public Timestamp m14030a(dfu com_ushareit_listenit_dfu) {
        Date date = (Date) this.f9715a.mo1401b(com_ushareit_listenit_dfu);
        return date != null ? new Timestamp(date.getTime()) : null;
    }

    public void m14032a(dfx com_ushareit_listenit_dfx, Timestamp timestamp) {
        this.f9715a.mo1400a(com_ushareit_listenit_dfx, timestamp);
    }

    public /* synthetic */ Object mo1401b(dfu com_ushareit_listenit_dfu) {
        return m14030a(com_ushareit_listenit_dfu);
    }
}
