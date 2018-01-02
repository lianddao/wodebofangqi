package com.ushareit.listenit;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

@Deprecated
public abstract class bet {
    protected void m7946a() {
    }

    public void m7947a(Map<String, String> map) {
        Map hashMap = new HashMap();
        for (Field field : getClass().getFields()) {
            bev com_ushareit_listenit_bev = (bev) field.getAnnotation(bev.class);
            if (com_ushareit_listenit_bev != null) {
                hashMap.put(com_ushareit_listenit_bev.m7948a(), field);
            }
        }
        if (hashMap.isEmpty()) {
            bze.m10490c("No server options fields detected. To suppress this message either add a field with the @Parameter annotation, or override the load() method.");
        }
        for (Entry entry : map.entrySet()) {
            String str;
            Field field2 = (Field) hashMap.remove(entry.getKey());
            if (field2 != null) {
                try {
                    field2.set(this, entry.getValue());
                } catch (IllegalAccessException e) {
                    str = (String) entry.getKey();
                    bze.m10490c(new StringBuilder(String.valueOf(str).length() + 49).append("Server option \"").append(str).append("\" could not be set: Illegal Access").toString());
                } catch (IllegalArgumentException e2) {
                    str = (String) entry.getKey();
                    bze.m10490c(new StringBuilder(String.valueOf(str).length() + 43).append("Server option \"").append(str).append("\" could not be set: Bad Type").toString());
                }
            } else {
                str = (String) entry.getKey();
                String str2 = (String) entry.getValue();
                bze.m10485a(new StringBuilder((String.valueOf(str).length() + 31) + String.valueOf(str2).length()).append("Unexpected server option: ").append(str).append(" = \"").append(str2).append("\"").toString());
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (Field field22 : hashMap.values()) {
            if (((bev) field22.getAnnotation(bev.class)).m7949b()) {
                String str3 = "Required server option missing: ";
                str2 = String.valueOf(((bev) field22.getAnnotation(bev.class)).m7948a());
                bze.m10490c(str2.length() != 0 ? str3.concat(str2) : new String(str3));
                if (stringBuilder.length() > 0) {
                    stringBuilder.append(", ");
                }
                stringBuilder.append(((bev) field22.getAnnotation(bev.class)).m7948a());
            }
        }
        if (stringBuilder.length() > 0) {
            String str4 = "Required server option(s) missing: ";
            str = String.valueOf(stringBuilder.toString());
            throw new beu(str.length() != 0 ? str4.concat(str) : new String(str4));
        }
        m7946a();
    }
}
