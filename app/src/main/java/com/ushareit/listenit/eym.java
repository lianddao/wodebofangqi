package com.ushareit.listenit;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class eym extends eyh {
    private File f12191a;
    private RandomAccessFile f12192b;

    public eym(File file) {
        exu.m18430a((Object) file);
        this.f12191a = file;
    }

    public eym(String str) {
        this.f12191a = new File(str);
    }

    public eym(eym com_ushareit_listenit_eym, String str) {
        this.f12191a = new File(com_ushareit_listenit_eym.f12191a, str);
    }

    public boolean mo2324a() {
        return this.f12191a.canWrite();
    }

    public boolean mo2327b() {
        return this.f12191a.canRead();
    }

    public boolean mo2328c() {
        return this.f12191a.exists();
    }

    public eyh mo2329d() {
        File parentFile = this.f12191a.getParentFile();
        return parentFile != null ? new eym(parentFile) : null;
    }

    public String mo2330e() {
        return this.f12191a.getAbsolutePath();
    }

    public String mo2331f() {
        return this.f12191a.getName();
    }

    public long mo2332g() {
        return this.f12191a.length();
    }

    public boolean mo2333h() {
        return this.f12191a.mkdirs();
    }

    public boolean mo2334i() {
        try {
            return this.f12191a.createNewFile();
        } catch (IOException e) {
            return false;
        }
    }

    public boolean mo2335j() {
        return this.f12191a.delete();
    }

    public boolean mo2325a(eyh com_ushareit_listenit_eyh) {
        return this.f12191a.renameTo(((eym) com_ushareit_listenit_eyh).f12191a);
    }

    public File mo2336k() {
        return this.f12191a;
    }

    public void mo2322a(eyi com_ushareit_listenit_eyi) {
        String str = "rw";
        if (com_ushareit_listenit_eyi == eyi.Read) {
            str = "r";
        }
        this.f12192b = new RandomAccessFile(this.f12191a, str);
    }

    public void mo2323a(eyi com_ushareit_listenit_eyi, long j) {
        this.f12192b.seek(j);
    }

    public void mo2326b(byte[] bArr, int i, int i2) {
        if (this.f12192b == null) {
            throw new IOException("Target file do not opened!");
        }
        this.f12192b.write(bArr, i, i2);
    }

    public int mo2320a(byte[] bArr) {
        if (this.f12192b != null) {
            return this.f12192b.read(bArr);
        }
        throw new IOException("Target file do not opened!");
    }

    public int mo2321a(byte[] bArr, int i, int i2) {
        if (this.f12192b != null) {
            return this.f12192b.read(bArr, i, i2);
        }
        throw new IOException("Target file do not opened!");
    }

    public void mo2337l() {
        fbb.m18757a(this.f12192b);
    }
}
