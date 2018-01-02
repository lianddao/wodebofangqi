package com.ushareit.listenit;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;
import java.io.IOException;

@SuppressLint({"HandlerLeak"})
final class bsc<T extends bsd> extends Handler implements Runnable {
    public final int f7591a;
    final /* synthetic */ bsa f7592b;
    private final T f7593c;
    private final bsb<T> f7594d;
    private final long f7595e;
    private IOException f7596f;
    private int f7597g;
    private volatile Thread f7598h;
    private volatile boolean f7599i;

    public bsc(bsa com_ushareit_listenit_bsa, Looper looper, T t, bsb<T> com_ushareit_listenit_bsb_T, int i, long j) {
        this.f7592b = com_ushareit_listenit_bsa;
        super(looper);
        this.f7593c = t;
        this.f7594d = com_ushareit_listenit_bsb_T;
        this.f7591a = i;
        this.f7595e = j;
    }

    public void m9650a(int i) {
        if (this.f7596f != null && this.f7597g > i) {
            throw this.f7596f;
        }
    }

    public void m9651a(long j) {
        bsg.m9658b(this.f7592b.f7589b == null);
        this.f7592b.f7589b = this;
        if (j > 0) {
            sendEmptyMessageDelayed(0, j);
        } else {
            m9647a();
        }
    }

    public void m9652a(boolean z) {
        this.f7599i = z;
        this.f7596f = null;
        if (hasMessages(0)) {
            removeMessages(0);
            if (!z) {
                sendEmptyMessage(1);
            }
        } else {
            this.f7593c.mo1039a();
            if (this.f7598h != null) {
                this.f7598h.interrupt();
            }
        }
        if (z) {
            m9648b();
            long elapsedRealtime = SystemClock.elapsedRealtime();
            this.f7594d.mo1031a(this.f7593c, elapsedRealtime, elapsedRealtime - this.f7595e, true);
        }
    }

    public void run() {
        try {
            this.f7598h = Thread.currentThread();
            if (!this.f7593c.mo1040b()) {
                btb.m9756a("load:" + this.f7593c.getClass().getSimpleName());
                this.f7593c.mo1041c();
                btb.m9755a();
            }
            if (!this.f7599i) {
                sendEmptyMessage(2);
            }
        } catch (IOException e) {
            if (!this.f7599i) {
                obtainMessage(3, e).sendToTarget();
            }
        } catch (InterruptedException e2) {
            bsg.m9658b(this.f7593c.mo1040b());
            if (!this.f7599i) {
                sendEmptyMessage(2);
            }
        } catch (Throwable e3) {
            Log.e("LoadTask", "Unexpected exception loading stream", e3);
            if (!this.f7599i) {
                obtainMessage(3, new bse(e3)).sendToTarget();
            }
        } catch (Throwable e32) {
            Log.e("LoadTask", "Unexpected error loading stream", e32);
            if (!this.f7599i) {
                obtainMessage(4, e32).sendToTarget();
            }
            throw e32;
        } catch (Throwable th) {
            btb.m9755a();
        }
    }

    public void handleMessage(Message message) {
        if (!this.f7599i) {
            if (message.what == 0) {
                m9647a();
            } else if (message.what == 4) {
                throw ((Error) message.obj);
            } else {
                m9648b();
                long elapsedRealtime = SystemClock.elapsedRealtime();
                long j = elapsedRealtime - this.f7595e;
                if (this.f7593c.mo1040b()) {
                    this.f7594d.mo1031a(this.f7593c, elapsedRealtime, j, false);
                    return;
                }
                switch (message.what) {
                    case 1:
                        this.f7594d.mo1031a(this.f7593c, elapsedRealtime, j, false);
                        return;
                    case 2:
                        this.f7594d.mo1030a(this.f7593c, elapsedRealtime, j);
                        return;
                    case 3:
                        this.f7596f = (IOException) message.obj;
                        int a = this.f7594d.mo1023a(this.f7593c, elapsedRealtime, j, this.f7596f);
                        if (a == 3) {
                            this.f7592b.f7590c = this.f7596f;
                            return;
                        } else if (a != 2) {
                            if (a == 1) {
                                a = 1;
                            } else {
                                a = this.f7597g + 1;
                            }
                            this.f7597g = a;
                            m9651a(m9649c());
                            return;
                        } else {
                            return;
                        }
                    default:
                        return;
                }
            }
        }
    }

    private void m9647a() {
        this.f7596f = null;
        this.f7592b.f7588a.submit(this.f7592b.f7589b);
    }

    private void m9648b() {
        this.f7592b.f7589b = null;
    }

    private long m9649c() {
        return (long) Math.min((this.f7597g - 1) * 1000, 5000);
    }
}
