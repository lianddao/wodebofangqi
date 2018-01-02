package com.ushareit.listenit;

import java.lang.reflect.Type;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

final class dae implements daz<Date>, dbi<Date> {
    private final DateFormat f9453a;
    private final DateFormat f9454b;
    private final DateFormat f9455c;

    dae() {
        this(DateFormat.getDateTimeInstance(2, 2, Locale.US), DateFormat.getDateTimeInstance(2, 2));
    }

    public dae(int i, int i2) {
        this(DateFormat.getDateTimeInstance(i, i2, Locale.US), DateFormat.getDateTimeInstance(i, i2));
    }

    dae(String str) {
        this(new SimpleDateFormat(str, Locale.US), new SimpleDateFormat(str));
    }

    dae(DateFormat dateFormat, DateFormat dateFormat2) {
        this.f9453a = dateFormat;
        this.f9454b = dateFormat2;
        this.f9455c = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.US);
        this.f9455c.setTimeZone(TimeZone.getTimeZone("UTC"));
    }

    private Date m13627a(dba com_ushareit_listenit_dba) {
        Date parse;
        synchronized (this.f9454b) {
            try {
                parse = this.f9454b.parse(com_ushareit_listenit_dba.mo1703c());
            } catch (ParseException e) {
                try {
                    parse = this.f9453a.parse(com_ushareit_listenit_dba.mo1703c());
                } catch (ParseException e2) {
                    try {
                        parse = this.f9455c.parse(com_ushareit_listenit_dba.mo1703c());
                    } catch (Throwable e3) {
                        throw new dbj(com_ushareit_listenit_dba.mo1703c(), e3);
                    }
                }
            }
        }
        return parse;
    }

    public dba m13629a(Date date, Type type, dbh com_ushareit_listenit_dbh) {
        dba com_ushareit_listenit_dbg;
        synchronized (this.f9454b) {
            com_ushareit_listenit_dbg = new dbg(this.f9453a.format(date));
        }
        return com_ushareit_listenit_dbg;
    }

    public Date m13630a(dba com_ushareit_listenit_dba, Type type, day com_ushareit_listenit_day) {
        if (com_ushareit_listenit_dba instanceof dbg) {
            Date a = m13627a(com_ushareit_listenit_dba);
            if (type == Date.class) {
                return a;
            }
            if (type == Timestamp.class) {
                return new Timestamp(a.getTime());
            }
            if (type == java.sql.Date.class) {
                return new java.sql.Date(a.getTime());
            }
            String valueOf = String.valueOf(getClass());
            String valueOf2 = String.valueOf(type);
            throw new IllegalArgumentException(new StringBuilder((String.valueOf(valueOf).length() + 23) + String.valueOf(valueOf2).length()).append(valueOf).append(" cannot deserialize to ").append(valueOf2).toString());
        }
        throw new dbe("The date should be a string value");
    }

    public /* synthetic */ Object mo1700b(dba com_ushareit_listenit_dba, Type type, day com_ushareit_listenit_day) {
        return m13630a(com_ushareit_listenit_dba, type, com_ushareit_listenit_day);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(dae.class.getSimpleName());
        stringBuilder.append('(').append(this.f9454b.getClass().getSimpleName()).append(')');
        return stringBuilder.toString();
    }
}
