package com.ushareit.listenit;

import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ReadOnlyBufferException;

public final class dga {
    private final ByteBuffer f9761a;

    private dga(ByteBuffer byteBuffer) {
        this.f9761a = byteBuffer;
        this.f9761a.order(ByteOrder.LITTLE_ENDIAN);
    }

    private dga(byte[] bArr, int i, int i2) {
        this(ByteBuffer.wrap(bArr, i, i2));
    }

    private static int m14156a(CharSequence charSequence) {
        int length = charSequence.length();
        int i = 0;
        while (i < length && charSequence.charAt(i) < '') {
            i++;
        }
        int i2 = i;
        i = length;
        while (i2 < length) {
            char charAt = charSequence.charAt(i2);
            if (charAt >= 'ࠀ') {
                i += m14157a(charSequence, i2);
                break;
            }
            i2++;
            i = ((127 - charAt) >>> 31) + i;
        }
        if (i >= length) {
            return i;
        }
        throw new IllegalArgumentException("UTF-8 length does not fit in int: " + (((long) i) + 4294967296L));
    }

    private static int m14157a(CharSequence charSequence, int i) {
        int length = charSequence.length();
        int i2 = 0;
        int i3 = i;
        while (i3 < length) {
            char charAt = charSequence.charAt(i3);
            if (charAt < 'ࠀ') {
                i2 += (127 - charAt) >>> 31;
            } else {
                i2 += 2;
                if ('?' <= charAt && charAt <= '?') {
                    if (Character.codePointAt(charSequence, i3) < 65536) {
                        throw new IllegalArgumentException("Unpaired surrogate at index " + i3);
                    }
                    i3++;
                }
            }
            i3++;
        }
        return i2;
    }

    private static int m14158a(CharSequence charSequence, byte[] bArr, int i, int i2) {
        int length = charSequence.length();
        int i3 = 0;
        int i4 = i + i2;
        while (i3 < length && i3 + i < i4) {
            char charAt = charSequence.charAt(i3);
            if (charAt >= '') {
                break;
            }
            bArr[i + i3] = (byte) charAt;
            i3++;
        }
        if (i3 == length) {
            return i + length;
        }
        int i5 = i + i3;
        while (i3 < length) {
            int i6;
            char charAt2 = charSequence.charAt(i3);
            if (charAt2 < '' && i5 < i4) {
                i6 = i5 + 1;
                bArr[i5] = (byte) charAt2;
            } else if (charAt2 < 'ࠀ' && i5 <= i4 - 2) {
                r6 = i5 + 1;
                bArr[i5] = (byte) ((charAt2 >>> 6) | 960);
                i6 = r6 + 1;
                bArr[r6] = (byte) ((charAt2 & 63) | 128);
            } else if ((charAt2 < '?' || '?' < charAt2) && i5 <= i4 - 3) {
                i6 = i5 + 1;
                bArr[i5] = (byte) ((charAt2 >>> 12) | 480);
                i5 = i6 + 1;
                bArr[i6] = (byte) (((charAt2 >>> 6) & 63) | 128);
                i6 = i5 + 1;
                bArr[i5] = (byte) ((charAt2 & 63) | 128);
            } else if (i5 <= i4 - 4) {
                if (i3 + 1 != charSequence.length()) {
                    i3++;
                    charAt = charSequence.charAt(i3);
                    if (Character.isSurrogatePair(charAt2, charAt)) {
                        int toCodePoint = Character.toCodePoint(charAt2, charAt);
                        i6 = i5 + 1;
                        bArr[i5] = (byte) ((toCodePoint >>> 18) | 240);
                        i5 = i6 + 1;
                        bArr[i6] = (byte) (((toCodePoint >>> 12) & 63) | 128);
                        r6 = i5 + 1;
                        bArr[i5] = (byte) (((toCodePoint >>> 6) & 63) | 128);
                        i6 = r6 + 1;
                        bArr[r6] = (byte) ((toCodePoint & 63) | 128);
                    }
                }
                throw new IllegalArgumentException("Unpaired surrogate at index " + (i3 - 1));
            } else {
                throw new ArrayIndexOutOfBoundsException("Failed writing " + charAt2 + " at index " + i5);
            }
            i3++;
            i5 = i6;
        }
        return i5;
    }

    public static dga m14159a(byte[] bArr) {
        return m14160a(bArr, 0, bArr.length);
    }

    public static dga m14160a(byte[] bArr, int i, int i2) {
        return new dga(bArr, i, i2);
    }

    private static void m14161a(CharSequence charSequence, ByteBuffer byteBuffer) {
        if (byteBuffer.isReadOnly()) {
            throw new ReadOnlyBufferException();
        } else if (byteBuffer.hasArray()) {
            try {
                byteBuffer.position(m14158a(charSequence, byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.remaining()) - byteBuffer.arrayOffset());
            } catch (Throwable e) {
                BufferOverflowException bufferOverflowException = new BufferOverflowException();
                bufferOverflowException.initCause(e);
                throw bufferOverflowException;
            }
        } else {
            m14174b(charSequence, byteBuffer);
        }
    }

    public static int m14162b(double d) {
        return 8;
    }

    public static int m14163b(float f) {
        return 4;
    }

    public static int m14164b(int i) {
        return i >= 0 ? m14184f(i) : 10;
    }

    public static int m14165b(int i, double d) {
        return m14178d(i) + m14162b(d);
    }

    public static int m14166b(int i, float f) {
        return m14178d(i) + m14163b(f);
    }

    public static int m14167b(int i, int i2) {
        return m14178d(i) + m14164b(i2);
    }

    public static int m14168b(int i, dgi com_ushareit_listenit_dgi) {
        return (m14178d(i) * 2) + m14176c(com_ushareit_listenit_dgi);
    }

    public static int m14169b(int i, String str) {
        return m14178d(i) + m14172b(str);
    }

    public static int m14170b(int i, boolean z) {
        return m14178d(i) + m14173b(z);
    }

    public static int m14171b(int i, byte[] bArr) {
        return m14178d(i) + m14177c(bArr);
    }

    public static int m14172b(String str) {
        int a = m14156a((CharSequence) str);
        return a + m14184f(a);
    }

    public static int m14173b(boolean z) {
        return 1;
    }

    private static void m14174b(CharSequence charSequence, ByteBuffer byteBuffer) {
        int length = charSequence.length();
        int i = 0;
        while (i < length) {
            char charAt = charSequence.charAt(i);
            if (charAt < '') {
                byteBuffer.put((byte) charAt);
            } else if (charAt < 'ࠀ') {
                byteBuffer.put((byte) ((charAt >>> 6) | 960));
                byteBuffer.put((byte) ((charAt & 63) | 128));
            } else if (charAt < '?' || '?' < charAt) {
                byteBuffer.put((byte) ((charAt >>> 12) | 480));
                byteBuffer.put((byte) (((charAt >>> 6) & 63) | 128));
                byteBuffer.put((byte) ((charAt & 63) | 128));
            } else {
                if (i + 1 != charSequence.length()) {
                    i++;
                    char charAt2 = charSequence.charAt(i);
                    if (Character.isSurrogatePair(charAt, charAt2)) {
                        int toCodePoint = Character.toCodePoint(charAt, charAt2);
                        byteBuffer.put((byte) ((toCodePoint >>> 18) | 240));
                        byteBuffer.put((byte) (((toCodePoint >>> 12) & 63) | 128));
                        byteBuffer.put((byte) (((toCodePoint >>> 6) & 63) | 128));
                        byteBuffer.put((byte) ((toCodePoint & 63) | 128));
                    }
                }
                throw new IllegalArgumentException("Unpaired surrogate at index " + (i - 1));
            }
            i++;
        }
    }

    public static int m14175c(int i, dgi com_ushareit_listenit_dgi) {
        return m14178d(i) + m14181d(com_ushareit_listenit_dgi);
    }

    public static int m14176c(dgi com_ushareit_listenit_dgi) {
        return com_ushareit_listenit_dgi.m13475g();
    }

    public static int m14177c(byte[] bArr) {
        return m14184f(bArr.length) + bArr.length;
    }

    public static int m14178d(int i) {
        return m14184f(dgl.m14262a(i, 0));
    }

    public static int m14179d(int i, long j) {
        return m14178d(i) + m14183e(j);
    }

    public static int m14180d(long j) {
        return m14186h(j);
    }

    public static int m14181d(dgi com_ushareit_listenit_dgi) {
        int g = com_ushareit_listenit_dgi.m13475g();
        return g + m14184f(g);
    }

    public static int m14182e(int i, long j) {
        return m14178d(i) + m14185f(j);
    }

    public static int m14183e(long j) {
        return m14186h(j);
    }

    public static int m14184f(int i) {
        return (i & -128) == 0 ? 1 : (i & -16384) == 0 ? 2 : (-2097152 & i) == 0 ? 3 : (-268435456 & i) == 0 ? 4 : 5;
    }

    public static int m14185f(long j) {
        return 8;
    }

    public static int m14186h(long j) {
        return (-128 & j) == 0 ? 1 : (-16384 & j) == 0 ? 2 : (-2097152 & j) == 0 ? 3 : (-268435456 & j) == 0 ? 4 : (-34359738368L & j) == 0 ? 5 : (-4398046511104L & j) == 0 ? 6 : (-562949953421312L & j) == 0 ? 7 : (-72057594037927936L & j) == 0 ? 8 : (Long.MIN_VALUE & j) == 0 ? 9 : 10;
    }

    public int m14187a() {
        return this.f9761a.remaining();
    }

    public void m14188a(byte b) {
        if (this.f9761a.hasRemaining()) {
            this.f9761a.put(b);
            return;
        }
        throw new dgb(this.f9761a.position(), this.f9761a.limit());
    }

    public void m14189a(double d) {
        m14218i(Double.doubleToLongBits(d));
    }

    public void m14190a(float f) {
        m14216g(Float.floatToIntBits(f));
    }

    public void m14191a(int i) {
        if (i >= 0) {
            m14215e(i);
        } else {
            m14217g((long) i);
        }
    }

    public void m14192a(int i, double d) {
        m14211c(i, 1);
        m14189a(d);
    }

    public void m14193a(int i, float f) {
        m14211c(i, 5);
        m14190a(f);
    }

    public void m14194a(int i, int i2) {
        m14211c(i, 0);
        m14191a(i2);
    }

    public void m14195a(int i, long j) {
        m14211c(i, 0);
        m14200a(j);
    }

    public void m14196a(int i, dgi com_ushareit_listenit_dgi) {
        m14211c(i, 2);
        m14207b(com_ushareit_listenit_dgi);
    }

    public void m14197a(int i, String str) {
        m14211c(i, 2);
        m14202a(str);
    }

    public void m14198a(int i, boolean z) {
        m14211c(i, 0);
        m14203a(z);
    }

    public void m14199a(int i, byte[] bArr) {
        m14211c(i, 2);
        m14208b(bArr);
    }

    public void m14200a(long j) {
        m14217g(j);
    }

    public void m14201a(dgi com_ushareit_listenit_dgi) {
        com_ushareit_listenit_dgi.mo1666a(this);
    }

    public void m14202a(String str) {
        try {
            int f = m14184f(str.length());
            if (f == m14184f(str.length() * 3)) {
                int position = this.f9761a.position();
                if (this.f9761a.remaining() < f) {
                    throw new dgb(f + position, this.f9761a.limit());
                }
                this.f9761a.position(position + f);
                m14161a((CharSequence) str, this.f9761a);
                int position2 = this.f9761a.position();
                this.f9761a.position(position);
                m14215e((position2 - position) - f);
                this.f9761a.position(position2);
                return;
            }
            m14215e(m14156a((CharSequence) str));
            m14161a((CharSequence) str, this.f9761a);
        } catch (Throwable e) {
            dgb com_ushareit_listenit_dgb = new dgb(this.f9761a.position(), this.f9761a.limit());
            com_ushareit_listenit_dgb.initCause(e);
            throw com_ushareit_listenit_dgb;
        }
    }

    public void m14203a(boolean z) {
        m14210c(z ? 1 : 0);
    }

    public void m14204b() {
        if (m14187a() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    public void m14205b(int i, long j) {
        m14211c(i, 0);
        m14206b(j);
    }

    public void m14206b(long j) {
        m14217g(j);
    }

    public void m14207b(dgi com_ushareit_listenit_dgi) {
        m14215e(com_ushareit_listenit_dgi.m13474f());
        com_ushareit_listenit_dgi.mo1666a(this);
    }

    public void m14208b(byte[] bArr) {
        m14215e(bArr.length);
        m14214d(bArr);
    }

    public void m14209b(byte[] bArr, int i, int i2) {
        if (this.f9761a.remaining() >= i2) {
            this.f9761a.put(bArr, i, i2);
            return;
        }
        throw new dgb(this.f9761a.position(), this.f9761a.limit());
    }

    public void m14210c(int i) {
        m14188a((byte) i);
    }

    public void m14211c(int i, int i2) {
        m14215e(dgl.m14262a(i, i2));
    }

    public void m14212c(int i, long j) {
        m14211c(i, 1);
        m14213c(j);
    }

    public void m14213c(long j) {
        m14218i(j);
    }

    public void m14214d(byte[] bArr) {
        m14209b(bArr, 0, bArr.length);
    }

    public void m14215e(int i) {
        while ((i & -128) != 0) {
            m14210c((i & 127) | 128);
            i >>>= 7;
        }
        m14210c(i);
    }

    public void m14216g(int i) {
        if (this.f9761a.remaining() < 4) {
            throw new dgb(this.f9761a.position(), this.f9761a.limit());
        }
        this.f9761a.putInt(i);
    }

    public void m14217g(long j) {
        while ((-128 & j) != 0) {
            m14210c((((int) j) & 127) | 128);
            j >>>= 7;
        }
        m14210c((int) j);
    }

    public void m14218i(long j) {
        if (this.f9761a.remaining() < 8) {
            throw new dgb(this.f9761a.position(), this.f9761a.limit());
        }
        this.f9761a.putLong(j);
    }
}
