package com.ushareit.listenit;

import android.content.Context;
import android.os.Build.VERSION;
import java.util.ArrayList;
import java.util.List;

public final class fhz implements esq {
    public List<etd> mo2383a(Context context) {
        boolean z = false;
        List<etd> arrayList = new ArrayList();
        boolean a = euo.m18017a(context, "umeng_page_use", true);
        boolean a2 = euo.m18017a(context, "umeng_event_use", true);
        if (a || a2) {
            arrayList.add(new fix(a, a2));
        }
        a = euo.m18017a(context, "firebase_page_use", true);
        a2 = euo.m18017a(context, "firebase_event_use", true);
        if ((a || a2) && VERSION.SDK_INT >= 9) {
            arrayList.add(new fia(a, a2));
        }
        a = fql.m20390b() || euo.m18017a(context, "beyla_page_use", true);
        if (fql.m20390b() || euo.m18017a(context, "beyla_event_use", true)) {
            z = true;
        }
        if (a || z) {
            ete.m17857a(fah.m18702a(context));
            arrayList.add(new ete(context, null, a, z));
        }
        return arrayList;
    }
}
