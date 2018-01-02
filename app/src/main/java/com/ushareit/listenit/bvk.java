package com.ushareit.listenit;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.VideoOptionsParcel;
import com.google.android.gms.ads.internal.client.zzk;
import java.util.concurrent.atomic.AtomicBoolean;

public class bvk {
    final bwv f7823a;
    private final dih f7824b;
    private final bwg f7825c;
    private final AtomicBoolean f7826d;
    private final buf f7827e;
    private buy f7828f;
    private btu f7829g;
    private bua[] f7830h;
    private buk f7831i;
    private bub f7832j;
    private bxl f7833k;
    private cag f7834l;
    private bum f7835m;
    private cai f7836n;
    private buh f7837o;
    private String f7838p;
    private String f7839q;
    private ViewGroup f7840r;
    private boolean f7841s;
    private boolean f7842t;

    public bvk(ViewGroup viewGroup) {
        this(viewGroup, null, false, bwg.m10203a(), false);
    }

    public bvk(ViewGroup viewGroup, AttributeSet attributeSet, boolean z) {
        this(viewGroup, attributeSet, z, bwg.m10203a(), false);
    }

    bvk(ViewGroup viewGroup, AttributeSet attributeSet, boolean z, bwg com_ushareit_listenit_bwg, bxl com_ushareit_listenit_bxl, boolean z2) {
        this.f7824b = new dih();
        this.f7827e = new buf();
        this.f7823a = new bvl(this);
        this.f7840r = viewGroup;
        this.f7825c = com_ushareit_listenit_bwg;
        this.f7833k = com_ushareit_listenit_bxl;
        this.f7826d = new AtomicBoolean(false);
        this.f7841s = z2;
        if (attributeSet != null) {
            Context context = viewGroup.getContext();
            try {
                zzk com_google_android_gms_ads_internal_client_zzk = new zzk(context, attributeSet);
                this.f7830h = com_google_android_gms_ads_internal_client_zzk.m2153a(z);
                this.f7838p = com_google_android_gms_ads_internal_client_zzk.m2152a();
                if (viewGroup.isInEditMode()) {
                    bwt.m10268a().m10474a(viewGroup, m10009a(context, this.f7830h[0], this.f7841s), "Ads by Google");
                }
            } catch (IllegalArgumentException e) {
                bwt.m10268a().m10475a(viewGroup, new AdSizeParcel(context, bua.f7753a), e.getMessage(), e.getMessage());
            }
        }
    }

    bvk(ViewGroup viewGroup, AttributeSet attributeSet, boolean z, bwg com_ushareit_listenit_bwg, boolean z2) {
        this(viewGroup, attributeSet, z, com_ushareit_listenit_bwg, null, z2);
    }

    public bvk(ViewGroup viewGroup, AttributeSet attributeSet, boolean z, boolean z2) {
        this(viewGroup, attributeSet, z, bwg.m10203a(), z2);
    }

    public bvk(ViewGroup viewGroup, boolean z) {
        this(viewGroup, null, false, bwg.m10203a(), z);
    }

    private static AdSizeParcel m10009a(Context context, bua com_ushareit_listenit_bua, boolean z) {
        AdSizeParcel adSizeParcel = new AdSizeParcel(context, com_ushareit_listenit_bua);
        adSizeParcel.m2149a(z);
        return adSizeParcel;
    }

    private static AdSizeParcel m10010a(Context context, bua[] com_ushareit_listenit_buaArr, boolean z) {
        AdSizeParcel adSizeParcel = new AdSizeParcel(context, com_ushareit_listenit_buaArr);
        adSizeParcel.m2149a(z);
        return adSizeParcel;
    }

    private void m10012q() {
        try {
            ckg a = this.f7833k.mo1130a();
            if (a != null) {
                this.f7840r.addView((View) ckj.m11513a(a));
            }
        } catch (Throwable e) {
            bze.m10491c("Failed to get an ad frame.", e);
        }
    }

    public void m10013a() {
        try {
            if (this.f7833k != null) {
                this.f7833k.mo1144b();
            }
        } catch (Throwable e) {
            bze.m10491c("Failed to destroy AdView.", e);
        }
    }

    public void m10014a(btu com_ushareit_listenit_btu) {
        this.f7829g = com_ushareit_listenit_btu;
        this.f7823a.m10043a(com_ushareit_listenit_btu);
    }

    public void m10015a(bub com_ushareit_listenit_bub) {
        this.f7832j = com_ushareit_listenit_bub;
        try {
            if (this.f7833k != null) {
                this.f7833k.mo1136a(this.f7832j == null ? null : this.f7832j.m9865a());
            }
        } catch (Throwable e) {
            bze.m10491c("Failed to set correlator.", e);
        }
    }

    public void m10016a(buh com_ushareit_listenit_buh) {
        this.f7837o = com_ushareit_listenit_buh;
        try {
            if (this.f7833k != null) {
                this.f7833k.mo1132a(com_ushareit_listenit_buh == null ? null : new VideoOptionsParcel(com_ushareit_listenit_buh));
            }
        } catch (Throwable e) {
            bze.m10491c("Failed to set video options.", e);
        }
    }

    public void m10017a(buk com_ushareit_listenit_buk) {
        try {
            this.f7831i = com_ushareit_listenit_buk;
            if (this.f7833k != null) {
                this.f7833k.mo1135a(com_ushareit_listenit_buk != null ? new bwi(com_ushareit_listenit_buk) : null);
            }
        } catch (Throwable e) {
            bze.m10491c("Failed to set the AppEventListener.", e);
        }
    }

    public void m10018a(bum com_ushareit_listenit_bum) {
        this.f7835m = com_ushareit_listenit_bum;
        try {
            if (this.f7833k != null) {
                this.f7833k.mo1138a(com_ushareit_listenit_bum != null ? new dgw(com_ushareit_listenit_bum) : null);
            }
        } catch (Throwable e) {
            bze.m10491c("Failed to set the onCustomRenderedAdLoadedListener.", e);
        }
    }

    public void m10019a(buy com_ushareit_listenit_buy) {
        try {
            this.f7828f = com_ushareit_listenit_buy;
            if (this.f7833k != null) {
                this.f7833k.mo1133a(com_ushareit_listenit_buy != null ? new bwb(com_ushareit_listenit_buy) : null);
            }
        } catch (Throwable e) {
            bze.m10491c("Failed to set the AdClickListener.", e);
        }
    }

    public void m10020a(bvi com_ushareit_listenit_bvi) {
        try {
            if (this.f7833k == null) {
                m10041o();
            }
            if (this.f7833k.mo1143a(this.f7825c.m10204a(this.f7840r.getContext(), com_ushareit_listenit_bvi))) {
                this.f7824b.m14418a(com_ushareit_listenit_bvi.m9978j());
            }
        } catch (Throwable e) {
            bze.m10491c("Failed to load ad.", e);
        }
    }

    public void m10021a(cag com_ushareit_listenit_cag) {
        if (this.f7836n != null) {
            throw new IllegalStateException("Play store purchase parameter has already been set.");
        }
        try {
            this.f7834l = com_ushareit_listenit_cag;
            if (this.f7833k != null) {
                this.f7833k.mo1139a(com_ushareit_listenit_cag != null ? new dkl(com_ushareit_listenit_cag) : null);
            }
        } catch (Throwable e) {
            bze.m10491c("Failed to set the InAppPurchaseListener.", e);
        }
    }

    public void m10022a(cai com_ushareit_listenit_cai, String str) {
        if (this.f7834l != null) {
            throw new IllegalStateException("InAppPurchaseListener has already been set.");
        }
        try {
            this.f7836n = com_ushareit_listenit_cai;
            this.f7839q = str;
            if (this.f7833k != null) {
                this.f7833k.mo1140a(com_ushareit_listenit_cai != null ? new dkp(com_ushareit_listenit_cai) : null, str);
            }
        } catch (Throwable e) {
            bze.m10491c("Failed to set the play store purchase parameter.", e);
        }
    }

    public void m10023a(String str) {
        if (this.f7838p != null) {
            throw new IllegalStateException("The ad unit ID can only be set once on AdView.");
        }
        this.f7838p = str;
    }

    public void m10024a(boolean z) {
        this.f7842t = z;
        try {
            if (this.f7833k != null) {
                this.f7833k.mo1142a(this.f7842t);
            }
        } catch (Throwable e) {
            bze.m10491c("Failed to set manual impressions.", e);
        }
    }

    public void m10025a(bua... com_ushareit_listenit_buaArr) {
        if (this.f7830h != null) {
            throw new IllegalStateException("The ad size can only be set once on AdView.");
        }
        m10028b(com_ushareit_listenit_buaArr);
    }

    public boolean m10026a(AdSizeParcel adSizeParcel) {
        return "search_v2".equals(adSizeParcel.f1523b);
    }

    public btu m10027b() {
        return this.f7829g;
    }

    public void m10028b(bua... com_ushareit_listenit_buaArr) {
        this.f7830h = com_ushareit_listenit_buaArr;
        try {
            if (this.f7833k != null) {
                this.f7833k.mo1131a(m10010a(this.f7840r.getContext(), this.f7830h, this.f7841s));
            }
        } catch (Throwable e) {
            bze.m10491c("Failed to set the ad size.", e);
        }
        this.f7840r.requestLayout();
    }

    public bua m10029c() {
        try {
            if (this.f7833k != null) {
                AdSizeParcel i = this.f7833k.mo1151i();
                if (i != null) {
                    return i.m2150b();
                }
            }
        } catch (Throwable e) {
            bze.m10491c("Failed to get the current AdSize.", e);
        }
        return this.f7830h != null ? this.f7830h[0] : null;
    }

    public bua[] m10030d() {
        return this.f7830h;
    }

    public String m10031e() {
        return this.f7838p;
    }

    public buk m10032f() {
        return this.f7831i;
    }

    public cag m10033g() {
        return this.f7834l;
    }

    public bum m10034h() {
        return this.f7835m;
    }

    public void m10035i() {
        try {
            if (this.f7833k != null) {
                this.f7833k.mo1146d();
            }
        } catch (Throwable e) {
            bze.m10491c("Failed to call pause.", e);
        }
    }

    public void m10036j() {
        try {
            if (this.f7833k != null) {
                this.f7833k.mo1147e();
            }
        } catch (Throwable e) {
            bze.m10491c("Failed to call resume.", e);
        }
    }

    public String m10037k() {
        try {
            if (this.f7833k != null) {
                return this.f7833k.mo1152j();
            }
        } catch (Throwable e) {
            bze.m10491c("Failed to get the mediation adapter class name.", e);
        }
        return null;
    }

    public buf m10038l() {
        return this.f7827e;
    }

    public bvc m10039m() {
        bvc com_ushareit_listenit_bvc = null;
        if (this.f7833k != null) {
            try {
                com_ushareit_listenit_bvc = this.f7833k.mo1154l();
            } catch (Throwable e) {
                bze.m10491c("Failed to retrieve VideoController.", e);
            }
        }
        return com_ushareit_listenit_bvc;
    }

    public buh m10040n() {
        return this.f7837o;
    }

    void m10041o() {
        if ((this.f7830h == null || this.f7838p == null) && this.f7833k == null) {
            throw new IllegalStateException("The ad size and ad unit ID must be set before loadAd is called.");
        }
        this.f7833k = m10042p();
        this.f7833k.mo1134a(new bwc(this.f7823a));
        if (this.f7828f != null) {
            this.f7833k.mo1133a(new bwb(this.f7828f));
        }
        if (this.f7831i != null) {
            this.f7833k.mo1135a(new bwi(this.f7831i));
        }
        if (this.f7834l != null) {
            this.f7833k.mo1139a(new dkl(this.f7834l));
        }
        if (this.f7836n != null) {
            this.f7833k.mo1140a(new dkp(this.f7836n), this.f7839q);
        }
        if (this.f7835m != null) {
            this.f7833k.mo1138a(new dgw(this.f7835m));
        }
        if (this.f7832j != null) {
            this.f7833k.mo1136a(this.f7832j.m9865a());
        }
        if (this.f7837o != null) {
            this.f7833k.mo1132a(new VideoOptionsParcel(this.f7837o));
        }
        this.f7833k.mo1142a(this.f7842t);
        m10012q();
    }

    protected bxl m10042p() {
        Context context = this.f7840r.getContext();
        AdSizeParcel a = m10010a(context, this.f7830h, this.f7841s);
        return m10026a(a) ? bwt.m10270b().m10224a(context, a, this.f7838p) : bwt.m10270b().m10225a(context, a, this.f7838p, this.f7824b);
    }
}
