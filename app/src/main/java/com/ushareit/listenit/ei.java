package com.ushareit.listenit;

import android.os.Process;

class ei extends eo<Params, Result> {
    final /* synthetic */ eg f11072a;

    ei(eg egVar) {
        this.f11072a = egVar;
        super();
    }

    public Result call() {
        this.f11072a.f10375i.set(true);
        Process.setThreadPriority(10);
        return this.f11072a.m15725d(this.f11072a.mo2077a(this.b));
    }
}
