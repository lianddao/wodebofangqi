package com.ushareit.listenit;

import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

class cpi {
    private static long f8635a = 0;
    private cpm f8636b;
    private boolean f8637c = false;
    private boolean f8638d = false;
    private long f8639e = 0;
    private cpv f8640f;
    private cpl f8641g;
    private ScheduledFuture<?> f8642h;
    private ScheduledFuture<?> f8643i;
    private final col f8644j;
    private final ScheduledExecutorService f8645k;
    private final cvy f8646l;

    public cpi(col com_ushareit_listenit_col, con com_ushareit_listenit_con, String str, cpl com_ushareit_listenit_cpl, String str2) {
        this.f8644j = com_ushareit_listenit_col;
        this.f8645k = com_ushareit_listenit_col.m12027c();
        this.f8641g = com_ushareit_listenit_cpl;
        long j = f8635a;
        f8635a = 1 + j;
        this.f8646l = new cvy(com_ushareit_listenit_col.m12025a(), "WebSocket", "ws_" + j);
        this.f8636b = m12173a(com_ushareit_listenit_con, str, str2);
    }

    private cpm m12173a(con com_ushareit_listenit_con, String str, String str2) {
        if (str == null) {
            str = com_ushareit_listenit_con.m12037a();
        }
        URI a = con.m12036a(str, com_ushareit_listenit_con.m12039c(), com_ushareit_listenit_con.m12038b(), str2);
        Map hashMap = new HashMap();
        hashMap.put("User-Agent", this.f8644j.m12030f());
        return new cpn(this, new cxs(a, null, hashMap));
    }

    private void m12175a(int i) {
        this.f8639e = (long) i;
        this.f8640f = new cpv();
        if (this.f8646l.m13094a()) {
            this.f8646l.m13093a("HandleNewFrameCount: " + this.f8639e, new Object[0]);
        }
    }

    private void m12177a(String str) {
        Throwable th;
        cvy com_ushareit_listenit_cvy;
        String str2;
        String valueOf;
        this.f8640f.m12228a(str);
        this.f8639e--;
        if (this.f8639e == 0) {
            try {
                this.f8640f.m12227a();
                Map a = cyg.m13368a(this.f8640f.toString());
                this.f8640f = null;
                if (this.f8646l.m13094a()) {
                    cvy com_ushareit_listenit_cvy2 = this.f8646l;
                    String valueOf2 = String.valueOf(a);
                    com_ushareit_listenit_cvy2.m13093a(new StringBuilder(String.valueOf(valueOf2).length() + 36).append("handleIncomingFrame complete frame: ").append(valueOf2).toString(), new Object[0]);
                }
                this.f8641g.mo1514a(a);
            } catch (Throwable e) {
                th = e;
                com_ushareit_listenit_cvy = this.f8646l;
                str2 = "Error parsing frame: ";
                valueOf = String.valueOf(this.f8640f.toString());
                com_ushareit_listenit_cvy.m13091a(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2), th);
                m12197c();
                m12192h();
            } catch (Throwable e2) {
                th = e2;
                com_ushareit_listenit_cvy = this.f8646l;
                str2 = "Error parsing frame (cast error): ";
                valueOf = String.valueOf(this.f8640f.toString());
                com_ushareit_listenit_cvy.m13091a(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2), th);
                m12197c();
                m12192h();
            }
        }
    }

    private static String[] m12179a(String str, int i) {
        int i2 = 0;
        if (str.length() <= i) {
            return new String[]{str};
        }
        ArrayList arrayList = new ArrayList();
        while (i2 < str.length()) {
            arrayList.add(str.substring(i2, Math.min(i2 + i, str.length())));
            i2 += i;
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    private String m12181b(String str) {
        if (str.length() <= 6) {
            try {
                int parseInt = Integer.parseInt(str);
                if (parseInt > 0) {
                    m12175a(parseInt);
                }
                return null;
            } catch (NumberFormatException e) {
            }
        }
        m12175a(1);
        return str;
    }

    private void m12183c(String str) {
        if (!this.f8638d) {
            m12185d();
            if (m12189f()) {
                m12177a(str);
                return;
            }
            String b = m12181b(str);
            if (b != null) {
                m12177a(b);
            }
        }
    }

    private void m12185d() {
        if (!this.f8638d) {
            if (this.f8642h != null) {
                this.f8642h.cancel(false);
                if (this.f8646l.m13094a()) {
                    this.f8646l.m13093a("Reset keepAlive. Remaining: " + this.f8642h.getDelay(TimeUnit.MILLISECONDS), new Object[0]);
                }
            } else if (this.f8646l.m13094a()) {
                this.f8646l.m13093a("Reset keepAlive", new Object[0]);
            }
            this.f8642h = this.f8645k.schedule(m12186e(), 45000, TimeUnit.MILLISECONDS);
        }
    }

    private Runnable m12186e() {
        return new cpk(this);
    }

    private boolean m12189f() {
        return this.f8640f != null;
    }

    private void m12191g() {
        if (!this.f8638d) {
            if (this.f8646l.m13094a()) {
                this.f8646l.m13093a("closing itself", new Object[0]);
            }
            m12192h();
        }
        this.f8636b = null;
        if (this.f8642h != null) {
            this.f8642h.cancel(false);
        }
    }

    private void m12192h() {
        this.f8638d = true;
        this.f8641g.mo1515a(this.f8637c);
    }

    private void m12193i() {
        if (!this.f8637c && !this.f8638d) {
            if (this.f8646l.m13094a()) {
                this.f8646l.m13093a("timed out on connect", new Object[0]);
            }
            this.f8636b.mo1544b();
        }
    }

    public void m12194a() {
        this.f8636b.mo1540a();
        this.f8643i = this.f8645k.schedule(new cpj(this), 30000, TimeUnit.MILLISECONDS);
    }

    public void m12195a(Map<String, Object> map) {
        m12185d();
        String str;
        try {
            String[] a = m12179a(cyg.m13366a((Map) map), 16384);
            if (a.length > 1) {
                this.f8636b.mo1543a(a.length);
            }
            for (String str2 : a) {
                this.f8636b.mo1543a(str2);
            }
        } catch (Throwable e) {
            Throwable th = e;
            cvy com_ushareit_listenit_cvy = this.f8646l;
            str2 = "Failed to serialize message: ";
            String valueOf = String.valueOf(map.toString());
            com_ushareit_listenit_cvy.m13091a(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2), th);
            m12192h();
        }
    }

    public void m12196b() {
    }

    public void m12197c() {
        if (this.f8646l.m13094a()) {
            this.f8646l.m13093a("websocket is being closed", new Object[0]);
        }
        this.f8638d = true;
        this.f8636b.mo1544b();
        if (this.f8643i != null) {
            this.f8643i.cancel(true);
        }
        if (this.f8642h != null) {
            this.f8642h.cancel(true);
        }
    }
}
