package com.ushareit.listenit;

import com.mopub.common.DiskLruCache;
import com.mopub.common.DiskLruCache.Editor;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public final class egn {
    final /* synthetic */ DiskLruCache f11038a;
    private final String f11039b;
    private final long[] f11040c;
    private boolean f11041d;
    private Editor f11042e;
    private long f11043f;

    private egn(DiskLruCache diskLruCache, String str) {
        this.f11038a = diskLruCache;
        this.f11039b = str;
        this.f11040c = new long[diskLruCache.f2104i];
    }

    public String getLengths() {
        StringBuilder stringBuilder = new StringBuilder();
        for (long append : this.f11040c) {
            stringBuilder.append(' ').append(append);
        }
        return stringBuilder.toString();
    }

    private void m17062a(String[] strArr) {
        if (strArr.length != this.f11038a.f2104i) {
            throw m17064b(strArr);
        }
        int i = 0;
        while (i < strArr.length) {
            try {
                this.f11040c[i] = Long.parseLong(strArr[i]);
                i++;
            } catch (NumberFormatException e) {
                throw m17064b(strArr);
            }
        }
    }

    private IOException m17064b(String[] strArr) {
        throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
    }

    public File getCleanFile(int i) {
        return new File(this.f11038a.f2098c, this.f11039b + "." + i);
    }

    public File getDirtyFile(int i) {
        return new File(this.f11038a.f2098c, this.f11039b + "." + i + ".tmp");
    }
}
