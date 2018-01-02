package com.ushareit.listenit;

import android.view.View;

public abstract class ro {
    protected final sh f16430a;
    private int f16431b;

    public abstract int mo3029a(View view);

    public abstract void mo3030a(int i);

    public abstract int mo3031b(View view);

    public abstract int mo3032c();

    public abstract int mo3033c(View view);

    public abstract int mo3034d();

    public abstract int mo3035d(View view);

    public abstract int mo3036e();

    public abstract int mo3037f();

    public abstract int mo3038g();

    private ro(sh shVar) {
        this.f16431b = Integer.MIN_VALUE;
        this.f16430a = shVar;
    }

    public void m25967a() {
        this.f16431b = mo3037f();
    }

    public int m25969b() {
        return Integer.MIN_VALUE == this.f16431b ? 0 : mo3037f() - this.f16431b;
    }

    public static ro m25964a(sh shVar, int i) {
        switch (i) {
            case 0:
                return m25963a(shVar);
            case 1:
                return m25965b(shVar);
            default:
                throw new IllegalArgumentException("invalid orientation");
        }
    }

    public static ro m25963a(sh shVar) {
        return new rp(shVar);
    }

    public static ro m25965b(sh shVar) {
        return new rq(shVar);
    }
}
