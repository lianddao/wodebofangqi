package com.ushareit.listenit;

import java.util.Map;

public class cyf {
    private final String f9359a;
    private final Map<String, Object> f9360b;

    public cyf(String str, Map<String, Object> map) {
        this.f9359a = str;
        this.f9360b = map;
    }

    public static cyf m13362a(String str) {
        if (!str.startsWith("gauth|")) {
            return null;
        }
        try {
            Map a = cyg.m13368a(str.substring("gauth|".length()));
            return new cyf((String) a.get("token"), (Map) a.get("auth"));
        } catch (Throwable e) {
            throw new RuntimeException("Failed to parse gauth token", e);
        }
    }

    public String m13363a() {
        return this.f9359a;
    }

    public Map<String, Object> m13364b() {
        return this.f9360b;
    }
}
