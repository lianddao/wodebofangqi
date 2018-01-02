package com.ushareit.listenit;

import android.text.TextUtils;

public class aqu implements aqo {
    private String m6818b(String str) {
        int lastIndexOf = str.lastIndexOf(46);
        return (lastIndexOf == -1 || lastIndexOf <= str.lastIndexOf(47) || (lastIndexOf + 2) + 4 <= str.length()) ? "" : str.substring(lastIndexOf + 1, str.length());
    }

    public String mo784a(String str) {
        Object b = m6818b(str);
        String d = arq.m6909d(str);
        return TextUtils.isEmpty(b) ? d : d + "." + b;
    }
}
