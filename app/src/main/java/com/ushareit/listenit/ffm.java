package com.ushareit.listenit;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import com.facebook.ads.af;
import com.facebook.ads.an;
import com.mopub.nativeads.NativeAd;
import com.mopub.nativeads.StaticNativeAd;
import com.umeng.analytics.C0154a;
import java.util.ArrayList;
import java.util.List;

public class ffm {
    public static void m19110a(af afVar, ffl com_ushareit_listenit_ffl, fge com_ushareit_listenit_fge, ffs com_ushareit_listenit_ffs) {
        if (afVar != null) {
            an e = afVar.m903e();
            if ("flash_page".equals(com_ushareit_listenit_ffl.f12607l)) {
                fzi.m21395a(eys.m18562a(), Uri.parse(e.m949a()), null, e.m950b(), e.m951c(), new ffn(com_ushareit_listenit_ffl, afVar, com_ushareit_listenit_fge, com_ushareit_listenit_ffs));
                return;
            }
            List arrayList = new ArrayList();
            esi com_ushareit_listenit_esi = new esi(com_ushareit_listenit_ffl.a, com_ushareit_listenit_ffl.c, C0154a.f2954j, afVar, com_ushareit_listenit_ffl.f12607l);
            com_ushareit_listenit_esi.m17715a("NativeAdListener", (Object) com_ushareit_listenit_fge);
            arrayList.add(com_ushareit_listenit_esi);
            if (com_ushareit_listenit_ffs != null) {
                com_ushareit_listenit_ffs.mo2371a(arrayList);
            }
        }
    }

    public static void m19111a(NativeAd nativeAd, ffl com_ushareit_listenit_ffl, ffs com_ushareit_listenit_ffs) {
        if (nativeAd != null) {
            StaticNativeAd staticNativeAd = (StaticNativeAd) nativeAd.getBaseNativeAd();
            int a = gyr.m23306a();
            int a2 = gyr.m23307a(190.0f);
            if ("flash_page".equals(com_ushareit_listenit_ffl.f12607l)) {
                fzi.m21395a(eys.m18562a(), Uri.parse(staticNativeAd.getMainImageUrl()), null, a, a2, new ffp(com_ushareit_listenit_ffl, nativeAd, com_ushareit_listenit_ffs));
                return;
            }
            List arrayList = new ArrayList();
            arrayList.add(new esi(com_ushareit_listenit_ffl.a, com_ushareit_listenit_ffl.c, C0154a.f2954j, nativeAd, com_ushareit_listenit_ffl.f12607l));
            if (com_ushareit_listenit_ffs != null) {
                com_ushareit_listenit_ffs.mo2371a(arrayList);
            }
        }
    }

    public static void m19112a(Object obj, ffl com_ushareit_listenit_ffl, fge com_ushareit_listenit_fge, ffs com_ushareit_listenit_ffs) {
        if (obj != null) {
            List list;
            if ("flash_page".equals(com_ushareit_listenit_ffl.f12607l)) {
                list = null;
                if (obj instanceof but) {
                    list = ((but) obj).mo1779c();
                } else if (obj instanceof buv) {
                    list = ((buv) obj).mo1798c();
                }
                if (list != null && list.get(0) != null) {
                    Bitmap bitmap = ((BitmapDrawable) ((bup) list.get(0)).mo1761a()).getBitmap();
                    gxm.m23097a(bitmap, "AdMobAdBackgroundBlurTask", new ffr(com_ushareit_listenit_ffl, obj, com_ushareit_listenit_fge, bitmap, com_ushareit_listenit_ffs));
                    return;
                }
                return;
            }
            list = new ArrayList();
            esi com_ushareit_listenit_esi = new esi(com_ushareit_listenit_ffl.a, com_ushareit_listenit_ffl.c, C0154a.f2954j, obj, com_ushareit_listenit_ffl.f12607l);
            com_ushareit_listenit_esi.m17715a("NativeAdListener", (Object) com_ushareit_listenit_fge);
            list.add(com_ushareit_listenit_esi);
            if (com_ushareit_listenit_ffs != null) {
                com_ushareit_listenit_ffs.mo2371a(list);
            }
        }
    }
}
