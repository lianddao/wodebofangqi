package com.ushareit.listenit;

import android.database.Cursor;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class fni implements Serializable {
    public static final String KEY_ADDRESS = "ad";
    public static final String KEY_LATITUDE = "la";
    public static final String KEY_LONGITUDE = "lg";
    public static final String KEY_NAME = "nm";
    public static final String KEY_PLAYLIST_NUMBER = "plN";
    public static final String KEY_SONG_NUMBER = "sgN";
    public static final String KEY_UID = "id";
    String ad = "";
    String id;
    long lg;
    long lt;
    String nm;
    int plN;
    int sgN;

    public fni(String str, String str2, int i, int i2, long j, long j2, String str3) {
        this.id = str;
        this.nm = str2;
        this.plN = i;
        this.sgN = i2;
        this.lg = j;
        this.lt = j2;
        this.ad = str3;
    }

    public fni(ecb com_ushareit_listenit_ecb) {
        loadData(com_ushareit_listenit_ecb);
    }

    public fni(Cursor cursor) {
        this.id = cursor.getString(cursor.getColumnIndex("user_id"));
        this.nm = cursor.getString(cursor.getColumnIndex("user_name"));
        this.plN = cursor.getInt(cursor.getColumnIndex("playlist_count"));
        this.sgN = cursor.getInt(cursor.getColumnIndex(fnl.SONG_NUMBER));
        this.lg = cursor.getLong(cursor.getColumnIndex("longitude"));
        this.lt = cursor.getLong(cursor.getColumnIndex("latitude"));
        this.ad = cursor.getString(cursor.getColumnIndex("address"));
    }

    public void loadData(ecb com_ushareit_listenit_ecb) {
        this.id = com_ushareit_listenit_ecb.m16706d();
        this.nm = (String) com_ushareit_listenit_ecb.m16699a(KEY_NAME).m16701a(String.class);
        this.plN = ((Integer) com_ushareit_listenit_ecb.m16699a(KEY_PLAYLIST_NUMBER).m16701a(Integer.class)).intValue();
        this.sgN = ((Integer) com_ushareit_listenit_ecb.m16699a("sgN").m16701a(Integer.class)).intValue();
        this.lg = ((Long) com_ushareit_listenit_ecb.m16699a(KEY_LONGITUDE).m16701a(Long.class)).longValue();
        this.lt = ((Long) com_ushareit_listenit_ecb.m16699a(KEY_LATITUDE).m16701a(Long.class)).longValue();
        if (com_ushareit_listenit_ecb.m16704b(KEY_ADDRESS)) {
            this.ad = (String) com_ushareit_listenit_ecb.m16699a(KEY_ADDRESS).m16701a(String.class);
            this.ad = this.ad == null ? "" : this.ad;
        }
    }

    public Map<String, Object> toMap() {
        Map<String, Object> hashMap = new HashMap();
        hashMap.put(KEY_NAME, this.nm);
        hashMap.put(KEY_PLAYLIST_NUMBER, Integer.valueOf(this.plN));
        hashMap.put("sgN", Integer.valueOf(this.sgN));
        hashMap.put(KEY_LONGITUDE, Long.valueOf(this.lg));
        hashMap.put(KEY_LATITUDE, Long.valueOf(this.lt));
        hashMap.put(KEY_ADDRESS, this.ad);
        return hashMap;
    }

    public String toString() {
        return "name=" + this.nm + ", longitude=" + this.lg + ", latitude=" + this.lt + ", playlistNumber=" + this.plN + ", songNumber=" + this.sgN;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String str) {
        this.id = str;
    }

    public String getNm() {
        return this.nm;
    }

    public void setNm(String str) {
        this.nm = str;
    }

    public int getPlN() {
        return this.plN;
    }

    public void setPlN(int i) {
        this.plN = i;
    }

    public int getSgN() {
        return this.sgN;
    }

    public void setSgN(int i) {
        this.sgN = i;
    }

    public long getLg() {
        return this.lg;
    }

    public void setLg(long j) {
        this.lg = j;
    }

    public long getLt() {
        return this.lt;
    }

    public void setLt(long j) {
        this.lt = j;
    }

    public String getAd() {
        return this.ad;
    }

    public void setAd(String str) {
        this.ad = str;
    }
}
