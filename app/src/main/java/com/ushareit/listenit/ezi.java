package com.ushareit.listenit;

import android.text.TextUtils;
import android.util.Pair;
import com.mopub.common.Constants;
import com.umeng.analytics.pro.C0277j;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public final class ezi {
    protected ezx f12239a;
    private String f12240b;
    private final eyh f12241c;
    private long f12242d;
    private long f12243e;
    private String f12244f;
    private boolean f12245g;
    private boolean f12246h;
    private long f12247i;
    private long f12248j;
    private long f12249k;
    private boolean f12250l;

    public ezi(String str, eyh com_ushareit_listenit_eyh, boolean z) {
        this(str, com_ushareit_listenit_eyh, z, 0, -1);
    }

    public ezi(String str, eyh com_ushareit_listenit_eyh, boolean z, long j, long j2) {
        this.f12245g = false;
        this.f12246h = false;
        this.f12250l = euo.m18017a(eys.m18562a(), "dl_read_timeout", false);
        this.f12239a = new ezx();
        this.f12240b = str;
        this.f12241c = com_ushareit_listenit_eyh;
        this.f12242d = this.f12241c.mo2328c() ? this.f12241c.mo2332g() : 0;
        this.f12245g = z;
        this.f12248j = j;
        this.f12249k = j2;
    }

    public void m18621a(ezk com_ushareit_listenit_ezk, ezl com_ushareit_listenit_ezl) {
        m18622a(com_ushareit_listenit_ezk, com_ushareit_listenit_ezl, 15000, 15000);
    }

    public void m18622a(ezk com_ushareit_listenit_ezk, ezl com_ushareit_listenit_ezl, int i, int i2) {
        String str = "";
        try {
            str = new URL(this.f12240b).getProtocol();
        } catch (Exception e) {
        }
        m18624a(Constants.HTTPS.equalsIgnoreCase(str) ? new ezc(i, i2) : new ezf(15000, 15000), com_ushareit_listenit_ezk, com_ushareit_listenit_ezl, true);
    }

    public void m18623a(ezo com_ushareit_listenit_ezo, ezk com_ushareit_listenit_ezk, ezl com_ushareit_listenit_ezl) {
        m18624a(com_ushareit_listenit_ezo, com_ushareit_listenit_ezk, com_ushareit_listenit_ezl, false);
    }

    public boolean m18625a() {
        return this.f12246h;
    }

    protected void m18624a(ezo com_ushareit_listenit_ezo, ezk com_ushareit_listenit_ezk, ezl com_ushareit_listenit_ezl, boolean z) {
        long j;
        Throwable e;
        Throwable th;
        exw.m18443a("DownloaderEx", "completed:" + this.f12242d + ", request start:" + this.f12248j + ", request end:" + this.f12249k);
        if (com_ushareit_listenit_ezk != null && com_ushareit_listenit_ezk.m18626a()) {
            throw new ezs(8, "");
        } else if (TextUtils.isEmpty(this.f12240b)) {
            throw new ezs(0, "Empty Source Url", "Url is empty");
        } else {
            ezp com_ushareit_listenit_ezp = null;
            this.f12239a.m18652a();
            long j2 = 0;
            ezp b;
            try {
                exw.m18443a("DownloaderEx", "Ready to download " + this.f12240b);
                b = com_ushareit_listenit_ezo.mo2340b(this.f12240b);
                try {
                    b.m18593a("Accept-Ranges", "bytes");
                    if (z) {
                        b.m18593a("Connection", "Close");
                    }
                    if (this.f12242d > 0 || this.f12248j > 0 || this.f12249k != -1) {
                        b.m18592a(this.f12248j + this.f12242d, this.f12249k);
                    }
                    ezq a = com_ushareit_listenit_ezo.mo2339a(b);
                    this.f12244f = a.m18598a("Content-Type");
                    int c = a.mo2344c();
                    this.f12239a.m18655b();
                    Object obj = (c == 200 || c == 206) ? 1 : null;
                    if (obj == null) {
                        String str = "Http Status:" + c;
                        int i = 0;
                        if (c == 404) {
                            i = 5;
                            try {
                                str = str.concat("; " + m18614a(a.mo2343b()));
                            } catch (Exception e2) {
                            }
                        }
                        throw new ezs(i, this.f12240b, str);
                    }
                    long a2 = a.mo2342a();
                    this.f12247i = a2;
                    if (c == 206) {
                        Pair a3 = ezr.m18637a(a.m18598a("Content-Range"), a.mo2342a());
                        if (a3 == null) {
                            exw.m18456d("DownloaderEx", "Content-Range not found or bad format in a range download response, url = " + this.f12240b);
                            throw new ezs(0, this.f12240b, "Bad range header");
                        } else {
                            j2 = ((Long) a3.first).longValue();
                            this.f12247i = ((Long) a3.second).longValue();
                        }
                    }
                    j = j2;
                    if (a2 >= 0) {
                        try {
                            if (this.f12247i >= 0) {
                                this.f12243e = this.f12242d + a2;
                                exw.m18443a("DownloaderEx", "file length:" + this.f12243e + ", length=" + this.f12243e + ", completed=" + this.f12242d + " <- " + this.f12240b);
                                if (com_ushareit_listenit_ezl != null) {
                                    com_ushareit_listenit_ezl.m18627a(this.f12240b, this.f12247i, this.f12242d);
                                    this.f12239a.m18658c();
                                }
                                m18617a(a.mo2343b(), this.f12242d, com_ushareit_listenit_ezk, com_ushareit_listenit_ezl, this.f12245g, com_ushareit_listenit_ezo.mo2338a());
                                this.f12246h = true;
                                if (b != null) {
                                    b.mo2341a();
                                }
                                if (com_ushareit_listenit_ezl != null) {
                                    if (this.f12246h) {
                                        com_ushareit_listenit_ezl.m18629b(this.f12240b, this.f12242d, this.f12247i);
                                    }
                                    com_ushareit_listenit_ezl.m18628a(this.f12240b, this.f12246h);
                                    this.f12239a.m18663g();
                                }
                                this.f12239a.m18659c(this.f12242d - j);
                                exw.m18443a("DownloaderEx", "total download time: " + (this.f12239a.f12273a / 1000000) + " ms");
                                return;
                            }
                        } catch (FileNotFoundException e3) {
                            e = e3;
                            j2 = j;
                            com_ushareit_listenit_ezp = b;
                            try {
                                throw new ezs(12, e, "Do not create file");
                            } catch (Throwable e4) {
                                th = e4;
                                j = j2;
                                b = com_ushareit_listenit_ezp;
                                if (b != null) {
                                    b.mo2341a();
                                }
                                if (com_ushareit_listenit_ezl != null) {
                                    if (this.f12246h) {
                                        com_ushareit_listenit_ezl.m18629b(this.f12240b, this.f12242d, this.f12247i);
                                    }
                                    com_ushareit_listenit_ezl.m18628a(this.f12240b, this.f12246h);
                                    this.f12239a.m18663g();
                                }
                                this.f12239a.m18659c(this.f12242d - j);
                                exw.m18443a("DownloaderEx", "total download time: " + (this.f12239a.f12273a / 1000000) + " ms");
                                throw th;
                            }
                        } catch (IOException e5) {
                            e4 = e5;
                            j2 = j;
                            try {
                                throw new ezs(1, e4, e4.getClass().getName() + ":" + e4.getMessage());
                            } catch (Throwable e42) {
                                th = e42;
                                j = j2;
                                if (b != null) {
                                    b.mo2341a();
                                }
                                if (com_ushareit_listenit_ezl != null) {
                                    if (this.f12246h) {
                                        com_ushareit_listenit_ezl.m18629b(this.f12240b, this.f12242d, this.f12247i);
                                    }
                                    com_ushareit_listenit_ezl.m18628a(this.f12240b, this.f12246h);
                                    this.f12239a.m18663g();
                                }
                                this.f12239a.m18659c(this.f12242d - j);
                                exw.m18443a("DownloaderEx", "total download time: " + (this.f12239a.f12273a / 1000000) + " ms");
                                throw th;
                            }
                        } catch (RuntimeException e6) {
                            e42 = e6;
                            j2 = j;
                            throw new ezs(0, e42, e42.getClass().getName() + ":" + e42.getMessage());
                        } catch (Throwable e422) {
                            th = e422;
                            if (b != null) {
                                b.mo2341a();
                            }
                            if (com_ushareit_listenit_ezl != null) {
                                if (this.f12246h) {
                                    com_ushareit_listenit_ezl.m18629b(this.f12240b, this.f12242d, this.f12247i);
                                }
                                com_ushareit_listenit_ezl.m18628a(this.f12240b, this.f12246h);
                                this.f12239a.m18663g();
                            }
                            this.f12239a.m18659c(this.f12242d - j);
                            exw.m18443a("DownloaderEx", "total download time: " + (this.f12239a.f12273a / 1000000) + " ms");
                            throw th;
                        }
                    }
                    throw new ezs(0, "", "Length is less than 0");
                } catch (FileNotFoundException e7) {
                    e422 = e7;
                    com_ushareit_listenit_ezp = b;
                    throw new ezs(12, e422, "Do not create file");
                } catch (IOException e8) {
                    e422 = e8;
                    throw new ezs(1, e422, e422.getClass().getName() + ":" + e422.getMessage());
                } catch (RuntimeException e9) {
                    e422 = e9;
                    throw new ezs(0, e422, e422.getClass().getName() + ":" + e422.getMessage());
                }
            } catch (FileNotFoundException e10) {
                e422 = e10;
                throw new ezs(12, e422, "Do not create file");
            } catch (IOException e11) {
                e422 = e11;
                b = null;
                throw new ezs(1, e422, e422.getClass().getName() + ":" + e422.getMessage());
            } catch (RuntimeException e12) {
                e422 = e12;
                b = null;
                throw new ezs(0, e422, e422.getClass().getName() + ":" + e422.getMessage());
            } catch (Throwable e4222) {
                th = e4222;
                j = 0;
                b = null;
                if (b != null) {
                    b.mo2341a();
                }
                if (com_ushareit_listenit_ezl != null) {
                    if (this.f12246h) {
                        com_ushareit_listenit_ezl.m18629b(this.f12240b, this.f12242d, this.f12247i);
                    }
                    com_ushareit_listenit_ezl.m18628a(this.f12240b, this.f12246h);
                    this.f12239a.m18663g();
                }
                this.f12239a.m18659c(this.f12242d - j);
                exw.m18443a("DownloaderEx", "total download time: " + (this.f12239a.f12273a / 1000000) + " ms");
                throw th;
            }
        }
    }

    private void m18617a(InputStream inputStream, long j, ezk com_ushareit_listenit_ezk, ezl com_ushareit_listenit_ezl, boolean z, int i) {
        try {
            this.f12241c.mo2322a(eyi.Write);
            this.f12241c.mo2323a(eyi.Write, j);
            if (z) {
                m18616a(inputStream, j, com_ushareit_listenit_ezk, com_ushareit_listenit_ezl, i);
            } else {
                m18615a(inputStream, j, com_ushareit_listenit_ezk);
            }
            this.f12241c.mo2337l();
            if (this.f12242d < this.f12243e) {
                exw.m18443a("DownloaderEx", "Completed size less than file size");
                throw new ezs(2, "Completed size less than file size!");
            }
        } catch (Throwable e) {
            if (e instanceof FileNotFoundException) {
                eyv.m18566a(eys.m18562a(), this.f12241c, e);
                throw new ezs(12, e, "Create file failed");
            }
            throw new ezs(0, e, "Seek file failed");
        } catch (Throwable th) {
            this.f12241c.mo2337l();
        }
    }

    private void m18616a(InputStream inputStream, long j, ezk com_ushareit_listenit_ezk, ezl com_ushareit_listenit_ezl, int i) {
        ezw com_ushareit_listenit_ezw = new ezw(65536, m18611a(this.f12243e));
        Thread thread = new Thread(new ezj(this, com_ushareit_listenit_ezw, inputStream));
        this.f12239a.m18660d();
        thread.start();
        while (this.f12242d < this.f12243e && !Thread.currentThread().isInterrupted()) {
            ezu com_ushareit_listenit_ezu;
            ezu com_ushareit_listenit_ezu2 = null;
            int i2 = 0;
            while (com_ushareit_listenit_ezu2 == null) {
                if (!com_ushareit_listenit_ezw.m18649a()) {
                    break;
                }
                com_ushareit_listenit_ezu2 = com_ushareit_listenit_ezw.m18646b(1000);
                if (com_ushareit_listenit_ezk != null && com_ushareit_listenit_ezk.m18626a()) {
                    break;
                }
                try {
                    if (this.f12250l) {
                        i2 = com_ushareit_listenit_ezu2 == null ? i2 + 1000 : 0;
                        if (i2 > i) {
                            exw.m18456d("DownloaderEx", "get buffer timeout! url = " + this.f12240b);
                            eyv.m18567a(this.f12240b, this.f12242d == this.f12243e, i);
                        }
                    }
                } catch (InterruptedException e) {
                    thread.interrupt();
                    throw new ezs(8, "");
                }
            }
            if (com_ushareit_listenit_ezu2 != null || com_ushareit_listenit_ezw.m18649a() || com_ushareit_listenit_ezw.m18650b()) {
                com_ushareit_listenit_ezu = com_ushareit_listenit_ezu2;
            } else {
                com_ushareit_listenit_ezu = com_ushareit_listenit_ezw.m18646b(1);
            }
            if (com_ushareit_listenit_ezk != null && com_ushareit_listenit_ezk.m18626a()) {
                exw.m18443a("DownloaderEx", "the task had been canceled!");
                thread.interrupt();
                throw new ezs(8, "");
            } else if (com_ushareit_listenit_ezu == null) {
                throw new ezs(2, "download failed!");
            } else {
                try {
                    this.f12239a.m18661e();
                    this.f12241c.mo2326b(com_ushareit_listenit_ezu.f12261a, 0, com_ushareit_listenit_ezu.f12263c);
                    this.f12239a.m18662f();
                    this.f12242d += (long) com_ushareit_listenit_ezu.f12263c;
                    this.f12239a.m18654a(this.f12242d - j);
                    if (com_ushareit_listenit_ezl != null) {
                        com_ushareit_listenit_ezl.m18629b(this.f12240b, this.f12242d, this.f12247i);
                        this.f12239a.m18657b((long) com_ushareit_listenit_ezu.f12263c);
                    }
                    if (this.f12242d == this.f12243e) {
                        exw.m18443a("DownloaderEx", "download completed");
                        break;
                    }
                    com_ushareit_listenit_ezw.m18647b(com_ushareit_listenit_ezu);
                } catch (Throwable e2) {
                    throw new ezs(7, e2);
                }
            }
        }
        this.f12239a.m18656b(com_ushareit_listenit_ezw.m18651c());
    }

    private void m18615a(InputStream inputStream, long j, ezk com_ushareit_listenit_ezk) {
        byte[] bArr = new byte[8192];
        while (this.f12242d < this.f12243e && !Thread.currentThread().isInterrupted()) {
            if (com_ushareit_listenit_ezk == null || !com_ushareit_listenit_ezk.m18626a()) {
                int i = 0;
                while (i < bArr.length && this.f12242d + ((long) i) < this.f12243e) {
                    try {
                        int read = inputStream.read(bArr, i, bArr.length - i);
                        if (read <= 0) {
                            break;
                        }
                        i += read;
                        if (com_ushareit_listenit_ezk != null) {
                            if (com_ushareit_listenit_ezk.m18626a()) {
                                break;
                            }
                        }
                    } catch (Throwable e) {
                        exw.m18443a("DownloaderEx", "error while read from network");
                        throw new ezs(2, e);
                    } catch (Throwable e2) {
                        exw.m18443a("DownloaderEx", "read error while read from network");
                        throw new ezs(2, e2);
                    }
                }
                if (i < 0) {
                    return;
                }
                if (i != 0) {
                    try {
                        this.f12241c.mo2326b(bArr, 0, i);
                        this.f12242d += (long) i;
                    } catch (Throwable e22) {
                        exw.m18443a("DownloaderEx", "error while write to file");
                        throw new ezs(7, e22);
                    }
                }
            } else {
                throw new ezs(8, "");
            }
        }
    }

    private static int m18611a(long j) {
        if (j < 262144) {
            return (int) Math.ceil(((double) j) / 65536.0d);
        }
        int i = 4;
        long a = fap.m18730a();
        if (a > 256) {
            i = 8;
        }
        if (a > 512) {
            i *= 2;
        }
        if (a > 1024) {
            return i * 2;
        }
        return i;
    }

    private static int m18618b(InputStream inputStream, byte[] bArr, int i, int i2) {
        int i3 = 0;
        while (i3 < i2) {
            int read = inputStream.read(bArr, i + i3, i2 - i3);
            if (read > 0) {
                i3 += read;
                if (Thread.currentThread().isInterrupted()) {
                    return i3;
                }
            } else if (i3 > 0) {
                return i3;
            } else {
                return read;
            }
        }
        return i3;
    }

    private static String m18614a(InputStream inputStream) {
        byte[] bArr = new byte[C0277j.f3694e];
        try {
            return new String(bArr, 0, inputStream.read(bArr), "UTF-8");
        } catch (Exception e) {
            return "";
        }
    }
}
