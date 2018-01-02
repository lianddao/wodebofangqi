package com.ushareit.listenit;

public class ecb {
    private final cwt f10809a;
    private final ecg f10810b;

    ecb(ecg com_ushareit_listenit_ecg, cwt com_ushareit_listenit_cwt) {
        this.f10809a = com_ushareit_listenit_cwt;
        this.f10810b = com_ushareit_listenit_ecg;
    }

    public ecb m16699a(String str) {
        return new ecb(this.f10810b.m16736a(str), cwt.m13242a(this.f10809a.m13247a().mo1629a(new cqq(str))));
    }

    public Object m16700a() {
        return this.f10809a.m13247a().mo1643a();
    }

    public <T> T m16701a(Class<T> cls) {
        return cyu.m13407a(this.f10809a.m13247a().mo1643a(), (Class) cls);
    }

    public Object m16702a(boolean z) {
        return this.f10809a.m13247a().mo1632a(z);
    }

    public long m16703b() {
        return (long) this.f10809a.m13247a().mo1636c();
    }

    public boolean m16704b(String str) {
        if (this.f10810b.mo2134a() == null) {
            cyt.m13398b(str);
        } else {
            cyt.m13397a(str);
        }
        return !this.f10809a.m13247a().mo1629a(new cqq(str)).mo1635b();
    }

    public ecg m16705c() {
        return this.f10810b;
    }

    public String m16706d() {
        return this.f10810b.m16737b();
    }

    public Iterable<ecb> m16707e() {
        return new ecc(this, this.f10809a.iterator());
    }

    public String toString() {
        String valueOf = String.valueOf(this.f10810b.m16737b());
        String valueOf2 = String.valueOf(this.f10809a.m13247a().mo1632a(true));
        return new StringBuilder((String.valueOf(valueOf).length() + 33) + String.valueOf(valueOf2).length()).append("DataSnapshot { key = ").append(valueOf).append(", value = ").append(valueOf2).append(" }").toString();
    }
}
