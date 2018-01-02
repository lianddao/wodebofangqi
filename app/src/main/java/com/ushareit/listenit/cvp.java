package com.ushareit.listenit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class cvp {
    static final /* synthetic */ boolean f9219a = (!cvp.class.desiredAssertionStatus());
    private final Map<cwc, cuv> f9220b = new HashMap();

    public List<cuv> m13040a() {
        return new ArrayList(this.f9220b.values());
    }

    public void m13041a(cuv com_ushareit_listenit_cuv) {
        cuy b = com_ushareit_listenit_cuv.m12960b();
        cwc a = com_ushareit_listenit_cuv.m12959a();
        if (!f9219a && b != cuy.CHILD_ADDED && b != cuy.CHILD_CHANGED && b != cuy.CHILD_REMOVED) {
            throw new AssertionError("Only child changes supported for tracking");
        } else if (!f9219a && com_ushareit_listenit_cuv.m12959a().m13145e()) {
            throw new AssertionError();
        } else if (this.f9220b.containsKey(a)) {
            cuv com_ushareit_listenit_cuv2 = (cuv) this.f9220b.get(a);
            cuy b2 = com_ushareit_listenit_cuv2.m12960b();
            if (b == cuy.CHILD_ADDED && b2 == cuy.CHILD_REMOVED) {
                this.f9220b.put(com_ushareit_listenit_cuv.m12959a(), cuv.m12951a(a, com_ushareit_listenit_cuv.m12961c(), com_ushareit_listenit_cuv2.m12961c()));
            } else if (b == cuy.CHILD_REMOVED && b2 == cuy.CHILD_ADDED) {
                this.f9220b.remove(a);
            } else if (b == cuy.CHILD_REMOVED && b2 == cuy.CHILD_CHANGED) {
                this.f9220b.put(a, cuv.m12955b(a, com_ushareit_listenit_cuv2.m12962d()));
            } else if (b == cuy.CHILD_CHANGED && b2 == cuy.CHILD_ADDED) {
                this.f9220b.put(a, cuv.m12950a(a, com_ushareit_listenit_cuv.m12961c()));
            } else if (b == cuy.CHILD_CHANGED && b2 == cuy.CHILD_CHANGED) {
                this.f9220b.put(a, cuv.m12951a(a, com_ushareit_listenit_cuv.m12961c(), com_ushareit_listenit_cuv2.m12962d()));
            } else {
                String valueOf = String.valueOf(com_ushareit_listenit_cuv);
                String valueOf2 = String.valueOf(com_ushareit_listenit_cuv2);
                throw new IllegalStateException(new StringBuilder((String.valueOf(valueOf).length() + 48) + String.valueOf(valueOf2).length()).append("Illegal combination of changes: ").append(valueOf).append(" occurred after ").append(valueOf2).toString());
            }
        } else {
            this.f9220b.put(com_ushareit_listenit_cuv.m12959a(), com_ushareit_listenit_cuv);
        }
    }
}
