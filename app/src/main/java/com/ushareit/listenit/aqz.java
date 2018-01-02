package com.ushareit.listenit;

import android.text.TextUtils;
import java.io.BufferedOutputStream;
import java.io.OutputStream;
import java.net.Socket;

class aqz extends arm {
    private final arj f5209a;
    private final aqn f5210b;
    private aqw f5211c;

    public aqz(arj com_ushareit_listenit_arj, aqn com_ushareit_listenit_aqn) {
        super(com_ushareit_listenit_arj, com_ushareit_listenit_aqn);
        this.f5210b = com_ushareit_listenit_aqn;
        this.f5209a = com_ushareit_listenit_arj;
    }

    private void m6841a(OutputStream outputStream, long j) {
        byte[] bArr = new byte[8192];
        while (true) {
            int a = m6836a(bArr, j, bArr.length);
            if (a != -1) {
                outputStream.write(bArr, 0, a);
                j += (long) a;
            } else {
                outputStream.flush();
                return;
            }
        }
    }

    private boolean m6842a(aqy com_ushareit_listenit_aqy) {
        int a = this.f5209a.mo788a();
        boolean z = a > 0;
        int a2 = this.f5210b.mo777a();
        if (z && com_ushareit_listenit_aqy.f5200c) {
            if (((float) com_ushareit_listenit_aqy.f5199b) > (((float) a) * 0.2f) + ((float) a2)) {
                return false;
            }
        }
        return true;
    }

    private String m6843b(aqy com_ushareit_listenit_aqy) {
        int i = !TextUtils.isEmpty(this.f5209a.m6899c()) ? 1 : 0;
        int a = this.f5210b.mo782d() ? this.f5210b.mo777a() : this.f5209a.mo788a();
        int i2 = a >= 0 ? 1 : 0;
        long j = com_ushareit_listenit_aqy.f5200c ? ((long) a) - com_ushareit_listenit_aqy.f5199b : (long) a;
        int i3 = (i2 == 0 || !com_ushareit_listenit_aqy.f5200c) ? 0 : 1;
        return (com_ushareit_listenit_aqy.f5200c ? "HTTP/1.1 206 PARTIAL CONTENT\n" : "HTTP/1.1 200 OK\n") + "Accept-Ranges: bytes\n" + (i2 != 0 ? String.format("Content-Length: %d\n", new Object[]{Long.valueOf(j)}) : "") + (i3 != 0 ? String.format("Content-Range: bytes %d-%d/%d\n", new Object[]{Long.valueOf(com_ushareit_listenit_aqy.f5199b), Integer.valueOf(a - 1), Integer.valueOf(a)}) : "") + (i != 0 ? String.format("Content-Type: %s\n", new Object[]{r9}) : "") + "\n";
    }

    private void m6844b(OutputStream outputStream, long j) {
        try {
            arj com_ushareit_listenit_arj = new arj(this.f5209a);
            com_ushareit_listenit_arj.mo790a((int) j);
            byte[] bArr = new byte[8192];
            while (true) {
                int a = com_ushareit_listenit_arj.mo789a(bArr);
                if (a == -1) {
                    break;
                }
                outputStream.write(bArr, 0, a);
                j += (long) a;
            }
            outputStream.flush();
        } finally {
            this.f5209a.mo791b();
        }
    }

    protected void mo786a(int i) {
        if (this.f5211c != null) {
            this.f5211c.mo787a(this.f5210b.f5186a, this.f5209a.f5238a, i);
        }
    }

    public void m6846a(aqw com_ushareit_listenit_aqw) {
        this.f5211c = com_ushareit_listenit_aqw;
    }

    public void m6847a(aqy com_ushareit_listenit_aqy, Socket socket) {
        OutputStream bufferedOutputStream = new BufferedOutputStream(socket.getOutputStream());
        bufferedOutputStream.write(m6843b(com_ushareit_listenit_aqy).getBytes("UTF-8"));
        long j = com_ushareit_listenit_aqy.f5199b;
        if (m6842a(com_ushareit_listenit_aqy)) {
            m6841a(bufferedOutputStream, j);
        } else {
            m6844b(bufferedOutputStream, j);
        }
    }
}
