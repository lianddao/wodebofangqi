package com.ushareit.listenit;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.mopub.common.Preconditions.NoThrow;
import com.mopub.common.logging.MoPubLog;
import com.mopub.nativeads.NativeAd;
import com.mopub.nativeads.ViewBinder;
import java.util.WeakHashMap;

@Deprecated
public class enj {
    private static final WeakHashMap<View, NativeAd> f11309a = new WeakHashMap();

    @Deprecated
    public static View m17203a(View view, ViewGroup viewGroup, Context context, NativeAd nativeAd, ViewBinder viewBinder) {
        NoThrow.checkNotNull(viewBinder, "ViewBinder is null.");
        if (view != null) {
            m17204a(context, view);
        }
        if (nativeAd == null || nativeAd.isDestroyed() || viewBinder == null) {
            MoPubLog.m2753d("NativeAd or viewBinder null or invalid. Returning empty view");
            if (view != null && enk.EMPTY.equals(view.getTag())) {
                return view;
            }
            view = new View(context);
            view.setTag(enk.EMPTY);
            view.setVisibility(8);
            return view;
        }
        if (view == null || !enk.AD.equals(view.getTag())) {
            view = nativeAd.createAdView(context, viewGroup);
            view.setTag(enk.AD);
        }
        m17205a(context, view, nativeAd);
        nativeAd.renderAdView(view);
        return view;
    }

    private static void m17204a(Context context, View view) {
        NativeAd nativeAd = (NativeAd) f11309a.get(view);
        if (nativeAd != null) {
            nativeAd.clear(view);
        }
    }

    private static void m17205a(Context context, View view, NativeAd nativeAd) {
        f11309a.put(view, nativeAd);
        nativeAd.prepare(view);
    }
}
