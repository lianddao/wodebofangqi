package com.ushareit.listenit;

import android.util.Pair;
import java.util.List;

public final class eto {
    private String f11792a;
    private long f11793b;
    private etp f11794c;
    private long f11795d;
    private String f11796e;
    private String f11797f;
    private long f11798g;
    private List<Pair<String, String>> f11799h;

    public eto(etp com_ushareit_listenit_etp, String str, String str2, long j, List<Pair<String, String>> list) {
        this(com_ushareit_listenit_etp, System.currentTimeMillis(), str, str2, j, list);
    }

    public eto(etp com_ushareit_listenit_etp, long j, String str, String str2, long j2, List<Pair<String, String>> list) {
        this(null, etr.m17939a(), com_ushareit_listenit_etp, j, str, str2, j2, list);
    }

    public eto(String str, long j, etp com_ushareit_listenit_etp, long j2, String str2, String str3, long j3, List<Pair<String, String>> list) {
        this.f11792a = str;
        this.f11793b = j;
        this.f11794c = com_ushareit_listenit_etp;
        this.f11795d = j2;
        this.f11796e = str2;
        this.f11797f = str3;
        this.f11798g = j3;
        this.f11799h = list;
    }

    public void m17908a(String str) {
        this.f11792a = str;
    }

    public String m17907a() {
        return this.f11792a;
    }

    public long m17909b() {
        return this.f11793b;
    }

    public etp m17910c() {
        return this.f11794c;
    }

    public long m17911d() {
        return this.f11795d;
    }

    public String m17912e() {
        return this.f11796e;
    }

    public String m17913f() {
        return this.f11797f;
    }

    public long m17914g() {
        return this.f11798g;
    }

    public List<Pair<String, String>> m17915h() {
        return this.f11799h;
    }

    public String m17916i() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.f11795d).append("\u0001").append(this.f11794c.m17918a()).append("\u0001").append(this.f11796e != null ? this.f11796e : "").append("\u0001").append(this.f11797f != null ? this.f11797f : "").append("\u0001").append(this.f11798g).append("\u0001");
        int i = 0;
        if (this.f11799h != null) {
            int min = Math.min(7, this.f11799h.size());
            int i2 = 0;
            while (i2 < min) {
                Pair pair = (Pair) this.f11799h.get(i2);
                String str = (String) pair.first;
                String str2 = (String) pair.second;
                if (str == null || str2 == null) {
                    stringBuilder.append("\u0001").append("\u0001");
                } else {
                    stringBuilder.append(str).append("\u0001").append(str2).append("\u0001");
                }
                i2++;
            }
            i = i2;
        }
        while (i < 7) {
            stringBuilder.append("\u0001").append("\u0001");
            i++;
        }
        stringBuilder.append("\u0001").append(this.f11793b > 0 ? Long.valueOf(this.f11793b) : "");
        return stringBuilder.toString();
    }

    public String toString() {
        return "EventEntity [mCommitId=" + this.f11792a + ", mType=" + this.f11794c + ", mTime=" + this.f11795d + ", mName=" + this.f11796e + ", mLabel=" + this.f11797f + ", mValue=" + this.f11798g + "]";
    }

    public static String m17906a(List<eto> list) {
        StringBuilder stringBuilder = new StringBuilder();
        for (eto i : list) {
            stringBuilder.append(i.m17916i() + "\u0001\n");
        }
        return stringBuilder.toString();
    }
}
