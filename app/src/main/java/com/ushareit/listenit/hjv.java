package com.ushareit.listenit;

import java.util.HashMap;
import java.util.Map;

public final class hjv {
    static final Throwable m23978a(Object[] objArr) {
        if (objArr == null || objArr.length == 0) {
            return null;
        }
        Object obj = objArr[objArr.length - 1];
        return obj instanceof Throwable ? (Throwable) obj : null;
    }

    public static final hjt m23976a(String str, Object[] objArr) {
        Throwable a = m23978a(objArr);
        if (a != null) {
            objArr = m23992b(objArr);
        }
        return m23977a(str, objArr, a);
    }

    private static Object[] m23992b(Object[] objArr) {
        if (objArr == null || objArr.length == 0) {
            throw new IllegalStateException("non-sensical empty or null argument array");
        }
        int length = objArr.length - 1;
        Object obj = new Object[length];
        System.arraycopy(objArr, 0, obj, 0, length);
        return obj;
    }

    public static final hjt m23977a(String str, Object[] objArr, Throwable th) {
        int i = 0;
        if (str == null) {
            return new hjt(null, objArr, th);
        }
        if (objArr == null) {
            return new hjt(str);
        }
        StringBuilder stringBuilder = new StringBuilder(str.length() + 50);
        int i2 = 0;
        while (i < objArr.length) {
            int indexOf = str.indexOf("{}", i2);
            if (indexOf != -1) {
                if (!m23990a(str, indexOf)) {
                    stringBuilder.append(str, i2, indexOf);
                    m23980a(stringBuilder, objArr[i], new HashMap());
                    i2 = indexOf + 2;
                } else if (m23991b(str, indexOf)) {
                    stringBuilder.append(str, i2, indexOf - 1);
                    m23980a(stringBuilder, objArr[i], new HashMap());
                    i2 = indexOf + 2;
                } else {
                    i--;
                    stringBuilder.append(str, i2, indexOf - 1);
                    stringBuilder.append('{');
                    i2 = indexOf + 1;
                }
                i++;
            } else if (i2 == 0) {
                return new hjt(str, objArr, th);
            } else {
                stringBuilder.append(str, i2, str.length());
                return new hjt(stringBuilder.toString(), objArr, th);
            }
        }
        stringBuilder.append(str, i2, str.length());
        return new hjt(stringBuilder.toString(), objArr, th);
    }

    static final boolean m23990a(String str, int i) {
        if (i != 0 && str.charAt(i - 1) == '\\') {
            return true;
        }
        return false;
    }

    static final boolean m23991b(String str, int i) {
        if (i < 2 || str.charAt(i - 2) != '\\') {
            return false;
        }
        return true;
    }

    private static void m23980a(StringBuilder stringBuilder, Object obj, Map<Object[], Object> map) {
        if (obj == null) {
            stringBuilder.append("null");
        } else if (!obj.getClass().isArray()) {
            m23979a(stringBuilder, obj);
        } else if (obj instanceof boolean[]) {
            m23989a(stringBuilder, (boolean[]) obj);
        } else if (obj instanceof byte[]) {
            m23981a(stringBuilder, (byte[]) obj);
        } else if (obj instanceof char[]) {
            m23982a(stringBuilder, (char[]) obj);
        } else if (obj instanceof short[]) {
            m23988a(stringBuilder, (short[]) obj);
        } else if (obj instanceof int[]) {
            m23985a(stringBuilder, (int[]) obj);
        } else if (obj instanceof long[]) {
            m23986a(stringBuilder, (long[]) obj);
        } else if (obj instanceof float[]) {
            m23984a(stringBuilder, (float[]) obj);
        } else if (obj instanceof double[]) {
            m23983a(stringBuilder, (double[]) obj);
        } else {
            m23987a(stringBuilder, (Object[]) obj, (Map) map);
        }
    }

    private static void m23979a(StringBuilder stringBuilder, Object obj) {
        try {
            stringBuilder.append(obj.toString());
        } catch (Throwable th) {
            hkb.m24024a("SLF4J: Failed toString() invocation on an object of type [" + obj.getClass().getName() + "]", th);
            stringBuilder.append("[FAILED toString()]");
        }
    }

    private static void m23987a(StringBuilder stringBuilder, Object[] objArr, Map<Object[], Object> map) {
        stringBuilder.append('[');
        if (map.containsKey(objArr)) {
            stringBuilder.append("...");
        } else {
            map.put(objArr, null);
            int length = objArr.length;
            for (int i = 0; i < length; i++) {
                m23980a(stringBuilder, objArr[i], (Map) map);
                if (i != length - 1) {
                    stringBuilder.append(", ");
                }
            }
            map.remove(objArr);
        }
        stringBuilder.append(']');
    }

    private static void m23989a(StringBuilder stringBuilder, boolean[] zArr) {
        stringBuilder.append('[');
        int length = zArr.length;
        for (int i = 0; i < length; i++) {
            stringBuilder.append(zArr[i]);
            if (i != length - 1) {
                stringBuilder.append(", ");
            }
        }
        stringBuilder.append(']');
    }

    private static void m23981a(StringBuilder stringBuilder, byte[] bArr) {
        stringBuilder.append('[');
        int length = bArr.length;
        for (int i = 0; i < length; i++) {
            stringBuilder.append(bArr[i]);
            if (i != length - 1) {
                stringBuilder.append(", ");
            }
        }
        stringBuilder.append(']');
    }

    private static void m23982a(StringBuilder stringBuilder, char[] cArr) {
        stringBuilder.append('[');
        int length = cArr.length;
        for (int i = 0; i < length; i++) {
            stringBuilder.append(cArr[i]);
            if (i != length - 1) {
                stringBuilder.append(", ");
            }
        }
        stringBuilder.append(']');
    }

    private static void m23988a(StringBuilder stringBuilder, short[] sArr) {
        stringBuilder.append('[');
        int length = sArr.length;
        for (int i = 0; i < length; i++) {
            stringBuilder.append(sArr[i]);
            if (i != length - 1) {
                stringBuilder.append(", ");
            }
        }
        stringBuilder.append(']');
    }

    private static void m23985a(StringBuilder stringBuilder, int[] iArr) {
        stringBuilder.append('[');
        int length = iArr.length;
        for (int i = 0; i < length; i++) {
            stringBuilder.append(iArr[i]);
            if (i != length - 1) {
                stringBuilder.append(", ");
            }
        }
        stringBuilder.append(']');
    }

    private static void m23986a(StringBuilder stringBuilder, long[] jArr) {
        stringBuilder.append('[');
        int length = jArr.length;
        for (int i = 0; i < length; i++) {
            stringBuilder.append(jArr[i]);
            if (i != length - 1) {
                stringBuilder.append(", ");
            }
        }
        stringBuilder.append(']');
    }

    private static void m23984a(StringBuilder stringBuilder, float[] fArr) {
        stringBuilder.append('[');
        int length = fArr.length;
        for (int i = 0; i < length; i++) {
            stringBuilder.append(fArr[i]);
            if (i != length - 1) {
                stringBuilder.append(", ");
            }
        }
        stringBuilder.append(']');
    }

    private static void m23983a(StringBuilder stringBuilder, double[] dArr) {
        stringBuilder.append('[');
        int length = dArr.length;
        for (int i = 0; i < length; i++) {
            stringBuilder.append(dArr[i]);
            if (i != length - 1) {
                stringBuilder.append(", ");
            }
        }
        stringBuilder.append(']');
    }
}
