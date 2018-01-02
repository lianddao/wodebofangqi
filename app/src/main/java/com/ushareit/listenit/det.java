package com.ushareit.listenit;

import java.util.Calendar;
import java.util.GregorianCalendar;

final class det extends dbq<Calendar> {
    det() {
    }

    public Calendar m14034a(dfu com_ushareit_listenit_dfu) {
        int i = 0;
        if (com_ushareit_listenit_dfu.mo1718f() == dfw.NULL) {
            com_ushareit_listenit_dfu.mo1722j();
            return null;
        }
        com_ushareit_listenit_dfu.mo1714c();
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        while (com_ushareit_listenit_dfu.mo1718f() != dfw.END_OBJECT) {
            String g = com_ushareit_listenit_dfu.mo1719g();
            int m = com_ushareit_listenit_dfu.mo1725m();
            if ("year".equals(g)) {
                i6 = m;
            } else if ("month".equals(g)) {
                i5 = m;
            } else if ("dayOfMonth".equals(g)) {
                i4 = m;
            } else if ("hourOfDay".equals(g)) {
                i3 = m;
            } else if ("minute".equals(g)) {
                i2 = m;
            } else if ("second".equals(g)) {
                i = m;
            }
        }
        com_ushareit_listenit_dfu.mo1716d();
        return new GregorianCalendar(i6, i5, i4, i3, i2, i);
    }

    public void m14036a(dfx com_ushareit_listenit_dfx, Calendar calendar) {
        if (calendar == null) {
            com_ushareit_listenit_dfx.mo1740f();
            return;
        }
        com_ushareit_listenit_dfx.mo1738d();
        com_ushareit_listenit_dfx.mo1732a("year");
        com_ushareit_listenit_dfx.mo1730a((long) calendar.get(1));
        com_ushareit_listenit_dfx.mo1732a("month");
        com_ushareit_listenit_dfx.mo1730a((long) calendar.get(2));
        com_ushareit_listenit_dfx.mo1732a("dayOfMonth");
        com_ushareit_listenit_dfx.mo1730a((long) calendar.get(5));
        com_ushareit_listenit_dfx.mo1732a("hourOfDay");
        com_ushareit_listenit_dfx.mo1730a((long) calendar.get(11));
        com_ushareit_listenit_dfx.mo1732a("minute");
        com_ushareit_listenit_dfx.mo1730a((long) calendar.get(12));
        com_ushareit_listenit_dfx.mo1732a("second");
        com_ushareit_listenit_dfx.mo1730a((long) calendar.get(13));
        com_ushareit_listenit_dfx.mo1739e();
    }

    public /* synthetic */ Object mo1401b(dfu com_ushareit_listenit_dfu) {
        return m14034a(com_ushareit_listenit_dfu);
    }
}
