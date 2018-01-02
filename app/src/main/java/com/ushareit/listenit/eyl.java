package com.ushareit.listenit;

import android.content.Context;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.FileChannel;

public class eyl extends eyh {
    private static boolean f12184g = false;
    private fl f12185a;
    private String f12186b;
    private fl f12187c;
    private ParcelFileDescriptor f12188d;
    private OutputStream f12189e;
    private InputStream f12190f;

    public eyl(fl flVar) {
        exu.m18430a((Object) flVar);
        this.f12185a = flVar;
    }

    public eyl(Uri uri, boolean z) {
        Context a = eys.m18562a();
        exu.m18433a(fl.m19697c(a, uri));
        if (z) {
            this.f12185a = fl.m19696b(a, uri);
            String[] split = uri.getLastPathSegment().substring(this.f12185a.mo2483a().getLastPathSegment().length()).split(File.separator);
            fl flVar = this.f12185a;
            fl flVar2 = flVar;
            for (Object obj : split) {
                if (!TextUtils.isEmpty(obj)) {
                    flVar2 = flVar2.m19701b(obj);
                    if (flVar2 == null) {
                        exu.m18432a("This uri can not create document!");
                        return;
                    }
                }
            }
            if (flVar2 != null) {
                this.f12185a = flVar2;
                return;
            }
            return;
        }
        this.f12185a = fl.m19695a(a, uri);
    }

    public eyl(eyl com_ushareit_listenit_eyl, String str) {
        this.f12187c = com_ushareit_listenit_eyl.f12185a;
        if (str.startsWith(File.separator)) {
            str = str.substring(1);
        }
        this.f12186b = str;
    }

    public boolean mo2324a() {
        if (!(this.f12185a != null || this.f12187c == null || this.f12186b == null)) {
            this.f12185a = this.f12187c.m19701b(this.f12186b);
        }
        return this.f12185a == null ? false : this.f12185a.mo2490f();
    }

    public boolean mo2327b() {
        if (!(this.f12185a != null || this.f12187c == null || this.f12186b == null)) {
            this.f12185a = this.f12187c.m19701b(this.f12186b);
        }
        return this.f12185a == null ? false : this.f12185a.mo2489e();
    }

    public boolean mo2328c() {
        if (this.f12185a != null) {
            return this.f12185a.mo2492h();
        }
        if (this.f12187c == null || this.f12186b == null) {
            return false;
        }
        String[] split = this.f12186b.split(File.separator);
        fl flVar = this.f12187c;
        for (Object obj : split) {
            if (!TextUtils.isEmpty(obj)) {
                flVar = flVar.m19701b(obj);
                if (flVar == null) {
                    return false;
                }
            }
        }
        this.f12185a = flVar;
        return true;
    }

    public eyh mo2329d() {
        if (this.f12187c != null) {
            return new eyl(this.f12187c);
        }
        fl c = this.f12185a.m19703c();
        return c == null ? null : new eyl(c);
    }

    public String mo2330e() {
        if (this.f12185a != null) {
            return this.f12185a.mo2483a().toString();
        }
        if (this.f12187c == null || this.f12186b == null) {
            return "";
        }
        String[] split = this.f12186b.split(File.separator);
        fl flVar = this.f12187c;
        fl flVar2 = flVar;
        for (Object obj : split) {
            if (!TextUtils.isEmpty(obj)) {
                flVar2 = flVar2.m19701b(obj);
                if (flVar2 == null) {
                    return "";
                }
            }
        }
        this.f12185a = flVar2;
        return this.f12185a.mo2483a().toString();
    }

    public String mo2331f() {
        if (this.f12185a != null) {
            return this.f12185a.mo2486b();
        }
        if (!(this.f12187c == null || TextUtils.isEmpty(this.f12186b))) {
            String[] split = this.f12186b.split(File.separator);
            if (split.length == 0) {
                return this.f12186b;
            }
            for (int length = split.length - 1; length >= 0; length--) {
                if (!TextUtils.isEmpty(split[length])) {
                    return split[length];
                }
            }
        }
        return "";
    }

    public long mo2332g() {
        if (!(this.f12185a != null || this.f12187c == null || this.f12186b == null)) {
            String[] split = this.f12186b.split(File.separator);
            fl flVar = this.f12187c;
            fl flVar2 = flVar;
            for (Object obj : split) {
                if (!TextUtils.isEmpty(obj)) {
                    flVar2 = flVar2.m19701b(obj);
                    if (flVar2 == null) {
                        return 0;
                    }
                }
            }
            this.f12185a = flVar2;
        }
        return this.f12185a != null ? this.f12185a.mo2488d() : 0;
    }

    public boolean mo2333h() {
        if (this.f12187c == null || this.f12186b == null) {
            return false;
        }
        String[] split = this.f12186b.split(File.separator);
        fl flVar = this.f12187c;
        int length = split.length;
        int i = 0;
        while (i < length) {
            String str = split[i];
            fl b = flVar.m19701b(str);
            if (b == null) {
                try {
                    b = flVar.mo2484a(str);
                } catch (SecurityException e) {
                    exw.m18456d("FSDocument", "can not create directory, need authority!");
                    b = flVar;
                }
                if (b == null || !b.mo2492h()) {
                    return false;
                }
            }
            i++;
            flVar = b;
        }
        this.f12185a = flVar;
        return true;
    }

    public boolean mo2334i() {
        if (this.f12187c == null || this.f12186b == null) {
            return false;
        }
        try {
            this.f12185a = this.f12187c.mo2485a("", this.f12186b);
        } catch (SecurityException e) {
            exw.m18456d("FSDocument", "can not create file, need authority!");
        }
        if (this.f12185a != null) {
            return true;
        }
        return false;
    }

    public boolean mo2335j() {
        long j;
        boolean z = false;
        try {
            if (this.f12185a != null) {
                z = this.f12185a.mo2491g();
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                }
                return z;
            } else if (this.f12187c == null || this.f12186b == null) {
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e2) {
                }
                return z;
            } else {
                this.f12185a = this.f12187c.m19701b(this.f12186b);
                if (this.f12185a != null) {
                    z = this.f12185a.mo2491g();
                }
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e3) {
                }
                return z;
            }
        } catch (SecurityException e4) {
            j = "can not delete file, need authority!";
            exw.m18456d("FSDocument", j);
            try {
                Thread.sleep(j);
            } catch (InterruptedException e5) {
            }
            return z;
        } finally {
            j = 200;
            try {
                Thread.sleep(200);
            } catch (InterruptedException e6) {
            }
        }
    }

    public boolean mo2325a(eyh com_ushareit_listenit_eyh) {
        if (this.f12185a == null || !this.f12185a.mo2492h()) {
            return false;
        }
        if (f12184g) {
            String e = com_ushareit_listenit_eyh.mo2330e();
            String lastPathSegment = this.f12185a.mo2483a().getLastPathSegment();
            String[] split = e.split(File.separator);
            String[] split2 = lastPathSegment.split(File.separator);
            int length = split.length - 1;
            int length2 = split2.length - 1;
            int i = 0;
            while (i < length && i < length2 && split[i].equals(split2[i])) {
                i++;
            }
            e = "";
            int i2 = length2 - i;
            length = 0;
            while (length < i2) {
                length++;
                e = e + ".." + File.separator;
            }
            while (i < split.length) {
                e = e + split[i] + (i == split.length + -1 ? "" : File.separator);
                i++;
            }
            try {
                return this.f12185a.mo2487c(e);
            } catch (SecurityException e2) {
                exw.m18456d("FSDocument", "can not renameto file, need authority!");
                return false;
            }
        }
        try {
            eye.m18477a((eyh) this, com_ushareit_listenit_eyh);
            return true;
        } catch (IOException e3) {
            return false;
        }
    }

    public File mo2336k() {
        if (this.f12185a == null) {
            this.f12185a = this.f12187c.m19701b(this.f12186b);
        }
        if (this.f12185a == null) {
            return new File("");
        }
        String[] split = this.f12185a.mo2483a().getLastPathSegment().split(":");
        if (split.length == 0) {
            return new File("");
        }
        String str;
        for (eyk com_ushareit_listenit_eyk : eyj.m18514b(eys.m18562a())) {
            str = TextUtils.isEmpty(com_ushareit_listenit_eyk.f12176b) ? com_ushareit_listenit_eyk.f12175a ? "primary" : "" : com_ushareit_listenit_eyk.f12176b;
            if (str.equals(split[0]) || ("primary".equals(split[0]) && TextUtils.isEmpty(com_ushareit_listenit_eyk.f12176b) && !com_ushareit_listenit_eyk.f12175a)) {
                str = com_ushareit_listenit_eyk.f12178d;
                break;
            }
        }
        str = null;
        if (str == null) {
            return new File("");
        }
        return split.length < 2 ? new File(str) : new File(str, split[1]);
    }

    public void mo2322a(eyi com_ushareit_listenit_eyi) {
        Context a = eys.m18562a();
        if (!(this.f12185a != null || this.f12187c == null || this.f12186b == null)) {
            this.f12185a = this.f12187c.mo2485a("", this.f12186b);
        }
        if (this.f12185a == null) {
            throw new IllegalArgumentException("Can not create file!");
        }
        this.f12188d = a.getContentResolver().openFileDescriptor(this.f12185a.mo2483a(), "rw");
        if (com_ushareit_listenit_eyi == eyi.RW || com_ushareit_listenit_eyi == eyi.Write) {
            this.f12189e = new FileOutputStream(this.f12188d.getFileDescriptor());
        } else if (com_ushareit_listenit_eyi == eyi.Read) {
            this.f12190f = new FileInputStream(this.f12188d.getFileDescriptor());
        }
    }

    public void mo2323a(eyi com_ushareit_listenit_eyi, long j) {
        FileChannel fileChannel = null;
        if (com_ushareit_listenit_eyi == eyi.RW || com_ushareit_listenit_eyi == eyi.Write) {
            fileChannel = ((FileOutputStream) this.f12189e).getChannel();
        } else if (com_ushareit_listenit_eyi == eyi.Read) {
            fileChannel = ((FileInputStream) this.f12190f).getChannel();
        }
        fileChannel.position(j);
    }

    public void mo2326b(byte[] bArr, int i, int i2) {
        if (this.f12189e == null) {
            throw new IOException("Target file do not opened!");
        }
        this.f12189e.write(bArr, i, i2);
    }

    public int mo2320a(byte[] bArr) {
        if (this.f12190f != null) {
            return this.f12190f.read(bArr);
        }
        throw new IOException("Target file do not opened!");
    }

    public int mo2321a(byte[] bArr, int i, int i2) {
        if (this.f12190f != null) {
            return this.f12190f.read(bArr, i, i2);
        }
        throw new IOException("Target file do not opened!");
    }

    public void mo2337l() {
        if (this.f12189e != null) {
            fbb.m18757a(this.f12189e);
            this.f12189e = null;
        }
        if (this.f12190f != null) {
            fbb.m18757a(this.f12190f);
            this.f12190f = null;
        }
    }
}
