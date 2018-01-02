package com.ushareit.listenit;

import android.os.Bundle;
import com.facebook.AccessToken;
import com.facebook.GraphRequest;
import com.facebook.internal.bk;
import com.facebook.internal.cb;
import org.json.JSONObject;

class bbc extends bay {
    String f5838e = this.f5842i.f5792n;
    String f5839f = this.f5842i.f5793o;
    String f5840g = this.f5842i.f5794p;
    String f5841h = this.f5842i.f5795q;
    final /* synthetic */ bak f5842i;

    bbc(bak com_ushareit_listenit_bak, String str, bdm com_ushareit_listenit_bdm) {
        this.f5842i = com_ushareit_listenit_bak;
        super(com_ushareit_listenit_bak, str, com_ushareit_listenit_bdm);
        Bundle bundle = new Bundle();
        bundle.putString("fields", "engagement.fields(count_string_with_like,count_string_without_like,social_sentence_with_like,social_sentence_without_like)");
        m7586a(new GraphRequest(AccessToken.m671a(), str, bundle, aji.GET));
    }

    protected void mo829a(ajh com_ushareit_listenit_ajh) {
        JSONObject b = cb.m1598b(com_ushareit_listenit_ajh.m5777b(), "engagement");
        if (b != null) {
            this.f5838e = b.optString("count_string_with_like", this.f5838e);
            this.f5839f = b.optString("count_string_without_like", this.f5839f);
            this.f5840g = b.optString("social_sentence_with_like", this.f5840g);
            this.f5841h = b.optString("social_sentence_without_like", this.f5841h);
        }
    }

    protected void mo828a(aih com_ushareit_listenit_aih) {
        bk.m1465a(ajk.REQUESTS, bak.f5779a, "Error fetching engagement for object '%s' with type '%s' : %s", this.a, this.b, com_ushareit_listenit_aih);
        this.f5842i.m7508a("get_engagement", com_ushareit_listenit_aih);
    }
}
