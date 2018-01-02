package com.ushareit.listenit;

import java.io.File;
import java.io.RandomAccessFile;
import java.util.zip.CRC32;
import java.util.zip.ZipException;

final class C0358h {
    static long m23425a(File file) {
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
        try {
            long a = C0358h.m23426a(randomAccessFile, C0358h.m23427a(randomAccessFile));
            return a;
        } finally {
            randomAccessFile.close();
        }
    }

    static C0359i m23427a(RandomAccessFile randomAccessFile) {
        long j = 0;
        long length = randomAccessFile.length() - 22;
        if (length < 0) {
            throw new ZipException("File too short to be a zip file: " + randomAccessFile.length());
        }
        long j2 = length - 65536;
        if (j2 >= 0) {
            j = j2;
        }
        int reverseBytes = Integer.reverseBytes(101010256);
        j2 = length;
        do {
            randomAccessFile.seek(j2);
            if (randomAccessFile.readInt() == reverseBytes) {
                randomAccessFile.skipBytes(2);
                randomAccessFile.skipBytes(2);
                randomAccessFile.skipBytes(2);
                randomAccessFile.skipBytes(2);
                C0359i c0359i = new C0359i();
                c0359i.f15578b = ((long) Integer.reverseBytes(randomAccessFile.readInt())) & 4294967295L;
                c0359i.f15577a = ((long) Integer.reverseBytes(randomAccessFile.readInt())) & 4294967295L;
                return c0359i;
            }
            j2--;
        } while (j2 >= j);
        throw new ZipException("End Of Central Directory signature not found");
    }

    static long m23426a(RandomAccessFile randomAccessFile, C0359i c0359i) {
        CRC32 crc32 = new CRC32();
        long j = c0359i.f15578b;
        randomAccessFile.seek(c0359i.f15577a);
        byte[] bArr = new byte[16384];
        int read = randomAccessFile.read(bArr, 0, (int) Math.min(16384, j));
        while (read != -1) {
            crc32.update(bArr, 0, read);
            j -= (long) read;
            if (j == 0) {
                break;
            }
            read = randomAccessFile.read(bArr, 0, (int) Math.min(16384, j));
        }
        return crc32.getValue();
    }
}
