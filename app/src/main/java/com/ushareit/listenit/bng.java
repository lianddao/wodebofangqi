package com.ushareit.listenit;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import com.google.android.exoplayer2.Format;
import java.nio.ByteBuffer;

public final class bng<T> extends bff implements Callback {
    private final bne<T> f7130a;
    private final bnh<T> f7131b;
    private final Handler f7132c;
    private final bfu f7133d;
    private final bhf f7134e;
    private boolean f7135f;
    private long f7136g;
    private T f7137h;

    public bng(bnh<T> com_ushareit_listenit_bnh_T, Looper looper, bne<T> com_ushareit_listenit_bne_T) {
        super(4);
        this.f7131b = (bnh) bsg.m9654a((Object) com_ushareit_listenit_bnh_T);
        this.f7132c = looper == null ? null : new Handler(looper, this);
        this.f7130a = (bne) bsg.m9654a((Object) com_ushareit_listenit_bne_T);
        this.f7133d = new bfu();
        this.f7134e = new bhf(1);
    }

    public int mo931a(Format format) {
        return this.f7130a.mo1022a(format.f1431e) ? 3 : 0;
    }

    protected void mo933a(long j, boolean z) {
        this.f7137h = null;
        this.f7135f = false;
    }

    public void mo932a(long j, long j2) {
        if (!this.f7135f && this.f7137h == null) {
            this.f7134e.mo951a();
            if (m7979a(this.f7133d, this.f7134e) == -4) {
                if (this.f7134e.m8384c()) {
                    this.f7135f = true;
                } else {
                    this.f7136g = this.f7134e.f6322c;
                    try {
                        this.f7134e.m8399e();
                        ByteBuffer byteBuffer = this.f7134e.f6321b;
                        this.f7137h = this.f7130a.mo1021a(byteBuffer.array(), byteBuffer.limit());
                    } catch (Exception e) {
                        throw bfi.m8024a(e, m8003p());
                    }
                }
            }
        }
        if (this.f7137h != null && this.f7136g <= j) {
            m9126a(this.f7137h);
            this.f7137h = null;
        }
    }

    protected void mo937o() {
        this.f7137h = null;
        super.mo937o();
    }

    public boolean mo939s() {
        return this.f7135f;
    }

    public boolean mo938r() {
        return true;
    }

    private void m9126a(T t) {
        if (this.f7132c != null) {
            this.f7132c.obtainMessage(0, t).sendToTarget();
        } else {
            m9127b(t);
        }
    }

    public boolean handleMessage(Message message) {
        switch (message.what) {
            case 0:
                m9127b(message.obj);
                return true;
            default:
                return false;
        }
    }

    private void m9127b(T t) {
        this.f7131b.mo918a(t);
    }
}
