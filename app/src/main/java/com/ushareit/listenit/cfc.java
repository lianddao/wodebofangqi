package com.ushareit.listenit;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

public class cfc {
    public static int m11042a(Parcel parcel) {
        return m11064b(parcel, 20293);
    }

    public static void m11043a(Parcel parcel, int i) {
        m11067c(parcel, i);
    }

    public static void m11044a(Parcel parcel, int i, double d) {
        m11065b(parcel, i, 8);
        parcel.writeDouble(d);
    }

    public static void m11045a(Parcel parcel, int i, float f) {
        m11065b(parcel, i, 4);
        parcel.writeFloat(f);
    }

    public static void m11046a(Parcel parcel, int i, int i2) {
        m11065b(parcel, i, 4);
        parcel.writeInt(i2);
    }

    public static void m11047a(Parcel parcel, int i, long j) {
        m11065b(parcel, i, 8);
        parcel.writeLong(j);
    }

    public static void m11048a(Parcel parcel, int i, Bundle bundle, boolean z) {
        if (bundle != null) {
            int b = m11064b(parcel, i);
            parcel.writeBundle(bundle);
            m11067c(parcel, b);
        } else if (z) {
            m11065b(parcel, i, 0);
        }
    }

    public static void m11049a(Parcel parcel, int i, IBinder iBinder, boolean z) {
        if (iBinder != null) {
            int b = m11064b(parcel, i);
            parcel.writeStrongBinder(iBinder);
            m11067c(parcel, b);
        } else if (z) {
            m11065b(parcel, i, 0);
        }
    }

    public static void m11050a(Parcel parcel, int i, Parcelable parcelable, int i2, boolean z) {
        if (parcelable != null) {
            int b = m11064b(parcel, i);
            parcelable.writeToParcel(parcel, i2);
            m11067c(parcel, b);
        } else if (z) {
            m11065b(parcel, i, 0);
        }
    }

    public static void m11051a(Parcel parcel, int i, Double d, boolean z) {
        if (d != null) {
            m11065b(parcel, i, 8);
            parcel.writeDouble(d.doubleValue());
        } else if (z) {
            m11065b(parcel, i, 0);
        }
    }

    public static void m11052a(Parcel parcel, int i, Float f, boolean z) {
        if (f != null) {
            m11065b(parcel, i, 4);
            parcel.writeFloat(f.floatValue());
        } else if (z) {
            m11065b(parcel, i, 0);
        }
    }

    public static void m11053a(Parcel parcel, int i, Integer num, boolean z) {
        if (num != null) {
            m11065b(parcel, i, 4);
            parcel.writeInt(num.intValue());
        } else if (z) {
            m11065b(parcel, i, 0);
        }
    }

    public static void m11054a(Parcel parcel, int i, Long l, boolean z) {
        if (l != null) {
            m11065b(parcel, i, 8);
            parcel.writeLong(l.longValue());
        } else if (z) {
            m11065b(parcel, i, 0);
        }
    }

    public static void m11055a(Parcel parcel, int i, String str, boolean z) {
        if (str != null) {
            int b = m11064b(parcel, i);
            parcel.writeString(str);
            m11067c(parcel, b);
        } else if (z) {
            m11065b(parcel, i, 0);
        }
    }

    public static void m11056a(Parcel parcel, int i, List<Integer> list, boolean z) {
        if (list != null) {
            int b = m11064b(parcel, i);
            int size = list.size();
            parcel.writeInt(size);
            for (int i2 = 0; i2 < size; i2++) {
                parcel.writeInt(((Integer) list.get(i2)).intValue());
            }
            m11067c(parcel, b);
        } else if (z) {
            m11065b(parcel, i, 0);
        }
    }

    public static void m11057a(Parcel parcel, int i, short s) {
        m11065b(parcel, i, 4);
        parcel.writeInt(s);
    }

    public static void m11058a(Parcel parcel, int i, boolean z) {
        m11065b(parcel, i, 4);
        parcel.writeInt(z ? 1 : 0);
    }

    public static void m11059a(Parcel parcel, int i, byte[] bArr, boolean z) {
        if (bArr != null) {
            int b = m11064b(parcel, i);
            parcel.writeByteArray(bArr);
            m11067c(parcel, b);
        } else if (z) {
            m11065b(parcel, i, 0);
        }
    }

    public static void m11060a(Parcel parcel, int i, int[] iArr, boolean z) {
        if (iArr != null) {
            int b = m11064b(parcel, i);
            parcel.writeIntArray(iArr);
            m11067c(parcel, b);
        } else if (z) {
            m11065b(parcel, i, 0);
        }
    }

    public static <T extends Parcelable> void m11061a(Parcel parcel, int i, T[] tArr, int i2, boolean z) {
        if (tArr != null) {
            int b = m11064b(parcel, i);
            parcel.writeInt(r3);
            for (Parcelable parcelable : tArr) {
                if (parcelable == null) {
                    parcel.writeInt(0);
                } else {
                    m11063a(parcel, parcelable, i2);
                }
            }
            m11067c(parcel, b);
        } else if (z) {
            m11065b(parcel, i, 0);
        }
    }

    public static void m11062a(Parcel parcel, int i, String[] strArr, boolean z) {
        if (strArr != null) {
            int b = m11064b(parcel, i);
            parcel.writeStringArray(strArr);
            m11067c(parcel, b);
        } else if (z) {
            m11065b(parcel, i, 0);
        }
    }

    private static <T extends Parcelable> void m11063a(Parcel parcel, T t, int i) {
        int dataPosition = parcel.dataPosition();
        parcel.writeInt(1);
        int dataPosition2 = parcel.dataPosition();
        t.writeToParcel(parcel, i);
        int dataPosition3 = parcel.dataPosition();
        parcel.setDataPosition(dataPosition);
        parcel.writeInt(dataPosition3 - dataPosition2);
        parcel.setDataPosition(dataPosition3);
    }

    private static int m11064b(Parcel parcel, int i) {
        parcel.writeInt(-65536 | i);
        parcel.writeInt(0);
        return parcel.dataPosition();
    }

    private static void m11065b(Parcel parcel, int i, int i2) {
        if (i2 >= 65535) {
            parcel.writeInt(-65536 | i);
            parcel.writeInt(i2);
            return;
        }
        parcel.writeInt((i2 << 16) | i);
    }

    public static void m11066b(Parcel parcel, int i, List<String> list, boolean z) {
        if (list != null) {
            int b = m11064b(parcel, i);
            parcel.writeStringList(list);
            m11067c(parcel, b);
        } else if (z) {
            m11065b(parcel, i, 0);
        }
    }

    private static void m11067c(Parcel parcel, int i) {
        int dataPosition = parcel.dataPosition();
        int i2 = dataPosition - i;
        parcel.setDataPosition(i - 4);
        parcel.writeInt(i2);
        parcel.setDataPosition(dataPosition);
    }

    public static <T extends Parcelable> void m11068c(Parcel parcel, int i, List<T> list, boolean z) {
        if (list != null) {
            int b = m11064b(parcel, i);
            int size = list.size();
            parcel.writeInt(size);
            for (int i2 = 0; i2 < size; i2++) {
                Parcelable parcelable = (Parcelable) list.get(i2);
                if (parcelable == null) {
                    parcel.writeInt(0);
                } else {
                    m11063a(parcel, parcelable, 0);
                }
            }
            m11067c(parcel, b);
        } else if (z) {
            m11065b(parcel, i, 0);
        }
    }
}
