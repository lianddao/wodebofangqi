package com.ushareit.listenit;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

public class fnj implements Serializable {
    public static final String KEY_ID = "id";
    public static final String KEY_SYNC_TIME = "st";
    private String id;
    private long st;

    public fnj(String str, long j) {
        this.id = str;
        this.st = j;
    }

    public fnj(glc com_ushareit_listenit_glc) {
        this.id = com_ushareit_listenit_glc.f14283c;
        this.st = com_ushareit_listenit_glc.f14286f;
    }

    public Map<String, Object> toMap() {
        Map<String, Object> linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("id", this.id);
        linkedHashMap.put("st", Long.valueOf(this.st));
        return linkedHashMap;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String str) {
        this.id = str;
    }

    public long getSt() {
        return this.st;
    }

    public void setSt(long j) {
        this.st = j;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("id").append(this.id).append("\n");
        stringBuilder.append("st").append(this.st);
        return stringBuilder.toString();
    }
}
