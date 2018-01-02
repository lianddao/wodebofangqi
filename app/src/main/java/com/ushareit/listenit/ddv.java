package com.ushareit.listenit;

import java.io.Writer;

final class ddv extends Writer {
    ddv() {
    }

    public void close() {
        throw new AssertionError();
    }

    public void flush() {
        throw new AssertionError();
    }

    public void write(char[] cArr, int i, int i2) {
        throw new AssertionError();
    }
}
