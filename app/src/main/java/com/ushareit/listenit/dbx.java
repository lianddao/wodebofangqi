package com.ushareit.listenit;

import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Properties;

public final class dbx {
    static final Type[] f9507a = new Type[0];

    private static int m13751a(Object[] objArr, Object obj) {
        for (int i = 0; i < objArr.length; i++) {
            if (obj.equals(objArr[i])) {
                return i;
            }
        }
        throw new NoSuchElementException();
    }

    private static Class<?> m13752a(TypeVariable<?> typeVariable) {
        GenericDeclaration genericDeclaration = typeVariable.getGenericDeclaration();
        return genericDeclaration instanceof Class ? (Class) genericDeclaration : null;
    }

    public static GenericArrayType m13753a(Type type) {
        return new dby(type);
    }

    public static ParameterizedType m13754a(Type type, Type type2, Type... typeArr) {
        return new dbz(type, type2, typeArr);
    }

    public static Type m13755a(Type type, Class<?> cls) {
        Type b = m13762b(type, cls, Collection.class);
        if (b instanceof WildcardType) {
            b = ((WildcardType) b).getUpperBounds()[0];
        }
        return b instanceof ParameterizedType ? ((ParameterizedType) b).getActualTypeArguments()[0] : Object.class;
    }

    static Type m13756a(Type type, Class<?> cls, Class<?> cls2) {
        if (cls2 == cls) {
            return type;
        }
        if (cls2.isInterface()) {
            Class[] interfaces = cls.getInterfaces();
            int length = interfaces.length;
            for (int i = 0; i < length; i++) {
                if (interfaces[i] == cls2) {
                    return cls.getGenericInterfaces()[i];
                }
                if (cls2.isAssignableFrom(interfaces[i])) {
                    return m13756a(cls.getGenericInterfaces()[i], interfaces[i], (Class) cls2);
                }
            }
        }
        if (!cls.isInterface()) {
            Class cls3;
            while (cls3 != Object.class) {
                Class superclass = cls3.getSuperclass();
                if (superclass == cls2) {
                    return cls3.getGenericSuperclass();
                }
                if (cls2.isAssignableFrom(superclass)) {
                    return m13756a(cls3.getGenericSuperclass(), superclass, (Class) cls2);
                }
                cls3 = superclass;
            }
        }
        return cls2;
    }

    public static Type m13757a(Type type, Class<?> cls, Type type2) {
        Type type3 = type2;
        while (type3 instanceof TypeVariable) {
            type3 = (TypeVariable) type3;
            type2 = m13758a(type, (Class) cls, (TypeVariable) type3);
            if (type2 == type3) {
                return type2;
            }
            type3 = type2;
        }
        Type componentType;
        Type a;
        if ((type3 instanceof Class) && ((Class) type3).isArray()) {
            Class cls2 = (Class) type3;
            componentType = cls2.getComponentType();
            a = m13757a(type, (Class) cls, componentType);
            return componentType != a ? m13753a(a) : cls2;
        } else if (type3 instanceof GenericArrayType) {
            GenericArrayType genericArrayType = (GenericArrayType) type3;
            componentType = genericArrayType.getGenericComponentType();
            a = m13757a(type, (Class) cls, componentType);
            return componentType != a ? m13753a(a) : genericArrayType;
        } else if (type3 instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type3;
            componentType = parameterizedType.getOwnerType();
            Type a2 = m13757a(type, (Class) cls, componentType);
            int i = a2 != componentType ? 1 : 0;
            r4 = parameterizedType.getActualTypeArguments();
            int length = r4.length;
            int i2 = i;
            r1 = r4;
            for (int i3 = 0; i3 < length; i3++) {
                Type a3 = m13757a(type, (Class) cls, r1[i3]);
                if (a3 != r1[i3]) {
                    if (i2 == 0) {
                        r1 = (Type[]) r1.clone();
                        i2 = 1;
                    }
                    r1[i3] = a3;
                }
            }
            return i2 != 0 ? m13754a(a2, parameterizedType.getRawType(), r1) : parameterizedType;
        } else if (!(type3 instanceof WildcardType)) {
            return type3;
        } else {
            WildcardType wildcardType = (WildcardType) type3;
            r1 = wildcardType.getLowerBounds();
            r4 = wildcardType.getUpperBounds();
            if (r1.length == 1) {
                a = m13757a(type, (Class) cls, r1[0]);
                return a != r1[0] ? m13765c(a) : wildcardType;
            } else if (r4.length != 1) {
                return wildcardType;
            } else {
                componentType = m13757a(type, (Class) cls, r4[0]);
                return componentType != r4[0] ? m13763b(componentType) : wildcardType;
            }
        }
    }

    static Type m13758a(Type type, Class<?> cls, TypeVariable<?> typeVariable) {
        Class a = m13752a((TypeVariable) typeVariable);
        if (a == null) {
            return typeVariable;
        }
        Type a2 = m13756a(type, (Class) cls, a);
        if (!(a2 instanceof ParameterizedType)) {
            return typeVariable;
        }
        return ((ParameterizedType) a2).getActualTypeArguments()[m13751a(a.getTypeParameters(), (Object) typeVariable)];
    }

    static boolean m13759a(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public static boolean m13760a(Type type, Type type2) {
        boolean z = true;
        if (type == type2) {
            return true;
        }
        if (type instanceof Class) {
            return type.equals(type2);
        }
        if (type instanceof ParameterizedType) {
            if (!(type2 instanceof ParameterizedType)) {
                return false;
            }
            ParameterizedType parameterizedType = (ParameterizedType) type;
            ParameterizedType parameterizedType2 = (ParameterizedType) type2;
            if (!(m13759a(parameterizedType.getOwnerType(), parameterizedType2.getOwnerType()) && parameterizedType.getRawType().equals(parameterizedType2.getRawType()) && Arrays.equals(parameterizedType.getActualTypeArguments(), parameterizedType2.getActualTypeArguments()))) {
                z = false;
            }
            return z;
        } else if (type instanceof GenericArrayType) {
            if (!(type2 instanceof GenericArrayType)) {
                return false;
            }
            return m13760a(((GenericArrayType) type).getGenericComponentType(), ((GenericArrayType) type2).getGenericComponentType());
        } else if (type instanceof WildcardType) {
            if (!(type2 instanceof WildcardType)) {
                return false;
            }
            WildcardType wildcardType = (WildcardType) type;
            WildcardType wildcardType2 = (WildcardType) type2;
            if (!(Arrays.equals(wildcardType.getUpperBounds(), wildcardType2.getUpperBounds()) && Arrays.equals(wildcardType.getLowerBounds(), wildcardType2.getLowerBounds()))) {
                z = false;
            }
            return z;
        } else if (!(type instanceof TypeVariable) || !(type2 instanceof TypeVariable)) {
            return false;
        } else {
            TypeVariable typeVariable = (TypeVariable) type;
            TypeVariable typeVariable2 = (TypeVariable) type2;
            if (!(typeVariable.getGenericDeclaration() == typeVariable2.getGenericDeclaration() && typeVariable.getName().equals(typeVariable2.getName()))) {
                z = false;
            }
            return z;
        }
    }

    private static int m13761b(Object obj) {
        return obj != null ? obj.hashCode() : 0;
    }

    static Type m13762b(Type type, Class<?> cls, Class<?> cls2) {
        dbw.m13749a(cls2.isAssignableFrom(cls));
        return m13757a(type, (Class) cls, m13756a(type, (Class) cls, (Class) cls2));
    }

    public static WildcardType m13763b(Type type) {
        return new dca(new Type[]{type}, f9507a);
    }

    public static Type[] m13764b(Type type, Class<?> cls) {
        if (type == Properties.class) {
            return new Type[]{String.class, String.class};
        }
        Type b = m13762b(type, cls, Map.class);
        if (b instanceof ParameterizedType) {
            return ((ParameterizedType) b).getActualTypeArguments();
        }
        return new Type[]{Object.class, Object.class};
    }

    public static WildcardType m13765c(Type type) {
        return new dca(new Type[]{Object.class}, new Type[]{type});
    }

    public static Type m13766d(Type type) {
        if (type instanceof Class) {
            dby com_ushareit_listenit_dby;
            Class cls = (Class) type;
            if (cls.isArray()) {
                com_ushareit_listenit_dby = new dby(m13766d(cls.getComponentType()));
            } else {
                Object obj = cls;
            }
            return com_ushareit_listenit_dby;
        } else if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            return new dbz(parameterizedType.getOwnerType(), parameterizedType.getRawType(), parameterizedType.getActualTypeArguments());
        } else if (type instanceof GenericArrayType) {
            return new dby(((GenericArrayType) type).getGenericComponentType());
        } else {
            if (!(type instanceof WildcardType)) {
                return type;
            }
            WildcardType wildcardType = (WildcardType) type;
            return new dca(wildcardType.getUpperBounds(), wildcardType.getLowerBounds());
        }
    }

    public static Class<?> m13767e(Type type) {
        if (type instanceof Class) {
            return (Class) type;
        }
        if (type instanceof ParameterizedType) {
            Type rawType = ((ParameterizedType) type).getRawType();
            dbw.m13749a(rawType instanceof Class);
            return (Class) rawType;
        } else if (type instanceof GenericArrayType) {
            return Array.newInstance(m13767e(((GenericArrayType) type).getGenericComponentType()), 0).getClass();
        } else {
            if (type instanceof TypeVariable) {
                return Object.class;
            }
            if (type instanceof WildcardType) {
                return m13767e(((WildcardType) type).getUpperBounds()[0]);
            }
            String name = type == null ? "null" : type.getClass().getName();
            String valueOf = String.valueOf("Expected a Class, ParameterizedType, or GenericArrayType, but <");
            String valueOf2 = String.valueOf(type);
            throw new IllegalArgumentException(new StringBuilder(((String.valueOf(valueOf).length() + 13) + String.valueOf(valueOf2).length()) + String.valueOf(name).length()).append(valueOf).append(valueOf2).append("> is of type ").append(name).toString());
        }
    }

    public static String m13768f(Type type) {
        return type instanceof Class ? ((Class) type).getName() : type.toString();
    }

    public static Type m13769g(Type type) {
        return type instanceof GenericArrayType ? ((GenericArrayType) type).getGenericComponentType() : ((Class) type).getComponentType();
    }

    private static void m13771i(Type type) {
        boolean z = ((type instanceof Class) && ((Class) type).isPrimitive()) ? false : true;
        dbw.m13749a(z);
    }
}
