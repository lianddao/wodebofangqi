package com.ushareit.listenit;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class fnq implements Serializable {
    public static final String KEY_USER_AVATOR = "av";
    public static final String KEY_USER_NAME = "na";
    private long av;
    private long na;

    public fnq(long j, long j2) {
        this.na = j;
        this.av = j2;
    }

    public Map<String, Object> toMap() {
        Map<String, Object> hashMap = new HashMap();
        hashMap.put("na", Long.valueOf(this.na));
        hashMap.put("av", Long.valueOf(this.av));
        return hashMap;
    }

    public long getNa() {
        return this.na;
    }

    public void setNa(long j) {
        this.na = j;
    }

    public long getAv() {
        return this.av;
    }

    public void setAv(long j) {
        this.av = j;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("na").append(this.na).append(", ");
        stringBuilder.append("av").append(this.av);
        return stringBuilder.toString();
    }
}
