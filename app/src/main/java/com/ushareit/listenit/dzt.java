package com.ushareit.listenit;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public final class dzt {
    public static <TResult> dzo<TResult> m16569a(Exception exception) {
        dzo com_ushareit_listenit_eaf = new eaf();
        com_ushareit_listenit_eaf.m16597a(exception);
        return com_ushareit_listenit_eaf;
    }

    public static <TResult> dzo<TResult> m16570a(TResult tResult) {
        dzo com_ushareit_listenit_eaf = new eaf();
        com_ushareit_listenit_eaf.m16598a((Object) tResult);
        return com_ushareit_listenit_eaf;
    }

    private static <TResult> TResult m16571a(dzo<TResult> com_ushareit_listenit_dzo_TResult) {
        if (com_ushareit_listenit_dzo_TResult.mo2130b()) {
            return com_ushareit_listenit_dzo_TResult.mo2131c();
        }
        throw new ExecutionException(com_ushareit_listenit_dzo_TResult.mo2132d());
    }

    public static <TResult> TResult m16572a(dzo<TResult> com_ushareit_listenit_dzo_TResult, long j, TimeUnit timeUnit) {
        cfi.m11084a();
        cfi.m11081a((Object) com_ushareit_listenit_dzo_TResult, (Object) "Task must not be null");
        cfi.m11081a((Object) timeUnit, (Object) "TimeUnit must not be null");
        if (com_ushareit_listenit_dzo_TResult.mo2129a()) {
            return m16571a((dzo) com_ushareit_listenit_dzo_TResult);
        }
        Object com_ushareit_listenit_dzv = new dzv();
        m16573a(com_ushareit_listenit_dzo_TResult, com_ushareit_listenit_dzv);
        if (com_ushareit_listenit_dzv.m16576a(j, timeUnit)) {
            return m16571a((dzo) com_ushareit_listenit_dzo_TResult);
        }
        throw new TimeoutException("Timed out waiting for Task");
    }

    private static void m16573a(dzo<?> com_ushareit_listenit_dzo_, dzw com_ushareit_listenit_dzw) {
        com_ushareit_listenit_dzo_.mo2128a(dzq.f10728b, (dzm) com_ushareit_listenit_dzw);
        com_ushareit_listenit_dzo_.mo2127a(dzq.f10728b, (dzl) com_ushareit_listenit_dzw);
    }
}
