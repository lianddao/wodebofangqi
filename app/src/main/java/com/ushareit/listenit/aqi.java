package com.ushareit.listenit;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class aqi implements Map<String, String> {
    private Map<String, String> f5185a = new HashMap();

    public aqi m6783a(Map<? extends String, ? extends String> map) {
        putAll(map);
        return this;
    }

    public String m6784a() {
        StringBuilder stringBuilder = new StringBuilder();
        for (String str : this.f5185a.keySet()) {
            if (stringBuilder.length() > 0) {
                stringBuilder.append("&");
            }
            stringBuilder.append(str);
            String str2 = (String) this.f5185a.get(str2);
            if (str2 != null) {
                stringBuilder.append("=");
                try {
                    stringBuilder.append(URLEncoder.encode(str2, "UTF-8"));
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
        }
        return stringBuilder.toString();
    }

    public String m6785a(Object obj) {
        return (String) this.f5185a.get(obj);
    }

    public String m6786a(String str, String str2) {
        return (String) this.f5185a.put(str, str2);
    }

    public String m6787b(Object obj) {
        return (String) this.f5185a.remove(obj);
    }

    public byte[] m6788b() {
        byte[] bArr = null;
        try {
            bArr = m6784a().getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return bArr;
    }

    public void clear() {
        this.f5185a.clear();
    }

    public boolean containsKey(Object obj) {
        return this.f5185a.containsKey(obj);
    }

    public boolean containsValue(Object obj) {
        return this.f5185a.containsValue(obj);
    }

    public Set<Entry<String, String>> entrySet() {
        return this.f5185a.entrySet();
    }

    public /* synthetic */ Object get(Object obj) {
        return m6785a(obj);
    }

    public boolean isEmpty() {
        return this.f5185a.isEmpty();
    }

    public Set<String> keySet() {
        return this.f5185a.keySet();
    }

    public /* synthetic */ Object put(Object obj, Object obj2) {
        return m6786a((String) obj, (String) obj2);
    }

    public void putAll(Map<? extends String, ? extends String> map) {
        this.f5185a.putAll(map);
    }

    public /* synthetic */ Object remove(Object obj) {
        return m6787b(obj);
    }

    public int size() {
        return this.f5185a.size();
    }

    public Collection<String> values() {
        return this.f5185a.values();
    }
}
