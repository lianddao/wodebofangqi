package com.ushareit.listenit;

import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import java.lang.reflect.Field;

public final class dql {
    public static final dqu f10164a = new dqn();
    public static final dqu f10165b = new dqo();
    public static final dqu f10166c = new dqp();
    public static final dqu f10167d = new dqq();
    public static final dqu f10168e = new dqr();
    private static dqx f10169f;
    private static final dqv f10170g = new dqm();
    private final Context f10171h;

    private dql(Context context) {
        this.f10171h = (Context) cfi.m11080a((Object) context);
    }

    public static int m15281a(Context context, String str) {
        String valueOf;
        String valueOf2;
        try {
            ClassLoader classLoader = context.getApplicationContext().getClassLoader();
            valueOf = String.valueOf("com.google.android.gms.dynamite.descriptors.");
            valueOf2 = String.valueOf("ModuleDescriptor");
            Class loadClass = classLoader.loadClass(new StringBuilder(((String.valueOf(valueOf).length() + 1) + String.valueOf(str).length()) + String.valueOf(valueOf2).length()).append(valueOf).append(str).append(".").append(valueOf2).toString());
            Field declaredField = loadClass.getDeclaredField("MODULE_ID");
            Field declaredField2 = loadClass.getDeclaredField("MODULE_VERSION");
            if (declaredField.get(null).equals(str)) {
                return declaredField2.getInt(null);
            }
            valueOf = String.valueOf(declaredField.get(null));
            Log.e("DynamiteModule", new StringBuilder((String.valueOf(valueOf).length() + 51) + String.valueOf(str).length()).append("Module descriptor id '").append(valueOf).append("' didn't match expected id '").append(str).append("'").toString());
            return 0;
        } catch (ClassNotFoundException e) {
            Log.w("DynamiteModule", new StringBuilder(String.valueOf(str).length() + 45).append("Local module descriptor class for ").append(str).append(" not found.").toString());
            return 0;
        } catch (Exception e2) {
            valueOf = "DynamiteModule";
            valueOf2 = "Failed to load module descriptor class: ";
            String valueOf3 = String.valueOf(e2.getMessage());
            Log.e(valueOf, valueOf3.length() != 0 ? valueOf2.concat(valueOf3) : new String(valueOf2));
            return 0;
        }
    }

    public static int m15282a(Context context, String str, boolean z) {
        dqx a = m15285a(context);
        if (a == null) {
            return 0;
        }
        try {
            return a.mo2025a(ckj.m11512a((Object) context), str, z);
        } catch (RemoteException e) {
            String str2 = "DynamiteModule";
            String str3 = "Failed to retrieve remote module version: ";
            String valueOf = String.valueOf(e.getMessage());
            Log.w(str2, valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3));
            return 0;
        }
    }

    public static dql m15283a(Context context, dqu com_ushareit_listenit_dqu, String str) {
        dqw a = com_ushareit_listenit_dqu.mo2023a(context, str, f10170g);
        Log.i("DynamiteModule", new StringBuilder((String.valueOf(str).length() + 68) + String.valueOf(str).length()).append("Considering local module ").append(str).append(":").append(a.f10173a).append(" and remote module ").append(str).append(":").append(a.f10174b).toString());
        if (a.f10175c == 0 || ((a.f10175c == -1 && a.f10173a == 0) || (a.f10175c == 1 && a.f10174b == 0))) {
            throw new dqt("No acceptable module found. Local version is " + a.f10173a + " and remote version is " + a.f10174b + ".");
        } else if (a.f10175c == -1) {
            return m15287c(context, str);
        } else {
            if (a.f10175c == 1) {
                try {
                    return m15284a(context, str, a.f10174b);
                } catch (Throwable e) {
                    Throwable th = e;
                    String str2 = "DynamiteModule";
                    String str3 = "Failed to load remote module: ";
                    String valueOf = String.valueOf(th.getMessage());
                    Log.w(str2, valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3));
                    if (a.f10173a != 0 && com_ushareit_listenit_dqu.mo2023a(context, str, new dqs(a.f10173a)).f10175c == -1) {
                        return m15287c(context, str);
                    }
                    throw new dqt("Remote load failed. No local fallback found.", th);
                }
            }
            throw new dqt("VersionPolicy returned invalid code:" + a.f10175c);
        }
    }

    private static dql m15284a(Context context, String str, int i) {
        Log.i("DynamiteModule", new StringBuilder(String.valueOf(str).length() + 51).append("Selected remote version of ").append(str).append(", version >= ").append(i).toString());
        dqx a = m15285a(context);
        if (a == null) {
            throw new dqt("Failed to create IDynamiteLoader.");
        }
        try {
            ckg a2 = a.mo2026a(ckj.m11512a((Object) context), str, i);
            if (ckj.m11513a(a2) != null) {
                return new dql((Context) ckj.m11513a(a2));
            }
            throw new dqt("Failed to load remote module.");
        } catch (Throwable e) {
            throw new dqt("Failed to load remote module.", e);
        }
    }

    private static dqx m15285a(Context context) {
        synchronized (dql.class) {
            dqx com_ushareit_listenit_dqx;
            if (f10169f != null) {
                com_ushareit_listenit_dqx = f10169f;
                return com_ushareit_listenit_dqx;
            } else if (cjb.m10875b().mo1287a(context) != 0) {
                return null;
            } else {
                try {
                    com_ushareit_listenit_dqx = dqy.m15304a((IBinder) context.createPackageContext("com.google.android.gms", 3).getClassLoader().loadClass("com.google.android.gms.chimera.container.DynamiteLoaderImpl").newInstance());
                    if (com_ushareit_listenit_dqx != null) {
                        f10169f = com_ushareit_listenit_dqx;
                        return com_ushareit_listenit_dqx;
                    }
                } catch (Exception e) {
                    String str = "DynamiteModule";
                    String str2 = "Failed to load IDynamiteLoader from GmsCore: ";
                    String valueOf = String.valueOf(e.getMessage());
                    Log.e(str, valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
                    return null;
                }
            }
        }
    }

    public static int m15286b(Context context, String str) {
        return m15282a(context, str, false);
    }

    private static dql m15287c(Context context, String str) {
        String str2 = "DynamiteModule";
        String str3 = "Selected local version of ";
        String valueOf = String.valueOf(str);
        Log.i(str2, valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3));
        return new dql(context.getApplicationContext());
    }

    public IBinder m15288a(String str) {
        Throwable e;
        String str2;
        String valueOf;
        try {
            return (IBinder) this.f10171h.getClassLoader().loadClass(str).newInstance();
        } catch (ClassNotFoundException e2) {
            e = e2;
            str2 = "Failed to instantiate module class: ";
            valueOf = String.valueOf(str);
            throw new dqt(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2), e);
        } catch (InstantiationException e3) {
            e = e3;
            str2 = "Failed to instantiate module class: ";
            valueOf = String.valueOf(str);
            if (valueOf.length() != 0) {
            }
            throw new dqt(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2), e);
        } catch (IllegalAccessException e4) {
            e = e4;
            str2 = "Failed to instantiate module class: ";
            valueOf = String.valueOf(str);
            if (valueOf.length() != 0) {
            }
            throw new dqt(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2), e);
        }
    }
}
