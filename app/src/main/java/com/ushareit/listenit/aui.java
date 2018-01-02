package com.ushareit.listenit;

import java.util.HashMap;
import java.util.Map;

public class aui {
    private final String f5501a;
    private final String f5502b;
    private final String f5503c;

    public aui(String str, String str2) {
        this(str, str2, false);
    }

    public aui(String str, String str2, boolean z) {
        this.f5501a = str;
        this.f5502b = str2;
        this.f5503c = z ? "1" : "0";
    }

    public Map<String, String> m7197a() {
        Map<String, String> hashMap = new HashMap();
        hashMap.put("stacktrace", this.f5501a);
        hashMap.put("app_crashed_version", this.f5502b);
        hashMap.put("caught_exception", this.f5503c);
        return hashMap;
    }
}
