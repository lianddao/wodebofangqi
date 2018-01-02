package com.ushareit.listenit;

import java.util.LinkedHashMap;
import java.util.Map;

public class fnp {
    public static final String KEY_USER_AVATOR = "av";
    public static final String KEY_USER_ID = "id";
    public static final String KEY_USER_NAME = "na";
    private String av;
    private String id;
    private String na;

    public fnp(String str, String str2, String str3) {
        this.id = str;
        this.na = str2;
        this.av = str3;
    }

    public Map<String, Object> toMap() {
        Map<String, Object> linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("id", this.id);
        linkedHashMap.put("na", this.na);
        linkedHashMap.put("av", this.av);
        return linkedHashMap;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String str) {
        this.id = str;
    }

    public String getNa() {
        return this.na;
    }

    public void setNa(String str) {
        this.na = str;
    }

    public String getAv() {
        return this.av;
    }

    public void setAv(String str) {
        this.av = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("id").append(this.id).append("\n");
        stringBuilder.append("na").append(this.na).append("\n");
        stringBuilder.append("av").append(this.na).append("\n");
        return stringBuilder.toString();
    }
}
