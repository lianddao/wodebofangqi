package com.ushareit.listenit;

import java.io.File;
import java.io.RandomAccessFile;

public class agy implements afw {
    public File f4353a;
    private final agx f4354b;
    private RandomAccessFile f4355c;

    public agy(File file, agx com_ushareit_listenit_agx) {
        if (com_ushareit_listenit_agx == null) {
            try {
                throw new NullPointerException();
            } catch (Throwable e) {
                throw new ags("Error using file " + file + " as disc cache", e);
            }
        }
        this.f4354b = com_ushareit_listenit_agx;
        aha.m5613a(file.getParentFile());
        boolean exists = file.exists();
        this.f4353a = exists ? file : new File(file.getParentFile(), file.getName() + ".download");
        this.f4355c = new RandomAccessFile(this.f4353a, exists ? "r" : "rw");
    }

    public synchronized long mo623a() {
        try {
        } catch (Throwable e) {
            throw new ags("Error reading length of file " + this.f4353a, e);
        }
        return (long) ((int) this.f4355c.length());
    }

    public synchronized int mo622a(byte[] bArr, long j, int i) {
        try {
            this.f4355c.seek(j);
        } catch (Throwable e) {
            throw new ags(String.format("Error reading %d bytes with offset %d from file[%d bytes] to buffer[%d bytes]", new Object[]{Integer.valueOf(i), Long.valueOf(j), Long.valueOf(mo623a()), Integer.valueOf(bArr.length)}), e);
        }
        return this.f4355c.read(bArr, 0, i);
    }

    public synchronized void mo624a(byte[] bArr, int i) {
        try {
            if (mo627d()) {
                throw new ags("Error append cache: cache file " + this.f4353a + " is completed!");
            }
            this.f4355c.seek(mo623a());
            this.f4355c.write(bArr, 0, i);
        } catch (Throwable e) {
            throw new ags(String.format("Error writing %d bytes to %s from buffer with size %d", new Object[]{Integer.valueOf(i), this.f4355c, Integer.valueOf(bArr.length)}), e);
        }
    }

    public synchronized void mo625b() {
        try {
            this.f4355c.close();
            this.f4354b.mo628a(this.f4353a);
        } catch (Throwable e) {
            throw new ags("Error closing file " + this.f4353a, e);
        }
    }

    public synchronized void mo626c() {
        if (!mo627d()) {
            mo625b();
            File file = new File(this.f4353a.getParentFile(), this.f4353a.getName().substring(0, this.f4353a.getName().length() - ".download".length()));
            if (this.f4353a.renameTo(file)) {
                this.f4353a = file;
                try {
                    this.f4355c = new RandomAccessFile(this.f4353a, "r");
                    this.f4354b.mo628a(this.f4353a);
                } catch (Throwable e) {
                    throw new ags("Error opening " + this.f4353a + " as disc cache", e);
                }
            }
            throw new ags("Error renaming file " + this.f4353a + " to " + file + " for completion!");
        }
    }

    public synchronized boolean mo627d() {
        return !m5605a(this.f4353a);
    }

    private boolean m5605a(File file) {
        return file.getName().endsWith(".download");
    }
}
