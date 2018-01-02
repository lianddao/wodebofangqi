package com.ushareit.listenit;

public final class dgl {
    public static final int[] f9779a = new int[0];
    public static final long[] f9780b = new long[0];
    public static final float[] f9781c = new float[0];
    public static final double[] f9782d = new double[0];
    public static final boolean[] f9783e = new boolean[0];
    public static final String[] f9784f = new String[0];
    public static final byte[][] f9785g = new byte[0][];
    public static final byte[] f9786h = new byte[0];

    static int m14261a(int i) {
        return i & 7;
    }

    public static int m14262a(int i, int i2) {
        return (i << 3) | i2;
    }

    public static boolean m14263a(dfz com_ushareit_listenit_dfz, int i) {
        return com_ushareit_listenit_dfz.m14131b(i);
    }

    public static int m14264b(int i) {
        return i >>> 3;
    }

    public static final int m14265b(dfz com_ushareit_listenit_dfz, int i) {
        int i2 = 1;
        int r = com_ushareit_listenit_dfz.m14151r();
        com_ushareit_listenit_dfz.m14131b(i);
        while (com_ushareit_listenit_dfz.m14126a() == i) {
            com_ushareit_listenit_dfz.m14131b(i);
            i2++;
        }
        com_ushareit_listenit_dfz.m14137e(r);
        return i2;
    }
}
