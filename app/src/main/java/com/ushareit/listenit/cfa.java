package com.ushareit.listenit;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.ArrayList;

public class cfa {
    public static int m11014a(int i) {
        return 65535 & i;
    }

    public static int m11015a(Parcel parcel) {
        return parcel.readInt();
    }

    public static int m11016a(Parcel parcel, int i) {
        return (i & -65536) != -65536 ? (i >> 16) & 65535 : parcel.readInt();
    }

    public static <T extends Parcelable> T m11017a(Parcel parcel, int i, Creator<T> creator) {
        int a = m11016a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        Parcelable parcelable = (Parcelable) creator.createFromParcel(parcel);
        parcel.setDataPosition(a + dataPosition);
        return parcelable;
    }

    private static void m11018a(Parcel parcel, int i, int i2) {
        int a = m11016a(parcel, i);
        if (a != i2) {
            String valueOf = String.valueOf(Integer.toHexString(a));
            throw new cfb(new StringBuilder(String.valueOf(valueOf).length() + 46).append("Expected size ").append(i2).append(" got ").append(a).append(" (0x").append(valueOf).append(")").toString(), parcel);
        }
    }

    private static void m11019a(Parcel parcel, int i, int i2, int i3) {
        if (i2 != i3) {
            String valueOf = String.valueOf(Integer.toHexString(i2));
            throw new cfb(new StringBuilder(String.valueOf(valueOf).length() + 46).append("Expected size ").append(i3).append(" got ").append(i2).append(" (0x").append(valueOf).append(")").toString(), parcel);
        }
    }

    public static int m11020b(Parcel parcel) {
        int a = m11015a(parcel);
        int a2 = m11016a(parcel, a);
        int dataPosition = parcel.dataPosition();
        if (m11014a(a) != 20293) {
            String str = "Expected object header. Got 0x";
            String valueOf = String.valueOf(Integer.toHexString(a));
            throw new cfb(valueOf.length() != 0 ? str.concat(valueOf) : new String(str), parcel);
        }
        a = dataPosition + a2;
        if (a >= dataPosition && a <= parcel.dataSize()) {
            return a;
        }
        throw new cfb("Size read is invalid start=" + dataPosition + " end=" + a, parcel);
    }

    public static void m11021b(Parcel parcel, int i) {
        parcel.setDataPosition(m11016a(parcel, i) + parcel.dataPosition());
    }

    public static <T> T[] m11022b(Parcel parcel, int i, Creator<T> creator) {
        int a = m11016a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        T[] createTypedArray = parcel.createTypedArray(creator);
        parcel.setDataPosition(a + dataPosition);
        return createTypedArray;
    }

    public static <T> ArrayList<T> m11023c(Parcel parcel, int i, Creator<T> creator) {
        int a = m11016a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        ArrayList<T> createTypedArrayList = parcel.createTypedArrayList(creator);
        parcel.setDataPosition(a + dataPosition);
        return createTypedArrayList;
    }

    public static boolean m11024c(Parcel parcel, int i) {
        m11018a(parcel, i, 4);
        return parcel.readInt() != 0;
    }

    public static short m11025d(Parcel parcel, int i) {
        m11018a(parcel, i, 4);
        return (short) parcel.readInt();
    }

    public static int m11026e(Parcel parcel, int i) {
        m11018a(parcel, i, 4);
        return parcel.readInt();
    }

    public static Integer m11027f(Parcel parcel, int i) {
        int a = m11016a(parcel, i);
        if (a == 0) {
            return null;
        }
        m11019a(parcel, i, a, 4);
        return Integer.valueOf(parcel.readInt());
    }

    public static long m11028g(Parcel parcel, int i) {
        m11018a(parcel, i, 8);
        return parcel.readLong();
    }

    public static Long m11029h(Parcel parcel, int i) {
        int a = m11016a(parcel, i);
        if (a == 0) {
            return null;
        }
        m11019a(parcel, i, a, 8);
        return Long.valueOf(parcel.readLong());
    }

    public static float m11030i(Parcel parcel, int i) {
        m11018a(parcel, i, 4);
        return parcel.readFloat();
    }

    public static Float m11031j(Parcel parcel, int i) {
        int a = m11016a(parcel, i);
        if (a == 0) {
            return null;
        }
        m11019a(parcel, i, a, 4);
        return Float.valueOf(parcel.readFloat());
    }

    public static double m11032k(Parcel parcel, int i) {
        m11018a(parcel, i, 8);
        return parcel.readDouble();
    }

    public static Double m11033l(Parcel parcel, int i) {
        int a = m11016a(parcel, i);
        if (a == 0) {
            return null;
        }
        m11019a(parcel, i, a, 8);
        return Double.valueOf(parcel.readDouble());
    }

    public static String m11034m(Parcel parcel, int i) {
        int a = m11016a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        String readString = parcel.readString();
        parcel.setDataPosition(a + dataPosition);
        return readString;
    }

    public static IBinder m11035n(Parcel parcel, int i) {
        int a = m11016a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        IBinder readStrongBinder = parcel.readStrongBinder();
        parcel.setDataPosition(a + dataPosition);
        return readStrongBinder;
    }

    public static Bundle m11036o(Parcel parcel, int i) {
        int a = m11016a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        Bundle readBundle = parcel.readBundle();
        parcel.setDataPosition(a + dataPosition);
        return readBundle;
    }

    public static byte[] m11037p(Parcel parcel, int i) {
        int a = m11016a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        byte[] createByteArray = parcel.createByteArray();
        parcel.setDataPosition(a + dataPosition);
        return createByteArray;
    }

    public static int[] m11038q(Parcel parcel, int i) {
        int a = m11016a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        int[] createIntArray = parcel.createIntArray();
        parcel.setDataPosition(a + dataPosition);
        return createIntArray;
    }

    public static String[] m11039r(Parcel parcel, int i) {
        int a = m11016a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        String[] createStringArray = parcel.createStringArray();
        parcel.setDataPosition(a + dataPosition);
        return createStringArray;
    }

    public static ArrayList<Integer> m11040s(Parcel parcel, int i) {
        int a = m11016a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        ArrayList<Integer> arrayList = new ArrayList();
        int readInt = parcel.readInt();
        for (int i2 = 0; i2 < readInt; i2++) {
            arrayList.add(Integer.valueOf(parcel.readInt()));
        }
        parcel.setDataPosition(dataPosition + a);
        return arrayList;
    }

    public static ArrayList<String> m11041t(Parcel parcel, int i) {
        int a = m11016a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        ArrayList<String> createStringArrayList = parcel.createStringArrayList();
        parcel.setDataPosition(a + dataPosition);
        return createStringArrayList;
    }
}
