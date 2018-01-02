package com.ushareit.listenit;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;
import org.json.JSONTokener;

public class gky {
    private String f14266a;
    private int f14267b;
    private int f14268c;
    private int f14269d;
    private int f14270e;
    private int f14271f;
    private int f14272g;
    private int f14273h;
    private int f14274i;
    private int f14275j;
    private boolean f14276k;

    public gky() {
        m22265m();
    }

    public gky(int i, String str, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        this.f14267b = i;
        this.f14266a = str;
        this.f14268c = i2;
        this.f14269d = i3;
        this.f14270e = i4;
        this.f14271f = i5;
        this.f14272g = i6;
        this.f14273h = i7;
        this.f14274i = i8;
        this.f14275j = i9;
    }

    public gky(String str) {
        if (fbb.m18763c(str)) {
            m22265m();
            return;
        }
        try {
            JSONObject jSONObject = (JSONObject) new JSONTokener(str).nextValue();
            this.f14267b = jSONObject.getInt("key_eqId");
            this.f14266a = jSONObject.getString("key_eqName");
            this.f14268c = jSONObject.getInt("key_eq60hz");
            this.f14269d = jSONObject.getInt("key_eq230hz");
            this.f14270e = jSONObject.getInt("key_eq910hz");
            this.f14271f = jSONObject.getInt("key_eq3600hz");
            this.f14272g = jSONObject.getInt("key_eq1400hz");
            this.f14273h = jSONObject.getInt("key_bassboot");
            this.f14274i = jSONObject.getInt("key_virtualizer");
            this.f14275j = jSONObject.getInt("key_reverb");
        } catch (Throwable e) {
            exw.m18457e("EqualizerItem", "EqualizerItem construct error from jsonString: " + str + ", " + exw.m18438a(e));
        }
        exw.m18443a("EqualizerItem", "createfromjsonstring: jsonString=" + str + ", dstData=" + toString());
    }

    public void m22267a(gky com_ushareit_listenit_gky) {
        this.f14266a = com_ushareit_listenit_gky.m22273c();
        this.f14267b = com_ushareit_listenit_gky.m22271b();
        this.f14268c = com_ushareit_listenit_gky.m22275d();
        this.f14269d = com_ushareit_listenit_gky.m22277e();
        this.f14270e = com_ushareit_listenit_gky.m22279f();
        this.f14271f = com_ushareit_listenit_gky.m22281g();
        this.f14272g = com_ushareit_listenit_gky.m22283h();
        this.f14273h = com_ushareit_listenit_gky.m22285i();
        this.f14274i = com_ushareit_listenit_gky.m22287j();
        this.f14275j = com_ushareit_listenit_gky.m22288k();
        this.f14276k = com_ushareit_listenit_gky.m22270a();
    }

    private void m22265m() {
        this.f14266a = "";
        this.f14267b = -1;
        this.f14268c = 0;
        this.f14269d = 0;
        this.f14270e = 0;
        this.f14271f = 0;
        this.f14272g = 0;
        this.f14273h = 0;
        this.f14274i = 0;
        this.f14275j = 0;
    }

    public boolean m22270a() {
        return this.f14276k;
    }

    public void m22269a(boolean z) {
        this.f14276k = z;
    }

    public int m22271b() {
        return this.f14267b;
    }

    public void m22266a(int i) {
        this.f14267b = i;
    }

    public String m22273c() {
        return this.f14266a;
    }

    public void m22268a(String str) {
        this.f14266a = str;
    }

    public int m22275d() {
        return this.f14268c;
    }

    public void m22272b(int i) {
        if (this.f14268c != i) {
            this.f14268c = i;
        }
    }

    public int m22277e() {
        return this.f14269d;
    }

    public void m22274c(int i) {
        if (this.f14269d != i) {
            this.f14269d = i;
        }
    }

    public int m22279f() {
        return this.f14270e;
    }

    public void m22276d(int i) {
        if (this.f14270e != i) {
            this.f14270e = i;
        }
    }

    public int m22281g() {
        return this.f14271f;
    }

    public void m22278e(int i) {
        if (this.f14271f != i) {
            this.f14271f = i;
        }
    }

    public int m22283h() {
        return this.f14272g;
    }

    public void m22280f(int i) {
        if (this.f14272g != i) {
            this.f14272g = i;
        }
    }

    public int m22285i() {
        return this.f14273h;
    }

    public void m22282g(int i) {
        if (this.f14273h != i) {
            this.f14273h = i;
        }
    }

    public int m22287j() {
        return this.f14274i;
    }

    public void m22284h(int i) {
        if (this.f14274i != i) {
            this.f14274i = i;
        }
    }

    public int m22288k() {
        return this.f14275j;
    }

    public void m22286i(int i) {
        if (this.f14275j != i) {
            this.f14275j = i;
        }
    }

    public String m22289l() {
        JSONStringer jSONStringer = new JSONStringer();
        try {
            jSONStringer.object();
            jSONStringer.key("key_eqId");
            jSONStringer.value((long) this.f14267b);
            jSONStringer.key("key_eqName");
            jSONStringer.value(this.f14266a);
            jSONStringer.key("key_eq60hz");
            jSONStringer.value((long) this.f14268c);
            jSONStringer.key("key_eq230hz");
            jSONStringer.value((long) this.f14269d);
            jSONStringer.key("key_eq910hz");
            jSONStringer.value((long) this.f14270e);
            jSONStringer.key("key_eq3600hz");
            jSONStringer.value((long) this.f14271f);
            jSONStringer.key("key_eq1400hz");
            jSONStringer.value((long) this.f14272g);
            jSONStringer.key("key_bassboot");
            jSONStringer.value((long) this.f14273h);
            jSONStringer.key("key_virtualizer");
            jSONStringer.value((long) this.f14274i);
            jSONStringer.key("key_reverb");
            jSONStringer.value((long) this.f14275j);
            jSONStringer.endObject();
        } catch (JSONException e) {
            exw.m18457e("EqualizerItem", "toJsonString error : " + toString());
        }
        exw.m18443a("EqualizerItem", "toJsonString: " + jSONStringer.toString());
        return jSONStringer.toString();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("eqName=").append(this.f14266a);
        stringBuilder.append(", eqId=").append(this.f14267b);
        stringBuilder.append(", eq60Hz=").append(this.f14268c);
        stringBuilder.append(", eq230Hz=").append(this.f14269d);
        stringBuilder.append(", eq910Hz=").append(this.f14270e);
        stringBuilder.append(", eq3600Hz=").append(this.f14271f);
        stringBuilder.append(", eq14000Hz").append(this.f14272g);
        stringBuilder.append(", bassboot=").append(this.f14273h);
        stringBuilder.append(", virtualizer=").append(this.f14274i);
        stringBuilder.append(", reverb=").append(this.f14275j);
        return stringBuilder.toString();
    }

    public boolean equals(Object obj) {
        return this.f14267b == ((gky) obj).f14267b;
    }
}
