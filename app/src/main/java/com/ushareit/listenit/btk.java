package com.ushareit.listenit;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;
import android.view.Choreographer;
import android.view.Choreographer.FrameCallback;

final class btk implements Callback, FrameCallback {
    private static final btk f7717b = new btk();
    public volatile long f7718a;
    private final Handler f7719c;
    private final HandlerThread f7720d = new HandlerThread("ChoreographerOwner:Handler");
    private Choreographer f7721e;
    private int f7722f;

    public static btk m9825a() {
        return f7717b;
    }

    private btk() {
        this.f7720d.start();
        this.f7719c = new Handler(this.f7720d.getLooper(), this);
        this.f7719c.sendEmptyMessage(0);
    }

    public void m9829b() {
        this.f7719c.sendEmptyMessage(1);
    }

    public void m9830c() {
        this.f7719c.sendEmptyMessage(2);
    }

    public void doFrame(long j) {
        this.f7718a = j;
        this.f7721e.postFrameCallbackDelayed(this, 500);
    }

    public boolean handleMessage(Message message) {
        switch (message.what) {
            case 0:
                m9826d();
                return true;
            case 1:
                m9827e();
                return true;
            case 2:
                m9828f();
                return true;
            default:
                return false;
        }
    }

    private void m9826d() {
        this.f7721e = Choreographer.getInstance();
    }

    private void m9827e() {
        this.f7722f++;
        if (this.f7722f == 1) {
            this.f7721e.postFrameCallback(this);
        }
    }

    private void m9828f() {
        this.f7722f--;
        if (this.f7722f == 0) {
            this.f7721e.removeFrameCallback(this);
            this.f7718a = 0;
        }
    }
}
