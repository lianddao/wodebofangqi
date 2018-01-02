package com.ushareit.listenit;

import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class eqt implements Cloneable {
    private static final eqx f11534i = new epx();
    private static final eqx f11535j = new epv();
    private static Class[] f11536k = new Class[]{Float.TYPE, Float.class, Double.TYPE, Integer.TYPE, Double.class, Integer.class};
    private static Class[] f11537l = new Class[]{Integer.TYPE, Integer.class, Float.TYPE, Double.TYPE, Float.class, Double.class};
    private static Class[] f11538m = new Class[]{Double.TYPE, Double.class, Float.TYPE, Integer.TYPE, Float.class, Integer.class};
    private static final HashMap<Class, HashMap<String, Method>> f11539n = new HashMap();
    private static final HashMap<Class, HashMap<String, Method>> f11540o = new HashMap();
    String f11541a;
    protected eri f11542b;
    Method f11543c;
    Class f11544d;
    eqc f11545e;
    final ReentrantReadWriteLock f11546f;
    final Object[] f11547g;
    private Method f11548h;
    private eqx f11549p;
    private Object f11550q;

    public /* synthetic */ Object clone() {
        return mo2261a();
    }

    private eqt(String str) {
        this.f11543c = null;
        this.f11548h = null;
        this.f11545e = null;
        this.f11546f = new ReentrantReadWriteLock();
        this.f11547g = new Object[1];
        this.f11541a = str;
    }

    private eqt(eri com_ushareit_listenit_eri) {
        this.f11543c = null;
        this.f11548h = null;
        this.f11545e = null;
        this.f11546f = new ReentrantReadWriteLock();
        this.f11547g = new Object[1];
        this.f11542b = com_ushareit_listenit_eri;
        if (com_ushareit_listenit_eri != null) {
            this.f11541a = com_ushareit_listenit_eri.m17416a();
        }
    }

    public static eqt m17483a(String str, int... iArr) {
        return new eqw(str, iArr);
    }

    public static eqt m17481a(eri<?, Integer> com_ushareit_listenit_eri___java_lang_Integer, int... iArr) {
        return new eqw((eri) com_ushareit_listenit_eri___java_lang_Integer, iArr);
    }

    public static eqt m17482a(String str, float... fArr) {
        return new eqv(str, fArr);
    }

    public static eqt m17480a(eri<?, Float> com_ushareit_listenit_eri___java_lang_Float, float... fArr) {
        return new eqv((eri) com_ushareit_listenit_eri___java_lang_Float, fArr);
    }

    public void mo2268a(int... iArr) {
        this.f11544d = Integer.TYPE;
        this.f11545e = eqc.m17325a(iArr);
    }

    public void mo2264a(float... fArr) {
        this.f11544d = Float.TYPE;
        this.f11545e = eqc.m17324a(fArr);
    }

    private Method m17485a(Class cls, String str, Class cls2) {
        Method method = null;
        String a = m17484a(str, this.f11541a);
        Class[] clsArr = null;
        if (cls2 == null) {
            try {
                return cls.getMethod(a, clsArr);
            } catch (NoSuchMethodException e) {
                Method declaredMethod;
                try {
                    declaredMethod = cls.getDeclaredMethod(a, clsArr);
                    try {
                        declaredMethod.setAccessible(true);
                        return declaredMethod;
                    } catch (NoSuchMethodException e2) {
                        Log.e("PropertyValuesHolder", "Couldn't find no-arg method for property " + this.f11541a + ": " + e);
                        return declaredMethod;
                    }
                } catch (NoSuchMethodException e3) {
                    declaredMethod = null;
                    Log.e("PropertyValuesHolder", "Couldn't find no-arg method for property " + this.f11541a + ": " + e);
                    return declaredMethod;
                }
            }
        }
        Class[] clsArr2 = new Class[1];
        if (this.f11544d.equals(Float.class)) {
            clsArr = f11536k;
        } else if (this.f11544d.equals(Integer.class)) {
            clsArr = f11537l;
        } else {
            clsArr = this.f11544d.equals(Double.class) ? f11538m : new Class[]{this.f11544d};
        }
        int length = clsArr.length;
        int i = 0;
        while (i < length) {
            Class cls3 = clsArr[i];
            clsArr2[0] = cls3;
            try {
                method = cls.getMethod(a, clsArr2);
                this.f11544d = cls3;
                return method;
            } catch (NoSuchMethodException e4) {
                try {
                    method = cls.getDeclaredMethod(a, clsArr2);
                    method.setAccessible(true);
                    this.f11544d = cls3;
                    return method;
                } catch (NoSuchMethodException e5) {
                    i++;
                }
            }
        }
        Log.e("PropertyValuesHolder", "Couldn't find setter/getter for property " + this.f11541a + " with value type " + this.f11544d);
        return method;
    }

    private Method m17486a(Class cls, HashMap<Class, HashMap<String, Method>> hashMap, String str, Class cls2) {
        Method method = null;
        try {
            this.f11546f.writeLock().lock();
            HashMap hashMap2 = (HashMap) hashMap.get(cls);
            if (hashMap2 != null) {
                method = (Method) hashMap2.get(this.f11541a);
            }
            if (method == null) {
                method = m17485a(cls, str, cls2);
                if (hashMap2 == null) {
                    hashMap2 = new HashMap();
                    hashMap.put(cls, hashMap2);
                }
                hashMap2.put(this.f11541a, method);
            }
            Method method2 = method;
            this.f11546f.writeLock().unlock();
            return method2;
        } catch (Throwable th) {
            this.f11546f.writeLock().unlock();
        }
    }

    void mo2263a(Class cls) {
        this.f11543c = m17486a(cls, f11539n, "set", this.f11544d);
    }

    private void m17487b(Class cls) {
        this.f11548h = m17486a(cls, f11540o, "get", null);
    }

    void m17492a(Object obj) {
        epz com_ushareit_listenit_epz;
        if (this.f11542b != null) {
            try {
                this.f11542b.mo2258a(obj);
                Iterator it = this.f11545e.f11468e.iterator();
                while (it.hasNext()) {
                    com_ushareit_listenit_epz = (epz) it.next();
                    if (!com_ushareit_listenit_epz.m17345a()) {
                        com_ushareit_listenit_epz.mo2244a(this.f11542b.mo2258a(obj));
                    }
                }
                return;
            } catch (ClassCastException e) {
                Log.e("PropertyValuesHolder", "No such property (" + this.f11542b.m17416a() + ") on target object " + obj + ". Trying reflection instead");
                this.f11542b = null;
            }
        }
        Class cls = obj.getClass();
        if (this.f11543c == null) {
            mo2263a(cls);
        }
        Iterator it2 = this.f11545e.f11468e.iterator();
        while (it2.hasNext()) {
            com_ushareit_listenit_epz = (epz) it2.next();
            if (!com_ushareit_listenit_epz.m17345a()) {
                if (this.f11548h == null) {
                    m17487b(cls);
                }
                try {
                    com_ushareit_listenit_epz.mo2244a(this.f11548h.invoke(obj, new Object[0]));
                } catch (InvocationTargetException e2) {
                    Log.e("PropertyValuesHolder", e2.toString());
                } catch (IllegalAccessException e3) {
                    Log.e("PropertyValuesHolder", e3.toString());
                }
            }
        }
    }

    public eqt mo2261a() {
        try {
            eqt com_ushareit_listenit_eqt = (eqt) super.clone();
            com_ushareit_listenit_eqt.f11541a = this.f11541a;
            com_ushareit_listenit_eqt.f11542b = this.f11542b;
            com_ushareit_listenit_eqt.f11545e = this.f11545e.mo2242b();
            com_ushareit_listenit_eqt.f11549p = this.f11549p;
            return com_ushareit_listenit_eqt;
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

    void mo2265b(Object obj) {
        if (this.f11542b != null) {
            this.f11542b.mo2257a(obj, mo2267d());
        }
        if (this.f11543c != null) {
            try {
                this.f11547g[0] = mo2267d();
                this.f11543c.invoke(obj, this.f11547g);
            } catch (InvocationTargetException e) {
                Log.e("PropertyValuesHolder", e.toString());
            } catch (IllegalAccessException e2) {
                Log.e("PropertyValuesHolder", e2.toString());
            }
        }
    }

    void m17496b() {
        if (this.f11549p == null) {
            eqx com_ushareit_listenit_eqx = this.f11544d == Integer.class ? f11534i : this.f11544d == Float.class ? f11535j : null;
            this.f11549p = com_ushareit_listenit_eqx;
        }
        if (this.f11549p != null) {
            this.f11545e.m17327a(this.f11549p);
        }
    }

    void mo2262a(float f) {
        this.f11550q = this.f11545e.mo2241a(f);
    }

    public void m17493a(String str) {
        this.f11541a = str;
    }

    public void m17490a(eri com_ushareit_listenit_eri) {
        this.f11542b = com_ushareit_listenit_eri;
    }

    public String m17498c() {
        return this.f11541a;
    }

    Object mo2267d() {
        return this.f11550q;
    }

    public String toString() {
        return this.f11541a + ": " + this.f11545e.toString();
    }

    static String m17484a(String str, String str2) {
        if (str2 == null || str2.length() == 0) {
            return str;
        }
        char toUpperCase = Character.toUpperCase(str2.charAt(0));
        return str + toUpperCase + str2.substring(1);
    }
}
