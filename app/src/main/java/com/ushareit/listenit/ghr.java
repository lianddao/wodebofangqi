package com.ushareit.listenit;

import java.io.File;
import java.util.Locale;

class ghr implements gxy {
    private ghr() {
    }

    public boolean accept(File file) {
        if (file.isDirectory()) {
            String toLowerCase = file.getAbsolutePath().toLowerCase(Locale.US);
            for (String endsWith : ghp.f14132c) {
                if (toLowerCase.endsWith(endsWith)) {
                    return false;
                }
            }
            return true;
        }
        String e = gyn.m23235e(file.getAbsolutePath());
        if (fbb.m18763c(e) || !e.equals("lrc") || file.length() >= 512000) {
            return false;
        }
        return true;
    }

    public boolean mo2682a(String[] strArr) {
        return strArr != null && strArr.length < 2000;
    }
}
