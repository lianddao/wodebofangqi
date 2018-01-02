package com.ushareit.listenit;

import android.content.Intent;
import com.ushareit.listenit.service.CommonService;

public class guh extends gwv {
    final /* synthetic */ Intent f14743a;
    final /* synthetic */ CommonService f14744b;

    public guh(CommonService commonService, String str, Intent intent) {
        this.f14744b = commonService;
        this.f14743a = intent;
        super(str);
    }

    public void execute() {
        if (this.f14743a == null || !this.f14743a.hasExtra("StartType")) {
            this.f14744b.m26043a(guk.ALL);
            return;
        }
        this.f14744b.f16441a = gul.m22820a(this.f14743a.getIntExtra("StartType", 1));
        this.f14744b.m26042a(this.f14743a);
    }
}
