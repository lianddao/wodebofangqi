package com.ushareit.listenit;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.SearchAdRequestParcel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class bwg {
    public static final bwg f7882a = new bwg();

    protected bwg() {
    }

    public static bwg m10203a() {
        return f7882a;
    }

    public AdRequestParcel m10204a(Context context, bvi com_ushareit_listenit_bvi) {
        Date a = com_ushareit_listenit_bvi.m9968a();
        long time = a != null ? a.getTime() : -1;
        String b = com_ushareit_listenit_bvi.m9970b();
        int c = com_ushareit_listenit_bvi.m9971c();
        Collection d = com_ushareit_listenit_bvi.m9972d();
        List unmodifiableList = !d.isEmpty() ? Collections.unmodifiableList(new ArrayList(d)) : null;
        boolean a2 = com_ushareit_listenit_bvi.m9969a(context);
        int l = com_ushareit_listenit_bvi.m9980l();
        Location e = com_ushareit_listenit_bvi.m9973e();
        Bundle a3 = com_ushareit_listenit_bvi.m9967a(AdMobAdapter.class);
        boolean f = com_ushareit_listenit_bvi.m9974f();
        String g = com_ushareit_listenit_bvi.m9975g();
        can i = com_ushareit_listenit_bvi.m9977i();
        SearchAdRequestParcel searchAdRequestParcel = i != null ? new SearchAdRequestParcel(i) : null;
        String str = null;
        Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            str = bwt.m10268a().m10471a(Thread.currentThread().getStackTrace(), applicationContext.getPackageName());
        }
        return new AdRequestParcel(7, time, a3, c, unmodifiableList, a2, l, f, g, searchAdRequestParcel, e, b, com_ushareit_listenit_bvi.m9979k(), com_ushareit_listenit_bvi.m9981m(), Collections.unmodifiableList(new ArrayList(com_ushareit_listenit_bvi.m9982n())), com_ushareit_listenit_bvi.m9976h(), str, com_ushareit_listenit_bvi.m9983o());
    }
}
