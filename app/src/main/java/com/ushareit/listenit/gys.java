package com.ushareit.listenit;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import com.ushareit.listenit.service.PlayService;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class gys {
    private static gum f14932a = null;
    private static final AtomicInteger f14933b = new AtomicInteger(0);
    private static final List<gyu> f14934c = new ArrayList();
    private static String f14935d = null;
    private static ServiceConnection f14936e = new gyt();

    private gys() {
    }

    public static synchronized gum m23310a() {
        gum com_ushareit_listenit_gum;
        synchronized (gys.class) {
            com_ushareit_listenit_gum = f14932a;
        }
        return com_ushareit_listenit_gum;
    }

    private static synchronized void m23315b(gum com_ushareit_listenit_gum) {
        synchronized (gys.class) {
            f14932a = com_ushareit_listenit_gum;
        }
    }

    public static void m23312a(Context context, gyu com_ushareit_listenit_gyu) {
        synchronized (gys.class) {
            if (com_ushareit_listenit_gyu != null) {
                f14934c.add(com_ushareit_listenit_gyu);
            }
        }
        int incrementAndGet = f14933b.incrementAndGet();
        if (incrementAndGet == 1) {
            f14935d = gyv.m23317a(PlayService.class.getName());
            context.startService(new Intent(context, PlayService.class));
            Intent intent = new Intent();
            intent.setClassName(context.getPackageName(), PlayService.class.getName());
            context.bindService(intent, f14936e, 0);
        } else {
            m23316c();
        }
        exw.m18449b("UI.ServiceFactory", "After bind() is called: " + incrementAndGet);
    }

    public static void m23311a(Context context) {
        int decrementAndGet = f14933b.decrementAndGet();
        if (decrementAndGet == 0) {
            context.unbindService(f14936e);
            if (!(m23310a() == null || m23310a().mo2425a())) {
                context.stopService(new Intent(context, PlayService.class));
            }
            m23315b(null);
            gyv.m23318b(f14935d);
            f14935d = null;
        }
        exw.m18449b("UI.ServiceFactory", "After unbind() is called: " + decrementAndGet);
    }

    private static synchronized void m23316c() {
        synchronized (gys.class) {
            if (f14932a != null) {
                for (gyu a : f14934c) {
                    a.mo2386a();
                }
                f14934c.clear();
            }
        }
    }
}
