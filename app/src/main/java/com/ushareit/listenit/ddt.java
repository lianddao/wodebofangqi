package com.ushareit.listenit;

import java.io.Reader;

final class ddt extends Reader {
    ddt() {
    }

    public void close() {
        throw new AssertionError();
    }

    public int read(char[] cArr, int i, int i2) {
        throw new AssertionError();
    }
}
