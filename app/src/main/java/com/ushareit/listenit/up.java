package com.ushareit.listenit;

import android.util.Log;
import com.mopub.mobileads.resource.DrawableConstants.CtaButton;
import com.umeng.analytics.pro.C0277j;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

public class up {
    private final byte[] f16939a = new byte[C0277j.f3694e];
    private ByteBuffer f16940b;
    private uo f16941c;
    private int f16942d = 0;

    public up m26580a(byte[] bArr) {
        m26567c();
        if (bArr != null) {
            this.f16940b = ByteBuffer.wrap(bArr);
            this.f16940b.rewind();
            this.f16940b.order(ByteOrder.LITTLE_ENDIAN);
        } else {
            this.f16940b = null;
            this.f16941c.f16927b = 2;
        }
        return this;
    }

    public void m26581a() {
        this.f16940b = null;
        this.f16941c = null;
    }

    private void m26567c() {
        this.f16940b = null;
        Arrays.fill(this.f16939a, (byte) 0);
        this.f16941c = new uo();
        this.f16942d = 0;
    }

    public uo m26582b() {
        if (this.f16940b == null) {
            throw new IllegalStateException("You must call setData() before parseHeader()");
        } else if (m26579o()) {
            return this.f16941c;
        } else {
            m26572h();
            if (!m26579o()) {
                m26568d();
                if (this.f16941c.f16928c < 0) {
                    this.f16941c.f16927b = 1;
                }
            }
            return this.f16941c;
        }
    }

    private void m26568d() {
        int i = 0;
        while (i == 0 && !m26579o()) {
            switch (m26577m()) {
                case 33:
                    switch (m26577m()) {
                        case 1:
                            m26575k();
                            break;
                        case 249:
                            this.f16941c.f16929d = new un();
                            m26569e();
                            break;
                        case 254:
                            m26575k();
                            break;
                        case 255:
                            m26576l();
                            String str = "";
                            for (int i2 = 0; i2 < 11; i2++) {
                                str = str + ((char) this.f16939a[i2]);
                            }
                            if (!str.equals("NETSCAPE2.0")) {
                                m26575k();
                                break;
                            } else {
                                m26571g();
                                break;
                            }
                        default:
                            m26575k();
                            break;
                    }
                case 44:
                    if (this.f16941c.f16929d == null) {
                        this.f16941c.f16929d = new un();
                    }
                    m26570f();
                    break;
                case 59:
                    i = 1;
                    break;
                default:
                    this.f16941c.f16927b = 1;
                    break;
            }
        }
    }

    private void m26569e() {
        boolean z = true;
        m26577m();
        int m = m26577m();
        this.f16941c.f16929d.f16921g = (m & 28) >> 2;
        if (this.f16941c.f16929d.f16921g == 0) {
            this.f16941c.f16929d.f16921g = 1;
        }
        un unVar = this.f16941c.f16929d;
        if ((m & 1) == 0) {
            z = false;
        }
        unVar.f16920f = z;
        int n = m26578n();
        if (n < 3) {
            n = 10;
        }
        this.f16941c.f16929d.f16923i = n * 10;
        this.f16941c.f16929d.f16922h = m26577m();
        m26577m();
    }

    private void m26570f() {
        boolean z = true;
        this.f16941c.f16929d.f16915a = m26578n();
        this.f16941c.f16929d.f16916b = m26578n();
        this.f16941c.f16929d.f16917c = m26578n();
        this.f16941c.f16929d.f16918d = m26578n();
        int m = m26577m();
        boolean z2 = (m & 128) != 0;
        int pow = (int) Math.pow(2.0d, (double) ((m & 7) + 1));
        un unVar = this.f16941c.f16929d;
        if ((m & 64) == 0) {
            z = false;
        }
        unVar.f16919e = z;
        if (z2) {
            this.f16941c.f16929d.f16925k = m26566a(pow);
        } else {
            this.f16941c.f16929d.f16925k = null;
        }
        this.f16941c.f16929d.f16924j = this.f16940b.position();
        m26574j();
        if (!m26579o()) {
            uo uoVar = this.f16941c;
            uoVar.f16928c++;
            this.f16941c.f16930e.add(this.f16941c.f16929d);
        }
    }

    private void m26571g() {
        do {
            m26576l();
            if (this.f16939a[0] == (byte) 1) {
                this.f16941c.f16938m = (this.f16939a[1] & 255) | ((this.f16939a[2] & 255) << 8);
            }
            if (this.f16942d <= 0) {
                return;
            }
        } while (!m26579o());
    }

    private void m26572h() {
        String str = "";
        for (int i = 0; i < 6; i++) {
            str = str + ((char) m26577m());
        }
        if (str.startsWith("GIF")) {
            m26573i();
            if (this.f16941c.f16933h && !m26579o()) {
                this.f16941c.f16926a = m26566a(this.f16941c.f16934i);
                this.f16941c.f16937l = this.f16941c.f16926a[this.f16941c.f16935j];
                return;
            }
            return;
        }
        this.f16941c.f16927b = 1;
    }

    private void m26573i() {
        this.f16941c.f16931f = m26578n();
        this.f16941c.f16932g = m26578n();
        int m = m26577m();
        this.f16941c.f16933h = (m & 128) != 0;
        this.f16941c.f16934i = 2 << (m & 7);
        this.f16941c.f16935j = m26577m();
        this.f16941c.f16936k = m26577m();
    }

    private int[] m26566a(int i) {
        int[] iArr;
        Throwable e;
        int i2 = 0;
        byte[] bArr = new byte[(i * 3)];
        try {
            this.f16940b.get(bArr);
            iArr = new int[C0277j.f3694e];
            int i3 = 0;
            while (i2 < i) {
                int i4 = i3 + 1;
                try {
                    int i5 = bArr[i3] & 255;
                    int i6 = i4 + 1;
                    int i7 = bArr[i4] & 255;
                    i3 = i6 + 1;
                    i4 = i2 + 1;
                    iArr[i2] = (((i5 << 16) | CtaButton.BACKGROUND_COLOR) | (i7 << 8)) | (bArr[i6] & 255);
                    i2 = i4;
                } catch (BufferUnderflowException e2) {
                    e = e2;
                }
            }
        } catch (Throwable e3) {
            Throwable th = e3;
            iArr = null;
            e = th;
            if (Log.isLoggable("GifHeaderParser", 3)) {
                Log.d("GifHeaderParser", "Format Error Reading Color Table", e);
            }
            this.f16941c.f16927b = 1;
            return iArr;
        }
        return iArr;
    }

    private void m26574j() {
        m26577m();
        m26575k();
    }

    private void m26575k() {
        int m;
        do {
            m = m26577m();
            this.f16940b.position(this.f16940b.position() + m);
        } while (m > 0);
    }

    private int m26576l() {
        int i = 0;
        this.f16942d = m26577m();
        if (this.f16942d > 0) {
            int i2 = 0;
            while (i < this.f16942d) {
                try {
                    i2 = this.f16942d - i;
                    this.f16940b.get(this.f16939a, i, i2);
                    i += i2;
                } catch (Throwable e) {
                    if (Log.isLoggable("GifHeaderParser", 3)) {
                        Log.d("GifHeaderParser", "Error Reading Block n: " + i + " count: " + i2 + " blockSize: " + this.f16942d, e);
                    }
                    this.f16941c.f16927b = 1;
                }
            }
        }
        return i;
    }

    private int m26577m() {
        int i = 0;
        try {
            return this.f16940b.get() & 255;
        } catch (Exception e) {
            this.f16941c.f16927b = 1;
            return i;
        }
    }

    private int m26578n() {
        return this.f16940b.getShort();
    }

    private boolean m26579o() {
        return this.f16941c.f16927b != 0;
    }
}
