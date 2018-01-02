package com.ushareit.listenit;

import android.content.Context;
import android.telephony.TelephonyManager;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public abstract class fal {
    public static fam m18717a(Context context) {
        if (context == null) {
            return null;
        }
        fam b = m18719b(context);
        if (b != null) {
            return b;
        }
        b = m18720c(context);
        return b == null ? m18721d(context) : b;
    }

    public static fam m18719b(Context context) {
        Integer num;
        Integer valueOf = Integer.valueOf(0);
        Integer valueOf2 = Integer.valueOf(1);
        try {
            Class cls = Class.forName("com.android.internal.telephony.Phone");
            try {
                Field field = cls.getField("GEMINI_SIM_1");
                field.setAccessible(true);
                num = (Integer) field.get(null);
                try {
                    field.setAccessible(false);
                    valueOf = num;
                } catch (Exception e) {
                    valueOf = num;
                }
            } catch (Exception e2) {
            }
            try {
                Field field2 = cls.getField("GEMINI_SIM_2");
                field2.setAccessible(true);
                num = (Integer) field2.get(null);
                try {
                    field2.setAccessible(false);
                } catch (Exception e3) {
                }
            } catch (Exception e4) {
                num = valueOf2;
            }
            Object obj = valueOf;
            Object obj2 = num;
        } catch (Exception e5) {
            Integer num2 = valueOf;
            valueOf = valueOf2;
        }
        fam com_ushareit_listenit_fam = new fam();
        try {
            Class cls2 = Class.forName("android.provider.MultiSIMUtils");
            Object invoke = cls2.getMethod("getDefault", new Class[]{Context.class}).invoke(cls2, new Object[]{context});
            if (invoke != null) {
                Method method = cls2.getMethod("getDeviceId", new Class[]{Integer.TYPE});
                com_ushareit_listenit_fam.f12322a = "MtkDoubleSim1";
                com_ushareit_listenit_fam.f12323b = (String) method.invoke(invoke, new Object[]{obj});
                com_ushareit_listenit_fam.f12324c = (String) method.invoke(invoke, new Object[]{obj2});
            }
        } catch (Exception e6) {
        }
        if (com_ushareit_listenit_fam.m18723a()) {
            return com_ushareit_listenit_fam;
        }
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (telephonyManager == null) {
            return null;
        }
        try {
            method = TelephonyManager.class.getDeclaredMethod("getDeviceIdGemini", new Class[]{Integer.TYPE});
            com_ushareit_listenit_fam.f12322a = "MtkDoubleSim2";
            com_ushareit_listenit_fam.f12323b = (String) method.invoke(telephonyManager, new Object[]{obj});
            com_ushareit_listenit_fam.f12324c = (String) method.invoke(telephonyManager, new Object[]{obj2});
        } catch (Exception e7) {
        }
        if (com_ushareit_listenit_fam.m18723a()) {
            return com_ushareit_listenit_fam;
        }
        try {
            method = TelephonyManager.class.getMethod("getDefault", new Class[]{Integer.TYPE});
            TelephonyManager telephonyManager2 = (TelephonyManager) method.invoke(telephonyManager, new Object[]{obj});
            telephonyManager = (TelephonyManager) method.invoke(telephonyManager, new Object[]{obj2});
            if (!(telephonyManager2 == null || telephonyManager == null)) {
                com_ushareit_listenit_fam.f12322a = "MtkDoubleSim3";
                com_ushareit_listenit_fam.f12323b = telephonyManager2.getDeviceId();
                com_ushareit_listenit_fam.f12324c = telephonyManager.getDeviceId();
            }
        } catch (Exception e8) {
        }
        return com_ushareit_listenit_fam.m18723a() ? com_ushareit_listenit_fam : null;
    }

    public static fam m18720c(Context context) {
        fam com_ushareit_listenit_fam = new fam();
        try {
            Class cls = Class.forName("android.telephony.MSimTelephonyManager");
            Object systemService = context.getSystemService("phone_msim");
            if (systemService == null) {
                return null;
            }
            Method method = cls.getMethod("getDeviceId", new Class[]{Integer.TYPE});
            Integer valueOf = Integer.valueOf(0);
            Integer valueOf2 = Integer.valueOf(1);
            com_ushareit_listenit_fam.f12322a = "QualcommDoubleSim";
            com_ushareit_listenit_fam.f12323b = (String) method.invoke(systemService, new Object[]{valueOf});
            com_ushareit_listenit_fam.f12324c = (String) method.invoke(systemService, new Object[]{valueOf2});
            return com_ushareit_listenit_fam.m18723a() ? com_ushareit_listenit_fam : null;
        } catch (Exception e) {
        }
    }

    public static String m18718a() {
        try {
            Class cls = Class.forName("android.telephony.MSimTelephonyManager");
            return (String) cls.getDeclaredMethod("getTelephonyProperty", new Class[]{String.class, Integer.TYPE, String.class}).invoke(cls, new Object[]{"gsm.operator.alpha", Integer.valueOf(0), null});
        } catch (Exception e) {
            return null;
        }
    }

    public static fam m18721d(Context context) {
        fam e = m18722e(context);
        if (e == null) {
            return null;
        }
        try {
            Class cls = Class.forName("com.android.internal.telephony.PhoneFactory");
            String str = (String) cls.getMethod("getServiceName", new Class[]{String.class, Integer.TYPE}).invoke(cls, new Object[]{"phone", Integer.valueOf(1)});
            if (str == null || str.length() == 0) {
                return e;
            }
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(str);
            if (telephonyManager != null) {
                e.f12322a = "SpreadDoubleSim";
                e.f12324c = telephonyManager.getDeviceId();
            }
            return e;
        } catch (Throwable th) {
        }
    }

    public static fam m18722e(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (telephonyManager == null) {
            return null;
        }
        fam com_ushareit_listenit_fam = new fam();
        try {
            com_ushareit_listenit_fam.f12322a = "SingleSim";
            com_ushareit_listenit_fam.f12323b = telephonyManager.getDeviceId();
            com_ushareit_listenit_fam.f12324c = null;
        } catch (Exception e) {
        }
        return com_ushareit_listenit_fam.m18723a() ? com_ushareit_listenit_fam : null;
    }
}
