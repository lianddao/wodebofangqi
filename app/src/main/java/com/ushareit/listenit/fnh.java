package com.ushareit.listenit;

import java.util.HashMap;
import java.util.Map;

public class fnh {
    public static final String KEY_LIBRARY_SONGS = "ls";
    public static final String KEY_PLAYLIST = "pl";
    public static final String KEY_USERINFO = "ui";
    private long ls;
    private long pl;
    private long ui;

    public fnh(long j, long j2, long j3) {
        this.ui = j;
        this.pl = j2;
        this.ls = j3;
    }

    public Map<String, Object> toMap() {
        Map<String, Object> hashMap = new HashMap();
        hashMap.put(KEY_USERINFO, Long.valueOf(this.ui));
        hashMap.put(KEY_PLAYLIST, Long.valueOf(this.pl));
        hashMap.put(KEY_LIBRARY_SONGS, Long.valueOf(this.ls));
        return hashMap;
    }

    public long getUi() {
        return this.ui;
    }

    public void setUi(long j) {
        this.ui = j;
    }

    public long getPl() {
        return this.pl;
    }

    public void setPl(long j) {
        this.pl = j;
    }

    public long getLs() {
        return this.ls;
    }

    public void setLs(long j) {
        this.ls = j;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(KEY_USERINFO).append(this.ui).append(", ");
        stringBuilder.append(KEY_PLAYLIST).append(this.pl).append(", ");
        stringBuilder.append(KEY_LIBRARY_SONGS).append(this.ls);
        return stringBuilder.toString();
    }
}
