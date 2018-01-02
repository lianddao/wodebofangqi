package com.ushareit.listenit;

import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.WritableByteChannel;
import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

class cyc {
    private BlockingQueue<ByteBuffer> f9350a;
    private final Random f9351b = new Random();
    private volatile boolean f9352c = false;
    private boolean f9353d = false;
    private cxs f9354e;
    private WritableByteChannel f9355f;
    private final Thread f9356g = cxs.m13315a().newThread(new cyd(this));

    cyc(cxs com_ushareit_listenit_cxs, String str, int i) {
        cxs.m13319b().mo1554a(m13359b(), new StringBuilder(String.valueOf(str).length() + 18).append(str).append("Writer-").append(i).toString());
        this.f9354e = com_ushareit_listenit_cxs;
        this.f9350a = new LinkedBlockingQueue();
    }

    private void m13350a(cxy com_ushareit_listenit_cxy) {
        this.f9354e.m13325a(com_ushareit_listenit_cxy);
    }

    private ByteBuffer m13352b(byte b, boolean z, byte[] bArr) {
        int i = 2;
        if (z) {
            i = 6;
        }
        int length = bArr.length;
        if (length >= 126) {
            i = length <= 65535 ? i + 2 : i + 8;
        }
        ByteBuffer allocate = ByteBuffer.allocate(i + bArr.length);
        allocate.put((byte) (b | -128));
        if (length < 126) {
            allocate.put((byte) (z ? length | 128 : length));
        } else if (length <= 65535) {
            allocate.put((byte) (z ? 254 : 126));
            allocate.putShort((short) length);
        } else {
            i = 127;
            if (z) {
                i = 255;
            }
            allocate.put((byte) i);
            allocate.putInt(0);
            allocate.putInt(length);
        }
        if (z) {
            byte[] c = m13353c();
            allocate.put(c);
            for (i = 0; i < bArr.length; i++) {
                allocate.put((byte) (bArr[i] ^ c[i % 4]));
            }
        }
        allocate.flip();
        return allocate;
    }

    private byte[] m13353c() {
        byte[] bArr = new byte[4];
        this.f9351b.nextBytes(bArr);
        return bArr;
    }

    private void m13354d() {
        this.f9355f.write((ByteBuffer) this.f9350a.take());
    }

    private void m13355e() {
        while (!this.f9352c && !Thread.interrupted()) {
            try {
                m13354d();
            } catch (Throwable e) {
                m13350a(new cxy("IO Exception", e));
                return;
            } catch (InterruptedException e2) {
                return;
            }
        }
        for (int i = 0; i < this.f9350a.size(); i++) {
            m13354d();
        }
    }

    void m13356a() {
        this.f9352c = true;
    }

    synchronized void m13357a(byte b, boolean z, byte[] bArr) {
        ByteBuffer b2 = m13352b(b, z, bArr);
        if (!this.f9352c || (!this.f9353d && b == (byte) 8)) {
            if (b == (byte) 8) {
                this.f9353d = true;
            }
            this.f9350a.add(b2);
        } else {
            throw new cxy("Shouldn't be sending");
        }
    }

    void m13358a(OutputStream outputStream) {
        this.f9355f = Channels.newChannel(outputStream);
    }

    Thread m13359b() {
        return this.f9356g;
    }
}
