package com.ushareit.listenit;

import java.io.File;
import java.io.RandomAccessFile;

public class aqn implements aql {
    public File f5186a;
    private final aqm f5187b;
    private RandomAccessFile f5188c;

    public aqn(File file, aqm com_ushareit_listenit_aqm) {
        if (com_ushareit_listenit_aqm == null) {
            try {
                throw new NullPointerException();
            } catch (Throwable e) {
                throw new arp("Error using file " + file + " as disc cache", e);
            }
        }
        this.f5187b = com_ushareit_listenit_aqm;
        aqp.m6804a(file.getParentFile());
        boolean exists = file.exists();
        this.f5186a = exists ? file : new File(file.getParentFile(), file.getName() + ".download");
        this.f5188c = new RandomAccessFile(this.f5186a, exists ? "r" : "rw");
    }

    private boolean m6796a(File file) {
        return file.getName().endsWith(".download");
    }

    public synchronized int mo777a() {
        try {
        } catch (Throwable e) {
            throw new arp("Error reading length of file " + this.f5186a, e);
        }
        return (int) this.f5188c.length();
    }

    public synchronized int mo778a(byte[] bArr, long j, int i) {
        try {
            this.f5188c.seek(j);
        } catch (Throwable e) {
            throw new arp(String.format("Error reading %d bytes with offset %d from file[%d bytes] to buffer[%d bytes]", new Object[]{Integer.valueOf(i), Long.valueOf(j), Integer.valueOf(mo777a()), Integer.valueOf(bArr.length)}), e);
        }
        return this.f5188c.read(bArr, 0, i);
    }

    public synchronized void mo779a(byte[] bArr, int i) {
        try {
            if (mo782d()) {
                throw new arp("Error append cache: cache file " + this.f5186a + " is completed!");
            }
            this.f5188c.seek((long) mo777a());
            this.f5188c.write(bArr, 0, i);
        } catch (Throwable e) {
            throw new arp(String.format("Error writing %d bytes to %s from buffer with size %d", new Object[]{Integer.valueOf(i), this.f5188c, Integer.valueOf(bArr.length)}), e);
        }
    }

    public synchronized void mo780b() {
        try {
            this.f5188c.close();
            this.f5187b.mo783a(this.f5186a);
        } catch (Throwable e) {
            throw new arp("Error closing file " + this.f5186a, e);
        }
    }

    public synchronized void mo781c() {
        if (!mo782d()) {
            mo780b();
            File file = new File(this.f5186a.getParentFile(), this.f5186a.getName().substring(0, this.f5186a.getName().length() - ".download".length()));
            if (this.f5186a.renameTo(file)) {
                this.f5186a = file;
                try {
                    this.f5188c = new RandomAccessFile(this.f5186a, "r");
                } catch (Throwable e) {
                    throw new arp("Error opening " + this.f5186a + " as disc cache", e);
                }
            }
            throw new arp("Error renaming file " + this.f5186a + " to " + file + " for completion!");
        }
    }

    public synchronized boolean mo782d() {
        return !m6796a(this.f5186a);
    }
}
