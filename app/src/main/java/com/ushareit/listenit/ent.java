package com.ushareit.listenit;

import android.content.Context;
import com.mopub.common.BaseUrlGenerator;
import com.mopub.common.ClientMetadata;
import com.mopub.common.Constants;

class ent extends BaseUrlGenerator {
    private final Context f11332a;
    private String f11333b;

    public ent(Context context) {
        this.f11332a = context;
    }

    public ent withAdUnitId(String str) {
        this.f11333b = str;
        return this;
    }

    public String generateUrlString(String str) {
        m2604a(str, Constants.POSITIONING_HANDLER);
        m17232a(this.f11333b);
        m2609k("1");
        ClientMetadata instance = ClientMetadata.getInstance(this.f11332a);
        m17233b(instance.getSdkVersion());
        m2605a(instance.getDeviceManufacturer(), instance.getDeviceModel(), instance.getDeviceProduct());
        m2610l(instance.getAppVersion());
        m2606b();
        return m2602a();
    }

    private void m17232a(String str) {
        m2607b("id", str);
    }

    private void m17233b(String str) {
        m2607b("nsv", str);
    }
}
