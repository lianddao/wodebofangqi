package com.ushareit.listenit;

import java.math.BigInteger;

public final class dbg extends dba {
    private static final Class<?>[] f9491a = new Class[]{Integer.TYPE, Long.TYPE, Short.TYPE, Float.TYPE, Double.TYPE, Byte.TYPE, Boolean.TYPE, Character.TYPE, Integer.class, Long.class, Short.class, Float.class, Double.class, Byte.class, Boolean.class, Character.class};
    private Object f9492b;

    public dbg(Boolean bool) {
        m13725a((Object) bool);
    }

    public dbg(Number number) {
        m13725a((Object) number);
    }

    dbg(Object obj) {
        m13725a(obj);
    }

    public dbg(String str) {
        m13725a((Object) str);
    }

    private static boolean m13723a(dbg com_ushareit_listenit_dbg) {
        if (!(com_ushareit_listenit_dbg.f9492b instanceof Number)) {
            return false;
        }
        Number number = (Number) com_ushareit_listenit_dbg.f9492b;
        return (number instanceof BigInteger) || (number instanceof Long) || (number instanceof Integer) || (number instanceof Short) || (number instanceof Byte);
    }

    private static boolean m13724b(Object obj) {
        if (obj instanceof String) {
            return true;
        }
        Class cls = obj.getClass();
        for (Class isAssignableFrom : f9491a) {
            if (isAssignableFrom.isAssignableFrom(cls)) {
                return true;
            }
        }
        return false;
    }

    void m13725a(Object obj) {
        if (obj instanceof Character) {
            this.f9492b = String.valueOf(((Character) obj).charValue());
            return;
        }
        boolean z = (obj instanceof Number) || m13724b(obj);
        dbw.m13749a(z);
        this.f9492b = obj;
    }

    public boolean m13726a() {
        return this.f9492b instanceof Boolean;
    }

    public Number mo1702b() {
        return this.f9492b instanceof String ? new dcr((String) this.f9492b) : (Number) this.f9492b;
    }

    public String mo1703c() {
        return m13734p() ? mo1702b().toString() : m13726a() ? mo1708o().toString() : (String) this.f9492b;
    }

    public double mo1704d() {
        return m13734p() ? mo1702b().doubleValue() : Double.parseDouble(mo1703c());
    }

    public long mo1705e() {
        return m13734p() ? mo1702b().longValue() : Long.parseLong(mo1703c());
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        dbg com_ushareit_listenit_dbg = (dbg) obj;
        if (this.f9492b == null) {
            return com_ushareit_listenit_dbg.f9492b == null;
        } else {
            if (m13723a(this) && m13723a(com_ushareit_listenit_dbg)) {
                return mo1702b().longValue() == com_ushareit_listenit_dbg.mo1702b().longValue();
            } else {
                if (!(this.f9492b instanceof Number) || !(com_ushareit_listenit_dbg.f9492b instanceof Number)) {
                    return this.f9492b.equals(com_ushareit_listenit_dbg.f9492b);
                }
                double doubleValue = mo1702b().doubleValue();
                double doubleValue2 = com_ushareit_listenit_dbg.mo1702b().doubleValue();
                if (doubleValue == doubleValue2 || (Double.isNaN(doubleValue) && Double.isNaN(doubleValue2))) {
                    z = true;
                }
                return z;
            }
        }
    }

    public int mo1706f() {
        return m13734p() ? mo1702b().intValue() : Integer.parseInt(mo1703c());
    }

    public boolean mo1707g() {
        return m13726a() ? mo1708o().booleanValue() : Boolean.parseBoolean(mo1703c());
    }

    public int hashCode() {
        if (this.f9492b == null) {
            return 31;
        }
        long longValue;
        if (m13723a(this)) {
            longValue = mo1702b().longValue();
            return (int) (longValue ^ (longValue >>> 32));
        } else if (!(this.f9492b instanceof Number)) {
            return this.f9492b.hashCode();
        } else {
            longValue = Double.doubleToLongBits(mo1702b().doubleValue());
            return (int) (longValue ^ (longValue >>> 32));
        }
    }

    Boolean mo1708o() {
        return (Boolean) this.f9492b;
    }

    public boolean m13734p() {
        return this.f9492b instanceof Number;
    }

    public boolean m13735q() {
        return this.f9492b instanceof String;
    }
}
