package com.ushareit.listenit;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class cvw implements cvz {
    private final Set<String> f9232a;
    private final cwa f9233b;

    public cvw(cwa com_ushareit_listenit_cwa, List<String> list) {
        if (list != null) {
            this.f9232a = new HashSet(list);
        } else {
            this.f9232a = null;
        }
        this.f9233b = com_ushareit_listenit_cwa;
    }

    public cwa mo1622a() {
        return this.f9233b;
    }

    protected String mo1624a(cwa com_ushareit_listenit_cwa, String str, String str2, long j) {
        String valueOf = String.valueOf(new Date(j).toString());
        String valueOf2 = String.valueOf(com_ushareit_listenit_cwa);
        return new StringBuilder((((String.valueOf(valueOf).length() + 6) + String.valueOf(valueOf2).length()) + String.valueOf(str).length()) + String.valueOf(str2).length()).append(valueOf).append(" [").append(valueOf2).append("] ").append(str).append(": ").append(str2).toString();
    }

    protected void mo1625a(String str, String str2) {
        System.err.println(str2);
    }

    protected boolean m13077a(cwa com_ushareit_listenit_cwa, String str) {
        return com_ushareit_listenit_cwa.ordinal() >= this.f9233b.ordinal() && (this.f9232a == null || com_ushareit_listenit_cwa.ordinal() > cwa.DEBUG.ordinal() || this.f9232a.contains(str));
    }

    public void mo1623b(cwa com_ushareit_listenit_cwa, String str, String str2, long j) {
        if (m13077a(com_ushareit_listenit_cwa, str)) {
            String a = mo1624a(com_ushareit_listenit_cwa, str, str2, j);
            switch (cvx.f9234a[com_ushareit_listenit_cwa.ordinal()]) {
                case 1:
                    mo1625a(str, a);
                    return;
                case 2:
                    mo1626b(str, a);
                    return;
                case 3:
                    mo1627c(str, a);
                    return;
                case 4:
                    mo1628d(str, a);
                    return;
                default:
                    throw new RuntimeException("Should not reach here!");
            }
        }
    }

    protected void mo1626b(String str, String str2) {
        System.out.println(str2);
    }

    protected void mo1627c(String str, String str2) {
        System.out.println(str2);
    }

    protected void mo1628d(String str, String str2) {
        System.out.println(str2);
    }
}
