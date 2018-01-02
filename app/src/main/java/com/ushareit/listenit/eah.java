package com.ushareit.listenit;

import android.annotation.TargetApi;
import android.app.Application;
import android.content.Context;
import android.util.Log;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

public class eah {
    static final Map<String, eah> f10756a = new fq();
    private static final List<String> f10757b = Arrays.asList(new String[]{"com.google.firebase.auth.FirebaseAuth", "com.google.firebase.iid.FirebaseInstanceId"});
    private static final List<String> f10758c = Collections.singletonList("com.google.firebase.crash.FirebaseCrash");
    private static final List<String> f10759d = Arrays.asList(new String[]{"com.google.android.gms.measurement.AppMeasurement"});
    private static final List<String> f10760e = Arrays.asList(new String[0]);
    private static final Set<String> f10761f = Collections.emptySet();
    private static final Object f10762g = new Object();
    private final Context f10763h;
    private final String f10764i;
    private final ean f10765j;
    private final AtomicBoolean f10766k = new AtomicBoolean(false);
    private final AtomicBoolean f10767l = new AtomicBoolean();
    private final List<eai> f10768m = new CopyOnWriteArrayList();
    private final List<eaj> f10769n = new CopyOnWriteArrayList();
    private final List<Object> f10770o = new CopyOnWriteArrayList();
    private cyy f10771p;

    protected eah(Context context, String str, ean com_ushareit_listenit_ean) {
        this.f10763h = (Context) cfi.m11080a((Object) context);
        this.f10764i = cfi.m11082a(str);
        this.f10765j = (ean) cfi.m11080a((Object) com_ushareit_listenit_ean);
    }

    public static eah m16603a(Context context) {
        eah d;
        synchronized (f10762g) {
            if (f10756a.containsKey("[DEFAULT]")) {
                d = m16613d();
            } else {
                ean a = ean.m16631a(context);
                if (a == null) {
                    d = null;
                } else {
                    d = m16604a(context, a);
                }
            }
        }
        return d;
    }

    public static eah m16604a(Context context, ean com_ushareit_listenit_ean) {
        return m16605a(context, com_ushareit_listenit_ean, "[DEFAULT]");
    }

    public static eah m16605a(Context context, ean com_ushareit_listenit_ean, String str) {
        Object com_ushareit_listenit_eah;
        cyx a = cyx.m13442a(context);
        m16611b(context);
        String b = m16610b(str);
        if (!(context instanceof Application)) {
            Object applicationContext = context.getApplicationContext();
        }
        synchronized (f10762g) {
            cfi.m11086a(!f10756a.containsKey(b), new StringBuilder(String.valueOf(b).length() + 33).append("FirebaseApp name ").append(b).append(" already exists!").toString());
            cfi.m11081a(applicationContext, (Object) "Application context cannot be null.");
            com_ushareit_listenit_eah = new eah(applicationContext, b, com_ushareit_listenit_ean);
            f10756a.put(b, com_ushareit_listenit_eah);
        }
        a.m13443a((eah) com_ushareit_listenit_eah);
        com_ushareit_listenit_eah.m16608a(eah.class, com_ushareit_listenit_eah, f10757b);
        if (com_ushareit_listenit_eah.m16626e()) {
            com_ushareit_listenit_eah.m16608a(eah.class, com_ushareit_listenit_eah, f10758c);
            com_ushareit_listenit_eah.m16608a(Context.class, com_ushareit_listenit_eah.m16618a(), f10759d);
        }
        return com_ushareit_listenit_eah;
    }

    public static eah m16606a(String str) {
        eah com_ushareit_listenit_eah;
        synchronized (f10762g) {
            com_ushareit_listenit_eah = (eah) f10756a.get(m16610b(str));
            if (com_ushareit_listenit_eah != null) {
            } else {
                String str2;
                Iterable i = m16616i();
                if (i.isEmpty()) {
                    str2 = "";
                } else {
                    String str3 = "Available app names: ";
                    str2 = String.valueOf(cie.m11357a(", ").m11359a(i));
                    str2 = str2.length() != 0 ? str3.concat(str2) : new String(str3);
                }
                throw new IllegalStateException(String.format("FirebaseApp with name %s doesn't exist. %s", new Object[]{str, str2}));
            }
        }
        return com_ushareit_listenit_eah;
    }

    private <T> void m16608a(Class<T> cls, T t, Iterable<String> iterable) {
        boolean z;
        String valueOf;
        if (ciu.m11415k()) {
            boolean isDeviceProtectedStorage = this.f10763h.isDeviceProtectedStorage();
            if (isDeviceProtectedStorage) {
                eak.m16629b(this.f10763h);
            }
            z = isDeviceProtectedStorage;
        } else {
            z = false;
        }
        for (String valueOf2 : iterable) {
            if (z) {
                try {
                    if (!f10760e.contains(valueOf2)) {
                    }
                } catch (ClassNotFoundException e) {
                    if (f10761f.contains(valueOf2)) {
                        throw new IllegalStateException(String.valueOf(valueOf2).concat(" is missing, but is required. Check if it has been removed by Proguard."));
                    }
                    Log.d("FirebaseApp", String.valueOf(valueOf2).concat(" is not linked. Skipping initialization."));
                } catch (NoSuchMethodException e2) {
                    throw new IllegalStateException(String.valueOf(valueOf2).concat("#getInstance has been removed by Proguard. Add keep rule to prevent it."));
                } catch (Throwable e3) {
                    Log.wtf("FirebaseApp", "Firebase API initialization failure.", e3);
                } catch (Throwable e4) {
                    String str = "FirebaseApp";
                    String str2 = "Failed to initialize ";
                    valueOf2 = String.valueOf(valueOf2);
                    Log.wtf(str, valueOf2.length() != 0 ? str2.concat(valueOf2) : new String(str2), e4);
                }
            }
            Method method = Class.forName(valueOf2).getMethod("getInstance", new Class[]{cls});
            int modifiers = method.getModifiers();
            if (Modifier.isPublic(modifiers) && Modifier.isStatic(modifiers)) {
                method.invoke(null, new Object[]{t});
            }
        }
    }

    public static void m16609a(boolean z) {
        synchronized (f10762g) {
            Iterator it = new ArrayList(f10756a.values()).iterator();
            while (it.hasNext()) {
                eah com_ushareit_listenit_eah = (eah) it.next();
                if (com_ushareit_listenit_eah.f10766k.get()) {
                    com_ushareit_listenit_eah.m16612c(z);
                }
            }
        }
    }

    private static String m16610b(String str) {
        return str.trim();
    }

    @TargetApi(14)
    private static void m16611b(Context context) {
        if (ciu.m11408d() && (context.getApplicationContext() instanceof Application)) {
            cyw.m13439a((Application) context.getApplicationContext());
        }
    }

    private void m16612c(boolean z) {
        Log.d("FirebaseApp", "Notifying background state change listeners.");
        for (eaj a : this.f10769n) {
            a.mo1462a(z);
        }
    }

    public static eah m16613d() {
        eah com_ushareit_listenit_eah;
        synchronized (f10762g) {
            com_ushareit_listenit_eah = (eah) f10756a.get("[DEFAULT]");
            if (com_ushareit_listenit_eah == null) {
                String valueOf = String.valueOf(civ.m11418b());
                throw new IllegalStateException(new StringBuilder(String.valueOf(valueOf).length() + 116).append("Default FirebaseApp is not initialized in this process ").append(valueOf).append(". Make sure to call FirebaseApp.initializeApp(Context) first.").toString());
            }
        }
        return com_ushareit_listenit_eah;
    }

    private void m16615h() {
        cfi.m11086a(!this.f10767l.get(), (Object) "FirebaseApp was deleted");
    }

    private static List<String> m16616i() {
        Collection com_ushareit_listenit_cil = new cil();
        synchronized (f10762g) {
            for (eah b : f10756a.values()) {
                com_ushareit_listenit_cil.add(b.m16624b());
            }
            cyx a = cyx.m13441a();
            if (a != null) {
                com_ushareit_listenit_cil.addAll(a.m13444b());
            }
        }
        List<String> arrayList = new ArrayList(com_ushareit_listenit_cil);
        Collections.sort(arrayList);
        return arrayList;
    }

    private void m16617j() {
        m16608a(eah.class, (Object) this, f10757b);
        if (m16626e()) {
            m16608a(eah.class, (Object) this, f10758c);
            m16608a(Context.class, this.f10763h, f10759d);
        }
    }

    public Context m16618a() {
        m16615h();
        return this.f10763h;
    }

    public void m16619a(cyy com_ushareit_listenit_cyy) {
        this.f10771p = (cyy) cfi.m11080a((Object) com_ushareit_listenit_cyy);
    }

    public void m16620a(cyz com_ushareit_listenit_cyz) {
        Log.d("FirebaseApp", "Notifying auth state listeners.");
        int i = 0;
        for (eai a : this.f10768m) {
            a.mo1449a(com_ushareit_listenit_cyz);
            i++;
        }
        Log.d("FirebaseApp", String.format("Notified %d auth state listeners.", new Object[]{Integer.valueOf(i)}));
    }

    public void m16621a(eai com_ushareit_listenit_eai) {
        m16615h();
        cfi.m11080a((Object) com_ushareit_listenit_eai);
        this.f10768m.add(com_ushareit_listenit_eai);
    }

    public void m16622a(eaj com_ushareit_listenit_eaj) {
        m16615h();
        if (this.f10766k.get() && cyw.m13438a().m13440b()) {
            com_ushareit_listenit_eaj.mo1462a(true);
        }
        this.f10769n.add(com_ushareit_listenit_eaj);
    }

    public dzo<ebk> m16623b(boolean z) {
        m16615h();
        return this.f10771p == null ? dzt.m16569a(new eag("firebase-auth is not linked, please fall back to unauthenticated mode.")) : this.f10771p.mo273a(z);
    }

    public String m16624b() {
        m16615h();
        return this.f10764i;
    }

    public ean m16625c() {
        m16615h();
        return this.f10765j;
    }

    public boolean m16626e() {
        return "[DEFAULT]".equals(m16624b());
    }

    public boolean equals(Object obj) {
        return !(obj instanceof eah) ? false : this.f10764i.equals(((eah) obj).m16624b());
    }

    public String m16627f() {
        String valueOf = String.valueOf(cim.m11384a(m16624b().getBytes()));
        String valueOf2 = String.valueOf(cim.m11384a(m16625c().m16633b().getBytes()));
        return new StringBuilder((String.valueOf(valueOf).length() + 1) + String.valueOf(valueOf2).length()).append(valueOf).append("+").append(valueOf2).toString();
    }

    public int hashCode() {
        return this.f10764i.hashCode();
    }

    public String toString() {
        return cff.m11077a((Object) this).m11079a("name", this.f10764i).m11079a("options", this.f10765j).toString();
    }
}
