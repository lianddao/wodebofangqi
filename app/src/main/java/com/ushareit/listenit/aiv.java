package com.ushareit.listenit;

import com.facebook.GraphRequest;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Locale;

public class aiv implements aiz {
    final /* synthetic */ ArrayList f4454a;
    final /* synthetic */ GraphRequest f4455b;

    public aiv(GraphRequest graphRequest, ArrayList arrayList) {
        this.f4455b = graphRequest;
        this.f4454a = arrayList;
    }

    public void mo638a(String str, String str2) {
        this.f4454a.add(String.format(Locale.US, "%s=%s", new Object[]{str, URLEncoder.encode(str2, "UTF-8")}));
    }
}
