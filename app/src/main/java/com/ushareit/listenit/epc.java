package com.ushareit.listenit;

import java.io.FilterInputStream;
import java.io.InputStream;

public class epc extends FilterInputStream {
    private int f11416a;

    private epc(InputStream inputStream) {
        super(inputStream);
        this.f11416a = 0;
    }

    public int read() {
        int read = super.read();
        if (read != -1) {
            this.f11416a++;
        }
        return read;
    }

    public int read(byte[] bArr, int i, int i2) {
        int read = super.read(bArr, i, i2);
        if (read != -1) {
            this.f11416a += read;
        }
        return read;
    }
}
