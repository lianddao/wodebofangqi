package com.ushareit.listenit;

import android.content.Context;
import android.os.SystemClock;
import android.util.Log;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class ara {
    private final Object f5212a;
    private final ExecutorService f5213b;
    private final Map<String, arh> f5214c;
    private final ServerSocket f5215d;
    private final int f5216e;
    private final Thread f5217f;
    private final aqx f5218g;
    private boolean f5219h;

    public ara(Context context) {
        this(new arc(context).m6877a());
    }

    private ara(aqx com_ushareit_listenit_aqx) {
        Throwable e;
        this.f5212a = new Object();
        this.f5213b = Executors.newFixedThreadPool(8);
        this.f5214c = new ConcurrentHashMap();
        this.f5218g = (aqx) arl.m6900a(com_ushareit_listenit_aqx);
        try {
            this.f5215d = new ServerSocket(0, 8, InetAddress.getByName("127.0.0.1"));
            this.f5216e = this.f5215d.getLocalPort();
            CountDownLatch countDownLatch = new CountDownLatch(1);
            this.f5217f = new Thread(new arg(this, countDownLatch));
            this.f5217f.start();
            countDownLatch.await();
            Log.i("ProxyCache", "Proxy cache server started. Ping it...");
            m6860b();
        } catch (IOException e2) {
            e = e2;
            this.f5213b.shutdown();
            throw new IllegalStateException("Error starting local proxy server", e);
        } catch (InterruptedException e3) {
            e = e3;
            this.f5213b.shutdown();
            throw new IllegalStateException("Error starting local proxy server", e);
        }
    }

    private void m6857a(Throwable th) {
        Log.e("ProxyCache", "HttpProxyCacheServer error", th);
    }

    private void m6858a(Socket socket) {
        Throwable e;
        try {
            aqy a = aqy.m6825a(socket.getInputStream());
            Log.i("ProxyCache", "Request to cache proxy:" + a);
            String c = arq.m6908c(a.f5198a);
            if ("ping".equals(c)) {
                m6861b(socket);
            } else {
                m6869e(c).m6885a(a, socket);
            }
            m6863c(socket);
            Log.d("ProxyCache", "Opened connections: " + m6872f());
        } catch (SocketException e2) {
            Log.d("ProxyCache", "Closing socket... Socket is closed by client.");
            m6863c(socket);
            Log.d("ProxyCache", "Opened connections: " + m6872f());
        } catch (arp e3) {
            e = e3;
            m6857a(new arp("Error processing request", e));
            m6863c(socket);
            Log.d("ProxyCache", "Opened connections: " + m6872f());
        } catch (IOException e4) {
            e = e4;
            m6857a(new arp("Error processing request", e));
            m6863c(socket);
            Log.d("ProxyCache", "Opened connections: " + m6872f());
        } catch (Throwable th) {
            m6863c(socket);
            Log.d("ProxyCache", "Opened connections: " + m6872f());
        }
    }

    private void m6860b() {
        int i = 300;
        int i2 = 0;
        while (i2 < 3) {
            try {
                this.f5219h = ((Boolean) this.f5213b.submit(new ard()).get((long) i, TimeUnit.MILLISECONDS)).booleanValue();
                if (!this.f5219h) {
                    SystemClock.sleep((long) i);
                    i *= 2;
                    i2++;
                } else {
                    return;
                }
            } catch (InterruptedException e) {
                Throwable e2 = e;
                Log.e("ProxyCache", "Error pinging server [attempt: " + i2 + ", timeout: " + i + "]. ", e2);
                i *= 2;
                i2++;
            } catch (ExecutionException e3) {
                e2 = e3;
                Log.e("ProxyCache", "Error pinging server [attempt: " + i2 + ", timeout: " + i + "]. ", e2);
                i *= 2;
                i2++;
            } catch (TimeoutException e4) {
                e2 = e4;
                Log.e("ProxyCache", "Error pinging server [attempt: " + i2 + ", timeout: " + i + "]. ", e2);
                i *= 2;
                i2++;
            }
        }
        Log.e("ProxyCache", "Shutdown server... Error pinging server [attempts: " + i2 + ", max timeout: " + (i / 2) + "].");
        m6874a();
    }

    private void m6861b(Socket socket) {
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("HTTP/1.1 200 OK\n\n".getBytes());
        outputStream.write("ping ok".getBytes());
    }

    private void m6863c(Socket socket) {
        m6868d(socket);
        m6871e(socket);
        m6873f(socket);
    }

    private boolean m6864c() {
        arj com_ushareit_listenit_arj = new arj(m6866d("ping"));
        boolean equals;
        try {
            byte[] bytes = "ping ok".getBytes();
            com_ushareit_listenit_arj.mo790a(0);
            byte[] bArr = new byte[bytes.length];
            com_ushareit_listenit_arj.mo789a(bArr);
            equals = Arrays.equals(bytes, bArr);
            Log.d("ProxyCache", "Ping response: `" + new String(bArr) + "`, pinged? " + equals);
            return equals;
        } catch (arp e) {
            equals = e;
            Log.e("ProxyCache", "Error reading ping response", equals);
            return false;
        } finally {
            com_ushareit_listenit_arj.mo791b();
        }
    }

    private boolean m6865c(String str) {
        arj com_ushareit_listenit_arj = new arj(m6866d(str));
        try {
            com_ushareit_listenit_arj.mo790a(0);
            while (true) {
                if (com_ushareit_listenit_arj.mo789a(new byte[8192]) == -1) {
                    break;
                }
            }
            return true;
        } catch (Throwable e) {
            Log.e("ProxyCache", "Error reading url", e);
            return false;
        } finally {
            com_ushareit_listenit_arj.mo791b();
        }
    }

    private String m6866d(String str) {
        return String.format("http://%s:%d/%s", new Object[]{"127.0.0.1", Integer.valueOf(this.f5216e), arq.m6907b(str)});
    }

    private void m6867d() {
        synchronized (this.f5212a) {
            for (arh a : this.f5214c.values()) {
                a.m6884a();
            }
            this.f5214c.clear();
        }
    }

    private void m6868d(Socket socket) {
        try {
            if (!socket.isInputShutdown()) {
                socket.shutdownInput();
            }
        } catch (SocketException e) {
            Log.d("ProxyCache", "Releasing input stream... Socket is closed by client.");
        } catch (Throwable e2) {
            m6857a(new arp("Error closing socket input stream", e2));
        }
    }

    private arh m6869e(String str) {
        arh com_ushareit_listenit_arh;
        synchronized (this.f5212a) {
            com_ushareit_listenit_arh = (arh) this.f5214c.get(str);
            if (com_ushareit_listenit_arh == null) {
                com_ushareit_listenit_arh = new arh(str, this.f5218g);
                this.f5214c.put(str, com_ushareit_listenit_arh);
            }
        }
        return com_ushareit_listenit_arh;
    }

    private void m6870e() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                Socket accept = this.f5215d.accept();
                Log.d("ProxyCache", "Accept new socket " + accept);
                this.f5213b.submit(new arf(this, accept));
            } catch (Throwable e) {
                m6857a(new arp("Error during waiting connection", e));
                return;
            }
        }
    }

    private void m6871e(Socket socket) {
        try {
            if (socket.isOutputShutdown()) {
                socket.shutdownOutput();
            }
        } catch (Throwable e) {
            m6857a(new arp("Error closing socket output stream", e));
        }
    }

    private int m6872f() {
        int i;
        synchronized (this.f5212a) {
            i = 0;
            for (arh b : this.f5214c.values()) {
                i = b.m6886b() + i;
            }
        }
        return i;
    }

    private void m6873f(Socket socket) {
        try {
            if (!socket.isClosed()) {
                socket.close();
            }
        } catch (Throwable e) {
            m6857a(new arp("Error closing socket", e));
        }
    }

    public void m6874a() {
        Log.i("ProxyCache", "Shutdown proxy server");
        m6867d();
        this.f5217f.interrupt();
        try {
            if (!this.f5215d.isClosed()) {
                this.f5215d.close();
            }
        } catch (Throwable e) {
            m6857a(new arp("Error shutting down proxy server", e));
        }
    }

    public void m6875a(String str) {
        int i = 300;
        int i2 = 0;
        while (i2 < 3) {
            try {
                if (!((Boolean) this.f5213b.submit(new are(this, str)).get()).booleanValue()) {
                    SystemClock.sleep((long) i);
                    i *= 2;
                    i2++;
                } else {
                    return;
                }
            } catch (InterruptedException e) {
                Throwable e2 = e;
                Log.e("ProxyCache", "Error precaching url [attempt: " + i2 + ", url: " + str + "]. ", e2);
                i *= 2;
                i2++;
            } catch (ExecutionException e3) {
                e2 = e3;
                Log.e("ProxyCache", "Error precaching url [attempt: " + i2 + ", url: " + str + "]. ", e2);
                i *= 2;
                i2++;
            }
        }
        Log.e("ProxyCache", "Shutdown server... Error precaching url [attempts: " + i2 + ", url: " + str + "].");
        m6874a();
    }

    public String m6876b(String str) {
        if (!this.f5219h) {
            Log.e("ProxyCache", "Proxy server isn't pinged. Caching doesn't work.");
        }
        return this.f5219h ? m6866d(str) : str;
    }
}
