package com.ushareit.listenit;

import android.content.Context;
import java.util.concurrent.Callable;

class ank implements Callable<ara> {
    final /* synthetic */ Context f4934a;
    final /* synthetic */ anj f4935b;

    ank(anj com_ushareit_listenit_anj, Context context) {
        this.f4935b = com_ushareit_listenit_anj;
        this.f4934a = context;
    }

    public ara m6388a() {
        return new ara(this.f4934a);
    }

    public /* synthetic */ Object call() {
        return m6388a();
    }
}
