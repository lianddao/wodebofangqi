package com.ushareit.listenit;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class abc {
    private final ByteBuffer f4025a;

    public abc(byte[] bArr) {
        this.f4025a = ByteBuffer.wrap(bArr);
        this.f4025a.order(ByteOrder.BIG_ENDIAN);
    }

    public void m5065a(ByteOrder byteOrder) {
        this.f4025a.order(byteOrder);
    }

    public int m5063a() {
        return this.f4025a.array().length;
    }

    public int m5064a(int i) {
        return this.f4025a.getInt(i);
    }

    public short m5066b(int i) {
        return this.f4025a.getShort(i);
    }
}
