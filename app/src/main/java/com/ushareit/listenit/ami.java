package com.ushareit.listenit;

import android.content.Context;
import android.text.TextUtils;
import com.facebook.ads.internal.view.C0022b;
import java.util.Map;

public class ami extends akz {
    private static final String f4849c = ami.class.getSimpleName();
    private final C0022b f4850d;
    private final Context f4851e;
    private amh f4852f;

    public ami(Context context, C0022b c0022b, aru com_ushareit_listenit_aru, alb com_ushareit_listenit_alb) {
        super(context, com_ushareit_listenit_alb, com_ushareit_listenit_aru);
        this.f4851e = context.getApplicationContext();
        this.f4850d = c0022b;
    }

    public void m6287a(amh com_ushareit_listenit_amh) {
        this.f4852f = com_ushareit_listenit_amh;
    }

    protected void mo732a(Map<String, String> map) {
        if (this.f4852f != null && !TextUtils.isEmpty(this.f4852f.mo698y())) {
            apb.m6565a(this.f4851e).mo742a(this.f4852f.mo698y(), (Map) map);
        }
    }
}
