package com.ushareit.listenit;

import java.io.OutputStream;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.Socket;
import java.net.URI;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

class agl {
    private static final hjm f4342a = hjn.m23936a("Pinger");
    private final ExecutorService f4343b = Executors.newSingleThreadExecutor();
    private final String f4344c;
    private final int f4345d;

    agl(String str, int i) {
        this.f4344c = (String) ago.m5589a((Object) str);
        this.f4345d = i;
    }

    boolean m5586a(int i, int i2) {
        boolean z;
        Throwable e;
        ago.m5591a(i >= 1);
        if (i2 > 0) {
            z = true;
        } else {
            z = false;
        }
        ago.m5591a(z);
        int i3 = 0;
        while (i3 < i) {
            try {
                if (((Boolean) this.f4343b.submit(new agn()).get((long) i2, TimeUnit.MILLISECONDS)).booleanValue()) {
                    return true;
                }
                i2 *= 2;
                i3++;
            } catch (TimeoutException e2) {
                f4342a.mo2794c("Error pinging server (attempt: " + i3 + ", timeout: " + i2 + "). ");
            } catch (InterruptedException e3) {
                e = e3;
                f4342a.mo2792a("Error pinging server due to unexpected error", e);
            } catch (ExecutionException e4) {
                e = e4;
                f4342a.mo2792a("Error pinging server due to unexpected error", e);
            }
        }
        String format = String.format(Locale.US, "Error pinging server (attempts: %d, max timeout: %d). If you see this message, please, report at https://github.com/danikula/AndroidVideoCache/issues/134. Default proxies are: %s", new Object[]{Integer.valueOf(i3), Integer.valueOf(i2 / 2), m5581a()});
        f4342a.mo2792a(format, new ags(format));
        return false;
    }

    private List<Proxy> m5581a() {
        try {
            return ProxySelector.getDefault().select(new URI(m5584c()));
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
    }

    boolean m5587a(String str) {
        return "ping".equals(str);
    }

    void m5585a(Socket socket) {
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("HTTP/1.1 200 OK\n\n".getBytes());
        outputStream.write("ping ok".getBytes());
    }

    private boolean m5583b() {
        boolean equals;
        agi com_ushareit_listenit_agi = new agi(m5584c());
        try {
            byte[] bytes = "ping ok".getBytes();
            com_ushareit_listenit_agi.mo620a(0);
            byte[] bArr = new byte[bytes.length];
            com_ushareit_listenit_agi.mo618a(bArr);
            equals = Arrays.equals(bytes, bArr);
            f4342a.mo2793b("Ping response: `" + new String(bArr) + "`, pinged? " + equals);
        } catch (Throwable e) {
            f4342a.mo2792a("Error reading ping response", e);
            equals = false;
        } finally {
            com_ushareit_listenit_agi.mo621b();
        }
        return equals;
    }

    private String m5584c() {
        return String.format(Locale.US, "http://%s:%d/%s", new Object[]{this.f4344c, Integer.valueOf(this.f4345d), "ping"});
    }
}
