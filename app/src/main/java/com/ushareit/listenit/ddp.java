package com.ushareit.listenit;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public final class ddp extends dbq<Date> {
    public static final dbr f9596a = new ddq();
    private final DateFormat f9597b = DateFormat.getDateTimeInstance(2, 2, Locale.US);
    private final DateFormat f9598c = DateFormat.getDateTimeInstance(2, 2);
    private final DateFormat f9599d = m13848a();

    private static DateFormat m13848a() {
        DateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.US);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        return simpleDateFormat;
    }

    private synchronized Date m13849a(String str) {
        Date parse;
        try {
            parse = this.f9598c.parse(str);
        } catch (ParseException e) {
            try {
                parse = this.f9597b.parse(str);
            } catch (ParseException e2) {
                try {
                    parse = this.f9599d.parse(str);
                } catch (Throwable e3) {
                    throw new dbj(str, e3);
                }
            }
        }
        return parse;
    }

    public Date m13850a(dfu com_ushareit_listenit_dfu) {
        if (com_ushareit_listenit_dfu.mo1718f() != dfw.NULL) {
            return m13849a(com_ushareit_listenit_dfu.mo1720h());
        }
        com_ushareit_listenit_dfu.mo1722j();
        return null;
    }

    public synchronized void m13852a(dfx com_ushareit_listenit_dfx, Date date) {
        if (date == null) {
            com_ushareit_listenit_dfx.mo1740f();
        } else {
            com_ushareit_listenit_dfx.mo1735b(this.f9597b.format(date));
        }
    }

    public /* synthetic */ Object mo1401b(dfu com_ushareit_listenit_dfu) {
        return m13850a(com_ushareit_listenit_dfu);
    }
}
