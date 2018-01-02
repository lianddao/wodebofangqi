package com.ushareit.listenit;

import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class deb implements dbr {
    private final dcb f9650a;
    private final dan f9651b;
    private final dco f9652c;

    public deb(dcb com_ushareit_listenit_dcb, dan com_ushareit_listenit_dan, dco com_ushareit_listenit_dco) {
        this.f9650a = com_ushareit_listenit_dcb;
        this.f9651b = com_ushareit_listenit_dan;
        this.f9652c = com_ushareit_listenit_dco;
    }

    private dbq<?> m13970a(dao com_ushareit_listenit_dao, Field field, dft<?> com_ushareit_listenit_dft_) {
        dbs com_ushareit_listenit_dbs = (dbs) field.getAnnotation(dbs.class);
        if (com_ushareit_listenit_dbs != null) {
            dbq<?> a = ddr.m13855a(this.f9650a, com_ushareit_listenit_dao, com_ushareit_listenit_dft_, com_ushareit_listenit_dbs);
            if (a != null) {
                return a;
            }
        }
        return com_ushareit_listenit_dao.m13651a((dft) com_ushareit_listenit_dft_);
    }

    private dee m13972a(dao com_ushareit_listenit_dao, Field field, String str, dft<?> com_ushareit_listenit_dft_, boolean z, boolean z2) {
        return new dec(this, str, z, z2, com_ushareit_listenit_dao, field, com_ushareit_listenit_dft_, ddb.m13830a(com_ushareit_listenit_dft_.m14120a()));
    }

    static List<String> m13973a(dan com_ushareit_listenit_dan, Field field) {
        dbt com_ushareit_listenit_dbt = (dbt) field.getAnnotation(dbt.class);
        List<String> linkedList = new LinkedList();
        if (com_ushareit_listenit_dbt == null) {
            linkedList.add(com_ushareit_listenit_dan.mo1701a(field));
        } else {
            linkedList.add(com_ushareit_listenit_dbt.m13744a());
            for (Object add : com_ushareit_listenit_dbt.m13745b()) {
                linkedList.add(add);
            }
        }
        return linkedList;
    }

    private List<String> m13974a(Field field) {
        return m13973a(this.f9651b, field);
    }

    private Map<String, dee> m13975a(dao com_ushareit_listenit_dao, dft<?> com_ushareit_listenit_dft_, Class<?> cls) {
        Map<String, dee> linkedHashMap = new LinkedHashMap();
        if (cls.isInterface()) {
            return linkedHashMap;
        }
        Type b = com_ushareit_listenit_dft_.m14121b();
        Class a;
        while (a != Object.class) {
            for (Field field : a.getDeclaredFields()) {
                boolean a2 = m13978a(field, true);
                boolean a3 = m13978a(field, false);
                if (a2 || a3) {
                    field.setAccessible(true);
                    Type a4 = dbx.m13757a(r19.m14121b(), a, field.getGenericType());
                    List a5 = m13974a(field);
                    dee com_ushareit_listenit_dee = null;
                    int i = 0;
                    while (i < a5.size()) {
                        String str = (String) a5.get(i);
                        if (i != 0) {
                            a2 = false;
                        }
                        dee com_ushareit_listenit_dee2 = (dee) linkedHashMap.put(str, m13972a(com_ushareit_listenit_dao, field, str, dft.m14117a(a4), a2, a3));
                        if (com_ushareit_listenit_dee != null) {
                            com_ushareit_listenit_dee2 = com_ushareit_listenit_dee;
                        }
                        i++;
                        com_ushareit_listenit_dee = com_ushareit_listenit_dee2;
                    }
                    if (com_ushareit_listenit_dee != null) {
                        String valueOf = String.valueOf(b);
                        String str2 = com_ushareit_listenit_dee.f9653g;
                        throw new IllegalArgumentException(new StringBuilder((String.valueOf(valueOf).length() + 37) + String.valueOf(str2).length()).append(valueOf).append(" declares multiple JSON fields named ").append(str2).toString());
                    }
                }
            }
            dft a6 = dft.m14117a(dbx.m13757a(a6.m14121b(), a, a.getGenericSuperclass()));
            a = a6.m14120a();
        }
        return linkedHashMap;
    }

    static boolean m13976a(Field field, boolean z, dco com_ushareit_listenit_dco) {
        return (com_ushareit_listenit_dco.m13801a(field.getType(), z) || com_ushareit_listenit_dco.m13802a(field, z)) ? false : true;
    }

    public <T> dbq<T> mo1709a(dao com_ushareit_listenit_dao, dft<T> com_ushareit_listenit_dft_T) {
        Class a = com_ushareit_listenit_dft_T.m14120a();
        return !Object.class.isAssignableFrom(a) ? null : new ded(this.f9650a.m13777a((dft) com_ushareit_listenit_dft_T), m13975a(com_ushareit_listenit_dao, (dft) com_ushareit_listenit_dft_T, a), null);
    }

    public boolean m13978a(Field field, boolean z) {
        return m13976a(field, z, this.f9652c);
    }
}
