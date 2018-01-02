package com.ushareit.listenit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ggm {
    private String f14080a;
    private String f14081b;
    private String f14082c;
    private String f14083d;
    private String f14084e;
    private String f14085f;
    private long f14086g;
    private long f14087h;
    private int f14088i;
    private boolean f14089j = true;
    private String f14090k;
    private List<ggo> f14091l = new ArrayList();

    public String m21944a() {
        return this.f14090k;
    }

    public void m21946a(String str) {
        this.f14090k = str;
    }

    public void m21950b() {
        this.f14091l.clear();
    }

    public void m21947a(String str, long j) {
        this.f14091l.add(new ggo(this, str, j));
    }

    public void m21954c() {
        Collections.sort(this.f14091l, new ggn(this));
    }

    public int m21943a(int i) {
        int i2 = 0;
        if (i < m21949b(0)) {
            return -1;
        }
        if (i > m21949b(this.f14091l.size() - 1)) {
            return this.f14091l.size() - 1;
        }
        int size = this.f14091l.size() - 1;
        while (size - i2 > 1) {
            int i3 = (size + i2) / 2;
            long b = (long) m21949b(i3);
            if (b == ((long) i)) {
                return i3;
            }
            if (b < ((long) i)) {
                i2 = i3;
            } else if (b > ((long) i)) {
                size = i3;
            }
        }
        return i2;
    }

    public int m21956d() {
        return this.f14091l.size();
    }

    public int m21949b(int i) {
        return (int) (((ggo) this.f14091l.get(i)).m21975a().longValue() + ((long) this.f14088i));
    }

    public String m21953c(int i) {
        return ((ggo) this.f14091l.get(i)).m21977b();
    }

    public String m21957d(int i) {
        return gyn.m23182a(((ggo) this.f14091l.get(i)).m21975a().longValue());
    }

    public ggo m21959e(int i) {
        return (ggo) this.f14091l.get(i);
    }

    public void m21948a(boolean z) {
        this.f14089j = z;
    }

    public boolean m21961e() {
        return this.f14089j;
    }

    public String m21962f() {
        return this.f14080a;
    }

    public void m21952b(String str) {
        this.f14080a = str;
    }

    public String m21965g() {
        return this.f14081b;
    }

    public void m21955c(String str) {
        this.f14081b = str;
    }

    public String m21967h() {
        return this.f14082c;
    }

    public void m21958d(String str) {
        this.f14082c = str;
    }

    public String m21968i() {
        return this.f14083d;
    }

    public void m21960e(String str) {
        this.f14083d = str;
    }

    public String m21969j() {
        return this.f14084e;
    }

    public void m21964f(String str) {
        this.f14084e = str;
    }

    public String m21970k() {
        return this.f14085f;
    }

    public void m21966g(String str) {
        this.f14085f = str;
    }

    public long m21971l() {
        return this.f14086g;
    }

    public void m21945a(long j) {
        this.f14086g = j;
    }

    public long m21972m() {
        return this.f14087h;
    }

    public void m21951b(long j) {
        this.f14087h = j;
    }

    public int m21973n() {
        return this.f14088i;
    }

    public void m21963f(int i) {
        this.f14088i = i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Title: " + m21962f() + "\n").append("Artist: " + m21965g() + "\n").append("Album: " + m21967h() + "\n").append("By: " + m21968i() + "\n").append("Author: " + m21969j() + "\n").append("Sign: " + m21970k() + "\n").append("Total: " + m21971l() + "\n").append("Length: " + m21972m() + "\n").append("Offset: " + m21973n() + "\n");
        if (this.f14091l != null) {
            for (ggo com_ushareit_listenit_ggo : this.f14091l) {
                stringBuilder.append(com_ushareit_listenit_ggo.toString() + "\n");
            }
        }
        return stringBuilder.toString();
    }
}
