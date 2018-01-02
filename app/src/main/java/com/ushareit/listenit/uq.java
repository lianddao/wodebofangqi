package com.ushareit.listenit;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.Log;
import com.umeng.analytics.pro.C0277j;
import java.io.IOException;
import java.io.OutputStream;

public class uq {
    private int f16943a;
    private int f16944b;
    private Integer f16945c = null;
    private int f16946d;
    private int f16947e = -1;
    private int f16948f = 0;
    private boolean f16949g = false;
    private OutputStream f16950h;
    private Bitmap f16951i;
    private byte[] f16952j;
    private byte[] f16953k;
    private int f16954l;
    private byte[] f16955m;
    private boolean[] f16956n = new boolean[C0277j.f3694e];
    private int f16957o = 7;
    private int f16958p = -1;
    private boolean f16959q = false;
    private boolean f16960r = true;
    private boolean f16961s = false;
    private int f16962t = 10;
    private boolean f16963u;

    public void m26594a(int i) {
        this.f16948f = Math.round(((float) i) / 10.0f);
    }

    public boolean m26597a(Bitmap bitmap) {
        if (bitmap == null || !this.f16949g) {
            return false;
        }
        try {
            if (!this.f16961s) {
                m26595a(bitmap.getWidth(), bitmap.getHeight());
            }
            this.f16951i = bitmap;
            m26586c();
            m26585b();
            if (this.f16960r) {
                m26590f();
                m26592h();
                if (this.f16947e >= 0) {
                    m26591g();
                }
            }
            m26588d();
            m26589e();
            if (!this.f16960r) {
                m26592h();
            }
            m26593i();
            this.f16960r = false;
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public boolean m26596a() {
        if (!this.f16949g) {
            return false;
        }
        boolean z;
        this.f16949g = false;
        try {
            this.f16950h.write(59);
            this.f16950h.flush();
            if (this.f16959q) {
                this.f16950h.close();
            }
            z = true;
        } catch (IOException e) {
            z = false;
        }
        this.f16946d = 0;
        this.f16950h = null;
        this.f16951i = null;
        this.f16952j = null;
        this.f16953k = null;
        this.f16955m = null;
        this.f16959q = false;
        this.f16960r = true;
        return z;
    }

    public void m26595a(int i, int i2) {
        if (!this.f16949g || this.f16960r) {
            this.f16943a = i;
            this.f16944b = i2;
            if (this.f16943a < 1) {
                this.f16943a = 320;
            }
            if (this.f16944b < 1) {
                this.f16944b = 240;
            }
            this.f16961s = true;
        }
    }

    public boolean m26598a(OutputStream outputStream) {
        if (outputStream == null) {
            return false;
        }
        boolean z = true;
        this.f16959q = false;
        this.f16950h = outputStream;
        try {
            m26583a("GIF89a");
        } catch (IOException e) {
            z = false;
        }
        this.f16949g = z;
        return z;
    }

    private void m26585b() {
        int length = this.f16952j.length;
        int i = length / 3;
        this.f16953k = new byte[i];
        us usVar = new us(this.f16952j, length, this.f16962t);
        this.f16955m = usVar.m26615d();
        for (length = 0; length < this.f16955m.length; length += 3) {
            byte b = this.f16955m[length];
            this.f16955m[length] = this.f16955m[length + 2];
            this.f16955m[length + 2] = b;
            this.f16956n[length / 3] = false;
        }
        int i2 = 0;
        for (length = 0; length < i; length++) {
            int i3 = i2 + 1;
            int i4 = i3 + 1;
            i2 = i4 + 1;
            int a = usVar.m26608a(this.f16952j[i2] & 255, this.f16952j[i3] & 255, this.f16952j[i4] & 255);
            this.f16956n[a] = true;
            this.f16953k[length] = (byte) a;
        }
        this.f16952j = null;
        this.f16954l = 8;
        this.f16957o = 7;
        if (this.f16945c != null) {
            this.f16946d = m26584b(this.f16945c.intValue());
        } else if (this.f16963u) {
            this.f16946d = m26584b(0);
        }
    }

    private int m26584b(int i) {
        int i2 = 0;
        if (this.f16955m == null) {
            return -1;
        }
        int red = Color.red(i);
        int green = Color.green(i);
        int blue = Color.blue(i);
        int i3 = 16777216;
        int length = this.f16955m.length;
        int i4 = 0;
        while (i2 < length) {
            int i5 = i2 + 1;
            i2 = red - (this.f16955m[i2] & 255);
            int i6 = i5 + 1;
            int i7 = green - (this.f16955m[i5] & 255);
            i5 = blue - (this.f16955m[i6] & 255);
            i2 = ((i2 * i2) + (i7 * i7)) + (i5 * i5);
            i7 = i6 / 3;
            if (!this.f16956n[i7] || i2 >= i3) {
                i2 = i3;
                i3 = i4;
            } else {
                i3 = i7;
            }
            i4 = i3;
            i3 = i2;
            i2 = i6 + 1;
        }
        return i4;
    }

    private void m26586c() {
        boolean z = false;
        int width = this.f16951i.getWidth();
        int height = this.f16951i.getHeight();
        if (!(width == this.f16943a && height == this.f16944b)) {
            Bitmap createBitmap = Bitmap.createBitmap(this.f16943a, this.f16944b, Config.ARGB_8888);
            new Canvas(createBitmap).drawBitmap(createBitmap, 0.0f, 0.0f, null);
            this.f16951i = createBitmap;
        }
        int[] iArr = new int[(width * height)];
        this.f16951i.getPixels(iArr, 0, width, 0, 0, width, height);
        this.f16952j = new byte[(iArr.length * 3)];
        this.f16963u = false;
        int i = 0;
        int i2 = 0;
        for (int i3 : iArr) {
            if (i3 == 0) {
                i++;
            }
            int i4 = i2 + 1;
            this.f16952j[i2] = (byte) (i3 & 255);
            height = i4 + 1;
            this.f16952j[i4] = (byte) ((i3 >> 8) & 255);
            i2 = height + 1;
            this.f16952j[height] = (byte) ((i3 >> 16) & 255);
        }
        double length = ((double) (i * 100)) / ((double) iArr.length);
        if (length > 4.0d) {
            z = true;
        }
        this.f16963u = z;
        if (Log.isLoggable("AnimatedGifEncoder", 3)) {
            Log.d("AnimatedGifEncoder", "got pixels for frame with " + length + "% transparent pixels");
        }
    }

    private void m26588d() {
        int i;
        int i2;
        this.f16950h.write(33);
        this.f16950h.write(249);
        this.f16950h.write(4);
        if (this.f16945c != null || this.f16963u) {
            i = 1;
            i2 = 2;
        } else {
            i2 = 0;
            i = 0;
        }
        if (this.f16958p >= 0) {
            i2 = this.f16958p & 7;
        }
        this.f16950h.write((((i2 << 2) | 0) | 0) | i);
        m26587c(this.f16948f);
        this.f16950h.write(this.f16946d);
        this.f16950h.write(0);
    }

    private void m26589e() {
        this.f16950h.write(44);
        m26587c(0);
        m26587c(0);
        m26587c(this.f16943a);
        m26587c(this.f16944b);
        if (this.f16960r) {
            this.f16950h.write(0);
        } else {
            this.f16950h.write(this.f16957o | 128);
        }
    }

    private void m26590f() {
        m26587c(this.f16943a);
        m26587c(this.f16944b);
        this.f16950h.write(this.f16957o | 240);
        this.f16950h.write(0);
        this.f16950h.write(0);
    }

    private void m26591g() {
        this.f16950h.write(33);
        this.f16950h.write(255);
        this.f16950h.write(11);
        m26583a("NETSCAPE2.0");
        this.f16950h.write(3);
        this.f16950h.write(1);
        m26587c(this.f16947e);
        this.f16950h.write(0);
    }

    private void m26592h() {
        this.f16950h.write(this.f16955m, 0, this.f16955m.length);
        int length = 768 - this.f16955m.length;
        for (int i = 0; i < length; i++) {
            this.f16950h.write(0);
        }
    }

    private void m26593i() {
        new ur(this.f16943a, this.f16944b, this.f16953k, this.f16954l).m26606b(this.f16950h);
    }

    private void m26587c(int i) {
        this.f16950h.write(i & 255);
        this.f16950h.write((i >> 8) & 255);
    }

    private void m26583a(String str) {
        for (int i = 0; i < str.length(); i++) {
            this.f16950h.write((byte) str.charAt(i));
        }
    }
}
