package com.ushareit.listenit;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.mopub.common.VisibleForTesting;
import com.mopub.common.logging.MoPubLog;
import com.mopub.nativeads.ViewBinder;

public class enz {
    @VisibleForTesting
    static final enz f11347h = new enz();
    public View f11348a;
    public TextView f11349b;
    public TextView f11350c;
    public TextView f11351d;
    public ImageView f11352e;
    public ImageView f11353f;
    public ImageView f11354g;

    private enz() {
    }

    public static enz m17241a(View view, ViewBinder viewBinder) {
        enz com_ushareit_listenit_enz = new enz();
        com_ushareit_listenit_enz.f11348a = view;
        try {
            com_ushareit_listenit_enz.f11349b = (TextView) view.findViewById(viewBinder.f2764b);
            com_ushareit_listenit_enz.f11350c = (TextView) view.findViewById(viewBinder.f2765c);
            com_ushareit_listenit_enz.f11351d = (TextView) view.findViewById(viewBinder.f2766d);
            com_ushareit_listenit_enz.f11352e = (ImageView) view.findViewById(viewBinder.f2767e);
            com_ushareit_listenit_enz.f11353f = (ImageView) view.findViewById(viewBinder.f2768f);
            com_ushareit_listenit_enz.f11354g = (ImageView) view.findViewById(viewBinder.f2769g);
            return com_ushareit_listenit_enz;
        } catch (Throwable e) {
            MoPubLog.m2762w("Could not cast from id in ViewBinder to expected View type", e);
            return f11347h;
        }
    }
}
