package com.ushareit.listenit;

import java.io.File;
import java.util.Comparator;

final class ahc implements Comparator<File> {
    private ahc() {
    }

    public /* synthetic */ int compare(Object obj, Object obj2) {
        return m5619a((File) obj, (File) obj2);
    }

    public int m5619a(File file, File file2) {
        return m5618a(file.lastModified(), file2.lastModified());
    }

    private int m5618a(long j, long j2) {
        if (j < j2) {
            return -1;
        }
        return j == j2 ? 0 : 1;
    }
}
