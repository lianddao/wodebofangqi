package com.ushareit.listenit;

import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Log;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class aux extends AsyncTask<String, Void, auz> {
    private static final String f5549a = aux.class.getSimpleName();
    private static final Set<String> f5550b = new HashSet();
    private Map<String, String> f5551c;
    private Map<String, String> f5552d;
    private aqg f5553e;
    private auy f5554f;

    static {
        f5550b.add("#");
        f5550b.add("null");
    }

    public aux() {
        this(null, null);
    }

    public aux(Map<String, String> map) {
        this(map, null);
    }

    public aux(Map<String, String> map, Map<String, String> map2) {
        Map map3 = null;
        this.f5551c = map != null ? new HashMap(map) : null;
        if (map2 != null) {
            map3 = new HashMap(map2);
        }
        this.f5552d = map3;
    }

    private String m7237a(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            return str;
        }
        return str + (str.contains("?") ? "&" : "?") + str2 + "=" + URLEncoder.encode(str3);
    }

    private boolean m7238a(String str) {
        aps b = auv.m7231b();
        try {
            if (this.f5552d == null || this.f5552d.size() == 0) {
                this.f5553e = b.m6722a(str, null);
            } else {
                aqi com_ushareit_listenit_aqi = new aqi();
                com_ushareit_listenit_aqi.m6783a(this.f5552d);
                this.f5553e = b.m6731b(str, com_ushareit_listenit_aqi);
            }
            return this.f5553e != null && this.f5553e.m6776a() == 200;
        } catch (Throwable e) {
            Log.e(f5549a, "Error opening url: " + str, e);
            return false;
        }
    }

    private String m7239b(String str) {
        try {
            str = m7237a(str, "analog", atz.m7161a(asm.m6975a()));
        } catch (Exception e) {
        }
        return str;
    }

    protected auz m7240a(String... strArr) {
        Object obj = strArr[0];
        if (TextUtils.isEmpty(obj) || f5550b.contains(obj)) {
            return null;
        }
        String b = m7239b(obj);
        if (!(this.f5551c == null || this.f5551c.isEmpty())) {
            String str = b;
            for (Entry entry : this.f5551c.entrySet()) {
                str = m7237a(str, (String) entry.getKey(), (String) entry.getValue());
            }
            b = str;
        }
        int i = 1;
        while (true) {
            int i2 = i + 1;
            if (i > 2) {
                return null;
            }
            if (m7238a(b)) {
                return new auz(this.f5553e);
            }
            i = i2;
        }
    }

    public void m7241a(auy com_ushareit_listenit_auy) {
        this.f5554f = com_ushareit_listenit_auy;
    }

    protected void m7242a(auz com_ushareit_listenit_auz) {
        if (this.f5554f != null) {
            this.f5554f.mo161a(com_ushareit_listenit_auz);
        }
    }

    protected /* synthetic */ Object doInBackground(Object[] objArr) {
        return m7240a((String[]) objArr);
    }

    protected void onCancelled() {
        if (this.f5554f != null) {
            this.f5554f.mo160a();
        }
    }

    protected /* synthetic */ void onPostExecute(Object obj) {
        m7242a((auz) obj);
    }
}
