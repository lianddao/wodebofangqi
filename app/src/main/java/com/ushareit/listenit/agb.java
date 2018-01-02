package com.ushareit.listenit;

import android.net.Uri;
import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class agb {
    private static final hjm f4308a = hjn.m23936a("HttpProxyCacheServer");
    private final Object f4309b;
    private final ExecutorService f4310c;
    private final Map<String, agg> f4311d;
    private final ServerSocket f4312e;
    private final int f4313f;
    private final Thread f4314g;
    private final afy f4315h;
    private final agl f4316i;

    private agb(afy com_ushareit_listenit_afy) {
        Throwable e;
        this.f4309b = new Object();
        this.f4310c = Executors.newFixedThreadPool(8);
        this.f4311d = new ConcurrentHashMap();
        this.f4315h = (afy) ago.m5589a((Object) com_ushareit_listenit_afy);
        try {
            this.f4312e = new ServerSocket(0, 8, InetAddress.getByName("127.0.0.1"));
            this.f4313f = this.f4312e.getLocalPort();
            agj.m5580a("127.0.0.1", this.f4313f);
            CountDownLatch countDownLatch = new CountDownLatch(1);
            this.f4314g = new Thread(new agf(this, countDownLatch));
            this.f4314g.start();
            countDownLatch.await();
            this.f4316i = new agl("127.0.0.1", this.f4313f);
            f4308a.mo2793b("Proxy cache server started. Is it alive? " + m5542b());
        } catch (IOException e2) {
            e = e2;
            this.f4310c.shutdown();
            throw new IllegalStateException("Error starting local proxy server", e);
        } catch (InterruptedException e3) {
            e = e3;
            this.f4310c.shutdown();
            throw new IllegalStateException("Error starting local proxy server", e);
        }
    }

    public String m5552a(String str) {
        return m5553a(str, true);
    }

    public String m5553a(String str, boolean z) {
        if (!z || !m5555b(str)) {
            return m5542b() ? m5543c(str) : str;
        } else {
            File d = m5546d(str);
            m5538a(d);
            return Uri.fromFile(d).toString();
        }
    }

    public boolean m5555b(String str) {
        ago.m5590a((Object) str, "Url can't be null!");
        return m5546d(str).exists();
    }

    public void m5554a() {
        f4308a.mo2793b("Shutdown proxy server");
        m5544c();
        this.f4315h.f4290d.mo632a();
        this.f4314g.interrupt();
        try {
            if (!this.f4312e.isClosed()) {
                this.f4312e.close();
            }
        } catch (Throwable e) {
            m5539a(new ags("Error shutting down proxy server", e));
        }
    }

    private boolean m5542b() {
        return this.f4316i.m5586a(3, 70);
    }

    private String m5543c(String str) {
        return String.format(Locale.US, "http://%s:%d/%s", new Object[]{"127.0.0.1", Integer.valueOf(this.f4313f), agt.m5598b(str)});
    }

    private File m5546d(String str) {
        return new File(this.f4315h.f4287a, this.f4315h.f4288b.mo629a(str));
    }

    private void m5538a(File file) {
        try {
            this.f4315h.f4289c.mo628a(file);
        } catch (Throwable e) {
            f4308a.mo2792a("Error touching file " + file, e);
        }
    }

    private void m5544c() {
        synchronized (this.f4309b) {
            for (agg a : this.f4311d.values()) {
                a.m5562a();
            }
            this.f4311d.clear();
        }
    }

    private void m5547d() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                Socket accept = this.f4312e.accept();
                f4308a.mo2789a("Accept new socket " + accept);
                this.f4310c.submit(new age(this, accept));
            } catch (Throwable e) {
                m5539a(new ags("Error during waiting connection", e));
                return;
            }
        }
    }

    private void m5540a(Socket socket) {
        Throwable e;
        try {
            afz a = afz.m5511a(socket.getInputStream());
            f4308a.mo2789a("Request to cache proxy:" + a);
            String c = agt.m5599c(a.f4293a);
            if (this.f4316i.m5587a(c)) {
                this.f4316i.m5585a(socket);
            } else {
                m5550e(c).m5563a(a, socket);
            }
            m5541b(socket);
            f4308a.mo2789a("Opened connections: " + m5549e());
        } catch (SocketException e2) {
            f4308a.mo2789a("Closing socket… Socket is closed by client.");
            m5541b(socket);
            f4308a.mo2789a("Opened connections: " + m5549e());
        } catch (ags e3) {
            e = e3;
            m5539a(new ags("Error processing request", e));
            m5541b(socket);
            f4308a.mo2789a("Opened connections: " + m5549e());
        } catch (IOException e4) {
            e = e4;
            m5539a(new ags("Error processing request", e));
            m5541b(socket);
            f4308a.mo2789a("Opened connections: " + m5549e());
        } catch (Throwable th) {
            m5541b(socket);
            f4308a.mo2789a("Opened connections: " + m5549e());
        }
    }

    private agg m5550e(String str) {
        agg com_ushareit_listenit_agg;
        synchronized (this.f4309b) {
            com_ushareit_listenit_agg = (agg) this.f4311d.get(str);
            if (com_ushareit_listenit_agg == null) {
                com_ushareit_listenit_agg = new agg(str, this.f4315h);
                this.f4311d.put(str, com_ushareit_listenit_agg);
            }
        }
        return com_ushareit_listenit_agg;
    }

    private int m5549e() {
        int i;
        synchronized (this.f4309b) {
            i = 0;
            for (agg b : this.f4311d.values()) {
                i = b.m5564b() + i;
            }
        }
        return i;
    }

    private void m5541b(Socket socket) {
        m5545c(socket);
        m5548d(socket);
        m5551e(socket);
    }

    private void m5545c(Socket socket) {
        try {
            if (!socket.isInputShutdown()) {
                socket.shutdownInput();
            }
        } catch (SocketException e) {
            f4308a.mo2789a("Releasing input stream… Socket is closed by client.");
        } catch (Throwable e2) {
            m5539a(new ags("Error closing socket input stream", e2));
        }
    }

    private void m5548d(Socket socket) {
        try {
            if (!socket.isOutputShutdown()) {
                socket.shutdownOutput();
            }
        } catch (IOException e) {
            f4308a.mo2790a("Failed to close socket on proxy side: {}. It seems client have already closed connection.", e.getMessage());
        }
    }

    private void m5551e(Socket socket) {
        try {
            if (!socket.isClosed()) {
                socket.close();
            }
        } catch (Throwable e) {
            m5539a(new ags("Error closing socket", e));
        }
    }

    private void m5539a(Throwable th) {
        f4308a.mo2792a("HttpProxyCacheServer error", th);
    }
}
