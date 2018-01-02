package com.ushareit.listenit;

import android.text.SpannableString;
import android.text.style.LeadingMarginSpan.Standard;
import android.view.ViewGroup;

public abstract class fgx {
    private ffl f12670a;
    private ViewGroup f12671b;

    public abstract void mo2374a(ViewGroup viewGroup, esi com_ushareit_listenit_esi);

    public abstract void mo2375a(ViewGroup viewGroup, esi com_ushareit_listenit_esi, fev com_ushareit_listenit_fev);

    public abstract void mo2376b(ViewGroup viewGroup, esi com_ushareit_listenit_esi);

    public abstract void mo2377c(ViewGroup viewGroup, esi com_ushareit_listenit_esi);

    public abstract void mo2378d(ViewGroup viewGroup, esi com_ushareit_listenit_esi);

    public abstract void mo2379e(ViewGroup viewGroup, esi com_ushareit_listenit_esi);

    protected fgx(ViewGroup viewGroup, ffl com_ushareit_listenit_ffl) {
        this.f12670a = com_ushareit_listenit_ffl;
        this.f12671b = viewGroup;
    }

    public static fgx m19161a(ViewGroup viewGroup, ffl com_ushareit_listenit_ffl) {
        String str = com_ushareit_listenit_ffl.a;
        Object obj = -1;
        switch (str.hashCode()) {
            case -963929852:
                if (str.equals("admobapp")) {
                    obj = 2;
                    break;
                }
                break;
            case -963927963:
                if (str.equals("admobcon")) {
                    obj = 3;
                    break;
                }
                break;
            case 92668925:
                if (str.equals("admob")) {
                    obj = 1;
                    break;
                }
                break;
            case 104081947:
                if (str.equals("mopub")) {
                    obj = 4;
                    break;
                }
                break;
            case 497130182:
                if (str.equals("facebook")) {
                    obj = null;
                    break;
                }
                break;
        }
        switch (obj) {
            case null:
                return new fgy(viewGroup, com_ushareit_listenit_ffl);
            case 1:
            case 2:
            case 3:
                return new fgm(viewGroup, com_ushareit_listenit_ffl);
            case 4:
                return new fhe(viewGroup, com_ushareit_listenit_ffl);
            default:
                return null;
        }
    }

    public void m19165a(esi com_ushareit_listenit_esi) {
        m19168b(com_ushareit_listenit_esi);
        this.f12671b.removeAllViews();
        String str = this.f12670a.f12607l;
        Object obj = -1;
        switch (str.hashCode()) {
            case -1877643078:
                if (str.equals("play_page")) {
                    obj = 2;
                    break;
                }
                break;
            case -1194876546:
                if (str.equals("flash_page")) {
                    obj = null;
                    break;
                }
                break;
            case 1127651229:
                if (str.equals("charging_page")) {
                    obj = 4;
                    break;
                }
                break;
            case 1226023031:
                if (str.equals("lockscreen_page")) {
                    obj = 3;
                    break;
                }
                break;
            case 2063193412:
                if (str.equals("all_song_list_page")) {
                    obj = 1;
                    break;
                }
                break;
        }
        switch (obj) {
            case null:
                mo2374a(this.f12671b, com_ushareit_listenit_esi);
                return;
            case 1:
                mo2377c(this.f12671b, com_ushareit_listenit_esi);
                return;
            case 2:
                mo2376b(this.f12671b, com_ushareit_listenit_esi);
                return;
            case 3:
                mo2378d(this.f12671b, com_ushareit_listenit_esi);
                return;
            case 4:
                mo2379e(this.f12671b, com_ushareit_listenit_esi);
                return;
            default:
                return;
        }
    }

    public void m19166a(esi com_ushareit_listenit_esi, fev com_ushareit_listenit_fev) {
        m19168b(com_ushareit_listenit_esi);
        this.f12671b.removeAllViews();
        String str = this.f12670a.f12607l;
        Object obj = -1;
        switch (str.hashCode()) {
            case -1877643078:
                if (str.equals("play_page")) {
                    obj = 2;
                    break;
                }
                break;
            case -1194876546:
                if (str.equals("flash_page")) {
                    obj = null;
                    break;
                }
                break;
            case 2063193412:
                if (str.equals("all_song_list_page")) {
                    obj = 1;
                    break;
                }
                break;
            case 2118081007:
                if (str.equals("home_page")) {
                    obj = 3;
                    break;
                }
                break;
        }
        switch (obj) {
            case null:
                mo2374a(this.f12671b, com_ushareit_listenit_esi);
                return;
            case 1:
                mo2377c(this.f12671b, com_ushareit_listenit_esi);
                return;
            case 2:
                mo2376b(this.f12671b, com_ushareit_listenit_esi);
                return;
            case 3:
                mo2375a(this.f12671b, com_ushareit_listenit_esi, com_ushareit_listenit_fev);
                return;
            default:
                return;
        }
    }

    SpannableString m19162a(CharSequence charSequence, int i) {
        SpannableString spannableString = new SpannableString(charSequence);
        spannableString.setSpan(new Standard(i, 0), 0, 0, 18);
        return spannableString;
    }

    protected void m19168b(esi com_ushareit_listenit_esi) {
        if (com_ushareit_listenit_esi != null && com_ushareit_listenit_esi.m17719b("NativeAdListener")) {
            ((fge) com_ushareit_listenit_esi.m17720c("NativeAdListener")).onNativeAdShow();
        }
    }

    protected void m19170c(esi com_ushareit_listenit_esi) {
        if (com_ushareit_listenit_esi != null && com_ushareit_listenit_esi.m17719b("NativeAdListener")) {
            ((fge) com_ushareit_listenit_esi.m17720c("NativeAdListener")).onNativeAdClose();
        }
    }
}
