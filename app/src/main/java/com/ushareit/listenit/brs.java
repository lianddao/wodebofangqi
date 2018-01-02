package com.ushareit.listenit;

import android.net.Uri;
import java.io.EOFException;
import java.io.IOException;
import java.io.RandomAccessFile;

public final class brs implements brh {
    private final bsf<? super brs> f7563a;
    private RandomAccessFile f7564b;
    private Uri f7565c;
    private long f7566d;
    private boolean f7567e;

    public brs() {
        this(null);
    }

    public brs(bsf<? super brs> com_ushareit_listenit_bsf__super_com_ushareit_listenit_brs) {
        this.f7563a = com_ushareit_listenit_bsf__super_com_ushareit_listenit_brs;
    }

    public long mo1088a(brk com_ushareit_listenit_brk) {
        try {
            this.f7565c = com_ushareit_listenit_brk.f7504a;
            this.f7564b = new RandomAccessFile(com_ushareit_listenit_brk.f7504a.getPath(), "r");
            this.f7564b.seek(com_ushareit_listenit_brk.f7507d);
            this.f7566d = com_ushareit_listenit_brk.f7508e == -1 ? this.f7564b.length() - com_ushareit_listenit_brk.f7507d : com_ushareit_listenit_brk.f7508e;
            if (this.f7566d < 0) {
                throw new EOFException();
            }
            this.f7567e = true;
            if (this.f7563a != null) {
                this.f7563a.mo1098a((Object) this, com_ushareit_listenit_brk);
            }
            return this.f7566d;
        } catch (IOException e) {
            throw new brt(e);
        }
    }

    public int mo1087a(byte[] bArr, int i, int i2) {
        if (i2 == 0) {
            return 0;
        }
        if (this.f7566d == 0) {
            return -1;
        }
        try {
            int read = this.f7564b.read(bArr, i, (int) Math.min(this.f7566d, (long) i2));
            if (read <= 0) {
                return read;
            }
            this.f7566d -= (long) read;
            if (this.f7563a == null) {
                return read;
            }
            this.f7563a.mo1097a((Object) this, read);
            return read;
        } catch (IOException e) {
            throw new brt(e);
        }
    }

    public void mo1089a() {
        this.f7565c = null;
        try {
            if (this.f7564b != null) {
                this.f7564b.close();
            }
            this.f7564b = null;
            if (this.f7567e) {
                this.f7567e = false;
                if (this.f7563a != null) {
                    this.f7563a.mo1096a(this);
                }
            }
        } catch (IOException e) {
            throw new brt(e);
        } catch (Throwable th) {
            this.f7564b = null;
            if (this.f7567e) {
                this.f7567e = false;
                if (this.f7563a != null) {
                    this.f7563a.mo1096a(this);
                }
            }
        }
    }
}
