package com.ushareit.listenit;

public class eyd {
    private static eyg f12158a;
    private static eyf f12159b = null;

    protected static eyf m18470a() {
        if (f12159b == null) {
            synchronized (eyd.class) {
                if (f12159b == null) {
                    f12159b = f12158a.m18487a(eys.m18562a());
                    exw.m18443a("FileStore", "FileStore inited");
                }
            }
        }
        return f12159b;
    }

    protected eyd() {
    }

    public static synchronized eyh m18471b() {
        eyh a;
        synchronized (eyd.class) {
            a = m18470a().m18484a();
        }
        return a;
    }

    public static synchronized eyh m18472c() {
        eyh b;
        synchronized (eyd.class) {
            b = m18470a().m18485b();
        }
        return b;
    }

    public static eyh m18473d() {
        return m18470a().m18486c();
    }
}
