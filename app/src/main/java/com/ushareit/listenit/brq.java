package com.ushareit.listenit;

import android.text.TextUtils;
import android.util.Log;
import com.mopub.common.Constants;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.NoRouteToHostException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class brq implements bru {
    private static final Pattern f7541b = Pattern.compile("^bytes (\\d+)-(\\d+)/(\\d+)$");
    private static final AtomicReference<byte[]> f7542c = new AtomicReference();
    private final boolean f7543d;
    private final int f7544e;
    private final int f7545f;
    private final String f7546g;
    private final bsu<String> f7547h;
    private final HashMap<String, String> f7548i = new HashMap();
    private final bsf<? super brq> f7549j;
    private brk f7550k;
    private HttpURLConnection f7551l;
    private InputStream f7552m;
    private boolean f7553n;
    private long f7554o;
    private long f7555p;
    private long f7556q;
    private long f7557r;

    public brq(String str, bsu<String> com_ushareit_listenit_bsu_java_lang_String, bsf<? super brq> com_ushareit_listenit_bsf__super_com_ushareit_listenit_brq, int i, int i2, boolean z) {
        this.f7546g = bsg.m9655a(str);
        this.f7547h = com_ushareit_listenit_bsu_java_lang_String;
        this.f7549j = com_ushareit_listenit_bsf__super_com_ushareit_listenit_brq;
        this.f7544e = i;
        this.f7545f = i2;
        this.f7543d = z;
    }

    public long mo1088a(brk com_ushareit_listenit_brk) {
        long j = 0;
        this.f7550k = com_ushareit_listenit_brk;
        this.f7557r = 0;
        this.f7556q = 0;
        try {
            this.f7551l = m9610b(com_ushareit_listenit_brk);
            try {
                int responseCode = this.f7551l.getResponseCode();
                if (responseCode < 200 || responseCode > 299) {
                    Map headerFields = this.f7551l.getHeaderFields();
                    m9612d();
                    brz com_ushareit_listenit_brz = new brz(responseCode, headerFields, com_ushareit_listenit_brk);
                    if (responseCode == 416) {
                        com_ushareit_listenit_brz.initCause(new brj(0));
                    }
                    throw com_ushareit_listenit_brz;
                }
                String contentType = this.f7551l.getContentType();
                if (this.f7547h == null || this.f7547h.mo1100a(contentType)) {
                    if (responseCode == 200 && com_ushareit_listenit_brk.f7507d != 0) {
                        j = com_ushareit_listenit_brk.f7507d;
                    }
                    this.f7554o = j;
                    if ((com_ushareit_listenit_brk.f7510g & 1) != 0) {
                        this.f7555p = com_ushareit_listenit_brk.f7508e;
                    } else if (com_ushareit_listenit_brk.f7508e != -1) {
                        this.f7555p = com_ushareit_listenit_brk.f7508e;
                    } else {
                        j = m9605a(this.f7551l);
                        this.f7555p = j != -1 ? j - this.f7554o : -1;
                    }
                    try {
                        this.f7552m = this.f7551l.getInputStream();
                        this.f7553n = true;
                        if (this.f7549j != null) {
                            this.f7549j.mo1098a((Object) this, com_ushareit_listenit_brk);
                        }
                        return this.f7555p;
                    } catch (IOException e) {
                        m9612d();
                        throw new brx(e, com_ushareit_listenit_brk, 1);
                    }
                }
                m9612d();
                throw new bry(contentType, com_ushareit_listenit_brk);
            } catch (IOException e2) {
                m9612d();
                throw new brx("Unable to connect to " + com_ushareit_listenit_brk.f7504a.toString(), e2, com_ushareit_listenit_brk, 1);
            }
        } catch (IOException e22) {
            throw new brx("Unable to connect to " + com_ushareit_listenit_brk.f7504a.toString(), e22, com_ushareit_listenit_brk, 1);
        }
    }

    public int mo1087a(byte[] bArr, int i, int i2) {
        try {
            m9611c();
            return m9609b(bArr, i, i2);
        } catch (IOException e) {
            throw new brx(e, this.f7550k, 2);
        }
    }

    public void mo1089a() {
        try {
            if (this.f7552m != null) {
                m9608a(this.f7551l, m9616b());
                this.f7552m.close();
            }
            this.f7552m = null;
            m9612d();
            if (this.f7553n) {
                this.f7553n = false;
                if (this.f7549j != null) {
                    this.f7549j.mo1096a(this);
                }
            }
        } catch (IOException e) {
            throw new brx(e, this.f7550k, 3);
        } catch (Throwable th) {
            this.f7552m = null;
            m9612d();
            if (this.f7553n) {
                this.f7553n = false;
                if (this.f7549j != null) {
                    this.f7549j.mo1096a(this);
                }
            }
        }
    }

    protected final long m9616b() {
        return this.f7555p == -1 ? this.f7555p : this.f7555p - this.f7557r;
    }

    private HttpURLConnection m9610b(brk com_ushareit_listenit_brk) {
        URL url = new URL(com_ushareit_listenit_brk.f7504a.toString());
        byte[] bArr = com_ushareit_listenit_brk.f7505b;
        long j = com_ushareit_listenit_brk.f7507d;
        long j2 = com_ushareit_listenit_brk.f7508e;
        boolean z = (com_ushareit_listenit_brk.f7510g & 1) != 0;
        if (!this.f7543d) {
            return m9606a(url, bArr, j, j2, z, true);
        }
        HttpURLConnection a;
        int i = 0;
        while (true) {
            int i2 = i + 1;
            if (i <= 20) {
                a = m9606a(url, bArr, j, j2, z, false);
                int responseCode = a.getResponseCode();
                if (responseCode == 300 || responseCode == 301 || responseCode == 302 || responseCode == 303 || (bArr == null && (responseCode == 307 || responseCode == 308))) {
                    bArr = null;
                    String headerField = a.getHeaderField("Location");
                    a.disconnect();
                    url = m9607a(url, headerField);
                    i = i2;
                }
            } else {
                throw new NoRouteToHostException("Too many redirects: " + i2);
            }
        }
        return a;
    }

    private HttpURLConnection m9606a(URL url, byte[] bArr, long j, long j2, boolean z, boolean z2) {
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setConnectTimeout(this.f7544e);
        httpURLConnection.setReadTimeout(this.f7545f);
        synchronized (this.f7548i) {
            for (Entry entry : this.f7548i.entrySet()) {
                httpURLConnection.setRequestProperty((String) entry.getKey(), (String) entry.getValue());
            }
        }
        if (!(j == 0 && j2 == -1)) {
            String str = "bytes=" + j + "-";
            if (j2 != -1) {
                str = str + ((j + j2) - 1);
            }
            httpURLConnection.setRequestProperty("Range", str);
        }
        httpURLConnection.setRequestProperty("User-Agent", this.f7546g);
        if (!z) {
            httpURLConnection.setRequestProperty("Accept-Encoding", "identity");
        }
        httpURLConnection.setInstanceFollowRedirects(z2);
        httpURLConnection.setDoOutput(bArr != null);
        if (bArr != null) {
            httpURLConnection.setRequestMethod("POST");
            if (bArr.length == 0) {
                httpURLConnection.connect();
            } else {
                httpURLConnection.setFixedLengthStreamingMode(bArr.length);
                httpURLConnection.connect();
                OutputStream outputStream = httpURLConnection.getOutputStream();
                outputStream.write(bArr);
                outputStream.close();
            }
        } else {
            httpURLConnection.connect();
        }
        return httpURLConnection;
    }

    private static URL m9607a(URL url, String str) {
        if (str == null) {
            throw new ProtocolException("Null location redirect");
        }
        URL url2 = new URL(url, str);
        String protocol = url2.getProtocol();
        if (Constants.HTTPS.equals(protocol) || Constants.HTTP.equals(protocol)) {
            return url2;
        }
        throw new ProtocolException("Unsupported protocol redirect: " + protocol);
    }

    private static long m9605a(HttpURLConnection httpURLConnection) {
        long j = -1;
        String headerField = httpURLConnection.getHeaderField("Content-Length");
        if (!TextUtils.isEmpty(headerField)) {
            try {
                j = Long.parseLong(headerField);
            } catch (NumberFormatException e) {
                Log.e("DefaultHttpDataSource", "Unexpected Content-Length [" + headerField + "]");
            }
        }
        String headerField2 = httpURLConnection.getHeaderField("Content-Range");
        if (TextUtils.isEmpty(headerField2)) {
            return j;
        }
        Matcher matcher = f7541b.matcher(headerField2);
        if (!matcher.find()) {
            return j;
        }
        try {
            long parseLong = (Long.parseLong(matcher.group(2)) - Long.parseLong(matcher.group(1))) + 1;
            if (j < 0) {
                return parseLong;
            }
            if (j == parseLong) {
                return j;
            }
            Log.w("DefaultHttpDataSource", "Inconsistent headers [" + headerField + "] [" + headerField2 + "]");
            return Math.max(j, parseLong);
        } catch (NumberFormatException e2) {
            Log.e("DefaultHttpDataSource", "Unexpected Content-Range [" + headerField2 + "]");
            return j;
        }
    }

    private void m9611c() {
        if (this.f7556q != this.f7554o) {
            Object obj = (byte[]) f7542c.getAndSet(null);
            if (obj == null) {
                obj = new byte[4096];
            }
            while (this.f7556q != this.f7554o) {
                int read = this.f7552m.read(obj, 0, (int) Math.min(this.f7554o - this.f7556q, (long) obj.length));
                if (Thread.interrupted()) {
                    throw new InterruptedIOException();
                } else if (read == -1) {
                    throw new EOFException();
                } else {
                    this.f7556q += (long) read;
                    if (this.f7549j != null) {
                        this.f7549j.mo1097a((Object) this, read);
                    }
                }
            }
            f7542c.set(obj);
        }
    }

    private int m9609b(byte[] bArr, int i, int i2) {
        if (i2 == 0) {
            return 0;
        }
        if (this.f7555p != -1) {
            long j = this.f7555p - this.f7557r;
            if (j == 0) {
                return -1;
            }
            i2 = (int) Math.min((long) i2, j);
        }
        int read = this.f7552m.read(bArr, i, i2);
        if (read != -1) {
            this.f7557r += (long) read;
            if (this.f7549j != null) {
                this.f7549j.mo1097a((Object) this, read);
            }
            return read;
        } else if (this.f7555p == -1) {
            return -1;
        } else {
            throw new EOFException();
        }
    }

    private static void m9608a(HttpURLConnection httpURLConnection, long j) {
        if (btc.f7662a == 19 || btc.f7662a == 20) {
            try {
                InputStream inputStream = httpURLConnection.getInputStream();
                if (j == -1) {
                    if (inputStream.read() == -1) {
                        return;
                    }
                } else if (j <= 2048) {
                    return;
                }
                String name = inputStream.getClass().getName();
                if (name.equals("com.android.okhttp.internal.http.HttpTransport$ChunkedInputStream") || name.equals("com.android.okhttp.internal.http.HttpTransport$FixedLengthInputStream")) {
                    Method declaredMethod = inputStream.getClass().getSuperclass().getDeclaredMethod("unexpectedEndOfInput", new Class[0]);
                    declaredMethod.setAccessible(true);
                    declaredMethod.invoke(inputStream, new Object[0]);
                }
            } catch (Exception e) {
            }
        }
    }

    private void m9612d() {
        if (this.f7551l != null) {
            try {
                this.f7551l.disconnect();
            } catch (Throwable e) {
                Log.e("DefaultHttpDataSource", "Unexpected error while disconnecting", e);
            }
            this.f7551l = null;
        }
    }
}
