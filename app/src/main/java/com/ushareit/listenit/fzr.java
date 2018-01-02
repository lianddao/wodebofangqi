package com.ushareit.listenit;

import android.content.Context;
import android.content.res.Resources.NotFoundException;
import android.net.Uri;
import java.io.InputStream;
import java.util.Locale;

public class fzr implements ze<gla, InputStream> {
    ze<byte[], InputStream> f13784a;
    private ze<Uri, InputStream> f13785b;
    private Context f13786c;

    public fzr(Context context, ze<Uri, InputStream> zeVar, ze<byte[], InputStream> zeVar2) {
        this.f13785b = zeVar;
        this.f13784a = zeVar2;
        this.f13786c = context;
    }

    public vc<InputStream> m21437a(gla com_ushareit_listenit_gla, int i, int i2) {
        return new fzp(com_ushareit_listenit_gla, m21436b(com_ushareit_listenit_gla, i, i2), new fzs(this, i, i2));
    }

    private String m21436b(gla com_ushareit_listenit_gla, int i, int i2) {
        if ((com_ushareit_listenit_gla instanceof glg) && gyn.m23260p(com_ushareit_listenit_gla.mo2558g())) {
            return ((glg) com_ushareit_listenit_gla).f14343k + "-" + i + "-" + i2;
        }
        long d = com_ushareit_listenit_gla.mo2702d();
        int b = com_ushareit_listenit_gla.mo2561b();
        return String.format(Locale.US, "%s_%d_%d_%d_%d", new Object[]{com_ushareit_listenit_gla.mo2557a(), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(b), Long.valueOf(d)});
    }

    private Uri m21433a(Context context, Integer num) {
        try {
            return Uri.parse("android.resource://" + context.getResources().getResourcePackageName(num.intValue()) + '/' + context.getResources().getResourceTypeName(num.intValue()) + '/' + context.getResources().getResourceEntryName(num.intValue()));
        } catch (NotFoundException e) {
            return null;
        }
    }
}
