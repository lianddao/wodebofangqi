package com.ushareit.listenit;

import android.text.TextUtils;
import android.util.Log;
import com.mopub.common.Constants;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class arj implements arr {
    public final String f5238a;
    private HttpURLConnection f5239b;
    private InputStream f5240c;
    private volatile int f5241d;
    private volatile String f5242e;

    public arj(arj com_ushareit_listenit_arj) {
        this.f5241d = Integer.MIN_VALUE;
        this.f5238a = com_ushareit_listenit_arj.f5238a;
        this.f5242e = com_ushareit_listenit_arj.f5242e;
        this.f5241d = com_ushareit_listenit_arj.f5241d;
    }

    public arj(String str) {
        this(str, arq.m6903a(str));
    }

    public arj(String str, String str2) {
        this.f5241d = Integer.MIN_VALUE;
        this.f5238a = (String) arl.m6900a(str);
        this.f5242e = str2;
    }

    private int m6892a(HttpURLConnection httpURLConnection, int i, int i2) {
        int contentLength = httpURLConnection.getContentLength();
        return i2 == 200 ? contentLength : i2 == 206 ? contentLength + i : this.f5241d;
    }

    private HttpURLConnection m6893a(int i, int i2) {
        HttpURLConnection httpURLConnection;
        String str = this.f5238a;
        int i3 = 0;
        Object obj;
        do {
            Log.d("ProxyCache", "Open connection " + (i > 0 ? " with offset " + i : "") + " to " + str);
            httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            if (i > 0) {
                httpURLConnection.setRequestProperty("Range", "bytes=" + i + "-");
            }
            if (i2 > 0) {
                httpURLConnection.setConnectTimeout(i2);
                httpURLConnection.setReadTimeout(i2);
            }
            int responseCode = httpURLConnection.getResponseCode();
            obj = (responseCode == 301 || responseCode == 302 || responseCode == 303) ? 1 : null;
            if (obj != null) {
                str = httpURLConnection.getHeaderField("Location");
                i3++;
                httpURLConnection.disconnect();
            }
            if (i3 > 5) {
                throw new arp("Too many redirects: " + i3);
            }
        } while (obj != null);
        return httpURLConnection;
    }

    private void m6894d() {
        Throwable e;
        Closeable closeable = null;
        Log.d("ProxyCache", "Read content info from " + this.f5238a);
        HttpURLConnection a;
        try {
            a = m6893a(0, Constants.TEN_SECONDS_MILLIS);
            try {
                this.f5241d = a.getContentLength();
                this.f5242e = a.getContentType();
                closeable = a.getInputStream();
                Log.i("ProxyCache", "Content info for `" + this.f5238a + "`: mime: " + this.f5242e + ", content-length: " + this.f5241d);
                arq.m6905a(closeable);
                if (a != null) {
                    a.disconnect();
                }
            } catch (IOException e2) {
                e = e2;
                try {
                    Log.e("ProxyCache", "Error fetching info from " + this.f5238a, e);
                    arq.m6905a(closeable);
                    if (a != null) {
                        a.disconnect();
                    }
                } catch (Throwable th) {
                    e = th;
                    arq.m6905a(closeable);
                    if (a != null) {
                        a.disconnect();
                    }
                    throw e;
                }
            }
        } catch (IOException e3) {
            e = e3;
            a = null;
            Log.e("ProxyCache", "Error fetching info from " + this.f5238a, e);
            arq.m6905a(closeable);
            if (a != null) {
                a.disconnect();
            }
        } catch (Throwable th2) {
            e = th2;
            a = null;
            arq.m6905a(closeable);
            if (a != null) {
                a.disconnect();
            }
            throw e;
        }
    }

    public synchronized int mo788a() {
        if (this.f5241d == Integer.MIN_VALUE) {
            m6894d();
        }
        return this.f5241d;
    }

    public int mo789a(byte[] bArr) {
        if (this.f5240c == null) {
            throw new arp("Error reading data from " + this.f5238a + ": connection is absent!");
        }
        try {
            return this.f5240c.read(bArr, 0, bArr.length);
        } catch (Throwable e) {
            throw new ark("Reading source " + this.f5238a + " is interrupted", e);
        } catch (Throwable e2) {
            throw new arp("Error reading data from " + this.f5238a, e2);
        }
    }

    public void mo790a(int i) {
        try {
            this.f5239b = m6893a(i, -1);
            this.f5242e = this.f5239b.getContentType();
            this.f5240c = new BufferedInputStream(this.f5239b.getInputStream(), 8192);
            this.f5241d = m6892a(this.f5239b, i, this.f5239b.getResponseCode());
        } catch (Throwable e) {
            throw new arp("Error opening connection for " + this.f5238a + " with offset " + i, e);
        }
    }

    public void mo791b() {
        if (this.f5239b != null) {
            try {
                this.f5239b.disconnect();
            } catch (Throwable e) {
                throw new arp("Error disconnecting HttpUrlConnection", e);
            }
        }
    }

    public synchronized String m6899c() {
        if (TextUtils.isEmpty(this.f5242e)) {
            m6894d();
        }
        return this.f5242e;
    }

    public String toString() {
        return "HttpUrlSource{url='" + this.f5238a + "}";
    }
}
