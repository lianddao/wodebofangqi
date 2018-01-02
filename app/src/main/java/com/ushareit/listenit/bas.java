package com.ushareit.listenit;

import android.os.Bundle;
import com.facebook.internal.C0093a;
import com.facebook.internal.bk;
import com.facebook.internal.bp;

class bas extends bcc {
    final /* synthetic */ Bundle f5816a;
    final /* synthetic */ bak f5817b;

    bas(bak com_ushareit_listenit_bak, aic com_ushareit_listenit_aic, Bundle bundle) {
        this.f5817b = com_ushareit_listenit_bak;
        this.f5816a = bundle;
        super(com_ushareit_listenit_aic);
    }

    public void mo825a(C0093a c0093a, Bundle bundle) {
        if (bundle != null && bundle.containsKey("object_is_liked")) {
            boolean z = bundle.getBoolean("object_is_liked");
            String b = this.f5817b.f5792n;
            String c = this.f5817b.f5793o;
            if (bundle.containsKey("like_count_string")) {
                c = bundle.getString("like_count_string");
                b = c;
            }
            String d = this.f5817b.f5794p;
            String e = this.f5817b.f5795q;
            if (bundle.containsKey("social_sentence")) {
                e = bundle.getString("social_sentence");
                d = e;
            }
            String string = bundle.containsKey("object_is_liked") ? bundle.getString("unlike_token") : this.f5817b.f5796r;
            Bundle bundle2 = this.f5816a == null ? new Bundle() : this.f5816a;
            bundle2.putString("call_id", c0093a.m1247c().toString());
            this.f5817b.m7555l().m1207a("fb_like_control_dialog_did_succeed", null, bundle2);
            this.f5817b.m7513a(z, b, c, d, e, string);
        }
    }

    public void mo826a(C0093a c0093a, aif com_ushareit_listenit_aif) {
        bk.m1465a(ajk.REQUESTS, bak.f5779a, "Like Dialog failed with error : %s", com_ushareit_listenit_aif);
        Bundle bundle = this.f5816a == null ? new Bundle() : this.f5816a;
        bundle.putString("call_id", c0093a.m1247c().toString());
        this.f5817b.m7507a("present_dialog", bundle);
        bak.m7532c(this.f5817b, "com.facebook.sdk.LikeActionController.DID_ERROR", bp.m1505a(com_ushareit_listenit_aif));
    }

    public void mo824a(C0093a c0093a) {
        mo826a(c0093a, new aig());
    }
}
