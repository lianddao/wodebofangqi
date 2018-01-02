package com.ushareit.listenit;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

public final class djb extends dim {
    private final bzh f9836a;
    private djc f9837b;

    public djb(bzh com_ushareit_listenit_bzh) {
        this.f9836a = com_ushareit_listenit_bzh;
    }

    private Bundle m14552a(String str, int i, String str2) {
        String str3 = "Server parameters: ";
        String valueOf = String.valueOf(str);
        bze.m10490c(valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3));
        try {
            Bundle bundle = new Bundle();
            if (str != null) {
                JSONObject jSONObject = new JSONObject(str);
                Bundle bundle2 = new Bundle();
                Iterator keys = jSONObject.keys();
                while (keys.hasNext()) {
                    valueOf = (String) keys.next();
                    bundle2.putString(valueOf, jSONObject.getString(valueOf));
                }
                bundle = bundle2;
            }
            if (this.f9836a instanceof AdMobAdapter) {
                bundle.putString("adJson", str2);
                bundle.putInt("tagForChildDirectedTreatment", i);
            }
            return bundle;
        } catch (Throwable th) {
            bze.m10491c("Could not get Server Parameters Bundle.", th);
            RemoteException remoteException = new RemoteException();
        }
    }

    public ckg mo1816a() {
        if (this.f9836a instanceof bzj) {
            try {
                return ckj.m11512a(((bzj) this.f9836a).mo229d());
            } catch (Throwable th) {
                bze.m10491c("Could not get banner view from adapter.", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            String str = "MediationAdapter is not a MediationBannerAdapter: ";
            String valueOf = String.valueOf(this.f9836a.getClass().getCanonicalName());
            bze.m10490c(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
            throw new RemoteException();
        }
    }

    public void mo1817a(AdRequestParcel adRequestParcel, String str) {
        mo1818a(adRequestParcel, str, null);
    }

    public void mo1818a(AdRequestParcel adRequestParcel, String str, String str2) {
        if (this.f9836a instanceof cal) {
            bze.m10485a("Requesting rewarded video ad from adapter.");
            try {
                cal com_ushareit_listenit_cal = (cal) this.f9836a;
                com_ushareit_listenit_cal.mo226a(new dja(adRequestParcel.f1505b == -1 ? null : new Date(adRequestParcel.f1505b), adRequestParcel.f1507d, adRequestParcel.f1508e != null ? new HashSet(adRequestParcel.f1508e) : null, adRequestParcel.f1514k, adRequestParcel.f1509f, adRequestParcel.f1510g, adRequestParcel.f1521r), m14552a(str, adRequestParcel.f1510g, str2), adRequestParcel.f1516m != null ? adRequestParcel.f1516m.getBundle(com_ushareit_listenit_cal.getClass().getName()) : null);
            } catch (Throwable th) {
                bze.m10491c("Could not load rewarded video ad from adapter.", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            String str3 = "MediationAdapter is not a MediationRewardedVideoAdAdapter: ";
            String valueOf = String.valueOf(this.f9836a.getClass().getCanonicalName());
            bze.m10490c(valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3));
            throw new RemoteException();
        }
    }

    public void mo1819a(ckg com_ushareit_listenit_ckg) {
        try {
            ((bzt) this.f9836a).m10523a((Context) ckj.m11513a(com_ushareit_listenit_ckg));
        } catch (Throwable th) {
            bze.m10486a("Could not inform adapter of changed context", th);
        }
    }

    public void mo1820a(ckg com_ushareit_listenit_ckg, AdRequestParcel adRequestParcel, String str, byv com_ushareit_listenit_byv, String str2) {
        if (this.f9836a instanceof cal) {
            bze.m10485a("Initialize rewarded video adapter.");
            try {
                cal com_ushareit_listenit_cal = (cal) this.f9836a;
                com_ushareit_listenit_cal.mo222a((Context) ckj.m11513a(com_ushareit_listenit_ckg), new dja(adRequestParcel.f1505b == -1 ? null : new Date(adRequestParcel.f1505b), adRequestParcel.f1507d, adRequestParcel.f1508e != null ? new HashSet(adRequestParcel.f1508e) : null, adRequestParcel.f1514k, adRequestParcel.f1509f, adRequestParcel.f1510g, adRequestParcel.f1521r), str, new byy(com_ushareit_listenit_byv), m14552a(str2, adRequestParcel.f1510g, null), adRequestParcel.f1516m != null ? adRequestParcel.f1516m.getBundle(com_ushareit_listenit_cal.getClass().getName()) : null);
            } catch (Throwable th) {
                bze.m10491c("Could not initialize rewarded video adapter.", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            String str3 = "MediationAdapter is not a MediationRewardedVideoAdAdapter: ";
            String valueOf = String.valueOf(this.f9836a.getClass().getCanonicalName());
            bze.m10490c(valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3));
            throw new RemoteException();
        }
    }

    public void mo1821a(ckg com_ushareit_listenit_ckg, AdRequestParcel adRequestParcel, String str, dio com_ushareit_listenit_dio) {
        mo1822a(com_ushareit_listenit_ckg, adRequestParcel, str, null, com_ushareit_listenit_dio);
    }

    public void mo1822a(ckg com_ushareit_listenit_ckg, AdRequestParcel adRequestParcel, String str, String str2, dio com_ushareit_listenit_dio) {
        if (this.f9836a instanceof bzl) {
            bze.m10485a("Requesting interstitial ad from adapter.");
            try {
                bzl com_ushareit_listenit_bzl = (bzl) this.f9836a;
                com_ushareit_listenit_bzl.mo224a((Context) ckj.m11513a(com_ushareit_listenit_ckg), new djc(com_ushareit_listenit_dio), m14552a(str, adRequestParcel.f1510g, str2), new dja(adRequestParcel.f1505b == -1 ? null : new Date(adRequestParcel.f1505b), adRequestParcel.f1507d, adRequestParcel.f1508e != null ? new HashSet(adRequestParcel.f1508e) : null, adRequestParcel.f1514k, adRequestParcel.f1509f, adRequestParcel.f1510g, adRequestParcel.f1521r), adRequestParcel.f1516m != null ? adRequestParcel.f1516m.getBundle(com_ushareit_listenit_bzl.getClass().getName()) : null);
            } catch (Throwable th) {
                bze.m10491c("Could not request interstitial ad from adapter.", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            String str3 = "MediationAdapter is not a MediationInterstitialAdapter: ";
            String valueOf = String.valueOf(this.f9836a.getClass().getCanonicalName());
            bze.m10490c(valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3));
            throw new RemoteException();
        }
    }

    public void mo1823a(ckg com_ushareit_listenit_ckg, AdRequestParcel adRequestParcel, String str, String str2, dio com_ushareit_listenit_dio, NativeAdOptionsParcel nativeAdOptionsParcel, List<String> list) {
        if (this.f9836a instanceof bzn) {
            try {
                bzn com_ushareit_listenit_bzn = (bzn) this.f9836a;
                djf com_ushareit_listenit_djf = new djf(adRequestParcel.f1505b == -1 ? null : new Date(adRequestParcel.f1505b), adRequestParcel.f1507d, adRequestParcel.f1508e != null ? new HashSet(adRequestParcel.f1508e) : null, adRequestParcel.f1514k, adRequestParcel.f1509f, adRequestParcel.f1510g, nativeAdOptionsParcel, list, adRequestParcel.f1521r);
                Bundle bundle = adRequestParcel.f1516m != null ? adRequestParcel.f1516m.getBundle(com_ushareit_listenit_bzn.getClass().getName()) : null;
                this.f9837b = new djc(com_ushareit_listenit_dio);
                com_ushareit_listenit_bzn.mo225a((Context) ckj.m11513a(com_ushareit_listenit_ckg), this.f9837b, m14552a(str, adRequestParcel.f1510g, str2), com_ushareit_listenit_djf, bundle);
            } catch (Throwable th) {
                bze.m10491c("Could not request native ad from adapter.", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            String str3 = "MediationAdapter is not a MediationNativeAdapter: ";
            String valueOf = String.valueOf(this.f9836a.getClass().getCanonicalName());
            bze.m10490c(valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3));
            throw new RemoteException();
        }
    }

    public void mo1824a(ckg com_ushareit_listenit_ckg, AdSizeParcel adSizeParcel, AdRequestParcel adRequestParcel, String str, dio com_ushareit_listenit_dio) {
        mo1825a(com_ushareit_listenit_ckg, adSizeParcel, adRequestParcel, str, null, com_ushareit_listenit_dio);
    }

    public void mo1825a(ckg com_ushareit_listenit_ckg, AdSizeParcel adSizeParcel, AdRequestParcel adRequestParcel, String str, String str2, dio com_ushareit_listenit_dio) {
        if (this.f9836a instanceof bzj) {
            bze.m10485a("Requesting banner ad from adapter.");
            try {
                bzj com_ushareit_listenit_bzj = (bzj) this.f9836a;
                com_ushareit_listenit_bzj.mo223a((Context) ckj.m11513a(com_ushareit_listenit_ckg), new djc(com_ushareit_listenit_dio), m14552a(str, adRequestParcel.f1510g, str2), cao.m10568a(adSizeParcel.f1527f, adSizeParcel.f1524c, adSizeParcel.f1523b), new dja(adRequestParcel.f1505b == -1 ? null : new Date(adRequestParcel.f1505b), adRequestParcel.f1507d, adRequestParcel.f1508e != null ? new HashSet(adRequestParcel.f1508e) : null, adRequestParcel.f1514k, adRequestParcel.f1509f, adRequestParcel.f1510g, adRequestParcel.f1521r), adRequestParcel.f1516m != null ? adRequestParcel.f1516m.getBundle(com_ushareit_listenit_bzj.getClass().getName()) : null);
            } catch (Throwable th) {
                bze.m10491c("Could not request banner ad from adapter.", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            String str3 = "MediationAdapter is not a MediationBannerAdapter: ";
            String valueOf = String.valueOf(this.f9836a.getClass().getCanonicalName());
            bze.m10490c(valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3));
            throw new RemoteException();
        }
    }

    public void mo1826b() {
        if (this.f9836a instanceof bzl) {
            bze.m10485a("Showing interstitial from adapter.");
            try {
                ((bzl) this.f9836a).mo230e();
            } catch (Throwable th) {
                bze.m10491c("Could not show interstitial from adapter.", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            String str = "MediationAdapter is not a MediationInterstitialAdapter: ";
            String valueOf = String.valueOf(this.f9836a.getClass().getCanonicalName());
            bze.m10490c(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
            throw new RemoteException();
        }
    }

    public void mo1827c() {
        try {
            this.f9836a.mo221a();
        } catch (Throwable th) {
            bze.m10491c("Could not destroy adapter.", th);
            RemoteException remoteException = new RemoteException();
        }
    }

    public void mo1828d() {
        try {
            this.f9836a.mo227b();
        } catch (Throwable th) {
            bze.m10491c("Could not pause adapter.", th);
            RemoteException remoteException = new RemoteException();
        }
    }

    public void mo1829e() {
        try {
            this.f9836a.mo228c();
        } catch (Throwable th) {
            bze.m10491c("Could not resume adapter.", th);
            RemoteException remoteException = new RemoteException();
        }
    }

    public void mo1830f() {
        if (this.f9836a instanceof cal) {
            bze.m10485a("Show rewarded video ad from adapter.");
            try {
                ((cal) this.f9836a).mo232g();
            } catch (Throwable th) {
                bze.m10491c("Could not show rewarded video ad from adapter.", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            String str = "MediationAdapter is not a MediationRewardedVideoAdAdapter: ";
            String valueOf = String.valueOf(this.f9836a.getClass().getCanonicalName());
            bze.m10490c(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
            throw new RemoteException();
        }
    }

    public boolean mo1831g() {
        if (this.f9836a instanceof cal) {
            bze.m10485a("Check if adapter is initialized.");
            try {
                return ((cal) this.f9836a).mo233h();
            } catch (Throwable th) {
                bze.m10491c("Could not check if adapter is initialized.", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            String str = "MediationAdapter is not a MediationRewardedVideoAdAdapter: ";
            String valueOf = String.valueOf(this.f9836a.getClass().getCanonicalName());
            bze.m10490c(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
            throw new RemoteException();
        }
    }

    public diu mo1832h() {
        bzp a = this.f9837b.m14574a();
        return a instanceof bzq ? new djd((bzq) a) : null;
    }

    public dix mo1833i() {
        bzp a = this.f9837b.m14574a();
        return a instanceof bzr ? new dje((bzr) a) : null;
    }

    public Bundle mo1834j() {
        if (this.f9836a instanceof dkq) {
            return ((dkq) this.f9836a).m14736e();
        }
        String str = "MediationAdapter is not a v2 MediationBannerAdapter: ";
        String valueOf = String.valueOf(this.f9836a.getClass().getCanonicalName());
        bze.m10490c(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
        return new Bundle();
    }

    public Bundle mo1835k() {
        if (this.f9836a instanceof dkr) {
            return ((dkr) this.f9836a).mo231f();
        }
        String str = "MediationAdapter is not a v2 MediationInterstitialAdapter: ";
        String valueOf = String.valueOf(this.f9836a.getClass().getCanonicalName());
        bze.m10490c(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
        return new Bundle();
    }

    public Bundle mo1836l() {
        return new Bundle();
    }
}
