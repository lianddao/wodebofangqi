package com.ushareit.listenit;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.umeng.analytics.pro.C0277j;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class efc extends efm<efd> {
    private final Uri f10932b;
    private long f10933c;
    private efl f10934d;
    private czq f10935e;
    private long f10936f = -1;
    private String f10937g = null;
    private volatile Exception f10938h = null;
    private long f10939i = 0;
    private int f10940j;

    efc(efl com_ushareit_listenit_efl, Uri uri) {
        this.f10934d = com_ushareit_listenit_efl;
        this.f10932b = uri;
        this.f10935e = new czq(this.f10934d.m17012b().m16966d(), this.f10934d.m17012b().m16964b());
    }

    private boolean m16949a(int i) {
        return i == 308 || (i >= 200 && i < 300);
    }

    efl mo2150e() {
        return this.f10934d;
    }

    protected void mo2151f() {
        efy.m17045a().m17048c(m16948u());
    }

    efd mo2152g() {
        return new efd(this, efh.m16970a(this.f10938h, this.f10940j), this.f10933c);
    }

    void mo2153h() {
        m16926a(4, false);
        this.f10935e.m13537b();
        try {
            Object a;
            dad a2 = this.f10934d.m17014d().m13606a(this.f10934d.m17015e(), this.f10939i);
            this.f10935e.m13535a(a2, false);
            this.f10940j = a2.m13622g();
            this.f10938h = a2.m13621f() != null ? a2.m13621f() : this.f10938h;
            Object obj = (m16949a(this.f10940j) && this.f10938h == null && m16940m() == 4) ? 1 : null;
            if (obj != null) {
                this.f10936f = (long) a2.m13624i();
                a = a2.m13613a("ETag");
                if (TextUtils.isEmpty(a) || this.f10937g == null || this.f10937g.equals(a)) {
                    this.f10937g = a;
                    InputStream c = a2.m13618c();
                    if (c != null) {
                        try {
                            String str;
                            String valueOf;
                            String str2;
                            OutputStream fileOutputStream;
                            File file = new File(this.f10932b.getPath());
                            if (!file.exists()) {
                                if (this.f10939i > 0) {
                                    String str3 = "FileDownloadTask";
                                    str = "The file downloading to has been deleted:";
                                    valueOf = String.valueOf(file.getAbsolutePath());
                                    Log.e(str3, valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
                                    throw new IllegalStateException("expected a file to resume from.");
                                } else if (!file.createNewFile()) {
                                    str = "FileDownloadTask";
                                    str2 = "unable to create file:";
                                    valueOf = String.valueOf(file.getAbsolutePath());
                                    Log.w(str, valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
                                }
                            }
                            if (this.f10939i > 0) {
                                str = "FileDownloadTask";
                                str2 = "Resuming download file ";
                                valueOf = String.valueOf(file.getAbsolutePath());
                                Log.d(str, valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
                                fileOutputStream = new FileOutputStream(file, true);
                            } else {
                                fileOutputStream = new FileOutputStream(file);
                            }
                            byte[] bArr = new byte[262144];
                            do {
                                int read = c.read(bArr);
                                if (read == -1) {
                                    break;
                                }
                                fileOutputStream.write(bArr, 0, read);
                                this.f10933c += (long) read;
                            } while (m16926a(4, false));
                            fileOutputStream.flush();
                            fileOutputStream.close();
                            c.close();
                        } catch (Throwable e) {
                            Log.e("FileDownloadTask", "Exception occurred during file download", e);
                            this.f10938h = e;
                        }
                    } else {
                        this.f10938h = new IllegalStateException("Unable to open Firebase Storage stream.");
                    }
                } else {
                    Log.w("FileDownloadTask", "The file at the server has changed.  Restarting from the beginning.");
                    this.f10939i = 0;
                    this.f10937g = null;
                    a2.m13616b();
                    mo2151f();
                    return;
                }
            }
            a2.m13616b();
            a = (obj != null && this.f10938h == null && m16940m() == 4) ? 1 : null;
            if (a != null) {
                m16926a(128, false);
                return;
            }
            File file2 = new File(this.f10932b.getPath());
            if (file2.exists()) {
                this.f10939i = file2.length();
            } else {
                this.f10939i = 0;
            }
            if (m16940m() == 8) {
                m16926a(16, false);
                return;
            }
            if (!m16926a(m16940m() == 32 ? C0277j.f3694e : 64, false)) {
                Log.w("FileDownloadTask", "Unable to change download task to final state from " + m16940m());
            }
        } catch (Throwable e2) {
            Log.e("FileDownloadTask", "Unable to create firebase storage network request.", e2);
            this.f10938h = e2;
            m16926a(64, false);
        }
    }

    protected void mo2154i() {
        this.f10935e.m13533a();
    }

    /* synthetic */ efs mo2155j() {
        return mo2152g();
    }
}
