package com.ushareit.listenit;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;

public class fpf extends fpm {
    public static final int[] f13145a = new int[]{1684631142, 1751411826, 1835296868, 1835297121, 1835626086, 1836019574, 1836476516, 1936549988, 1937007212, 1937011556, 1937011578, 1937011827, 1953196132, 1953653099};
    public static final int[] f13146b = new int[]{1684631142, 1751411826, 1835296868, 1836476516, 1936549988, 1953196132, 1937011556};
    private int f13147h;
    private int[] f13148i;
    private int[] f13149j;
    private int[] f13150k;
    private int f13151l;
    private HashMap<Integer, fph> f13152m;
    private int f13153n;
    private int f13154o;
    private int f13155p;
    private int f13156q;
    private int f13157r;
    private int f13158s;
    private int f13159t;
    private int f13160u;
    private int f13161v;

    public static fpn m20264a() {
        return new fpg();
    }

    public int mo2515b() {
        return this.f13147h;
    }

    public int mo2516c() {
        return this.f13156q;
    }

    public int[] mo2517d() {
        return this.f13150k;
    }

    public int mo2518e() {
        int i = this.f13147h * this.f13156q;
        if (i == 0) {
            return 0;
        }
        return this.f13151l / i;
    }

    public int mo2519f() {
        return this.f13154o;
    }

    public String mo2520g() {
        return "AAC";
    }

    public String m20266a(int i) {
        return ((("" + ((char) ((i >> 24) & 255))) + ((char) ((i >> 16) & 255))) + ((char) ((i >> 8) & 255))) + ((char) (i & 255));
    }

    public void mo2513a(File file) {
        int i = 0;
        super.mo2513a(file);
        this.f13155p = 0;
        this.f13154o = 0;
        this.f13153n = 0;
        this.f13156q = 0;
        this.f13147h = 0;
        this.f13158s = 255;
        this.f13159t = 0;
        this.f13157r = 0;
        this.f13160u = -1;
        this.f13161v = -1;
        this.f13152m = new HashMap();
        this.f13151l = (int) this.g.length();
        if (this.f13151l < 128) {
            throw new IOException("File too small to parse");
        }
        byte[] bArr = new byte[8];
        new FileInputStream(this.g).read(bArr, 0, 8);
        if (bArr[0] == (byte) 0 && bArr[4] == (byte) 102 && bArr[5] == (byte) 116 && bArr[6] == (byte) 121 && bArr[7] == (byte) 112) {
            m20265e(new FileInputStream(this.g), this.f13151l);
            if (this.f13160u <= 0 || this.f13161v <= 0) {
                throw new IOException("Didn't find mdat");
            }
            InputStream fileInputStream = new FileInputStream(this.g);
            fileInputStream.skip((long) this.f13160u);
            this.f13157r = this.f13160u;
            m20276c(fileInputStream, this.f13161v);
            for (int i2 : f13145a) {
                if (!this.f13152m.containsKey(Integer.valueOf(i2))) {
                    System.out.println("Missing atom: " + m20266a(i2));
                    i = 1;
                }
            }
            if (i != 0) {
                throw new IOException("Could not parse MP4 file");
            }
            return;
        }
        throw new IOException("Unknown file format");
    }

    private void m20265e(InputStream inputStream, int i) {
        int i2 = i;
        while (i2 > 8) {
            int i3;
            int i4 = this.f13157r;
            byte[] bArr = new byte[8];
            inputStream.read(bArr, 0, 8);
            int i5 = ((((bArr[0] & 255) << 24) | ((bArr[1] & 255) << 16)) | ((bArr[2] & 255) << 8)) | (bArr[3] & 255);
            if (i5 > i2) {
                i3 = i2;
            } else {
                i3 = i5;
            }
            int i6 = ((((bArr[4] & 255) << 24) | ((bArr[5] & 255) << 16)) | ((bArr[6] & 255) << 8)) | (bArr[7] & 255);
            fph com_ushareit_listenit_fph = new fph(this);
            com_ushareit_listenit_fph.f13162a = this.f13157r;
            com_ushareit_listenit_fph.f13163b = i3;
            this.f13152m.put(Integer.valueOf(i6), com_ushareit_listenit_fph);
            this.f13157r += 8;
            if (i6 == 1836019574 || i6 == 1953653099 || i6 == 1835297121 || i6 == 1835626086 || i6 == 1937007212) {
                m20265e(inputStream, i3);
            } else if (i6 == 1937011578) {
                m20274b(inputStream, i3 - 8);
            } else if (i6 == 1937011827) {
                m20271a(inputStream, i3 - 8);
            } else if (i6 == 1835295092) {
                this.f13160u = this.f13157r;
                this.f13161v = i3 - 8;
            } else {
                for (int i52 : f13146b) {
                    if (i52 == i6) {
                        byte[] bArr2 = new byte[(i3 - 8)];
                        inputStream.read(bArr2, 0, i3 - 8);
                        this.f13157r += i3 - 8;
                        ((fph) this.f13152m.get(Integer.valueOf(i6))).f13164c = bArr2;
                    }
                }
            }
            if (i6 == 1937011556) {
                m20282h();
            }
            i2 -= i3;
            i52 = i3 - (this.f13157r - i4);
            if (i52 < 0) {
                throw new IOException("Went over by " + (-i52) + " bytes");
            }
            inputStream.skip((long) i52);
            this.f13157r = i52 + this.f13157r;
        }
    }

    void m20271a(InputStream inputStream, int i) {
        byte[] bArr = new byte[16];
        inputStream.read(bArr, 0, 16);
        this.f13157r += 16;
        this.f13156q = (bArr[15] & 255) | ((((bArr[12] & 255) << 24) | ((bArr[13] & 255) << 16)) | ((bArr[14] & 255) << 8));
    }

    void m20274b(InputStream inputStream, int i) {
        int i2 = 0;
        byte[] bArr = new byte[12];
        inputStream.read(bArr, 0, 12);
        this.f13157r += 12;
        this.f13147h = (bArr[11] & 255) | ((((bArr[8] & 255) << 24) | ((bArr[9] & 255) << 16)) | ((bArr[10] & 255) << 8));
        this.f13148i = new int[this.f13147h];
        this.f13149j = new int[this.f13147h];
        this.f13150k = new int[this.f13147h];
        bArr = new byte[(this.f13147h * 4)];
        inputStream.read(bArr, 0, this.f13147h * 4);
        this.f13157r += this.f13147h * 4;
        while (i2 < this.f13147h) {
            this.f13149j[i2] = ((((bArr[(i2 * 4) + 0] & 255) << 24) | ((bArr[(i2 * 4) + 1] & 255) << 16)) | ((bArr[(i2 * 4) + 2] & 255) << 8)) | (bArr[(i2 * 4) + 3] & 255);
            i2++;
        }
    }

    void m20282h() {
        byte[] bArr = ((fph) this.f13152m.get(Integer.valueOf(1937011556))).f13164c;
        this.f13155p = ((bArr[32] & 255) << 8) | (bArr[33] & 255);
        this.f13154o = (bArr[41] & 255) | ((bArr[40] & 255) << 8);
    }

    void m20276c(InputStream inputStream, int i) {
        int i2 = this.f13157r;
        int i3 = 0;
        while (i3 < this.f13147h) {
            this.f13148i[i3] = this.f13157r;
            if ((this.f13157r - i2) + this.f13149j[i3] > i - 8) {
                this.f13150k[i3] = 0;
            } else {
                m20277d(inputStream, i3);
            }
            if (this.f13150k[i3] < this.f13158s) {
                this.f13158s = this.f13150k[i3];
            }
            if (this.f13150k[i3] > this.f13159t) {
                this.f13159t = this.f13150k[i3];
            }
            if (this.f == null || this.f.m20314a((((double) this.f13157r) * 1.0d) / ((double) this.f13151l))) {
                i3++;
            } else {
                return;
            }
        }
    }

    void m20277d(InputStream inputStream, int i) {
        int i2 = 0;
        if (this.f13149j[i] < 4) {
            this.f13150k[i] = 0;
            inputStream.skip((long) this.f13149j[i]);
            return;
        }
        int i3;
        int i4 = this.f13157r;
        byte[] bArr = new byte[4];
        inputStream.read(bArr, 0, 4);
        this.f13157r += 4;
        switch ((bArr[0] & 224) >> 5) {
            case 0:
                this.f13150k[i] = ((bArr[0] & 1) << 7) | ((bArr[1] & 254) >> 1);
                break;
            case 1:
                int i5;
                int i6;
                int i7 = (bArr[1] & 16) >> 4;
                if (((bArr[1] & 96) >> 5) == 2) {
                    i3 = ((bArr[2] & 1) << 1) | ((bArr[3] & 128) >> 7);
                    i7 = 25;
                    i5 = bArr[1] & 15;
                    i6 = (bArr[2] & 254) >> 1;
                } else {
                    i3 = (bArr[2] & 24) >> 3;
                    i7 = 21;
                    i5 = ((bArr[1] & 15) << 2) | ((bArr[2] & 192) >> 6);
                    i6 = -1;
                }
                if (i3 == 1) {
                    i3 = 0;
                    for (int i8 = 0; i8 < 7; i8++) {
                        if (((1 << i8) & i6) == 0) {
                            i3++;
                        }
                    }
                    i3 = ((i3 + 1) * i5) + i7;
                } else {
                    i3 = i7;
                }
                i7 = ((i3 + 7) / 8) + 1;
                byte[] bArr2 = new byte[i7];
                bArr2[0] = bArr[0];
                bArr2[1] = bArr[1];
                bArr2[2] = bArr[2];
                bArr2[3] = bArr[3];
                inputStream.read(bArr2, 4, i7 - 4);
                this.f13157r = (i7 - 4) + this.f13157r;
                for (i7 = 0; i7 < 8; i7++) {
                    i5 = 7 - ((i7 + i3) % 8);
                    i2 += ((bArr2[(i7 + i3) / 8] & (1 << i5)) >> i5) << (7 - i7);
                }
                this.f13150k[i] = i2;
                break;
            default:
                if (i <= 0) {
                    this.f13150k[i] = 0;
                    break;
                } else {
                    this.f13150k[i] = this.f13150k[i - 1];
                    break;
                }
        }
        i3 = this.f13149j[i] - (this.f13157r - i4);
        inputStream.skip((long) i3);
        this.f13157r = i3 + this.f13157r;
    }

    public void m20270a(FileOutputStream fileOutputStream, int i) {
        r1 = new byte[8];
        int i2 = ((fph) this.f13152m.get(Integer.valueOf(i))).f13163b;
        r1[0] = (byte) ((i2 >> 24) & 255);
        r1[1] = (byte) ((i2 >> 16) & 255);
        r1[2] = (byte) ((i2 >> 8) & 255);
        r1[3] = (byte) (i2 & 255);
        r1[4] = (byte) ((i >> 24) & 255);
        r1[5] = (byte) ((i >> 16) & 255);
        r1[6] = (byte) ((i >> 8) & 255);
        r1[7] = (byte) (i & 255);
        fileOutputStream.write(r1, 0, 8);
    }

    public void m20273b(FileOutputStream fileOutputStream, int i) {
        fph com_ushareit_listenit_fph = (fph) this.f13152m.get(Integer.valueOf(i));
        m20270a(fileOutputStream, i);
        fileOutputStream.write(com_ushareit_listenit_fph.f13164c, 0, com_ushareit_listenit_fph.f13163b - 8);
    }

    public void m20267a(int i, byte[] bArr) {
        fph com_ushareit_listenit_fph = (fph) this.f13152m.get(Integer.valueOf(i));
        if (com_ushareit_listenit_fph == null) {
            com_ushareit_listenit_fph = new fph(this);
            this.f13152m.put(Integer.valueOf(i), com_ushareit_listenit_fph);
        }
        com_ushareit_listenit_fph.f13163b = bArr.length + 8;
        com_ushareit_listenit_fph.f13164c = bArr;
    }

    public void mo2514a(File file, int i, int i2) {
        int i3;
        file.createNewFile();
        FileInputStream fileInputStream = new FileInputStream(this.g);
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        m20267a(1718909296, new byte[]{(byte) 77, (byte) 52, (byte) 65, (byte) 32, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 77, (byte) 52, (byte) 65, (byte) 32, (byte) 109, (byte) 112, (byte) 52, (byte) 50, (byte) 105, (byte) 115, (byte) 111, (byte) 109, (byte) 0, (byte) 0, (byte) 0, (byte) 0});
        m20267a(1937011827, new byte[]{(byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 1, (byte) ((i2 >> 24) & 255), (byte) ((i2 >> 16) & 255), (byte) ((i2 >> 8) & 255), (byte) (i2 & 255), (byte) ((this.f13156q >> 24) & 255), (byte) ((this.f13156q >> 16) & 255), (byte) ((this.f13156q >> 8) & 255), (byte) (this.f13156q & 255)});
        m20267a(1937011555, new byte[]{(byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 1, (byte) 0, (byte) 0, (byte) 0, (byte) 1, (byte) ((i2 >> 24) & 255), (byte) ((i2 >> 16) & 255), (byte) ((i2 >> 8) & 255), (byte) (i2 & 255), (byte) 0, (byte) 0, (byte) 0, (byte) 1});
        byte[] bArr = new byte[((i2 * 4) + 12)];
        bArr[8] = (byte) ((i2 >> 24) & 255);
        bArr[9] = (byte) ((i2 >> 16) & 255);
        bArr[10] = (byte) ((i2 >> 8) & 255);
        bArr[11] = (byte) (i2 & 255);
        for (i3 = 0; i3 < i2; i3++) {
            bArr[(i3 * 4) + 12] = (byte) ((this.f13149j[i + i3] >> 24) & 255);
            bArr[(i3 * 4) + 13] = (byte) ((this.f13149j[i + i3] >> 16) & 255);
            bArr[(i3 * 4) + 14] = (byte) ((this.f13149j[i + i3] >> 8) & 255);
            bArr[(i3 * 4) + 15] = (byte) (this.f13149j[i + i3] & 255);
        }
        m20267a(1937011578, bArr);
        i3 = ((fph) this.f13152m.get(Integer.valueOf(1684631142))).f13163b + (((((((((i2 * 4) + 144) + ((fph) this.f13152m.get(Integer.valueOf(1937011556))).f13163b) + ((fph) this.f13152m.get(Integer.valueOf(1937011555))).f13163b) + ((fph) this.f13152m.get(Integer.valueOf(1836476516))).f13163b) + ((fph) this.f13152m.get(Integer.valueOf(1953196132))).f13163b) + ((fph) this.f13152m.get(Integer.valueOf(1835296868))).f13163b) + ((fph) this.f13152m.get(Integer.valueOf(1751411826))).f13163b) + ((fph) this.f13152m.get(Integer.valueOf(1936549988))).f13163b);
        m20267a(1937007471, new byte[]{(byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 1, (byte) ((i3 >> 24) & 255), (byte) ((i3 >> 16) & 255), (byte) ((i3 >> 8) & 255), (byte) (i3 & 255)});
        ((fph) this.f13152m.get(Integer.valueOf(1937007212))).f13163b = ((fph) this.f13152m.get(Integer.valueOf(1937007471))).f13163b + ((((((fph) this.f13152m.get(Integer.valueOf(1937011556))).f13163b + 8) + ((fph) this.f13152m.get(Integer.valueOf(1937011827))).f13163b) + ((fph) this.f13152m.get(Integer.valueOf(1937011555))).f13163b) + ((fph) this.f13152m.get(Integer.valueOf(1937011578))).f13163b);
        ((fph) this.f13152m.get(Integer.valueOf(1835626086))).f13163b = ((fph) this.f13152m.get(Integer.valueOf(1937007212))).f13163b + ((((fph) this.f13152m.get(Integer.valueOf(1684631142))).f13163b + 8) + ((fph) this.f13152m.get(Integer.valueOf(1936549988))).f13163b);
        ((fph) this.f13152m.get(Integer.valueOf(1835297121))).f13163b = ((fph) this.f13152m.get(Integer.valueOf(1835626086))).f13163b + ((((fph) this.f13152m.get(Integer.valueOf(1835296868))).f13163b + 8) + ((fph) this.f13152m.get(Integer.valueOf(1751411826))).f13163b);
        ((fph) this.f13152m.get(Integer.valueOf(1953653099))).f13163b = ((fph) this.f13152m.get(Integer.valueOf(1835297121))).f13163b + (((fph) this.f13152m.get(Integer.valueOf(1953196132))).f13163b + 8);
        ((fph) this.f13152m.get(Integer.valueOf(1836019574))).f13163b = ((fph) this.f13152m.get(Integer.valueOf(1953653099))).f13163b + (((fph) this.f13152m.get(Integer.valueOf(1836476516))).f13163b + 8);
        int i4 = 8;
        for (i3 = 0; i3 < i2; i3++) {
            i4 += this.f13149j[i + i3];
        }
        ((fph) this.f13152m.get(Integer.valueOf(1835295092))).f13163b = i4;
        m20273b(fileOutputStream, 1718909296);
        m20270a(fileOutputStream, 1836019574);
        m20273b(fileOutputStream, 1836476516);
        m20270a(fileOutputStream, 1953653099);
        m20273b(fileOutputStream, 1953196132);
        m20270a(fileOutputStream, 1835297121);
        m20273b(fileOutputStream, 1835296868);
        m20273b(fileOutputStream, 1751411826);
        m20270a(fileOutputStream, 1835626086);
        m20273b(fileOutputStream, 1684631142);
        m20273b(fileOutputStream, 1936549988);
        m20270a(fileOutputStream, 1937007212);
        m20273b(fileOutputStream, 1937011556);
        m20273b(fileOutputStream, 1937011827);
        m20273b(fileOutputStream, 1937011555);
        m20273b(fileOutputStream, 1937011578);
        m20273b(fileOutputStream, 1937007471);
        m20270a(fileOutputStream, 1835295092);
        i3 = 0;
        for (i4 = 0; i4 < i2; i4++) {
            if (this.f13149j[i + i4] > i3) {
                i3 = this.f13149j[i + i4];
            }
        }
        byte[] bArr2 = new byte[i3];
        i3 = 0;
        for (i4 = 0; i4 < i2; i4++) {
            int i5 = this.f13148i[i + i4] - i3;
            int i6 = this.f13149j[i + i4];
            if (i5 >= 0) {
                if (i5 > 0) {
                    fileInputStream.skip((long) i5);
                    i3 += i5;
                }
                fileInputStream.read(bArr2, 0, i6);
                fileOutputStream.write(bArr2, 0, i6);
                i3 += i6;
            }
        }
        fileInputStream.close();
        fileOutputStream.close();
    }
}
