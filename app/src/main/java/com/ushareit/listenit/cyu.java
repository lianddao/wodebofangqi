package com.ushareit.listenit;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class cyu {
    private static final ConcurrentMap<Class<?>, cyv<?>> f9375a = new ConcurrentHashMap();

    private static <T> cyv<T> m13405a(Class<T> cls) {
        cyv<T> com_ushareit_listenit_cyv_T = (cyv) f9375a.get(cls);
        if (com_ushareit_listenit_cyv_T != null) {
            return com_ushareit_listenit_cyv_T;
        }
        com_ushareit_listenit_cyv_T = new cyv(cls);
        f9375a.put(cls, com_ushareit_listenit_cyv_T);
        return com_ushareit_listenit_cyv_T;
    }

    public static Object m13406a(Object obj) {
        return m13414c(obj);
    }

    public static <T> T m13407a(Object obj, Class<T> cls) {
        return m13412b(obj, (Class) cls);
    }

    private static <T> T m13408a(Object obj, ParameterizedType parameterizedType) {
        Class cls = (Class) parameterizedType.getRawType();
        if (List.class.isAssignableFrom(cls)) {
            Type type = parameterizedType.getActualTypeArguments()[0];
            if (obj instanceof List) {
                List<Object> list = (List) obj;
                T arrayList = new ArrayList(list.size());
                for (Object b : list) {
                    arrayList.add(m13413b(b, type));
                }
                return arrayList;
            }
            String valueOf = String.valueOf(obj.getClass());
            throw new ecf(new StringBuilder(String.valueOf(valueOf).length() + 47).append("Expected a List while deserializing, but got a ").append(valueOf).toString());
        } else if (Map.class.isAssignableFrom(cls)) {
            Object obj2 = parameterizedType.getActualTypeArguments()[0];
            Type type2 = parameterizedType.getActualTypeArguments()[1];
            if (obj2.equals(String.class)) {
                Map d = m13417d(obj);
                T hashMap = new HashMap();
                for (Entry entry : d.entrySet()) {
                    hashMap.put((String) entry.getKey(), m13413b(entry.getValue(), type2));
                }
                return hashMap;
            }
            String valueOf2 = String.valueOf(obj2);
            throw new ecf(new StringBuilder(String.valueOf(valueOf2).length() + 70).append("Only Maps with string keys are supported, but found Map with key type ").append(valueOf2).toString());
        } else if (Collection.class.isAssignableFrom(cls)) {
            throw new ecf("Collections are not supported, please use Lists instead");
        } else {
            Map d2 = m13417d(obj);
            cyv a = m13405a(cls);
            Map hashMap2 = new HashMap();
            TypeVariable[] typeParameters = a.f9376a.getTypeParameters();
            Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
            if (actualTypeArguments.length != typeParameters.length) {
                throw new IllegalStateException("Mismatched lengths for type variables and actual types");
            }
            for (int i = 0; i < typeParameters.length; i++) {
                hashMap2.put(typeParameters[i], actualTypeArguments[i]);
            }
            return a.m13436a(d2, hashMap2);
        }
    }

    public static Map<String, Object> m13410a(Map<String, Object> map) {
        Object c = m13414c(map);
        cyr.m13387a(c instanceof Map);
        return (Map) c;
    }

    private static <T> T m13412b(Object obj, Class<T> cls) {
        if (obj == null) {
            return null;
        }
        if (cls.isPrimitive() || Number.class.isAssignableFrom(cls) || Boolean.class.isAssignableFrom(cls) || Character.class.isAssignableFrom(cls)) {
            return m13415c(obj, cls);
        }
        if (String.class.isAssignableFrom(cls)) {
            return m13423i(obj);
        }
        if (cls.isArray()) {
            throw new ecf("Converting to Arrays is not supported, please use Listsinstead");
        } else if (cls.getTypeParameters().length <= 0) {
            return !cls.equals(Object.class) ? cls.isEnum() ? m13416d(obj, cls) : m13419e(obj, cls) : obj;
        } else {
            String valueOf = String.valueOf(cls.getName());
            throw new ecf(new StringBuilder(String.valueOf(valueOf).length() + 75).append("Class ").append(valueOf).append(" has generic type parameters, please use GenericTypeIndicator instead").toString());
        }
    }

    private static <T> T m13413b(Object obj, Type type) {
        if (obj == null) {
            return null;
        }
        if (type instanceof ParameterizedType) {
            return m13408a(obj, (ParameterizedType) type);
        }
        if (type instanceof Class) {
            return m13412b(obj, (Class) type);
        }
        if (type instanceof WildcardType) {
            throw new ecf("Generic wildcard types are not supported");
        } else if (type instanceof GenericArrayType) {
            throw new ecf("Generic Arrays are not supported, please use Lists instead");
        } else {
            String valueOf = String.valueOf(type);
            throw new IllegalStateException(new StringBuilder(String.valueOf(valueOf).length() + 26).append("Unknown type encountered: ").append(valueOf).toString());
        }
    }

    private static <T> Object m13414c(T t) {
        if (t == null) {
            return null;
        }
        if (t instanceof Number) {
            if (t instanceof Float) {
                return Double.valueOf(((Float) t).doubleValue());
            }
            if (t instanceof Short) {
                throw new ecf("Shorts are not supported, please use int or long");
            } else if (!(t instanceof Byte)) {
                return t;
            } else {
                throw new ecf("Bytes are not supported, please use int or long");
            }
        } else if ((t instanceof String) || (t instanceof Boolean)) {
            return t;
        } else {
            if (t instanceof Character) {
                throw new ecf("Characters are not supported, please strings");
            } else if (t instanceof Map) {
                Map hashMap = new HashMap();
                for (Entry entry : ((Map) t).entrySet()) {
                    Object key = entry.getKey();
                    if (key instanceof String) {
                        hashMap.put((String) key, m13414c(entry.getValue()));
                    } else {
                        throw new ecf("Maps with non-string keys are not supported");
                    }
                }
                return hashMap;
            } else if (t instanceof Collection) {
                if (t instanceof List) {
                    List<Object> list = (List) t;
                    List arrayList = new ArrayList(list.size());
                    for (Object c : list) {
                        arrayList.add(m13414c(c));
                    }
                    return arrayList;
                }
                throw new ecf("Serializing Collections is not supported, please use Lists instead");
            } else if (!t.getClass().isArray()) {
                return t instanceof Enum ? ((Enum) t).name() : m13405a(t.getClass()).m13437a((Object) t);
            } else {
                throw new ecf("Serializing Arrays is not supported, please use Lists instead");
            }
        }
    }

    private static <T> T m13415c(Object obj, Class<T> cls) {
        if (Integer.class.isAssignableFrom(cls) || Integer.TYPE.isAssignableFrom(cls)) {
            return m13418e(obj);
        }
        if (Boolean.class.isAssignableFrom(cls) || Boolean.TYPE.isAssignableFrom(cls)) {
            return m13422h(obj);
        }
        if (Double.class.isAssignableFrom(cls) || Double.TYPE.isAssignableFrom(cls)) {
            return m13421g(obj);
        }
        if (Long.class.isAssignableFrom(cls) || Long.TYPE.isAssignableFrom(cls)) {
            return m13420f(obj);
        }
        if (Float.class.isAssignableFrom(cls) || Float.TYPE.isAssignableFrom(cls)) {
            return Float.valueOf(m13421g(obj).floatValue());
        }
        if (Short.class.isAssignableFrom(cls) || Short.TYPE.isAssignableFrom(cls)) {
            throw new ecf("Deserializing to shorts is not supported");
        } else if (Byte.class.isAssignableFrom(cls) || Byte.TYPE.isAssignableFrom(cls)) {
            throw new ecf("Deserializing to bytes is not supported");
        } else if (Character.class.isAssignableFrom(cls) || Character.TYPE.isAssignableFrom(cls)) {
            throw new ecf("Deserializing to char is not supported");
        } else {
            String valueOf = String.valueOf(cls);
            throw new IllegalArgumentException(new StringBuilder(String.valueOf(valueOf).length() + 24).append("Unknown primitive type: ").append(valueOf).toString());
        }
    }

    private static <T> T m13416d(Object obj, Class<T> cls) {
        if (obj instanceof String) {
            String str = (String) obj;
            try {
                return Enum.valueOf(cls, str);
            } catch (IllegalArgumentException e) {
                String valueOf = String.valueOf(cls.getName());
                throw new ecf(new StringBuilder((String.valueOf(valueOf).length() + 42) + String.valueOf(str).length()).append("Could not find enum value of ").append(valueOf).append(" for value \"").append(str).append("\"").toString());
            }
        }
        valueOf = String.valueOf(cls);
        String valueOf2 = String.valueOf(obj.getClass());
        throw new ecf(new StringBuilder((String.valueOf(valueOf).length() + 57) + String.valueOf(valueOf2).length()).append("Expected a String while deserializing to enum ").append(valueOf).append(" but got a ").append(valueOf2).toString());
    }

    private static Map<String, Object> m13417d(Object obj) {
        if (obj instanceof Map) {
            return (Map) obj;
        }
        String valueOf = String.valueOf(obj.getClass());
        throw new ecf(new StringBuilder(String.valueOf(valueOf).length() + 46).append("Expected a Map while deserializing, but got a ").append(valueOf).toString());
    }

    private static Integer m13418e(Object obj) {
        if (obj instanceof Integer) {
            return (Integer) obj;
        }
        if ((obj instanceof Long) || (obj instanceof Double)) {
            double doubleValue = ((Number) obj).doubleValue();
            if (doubleValue >= -2.147483648E9d && doubleValue <= 2.147483647E9d) {
                return Integer.valueOf(((Number) obj).intValue());
            }
            throw new ecf("Numeric value out of 32-bit integer range: " + doubleValue + ". Did you mean to use a long or double instead of an int?");
        }
        String valueOf = String.valueOf(obj.getClass().getName());
        throw new ecf(new StringBuilder(String.valueOf(valueOf).length() + 41).append("Failed to convert a value of type ").append(valueOf).append(" to int").toString());
    }

    private static <T> T m13419e(Object obj, Class<T> cls) {
        cyv a = m13405a((Class) cls);
        if (obj instanceof Map) {
            return a.m13435a(m13417d(obj));
        }
        String valueOf = String.valueOf(obj.getClass().getName());
        String valueOf2 = String.valueOf(cls.getName());
        throw new ecf(new StringBuilder((String.valueOf(valueOf).length() + 38) + String.valueOf(valueOf2).length()).append("Can't convert object of type ").append(valueOf).append(" to type ").append(valueOf2).toString());
    }

    private static Long m13420f(Object obj) {
        if (obj instanceof Integer) {
            return Long.valueOf(((Integer) obj).longValue());
        }
        if (obj instanceof Long) {
            return (Long) obj;
        }
        if (obj instanceof Double) {
            Double d = (Double) obj;
            if (d.doubleValue() >= -9.223372036854776E18d && d.doubleValue() <= 9.223372036854776E18d) {
                return Long.valueOf(d.longValue());
            }
            String valueOf = String.valueOf(d);
            throw new ecf(new StringBuilder(String.valueOf(valueOf).length() + 89).append("Numeric value out of 64-bit long range: ").append(valueOf).append(". Did you mean to use a double instead of a long?").toString());
        }
        valueOf = String.valueOf(obj.getClass().getName());
        throw new ecf(new StringBuilder(String.valueOf(valueOf).length() + 42).append("Failed to convert a value of type ").append(valueOf).append(" to long").toString());
    }

    private static Double m13421g(Object obj) {
        if (obj instanceof Integer) {
            return Double.valueOf(((Integer) obj).doubleValue());
        }
        String valueOf;
        if (obj instanceof Long) {
            Long l = (Long) obj;
            Double valueOf2 = Double.valueOf(((Long) obj).doubleValue());
            if (valueOf2.longValue() == l.longValue()) {
                return valueOf2;
            }
            valueOf = String.valueOf(obj);
            throw new ecf(new StringBuilder(String.valueOf(valueOf).length() + 97).append("Loss of precision while converting number to double: ").append(valueOf).append(". Did you mean to use a 64-bit long instead?").toString());
        } else if (obj instanceof Double) {
            return (Double) obj;
        } else {
            valueOf = String.valueOf(obj.getClass().getName());
            throw new ecf(new StringBuilder(String.valueOf(valueOf).length() + 44).append("Failed to convert a value of type ").append(valueOf).append(" to double").toString());
        }
    }

    private static Boolean m13422h(Object obj) {
        if (obj instanceof Boolean) {
            return (Boolean) obj;
        }
        String valueOf = String.valueOf(obj.getClass().getName());
        throw new ecf(new StringBuilder(String.valueOf(valueOf).length() + 43).append("Failed to convert value of type ").append(valueOf).append(" to boolean").toString());
    }

    private static String m13423i(Object obj) {
        if (obj instanceof String) {
            return (String) obj;
        }
        String valueOf = String.valueOf(obj.getClass().getName());
        throw new ecf(new StringBuilder(String.valueOf(valueOf).length() + 42).append("Failed to convert value of type ").append(valueOf).append(" to String").toString());
    }
}
