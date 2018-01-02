package com.ushareit.listenit;

import android.content.ContentProviderClient;
import android.content.Context;
import android.location.Location;
import android.os.Looper;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.internal.LocationRequestInternal;
import com.google.android.gms.location.internal.LocationRequestUpdateData;
import java.util.HashMap;
import java.util.Map;

public class dtq {
    private final dtz<dtk> f10319a;
    private final Context f10320b;
    private ContentProviderClient f10321c = null;
    private boolean f10322d = false;
    private Map<dsm, dtt> f10323e = new HashMap();
    private Map<Object, dtr> f10324f = new HashMap();

    public dtq(Context context, dtz<dtk> com_ushareit_listenit_dtz_com_ushareit_listenit_dtk) {
        this.f10320b = context;
        this.f10319a = com_ushareit_listenit_dtz_com_ushareit_listenit_dtk;
    }

    private dtt m15558a(dsm com_ushareit_listenit_dsm, Looper looper) {
        dtt com_ushareit_listenit_dtt;
        synchronized (this.f10323e) {
            com_ushareit_listenit_dtt = (dtt) this.f10323e.get(com_ushareit_listenit_dsm);
            if (com_ushareit_listenit_dtt == null) {
                com_ushareit_listenit_dtt = new dtt(com_ushareit_listenit_dsm, looper);
            }
            this.f10323e.put(com_ushareit_listenit_dsm, com_ushareit_listenit_dtt);
        }
        return com_ushareit_listenit_dtt;
    }

    public Location m15559a() {
        this.f10319a.mo2027a();
        try {
            return ((dtk) this.f10319a.mo2028c()).mo2063b(this.f10320b.getPackageName());
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
    }

    public void m15560a(LocationRequest locationRequest, dsm com_ushareit_listenit_dsm, Looper looper, dte com_ushareit_listenit_dte) {
        this.f10319a.mo2027a();
        ((dtk) this.f10319a.mo2028c()).mo2055a(LocationRequestUpdateData.m2402a(LocationRequestInternal.m2399a(locationRequest), m15558a(com_ushareit_listenit_dsm, looper), com_ushareit_listenit_dte));
    }

    public void m15561a(dsm com_ushareit_listenit_dsm, dte com_ushareit_listenit_dte) {
        this.f10319a.mo2027a();
        cfi.m11081a((Object) com_ushareit_listenit_dsm, (Object) "Invalid null listener");
        synchronized (this.f10323e) {
            duk com_ushareit_listenit_duk = (dtt) this.f10323e.remove(com_ushareit_listenit_dsm);
            if (com_ushareit_listenit_duk != null) {
                com_ushareit_listenit_duk.m15574a();
                ((dtk) this.f10319a.mo2028c()).mo2055a(LocationRequestUpdateData.m2404a(com_ushareit_listenit_duk, com_ushareit_listenit_dte));
            }
        }
    }

    public void m15562a(boolean z) {
        this.f10319a.mo2027a();
        ((dtk) this.f10319a.mo2028c()).mo2061a(z);
        this.f10322d = z;
    }

    public LocationAvailability m15563b() {
        this.f10319a.mo2027a();
        try {
            return ((dtk) this.f10319a.mo2028c()).mo2066c(this.f10320b.getPackageName());
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
    }

    public void m15564c() {
        try {
            synchronized (this.f10323e) {
                for (duk com_ushareit_listenit_duk : this.f10323e.values()) {
                    if (com_ushareit_listenit_duk != null) {
                        ((dtk) this.f10319a.mo2028c()).mo2055a(LocationRequestUpdateData.m2404a(com_ushareit_listenit_duk, null));
                    }
                }
                this.f10323e.clear();
            }
            synchronized (this.f10324f) {
                for (duh com_ushareit_listenit_duh : this.f10324f.values()) {
                    if (com_ushareit_listenit_duh != null) {
                        ((dtk) this.f10319a.mo2028c()).mo2055a(LocationRequestUpdateData.m2403a(com_ushareit_listenit_duh, null));
                    }
                }
                this.f10324f.clear();
            }
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
    }

    public void m15565d() {
        if (this.f10322d) {
            try {
                m15562a(false);
            } catch (Throwable e) {
                throw new IllegalStateException(e);
            }
        }
    }
}
