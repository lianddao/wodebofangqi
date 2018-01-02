package com.ushareit.listenit;

import android.content.Context;
import com.google.firebase.database.connection.idl.ConnectionConfig;
import com.google.firebase.database.connection.idl.IPersistentConnectionImpl;
import java.util.List;
import java.util.Map;

public class edk implements cop {
    private final edx f10859a;

    private edk(edx com_ushareit_listenit_edx) {
        this.f10859a = com_ushareit_listenit_edx;
    }

    public static edk m16795a(Context context, ConnectionConfig connectionConfig, col com_ushareit_listenit_col, coq com_ushareit_listenit_coq) {
        return new edk(IPersistentConnectionImpl.loadDynamic(context, connectionConfig, com_ushareit_listenit_col.m12026b(), com_ushareit_listenit_col.m12027c(), com_ushareit_listenit_coq));
    }

    private static eed m16796a(cph com_ushareit_listenit_cph) {
        return new edm(com_ushareit_listenit_cph);
    }

    public void mo1516a() {
        try {
            this.f10859a.initialize();
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void mo1520a(List<String> list, cph com_ushareit_listenit_cph) {
        try {
            this.f10859a.onDisconnectCancel(list, m16796a(com_ushareit_listenit_cph));
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void mo1521a(List<String> list, Object obj, cph com_ushareit_listenit_cph) {
        try {
            this.f10859a.put(list, ckj.m11512a(obj), m16796a(com_ushareit_listenit_cph));
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void mo1522a(List<String> list, Object obj, String str, cph com_ushareit_listenit_cph) {
        try {
            this.f10859a.compareAndPut(list, ckj.m11512a(obj), str, m16796a(com_ushareit_listenit_cph));
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void mo1523a(List<String> list, Map<String, Object> map) {
        try {
            this.f10859a.unlisten(list, ckj.m11512a((Object) map));
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void mo1524a(List<String> list, Map<String, Object> map, coo com_ushareit_listenit_coo, Long l, cph com_ushareit_listenit_cph) {
        long longValue;
        edu com_ushareit_listenit_edl = new edl(this, com_ushareit_listenit_coo);
        if (l != null) {
            try {
                longValue = l.longValue();
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }
        longValue = -1;
        this.f10859a.listen(list, ckj.m11512a((Object) map), com_ushareit_listenit_edl, longValue, m16796a(com_ushareit_listenit_cph));
    }

    public void mo1525a(List<String> list, Map<String, Object> map, cph com_ushareit_listenit_cph) {
        try {
            this.f10859a.merge(list, ckj.m11512a((Object) map), m16796a(com_ushareit_listenit_cph));
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void mo1527b() {
        try {
            this.f10859a.shutdown();
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void mo1529b(List<String> list, Object obj, cph com_ushareit_listenit_cph) {
        try {
            this.f10859a.onDisconnectPut(list, ckj.m11512a(obj), m16796a(com_ushareit_listenit_cph));
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void mo1530b(List<String> list, Map<String, Object> map, cph com_ushareit_listenit_cph) {
        try {
            this.f10859a.onDisconnectMerge(list, ckj.m11512a((Object) map), m16796a(com_ushareit_listenit_cph));
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void mo1531c() {
        try {
            this.f10859a.refreshAuthToken();
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void mo1532c(String str) {
        try {
            this.f10859a.refreshAuthToken2(str);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void mo1533d() {
        try {
            this.f10859a.purgeOutstandingWrites();
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void mo1534d(String str) {
        try {
            this.f10859a.interrupt(str);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void mo1535e(String str) {
        try {
            this.f10859a.resume(str);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public boolean mo1536f(String str) {
        try {
            return this.f10859a.isInterrupted(str);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
}
