package com.ushareit.listenit;

import android.app.Activity;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public final class djg<NETWORK_EXTRAS extends bew, SERVER_PARAMETERS extends bet> extends dim {
    private final beo<NETWORK_EXTRAS, SERVER_PARAMETERS> f9851a;
    private final NETWORK_EXTRAS f9852b;

    public djg(beo<NETWORK_EXTRAS, SERVER_PARAMETERS> com_ushareit_listenit_beo_NETWORK_EXTRAS__SERVER_PARAMETERS, NETWORK_EXTRAS network_extras) {
        this.f9851a = com_ushareit_listenit_beo_NETWORK_EXTRAS__SERVER_PARAMETERS;
        this.f9852b = network_extras;
    }

    private SERVER_PARAMETERS m14632a(String str, int i, String str2) {
        Map hashMap;
        if (str != null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                hashMap = new HashMap(jSONObject.length());
                Iterator keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String str3 = (String) keys.next();
                    hashMap.put(str3, jSONObject.getString(str3));
                }
            } catch (Throwable th) {
                bze.m10491c("Could not get MediationServerParameters.", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            hashMap = new HashMap(0);
        }
        Class c = this.f9851a.mo240c();
        if (c == null) {
            return null;
        }
        bet com_ushareit_listenit_bet = (bet) c.newInstance();
        com_ushareit_listenit_bet.m7947a(hashMap);
        return com_ushareit_listenit_bet;
    }

    public ckg mo1816a() {
        if (this.f9851a instanceof bep) {
            try {
                return ckj.m11512a(((bep) this.f9851a).mo241d());
            } catch (Throwable th) {
                bze.m10491c("Could not get banner view from adapter.", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            String str = "MediationAdapter is not a MediationBannerAdapter: ";
            String valueOf = String.valueOf(this.f9851a.getClass().getCanonicalName());
            bze.m10490c(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
            throw new RemoteException();
        }
    }

    public void mo1817a(AdRequestParcel adRequestParcel, String str) {
    }

    public void mo1818a(AdRequestParcel adRequestParcel, String str, String str2) {
    }

    public void mo1819a(ckg com_ushareit_listenit_ckg) {
    }

    public void mo1820a(ckg com_ushareit_listenit_ckg, AdRequestParcel adRequestParcel, String str, byv com_ushareit_listenit_byv, String str2) {
    }

    public void mo1821a(ckg com_ushareit_listenit_ckg, AdRequestParcel adRequestParcel, String str, dio com_ushareit_listenit_dio) {
        mo1822a(com_ushareit_listenit_ckg, adRequestParcel, str, null, com_ushareit_listenit_dio);
    }

    public void mo1822a(ckg com_ushareit_listenit_ckg, AdRequestParcel adRequestParcel, String str, String str2, dio com_ushareit_listenit_dio) {
        if (this.f9851a instanceof ber) {
            bze.m10485a("Requesting interstitial ad from adapter.");
            try {
                ((ber) this.f9851a).mo238a(new djh(com_ushareit_listenit_dio), (Activity) ckj.m11513a(com_ushareit_listenit_ckg), m14632a(str, adRequestParcel.f1510g, str2), djk.m14660a(adRequestParcel), this.f9852b);
            } catch (Throwable th) {
                bze.m10491c("Could not request interstitial ad from adapter.", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            String str3 = "MediationAdapter is not a MediationInterstitialAdapter: ";
            String valueOf = String.valueOf(this.f9851a.getClass().getCanonicalName());
            bze.m10490c(valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3));
            throw new RemoteException();
        }
    }

    public void mo1823a(ckg com_ushareit_listenit_ckg, AdRequestParcel adRequestParcel, String str, String str2, dio com_ushareit_listenit_dio, NativeAdOptionsParcel nativeAdOptionsParcel, List<String> list) {
    }

    public void mo1824a(ckg com_ushareit_listenit_ckg, AdSizeParcel adSizeParcel, AdRequestParcel adRequestParcel, String str, dio com_ushareit_listenit_dio) {
        mo1825a(com_ushareit_listenit_ckg, adSizeParcel, adRequestParcel, str, null, com_ushareit_listenit_dio);
    }

    public void mo1825a(ckg com_ushareit_listenit_ckg, AdSizeParcel adSizeParcel, AdRequestParcel adRequestParcel, String str, String str2, dio com_ushareit_listenit_dio) {
        if (this.f9851a instanceof bep) {
            bze.m10485a("Requesting banner ad from adapter.");
            try {
                ((bep) this.f9851a).mo237a(new djh(com_ushareit_listenit_dio), (Activity) ckj.m11513a(com_ushareit_listenit_ckg), m14632a(str, adRequestParcel.f1510g, str2), djk.m14659a(adSizeParcel), djk.m14660a(adRequestParcel), this.f9852b);
            } catch (Throwable th) {
                bze.m10491c("Could not request banner ad from adapter.", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            String str3 = "MediationAdapter is not a MediationBannerAdapter: ";
            String valueOf = String.valueOf(this.f9851a.getClass().getCanonicalName());
            bze.m10490c(valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3));
            throw new RemoteException();
        }
    }

    public void mo1826b() {
        if (this.f9851a instanceof ber) {
            bze.m10485a("Showing interstitial from adapter.");
            try {
                ((ber) this.f9851a).mo242e();
            } catch (Throwable th) {
                bze.m10491c("Could not show interstitial from adapter.", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            String str = "MediationAdapter is not a MediationInterstitialAdapter: ";
            String valueOf = String.valueOf(this.f9851a.getClass().getCanonicalName());
            bze.m10490c(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
            throw new RemoteException();
        }
    }

    public void mo1827c() {
        try {
            this.f9851a.mo236a();
        } catch (Throwable th) {
            bze.m10491c("Could not destroy adapter.", th);
            RemoteException remoteException = new RemoteException();
        }
    }

    public void mo1828d() {
        throw new RemoteException();
    }

    public void mo1829e() {
        throw new RemoteException();
    }

    public void mo1830f() {
    }

    public boolean mo1831g() {
        return true;
    }

    public diu mo1832h() {
        return null;
    }

    public dix mo1833i() {
        return null;
    }

    public Bundle mo1834j() {
        return new Bundle();
    }

    public Bundle mo1835k() {
        return new Bundle();
    }

    public Bundle mo1836l() {
        return new Bundle();
    }
}
