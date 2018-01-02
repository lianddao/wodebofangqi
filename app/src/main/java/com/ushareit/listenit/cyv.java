package com.ushareit.listenit;

import android.util.Log;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

class cyv<T> {
    private final Class<T> f9376a;
    private final Constructor<T> f9377b;
    private final boolean f9378c;
    private final boolean f9379d;
    private final Map<String, String> f9380e;
    private final Map<String, Method> f9381f;
    private final Map<String, Method> f9382g;
    private final Map<String, Field> f9383h;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public cyv(java.lang.Class<T> r11) {
        /*
        r10 = this;
        r1 = 1;
        r2 = 0;
        r10.<init>();
        r10.f9376a = r11;
        r0 = com.ushareit.listenit.ect.class;
        r0 = r11.isAnnotationPresent(r0);
        r10.f9378c = r0;
        r0 = com.ushareit.listenit.ecm.class;
        r0 = r11.isAnnotationPresent(r0);
        if (r0 != 0) goto L_0x007f;
    L_0x0017:
        r0 = r1;
    L_0x0018:
        r10.f9379d = r0;
        r0 = new java.util.HashMap;
        r0.<init>();
        r10.f9380e = r0;
        r0 = new java.util.HashMap;
        r0.<init>();
        r10.f9382g = r0;
        r0 = new java.util.HashMap;
        r0.<init>();
        r10.f9381f = r0;
        r0 = new java.util.HashMap;
        r0.<init>();
        r10.f9383h = r0;
        r0 = 0;
        r0 = new java.lang.Class[r0];	 Catch:{ NoSuchMethodException -> 0x0081 }
        r0 = r11.getDeclaredConstructor(r0);	 Catch:{ NoSuchMethodException -> 0x0081 }
        r3 = 1;
        r0.setAccessible(r3);	 Catch:{ NoSuchMethodException -> 0x0081 }
    L_0x0041:
        r10.f9377b = r0;
        r3 = r11.getMethods();
        r4 = r3.length;
        r0 = r2;
    L_0x0049:
        if (r0 >= r4) goto L_0x0092;
    L_0x004b:
        r5 = r3[r0];
        r6 = m13429a(r5);
        if (r6 == 0) goto L_0x008f;
    L_0x0053:
        r6 = m13434c(r5);
        r10.m13427a(r6);
        r5.setAccessible(r1);
        r7 = r10.f9381f;
        r7 = r7.containsKey(r6);
        if (r7 == 0) goto L_0x008a;
    L_0x0065:
        r1 = new com.ushareit.listenit.ecf;
        r2 = "Found conflicting getters for name: ";
        r0 = r5.getName();
        r0 = java.lang.String.valueOf(r0);
        r3 = r0.length();
        if (r3 == 0) goto L_0x0084;
    L_0x0077:
        r0 = r2.concat(r0);
    L_0x007b:
        r1.<init>(r0);
        throw r1;
    L_0x007f:
        r0 = r2;
        goto L_0x0018;
    L_0x0081:
        r0 = move-exception;
        r0 = 0;
        goto L_0x0041;
    L_0x0084:
        r0 = new java.lang.String;
        r0.<init>(r2);
        goto L_0x007b;
    L_0x008a:
        r7 = r10.f9381f;
        r7.put(r6, r5);
    L_0x008f:
        r0 = r0 + 1;
        goto L_0x0049;
    L_0x0092:
        r3 = r11.getFields();
        r4 = r3.length;
        r0 = r2;
    L_0x0098:
        if (r0 >= r4) goto L_0x00ac;
    L_0x009a:
        r5 = r3[r0];
        r6 = m13428a(r5);
        if (r6 == 0) goto L_0x00a9;
    L_0x00a2:
        r5 = m13432b(r5);
        r10.m13427a(r5);
    L_0x00a9:
        r0 = r0 + 1;
        goto L_0x0098;
    L_0x00ac:
        r3 = r11;
    L_0x00ad:
        r5 = r3.getDeclaredMethods();
        r6 = r5.length;
        r4 = r2;
    L_0x00b3:
        if (r4 >= r6) goto L_0x017c;
    L_0x00b5:
        r7 = r5[r4];
        r0 = m13433b(r7);
        if (r0 == 0) goto L_0x0107;
    L_0x00bd:
        r8 = m13434c(r7);
        r0 = r10.f9380e;
        r9 = r8.toLowerCase();
        r0 = r0.get(r9);
        r0 = (java.lang.String) r0;
        if (r0 == 0) goto L_0x0107;
    L_0x00cf:
        r0 = r0.equals(r8);
        if (r0 != 0) goto L_0x00f5;
    L_0x00d5:
        r1 = new com.ushareit.listenit.ecf;
        r2 = "Found setter with invalid case-sensitive name: ";
        r0 = r7.getName();
        r0 = java.lang.String.valueOf(r0);
        r3 = r0.length();
        if (r3 == 0) goto L_0x00ef;
    L_0x00e7:
        r0 = r2.concat(r0);
    L_0x00eb:
        r1.<init>(r0);
        throw r1;
    L_0x00ef:
        r0 = new java.lang.String;
        r0.<init>(r2);
        goto L_0x00eb;
    L_0x00f5:
        r0 = r10.f9382g;
        r0 = r0.get(r8);
        r0 = (java.lang.reflect.Method) r0;
        if (r0 != 0) goto L_0x010b;
    L_0x00ff:
        r7.setAccessible(r1);
        r0 = r10.f9382g;
        r0.put(r8, r7);
    L_0x0107:
        r0 = r4 + 1;
        r4 = r0;
        goto L_0x00b3;
    L_0x010b:
        r8 = m13430a(r7, r0);
        if (r8 != 0) goto L_0x0107;
    L_0x0111:
        r1 = new com.ushareit.listenit.ecf;
        r2 = r7.getName();
        r2 = java.lang.String.valueOf(r2);
        r3 = r0.getName();
        r3 = java.lang.String.valueOf(r3);
        r0 = r0.getDeclaringClass();
        r0 = r0.getName();
        r0 = java.lang.String.valueOf(r0);
        r4 = new java.lang.StringBuilder;
        r5 = java.lang.String.valueOf(r2);
        r5 = r5.length();
        r5 = r5 + 69;
        r6 = java.lang.String.valueOf(r3);
        r6 = r6.length();
        r5 = r5 + r6;
        r6 = java.lang.String.valueOf(r0);
        r6 = r6.length();
        r5 = r5 + r6;
        r4.<init>(r5);
        r5 = "Found a conflicting setters with name: ";
        r4 = r4.append(r5);
        r2 = r4.append(r2);
        r4 = " (conflicts with ";
        r2 = r2.append(r4);
        r2 = r2.append(r3);
        r3 = " defined on ";
        r2 = r2.append(r3);
        r0 = r2.append(r0);
        r2 = ")";
        r0 = r0.append(r2);
        r0 = r0.toString();
        r1.<init>(r0);
        throw r1;
    L_0x017c:
        r4 = r3.getDeclaredFields();
        r5 = r4.length;
        r0 = r2;
    L_0x0182:
        if (r0 >= r5) goto L_0x01a9;
    L_0x0184:
        r6 = r4[r0];
        r7 = m13432b(r6);
        r8 = r10.f9380e;
        r9 = r7.toLowerCase();
        r8 = r8.containsKey(r9);
        if (r8 == 0) goto L_0x01a6;
    L_0x0196:
        r8 = r10.f9383h;
        r8 = r8.containsKey(r7);
        if (r8 != 0) goto L_0x01a6;
    L_0x019e:
        r6.setAccessible(r1);
        r8 = r10.f9383h;
        r8.put(r7, r6);
    L_0x01a6:
        r0 = r0 + 1;
        goto L_0x0182;
    L_0x01a9:
        r0 = r3.getSuperclass();
        if (r0 == 0) goto L_0x01b7;
    L_0x01af:
        r3 = java.lang.Object.class;
        r3 = r0.equals(r3);
        if (r3 == 0) goto L_0x01e0;
    L_0x01b7:
        r0 = r10.f9380e;
        r0 = r0.isEmpty();
        if (r0 == 0) goto L_0x01df;
    L_0x01bf:
        r1 = new com.ushareit.listenit.ecf;
        r2 = "No properties to serialize found on class ";
        r0 = r11.getName();
        r0 = java.lang.String.valueOf(r0);
        r3 = r0.length();
        if (r3 == 0) goto L_0x01d9;
    L_0x01d1:
        r0 = r2.concat(r0);
    L_0x01d5:
        r1.<init>(r0);
        throw r1;
    L_0x01d9:
        r0 = new java.lang.String;
        r0.<init>(r2);
        goto L_0x01d5;
    L_0x01df:
        return;
    L_0x01e0:
        r3 = r0;
        goto L_0x00ad;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ushareit.listenit.cyv.<init>(java.lang.Class):void");
    }

    private static String m13425a(AccessibleObject accessibleObject) {
        return accessibleObject.isAnnotationPresent(eco.class) ? ((eco) accessibleObject.getAnnotation(eco.class)).m16745a() : null;
    }

    private Type m13426a(Type type, Map<TypeVariable<Class<T>>, Type> map) {
        if (!(type instanceof TypeVariable)) {
            return type;
        }
        Type type2 = (Type) map.get(type);
        if (type2 != null) {
            return type2;
        }
        String valueOf = String.valueOf(type);
        throw new IllegalStateException(new StringBuilder(String.valueOf(valueOf).length() + 23).append("Could not resolve type ").append(valueOf).toString());
    }

    private void m13427a(String str) {
        String str2 = (String) this.f9380e.put(str.toLowerCase(), str);
        if (str2 != null && !str.equals(str2)) {
            String str3 = "Found two getters or fields with conflicting case sensitivity for property: ";
            str2 = String.valueOf(str.toLowerCase());
            throw new ecf(str2.length() != 0 ? str3.concat(str2) : new String(str3));
        }
    }

    private static boolean m13428a(Field field) {
        return (field.getDeclaringClass().equals(Object.class) || !Modifier.isPublic(field.getModifiers()) || Modifier.isStatic(field.getModifiers()) || Modifier.isTransient(field.getModifiers()) || field.isAnnotationPresent(eck.class)) ? false : true;
    }

    private static boolean m13429a(Method method) {
        return ((!method.getName().startsWith("get") && !method.getName().startsWith("is")) || method.getDeclaringClass().equals(Object.class) || !Modifier.isPublic(method.getModifiers()) || Modifier.isStatic(method.getModifiers()) || method.getReturnType().equals(Void.TYPE) || method.getParameterTypes().length != 0 || method.isAnnotationPresent(eck.class)) ? false : true;
    }

    private static boolean m13430a(Method method, Method method2) {
        cyr.m13388a(method.getDeclaringClass().isAssignableFrom(method2.getDeclaringClass()), "Expected override from a base class");
        cyr.m13388a(method.getReturnType().equals(Void.TYPE), "Expected void return type");
        cyr.m13388a(method2.getReturnType().equals(Void.TYPE), "Expected void return type");
        Class[] parameterTypes = method.getParameterTypes();
        Class[] parameterTypes2 = method2.getParameterTypes();
        cyr.m13388a(parameterTypes.length == 1, "Expected exactly one parameter");
        cyr.m13388a(parameterTypes2.length == 1, "Expected exactly one parameter");
        return method.getName().equals(method2.getName()) && parameterTypes[0].equals(parameterTypes2[0]);
    }

    private static String m13431b(String str) {
        String[] strArr = new String[]{"get", "set", "is"};
        String str2 = null;
        int i = 0;
        while (i < 3) {
            String str3 = strArr[i];
            if (!str.startsWith(str3)) {
                str3 = str2;
            }
            i++;
            str2 = str3;
        }
        if (str2 == null) {
            String str4 = "Unknown Bean prefix for method: ";
            str3 = String.valueOf(str);
            throw new IllegalArgumentException(str3.length() != 0 ? str4.concat(str3) : new String(str4));
        }
        char[] toCharArray = str.substring(str2.length()).toCharArray();
        int i2 = 0;
        while (i2 < toCharArray.length && Character.isUpperCase(toCharArray[i2])) {
            toCharArray[i2] = Character.toLowerCase(toCharArray[i2]);
            i2++;
        }
        return new String(toCharArray);
    }

    private static String m13432b(Field field) {
        String a = m13425a((AccessibleObject) field);
        return a != null ? a : field.getName();
    }

    private static boolean m13433b(Method method) {
        return method.getName().startsWith("set") && !method.getDeclaringClass().equals(Object.class) && !Modifier.isStatic(method.getModifiers()) && method.getReturnType().equals(Void.TYPE) && method.getParameterTypes().length == 1 && !method.isAnnotationPresent(eck.class);
    }

    private static String m13434c(Method method) {
        String a = m13425a((AccessibleObject) method);
        return a != null ? a : m13431b(method.getName());
    }

    public T m13435a(Map<String, Object> map) {
        return m13436a((Map) map, Collections.emptyMap());
    }

    public T m13436a(Map<String, Object> map, Map<TypeVariable<Class<T>>, Type> map2) {
        if (this.f9377b == null) {
            String valueOf = String.valueOf(this.f9376a.getName());
            throw new ecf(new StringBuilder(String.valueOf(valueOf).length() + 49).append("Class ").append(valueOf).append(" is missing a constructor with no arguments").toString());
        }
        try {
            T newInstance = this.f9377b.newInstance(new Object[0]);
            for (Entry entry : map.entrySet()) {
                valueOf = (String) entry.getKey();
                if (this.f9382g.containsKey(valueOf)) {
                    Method method = (Method) this.f9382g.get(valueOf);
                    Type[] genericParameterTypes = method.getGenericParameterTypes();
                    if (genericParameterTypes.length != 1) {
                        throw new IllegalStateException("Setter does not have exactly one parameter");
                    }
                    Object a = cyu.m13413b(entry.getValue(), m13426a(genericParameterTypes[0], (Map) map2));
                    try {
                        method.invoke(newInstance, new Object[]{a});
                    } catch (Throwable e) {
                        throw new RuntimeException(e);
                    } catch (Throwable e2) {
                        throw new RuntimeException(e2);
                    }
                } else if (this.f9383h.containsKey(valueOf)) {
                    Field field = (Field) this.f9383h.get(valueOf);
                    try {
                        field.set(newInstance, cyu.m13413b(entry.getValue(), m13426a(field.getGenericType(), (Map) map2)));
                    } catch (Throwable e22) {
                        throw new RuntimeException(e22);
                    }
                } else {
                    String valueOf2 = String.valueOf(this.f9376a.getName());
                    valueOf2 = new StringBuilder((String.valueOf(valueOf).length() + 36) + String.valueOf(valueOf2).length()).append("No setter/field for ").append(valueOf).append(" found on class ").append(valueOf2).toString();
                    if (this.f9380e.containsKey(valueOf.toLowerCase())) {
                        valueOf2 = String.valueOf(valueOf2).concat(" (fields/setters are case sensitive!)");
                    }
                    if (this.f9378c) {
                        throw new ecf(valueOf2);
                    } else if (this.f9379d) {
                        Log.w("ClassMapper", valueOf2);
                    }
                }
            }
            return newInstance;
        } catch (Throwable e222) {
            throw new RuntimeException(e222);
        } catch (Throwable e2222) {
            throw new RuntimeException(e2222);
        } catch (Throwable e22222) {
            throw new RuntimeException(e22222);
        }
    }

    public Map<String, Object> m13437a(T t) {
        if (this.f9376a.isAssignableFrom(t.getClass())) {
            Map<String, Object> hashMap = new HashMap();
            for (String str : this.f9380e.values()) {
                String str2;
                Object invoke;
                if (this.f9381f.containsKey(str2)) {
                    try {
                        invoke = ((Method) this.f9381f.get(str2)).invoke(t, new Object[0]);
                    } catch (Throwable e) {
                        throw new RuntimeException(e);
                    } catch (Throwable e2) {
                        throw new RuntimeException(e2);
                    }
                }
                Field field = (Field) this.f9383h.get(str2);
                if (field == null) {
                    String str3 = "Bean property without field or getter:";
                    str2 = String.valueOf(str2);
                    throw new IllegalStateException(str2.length() != 0 ? str3.concat(str2) : new String(str3));
                }
                try {
                    invoke = field.get(t);
                } catch (Throwable e22) {
                    throw new RuntimeException(e22);
                }
                hashMap.put(str2, cyu.m13414c(invoke));
            }
            return hashMap;
        }
        String valueOf = String.valueOf(t.getClass());
        str3 = String.valueOf(this.f9376a);
        throw new IllegalArgumentException(new StringBuilder((String.valueOf(valueOf).length() + 59) + String.valueOf(str3).length()).append("Can't serialize object of class ").append(valueOf).append(" with BeanMapper for class ").append(str3).toString());
    }
}
