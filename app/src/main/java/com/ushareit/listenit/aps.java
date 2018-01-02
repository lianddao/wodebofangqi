package com.ushareit.listenit;

import android.os.Build.VERSION;
import android.util.Log;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import javax.net.ssl.HttpsURLConnection;

public class aps {
    private static int[] f5154f = new int[20];
    private static final String f5155g = aps.class.getSimpleName();
    protected final aqj f5156a = new apt(this);
    protected final apw f5157b = new apx();
    protected aqk f5158c = new apz();
    protected int f5159d = 2000;
    protected int f5160e = 8000;
    private int f5161h = 3;
    private Map<String, String> f5162i = new TreeMap();
    private boolean f5163j;
    private Set<String> f5164k;
    private Set<String> f5165l;

    static {
        m6715c();
        if (VERSION.SDK_INT > 8) {
            m6714a();
        }
    }

    public static void m6714a() {
        if (CookieHandler.getDefault() == null) {
            CookieHandler.setDefault(new CookieManager());
        }
    }

    private static void m6715c() {
        if (VERSION.SDK_INT < 8) {
            System.setProperty("http.keepAlive", "false");
        }
    }

    private void m6716c(HttpURLConnection httpURLConnection) {
        for (String str : this.f5162i.keySet()) {
            httpURLConnection.setRequestProperty(str, (String) this.f5162i.get(str));
        }
    }

    protected int m6717a(int i) {
        return f5154f[i + 2] * 1000;
    }

    protected int m6718a(HttpURLConnection httpURLConnection, byte[] bArr) {
        OutputStream outputStream = null;
        try {
            outputStream = this.f5156a.mo764a(httpURLConnection);
            if (outputStream != null) {
                this.f5156a.mo766a(outputStream, bArr);
            }
            int responseCode = httpURLConnection.getResponseCode();
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (Exception e) {
                }
            }
            return responseCode;
        } catch (Throwable th) {
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (Exception e2) {
                }
            }
        }
    }

    public aps m6719a(String str, String str2) {
        this.f5162i.put(str, str2);
        return this;
    }

    public aqg m6720a(aqe com_ushareit_listenit_aqe) {
        int i = 0;
        long currentTimeMillis = System.currentTimeMillis();
        while (i < this.f5161h) {
            try {
                m6736c(m6717a(i));
                if (this.f5158c.mo775a()) {
                    this.f5158c.mo773a((i + 1) + "of" + this.f5161h + ", trying " + com_ushareit_listenit_aqe.m6768a());
                }
                currentTimeMillis = System.currentTimeMillis();
                aqg a = m6721a(com_ushareit_listenit_aqe.m6768a(), com_ushareit_listenit_aqe.m6769b(), com_ushareit_listenit_aqe.m6770c(), com_ushareit_listenit_aqe.m6771d());
                if (a != null) {
                    return a;
                }
                i++;
            } catch (aqf e) {
                if (m6729a((Throwable) e, currentTimeMillis) && i < this.f5161h - 1) {
                    continue;
                } else if (!this.f5156a.mo768a(e) || i >= this.f5161h - 1) {
                    throw e;
                } else {
                    try {
                        Thread.sleep((long) this.f5159d);
                    } catch (InterruptedException e2) {
                        throw e;
                    }
                }
            }
        }
        return null;
    }

    protected aqg m6721a(String str, aqc com_ushareit_listenit_aqc, String str2, byte[] bArr) {
        HttpURLConnection a;
        Throwable e;
        HttpURLConnection httpURLConnection;
        Exception exception;
        aqg com_ushareit_listenit_aqg = null;
        Object obj = 1;
        aqg com_ushareit_listenit_aqg2 = null;
        aqg a2;
        try {
            this.f5163j = false;
            a = m6724a(str);
            try {
                m6727a(a, com_ushareit_listenit_aqc, str2);
                m6716c(a);
                if (this.f5158c.mo775a()) {
                    this.f5158c.mo774a(a, bArr);
                }
                a.connect();
                this.f5163j = true;
                Object obj2 = (this.f5165l == null || this.f5165l.isEmpty()) ? null : 1;
                if (this.f5164k == null || this.f5164k.isEmpty()) {
                    obj = null;
                }
                if ((a instanceof HttpsURLConnection) && !(obj2 == null && r1 == null)) {
                    try {
                        aqh.m6782a((HttpsURLConnection) a, this.f5165l, this.f5164k);
                    } catch (Throwable e2) {
                        Log.e(f5155g, "Unable to validate SSL certificates.", e2);
                    } catch (Throwable th) {
                        e2 = th;
                        if (this.f5158c.mo775a()) {
                            this.f5158c.mo772a(com_ushareit_listenit_aqg);
                        }
                        if (a != null) {
                            a.disconnect();
                        }
                        throw e2;
                    }
                }
                if (a.getDoOutput() && bArr != null) {
                    m6718a(a, bArr);
                }
                a2 = a.getDoInput() ? m6723a(a) : new aqg(a, null);
                if (this.f5158c.mo775a()) {
                    this.f5158c.mo772a(a2);
                }
                if (a == null) {
                    return a2;
                }
                a.disconnect();
                return a2;
            } catch (Exception e3) {
                httpURLConnection = a;
                exception = e3;
                try {
                    a2 = m6732b(httpURLConnection);
                    if (a2 != null) {
                        try {
                            if (a2.m6776a() > 0) {
                                if (this.f5158c.mo775a()) {
                                    this.f5158c.mo772a(a2);
                                }
                                if (httpURLConnection != null) {
                                    return a2;
                                }
                                httpURLConnection.disconnect();
                                return a2;
                            }
                        } catch (Throwable th2) {
                            com_ushareit_listenit_aqg = a2;
                            e2 = th2;
                            a = httpURLConnection;
                            if (this.f5158c.mo775a()) {
                                this.f5158c.mo772a(com_ushareit_listenit_aqg);
                            }
                            if (a != null) {
                                a.disconnect();
                            }
                            throw e2;
                        }
                    }
                    throw new aqf(exception, a2);
                } catch (Exception e4) {
                    exception.printStackTrace();
                    if (null != null) {
                        if (com_ushareit_listenit_aqg2.m6776a() > 0) {
                            if (this.f5158c.mo775a()) {
                                this.f5158c.mo772a(null);
                            }
                            if (httpURLConnection != null) {
                                httpURLConnection.disconnect();
                            }
                            return null;
                        }
                    }
                    throw new aqf(exception, com_ushareit_listenit_aqg2);
                } catch (Throwable th3) {
                    e2 = th3;
                    a = httpURLConnection;
                    if (this.f5158c.mo775a()) {
                        this.f5158c.mo772a(com_ushareit_listenit_aqg);
                    }
                    if (a != null) {
                        a.disconnect();
                    }
                    throw e2;
                }
            } catch (Throwable th4) {
                e2 = th4;
                if (this.f5158c.mo775a()) {
                    this.f5158c.mo772a(com_ushareit_listenit_aqg);
                }
                if (a != null) {
                    a.disconnect();
                }
                throw e2;
            }
        } catch (Exception e32) {
            exception = e32;
            httpURLConnection = null;
            a2 = m6732b(httpURLConnection);
            if (a2 != null) {
                if (a2.m6776a() > 0) {
                    if (this.f5158c.mo775a()) {
                        this.f5158c.mo772a(a2);
                    }
                    if (httpURLConnection != null) {
                        return a2;
                    }
                    httpURLConnection.disconnect();
                    return a2;
                }
            }
            throw new aqf(exception, a2);
        } catch (Throwable th5) {
            e2 = th5;
            a = null;
            if (this.f5158c.mo775a()) {
                this.f5158c.mo772a(com_ushareit_listenit_aqg);
            }
            if (a != null) {
                a.disconnect();
            }
            throw e2;
        }
    }

    public aqg m6722a(String str, aqi com_ushareit_listenit_aqi) {
        return m6730b(new aqb(str, com_ushareit_listenit_aqi));
    }

    protected aqg m6723a(HttpURLConnection httpURLConnection) {
        InputStream b;
        Throwable th;
        byte[] bArr = null;
        try {
            b = this.f5156a.mo770b(httpURLConnection);
            if (b != null) {
                try {
                    bArr = this.f5156a.mo769a(b);
                } catch (Throwable th2) {
                    th = th2;
                    if (b != null) {
                        try {
                            b.close();
                        } catch (Exception e) {
                        }
                    }
                    throw th;
                }
            }
            aqg com_ushareit_listenit_aqg = new aqg(httpURLConnection, bArr);
            if (b != null) {
                try {
                    b.close();
                } catch (Exception e2) {
                }
            }
            return com_ushareit_listenit_aqg;
        } catch (Throwable th3) {
            th = th3;
            b = null;
            if (b != null) {
                b.close();
            }
            throw th;
        }
    }

    protected HttpURLConnection m6724a(String str) {
        try {
            URL url = new URL(str);
            return this.f5156a.mo765a(str);
        } catch (Throwable e) {
            throw new IllegalArgumentException(str + " is not a valid URL", e);
        }
    }

    protected void m6725a(aqe com_ushareit_listenit_aqe, apu com_ushareit_listenit_apu) {
        this.f5157b.mo771a(this, com_ushareit_listenit_apu).mo776a(com_ushareit_listenit_aqe);
    }

    public void m6726a(String str, aqi com_ushareit_listenit_aqi, apu com_ushareit_listenit_apu) {
        m6725a(new aqd(str, com_ushareit_listenit_aqi), com_ushareit_listenit_apu);
    }

    protected void m6727a(HttpURLConnection httpURLConnection, aqc com_ushareit_listenit_aqc, String str) {
        httpURLConnection.setConnectTimeout(this.f5159d);
        httpURLConnection.setReadTimeout(this.f5160e);
        this.f5156a.mo767a(httpURLConnection, com_ushareit_listenit_aqc, str);
    }

    public void m6728a(Set<String> set) {
        this.f5165l = set;
    }

    protected boolean m6729a(Throwable th, long j) {
        long currentTimeMillis = (System.currentTimeMillis() - j) + 10;
        if (this.f5158c.mo775a()) {
            this.f5158c.mo773a("ELAPSED TIME = " + currentTimeMillis + ", CT = " + this.f5159d + ", RT = " + this.f5160e);
        }
        return this.f5163j ? currentTimeMillis >= ((long) this.f5160e) : currentTimeMillis >= ((long) this.f5159d);
    }

    public aqg m6730b(aqe com_ushareit_listenit_aqe) {
        aqg com_ushareit_listenit_aqg = null;
        try {
            com_ushareit_listenit_aqg = m6721a(com_ushareit_listenit_aqe.m6768a(), com_ushareit_listenit_aqe.m6769b(), com_ushareit_listenit_aqe.m6770c(), com_ushareit_listenit_aqe.m6771d());
        } catch (aqf e) {
            this.f5156a.mo768a(e);
        } catch (Exception e2) {
            this.f5156a.mo768a(new aqf(e2, com_ushareit_listenit_aqg));
        }
        return com_ushareit_listenit_aqg;
    }

    public aqg m6731b(String str, aqi com_ushareit_listenit_aqi) {
        return m6730b(new aqd(str, com_ushareit_listenit_aqi));
    }

    protected aqg m6732b(HttpURLConnection httpURLConnection) {
        InputStream errorStream;
        Throwable th;
        byte[] bArr = null;
        try {
            errorStream = httpURLConnection.getErrorStream();
            if (errorStream != null) {
                try {
                    bArr = this.f5156a.mo769a(errorStream);
                } catch (Throwable th2) {
                    th = th2;
                    if (errorStream != null) {
                        try {
                            errorStream.close();
                        } catch (Exception e) {
                        }
                    }
                    throw th;
                }
            }
            aqg com_ushareit_listenit_aqg = new aqg(httpURLConnection, bArr);
            if (errorStream != null) {
                try {
                    errorStream.close();
                } catch (Exception e2) {
                }
            }
            return com_ushareit_listenit_aqg;
        } catch (Throwable th3) {
            th = th3;
            errorStream = null;
            if (errorStream != null) {
                errorStream.close();
            }
            throw th;
        }
    }

    public aqi m6733b() {
        return new aqi();
    }

    public void m6734b(int i) {
        if (i < 1 || i > 18) {
            throw new IllegalArgumentException("Maximum retries must be between 1 and 18");
        }
        this.f5161h = i;
    }

    public void m6735b(Set<String> set) {
        this.f5164k = set;
    }

    public void m6736c(int i) {
        this.f5159d = i;
    }
}
