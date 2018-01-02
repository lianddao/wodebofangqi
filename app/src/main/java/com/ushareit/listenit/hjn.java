package com.ushareit.listenit;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.LinkedBlockingQueue;

public final class hjn {
    static volatile int f15526a = 0;
    static hka f15527b = new hka();
    static hjx f15528c = new hjx();
    static boolean f15529d = hkb.m24025b("slf4j.detectLoggerNameMismatch");
    private static final String[] f15530e = new String[]{"1.6", "1.7"};
    private static String f15531f = "org/slf4j/impl/StaticLoggerBinder.class";

    private hjn() {
    }

    private static final void m23946c() {
        m23948d();
        if (f15526a == 3) {
            m23952h();
        }
    }

    private static boolean m23945b(String str) {
        if (str == null) {
            return false;
        }
        if (str.contains("org/slf4j/impl/StaticLoggerBinder")) {
            return true;
        }
        if (str.contains("org.slf4j.impl.StaticLoggerBinder")) {
            return true;
        }
        return false;
    }

    private static final void m23948d() {
        Set set = null;
        try {
            if (!m23953i()) {
                set = m23937a();
                m23944b(set);
            }
            hke.m24041a();
            f15526a = 3;
            m23947c(set);
            m23949e();
            m23950f();
            f15527b.m24022d();
        } catch (Throwable e) {
            if (m23945b(e.getMessage())) {
                f15526a = 4;
                hkb.m24026c("Failed to load class \"org.slf4j.impl.StaticLoggerBinder\".");
                hkb.m24026c("Defaulting to no-operation (NOP) logger implementation");
                hkb.m24026c("See http://www.slf4j.org/codes.html#StaticLoggerBinder for further details.");
                return;
            }
            m23941a(e);
            throw e;
        } catch (NoSuchMethodError e2) {
            String message = e2.getMessage();
            if (message != null && message.contains("org.slf4j.impl.StaticLoggerBinder.getSingleton()")) {
                f15526a = 2;
                hkb.m24026c("slf4j-api 1.6.x (or later) is incompatible with this binding.");
                hkb.m24026c("Your binding is version 1.5.5 or earlier.");
                hkb.m24026c("Upgrade your binding to version 1.6.x.");
            }
            throw e2;
        } catch (Throwable e3) {
            m23941a(e3);
            throw new IllegalStateException("Unexpected initialization failure", e3);
        }
    }

    private static void m23949e() {
        synchronized (f15527b) {
            f15527b.m24021c();
            for (hjz com_ushareit_listenit_hjz : f15527b.m24019a()) {
                com_ushareit_listenit_hjz.m24004a(m23936a(com_ushareit_listenit_hjz.m24003a()));
            }
        }
    }

    static void m23941a(Throwable th) {
        f15526a = 2;
        hkb.m24024a("Failed to instantiate SLF4J LoggerFactory", th);
    }

    private static void m23950f() {
        LinkedBlockingQueue b = f15527b.m24020b();
        int size = b.size();
        int i = 0;
        List<hjs> arrayList = new ArrayList(128);
        while (b.drainTo(arrayList, 128) != 0) {
            int i2 = i;
            for (hjs com_ushareit_listenit_hjs : arrayList) {
                m23939a(com_ushareit_listenit_hjs);
                int i3 = i2 + 1;
                if (i2 == 0) {
                    m23940a(com_ushareit_listenit_hjs, size);
                }
                i2 = i3;
            }
            arrayList.clear();
            i = i2;
        }
    }

    private static void m23940a(hjs com_ushareit_listenit_hjs, int i) {
        if (com_ushareit_listenit_hjs.m23963a().m24013c()) {
            m23938a(i);
        } else if (!com_ushareit_listenit_hjs.m23963a().m24016e()) {
            m23951g();
        }
    }

    private static void m23939a(hjs com_ushareit_listenit_hjs) {
        if (com_ushareit_listenit_hjs != null) {
            hjz a = com_ushareit_listenit_hjs.m23963a();
            String a2 = a.m24003a();
            if (a.m24015d()) {
                throw new IllegalStateException("Delegate logger cannot be null at this state.");
            } else if (!a.m24016e()) {
                if (a.m24013c()) {
                    a.m24005a((hjr) com_ushareit_listenit_hjs);
                } else {
                    hkb.m24026c(a2);
                }
            }
        }
    }

    private static void m23951g() {
        hkb.m24026c("The following set of substitute loggers may have been accessed");
        hkb.m24026c("during the initialization phase. Logging calls during this");
        hkb.m24026c("phase were not honored. However, subsequent logging calls to these");
        hkb.m24026c("loggers will work as normally expected.");
        hkb.m24026c("See also http://www.slf4j.org/codes.html#substituteLogger");
    }

    private static void m23938a(int i) {
        hkb.m24026c("A number (" + i + ") of logging calls during the initialization phase have been intercepted and are");
        hkb.m24026c("now being replayed. These are subject to the filtering rules of the underlying logging system.");
        hkb.m24026c("See also http://www.slf4j.org/codes.html#replay");
    }

    private static final void m23952h() {
        Object obj = null;
        try {
            String str = hke.f15569a;
            for (String startsWith : f15530e) {
                if (str.startsWith(startsWith)) {
                    obj = 1;
                }
            }
            if (obj == null) {
                hkb.m24026c("The requested version " + str + " by your slf4j binding is not compatible with " + Arrays.asList(f15530e).toString());
                hkb.m24026c("See http://www.slf4j.org/codes.html#version_mismatch for further details.");
            }
        } catch (NoSuchFieldError e) {
        } catch (Throwable th) {
            hkb.m24024a("Unexpected problem occured during version sanity check", th);
        }
    }

    static Set<URL> m23937a() {
        Set<URL> linkedHashSet = new LinkedHashSet();
        try {
            Enumeration systemResources;
            ClassLoader classLoader = hjn.class.getClassLoader();
            if (classLoader == null) {
                systemResources = ClassLoader.getSystemResources(f15531f);
            } else {
                systemResources = classLoader.getResources(f15531f);
            }
            while (systemResources.hasMoreElements()) {
                linkedHashSet.add((URL) systemResources.nextElement());
            }
        } catch (Throwable e) {
            hkb.m24024a("Error getting resources from path", e);
        }
        return linkedHashSet;
    }

    private static boolean m23942a(Set<URL> set) {
        return set.size() > 1;
    }

    private static void m23944b(Set<URL> set) {
        if (m23942a((Set) set)) {
            hkb.m24026c("Class path contains multiple SLF4J bindings.");
            for (URL url : set) {
                hkb.m24026c("Found binding in [" + url + "]");
            }
            hkb.m24026c("See http://www.slf4j.org/codes.html#multiple_bindings for an explanation.");
        }
    }

    private static boolean m23953i() {
        String a = hkb.m24023a("java.vendor.url");
        if (a == null) {
            return false;
        }
        return a.toLowerCase().contains("android");
    }

    private static void m23947c(Set<URL> set) {
        if (set != null && m23942a((Set) set)) {
            hkb.m24026c("Actual binding is of type [" + hke.m24041a().m24043c() + "]");
        }
    }

    public static hjm m23936a(String str) {
        return m23943b().mo2797a(str);
    }

    public static hjl m23943b() {
        if (f15526a == 0) {
            synchronized (hjn.class) {
                if (f15526a == 0) {
                    f15526a = 1;
                    m23946c();
                }
            }
        }
        switch (f15526a) {
            case 1:
                return f15527b;
            case 2:
                throw new IllegalStateException("org.slf4j.LoggerFactory could not be successfully initialized. See also http://www.slf4j.org/codes.html#unsuccessfulInit");
            case 3:
                return hke.m24041a().m24042b();
            case 4:
                return f15528c;
            default:
                throw new IllegalStateException("Unreachable code");
        }
    }
}
