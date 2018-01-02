package com.ushareit.listenit;

import android.os.RemoteException;
import com.google.ads.mediation.AdUrlAdapter;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.mediation.customevent.CustomEventAdapter;
import java.util.Map;

public final class dih extends dij {
    private Map<Class<? extends Object>, Object> f9822a;

    private <NETWORK_EXTRAS extends bew, SERVER_PARAMETERS extends bet> dil m14415c(String str) {
        try {
            Class cls = Class.forName(str, false, dih.class.getClassLoader());
            if (beo.class.isAssignableFrom(cls)) {
                beo com_ushareit_listenit_beo = (beo) cls.newInstance();
                return new djg(com_ushareit_listenit_beo, (bew) this.f9822a.get(com_ushareit_listenit_beo.mo239b()));
            } else if (bzh.class.isAssignableFrom(cls)) {
                return new djb((bzh) cls.newInstance());
            } else {
                bze.m10490c(new StringBuilder(String.valueOf(str).length() + 64).append("Could not instantiate mediation adapter: ").append(str).append(" (not a valid adapter).").toString());
                throw new RemoteException();
            }
        } catch (Throwable th) {
            return m14416d(str);
        }
    }

    private dil m14416d(String str) {
        try {
            bze.m10485a("Reflection failed, retrying using direct instantiation");
            if ("com.google.ads.mediation.admob.AdMobAdapter".equals(str)) {
                return new djb(new AdMobAdapter());
            }
            if ("com.google.ads.mediation.AdUrlAdapter".equals(str)) {
                return new djb(new AdUrlAdapter());
            }
            if ("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter".equals(str)) {
                return new djb(new CustomEventAdapter());
            }
            if ("com.google.ads.mediation.customevent.CustomEventAdapter".equals(str)) {
                beo customEventAdapter = new com.google.ads.mediation.customevent.CustomEventAdapter();
                return new djg(customEventAdapter, (caa) this.f9822a.get(customEventAdapter.mo239b()));
            }
            throw new RemoteException();
        } catch (Throwable th) {
            bze.m10491c(new StringBuilder(String.valueOf(str).length() + 43).append("Could not instantiate mediation adapter: ").append(str).append(". ").toString(), th);
        }
    }

    public dil mo1814a(String str) {
        return m14415c(str);
    }

    public void m14418a(Map<Class<? extends Object>, Object> map) {
        this.f9822a = map;
    }

    public boolean mo1815b(String str) {
        boolean z = false;
        try {
            z = bzu.class.isAssignableFrom(Class.forName(str, false, dih.class.getClassLoader()));
        } catch (Throwable th) {
            bze.m10490c(new StringBuilder(String.valueOf(str).length() + 80).append("Could not load custom event implementation class: ").append(str).append(", assuming old implementation.").toString());
        }
        return z;
    }
}
