package com.ushareit.listenit;

import android.content.Context;
import android.os.Build.VERSION;
import java.util.concurrent.ExecutorService;

public class tu {
    private final Context f16826a;
    private vr f16827b;
    private ws f16828c;
    private xw f16829d;
    private ExecutorService f16830e;
    private ExecutorService f16831f;
    private ut f16832g;
    private xh f16833h;

    public tu(Context context) {
        this.f16826a = context.getApplicationContext();
    }

    public tu m26470a(xh xhVar) {
        this.f16833h = xhVar;
        return this;
    }

    tt m26469a() {
        if (this.f16830e == null) {
            this.f16830e = new yc(Math.max(1, Runtime.getRuntime().availableProcessors()));
        }
        if (this.f16831f == null) {
            this.f16831f = new yc(1);
        }
        xy xyVar = new xy(this.f16826a);
        if (this.f16828c == null) {
            if (VERSION.SDK_INT >= 11) {
                this.f16828c = new ww(xyVar.m27231b());
            } else {
                this.f16828c = new wt();
            }
        }
        if (this.f16829d == null) {
            this.f16829d = new xv(xyVar.m27230a());
        }
        if (this.f16833h == null) {
            this.f16833h = new xt(this.f16826a);
        }
        if (this.f16827b == null) {
            this.f16827b = new vr(this.f16829d, this.f16833h, this.f16831f, this.f16830e);
        }
        if (this.f16832g == null) {
            this.f16832g = ut.f16999d;
        }
        return new tt(this.f16827b, this.f16829d, this.f16828c, this.f16826a, this.f16832g);
    }
}
