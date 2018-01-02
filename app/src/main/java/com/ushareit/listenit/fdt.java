package com.ushareit.listenit;

import android.text.TextUtils;
import android.widget.SectionIndexer;

public class fdt extends fdu implements SectionIndexer {
    private String f12499a = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private gal f12500b;

    public fdt(gal com_ushareit_listenit_gal) {
        super(com_ushareit_listenit_gal);
        this.f12500b = com_ushareit_listenit_gal;
    }

    public int m18931a() {
        int a = this.f12500b.mo2565a();
        if (a == 0 || a == 5 || a == 6 || a == 7) {
            return 1;
        }
        return 0;
    }

    public int getPositionForSection(int i) {
        while (i >= 0) {
            char charAt = this.f12499a.charAt(i);
            for (int i2 = 0; i2 < getCount(); i2++) {
                Object c = m18923b(i2).mo2562c();
                if (!TextUtils.isEmpty(c) && m18930a(c.charAt(0)) == charAt) {
                    return i2 + m18931a();
                }
            }
            i--;
        }
        return m18931a();
    }

    private char m18930a(char c) {
        return ('a' > c || c > 'z') ? c : (char) (c - 32);
    }

    public int getSectionForPosition(int i) {
        return 0;
    }

    public Object[] getSections() {
        String[] strArr = new String[this.f12499a.length()];
        for (int i = 0; i < this.f12499a.length(); i++) {
            strArr[i] = String.valueOf(this.f12499a.charAt(i));
        }
        return strArr;
    }
}
