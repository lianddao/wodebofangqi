package com.ushareit.listenit;

import android.accounts.Account;
import android.content.Context;
import android.view.View;
import com.google.android.gms.common.api.Scope;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public final class cgs {
    private final Account f8260a;
    private final Set<Scope> f8261b;
    private final Set<Scope> f8262c;
    private final Map<cdj<?>, cgt> f8263d;
    private final int f8264e;
    private final View f8265f;
    private final String f8266g;
    private final String f8267h;
    private final dsc f8268i;
    private Integer f8269j;

    public cgs(Account account, Set<Scope> set, Map<cdj<?>, cgt> map, int i, View view, String str, String str2, dsc com_ushareit_listenit_dsc) {
        Map map2;
        this.f8260a = account;
        this.f8261b = set == null ? Collections.EMPTY_SET : Collections.unmodifiableSet(set);
        if (map == null) {
            map2 = Collections.EMPTY_MAP;
        }
        this.f8263d = map2;
        this.f8265f = view;
        this.f8264e = i;
        this.f8266g = str;
        this.f8267h = str2;
        this.f8268i = com_ushareit_listenit_dsc;
        Set hashSet = new HashSet(this.f8261b);
        for (cgt com_ushareit_listenit_cgt : this.f8263d.values()) {
            hashSet.addAll(com_ushareit_listenit_cgt.f8270a);
        }
        this.f8262c = Collections.unmodifiableSet(hashSet);
    }

    public static cgs m11177a(Context context) {
        return new cea(context).m10959a();
    }

    @Deprecated
    public String m11178a() {
        return this.f8260a != null ? this.f8260a.name : null;
    }

    public Set<Scope> m11179a(cdj<?> com_ushareit_listenit_cdj_) {
        cgt com_ushareit_listenit_cgt = (cgt) this.f8263d.get(com_ushareit_listenit_cdj_);
        if (com_ushareit_listenit_cgt == null || com_ushareit_listenit_cgt.f8270a.isEmpty()) {
            return this.f8261b;
        }
        Set<Scope> hashSet = new HashSet(this.f8261b);
        hashSet.addAll(com_ushareit_listenit_cgt.f8270a);
        return hashSet;
    }

    public void m11180a(Integer num) {
        this.f8269j = num;
    }

    public Account m11181b() {
        return this.f8260a;
    }

    public Account m11182c() {
        return this.f8260a != null ? this.f8260a : new Account("<<default account>>", "com.google");
    }

    public Set<Scope> m11183d() {
        return this.f8261b;
    }

    public Set<Scope> m11184e() {
        return this.f8262c;
    }

    public Map<cdj<?>, cgt> m11185f() {
        return this.f8263d;
    }

    public String m11186g() {
        return this.f8266g;
    }

    public String m11187h() {
        return this.f8267h;
    }

    public dsc m11188i() {
        return this.f8268i;
    }

    public Integer m11189j() {
        return this.f8269j;
    }
}
