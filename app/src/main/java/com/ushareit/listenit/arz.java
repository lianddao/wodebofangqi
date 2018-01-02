package com.ushareit.listenit;

import android.text.TextUtils;
import com.mopub.common.AdType;
import java.util.Locale;

public enum arz {
    UNKNOWN("unknown"),
    BANNER("banner"),
    INTERSTITIAL(AdType.INTERSTITIAL),
    NATIVE("native"),
    INSTREAM("instream"),
    REWARDED_VIDEO(AdType.REWARDED_VIDEO);
    
    private String f5299g;

    private arz(String str) {
        this.f5299g = str;
    }

    public static arz m6943a(String str) {
        if (TextUtils.isEmpty(str)) {
            return UNKNOWN;
        }
        try {
            return valueOf(str.toUpperCase(Locale.US));
        } catch (Exception e) {
            return UNKNOWN;
        }
    }

    public String toString() {
        return this.f5299g;
    }
}
