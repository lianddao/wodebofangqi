package com.ushareit.listenit;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

public class fnm implements Serializable {
    public static final String KEY_SONG_MD5 = "id";
    public static final String KEY_SYNC_TIME = "st";
    private String id;
    private long st;

    public fnm(String str, long j) {
        this.id = str;
        this.st = j;
    }

    public fnm(glg com_ushareit_listenit_glg) {
        this.id = com_ushareit_listenit_glg.m22362h();
        this.st = com_ushareit_listenit_glg.f14349q;
    }

    public fnm(ecb com_ushareit_listenit_ecb) {
        this.id = com_ushareit_listenit_ecb.m16706d();
        this.st = ((Long) com_ushareit_listenit_ecb.m16699a("st").m16701a(Long.class)).longValue();
    }

    public void update(glg com_ushareit_listenit_glg) {
        this.id = com_ushareit_listenit_glg.m22362h();
        this.st = com_ushareit_listenit_glg.f14349q;
    }

    public Map<String, Object> toMap() {
        Map<String, Object> linkedHashMap = new LinkedHashMap();
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
