package com.ushareit.listenit;

import android.util.Log;
import java.io.File;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

abstract class aqs implements aqm {
    private final ExecutorService f5189a = Executors.newSingleThreadExecutor();

    aqs() {
    }

    private void m6812a(List<File> list) {
        long b = m6813b((List) list);
        int size = list.size();
        int i = size;
        for (File file : list) {
            if (!mo785a(file, b, i)) {
                long length = file.length();
                if (file.delete()) {
                    i--;
                    b -= length;
                    Log.i("ProxyCache", "Cache file " + file + " is deleted because it exceeds cache limit");
                    size = i;
                    i = size;
                } else {
                    Log.e("ProxyCache", "Error deleting file " + file + " for trimming cache");
                }
            }
            size = i;
            i = size;
        }
    }

    private long m6813b(List<File> list) {
        long j = 0;
        for (File length : list) {
            j = length.length() + j;
        }
        return j;
    }

    private void m6814b(File file) {
        aqp.m6806c(file);
        m6812a(aqp.m6805b(file.getParentFile()));
    }

    public void mo783a(File file) {
        this.f5189a.submit(new aqt(this, file));
    }

    protected abstract boolean mo785a(File file, long j, int i);
}
