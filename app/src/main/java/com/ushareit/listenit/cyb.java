package com.ushareit.listenit;

import java.io.DataInputStream;
import java.net.SocketTimeoutException;

class cyb {
    private DataInputStream f9344a = null;
    private cxs f9345b = null;
    private cxx f9346c = null;
    private byte[] f9347d = new byte[112];
    private cxn f9348e;
    private volatile boolean f9349f = false;

    cyb(cxs com_ushareit_listenit_cxs) {
        this.f9345b = com_ushareit_listenit_cxs;
    }

    private int m13342a(byte[] bArr, int i, int i2) {
        this.f9344a.readFully(bArr, i, i2);
        return i2;
    }

    private long m13343a(byte[] bArr, int i) {
        return (((((((((long) bArr[i + 0]) << 56) + (((long) (bArr[i + 1] & 255)) << 48)) + (((long) (bArr[i + 2] & 255)) << 40)) + (((long) (bArr[i + 3] & 255)) << 32)) + (((long) (bArr[i + 4] & 255)) << 24)) + ((long) ((bArr[i + 5] & 255) << 16))) + ((long) ((bArr[i + 6] & 255) << 8))) + ((long) ((bArr[i + 7] & 255) << 0));
    }

    private void m13344a(cxy com_ushareit_listenit_cxy) {
        m13349b();
        this.f9345b.m13325a(com_ushareit_listenit_cxy);
    }

    private void m13345a(boolean z, byte b, byte[] bArr) {
        if (b == (byte) 9) {
            if (z) {
                m13346a(bArr);
                return;
            }
            throw new cxy("PING must not fragment across frames");
        } else if (this.f9348e != null && b != (byte) 0) {
            throw new cxy("Failed to continue outstanding frame");
        } else if (this.f9348e == null && b == (byte) 0) {
            throw new cxy("Received continuing frame, but there's nothing to continue");
        } else {
            if (this.f9348e == null) {
                this.f9348e = cxl.m13305a(b);
            }
            if (!this.f9348e.mo1663a(bArr)) {
                throw new cxy("Failed to decode frame");
            } else if (z) {
                cya a = this.f9348e.mo1662a();
                this.f9348e = null;
                if (a == null) {
                    throw new cxy("Failed to decode whole message");
                }
                this.f9346c.mo1542a(a);
            }
        }
    }

    private void m13346a(byte[] bArr) {
        if (bArr.length <= 125) {
            this.f9345b.m13327a(bArr);
            return;
        }
        throw new cxy("PING frame too long");
    }

    void m13347a() {
        this.f9346c = this.f9345b.m13328c();
        while (!this.f9349f) {
            try {
                int a = m13342a(this.f9347d, 0, 1) + 0;
                boolean z = (this.f9347d[0] & 128) != 0;
                if (((this.f9347d[0] & 112) != 0 ? 1 : null) != null) {
                    throw new cxy("Invalid frame received");
                }
                byte b = (byte) (this.f9347d[0] & 15);
                int a2 = a + m13342a(this.f9347d, a, 1);
                byte b2 = this.f9347d[1];
                long j = 0;
                if (b2 < (byte) 126) {
                    j = (long) b2;
                } else if (b2 == (byte) 126) {
                    int a3 = m13342a(this.f9347d, a2, 2) + a2;
                    j = (long) (((this.f9347d[2] & 255) << 8) | (this.f9347d[3] & 255));
                } else if (b2 == Byte.MAX_VALUE) {
                    j = m13343a(this.f9347d, (m13342a(this.f9347d, a2, 8) + a2) - 8);
                }
                byte[] bArr = new byte[((int) j)];
                m13342a(bArr, 0, (int) j);
                if (b == (byte) 8) {
                    this.f9345b.m13331f();
                } else if (b == (byte) 10) {
                    continue;
                } else if (b == (byte) 1 || b == (byte) 2 || b == (byte) 9 || b == (byte) 0) {
                    m13345a(z, b, bArr);
                } else {
                    throw new cxy("Unsupported opcode: " + b);
                }
            } catch (SocketTimeoutException e) {
            } catch (Throwable e2) {
                m13344a(new cxy("IO Error", e2));
            } catch (cxy e3) {
                m13344a(e3);
            }
        }
    }

    void m13348a(DataInputStream dataInputStream) {
        this.f9344a = dataInputStream;
    }

    void m13349b() {
        this.f9349f = true;
    }
}
