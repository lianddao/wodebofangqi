package com.ushareit.listenit;

import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;

class gnk {
    private int f14455a;
    private boolean f14456b;
    private eyh f14457c;

    gnk(HttpURLConnection httpURLConnection, eyh com_ushareit_listenit_eyh) {
        this.f14455a = httpURLConnection.getResponseCode();
        if (this.f14455a > 400) {
            this.f14456b = false;
            m22502a(httpURLConnection);
            return;
        }
        this.f14456b = true;
        Closeable closeable = null;
        try {
            closeable = httpURLConnection.getInputStream();
        } catch (IOException e) {
            closeable = httpURLConnection.getErrorStream();
        } catch (Throwable th) {
            fbb.m18757a(closeable);
        }
        if (closeable != null) {
            eye.m18478a((InputStream) closeable, com_ushareit_listenit_eyh);
            this.f14457c = com_ushareit_listenit_eyh;
        }
        fbb.m18757a(closeable);
    }

    gnk(HttpURLConnection httpURLConnection, String str, eyh com_ushareit_listenit_eyh, int i, gni com_ushareit_listenit_gni) {
        Closeable bufferedInputStream;
        Throwable th;
        Closeable closeable = null;
        this.f14455a = httpURLConnection.getResponseCode();
        if (this.f14455a > 400) {
            this.f14456b = false;
            m22502a(httpURLConnection);
            return;
        }
        this.f14456b = true;
        Closeable inputStream;
        try {
            inputStream = httpURLConnection.getInputStream();
            if (inputStream != null) {
                try {
                    bufferedInputStream = new BufferedInputStream(inputStream);
                    try {
                        byte[] bArr = new byte[16384];
                        int g = (int) com_ushareit_listenit_eyh.mo2332g();
                        com_ushareit_listenit_eyh.mo2322a(eyi.Write);
                        com_ushareit_listenit_eyh.mo2323a(eyi.Write, com_ushareit_listenit_eyh.mo2332g());
                        while (com_ushareit_listenit_eyh.mo2328c()) {
                            int read = bufferedInputStream.read(bArr);
                            if (read != -1) {
                                com_ushareit_listenit_eyh.mo2326b(bArr, 0, read);
                                if (com_ushareit_listenit_gni != null) {
                                    g += read;
                                    com_ushareit_listenit_gni.m22496b(g, i);
                                }
                            }
                        }
                        fbb.m18757a(bufferedInputStream);
                        com_ushareit_listenit_eyh.mo2337l();
                        if (com_ushareit_listenit_eyh.mo2332g() == ((long) i)) {
                            eyh a = eyh.m18491a(str);
                            if (a.mo2328c()) {
                                a.mo2335j();
                            }
                            com_ushareit_listenit_eyh.mo2325a(a);
                        }
                        this.f14457c = com_ushareit_listenit_eyh;
                    } catch (Throwable th2) {
                        th = th2;
                        try {
                            fbb.m18757a(bufferedInputStream);
                            com_ushareit_listenit_eyh.mo2337l();
                            throw th;
                        } catch (IOException e) {
                            closeable = inputStream;
                            try {
                                m22502a(httpURLConnection);
                                if (closeable != null) {
                                    fbb.m18757a(closeable);
                                }
                            } catch (Throwable th3) {
                                th = th3;
                                inputStream = closeable;
                                if (inputStream != null) {
                                    fbb.m18757a(inputStream);
                                }
                                throw th;
                            }
                        } catch (Throwable th4) {
                            th = th4;
                            if (inputStream != null) {
                                fbb.m18757a(inputStream);
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th5) {
                    th = th5;
                    bufferedInputStream = null;
                    fbb.m18757a(bufferedInputStream);
                    com_ushareit_listenit_eyh.mo2337l();
                    throw th;
                }
            }
            if (inputStream != null) {
                fbb.m18757a(inputStream);
            }
        } catch (IOException e2) {
            m22502a(httpURLConnection);
            if (closeable != null) {
                fbb.m18757a(closeable);
            }
        } catch (Throwable th6) {
            th = th6;
            inputStream = null;
            if (inputStream != null) {
                fbb.m18757a(inputStream);
            }
            throw th;
        }
    }

    private void m22502a(HttpURLConnection httpURLConnection) {
        try {
            InputStream errorStream = httpURLConnection.getErrorStream();
            if (errorStream != null) {
                char[] cArr = new char[1024];
                StringBuilder stringBuilder = new StringBuilder();
                Reader inputStreamReader = new InputStreamReader(errorStream, "UTF-8");
                while (true) {
                    int read = inputStreamReader.read(cArr, 0, cArr.length);
                    if (read < 0) {
                        exw.m18454c("ResponseOfFile", "response error message:" + stringBuilder.toString());
                        return;
                    }
                    stringBuilder.append(cArr, 0, read);
                }
            }
        } catch (Throwable e) {
            exw.m18450b("ResponseOfFile", "The process of showing detail error info has an error", e);
        }
    }

    int m22503a() {
        return this.f14455a;
    }

    public boolean m22504b() {
        return this.f14456b;
    }

    eyh m22505c() {
        return this.f14457c;
    }

    public String toString() {
        return "ResponseOfFile{statusCode=" + this.f14455a + ", isSuccess=" + this.f14456b + ", mDownloadFile=" + this.f14457c + '}';
    }

    static eyh m22501a(String str, String str2) {
        eyh a = eyh.m18491a(str.substring(0, str.lastIndexOf(File.separator)) + File.separator + str2);
        if (!a.mo2328c()) {
            a.mo2334i();
        }
        return a;
    }
}
