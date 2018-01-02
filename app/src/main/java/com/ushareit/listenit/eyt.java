package com.ushareit.listenit;

public final class eyt {
    public static Object m18564a(Class<?> cls, Object[] objArr, Class<?>... clsArr) {
        if (cls == null) {
            return null;
        }
        if (objArr != null) {
            return cls.getConstructor(clsArr).newInstance(objArr);
        }
        try {
            return cls.newInstance();
        } catch (Exception e) {
            return null;
        }
    }
}
