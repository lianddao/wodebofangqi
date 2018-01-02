package com.ushareit.listenit;

import android.content.Context;
import java.util.HashMap;
import java.util.Map;

public abstract class akz {
    protected final alb f4618a;
    protected final aru f4619b;
    private final Context f4620c;
    private boolean f4621d;

    public akz(Context context, alb com_ushareit_listenit_alb, aru com_ushareit_listenit_aru) {
        this.f4620c = context;
        this.f4618a = com_ushareit_listenit_alb;
        this.f4619b = com_ushareit_listenit_aru;
    }

    public final void m5951a() {
        if (!this.f4621d) {
            if (this.f4618a != null) {
                this.f4618a.mo100d();
            }
            Map hashMap = new HashMap();
            if (this.f4619b != null) {
                this.f4619b.m6935a(hashMap);
            }
            mo732a(hashMap);
            this.f4621d = true;
            atz.m7169a(this.f4620c, "Impression logged");
            if (this.f4618a != null) {
                this.f4618a.mo101e();
            }
        }
    }

    protected abstract void mo732a(Map<String, String> map);
}
