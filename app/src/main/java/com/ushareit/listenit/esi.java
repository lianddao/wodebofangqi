package com.ushareit.listenit;

public class esi extends eyr {
    protected Object f11701a;
    private String f11702b;
    private String f11703c;
    private int f11704d;
    private long f11705e;
    private long f11706f;
    private String f11707g;

    private esi(String str, String str2, long j) {
        this.f11704d = 0;
        this.f11702b = str;
        this.f11703c = str2;
        this.f11705e = -1;
        this.f11706f = j;
    }

    public esi(String str, String str2, long j, Object obj, String str3) {
        this(str, str2, j, obj, obj.hashCode(), str3);
    }

    private esi(String str, String str2, long j, Object obj, int i, String str3) {
        this(str, str2, j);
        m17766a(obj, i);
        this.f11707g = str3;
    }

    public String m17765a() {
        return this.f11702b;
    }

    public String m17768b() {
        return this.f11703c;
    }

    public void m17766a(Object obj, int i) {
        this.f11701a = obj;
        this.f11704d = i;
        this.f11705e = System.currentTimeMillis();
    }

    public Object m17769c() {
        return this.f11701a;
    }

    public int m17770d() {
        return this.f11704d;
    }

    public boolean m17767a(long j) {
        return this.f11705e != -1 && System.currentTimeMillis() > (this.f11705e + this.f11706f) + j;
    }

    public String m17771e() {
        return this.f11707g;
    }
}
