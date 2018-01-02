package com.ushareit.listenit;

import android.text.TextUtils;

public class ahf implements agz {
    public String mo629a(String str) {
        Object b = m5627b(str);
        String d = agt.m5600d(str);
        return TextUtils.isEmpty(b) ? d : d + "." + b;
    }

    private String m5627b(String str) {
        int lastIndexOf = str.lastIndexOf(46);
        return (lastIndexOf == -1 || lastIndexOf <= str.lastIndexOf(47) || (lastIndexOf + 2) + 4 <= str.length()) ? "" : str.substring(lastIndexOf + 1, str.length());
    }
}
