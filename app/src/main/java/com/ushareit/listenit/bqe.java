package com.ushareit.listenit;

import com.google.android.exoplayer2.Format;
import java.util.Comparator;

final class bqe implements Comparator<Format> {
    private bqe() {
    }

    public /* synthetic */ int compare(Object obj, Object obj2) {
        return m9501a((Format) obj, (Format) obj2);
    }

    public int m9501a(Format format, Format format2) {
        return format2.f1428b - format.f1428b;
    }
}
