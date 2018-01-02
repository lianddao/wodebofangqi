package com.ushareit.listenit;

import java.lang.Thread.State;
import java.net.Socket;
import java.net.URI;
import java.nio.charset.Charset;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

public class cxs {
    private static final AtomicInteger f9316a = new AtomicInteger(0);
    private static final Charset f9317b = Charset.forName("UTF-8");
    private static ThreadFactory f9318l = Executors.defaultThreadFactory();
    private static cxr f9319m = new cxt();
    private volatile cxw f9320c = cxw.NONE;
    private volatile Socket f9321d = null;
    private cxx f9322e = null;
    private final URI f9323f;
    private final cyb f9324g;
    private final cyc f9325h;
    private final cxz f9326i;
    private final int f9327j = f9316a.incrementAndGet();
    private final Thread f9328k = m13315a().newThread(new cxu(this));

    public cxs(URI uri, String str, Map<String, String> map) {
        this.f9323f = uri;
        this.f9326i = new cxz(uri, str, map);
        this.f9324g = new cyb(this);
        this.f9325h = new cyc(this, "TubeSock", this.f9327j);
    }

    static ThreadFactory m13315a() {
        return f9318l;
    }

    private synchronized void m13316a(byte b, byte[] bArr) {
        if (this.f9320c != cxw.CONNECTED) {
            this.f9322e.mo1541a(new cxy("error while sending data: not connected"));
        } else {
            try {
                this.f9325h.m13357a(b, true, bArr);
            } catch (Throwable e) {
                this.f9322e.mo1541a(new cxy("Failed to send frame", e));
                m13330e();
            }
        }
    }

    public static void m13318a(ThreadFactory threadFactory, cxr com_ushareit_listenit_cxr) {
        f9318l = threadFactory;
        f9319m = com_ushareit_listenit_cxr;
    }

    static cxr m13319b() {
        return f9319m;
    }

    private synchronized void m13320i() {
        if (this.f9320c != cxw.DISCONNECTED) {
            this.f9324g.m13349b();
            this.f9325h.m13356a();
            if (this.f9321d != null) {
                try {
                    this.f9321d.close();
                } catch (Throwable e) {
                    throw new RuntimeException(e);
                }
            }
            this.f9320c = cxw.DISCONNECTED;
            this.f9322e.mo1546d();
        }
    }

    private void m13321j() {
        try {
            this.f9320c = cxw.DISCONNECTING;
            this.f9325h.m13356a();
            this.f9325h.m13357a((byte) 8, true, new byte[0]);
        } catch (Throwable e) {
            this.f9322e.mo1541a(new cxy("Failed to send close frame", e));
        }
    }

    private Socket m13322k() {
        Throwable th;
        String str;
        String valueOf;
        String scheme = this.f9323f.getScheme();
        String host = this.f9323f.getHost();
        int port = this.f9323f.getPort();
        if (scheme != null && scheme.equals("ws")) {
            try {
                return new Socket(host, port == -1 ? 80 : port);
            } catch (Throwable e) {
                th = e;
                str = "unknown host: ";
                valueOf = String.valueOf(host);
                throw new cxy(valueOf.length() != 0 ? str.concat(valueOf) : new String(str), th);
            } catch (Throwable e2) {
                host = String.valueOf(this.f9323f);
                throw new cxy(new StringBuilder(String.valueOf(host).length() + 31).append("error while creating socket to ").append(host).toString(), e2);
            }
        } else if (scheme == null || !scheme.equals("wss")) {
            String str2 = "unsupported protocol: ";
            valueOf = String.valueOf(scheme);
            throw new cxy(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
        } else {
            if (port == -1) {
                port = 443;
            }
            try {
                SSLSocket sSLSocket = (SSLSocket) SSLSocketFactory.getDefault().createSocket(host, port);
                if (HttpsURLConnection.getDefaultHostnameVerifier().verify(host, sSLSocket.getSession())) {
                    return sSLSocket;
                }
                scheme = String.valueOf(this.f9323f);
                throw new cxy(new StringBuilder(String.valueOf(scheme).length() + 39).append("Error while verifying secure socket to ").append(scheme).toString());
            } catch (Throwable e22) {
                th = e22;
                str = "unknown host: ";
                valueOf = String.valueOf(host);
                throw new cxy(valueOf.length() != 0 ? str.concat(valueOf) : new String(str), th);
            } catch (Throwable e222) {
                host = String.valueOf(this.f9323f);
                throw new cxy(new StringBuilder(String.valueOf(host).length() + 38).append("error while creating secure socket to ").append(host).toString(), e222);
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m13323l() {
        /*
        r11 = this;
        r4 = 1;
        r10 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r1 = 0;
        r0 = r11.m13322k();	 Catch:{ cxy -> 0x0028, IOException -> 0x0065 }
        monitor-enter(r11);	 Catch:{ cxy -> 0x0028, IOException -> 0x0065 }
        r11.f9321d = r0;	 Catch:{ all -> 0x0025 }
        r2 = r11.f9320c;	 Catch:{ all -> 0x0025 }
        r3 = com.ushareit.listenit.cxw.DISCONNECTED;	 Catch:{ all -> 0x0025 }
        if (r2 != r3) goto L_0x0032;
    L_0x0011:
        r0 = r11.f9321d;	 Catch:{ IOException -> 0x001e }
        r0.close();	 Catch:{ IOException -> 0x001e }
        r0 = 0;
        r11.f9321d = r0;	 Catch:{ all -> 0x0025 }
        monitor-exit(r11);	 Catch:{ all -> 0x0025 }
        r11.m13330e();
    L_0x001d:
        return;
    L_0x001e:
        r0 = move-exception;
        r1 = new java.lang.RuntimeException;	 Catch:{ all -> 0x0025 }
        r1.<init>(r0);	 Catch:{ all -> 0x0025 }
        throw r1;	 Catch:{ all -> 0x0025 }
    L_0x0025:
        r0 = move-exception;
        monitor-exit(r11);	 Catch:{ all -> 0x0025 }
        throw r0;	 Catch:{ cxy -> 0x0028, IOException -> 0x0065 }
    L_0x0028:
        r0 = move-exception;
        r1 = r11.f9322e;	 Catch:{ all -> 0x00e1 }
        r1.mo1541a(r0);	 Catch:{ all -> 0x00e1 }
        r11.m13330e();
        goto L_0x001d;
    L_0x0032:
        monitor-exit(r11);	 Catch:{ all -> 0x0025 }
        r5 = new java.io.DataInputStream;	 Catch:{ cxy -> 0x0028, IOException -> 0x0065 }
        r2 = r0.getInputStream();	 Catch:{ cxy -> 0x0028, IOException -> 0x0065 }
        r5.<init>(r2);	 Catch:{ cxy -> 0x0028, IOException -> 0x0065 }
        r6 = r0.getOutputStream();	 Catch:{ cxy -> 0x0028, IOException -> 0x0065 }
        r0 = r11.f9326i;	 Catch:{ cxy -> 0x0028, IOException -> 0x0065 }
        r0 = r0.m13340a();	 Catch:{ cxy -> 0x0028, IOException -> 0x0065 }
        r6.write(r0);	 Catch:{ cxy -> 0x0028, IOException -> 0x0065 }
        r0 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r2 = new byte[r0];	 Catch:{ cxy -> 0x0028, IOException -> 0x0065 }
        r7 = new java.util.ArrayList;	 Catch:{ cxy -> 0x0028, IOException -> 0x0065 }
        r7.<init>();	 Catch:{ cxy -> 0x0028, IOException -> 0x0065 }
        r0 = r1;
        r3 = r1;
    L_0x0054:
        if (r3 != 0) goto L_0x00ec;
    L_0x0056:
        r8 = r5.read();	 Catch:{ cxy -> 0x0028, IOException -> 0x0065 }
        r9 = -1;
        if (r8 != r9) goto L_0x0088;
    L_0x005d:
        r0 = new com.ushareit.listenit.cxy;	 Catch:{ cxy -> 0x0028, IOException -> 0x0065 }
        r1 = "Connection closed before handshake was complete";
        r0.<init>(r1);	 Catch:{ cxy -> 0x0028, IOException -> 0x0065 }
        throw r0;	 Catch:{ cxy -> 0x0028, IOException -> 0x0065 }
    L_0x0065:
        r0 = move-exception;
        r2 = r11.f9322e;	 Catch:{ all -> 0x00e1 }
        r3 = new com.ushareit.listenit.cxy;	 Catch:{ all -> 0x00e1 }
        r4 = "error while connecting: ";
        r1 = r0.getMessage();	 Catch:{ all -> 0x00e1 }
        r1 = java.lang.String.valueOf(r1);	 Catch:{ all -> 0x00e1 }
        r5 = r1.length();	 Catch:{ all -> 0x00e1 }
        if (r5 == 0) goto L_0x014d;
    L_0x007a:
        r1 = r4.concat(r1);	 Catch:{ all -> 0x00e1 }
    L_0x007e:
        r3.<init>(r1, r0);	 Catch:{ all -> 0x00e1 }
        r2.mo1541a(r3);	 Catch:{ all -> 0x00e1 }
        r11.m13330e();
        goto L_0x001d;
    L_0x0088:
        r8 = (byte) r8;
        r2[r0] = r8;	 Catch:{ cxy -> 0x0028, IOException -> 0x0065 }
        r0 = r0 + 1;
        r8 = r0 + -1;
        r8 = r2[r8];	 Catch:{ cxy -> 0x0028, IOException -> 0x0065 }
        r9 = 10;
        if (r8 != r9) goto L_0x00c2;
    L_0x0095:
        r8 = r0 + -2;
        r8 = r2[r8];	 Catch:{ cxy -> 0x0028, IOException -> 0x0065 }
        r9 = 13;
        if (r8 != r9) goto L_0x00c2;
    L_0x009d:
        r0 = new java.lang.String;	 Catch:{ cxy -> 0x0028, IOException -> 0x0065 }
        r8 = f9317b;	 Catch:{ cxy -> 0x0028, IOException -> 0x0065 }
        r0.<init>(r2, r8);	 Catch:{ cxy -> 0x0028, IOException -> 0x0065 }
        r2 = r0.trim();	 Catch:{ cxy -> 0x0028, IOException -> 0x0065 }
        r8 = "";
        r2 = r2.equals(r8);	 Catch:{ cxy -> 0x0028, IOException -> 0x0065 }
        if (r2 == 0) goto L_0x00b9;
    L_0x00b0:
        r2 = r4;
    L_0x00b1:
        r0 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r0 = new byte[r0];	 Catch:{ cxy -> 0x0028, IOException -> 0x0065 }
        r3 = r2;
        r2 = r0;
        r0 = r1;
        goto L_0x0054;
    L_0x00b9:
        r0 = r0.trim();	 Catch:{ cxy -> 0x0028, IOException -> 0x0065 }
        r7.add(r0);	 Catch:{ cxy -> 0x0028, IOException -> 0x0065 }
        r2 = r3;
        goto L_0x00b1;
    L_0x00c2:
        if (r0 != r10) goto L_0x0054;
    L_0x00c4:
        r0 = new java.lang.String;	 Catch:{ cxy -> 0x0028, IOException -> 0x0065 }
        r1 = f9317b;	 Catch:{ cxy -> 0x0028, IOException -> 0x0065 }
        r0.<init>(r2, r1);	 Catch:{ cxy -> 0x0028, IOException -> 0x0065 }
        r1 = new com.ushareit.listenit.cxy;	 Catch:{ cxy -> 0x0028, IOException -> 0x0065 }
        r2 = "Unexpected long line in handshake: ";
        r0 = java.lang.String.valueOf(r0);	 Catch:{ cxy -> 0x0028, IOException -> 0x0065 }
        r3 = r0.length();	 Catch:{ cxy -> 0x0028, IOException -> 0x0065 }
        if (r3 == 0) goto L_0x00e6;
    L_0x00d9:
        r0 = r2.concat(r0);	 Catch:{ cxy -> 0x0028, IOException -> 0x0065 }
    L_0x00dd:
        r1.<init>(r0);	 Catch:{ cxy -> 0x0028, IOException -> 0x0065 }
        throw r1;	 Catch:{ cxy -> 0x0028, IOException -> 0x0065 }
    L_0x00e1:
        r0 = move-exception;
        r11.m13330e();
        throw r0;
    L_0x00e6:
        r0 = new java.lang.String;	 Catch:{ cxy -> 0x0028, IOException -> 0x0065 }
        r0.<init>(r2);	 Catch:{ cxy -> 0x0028, IOException -> 0x0065 }
        goto L_0x00dd;
    L_0x00ec:
        r1 = r11.f9326i;	 Catch:{ cxy -> 0x0028, IOException -> 0x0065 }
        r0 = 0;
        r0 = r7.get(r0);	 Catch:{ cxy -> 0x0028, IOException -> 0x0065 }
        r0 = (java.lang.String) r0;	 Catch:{ cxy -> 0x0028, IOException -> 0x0065 }
        r1.m13338a(r0);	 Catch:{ cxy -> 0x0028, IOException -> 0x0065 }
        r0 = 0;
        r7.remove(r0);	 Catch:{ cxy -> 0x0028, IOException -> 0x0065 }
        r1 = new java.util.HashMap;	 Catch:{ cxy -> 0x0028, IOException -> 0x0065 }
        r1.<init>();	 Catch:{ cxy -> 0x0028, IOException -> 0x0065 }
        r2 = r7.iterator();	 Catch:{ cxy -> 0x0028, IOException -> 0x0065 }
    L_0x0105:
        r0 = r2.hasNext();	 Catch:{ cxy -> 0x0028, IOException -> 0x0065 }
        if (r0 == 0) goto L_0x0122;
    L_0x010b:
        r0 = r2.next();	 Catch:{ cxy -> 0x0028, IOException -> 0x0065 }
        r0 = (java.lang.String) r0;	 Catch:{ cxy -> 0x0028, IOException -> 0x0065 }
        r3 = ": ";
        r4 = 2;
        r0 = r0.split(r3, r4);	 Catch:{ cxy -> 0x0028, IOException -> 0x0065 }
        r3 = 0;
        r3 = r0[r3];	 Catch:{ cxy -> 0x0028, IOException -> 0x0065 }
        r4 = 1;
        r0 = r0[r4];	 Catch:{ cxy -> 0x0028, IOException -> 0x0065 }
        r1.put(r3, r0);	 Catch:{ cxy -> 0x0028, IOException -> 0x0065 }
        goto L_0x0105;
    L_0x0122:
        r0 = r11.f9326i;	 Catch:{ cxy -> 0x0028, IOException -> 0x0065 }
        r0.m13339a(r1);	 Catch:{ cxy -> 0x0028, IOException -> 0x0065 }
        r0 = r11.f9325h;	 Catch:{ cxy -> 0x0028, IOException -> 0x0065 }
        r0.m13358a(r6);	 Catch:{ cxy -> 0x0028, IOException -> 0x0065 }
        r0 = r11.f9324g;	 Catch:{ cxy -> 0x0028, IOException -> 0x0065 }
        r0.m13348a(r5);	 Catch:{ cxy -> 0x0028, IOException -> 0x0065 }
        r0 = com.ushareit.listenit.cxw.CONNECTED;	 Catch:{ cxy -> 0x0028, IOException -> 0x0065 }
        r11.f9320c = r0;	 Catch:{ cxy -> 0x0028, IOException -> 0x0065 }
        r0 = r11.f9325h;	 Catch:{ cxy -> 0x0028, IOException -> 0x0065 }
        r0 = r0.m13359b();	 Catch:{ cxy -> 0x0028, IOException -> 0x0065 }
        r0.start();	 Catch:{ cxy -> 0x0028, IOException -> 0x0065 }
        r0 = r11.f9322e;	 Catch:{ cxy -> 0x0028, IOException -> 0x0065 }
        r0.mo1545c();	 Catch:{ cxy -> 0x0028, IOException -> 0x0065 }
        r0 = r11.f9324g;	 Catch:{ cxy -> 0x0028, IOException -> 0x0065 }
        r0.m13347a();	 Catch:{ cxy -> 0x0028, IOException -> 0x0065 }
        r11.m13330e();
        goto L_0x001d;
    L_0x014d:
        r1 = new java.lang.String;	 Catch:{ all -> 0x00e1 }
        r1.<init>(r4);	 Catch:{ all -> 0x00e1 }
        goto L_0x007e;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ushareit.listenit.cxs.l():void");
    }

    public void m13324a(cxx com_ushareit_listenit_cxx) {
        this.f9322e = com_ushareit_listenit_cxx;
    }

    void m13325a(cxy com_ushareit_listenit_cxy) {
        this.f9322e.mo1541a(com_ushareit_listenit_cxy);
        if (this.f9320c == cxw.CONNECTED) {
            m13330e();
        }
        m13320i();
    }

    public synchronized void m13326a(String str) {
        m13316a((byte) 1, str.getBytes(f9317b));
    }

    synchronized void m13327a(byte[] bArr) {
        m13316a((byte) 10, bArr);
    }

    cxx m13328c() {
        return this.f9322e;
    }

    public synchronized void m13329d() {
        if (this.f9320c != cxw.NONE) {
            this.f9322e.mo1541a(new cxy("connect() already called"));
            m13330e();
        } else {
            cxr b = m13319b();
            Thread h = m13333h();
            String valueOf = String.valueOf("TubeSockReader-");
            b.mo1554a(h, new StringBuilder(String.valueOf(valueOf).length() + 11).append(valueOf).append(this.f9327j).toString());
            this.f9320c = cxw.CONNECTING;
            m13333h().start();
        }
    }

    public synchronized void m13330e() {
        switch (cxv.f9330a[this.f9320c.ordinal()]) {
            case 1:
                this.f9320c = cxw.DISCONNECTED;
                break;
            case 2:
                m13320i();
                break;
            case 3:
                m13321j();
                break;
        }
    }

    void m13331f() {
        m13320i();
    }

    public void m13332g() {
        if (this.f9325h.m13359b().getState() != State.NEW) {
            this.f9325h.m13359b().join();
        }
        m13333h().join();
    }

    Thread m13333h() {
        return this.f9328k;
    }
}
