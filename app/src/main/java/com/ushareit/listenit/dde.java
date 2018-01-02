package com.ushareit.listenit;

import java.io.Writer;

final class dde extends Writer {
    private final Appendable f9582a;
    private final ddf f9583b;

    private dde(Appendable appendable) {
        this.f9583b = new ddf();
        this.f9582a = appendable;
    }

    public void close() {
    }

    public void flush() {
    }

    public void write(int i) {
        this.f9582a.append((char) i);
    }

    public void write(char[] cArr, int i, int i2) {
        this.f9583b.f9584a = cArr;
        this.f9582a.append(this.f9583b, i, i + i2);
    }
}
