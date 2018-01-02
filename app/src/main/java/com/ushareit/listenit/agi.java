package com.ushareit.listenit;

import android.text.TextUtils;
import com.mopub.common.Constants;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class agi implements agu {
    private static final hjm f4333a = hjn.m23936a("HttpUrlSource");
    private final ahj f4334b;
    private agv f4335c;
    private HttpURLConnection f4336d;
    private InputStream f4337e;

    public agi(String str) {
        this(str, ahk.m5641a());
    }

    public agi(String str, ahj com_ushareit_listenit_ahj) {
        this.f4334b = (ahj) ago.m5589a((Object) com_ushareit_listenit_ahj);
        agv a = com_ushareit_listenit_ahj.mo631a(str);
        if (a == null) {
            a = new agv(str, -2147483648L, agt.m5594a(str));
        }
        this.f4335c = a;
    }

    public agi(agi com_ushareit_listenit_agi) {
        this.f4335c = com_ushareit_listenit_agi.f4335c;
        this.f4334b = com_ushareit_listenit_agi.f4334b;
    }

    public synchronized long mo619a() {
        if (this.f4335c.f4350b == -2147483648L) {
            m5573e();
        }
        return this.f4335c.f4350b;
    }

    public void mo620a(long j) {
        try {
            this.f4336d = m5572a(j, -1);
            String contentType = this.f4336d.getContentType();
            this.f4337e = new BufferedInputStream(this.f4336d.getInputStream(), 8192);
            this.f4335c = new agv(this.f4335c.f4349a, m5571a(this.f4336d, j, this.f4336d.getResponseCode()), contentType);
            this.f4334b.mo633a(this.f4335c.f4349a, this.f4335c);
        } catch (Throwable e) {
            throw new ags("Error opening connection for " + this.f4335c.f4349a + " with offset " + j, e);
        }
    }

    private long m5571a(HttpURLConnection httpURLConnection, long j, int i) {
        long a = m5570a(httpURLConnection);
        if (i == 200) {
            return a;
        }
        return i == 206 ? a + j : this.f4335c.f4350b;
    }

    private long m5570a(HttpURLConnection httpURLConnection) {
        String headerField = httpURLConnection.getHeaderField("Content-Length");
        return headerField == null ? -1 : Long.parseLong(headerField);
    }

    public void mo621b() {
        Throwable e;
        if (this.f4336d != null) {
            try {
                this.f4336d.disconnect();
                return;
            } catch (NullPointerException e2) {
                e = e2;
            } catch (IllegalArgumentException e3) {
                e = e3;
            } catch (Throwable e4) {
                f4333a.mo2792a("Error closing connection correctly. Should happen only on Android L. If anybody know how to fix it, please visit https://github.com/danikula/AndroidVideoCache/issues/88. Until good solution is not know, just ignore this issue :(", e4);
                return;
            }
        }
        return;
        throw new RuntimeException("Wait... but why? WTF!? Really shouldn't happen any more after fixing https://github.com/danikula/AndroidVideoCache/issues/43. If you read it on your device log, please, notify me danikula@gmail.com or create issue here https://github.com/danikula/AndroidVideoCache/issues.", e4);
    }

    public int mo618a(byte[] bArr) {
        if (this.f4337e == null) {
            throw new ags("Error reading data from " + this.f4335c.f4349a + ": connection is absent!");
        }
        try {
            return this.f4337e.read(bArr, 0, bArr.length);
        } catch (Throwable e) {
            throw new agk("Reading source " + this.f4335c.f4349a + " is interrupted", e);
        } catch (Throwable e2) {
            throw new ags("Error reading data from " + this.f4335c.f4349a, e2);
        }
    }

    private void m5573e() {
        Throwable e;
        Closeable closeable = null;
        f4333a.mo2789a("Read content info from " + this.f4335c.f4349a);
        HttpURLConnection a;
        try {
            a = m5572a(0, Constants.TEN_SECONDS_MILLIS);
            try {
                long a2 = m5570a(a);
                String contentType = a.getContentType();
                closeable = a.getInputStream();
                this.f4335c = new agv(this.f4335c.f4349a, a2, contentType);
                this.f4334b.mo633a(this.f4335c.f4349a, this.f4335c);
                f4333a.mo2789a("Source info fetched: " + this.f4335c);
                agt.m5596a(closeable);
                if (a != null) {
                    a.disconnect();
                }
            } catch (IOException e2) {
                e = e2;
                try {
                    f4333a.mo2792a("Error fetching info from " + this.f4335c.f4349a, e);
                    agt.m5596a(closeable);
                    if (a != null) {
                        a.disconnect();
                    }
                } catch (Throwable th) {
                    e = th;
                    agt.m5596a(closeable);
                    if (a != null) {
                        a.disconnect();
                    }
                    throw e;
                }
            }
        } catch (IOException e3) {
            e = e3;
            a = null;
            f4333a.mo2792a("Error fetching info from " + this.f4335c.f4349a, e);
            agt.m5596a(closeable);
            if (a != null) {
                a.disconnect();
            }
        } catch (Throwable th2) {
            e = th2;
            a = null;
            agt.m5596a(closeable);
            if (a != null) {
                a.disconnect();
            }
            throw e;
        }
    }

    private HttpURLConnection m5572a(long j, int i) {
        HttpURLConnection httpURLConnection;
        String str = this.f4335c.f4349a;
        int i2 = 0;
        Object obj;
        do {
            f4333a.mo2789a("Open connection " + (j > 0 ? " with offset " + j : "") + " to " + str);
            httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            if (j > 0) {
                httpURLConnection.setRequestProperty("Range", "bytes=" + j + "-");
            }
            if (i > 0) {
                httpURLConnection.setConnectTimeout(i);
                httpURLConnection.setReadTimeout(i);
            }
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode == 301 || responseCode == 302 || responseCode == 303) {
                obj = 1;
            } else {
                obj = null;
            }
            if (obj != null) {
                str = httpURLConnection.getHeaderField("Location");
                i2++;
                httpURLConnection.disconnect();
            }
            if (i2 > 5) {
                throw new ags("Too many redirects: " + i2);
            }
        } while (obj != null);
        return httpURLConnection;
    }

    public synchronized String m5578c() {
        if (TextUtils.isEmpty(this.f4335c.f4351c)) {
            m5573e();
        }
        return this.f4335c.f4351c;
    }

    public String m5579d() {
        return this.f4335c.f4349a;
    }

    public String toString() {
        return "HttpUrlSource{sourceInfo='" + this.f4335c + "}";
    }
}
