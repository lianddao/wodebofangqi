package com.ushareit.listenit;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public final class def extends dbq<Date> {
    public static final dbr f9664a = new deg();
    private final DateFormat f9665b = new SimpleDateFormat("MMM d, yyyy");

    public synchronized Date m13987a(dfu com_ushareit_listenit_dfu) {
        Date date;
        if (com_ushareit_listenit_dfu.mo1718f() == dfw.NULL) {
            com_ushareit_listenit_dfu.mo1722j();
            date = null;
        } else {
            try {
                date = new Date(this.f9665b.parse(com_ushareit_listenit_dfu.mo1720h()).getTime());
            } catch (Throwable e) {
                throw new dbj(e);
            }
        }
        return date;
    }

    public synchronized void m13989a(dfx com_ushareit_listenit_dfx, Date date) {
        com_ushareit_listenit_dfx.mo1735b(date == null ? null : this.f9665b.format(date));
    }

    public /* synthetic */ Object mo1401b(dfu com_ushareit_listenit_dfu) {
        return m13987a(com_ushareit_listenit_dfu);
    }
}
