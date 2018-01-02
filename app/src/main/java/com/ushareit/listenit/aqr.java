package com.ushareit.listenit;

import java.io.File;
import java.util.Comparator;

final class aqr implements Comparator<File> {
    private aqr() {
    }

    private int m6809a(long j, long j2) {
        return j < j2 ? -1 : j == j2 ? 0 : 1;
    }

    public int m6810a(File file, File file2) {
        return m6809a(file.lastModified(), file2.lastModified());
    }

    public /* synthetic */ int compare(Object obj, Object obj2) {
        return m6810a((File) obj, (File) obj2);
    }
}
