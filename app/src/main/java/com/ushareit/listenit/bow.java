package com.ushareit.listenit;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import com.google.android.exoplayer2.Format;
import java.util.Collections;
import java.util.List;

public final class bow extends bff implements Callback {
    private final Handler f7247a;
    private final box f7248b;
    private final bos f7249c;
    private final bfu f7250d;
    private boolean f7251e;
    private boolean f7252f;
    private boq f7253g;
    private bou f7254h;
    private bov f7255i;
    private bov f7256j;
    private int f7257k;

    public bow(box com_ushareit_listenit_box, Looper looper) {
        this(com_ushareit_listenit_box, looper, bos.f7245a);
    }

    public bow(box com_ushareit_listenit_box, Looper looper, bos com_ushareit_listenit_bos) {
        super(3);
        this.f7248b = (box) bsg.m9654a((Object) com_ushareit_listenit_box);
        this.f7247a = looper == null ? null : new Handler(looper, this);
        this.f7249c = com_ushareit_listenit_bos;
        this.f7250d = new bfu();
    }

    public int mo931a(Format format) {
        if (this.f7249c.mo1068a(format)) {
            return 3;
        }
        return bsn.m9679c(format.f1431e) ? 1 : 0;
    }

    protected void mo1070a(Format[] formatArr) {
        if (this.f7253g != null) {
            this.f7253g.mo956d();
            this.f7254h = null;
        }
        this.f7253g = this.f7249c.mo1069b(formatArr[0]);
    }

    protected void mo933a(long j, boolean z) {
        this.f7251e = false;
        this.f7252f = false;
        if (this.f7255i != null) {
            this.f7255i.mo1067d();
            this.f7255i = null;
        }
        if (this.f7256j != null) {
            this.f7256j.mo1067d();
            this.f7256j = null;
        }
        this.f7254h = null;
        m9275u();
        this.f7253g.mo955c();
    }

    public void mo932a(long j, long j2) {
        if (!this.f7252f) {
            if (this.f7256j == null) {
                this.f7253g.mo1057a(j);
                try {
                    this.f7256j = (bov) this.f7253g.mo954b();
                } catch (Exception e) {
                    throw bfi.m8024a(e, m8003p());
                }
            }
            if (mo872d() == 2) {
                boolean z = false;
                if (this.f7255i != null) {
                    long t = m9274t();
                    while (t <= j) {
                        this.f7257k++;
                        t = m9274t();
                        z = true;
                    }
                }
                if (this.f7256j != null) {
                    if (this.f7256j.m8384c()) {
                        if (!z && m9274t() == Long.MAX_VALUE) {
                            if (this.f7255i != null) {
                                this.f7255i.mo1067d();
                                this.f7255i = null;
                            }
                            this.f7256j.mo1067d();
                            this.f7256j = null;
                            this.f7252f = true;
                        }
                    } else if (this.f7256j.a <= j) {
                        if (this.f7255i != null) {
                            this.f7255i.mo1067d();
                        }
                        this.f7255i = this.f7256j;
                        this.f7256j = null;
                        this.f7257k = this.f7255i.mo1063a(j);
                        z = true;
                    }
                }
                if (z) {
                    m9272a(this.f7255i.mo1066b(j));
                }
                while (!this.f7251e) {
                    if (this.f7254h == null) {
                        this.f7254h = (bou) this.f7253g.mo952a();
                        if (this.f7254h == null) {
                            return;
                        }
                    }
                    int a = m7979a(this.f7250d, this.f7254h);
                    if (a == -4) {
                        this.f7254h.m8383c(Integer.MIN_VALUE);
                        if (this.f7254h.m8384c()) {
                            this.f7251e = true;
                        } else {
                            try {
                                this.f7254h.f7246d = this.f7250d.f6128a.f1447u;
                                this.f7254h.m8399e();
                            } catch (Exception e2) {
                                throw bfi.m8024a(e2, m8003p());
                            }
                        }
                        this.f7253g.mo953a(this.f7254h);
                        this.f7254h = null;
                    } else if (a == -3) {
                        return;
                    }
                }
            }
        }
    }

    protected void mo937o() {
        if (this.f7255i != null) {
            this.f7255i.mo1067d();
            this.f7255i = null;
        }
        if (this.f7256j != null) {
            this.f7256j.mo1067d();
            this.f7256j = null;
        }
        this.f7253g.mo956d();
        this.f7253g = null;
        this.f7254h = null;
        m9275u();
        super.mo937o();
    }

    public boolean mo939s() {
        return this.f7252f;
    }

    public boolean mo938r() {
        return true;
    }

    private long m9274t() {
        if (this.f7257k == -1 || this.f7257k >= this.f7255i.mo1065b()) {
            return Long.MAX_VALUE;
        }
        return this.f7255i.mo1064a(this.f7257k);
    }

    private void m9272a(List<bom> list) {
        if (this.f7247a != null) {
            this.f7247a.obtainMessage(0, list).sendToTarget();
        } else {
            m9273b(list);
        }
    }

    private void m9275u() {
        m9272a(Collections.emptyList());
    }

    public boolean handleMessage(Message message) {
        switch (message.what) {
            case 0:
                m9273b((List) message.obj);
                return true;
            default:
                return false;
        }
    }

    private void m9273b(List<bom> list) {
        this.f7248b.mo243a(list);
    }
}
