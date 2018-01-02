package com.ushareit.listenit;

import java.util.LinkedHashMap;
import java.util.Map;

public class fnn {
    public static final String KEY_ALBUM = "al";
    public static final String KEY_ARTIST = "ar";
    public static final String KEY_BACKUP = "bk";
    public static final String KEY_BITRATE = "br";
    public static final String KEY_DURATION = "du";
    public static final String KEY_FAVORITE = "fv";
    public static final String KEY_GENRE = "ge";
    public static final String KEY_MD5 = "id";
    public static final String KEY_MIMETYPE = "mt";
    public static final String KEY_NAME = "na";
    public static final String KEY_SIZE = "sz";
    public static final String KEY_STATE = "sta";
    public static final String KEY_SYNCTIME = "st";
    private String al;
    private String ar;
    private long bk;
    private int br;
    private int du;
    private long fv;
    private String ge;
    private String id;
    private String mt;
    private String na;
    private long st;
    private int sta;
    private int sz;

    public fnn(String str, String str2, String str3, String str4, String str5, int i, int i2, int i3, String str6, int i4, long j, long j2, long j3) {
        this.id = str;
        this.na = str2;
        this.ar = str3;
        this.al = str4;
        this.ge = str5;
        this.br = i;
        this.du = i2;
        this.sz = i3;
        this.mt = str6;
        this.sta = i4;
        this.st = j;
        this.fv = j2;
        this.bk = j3;
    }

    public fnn(glg com_ushareit_listenit_glg) {
        this.id = com_ushareit_listenit_glg.m22362h();
        this.na = com_ushareit_listenit_glg.f14338f;
        this.ar = com_ushareit_listenit_glg.f14339g;
        this.al = com_ushareit_listenit_glg.f14340h;
        this.ge = com_ushareit_listenit_glg.f14345m;
        this.br = com_ushareit_listenit_glg.f14346n;
        this.du = com_ushareit_listenit_glg.f14337e;
        this.sz = com_ushareit_listenit_glg.f14344l;
        this.mt = com_ushareit_listenit_glg.f14347o;
        this.sta = com_ushareit_listenit_glg.f14336d;
        this.st = com_ushareit_listenit_glg.f14349q;
        this.fv = com_ushareit_listenit_glg.f14351s;
        this.bk = com_ushareit_listenit_glg.f14352t;
    }

    public fnn(ecb com_ushareit_listenit_ecb) {
        this.id = com_ushareit_listenit_ecb.m16706d();
        this.na = (String) com_ushareit_listenit_ecb.m16699a("na").m16701a(String.class);
        this.ar = (String) com_ushareit_listenit_ecb.m16699a(KEY_ARTIST).m16701a(String.class);
        this.al = (String) com_ushareit_listenit_ecb.m16699a(KEY_ALBUM).m16701a(String.class);
        this.ge = (String) com_ushareit_listenit_ecb.m16699a(KEY_GENRE).m16701a(String.class);
        this.br = ((Integer) com_ushareit_listenit_ecb.m16699a(KEY_BITRATE).m16701a(Integer.class)).intValue();
        this.du = ((Integer) com_ushareit_listenit_ecb.m16699a("du").m16701a(Integer.class)).intValue();
        this.sz = ((Integer) com_ushareit_listenit_ecb.m16699a(KEY_SIZE).m16701a(Integer.class)).intValue();
        this.mt = (String) com_ushareit_listenit_ecb.m16699a(KEY_MIMETYPE).m16701a(String.class);
        this.sta = ((Integer) com_ushareit_listenit_ecb.m16699a("sta").m16701a(Integer.class)).intValue();
        this.st = ((Long) com_ushareit_listenit_ecb.m16699a("st").m16701a(Long.class)).longValue();
        this.fv = ((Long) com_ushareit_listenit_ecb.m16699a(KEY_FAVORITE).m16701a(Long.class)).longValue();
        this.bk = ((Long) com_ushareit_listenit_ecb.m16699a(KEY_BACKUP).m16701a(Long.class)).longValue();
    }

    public fnn(frh com_ushareit_listenit_frh) {
        this.id = com_ushareit_listenit_frh.f13268a;
        this.na = com_ushareit_listenit_frh.f13270c;
        this.ar = com_ushareit_listenit_frh.f13271d;
        this.al = com_ushareit_listenit_frh.f13272e;
        this.ge = com_ushareit_listenit_frh.f13273f;
        this.br = com_ushareit_listenit_frh.f13275h;
        this.du = com_ushareit_listenit_frh.f13276i;
        this.sz = com_ushareit_listenit_frh.f13277j;
        this.mt = com_ushareit_listenit_frh.f13274g;
        this.sta = 0;
        this.st = 0;
        this.fv = 0;
        this.bk = System.currentTimeMillis();
    }

    public fnn(fri com_ushareit_listenit_fri) {
        this.id = com_ushareit_listenit_fri.f13280a;
        this.na = com_ushareit_listenit_fri.f13281b;
        this.ar = com_ushareit_listenit_fri.f13282c;
        this.al = com_ushareit_listenit_fri.f13283d;
        this.ge = com_ushareit_listenit_fri.f13284e;
        this.br = com_ushareit_listenit_fri.f13285f;
        this.du = com_ushareit_listenit_fri.f13286g;
        this.sz = com_ushareit_listenit_fri.f13287h;
        this.mt = com_ushareit_listenit_fri.f13288i;
        this.sta = 0;
        this.st = 0;
        this.fv = 0;
        this.bk = System.currentTimeMillis();
    }

    public void update(glg com_ushareit_listenit_glg) {
        this.id = com_ushareit_listenit_glg.m22362h();
        this.na = com_ushareit_listenit_glg.f14338f;
        this.ar = com_ushareit_listenit_glg.f14339g;
        this.al = com_ushareit_listenit_glg.f14340h;
        this.ge = com_ushareit_listenit_glg.f14345m;
        this.br = com_ushareit_listenit_glg.f14346n;
        this.du = com_ushareit_listenit_glg.f14337e;
        this.sz = com_ushareit_listenit_glg.f14344l;
        this.mt = com_ushareit_listenit_glg.f14347o;
        this.sta = com_ushareit_listenit_glg.f14336d;
        this.st = com_ushareit_listenit_glg.f14349q;
        this.fv = com_ushareit_listenit_glg.f14351s;
        this.bk = com_ushareit_listenit_glg.f14352t;
    }

    public Map<String, Object> toMap() {
        Map<String, Object> linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("na", this.na);
        linkedHashMap.put(KEY_ARTIST, this.ar);
        linkedHashMap.put(KEY_ALBUM, this.al);
        linkedHashMap.put(KEY_GENRE, this.ge);
        linkedHashMap.put(KEY_BITRATE, Integer.valueOf(this.br));
        linkedHashMap.put("du", Integer.valueOf(this.du));
        linkedHashMap.put(KEY_SIZE, Integer.valueOf(this.sz));
        linkedHashMap.put(KEY_MIMETYPE, this.mt);
        linkedHashMap.put("sta", Integer.valueOf(this.sta));
        linkedHashMap.put("st", Long.valueOf(this.st));
        linkedHashMap.put(KEY_FAVORITE, Long.valueOf(this.fv));
        linkedHashMap.put(KEY_BACKUP, Long.valueOf(this.bk));
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

    public String getAr() {
        return this.ar;
    }

    public void setAr(String str) {
        this.ar = str;
    }

    public String getAl() {
        return this.al;
    }

    public void setAl(String str) {
        this.al = str;
    }

    public String getGe() {
        return this.ge;
    }

    public void setGe(String str) {
        this.ge = str;
    }

    public int getBr() {
        return this.br;
    }

    public void setBr(int i) {
        this.br = i;
    }

    public int getDu() {
        return this.du;
    }

    public void setDu(int i) {
        this.du = i;
    }

    public int getSz() {
        return this.sz;
    }

    public void setSz(int i) {
        this.sz = i;
    }

    public String getMt() {
        return this.mt;
    }

    public void setMt(String str) {
        this.mt = str;
    }

    public int getSta() {
        return this.sta;
    }

    public void setSta(int i) {
        this.sta = i;
    }

    public long getSt() {
        return this.st;
    }

    public void setSt(long j) {
        this.st = j;
    }

    public long getFv() {
        return this.fv;
    }

    public void setFv(long j) {
        this.fv = j;
    }

    public long getBk() {
        return this.bk;
    }

    public void setBk(long j) {
        this.bk = j;
    }
}
