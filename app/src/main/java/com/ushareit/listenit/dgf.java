package com.ushareit.listenit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class dgf implements Cloneable {
    private dgd<?, ?> f9771a;
    private Object f9772b;
    private List<dgk> f9773c = new ArrayList();

    dgf() {
    }

    private byte[] m14236c() {
        byte[] bArr = new byte[m14237a()];
        m14238a(dga.m14159a(bArr));
        return bArr;
    }

    int m14237a() {
        if (this.f9772b != null) {
            return this.f9771a.m14219a(this.f9772b);
        }
        int i = 0;
        for (dgk a : this.f9773c) {
            i = a.m14259a() + i;
        }
        return i;
    }

    void m14238a(dga com_ushareit_listenit_dga) {
        if (this.f9772b != null) {
            this.f9771a.m14220a(this.f9772b, com_ushareit_listenit_dga);
            return;
        }
        for (dgk a : this.f9773c) {
            a.m14260a(com_ushareit_listenit_dga);
        }
    }

    void m14239a(dgk com_ushareit_listenit_dgk) {
        this.f9773c.add(com_ushareit_listenit_dgk);
    }

    public final dgf m14240b() {
        dgf com_ushareit_listenit_dgf = new dgf();
        try {
            com_ushareit_listenit_dgf.f9771a = this.f9771a;
            if (this.f9773c == null) {
                com_ushareit_listenit_dgf.f9773c = null;
            } else {
                com_ushareit_listenit_dgf.f9773c.addAll(this.f9773c);
            }
            if (this.f9772b != null) {
                if (this.f9772b instanceof dgi) {
                    com_ushareit_listenit_dgf.f9772b = (dgi) ((dgi) this.f9772b).clone();
                } else if (this.f9772b instanceof byte[]) {
                    com_ushareit_listenit_dgf.f9772b = ((byte[]) this.f9772b).clone();
                } else if (this.f9772b instanceof byte[][]) {
                    byte[][] bArr = (byte[][]) this.f9772b;
                    r4 = new byte[bArr.length][];
                    com_ushareit_listenit_dgf.f9772b = r4;
                    for (r2 = 0; r2 < bArr.length; r2++) {
                        r4[r2] = (byte[]) bArr[r2].clone();
                    }
                } else if (this.f9772b instanceof boolean[]) {
                    com_ushareit_listenit_dgf.f9772b = ((boolean[]) this.f9772b).clone();
                } else if (this.f9772b instanceof int[]) {
                    com_ushareit_listenit_dgf.f9772b = ((int[]) this.f9772b).clone();
                } else if (this.f9772b instanceof long[]) {
                    com_ushareit_listenit_dgf.f9772b = ((long[]) this.f9772b).clone();
                } else if (this.f9772b instanceof float[]) {
                    com_ushareit_listenit_dgf.f9772b = ((float[]) this.f9772b).clone();
                } else if (this.f9772b instanceof double[]) {
                    com_ushareit_listenit_dgf.f9772b = ((double[]) this.f9772b).clone();
                } else if (this.f9772b instanceof dgi[]) {
                    dgi[] com_ushareit_listenit_dgiArr = (dgi[]) this.f9772b;
                    r4 = new dgi[com_ushareit_listenit_dgiArr.length];
                    com_ushareit_listenit_dgf.f9772b = r4;
                    for (r2 = 0; r2 < com_ushareit_listenit_dgiArr.length; r2++) {
                        r4[r2] = (dgi) com_ushareit_listenit_dgiArr[r2].clone();
                    }
                }
            }
            return com_ushareit_listenit_dgf;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    public /* synthetic */ Object clone() {
        return m14240b();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof dgf)) {
            return false;
        }
        dgf com_ushareit_listenit_dgf = (dgf) obj;
        if (this.f9772b != null && com_ushareit_listenit_dgf.f9772b != null) {
            return this.f9771a == com_ushareit_listenit_dgf.f9771a ? !this.f9771a.f9763b.isArray() ? this.f9772b.equals(com_ushareit_listenit_dgf.f9772b) : this.f9772b instanceof byte[] ? Arrays.equals((byte[]) this.f9772b, (byte[]) com_ushareit_listenit_dgf.f9772b) : this.f9772b instanceof int[] ? Arrays.equals((int[]) this.f9772b, (int[]) com_ushareit_listenit_dgf.f9772b) : this.f9772b instanceof long[] ? Arrays.equals((long[]) this.f9772b, (long[]) com_ushareit_listenit_dgf.f9772b) : this.f9772b instanceof float[] ? Arrays.equals((float[]) this.f9772b, (float[]) com_ushareit_listenit_dgf.f9772b) : this.f9772b instanceof double[] ? Arrays.equals((double[]) this.f9772b, (double[]) com_ushareit_listenit_dgf.f9772b) : this.f9772b instanceof boolean[] ? Arrays.equals((boolean[]) this.f9772b, (boolean[]) com_ushareit_listenit_dgf.f9772b) : Arrays.deepEquals((Object[]) this.f9772b, (Object[]) com_ushareit_listenit_dgf.f9772b) : false;
        } else {
            if (this.f9773c != null && com_ushareit_listenit_dgf.f9773c != null) {
                return this.f9773c.equals(com_ushareit_listenit_dgf.f9773c);
            }
            try {
                return Arrays.equals(m14236c(), com_ushareit_listenit_dgf.m14236c());
            } catch (Throwable e) {
                throw new IllegalStateException(e);
            }
        }
    }

    public int hashCode() {
        try {
            return Arrays.hashCode(m14236c()) + 527;
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
    }
}
