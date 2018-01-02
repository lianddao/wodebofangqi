package com.ushareit.listenit;

public final class eyu<CLAZZ> {
    private eyp<CLAZZ> f12201a;
    private CLAZZ f12202b = null;
    private long f12203c = 0;

    public eyu(eyp<CLAZZ> com_ushareit_listenit_eyp_CLAZZ) {
        exu.m18431a((Object) com_ushareit_listenit_eyp_CLAZZ, "creator can't be null");
        this.f12201a = com_ushareit_listenit_eyp_CLAZZ;
        exw.m18449b("Singleton", "Creator Registered: " + this.f12201a.getClass().getName());
    }

    public synchronized CLAZZ m18565a(String str) {
        if (this.f12202b == null) {
            exw.m18449b("Singleton", "Instance Creating: " + this.f12201a.getClass().getName() + ", ClientId = " + str);
            this.f12202b = this.f12201a.mo2298b(eys.m18562a());
            exu.m18431a(this.f12202b, "singleton creator can't create instance: " + this.f12201a.getClass().getName());
        }
        this.f12203c++;
        exw.m18449b("Singleton", "Client Attached: Creator = " + this.f12201a.getClass().getName() + ", ClientId = " + str + ", AccessCount = " + this.f12203c);
        return this.f12202b;
    }
}
