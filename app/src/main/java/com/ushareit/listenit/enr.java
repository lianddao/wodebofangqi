package com.ushareit.listenit;

import android.content.Context;
import android.text.TextUtils;
import com.mopub.common.AdUrlGenerator;
import com.mopub.common.ClientMetadata;
import com.mopub.common.Constants;
import com.mopub.nativeads.RequestParameters;

public class enr extends AdUrlGenerator {
    private String f11323e;
    private String f11324f;

    public enr(Context context) {
        super(context);
    }

    public enr withAdUnitId(String str) {
        this.b = str;
        return this;
    }

    public enr m17210a(RequestParameters requestParameters) {
        if (requestParameters != null) {
            this.c = requestParameters.getKeywords();
            this.d = requestParameters.getLocation();
            this.f11323e = requestParameters.getDesiredAssets();
        }
        return this;
    }

    public enr m17209a(int i) {
        this.f11324f = String.valueOf(i);
        return this;
    }

    public String generateUrlString(String str) {
        m2604a(str, Constants.AD_HANDLER);
        m2617a(ClientMetadata.getInstance(this.a));
        m17208d();
        m17207c();
        return m2602a();
    }

    private void m17207c() {
        if (!TextUtils.isEmpty(this.f11324f)) {
            m2607b("MAGIC_NO", this.f11324f);
        }
    }

    private void m17208d() {
        if (!TextUtils.isEmpty(this.f11323e)) {
            m2607b("assets", this.f11323e);
        }
    }

    protected void mo2223b(String str) {
        m2607b("nsv", str);
    }
}
