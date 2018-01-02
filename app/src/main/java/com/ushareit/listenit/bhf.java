package com.ushareit.listenit;

import java.nio.ByteBuffer;

public class bhf extends bhb {
    public final bhc f6320a = new bhc();
    public ByteBuffer f6321b;
    public long f6322c;
    private final int f6323d;

    public bhf(int i) {
        this.f6323d = i;
    }

    public void m8400e(int i) {
        if (this.f6321b == null) {
            this.f6321b = m8396f(i);
            return;
        }
        int capacity = this.f6321b.capacity();
        int position = this.f6321b.position();
        int i2 = position + i;
        if (capacity < i2) {
            ByteBuffer f = m8396f(i2);
            if (position > 0) {
                this.f6321b.position(0);
                this.f6321b.limit(position);
                f.put(this.f6321b);
            }
            this.f6321b = f;
        }
    }

    public final boolean m8398d() {
        return m8385d(1073741824);
    }

    public final void m8399e() {
        this.f6321b.flip();
    }

    public void mo951a() {
        super.mo951a();
        if (this.f6321b != null) {
            this.f6321b.clear();
        }
    }

    private ByteBuffer m8396f(int i) {
        if (this.f6323d == 1) {
            return ByteBuffer.allocate(i);
        }
        if (this.f6323d == 2) {
            return ByteBuffer.allocateDirect(i);
        }
        throw new IllegalStateException("Buffer too small (" + (this.f6321b == null ? 0 : this.f6321b.capacity()) + " < " + i + ")");
    }
}
