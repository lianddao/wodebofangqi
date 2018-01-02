package com.ushareit.listenit;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class dco implements dbr, Cloneable {
    public static final dco f9537a = new dco();
    private double f9538b = -1.0d;
    private int f9539c = 136;
    private boolean f9540d = true;
    private List<daf> f9541e = Collections.emptyList();
    private List<daf> f9542f = Collections.emptyList();

    private boolean m13791a(dbu com_ushareit_listenit_dbu) {
        return com_ushareit_listenit_dbu == null || com_ushareit_listenit_dbu.m13746a() <= this.f9538b;
    }

    private boolean m13792a(dbu com_ushareit_listenit_dbu, dbv com_ushareit_listenit_dbv) {
        return m13791a(com_ushareit_listenit_dbu) && m13793a(com_ushareit_listenit_dbv);
    }

    private boolean m13793a(dbv com_ushareit_listenit_dbv) {
        return com_ushareit_listenit_dbv == null || com_ushareit_listenit_dbv.m13747a() > this.f9538b;
    }

    private boolean m13794a(Class<?> cls) {
        return !Enum.class.isAssignableFrom(cls) && (cls.isAnonymousClass() || cls.isLocalClass());
    }

    private boolean m13795b(Class<?> cls) {
        return cls.isMemberClass() && !m13796c(cls);
    }

    private boolean m13796c(Class<?> cls) {
        return (cls.getModifiers() & 8) != 0;
    }

    public <T> dbq<T> mo1709a(dao com_ushareit_listenit_dao, dft<T> com_ushareit_listenit_dft_T) {
        Class a = com_ushareit_listenit_dft_T.m14120a();
        boolean a2 = m13801a(a, true);
        boolean a3 = m13801a(a, false);
        return (a2 || a3) ? new dcp(this, a3, a2, com_ushareit_listenit_dao, com_ushareit_listenit_dft_T) : null;
    }

    protected dco m13798a() {
        try {
            return (dco) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    public dco m13799a(daf com_ushareit_listenit_daf, boolean z, boolean z2) {
        dco a = m13798a();
        if (z) {
            a.f9541e = new ArrayList(this.f9541e);
            a.f9541e.add(com_ushareit_listenit_daf);
        }
        if (z2) {
            a.f9542f = new ArrayList(this.f9542f);
            a.f9542f.add(com_ushareit_listenit_daf);
        }
        return a;
    }

    public dco m13800a(int... iArr) {
        int i = 0;
        dco a = m13798a();
        a.f9539c = 0;
        int length = iArr.length;
        while (i < length) {
            a.f9539c = iArr[i] | a.f9539c;
            i++;
        }
        return a;
    }

    public boolean m13801a(Class<?> cls, boolean z) {
        if (this.f9538b != -1.0d && !m13792a((dbu) cls.getAnnotation(dbu.class), (dbv) cls.getAnnotation(dbv.class))) {
            return true;
        }
        if (!this.f9540d && m13795b(cls)) {
            return true;
        }
        if (m13794a((Class) cls)) {
            return true;
        }
        for (daf a : z ? this.f9541e : this.f9542f) {
            if (a.mo1393a((Class) cls)) {
                return true;
            }
        }
        return false;
    }

    public boolean m13802a(Field field, boolean z) {
        if ((this.f9539c & field.getModifiers()) != 0) {
            return true;
        }
        if (this.f9538b != -1.0d && !m13792a((dbu) field.getAnnotation(dbu.class), (dbv) field.getAnnotation(dbv.class))) {
            return true;
        }
        if (field.isSynthetic()) {
            return true;
        }
        if (!this.f9540d && m13795b(field.getType())) {
            return true;
        }
        if (m13794a(field.getType())) {
            return true;
        }
        List<daf> list = z ? this.f9541e : this.f9542f;
        if (!list.isEmpty()) {
            dag com_ushareit_listenit_dag = new dag(field);
            for (daf a : list) {
                if (a.mo1392a(com_ushareit_listenit_dag)) {
                    return true;
                }
            }
        }
        return false;
    }

    protected /* synthetic */ Object clone() {
        return m13798a();
    }
}
