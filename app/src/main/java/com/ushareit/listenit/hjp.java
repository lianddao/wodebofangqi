package com.ushareit.listenit;

import java.util.Queue;

public class hjp implements hjm {
    String f15532a;
    hjz f15533b;
    Queue<hjs> f15534c;

    public hjp(hjz com_ushareit_listenit_hjz, Queue<hjs> queue) {
        this.f15533b = com_ushareit_listenit_hjz;
        this.f15532a = com_ushareit_listenit_hjz.m24003a();
        this.f15534c = queue;
    }

    private void m23955a(hjq com_ushareit_listenit_hjq, String str, Object[] objArr, Throwable th) {
        m23954a(com_ushareit_listenit_hjq, null, str, objArr, th);
    }

    private void m23954a(hjq com_ushareit_listenit_hjq, hjo com_ushareit_listenit_hjo, String str, Object[] objArr, Throwable th) {
        hjs com_ushareit_listenit_hjs = new hjs();
        com_ushareit_listenit_hjs.m23964a(System.currentTimeMillis());
        com_ushareit_listenit_hjs.m23965a(com_ushareit_listenit_hjq);
        com_ushareit_listenit_hjs.m23966a(this.f15533b);
        com_ushareit_listenit_hjs.m23967a(this.f15532a);
        com_ushareit_listenit_hjs.m23970b(str);
        com_ushareit_listenit_hjs.m23969a(objArr);
        com_ushareit_listenit_hjs.m23968a(th);
        com_ushareit_listenit_hjs.m23971c(Thread.currentThread().getName());
        this.f15534c.add(com_ushareit_listenit_hjs);
    }

    public void mo2789a(String str) {
        m23955a(hjq.TRACE, str, null, null);
    }

    public void mo2793b(String str) {
        m23955a(hjq.INFO, str, null, null);
    }

    public void mo2794c(String str) {
        m23955a(hjq.WARN, str, null, null);
    }

    public void mo2790a(String str, Object obj) {
        m23955a(hjq.WARN, str, new Object[]{obj}, null);
    }

    public void mo2791a(String str, Object obj, Object obj2) {
        m23955a(hjq.WARN, str, new Object[]{obj, obj2}, null);
    }

    public void mo2795d(String str) {
        m23955a(hjq.ERROR, str, null, null);
    }

    public void mo2792a(String str, Throwable th) {
        m23955a(hjq.ERROR, str, null, th);
    }
}
