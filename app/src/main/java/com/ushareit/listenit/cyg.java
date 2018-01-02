package com.ushareit.listenit;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONStringer;
import org.json.JSONTokener;

public class cyg {
    public static String m13365a(Object obj) {
        if (obj == null) {
            return "null";
        }
        if (obj instanceof String) {
            return JSONObject.quote((String) obj);
        }
        if (obj instanceof Number) {
            try {
                return JSONObject.numberToString((Number) obj);
            } catch (Throwable e) {
                throw new IOException("Could not serialize number", e);
            }
        } else if (obj instanceof Boolean) {
            return ((Boolean) obj).booleanValue() ? "true" : "false";
        } else {
            try {
                JSONStringer jSONStringer = new JSONStringer();
                m13370a(obj, jSONStringer);
                return jSONStringer.toString();
            } catch (Throwable e2) {
                throw new IOException("Failed to serialize JSON", e2);
            }
        }
    }

    public static String m13366a(Map<String, Object> map) {
        return m13365a((Object) map);
    }

    private static List<Object> m13367a(JSONArray jSONArray) {
        List<Object> arrayList = new ArrayList(jSONArray.length());
        for (int i = 0; i < jSONArray.length(); i++) {
            arrayList.add(m13371b(jSONArray.get(i)));
        }
        return arrayList;
    }

    public static Map<String, Object> m13368a(String str) {
        try {
            return m13369a(new JSONObject(str));
        } catch (Throwable e) {
            throw new IOException(e);
        }
    }

    private static Map<String, Object> m13369a(JSONObject jSONObject) {
        Map<String, Object> hashMap = new HashMap(jSONObject.length());
        Iterator keys = jSONObject.keys();
        while (keys.hasNext()) {
            String str = (String) keys.next();
            hashMap.put(str, m13371b(jSONObject.get(str)));
        }
        return hashMap;
    }

    private static void m13370a(Object obj, JSONStringer jSONStringer) {
        if (obj instanceof Map) {
            jSONStringer.object();
            for (Entry entry : ((Map) obj).entrySet()) {
                jSONStringer.key((String) entry.getKey());
                m13370a(entry.getValue(), jSONStringer);
            }
            jSONStringer.endObject();
        } else if (obj instanceof Collection) {
            Collection<Object> collection = (Collection) obj;
            jSONStringer.array();
            for (Object a : collection) {
                m13370a(a, jSONStringer);
            }
            jSONStringer.endArray();
        } else {
            jSONStringer.value(obj);
        }
    }

    private static Object m13371b(Object obj) {
        return obj instanceof JSONObject ? m13369a((JSONObject) obj) : obj instanceof JSONArray ? m13367a((JSONArray) obj) : obj.equals(JSONObject.NULL) ? null : obj;
    }

    public static Object m13372b(String str) {
        try {
            return m13371b(new JSONTokener(str).nextValue());
        } catch (Throwable e) {
            throw new IOException(e);
        }
    }
}
