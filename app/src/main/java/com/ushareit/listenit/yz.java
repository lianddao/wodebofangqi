package com.ushareit.listenit;

import android.text.TextUtils;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class yz {
    private static final String f17595a = System.getProperty("http.agent");
    private static final Map<String, List<yx>> f17596b;
    private boolean f17597c = true;
    private Map<String, List<yx>> f17598d = f17596b;
    private boolean f17599e = true;
    private boolean f17600f = true;

    static {
        Map hashMap = new HashMap(2);
        if (!TextUtils.isEmpty(f17595a)) {
            hashMap.put("User-Agent", Collections.singletonList(new za(f17595a)));
        }
        hashMap.put("Accept-Encoding", Collections.singletonList(new za("identity")));
        f17596b = Collections.unmodifiableMap(hashMap);
    }

    public yy m27273a() {
        this.f17597c = true;
        return new yy(this.f17598d);
    }
}
