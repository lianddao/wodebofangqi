package com.ushareit.listenit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;

class dwe {
    final int f10462a;
    final boolean f10463b;
    final String f10464c;
    final List<String> f10465d;
    final String f10466e;
    final boolean f10467f;

    public dwe(drk com_ushareit_listenit_drk) {
        boolean z;
        boolean z2 = false;
        cfi.m11080a((Object) com_ushareit_listenit_drk);
        if (com_ushareit_listenit_drk.f10202a == null || com_ushareit_listenit_drk.f10202a.intValue() == 0) {
            z = false;
        } else {
            if (com_ushareit_listenit_drk.f10202a.intValue() == 6) {
                if (com_ushareit_listenit_drk.f10205d == null || com_ushareit_listenit_drk.f10205d.length == 0) {
                    z = false;
                }
            } else if (com_ushareit_listenit_drk.f10203b == null) {
                z = false;
            }
            z = true;
        }
        if (z) {
            this.f10462a = com_ushareit_listenit_drk.f10202a.intValue();
            if (com_ushareit_listenit_drk.f10204c != null && com_ushareit_listenit_drk.f10204c.booleanValue()) {
                z2 = true;
            }
            this.f10463b = z2;
            if (this.f10463b || this.f10462a == 1 || this.f10462a == 6) {
                this.f10464c = com_ushareit_listenit_drk.f10203b;
            } else {
                this.f10464c = com_ushareit_listenit_drk.f10203b.toUpperCase(Locale.ENGLISH);
            }
            this.f10465d = com_ushareit_listenit_drk.f10205d == null ? null : m15883a(com_ushareit_listenit_drk.f10205d, this.f10463b);
            if (this.f10462a == 1) {
                this.f10466e = this.f10464c;
            } else {
                this.f10466e = null;
            }
        } else {
            this.f10462a = 0;
            this.f10463b = false;
            this.f10464c = null;
            this.f10465d = null;
            this.f10466e = null;
        }
        this.f10467f = z;
    }

    private List<String> m15883a(String[] strArr, boolean z) {
        if (z) {
            return Arrays.asList(strArr);
        }
        List<String> arrayList = new ArrayList();
        for (String toUpperCase : strArr) {
            arrayList.add(toUpperCase.toUpperCase(Locale.ENGLISH));
        }
        return arrayList;
    }

    public Boolean m15884a(String str) {
        if (!this.f10467f || str == null) {
            return null;
        }
        if (!(this.f10463b || this.f10462a == 1)) {
            str = str.toUpperCase(Locale.ENGLISH);
        }
        switch (this.f10462a) {
            case 1:
                return Boolean.valueOf(Pattern.compile(this.f10466e, this.f10463b ? 0 : 66).matcher(str).matches());
            case 2:
                return Boolean.valueOf(str.startsWith(this.f10464c));
            case 3:
                return Boolean.valueOf(str.endsWith(this.f10464c));
            case 4:
                return Boolean.valueOf(str.contains(this.f10464c));
            case 5:
                return Boolean.valueOf(str.equals(this.f10464c));
            case 6:
                return Boolean.valueOf(this.f10465d.contains(str));
            default:
                return null;
        }
    }
}
