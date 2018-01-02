package com.ushareit.listenit;

import android.content.ContentValues;
import com.google.android.gms.common.data.DataHolder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

public class cev {
    private final String[] f8201a;
    private final ArrayList<HashMap<String, Object>> f8202b;
    private final String f8203c;
    private final HashMap<Object, Integer> f8204d;
    private boolean f8205e;
    private String f8206f;

    private cev(String[] strArr, String str) {
        this.f8201a = (String[]) cfi.m11080a((Object) strArr);
        this.f8202b = new ArrayList();
        this.f8203c = str;
        this.f8204d = new HashMap();
        this.f8205e = false;
        this.f8206f = null;
    }

    private int m10999b(HashMap<String, Object> hashMap) {
        if (this.f8203c == null) {
            return -1;
        }
        Object obj = hashMap.get(this.f8203c);
        if (obj == null) {
            return -1;
        }
        Integer num = (Integer) this.f8204d.get(obj);
        if (num != null) {
            return num.intValue();
        }
        this.f8204d.put(obj, Integer.valueOf(this.f8202b.size()));
        return -1;
    }

    public DataHolder m11001a(int i) {
        return new DataHolder(this, i, null);
    }

    public cev mo1299a(ContentValues contentValues) {
        cfq.m11115a(contentValues);
        HashMap hashMap = new HashMap(contentValues.size());
        for (Entry entry : contentValues.valueSet()) {
            hashMap.put((String) entry.getKey(), entry.getValue());
        }
        return mo1300a(hashMap);
    }

    public cev mo1300a(HashMap<String, Object> hashMap) {
        cfq.m11115a(hashMap);
        int b = m10999b((HashMap) hashMap);
        if (b == -1) {
            this.f8202b.add(hashMap);
        } else {
            this.f8202b.remove(b);
            this.f8202b.add(b, hashMap);
        }
        this.f8205e = false;
        return this;
    }
}
