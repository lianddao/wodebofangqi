package com.ushareit.listenit;

import java.io.File;

class grx implements gxy {
    final /* synthetic */ grr f14621a;

    grx(grr com_ushareit_listenit_grr) {
        this.f14621a = com_ushareit_listenit_grr;
    }

    public boolean mo2682a(String[] strArr) {
        return strArr.length < 2000;
    }

    public boolean accept(File file) {
        if (!file.isDirectory()) {
            String absolutePath = file.getAbsolutePath();
            if (absolutePath.endsWith(".txt") || absolutePath.endsWith(".png")) {
                return false;
            }
            return true;
        } else if (new File(file.getAbsolutePath(), ".nomedia").exists()) {
            return false;
        } else {
            return true;
        }
    }
}
