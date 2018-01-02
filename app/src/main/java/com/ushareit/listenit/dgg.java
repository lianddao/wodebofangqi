package com.ushareit.listenit;

import java.nio.charset.Charset;
import java.util.Arrays;

public final class dgg {
    protected static final Charset f9774a = Charset.forName("UTF-8");
    protected static final Charset f9775b = Charset.forName("ISO-8859-1");
    public static final Object f9776c = new Object();

    public static int m14241a(long[] jArr) {
        return (jArr == null || jArr.length == 0) ? 0 : Arrays.hashCode(jArr);
    }

    public static int m14242a(Object[] objArr) {
        int i = 0;
        int length = objArr == null ? 0 : objArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            Object obj = objArr[i2];
            if (obj != null) {
                i = (i * 31) + obj.hashCode();
            }
        }
        return i;
    }

    public static void m14243a(dgc com_ushareit_listenit_dgc, dgc com_ushareit_listenit_dgc2) {
        if (com_ushareit_listenit_dgc.f9406f != null) {
            com_ushareit_listenit_dgc2.f9406f = (dge) com_ushareit_listenit_dgc.f9406f.clone();
        }
    }

    public static boolean m14244a(long[] jArr, long[] jArr2) {
        return (jArr == null || jArr.length == 0) ? jArr2 == null || jArr2.length == 0 : Arrays.equals(jArr, jArr2);
    }

    public static boolean m14245a(Object[] objArr, Object[] objArr2) {
        boolean length = objArr == null ? false : objArr.length;
        int length2 = objArr2 == null ? 0 : objArr2.length;
        int i = 0;
        boolean z = false;
        while (true) {
            if (z >= length || objArr[z] != null) {
                int i2 = i;
                while (i2 < length2 && objArr2[i2] == null) {
                    i2++;
                }
                boolean z2 = z >= length;
                boolean z3 = i2 >= length2;
                if (z2 && z3) {
                    return true;
                }
                if (z2 != z3 || !objArr[z].equals(objArr2[i2])) {
                    return false;
                }
                i = i2 + 1;
                z++;
            } else {
                z++;
            }
        }
    }
}
