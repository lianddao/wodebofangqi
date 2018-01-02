package com.ushareit.listenit;

import java.util.HashMap;
import java.util.Map;

final class dfs<T extends Enum<T>> extends dbq<T> {
    private final Map<String, T> f9730a = new HashMap();
    private final Map<T, String> f9731b = new HashMap();

    public dfs(Class<T> cls) {
        try {
            for (Enum enumR : (Enum[]) cls.getEnumConstants()) {
                String name = enumR.name();
                dbt com_ushareit_listenit_dbt = (dbt) cls.getField(name).getAnnotation(dbt.class);
                if (com_ushareit_listenit_dbt != null) {
                    name = com_ushareit_listenit_dbt.m13744a();
                    for (Object put : com_ushareit_listenit_dbt.m13745b()) {
                        this.f9730a.put(put, enumR);
                    }
                }
                String str = name;
                this.f9730a.put(str, enumR);
                this.f9731b.put(enumR, str);
            }
        } catch (NoSuchFieldException e) {
            throw new AssertionError();
        }
    }

    public T m14113a(dfu com_ushareit_listenit_dfu) {
        if (com_ushareit_listenit_dfu.mo1718f() != dfw.NULL) {
            return (Enum) this.f9730a.get(com_ushareit_listenit_dfu.mo1720h());
        }
        com_ushareit_listenit_dfu.mo1722j();
        return null;
    }

    public void m14114a(dfx com_ushareit_listenit_dfx, T t) {
        com_ushareit_listenit_dfx.mo1735b(t == null ? null : (String) this.f9731b.get(t));
    }

    public /* synthetic */ Object mo1401b(dfu com_ushareit_listenit_dfu) {
        return m14113a(com_ushareit_listenit_dfu);
    }
}
