package com.ushareit.listenit;

import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public final class deh extends dbq<Time> {
    public static final dbr f9666a = new dei();
    private final DateFormat f9667b = new SimpleDateFormat("hh:mm:ss a");

    public synchronized Time m13992a(dfu com_ushareit_listenit_dfu) {
        Time time;
        if (com_ushareit_listenit_dfu.mo1718f() == dfw.NULL) {
            com_ushareit_listenit_dfu.mo1722j();
            time = null;
        } else {
            try {
                time = new Time(this.f9667b.parse(com_ushareit_listenit_dfu.mo1720h()).getTime());
            } catch (Throwable e) {
                throw new dbj(e);
            }
        }
        return time;
    }

    public synchronized void m13994a(dfx com_ushareit_listenit_dfx, Time time) {
        com_ushareit_listenit_dfx.mo1735b(time == null ? null : this.f9667b.format(time));
    }

    public /* synthetic */ Object mo1401b(dfu com_ushareit_listenit_dfu) {
        return m13992a(com_ushareit_listenit_dfu);
    }
}
