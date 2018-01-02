package com.ushareit.listenit;

import java.util.HashMap;
import java.util.Map;

public class aue {
    public final String f5483a;
    public final long f5484b;
    public final long f5485c;
    public final long f5486d;
    public final long f5487e;
    public final long f5488f;
    public final long f5489g;
    public final long f5490h;

    private aue(String str, long j, long j2, long j3, long j4, long j5, long j6, long j7) {
        this.f5483a = str;
        this.f5484b = j;
        this.f5485c = j2;
        this.f5486d = j3;
        this.f5487e = j4;
        this.f5488f = j5;
        this.f5489g = j6;
        this.f5490h = j7;
    }

    public Map<String, String> m7184a() {
        Map<String, String> hashMap = new HashMap(7);
        hashMap.put("initial_url", this.f5483a);
        hashMap.put("handler_time_ms", String.valueOf(this.f5484b));
        hashMap.put("load_start_ms", String.valueOf(this.f5485c));
        hashMap.put("response_end_ms", String.valueOf(this.f5486d));
        hashMap.put("dom_content_loaded_ms", String.valueOf(this.f5487e));
        hashMap.put("scroll_ready_ms", String.valueOf(this.f5488f));
        hashMap.put("load_finish_ms", String.valueOf(this.f5489g));
        hashMap.put("session_finish_ms", String.valueOf(this.f5490h));
        return hashMap;
    }
}
