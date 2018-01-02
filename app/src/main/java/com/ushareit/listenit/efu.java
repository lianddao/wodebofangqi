package com.ushareit.listenit;

import android.content.ContentResolver;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.api.Status;
import com.umeng.analytics.pro.C0277j;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONException;
import org.json.JSONObject;

public class efu extends efm<efw> {
    private final efl f10984b;
    private final Uri f10985c;
    private final byte[] f10986d;
    private final byte[] f10987e = new byte[262144];
    private final long f10988f;
    private final AtomicLong f10989g = new AtomicLong(0);
    private czq f10990h;
    private InputStream f10991i;
    private volatile efi f10992j;
    private volatile Uri f10993k = null;
    private volatile Exception f10994l = null;
    private volatile Exception f10995m = null;
    private volatile int f10996n = 0;
    private volatile String f10997o;

    efu(efl com_ushareit_listenit_efl, efi com_ushareit_listenit_efi, Uri uri, Uri uri2) {
        long statSize;
        long j;
        Throwable th;
        InputStream openInputStream;
        Exception exception;
        String str;
        String str2;
        String valueOf;
        long j2;
        InputStream inputStream;
        String str3;
        String str4;
        long j3 = -1;
        cfi.m11080a((Object) com_ushareit_listenit_efl);
        cfi.m11080a((Object) uri);
        this.f10986d = null;
        this.f10984b = com_ushareit_listenit_efl;
        this.f10992j = com_ushareit_listenit_efi;
        this.f10985c = uri;
        this.f10990h = new czq(this.f10984b.m17013c(), this.f10984b.m17012b().m16965c());
        ContentResolver contentResolver = this.f10984b.m17012b().m16966d().m16618a().getContentResolver();
        try {
            ParcelFileDescriptor openFileDescriptor = contentResolver.openFileDescriptor(this.f10985c, "r");
            if (openFileDescriptor != null) {
                statSize = openFileDescriptor.getStatSize();
                try {
                    openFileDescriptor.close();
                } catch (Throwable e) {
                    Throwable th2 = e;
                    j = statSize;
                    th = th2;
                    try {
                        Log.w("UploadTask", "NullPointerException during file size calculation.", th);
                        openInputStream = contentResolver.openInputStream(this.f10985c);
                        if (openInputStream == null) {
                            try {
                            } catch (Exception e2) {
                                exception = e2;
                                str = "UploadTask";
                                str2 = "could not locate file for uploading:";
                                valueOf = String.valueOf(this.f10985c.toString());
                                Log.e(str, valueOf.length() == 0 ? new String(str2) : str2.concat(valueOf));
                                this.f10994l = exception;
                                j2 = j3;
                                inputStream = openInputStream;
                                statSize = j2;
                                this.f10988f = statSize;
                                this.f10991i = inputStream;
                                this.f10993k = uri2;
                            }
                        }
                        j2 = j3;
                        inputStream = openInputStream == null ? new BufferedInputStream(openInputStream) : openInputStream;
                        statSize = j2;
                    } catch (Exception e22) {
                        j3 = j;
                        openInputStream = null;
                        exception = e22;
                        str = "UploadTask";
                        str2 = "could not locate file for uploading:";
                        valueOf = String.valueOf(this.f10985c.toString());
                        if (valueOf.length() == 0) {
                        }
                        Log.e(str, valueOf.length() == 0 ? new String(str2) : str2.concat(valueOf));
                        this.f10994l = exception;
                        j2 = j3;
                        inputStream = openInputStream;
                        statSize = j2;
                        this.f10988f = statSize;
                        this.f10991i = inputStream;
                        this.f10993k = uri2;
                    }
                    this.f10988f = statSize;
                    this.f10991i = inputStream;
                    this.f10993k = uri2;
                } catch (IOException e3) {
                    j3 = statSize;
                    try {
                        str3 = "UploadTask";
                        str4 = "could not retrieve file size for upload ";
                        valueOf = String.valueOf(this.f10985c.toString());
                        Log.w(str3, valueOf.length() == 0 ? str4.concat(valueOf) : new String(str4));
                        openInputStream = contentResolver.openInputStream(this.f10985c);
                        j2 = j3;
                        inputStream = openInputStream == null ? new BufferedInputStream(openInputStream) : openInputStream;
                        statSize = j2;
                    } catch (Exception e222) {
                        exception = e222;
                        openInputStream = null;
                        str = "UploadTask";
                        str2 = "could not locate file for uploading:";
                        valueOf = String.valueOf(this.f10985c.toString());
                        if (valueOf.length() == 0) {
                        }
                        Log.e(str, valueOf.length() == 0 ? new String(str2) : str2.concat(valueOf));
                        this.f10994l = exception;
                        j2 = j3;
                        inputStream = openInputStream;
                        statSize = j2;
                        this.f10988f = statSize;
                        this.f10991i = inputStream;
                        this.f10993k = uri2;
                    }
                    this.f10988f = statSize;
                    this.f10991i = inputStream;
                    this.f10993k = uri2;
                } catch (Exception e4) {
                    exception = e4;
                    j3 = statSize;
                    openInputStream = null;
                    str = "UploadTask";
                    str2 = "could not locate file for uploading:";
                    valueOf = String.valueOf(this.f10985c.toString());
                    if (valueOf.length() == 0) {
                    }
                    Log.e(str, valueOf.length() == 0 ? new String(str2) : str2.concat(valueOf));
                    this.f10994l = exception;
                    j2 = j3;
                    inputStream = openInputStream;
                    statSize = j2;
                    this.f10988f = statSize;
                    this.f10991i = inputStream;
                    this.f10993k = uri2;
                }
            }
            statSize = -1;
            j3 = statSize;
        } catch (NullPointerException e5) {
            th = e5;
            j = -1;
            Log.w("UploadTask", "NullPointerException during file size calculation.", th);
            openInputStream = contentResolver.openInputStream(this.f10985c);
            if (openInputStream == null) {
            }
            j2 = j3;
            inputStream = openInputStream == null ? new BufferedInputStream(openInputStream) : openInputStream;
            statSize = j2;
            this.f10988f = statSize;
            this.f10991i = inputStream;
            this.f10993k = uri2;
        } catch (IOException e6) {
            str3 = "UploadTask";
            str4 = "could not retrieve file size for upload ";
            valueOf = String.valueOf(this.f10985c.toString());
            if (valueOf.length() == 0) {
            }
            Log.w(str3, valueOf.length() == 0 ? str4.concat(valueOf) : new String(str4));
            openInputStream = contentResolver.openInputStream(this.f10985c);
            if (openInputStream == null) {
            }
            j2 = j3;
            inputStream = openInputStream == null ? new BufferedInputStream(openInputStream) : openInputStream;
            statSize = j2;
            this.f10988f = statSize;
            this.f10991i = inputStream;
            this.f10993k = uri2;
        }
        openInputStream = contentResolver.openInputStream(this.f10985c);
        if (openInputStream == null) {
        }
        j2 = j3;
        inputStream = openInputStream == null ? new BufferedInputStream(openInputStream) : openInputStream;
        statSize = j2;
        this.f10988f = statSize;
        this.f10991i = inputStream;
        this.f10993k = uri2;
    }

    private boolean m17026a(int i) {
        return i == 308 || (i >= 200 && i < 300);
    }

    private boolean m17027a(dad com_ushareit_listenit_dad) {
        com_ushareit_listenit_dad.m13615a(czv.m13545a(this.f10984b.m17013c()), this.f10984b.m17013c().m16618a());
        return m17030c(com_ushareit_listenit_dad);
    }

    private boolean m17028a(boolean z) {
        try {
            dad b = this.f10984b.m17014d().m13611b(this.f10984b.m17015e(), this.f10993k.toString());
            if ("final".equals(this.f10997o)) {
                return false;
            }
            if (z) {
                if (!m17029b(b)) {
                    return false;
                }
            } else if (!m17027a(b)) {
                return false;
            }
            if ("final".equals(b.m13613a("X-Goog-Upload-Status"))) {
                this.f10994l = new IOException("The server has terminated the upload session");
                return false;
            }
            Object a = b.m13613a("X-Goog-Upload-Size-Received");
            long parseLong = !TextUtils.isEmpty(a) ? Long.parseLong(a) : 0;
            long j = this.f10989g.get();
            if (j > parseLong) {
                this.f10994l = new IOException("Unexpected error. The server lost a chunk update.");
                return false;
            }
            if (j < parseLong) {
                try {
                    if (this.f10991i.skip(parseLong - j) != parseLong - j) {
                        this.f10994l = new IOException("Unexpected end of stream encountered.");
                        return false;
                    } else if (!this.f10989g.compareAndSet(j, parseLong)) {
                        Log.e("UploadTask", "Somehow, the uploaded bytes changed during an uploaded.  This should nothappen");
                        this.f10994l = new IllegalStateException("uploaded bytes changed unexpectedly.");
                        return false;
                    }
                } catch (Throwable e) {
                    Log.e("UploadTask", "Unable to recover position in Stream during resumable upload", e);
                    this.f10994l = e;
                    return false;
                }
            }
            return true;
        } catch (Throwable e2) {
            Log.e("UploadTask", "Unable to recover status during resumable upload", e2);
            this.f10994l = e2;
            return false;
        }
    }

    private boolean m17029b(dad com_ushareit_listenit_dad) {
        this.f10990h.m13534a(com_ushareit_listenit_dad);
        return m17030c(com_ushareit_listenit_dad);
    }

    private boolean m17030c(dad com_ushareit_listenit_dad) {
        int g = com_ushareit_listenit_dad.m13622g();
        if (this.f10990h.m13536a(g)) {
            g = -2;
        }
        this.f10996n = g;
        this.f10995m = com_ushareit_listenit_dad.m13621f();
        this.f10997o = com_ushareit_listenit_dad.m13613a("X-Goog-Upload-Status");
        return m17026a(this.f10996n) && this.f10995m == null;
    }

    private void m17031v() {
        Throwable e;
        JSONObject jSONObject = null;
        if (this.f10992j != null) {
            String a = this.f10992j.m16993a();
        } else {
            CharSequence charSequence = null;
        }
        if (this.f10985c != null && TextUtils.isEmpty(r0)) {
            a = this.f10984b.m17012b().m16966d().m16618a().getContentResolver().getType(this.f10985c);
        }
        if (TextUtils.isEmpty(a)) {
            a = "application/octet-stream";
        }
        try {
            dac d = this.f10984b.m17014d();
            Uri e2 = this.f10984b.m17015e();
            if (this.f10992j != null) {
                jSONObject = this.f10992j.m16998f();
            }
            dad a2 = d.m13609a(e2, jSONObject, a);
            if (m17029b(a2)) {
                Object a3 = a2.m13613a("X-Goog-Upload-URL");
                if (!TextUtils.isEmpty(a3)) {
                    this.f10993k = Uri.parse(a3);
                }
            }
        } catch (JSONException e3) {
            e = e3;
            Log.e("UploadTask", "Unable to create a network request from metadata", e);
            this.f10994l = e;
        } catch (RemoteException e4) {
            e = e4;
            Log.e("UploadTask", "Unable to create a network request from metadata", e);
            this.f10994l = e;
        }
    }

    private boolean m17032w() {
        if (m16940m() == 128) {
            return false;
        }
        if (Thread.interrupted()) {
            this.f10994l = new InterruptedException();
            m16926a(64, false);
            return false;
        } else if (m16940m() == 32) {
            m16926a((int) C0277j.f3694e, false);
            return false;
        } else if (m16940m() == 8) {
            m16926a(16, false);
            return false;
        } else if (!m17033x()) {
            return false;
        } else {
            if (this.f10993k == null) {
                if (this.f10994l == null) {
                    this.f10994l = new IllegalStateException("Unable to obtain an upload URL.");
                }
                m16926a(64, false);
                return false;
            } else if (this.f10994l != null) {
                m16926a(64, false);
                return false;
            } else {
                boolean z = this.f10995m != null || this.f10996n < 200 || this.f10996n >= 300;
                if (!z || m17028a(true)) {
                    return true;
                }
                if (!m17033x()) {
                    return false;
                }
                m16926a(64, false);
                return false;
            }
        }
    }

    private boolean m17033x() {
        if (!"final".equals(this.f10997o)) {
            return true;
        }
        if (this.f10994l == null) {
            this.f10994l = new IOException("The server has terminated the upload session");
        }
        m16926a(64, false);
        return false;
    }

    private void m17034y() {
        Throwable e;
        String str;
        String str2;
        String valueOf;
        this.f10991i.mark(this.f10987e.length + 1);
        try {
            int read = this.f10991i.read(this.f10987e);
            try {
                dad a = this.f10984b.m17014d().m13608a(this.f10984b.m17015e(), this.f10993k.toString(), this.f10987e, this.f10989g.get(), read, ((long) read) != 262144);
                if (m17027a(a)) {
                    if (read != -1) {
                        this.f10989g.getAndAdd((long) read);
                    }
                    if (((long) read) != 262144) {
                        try {
                            this.f10992j = new efk(a.m13619d(), this.f10984b).m17000a();
                            m16926a(4, false);
                            m16926a(128, false);
                            return;
                        } catch (JSONException e2) {
                            e = e2;
                            str = "UploadTask";
                            str2 = "Unable to parse resulting metadata from upload:";
                            valueOf = String.valueOf(a.m13620e());
                            Log.e(str, valueOf.length() == 0 ? str2.concat(valueOf) : new String(str2), e);
                            this.f10994l = e;
                            return;
                        } catch (RemoteException e3) {
                            e = e3;
                            str = "UploadTask";
                            str2 = "Unable to parse resulting metadata from upload:";
                            valueOf = String.valueOf(a.m13620e());
                            if (valueOf.length() == 0) {
                            }
                            Log.e(str, valueOf.length() == 0 ? str2.concat(valueOf) : new String(str2), e);
                            this.f10994l = e;
                            return;
                        }
                    }
                    return;
                }
                try {
                    this.f10991i.reset();
                } catch (Throwable e4) {
                    Log.w("UploadTask", "Unable to reset the stream for error recovery.", e4);
                    this.f10994l = e4;
                }
            } catch (Throwable e42) {
                Log.e("UploadTask", "Unable to create chunk upload request", e42);
                this.f10994l = e42;
            }
        } catch (Throwable e422) {
            Log.e("UploadTask", "Unable to read bytes for uploading", e422);
            this.f10994l = e422;
        }
    }

    efl mo2150e() {
        return this.f10984b;
    }

    protected void mo2151f() {
        efy.m17045a().m17047b(m16948u());
    }

    efw mo2152g() {
        return new efw(this, efh.m16970a(this.f10994l != null ? this.f10994l : this.f10995m, this.f10996n), this.f10989g.get(), this.f10993k, this.f10992j);
    }

    void mo2153h() {
        this.f10990h.m13537b();
        if (this.f10984b.m17008a() == null) {
            this.f10994l = new IllegalArgumentException("Cannot upload to getRoot. You should upload to a storage location such as .getReference('image.png').putFile...");
        }
        if (this.f10994l != null) {
            m16926a(64, false);
            return;
        }
        if (this.f10993k == null) {
            m17031v();
        } else {
            m17028a(false);
        }
        while (m17032w()) {
            m16926a(4, false);
            m17034y();
        }
    }

    protected void mo2154i() {
        dad a;
        this.f10990h.m13533a();
        try {
            a = this.f10984b.m17014d().m13607a(this.f10984b.m17015e(), this.f10993k.toString());
        } catch (Throwable e) {
            Log.e("UploadTask", "Unable to create chunk upload request", e);
            a = null;
        }
        if (a != null) {
            efy.m17045a().m17046a(new efv(this, a));
        }
        this.f10994l = efh.m16969a(Status.f1690e);
        super.mo2154i();
    }

    /* synthetic */ efs mo2155j() {
        return mo2152g();
    }
}
