package com.ushareit.listenit;

import android.text.TextUtils;
import java.io.BufferedOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Locale;

class aga extends agp {
    private final agi f4305a;
    private final agy f4306b;
    private afx f4307c;

    public aga(agi com_ushareit_listenit_agi, agy com_ushareit_listenit_agy) {
        super(com_ushareit_listenit_agi, com_ushareit_listenit_agy);
        this.f4306b = com_ushareit_listenit_agy;
        this.f4305a = com_ushareit_listenit_agi;
    }

    public void m5534a(afx com_ushareit_listenit_afx) {
        this.f4307c = com_ushareit_listenit_afx;
    }

    public void m5535a(afz com_ushareit_listenit_afz, Socket socket) {
        OutputStream bufferedOutputStream = new BufferedOutputStream(socket.getOutputStream());
        bufferedOutputStream.write(m5531b(com_ushareit_listenit_afz).getBytes("UTF-8"));
        long j = com_ushareit_listenit_afz.f4294b;
        if (m5530a(com_ushareit_listenit_afz)) {
            m5529a(bufferedOutputStream, j);
        } else {
            m5532b(bufferedOutputStream, j);
        }
    }

    private boolean m5530a(afz com_ushareit_listenit_afz) {
        boolean z;
        long a = this.f4305a.mo619a();
        if (a > 0) {
            z = true;
        } else {
            z = false;
        }
        long a2 = this.f4306b.mo623a();
        if (z && com_ushareit_listenit_afz.f4295c && ((float) com_ushareit_listenit_afz.f4294b) > ((float) a2) + (((float) a) * 0.2f)) {
            return false;
        }
        return true;
    }

    private String m5531b(afz com_ushareit_listenit_afz) {
        int i;
        long j;
        int i2;
        int i3 = !TextUtils.isEmpty(this.f4305a.m5578c()) ? 1 : 0;
        long a = this.f4306b.mo627d() ? this.f4306b.mo623a() : this.f4305a.mo619a();
        if (a >= 0) {
            i = 1;
        } else {
            i = 0;
        }
        if (com_ushareit_listenit_afz.f4295c) {
            j = a - com_ushareit_listenit_afz.f4294b;
        } else {
            j = a;
        }
        if (i == 0 || !com_ushareit_listenit_afz.f4295c) {
            i2 = 0;
        } else {
            i2 = 1;
        }
        return (com_ushareit_listenit_afz.f4295c ? "HTTP/1.1 206 PARTIAL CONTENT\n" : "HTTP/1.1 200 OK\n") + "Accept-Ranges: bytes\n" + (i != 0 ? m5528a("Content-Length: %d\n", Long.valueOf(j)) : "") + (i2 != 0 ? m5528a("Content-Range: bytes %d-%d/%d\n", Long.valueOf(com_ushareit_listenit_afz.f4294b), Long.valueOf(a - 1), Long.valueOf(a)) : "") + (i3 != 0 ? m5528a("Content-Type: %s\n", r10) : "") + "\n";
    }

    private void m5529a(OutputStream outputStream, long j) {
        byte[] bArr = new byte[8192];
        while (true) {
            int a = m5523a(bArr, j, bArr.length);
            if (a != -1) {
                outputStream.write(bArr, 0, a);
                j += (long) a;
            } else {
                outputStream.flush();
                return;
            }
        }
    }

    private void m5532b(OutputStream outputStream, long j) {
        agi com_ushareit_listenit_agi = new agi(this.f4305a);
        try {
            com_ushareit_listenit_agi.mo620a((long) ((int) j));
            byte[] bArr = new byte[8192];
            while (true) {
                int a = com_ushareit_listenit_agi.mo618a(bArr);
                if (a == -1) {
                    break;
                }
                outputStream.write(bArr, 0, a);
                j += (long) a;
            }
            outputStream.flush();
        } finally {
            com_ushareit_listenit_agi.mo621b();
        }
    }

    private String m5528a(String str, Object... objArr) {
        return String.format(Locale.US, str, objArr);
    }

    protected void mo616a(int i) {
        if (this.f4307c != null) {
            this.f4307c.mo617a(this.f4306b.f4353a, this.f4305a.m5579d(), i);
        }
    }
}
