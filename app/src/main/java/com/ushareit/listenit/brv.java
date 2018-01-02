package com.ushareit.listenit;

import android.text.TextUtils;
import com.mopub.common.AdType;

final class brv implements bsu<String> {
    brv() {
    }

    public boolean m9624a(String str) {
        String d = btc.m9776d(str);
        return (TextUtils.isEmpty(d) || ((d.contains("text") && !d.contains("text/vtt")) || d.contains(AdType.HTML) || d.contains("xml"))) ? false : true;
    }
}
