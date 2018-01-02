package com.ushareit.listenit;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import java.util.Map.Entry;

class dxn implements Runnable {
    final /* synthetic */ dxj f10575a;
    private final URL f10576b;
    private final byte[] f10577c;
    private final dxl f10578d;
    private final String f10579e;
    private final Map<String, String> f10580f;

    public dxn(dxj com_ushareit_listenit_dxj, String str, URL url, byte[] bArr, Map<String, String> map, dxl com_ushareit_listenit_dxl) {
        this.f10575a = com_ushareit_listenit_dxj;
        cfi.m11082a(str);
        cfi.m11080a((Object) url);
        cfi.m11080a((Object) com_ushareit_listenit_dxl);
        this.f10576b = url;
        this.f10577c = bArr;
        this.f10578d = com_ushareit_listenit_dxl;
        this.f10579e = str;
        this.f10580f = map;
    }

    public void run() {
        HttpURLConnection a;
        OutputStream outputStream;
        Throwable e;
        Map map;
        int i;
        HttpURLConnection httpURLConnection;
        Throwable th;
        Map map2;
        this.f10575a.mo2082i();
        int i2 = 0;
        try {
            this.f10575a.m16270a(this.f10579e);
            a = this.f10575a.m16269a(this.f10576b);
            try {
                if (this.f10580f != null) {
                    for (Entry entry : this.f10580f.entrySet()) {
                        a.addRequestProperty((String) entry.getKey(), (String) entry.getValue());
                    }
                }
                if (this.f10577c != null) {
                    byte[] a2 = this.f10575a.mo2092s().m15958a(this.f10577c);
                    this.f10575a.mo2096w().m16235E().m16264a("Uploading data. size", Integer.valueOf(a2.length));
                    a.setDoOutput(true);
                    a.addRequestProperty("Content-Encoding", "gzip");
                    a.setFixedLengthStreamingMode(a2.length);
                    a.connect();
                    outputStream = a.getOutputStream();
                    try {
                        outputStream.write(a2);
                        outputStream.close();
                    } catch (IOException e2) {
                        e = e2;
                        map = null;
                        i = 0;
                        httpURLConnection = a;
                        if (outputStream != null) {
                            try {
                                outputStream.close();
                            } catch (IOException e3) {
                                this.f10575a.mo2096w().m16242f().m16264a("Error closing HTTP compressed POST connection output stream", e3);
                            }
                        }
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        this.f10575a.m16275g();
                        this.f10575a.mo2095v().m16380a(new dxm(this.f10579e, this.f10578d, i, e, null, map));
                    } catch (Throwable th2) {
                        th = th2;
                        map2 = null;
                        if (outputStream != null) {
                            try {
                                outputStream.close();
                            } catch (IOException e32) {
                                this.f10575a.mo2096w().m16242f().m16264a("Error closing HTTP compressed POST connection output stream", e32);
                            }
                        }
                        if (a != null) {
                            a.disconnect();
                        }
                        this.f10575a.m16275g();
                        this.f10575a.mo2095v().m16380a(new dxm(this.f10579e, this.f10578d, i2, null, null, map2));
                        throw th;
                    }
                }
                i2 = a.getResponseCode();
                map2 = a.getHeaderFields();
            } catch (IOException e4) {
                e = e4;
                map = null;
                i = i2;
                outputStream = null;
                httpURLConnection = a;
                if (outputStream != null) {
                    outputStream.close();
                }
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                this.f10575a.m16275g();
                this.f10575a.mo2095v().m16380a(new dxm(this.f10579e, this.f10578d, i, e, null, map));
            } catch (Throwable th3) {
                th = th3;
                map2 = null;
                outputStream = null;
                if (outputStream != null) {
                    outputStream.close();
                }
                if (a != null) {
                    a.disconnect();
                }
                this.f10575a.m16275g();
                this.f10575a.mo2095v().m16380a(new dxm(this.f10579e, this.f10578d, i2, null, null, map2));
                throw th;
            }
            try {
                byte[] a3 = this.f10575a.m16268a(a);
                if (a != null) {
                    a.disconnect();
                }
                this.f10575a.m16275g();
                this.f10575a.mo2095v().m16380a(new dxm(this.f10579e, this.f10578d, i2, null, a3, map2));
            } catch (IOException e5) {
                e = e5;
                map = map2;
                i = i2;
                outputStream = null;
                httpURLConnection = a;
                if (outputStream != null) {
                    outputStream.close();
                }
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                this.f10575a.m16275g();
                this.f10575a.mo2095v().m16380a(new dxm(this.f10579e, this.f10578d, i, e, null, map));
            } catch (Throwable th32) {
                th = th32;
                outputStream = null;
                if (outputStream != null) {
                    outputStream.close();
                }
                if (a != null) {
                    a.disconnect();
                }
                this.f10575a.m16275g();
                this.f10575a.mo2095v().m16380a(new dxm(this.f10579e, this.f10578d, i2, null, null, map2));
                throw th;
            }
        } catch (IOException e6) {
            e = e6;
            map = null;
            i = 0;
            outputStream = null;
            httpURLConnection = null;
            if (outputStream != null) {
                outputStream.close();
            }
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            this.f10575a.m16275g();
            this.f10575a.mo2095v().m16380a(new dxm(this.f10579e, this.f10578d, i, e, null, map));
        } catch (Throwable th322) {
            th = th322;
            map2 = null;
            a = null;
            outputStream = null;
            if (outputStream != null) {
                outputStream.close();
            }
            if (a != null) {
                a.disconnect();
            }
            this.f10575a.m16275g();
            this.f10575a.mo2095v().m16380a(new dxm(this.f10579e, this.f10578d, i2, null, null, map2));
            throw th;
        }
    }
}
