package com.ushareit.listenit;

import java.io.File;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public abstract class ahd implements agx {
    private static final hjm f4357a = hjn.m23936a("LruDiskUsage");
    private final ExecutorService f4358b = Executors.newSingleThreadExecutor();

    protected abstract boolean mo630a(File file, long j, int i);

    public void mo628a(File file) {
        this.f4358b.submit(new ahe(this, file));
    }

    private void m5623b(File file) {
        aha.m5615c(file);
        m5621a(aha.m5614b(file.getParentFile()));
    }

    private void m5621a(List<File> list) {
        long b = m5622b((List) list);
        int size = list.size();
        int i = size;
        for (File file : list) {
            if (!mo630a(file, b, i)) {
                long length = file.length();
                if (file.delete()) {
                    i--;
                    b -= length;
                    f4357a.mo2793b("Cache file " + file + " is deleted because it exceeds cache limit");
                    size = i;
                    i = size;
                } else {
                    f4357a.mo2795d("Error deleting file " + file + " for trimming cache");
                }
            }
            size = i;
            i = size;
        }
    }

    private long m5622b(List<File> list) {
        long j = 0;
        for (File length : list) {
            j = length.length() + j;
        }
        return j;
    }
}
