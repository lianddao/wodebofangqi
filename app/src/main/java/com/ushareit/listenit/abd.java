package com.ushareit.listenit;

import java.io.InputStream;

public class abd {
    private final InputStream f4026a;

    public abd(InputStream inputStream) {
        this.f4026a = inputStream;
    }

    public int m5067a() {
        return ((this.f4026a.read() << 8) & 65280) | (this.f4026a.read() & 255);
    }

    public short m5070b() {
        return (short) (this.f4026a.read() & 255);
    }

    public long m5069a(long j) {
        if (j < 0) {
            return 0;
        }
        long j2 = j;
        while (j2 > 0) {
            long skip = this.f4026a.skip(j2);
            if (skip > 0) {
                j2 -= skip;
            } else if (this.f4026a.read() == -1) {
                break;
            } else {
                j2--;
            }
        }
        return j - j2;
    }

    public int m5068a(byte[] bArr) {
        int length = bArr.length;
        while (length > 0) {
            int read = this.f4026a.read(bArr, bArr.length - length, length);
            if (read == -1) {
                break;
            }
            length -= read;
        }
        return bArr.length - length;
    }

    public int m5071c() {
        return this.f4026a.read();
    }
}
