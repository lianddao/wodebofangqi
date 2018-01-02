package com.ushareit.listenit;

import android.content.ContentResolver;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.Looper;
import android.text.TextUtils;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public final class eyj {
    private static String f12164a = "";
    private static String f12165b = "";
    private static Method f12166c;
    private static Method f12167d;
    private static Method f12168e;
    private static Method f12169f;
    private static Method f12170g;
    private static Method f12171h;
    private static Method f12172i;
    private static Method f12173j;
    private static Method f12174k;

    static {
        f12166c = null;
        f12167d = null;
        f12168e = null;
        f12169f = null;
        f12170g = null;
        f12171h = null;
        f12172i = null;
        f12173j = null;
        f12174k = null;
        Class cls = Class.forName("android.os.storage.StorageManager");
        Class cls2 = Class.forName("android.os.storage.StorageVolume");
        f12166c = cls.getDeclaredMethod("getVolumeList", new Class[0]);
        f12167d = cls.getDeclaredMethod("getVolumeState", new Class[]{String.class});
        try {
            f12168e = cls2.getDeclaredMethod("getDescription", new Class[0]);
        } catch (Exception e) {
        }
        try {
            f12169f = cls2.getDeclaredMethod("getDescription", new Class[]{Context.class});
        } catch (Exception e2) {
        }
        try {
            f12170g = cls2.getDeclaredMethod("getPath", new Class[0]);
            try {
                f12171h = cls2.getDeclaredMethod("getUuid", new Class[0]);
                f12172i = cls2.getDeclaredMethod("isPrimary", new Class[0]);
            } catch (Exception e3) {
            }
            cls = Class.forName("android.os.Environment");
            f12173j = cls.getDeclaredMethod("getRealExternalStorageDirectory", new Class[0]);
            f12174k = cls.getDeclaredMethod("getRealExternalStorageState", new Class[0]);
        } catch (Exception e4) {
        }
    }

    private static Object m18511a(Context context, Class<?> cls) {
        if (VERSION.SDK_INT < 18) {
            return cls.getConstructor(new Class[]{Looper.class}).newInstance(new Object[]{Looper.getMainLooper()});
        } else if (VERSION.SDK_INT < 23) {
            return cls.getConstructor(new Class[]{ContentResolver.class, Looper.class}).newInstance(new Object[]{context.getContentResolver(), Looper.getMainLooper()});
        } else {
            return cls.getConstructor(new Class[]{Context.class, Looper.class}).newInstance(new Object[]{context, Looper.getMainLooper()});
        }
    }

    public static List<eyk> m18512a(Context context) {
        eyk com_ushareit_listenit_eyk;
        List<eyk> arrayList = new ArrayList();
        try {
            Object a = m18511a(context, Class.forName("android.os.storage.StorageManager"));
            Object invoke = f12166c.invoke(a, new Object[0]);
            int length = Array.getLength(invoke);
            for (int i = 0; i < length; i++) {
                String str;
                String str2;
                Object obj = Array.get(invoke, i);
                String str3 = "";
                if (f12168e != null) {
                    str = (String) f12168e.invoke(obj, new Object[0]);
                } else if (f12169f != null) {
                    str = (String) f12169f.invoke(obj, new Object[]{context});
                } else {
                    str = str3;
                }
                boolean booleanValue = f12172i == null ? false : ((Boolean) f12172i.invoke(obj, new Object[0])).booleanValue();
                if (f12171h == null) {
                    str2 = null;
                } else {
                    str2 = (String) f12171h.invoke(obj, new Object[0]);
                }
                String str4 = (String) f12170g.invoke(obj, new Object[0]);
                String str5 = (String) f12167d.invoke(a, new Object[]{str4});
                if (exw.f12142a && !"removed".equals(str5)) {
                    exw.m18443a("StorageVolumeHelper", "Description: " + str + ", Path: " + str4 + ", State: " + str5);
                }
                com_ushareit_listenit_eyk = new eyk(booleanValue, str2, str, str4, str5);
                com_ushareit_listenit_eyk.f12180f = m18513a(context, str4);
                com_ushareit_listenit_eyk.f12181g = m18515b(context, com_ushareit_listenit_eyk.f12178d);
                com_ushareit_listenit_eyk.f12182h = m18517c(context, str4);
                com_ushareit_listenit_eyk.f12183i = m18518d(context, com_ushareit_listenit_eyk.f12178d);
                arrayList.add(com_ushareit_listenit_eyk);
            }
            if (!arrayList.isEmpty()) {
                return arrayList;
            }
        } catch (Exception e) {
            exw.m18456d("StorageVolumeHelper", e.toString());
        }
        com_ushareit_listenit_eyk = new eyk(f12164a, Environment.getExternalStorageDirectory().getAbsolutePath(), Environment.getExternalStorageState());
        com_ushareit_listenit_eyk.f12180f = m18513a(context, Environment.getExternalStorageDirectory().getAbsolutePath());
        com_ushareit_listenit_eyk.f12181g = m18515b(context, com_ushareit_listenit_eyk.f12178d);
        com_ushareit_listenit_eyk.f12182h = m18517c(context, Environment.getExternalStorageDirectory().getAbsolutePath());
        com_ushareit_listenit_eyk.f12175a = com_ushareit_listenit_eyk.f12182h;
        com_ushareit_listenit_eyk.f12183i = m18518d(context, com_ushareit_listenit_eyk.f12178d);
        arrayList.add(com_ushareit_listenit_eyk);
        try {
            Object newInstance = Class.forName("android.os.Environment").getConstructor(new Class[0]).newInstance(new Object[0]);
            File file = (File) f12173j.invoke(newInstance, new Object[0]);
            eyk com_ushareit_listenit_eyk2 = new eyk(f12165b, file.getAbsolutePath(), (String) f12174k.invoke(newInstance, new Object[0]));
            com_ushareit_listenit_eyk2.f12180f = m18513a(context, file.getAbsolutePath());
            com_ushareit_listenit_eyk2.f12181g = m18515b(context, com_ushareit_listenit_eyk2.f12178d);
            com_ushareit_listenit_eyk2.f12182h = m18517c(context, file.getAbsolutePath());
            com_ushareit_listenit_eyk2.f12175a = com_ushareit_listenit_eyk2.f12182h;
            com_ushareit_listenit_eyk2.f12183i = m18518d(context, com_ushareit_listenit_eyk2.f12178d);
            arrayList.add(com_ushareit_listenit_eyk2);
        } catch (Exception e2) {
            exw.m18456d("StorageVolumeHelper", e2.toString());
        }
        return arrayList;
    }

    public static List<eyk> m18514b(Context context) {
        List<eyk> arrayList = new ArrayList();
        for (eyk com_ushareit_listenit_eyk : m18512a(context)) {
            if ("mounted".equals(com_ushareit_listenit_eyk.f12179e)) {
                arrayList.add(com_ushareit_listenit_eyk);
            }
        }
        return arrayList;
    }

    public static eyk m18516c(Context context) {
        List<eyk> a = m18512a(context);
        CharSequence b = new exz(context).m17993b("SETTING_STORAGE");
        if (TextUtils.isEmpty(b)) {
            String absolutePath = Environment.getExternalStorageDirectory().getAbsolutePath();
        } else {
            CharSequence charSequence = b;
        }
        for (eyk com_ushareit_listenit_eyk : a) {
            if (absolutePath.equals(com_ushareit_listenit_eyk.f12178d)) {
                return com_ushareit_listenit_eyk;
            }
        }
        return (eyk) a.get(0);
    }

    private static boolean m18513a(Context context, String str) {
        File file = new File(str + "/" + "StorageVolumeHelper" + ".tmp");
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            file.delete();
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    private static boolean m18515b(Context context, String str) {
        File a = eye.m18475a(context, str);
        return (a == null || !a.exists()) ? false : m18513a(context, a.getAbsolutePath());
    }

    private static boolean m18517c(Context context, String str) {
        if (VERSION.SDK_INT >= 19 && !str.equalsIgnoreCase(Environment.getExternalStorageDirectory().getAbsolutePath())) {
            return false;
        }
        return true;
    }

    private static boolean m18518d(Context context, String str) {
        return VERSION.SDK_INT >= 21;
    }
}
