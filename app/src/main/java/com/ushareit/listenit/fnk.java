package com.ushareit.listenit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class fnk {
    public static final String KEY_ID = "id";
    public static final String KEY_NAME = "na";
    public static final String KEY_SONGS = "sgs";
    public static final String KEY_STATE = "sta";
    public static final String KEY_SYNC_TIME = "st";
    public static final String KEY_VISIBILITY = "vi";
    private String id;
    private String na;
    private List<String> sgs;
    private long st;
    private int sta;
    private int vi = 0;

    public fnk(String str, String str2, int i, long j, List<String> list) {
        this.id = str;
        this.na = str2;
        this.sta = i;
        this.st = j;
        this.sgs = list;
    }

    public fnk(glc com_ushareit_listenit_glc) {
        this.id = com_ushareit_listenit_glc.f14283c;
        this.na = com_ushareit_listenit_glc.f14285e;
        this.sta = com_ushareit_listenit_glc.f14288h;
        this.st = com_ushareit_listenit_glc.f14286f;
        List<glg> i = fqs.m20475i(com_ushareit_listenit_glc.f14283c);
        this.sgs = new ArrayList(i.size());
        for (glg com_ushareit_listenit_glg : i) {
            if (!gyn.m23260p(com_ushareit_listenit_glg.f14342j)) {
                this.sgs.add(com_ushareit_listenit_glg.m22362h());
            }
        }
        this.vi = com_ushareit_listenit_glc.f14290j;
    }

    public fnk(ecb com_ushareit_listenit_ecb) {
        this.id = com_ushareit_listenit_ecb.m16706d();
        this.na = (String) com_ushareit_listenit_ecb.m16699a("na").m16701a(String.class);
        this.sta = ((Integer) com_ushareit_listenit_ecb.m16699a("sta").m16701a(Integer.class)).intValue();
        this.st = ((Long) com_ushareit_listenit_ecb.m16699a("st").m16701a(Long.class)).longValue();
        this.sgs = getSongsFromDataSnapshot(com_ushareit_listenit_ecb.m16699a(KEY_SONGS));
        if (com_ushareit_listenit_ecb.m16704b(KEY_VISIBILITY)) {
            this.vi = ((Integer) com_ushareit_listenit_ecb.m16699a(KEY_VISIBILITY).m16701a(Integer.class)).intValue();
        }
    }

    public Map<String, Object> toMap() {
        Map<String, Object> linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("na", this.na);
        linkedHashMap.put(KEY_SONGS, getOrderSongMap());
        linkedHashMap.put("sta", Integer.valueOf(this.sta));
        linkedHashMap.put("st", Long.valueOf(this.st));
        linkedHashMap.put(KEY_VISIBILITY, Integer.valueOf(this.vi));
        return linkedHashMap;
    }

    private List<String> getSongsFromDataSnapshot(ecb com_ushareit_listenit_ecb) {
        List<String> arrayList = new ArrayList();
        if (com_ushareit_listenit_ecb == null || com_ushareit_listenit_ecb.m16703b() == 0) {
            return arrayList;
        }
        for (ecb a : com_ushareit_listenit_ecb.m16707e()) {
            String str = (String) a.m16701a(String.class);
            if (str != null) {
                arrayList.add(str);
            }
        }
        return arrayList;
    }

    private HashMap<String, String> getOrderSongMap() {
        HashMap<String, String> hashMap = new HashMap(this.sgs.size());
        int length = String.valueOf(this.sgs.size()).length();
        int i = 0;
        for (String str : this.sgs) {
            String str2 = "%0" + length + "d";
            Object[] objArr = new Object[1];
            int i2 = i + 1;
            objArr[0] = Integer.valueOf(i);
            hashMap.put(String.format(str2, objArr), str);
            i = i2;
        }
        return hashMap;
    }

    public long getSt() {
        return this.st;
    }

    public void setSt(long j) {
        this.st = j;
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

    public List<String> getSgs() {
        return this.sgs;
    }

    public void setSgs(List<String> list) {
        this.sgs = list;
    }

    public int getSta() {
        return this.sta;
    }

    public void setSta(int i) {
        this.sta = i;
    }

    public int getVi() {
        return this.vi;
    }

    public void setVi(int i) {
        this.vi = i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("id").append(this.id).append("\n");
        stringBuilder.append("na").append(this.na).append("\n");
        stringBuilder.append(KEY_SONGS).append(this.sgs).append("\n");
        stringBuilder.append("sta").append(this.sta).append("\n");
        stringBuilder.append("st").append(this.st).append("\n");
        stringBuilder.append(KEY_VISIBILITY).append(this.vi);
        return stringBuilder.toString();
    }
}
