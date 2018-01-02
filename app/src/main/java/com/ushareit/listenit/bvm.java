package com.ushareit.listenit;

import android.content.Context;
import com.google.android.gms.ads.internal.client.AdSizeParcel;

public class bvm {
    private final dih f7846a;
    private final Context f7847b;
    private final bwg f7848c;
    private btu f7849d;
    private buy f7850e;
    private bxl f7851f;
    private String f7852g;
    private String f7853h;
    private buk f7854i;
    private cai f7855j;
    private cag f7856k;
    private bun f7857l;
    private bum f7858m;
    private bub f7859n;
    private cak f7860o;
    private boolean f7861p;

    public bvm(Context context) {
        this(context, bwg.m10203a(), null);
    }

    public bvm(Context context, bwg com_ushareit_listenit_bwg, bun com_ushareit_listenit_bun) {
        this.f7846a = new dih();
        this.f7847b = context;
        this.f7848c = com_ushareit_listenit_bwg;
        this.f7857l = com_ushareit_listenit_bun;
    }

    private void m10044b(String str) {
        if (this.f7852g == null) {
            m10045c(str);
        }
        this.f7851f = bwt.m10270b().m10230b(this.f7847b, this.f7861p ? AdSizeParcel.m2146a() : new AdSizeParcel(), this.f7852g, this.f7846a);
        if (this.f7849d != null) {
            this.f7851f.mo1134a(new bwc(this.f7849d));
        }
        if (this.f7850e != null) {
            this.f7851f.mo1133a(new bwb(this.f7850e));
        }
        if (this.f7854i != null) {
            this.f7851f.mo1135a(new bwi(this.f7854i));
        }
        if (this.f7856k != null) {
            this.f7851f.mo1139a(new dkl(this.f7856k));
        }
        if (this.f7855j != null) {
            this.f7851f.mo1140a(new dkp(this.f7855j), this.f7853h);
        }
        if (this.f7858m != null) {
            this.f7851f.mo1138a(new dgw(this.f7858m));
        }
        if (this.f7859n != null) {
            this.f7851f.mo1136a(this.f7859n.m9865a());
        }
        if (this.f7860o != null) {
            this.f7851f.mo1137a(new byt(this.f7860o));
        }
    }

    private void m10045c(String str) {
        if (this.f7851f == null) {
            throw new IllegalStateException(new StringBuilder(String.valueOf(str).length() + 63).append("The ad unit ID must be set on InterstitialAd before ").append(str).append(" is called.").toString());
        }
    }

    public String m10046a() {
        return this.f7852g;
    }

    public void m10047a(btu com_ushareit_listenit_btu) {
        try {
            this.f7849d = com_ushareit_listenit_btu;
            if (this.f7851f != null) {
                this.f7851f.mo1134a(com_ushareit_listenit_btu != null ? new bwc(com_ushareit_listenit_btu) : null);
            }
        } catch (Throwable e) {
            bze.m10491c("Failed to set the AdListener.", e);
        }
    }

    public void m10048a(buy com_ushareit_listenit_buy) {
        try {
            this.f7850e = com_ushareit_listenit_buy;
            if (this.f7851f != null) {
                this.f7851f.mo1133a(com_ushareit_listenit_buy != null ? new bwb(com_ushareit_listenit_buy) : null);
            }
        } catch (Throwable e) {
            bze.m10491c("Failed to set the AdClickListener.", e);
        }
    }

    public void m10049a(bvi com_ushareit_listenit_bvi) {
        try {
            if (this.f7851f == null) {
                m10044b("loadAd");
            }
            if (this.f7851f.mo1143a(this.f7848c.m10204a(this.f7847b, com_ushareit_listenit_bvi))) {
                this.f7846a.m14418a(com_ushareit_listenit_bvi.m9978j());
            }
        } catch (Throwable e) {
            bze.m10491c("Failed to load ad.", e);
        }
    }

    public void m10050a(cak com_ushareit_listenit_cak) {
        try {
            this.f7860o = com_ushareit_listenit_cak;
            if (this.f7851f != null) {
                this.f7851f.mo1137a(com_ushareit_listenit_cak != null ? new byt(com_ushareit_listenit_cak) : null);
            }
        } catch (Throwable e) {
            bze.m10491c("Failed to set the AdListener.", e);
        }
    }

    public void m10051a(String str) {
        if (this.f7852g != null) {
            throw new IllegalStateException("The ad unit ID can only be set once on InterstitialAd.");
        }
        this.f7852g = str;
    }

    public void m10052a(boolean z) {
        this.f7861p = z;
    }

    public boolean m10053b() {
        boolean z = false;
        try {
            if (this.f7851f != null) {
                z = this.f7851f.mo1145c();
            }
        } catch (Throwable e) {
            bze.m10491c("Failed to check if ad is ready.", e);
        }
        return z;
    }

    public void m10054c() {
        try {
            m10045c("show");
            this.f7851f.mo1148f();
        } catch (Throwable e) {
            bze.m10491c("Failed to show interstitial.", e);
        }
    }
}
