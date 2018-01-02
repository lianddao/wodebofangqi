package com.ushareit.listenit;

import java.io.File;
import java.io.FileFilter;

final class C0357g implements FileFilter {
    final /* synthetic */ String f13803a;

    C0357g(String str) {
        this.f13803a = str;
    }

    public boolean accept(File file) {
        return !file.getName().startsWith(this.f13803a);
    }
}
