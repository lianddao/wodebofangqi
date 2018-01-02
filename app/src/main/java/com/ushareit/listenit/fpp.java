package com.ushareit.listenit;

import com.umeng.analytics.pro.dm;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class fpp extends fpm {
    private int f13199a;
    private int[] f13200b;
    private int[] f13201h;
    private int[] f13202i;
    private int f13203j;
    private int f13204k;
    private int f13205l;
    private int f13206m;
    private int f13207n;

    public static fpn m20315a() {
        return new fpq();
    }

    public int mo2515b() {
        return this.f13199a;
    }

    public int mo2516c() {
        return this.f13205l / 50;
    }

    public int[] mo2517d() {
        return this.f13202i;
    }

    public int mo2518e() {
        return ((this.f13205l * this.f13206m) * 2) / 1024;
    }

    public int mo2519f() {
        return this.f13205l;
    }

    public String mo2520g() {
        return "WAV";
    }

    public void mo2513a(File file) {
        super.mo2513a(file);
        this.f13204k = (int) this.g.length();
        if (this.f13204k < 128) {
            throw new IOException("File too small to parse");
        }
        FileInputStream fileInputStream = new FileInputStream(this.g);
        byte[] bArr = new byte[12];
        fileInputStream.read(bArr, 0, 12);
        this.f13207n += 12;
        if (bArr[0] == (byte) 82 && bArr[1] == (byte) 73 && bArr[2] == (byte) 70 && bArr[3] == (byte) 70 && bArr[8] == (byte) 87 && bArr[9] == (byte) 65 && bArr[10] == (byte) 86 && bArr[11] == (byte) 69) {
            this.f13206m = 0;
            this.f13205l = 0;
            while (this.f13207n + 8 <= this.f13204k) {
                bArr = new byte[8];
                fileInputStream.read(bArr, 0, 8);
                this.f13207n += 8;
                int i = ((((bArr[7] & 255) << 24) | ((bArr[6] & 255) << 16)) | ((bArr[5] & 255) << 8)) | (bArr[4] & 255);
                int abs;
                if (bArr[0] != (byte) 102 || bArr[1] != (byte) 109 || bArr[2] != (byte) 116 || bArr[3] != (byte) 32) {
                    if (bArr[0] == (byte) 100 && bArr[1] == (byte) 97 && bArr[2] == (byte) 116 && bArr[3] == (byte) 97) {
                        if (this.f13206m != 0 && this.f13205l != 0) {
                            this.f13203j = ((this.f13205l * this.f13206m) / 50) * 2;
                            this.f13199a = ((this.f13203j - 1) + i) / this.f13203j;
                            this.f13200b = new int[this.f13199a];
                            this.f13201h = new int[this.f13199a];
                            this.f13202i = new int[this.f13199a];
                            byte[] bArr2 = new byte[this.f13203j];
                            int i2 = 0;
                            int i3 = 0;
                            while (i3 < i) {
                                int i4 = this.f13203j;
                                if (i3 + i4 > i) {
                                    i3 = i - i4;
                                }
                                fileInputStream.read(bArr2, 0, i4);
                                int i5 = 0;
                                int i6 = 1;
                                while (i6 < i4) {
                                    abs = Math.abs(bArr2[i6]);
                                    if (abs <= i5) {
                                        abs = i5;
                                    }
                                    i6 = (this.f13206m * 4) + i6;
                                    i5 = abs;
                                }
                                this.f13200b[i2] = this.f13207n;
                                this.f13201h[i2] = i4;
                                this.f13202i[i2] = i5;
                                abs = i2 + 1;
                                this.f13207n += i4;
                                i3 += i4;
                                if (this.f != null && !this.f.m20314a((((double) i3) * 1.0d) / ((double) i))) {
                                    break;
                                }
                                i2 = abs;
                            }
                        } else {
                            throw new IOException("Bad WAV file: data chunk before fmt chunk");
                        }
                    }
                    fileInputStream.skip((long) i);
                    this.f13207n += i;
                } else if (i < 16 || i > 1024) {
                    throw new IOException("WAV file has bad fmt chunk");
                } else {
                    bArr = new byte[i];
                    fileInputStream.read(bArr, 0, i);
                    this.f13207n += i;
                    abs = ((bArr[1] & 255) << 8) | (bArr[0] & 255);
                    this.f13206m = ((bArr[3] & 255) << 8) | (bArr[2] & 255);
                    this.f13205l = (bArr[4] & 255) | ((((bArr[7] & 255) << 24) | ((bArr[6] & 255) << 16)) | ((bArr[5] & 255) << 8));
                    if (abs != 1) {
                        throw new IOException("Unsupported WAV file encoding");
                    }
                }
            }
            return;
        }
        throw new IOException("Not a WAV file");
    }

    public void mo2514a(File file, int i, int i2) {
        int i3;
        file.createNewFile();
        FileInputStream fileInputStream = new FileInputStream(this.g);
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        long j = 0;
        for (i3 = 0; i3 < i2; i3++) {
            j += (long) this.f13201h[i + i3];
        }
        long j2 = 36 + j;
        long j3 = (long) this.f13205l;
        long j4 = (long) ((this.f13205l * 2) * this.f13206m);
        fileOutputStream.write(new byte[]{(byte) 82, (byte) 73, (byte) 70, (byte) 70, (byte) ((int) (255 & j2)), (byte) ((int) ((j2 >> 8) & 255)), (byte) ((int) ((j2 >> 16) & 255)), (byte) ((int) ((j2 >> 24) & 255)), (byte) 87, (byte) 65, (byte) 86, (byte) 69, (byte) 102, (byte) 109, (byte) 116, (byte) 32, dm.f3664n, (byte) 0, (byte) 0, (byte) 0, (byte) 1, (byte) 0, (byte) this.f13206m, (byte) 0, (byte) ((int) (255 & j3)), (byte) ((int) ((j3 >> 8) & 255)), (byte) ((int) ((j3 >> 16) & 255)), (byte) ((int) ((j3 >> 24) & 255)), (byte) ((int) (255 & j4)), (byte) ((int) ((j4 >> 8) & 255)), (byte) ((int) ((j4 >> 16) & 255)), (byte) ((int) ((j4 >> 24) & 255)), (byte) (this.f13206m * 2), (byte) 0, dm.f3664n, (byte) 0, (byte) 100, (byte) 97, (byte) 116, (byte) 97, (byte) ((int) (255 & j)), (byte) ((int) ((j >> 8) & 255)), (byte) ((int) ((j >> 16) & 255)), (byte) ((int) ((j >> 24) & 255))}, 0, 44);
        byte[] bArr = new byte[this.f13203j];
        i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            int i5 = this.f13200b[i + i4] - i3;
            int i6 = this.f13201h[i + i4];
            if (i5 >= 0) {
                if (i5 > 0) {
                    fileInputStream.skip((long) i5);
                    i3 += i5;
                }
                fileInputStream.read(bArr, 0, i6);
                fileOutputStream.write(bArr, 0, i6);
                i3 += i6;
            }
        }
        fileInputStream.close();
        fileOutputStream.close();
    }
}
