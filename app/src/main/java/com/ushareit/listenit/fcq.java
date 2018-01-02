package com.ushareit.listenit;

import android.content.Context;
import android.database.Cursor;

public final class fcq {
    public static final long m18860a(long j, String str) {
        if (j > 0) {
            return j;
        }
        eyh a = eyh.m18491a(str);
        exu.m18433a(a.mo2328c());
        return a.mo2332g();
    }

    public static String[] m18862a(fcg com_ushareit_listenit_fcg) {
        switch (com_ushareit_listenit_fcg) {
            case PHOTO:
                return fct.f12445a;
            case MUSIC:
                return fcs.f12444a;
            case VIDEO:
                return fcu.f12446a;
            default:
                return null;
        }
    }

    public static fcb m18861a(Context context, fcg com_ushareit_listenit_fcg, Cursor cursor) {
        switch (com_ushareit_listenit_fcg) {
            case PHOTO:
                return fct.m18864a(cursor);
            case MUSIC:
                return fcs.m18863a(cursor);
            case VIDEO:
                return fcu.m18865a(cursor);
            default:
                return null;
        }
    }
}
