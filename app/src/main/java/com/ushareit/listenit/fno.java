package com.ushareit.listenit;

import java.util.LinkedHashMap;
import java.util.Map;

public class fno {
    public static final String KEY_DEVICE_ID = "id";
    public static final String KEY_DEVICE_TYPE = "ty";
    public static final String KEY_OS_VERSION = "ve";
    public static final String KEY_VERSION = "v";
    public static final int VERSION = 1;
    private String id;
    private String ty;
    private int f13041v = 1;
    private String ve;

    public fno(int i, String str, String str2, String str3) {
        this.f13041v = i;
        this.id = str;
        this.ty = str3;
        this.ve = str2;
    }

    public Map<String, Object> toMap() {
        Map<String, Object> linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(KEY_VERSION, Integer.valueOf(this.f13041v));
        linkedHashMap.put("id", this.id);
        linkedHashMap.put(KEY_DEVICE_TYPE, this.ty);
        linkedHashMap.put(KEY_OS_VERSION, this.ve);
        return linkedHashMap;
    }

    public int getV() {
        return this.f13041v;
    }

    public void setV(int i) {
        this.f13041v = i;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String str) {
        this.id = str;
    }

    public String getTy() {
        return this.ty;
    }

    public void setTy(String str) {
        this.ty = str;
    }

    public String getVe() {
        return this.ve;
    }

    public void setVe(String str) {
        this.ve = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(KEY_VERSION).append(this.f13041v).append(", ");
        stringBuilder.append("id").append(this.id).append(", ");
        stringBuilder.append(KEY_DEVICE_TYPE).append(this.ty).append(", ");
        stringBuilder.append(KEY_OS_VERSION).append(this.ve);
        return stringBuilder.toString();
    }
}
