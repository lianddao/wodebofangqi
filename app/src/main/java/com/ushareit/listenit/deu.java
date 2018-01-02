package com.ushareit.listenit;

import java.util.Locale;
import java.util.StringTokenizer;

final class deu extends dbq<Locale> {
    deu() {
    }

    public Locale m14038a(dfu com_ushareit_listenit_dfu) {
        if (com_ushareit_listenit_dfu.mo1718f() == dfw.NULL) {
            com_ushareit_listenit_dfu.mo1722j();
            return null;
        }
        StringTokenizer stringTokenizer = new StringTokenizer(com_ushareit_listenit_dfu.mo1720h(), "_");
        String nextToken = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
        String nextToken2 = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
        String nextToken3 = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
        return (nextToken2 == null && nextToken3 == null) ? new Locale(nextToken) : nextToken3 == null ? new Locale(nextToken, nextToken2) : new Locale(nextToken, nextToken2, nextToken3);
    }

    public void m14040a(dfx com_ushareit_listenit_dfx, Locale locale) {
        com_ushareit_listenit_dfx.mo1735b(locale == null ? null : locale.toString());
    }

    public /* synthetic */ Object mo1401b(dfu com_ushareit_listenit_dfu) {
        return m14038a(com_ushareit_listenit_dfu);
    }
}
