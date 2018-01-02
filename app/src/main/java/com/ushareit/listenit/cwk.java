package com.ushareit.listenit;

import java.util.Collections;
import java.util.List;

public class cwk {
    private final List<cqq> f9265a;
    private final List<String> f9266b;

    private cwk(List<cqq> list, List<String> list2) {
        if (list.size() != list2.size() - 1) {
            throw new IllegalArgumentException("Number of posts need to be n-1 for n hashes in CompoundHash");
        }
        this.f9265a = list;
        this.f9266b = list2;
    }

    public static cwk m13177a(cxa com_ushareit_listenit_cxa) {
        return m13178a(com_ushareit_listenit_cxa, new cwn(com_ushareit_listenit_cxa));
    }

    public static cwk m13178a(cxa com_ushareit_listenit_cxa, cwo com_ushareit_listenit_cwo) {
        if (com_ushareit_listenit_cxa.mo1635b()) {
            return new cwk(Collections.emptyList(), Collections.singletonList(""));
        }
        cwm com_ushareit_listenit_cwm = new cwm(com_ushareit_listenit_cwo);
        m13180b(com_ushareit_listenit_cxa, com_ushareit_listenit_cwm);
        com_ushareit_listenit_cwm.m13196f();
        return new cwk(com_ushareit_listenit_cwm.f9273f, com_ushareit_listenit_cwm.f9274g);
    }

    private static void m13180b(cxa com_ushareit_listenit_cxa, cwm com_ushareit_listenit_cwm) {
        if (com_ushareit_listenit_cxa.mo1639e()) {
            com_ushareit_listenit_cwm.m13189a((cwv) com_ushareit_listenit_cxa);
        } else if (com_ushareit_listenit_cxa.mo1635b()) {
            throw new IllegalArgumentException("Can't calculate hash on empty node!");
        } else if (com_ushareit_listenit_cxa instanceof cwf) {
            ((cwf) com_ushareit_listenit_cxa).m13160a(new cwl(com_ushareit_listenit_cwm), true);
        } else {
            String valueOf = String.valueOf(com_ushareit_listenit_cxa);
            throw new IllegalStateException(new StringBuilder(String.valueOf(valueOf).length() + 33).append("Expected children node, but got: ").append(valueOf).toString());
        }
    }

    public List<cqq> m13181a() {
        return Collections.unmodifiableList(this.f9265a);
    }

    public List<String> m13182b() {
        return Collections.unmodifiableList(this.f9266b);
    }
}
