package com.ushareit.listenit;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;

public class cd extends cp {
    CharSequence f8140a;
    CharSequence f8141b;
    List<ce> f8142c = new ArrayList();

    cd() {
    }

    public void mo1286a(Bundle bundle) {
        super.mo1286a(bundle);
        if (this.f8140a != null) {
            bundle.putCharSequence("android.selfDisplayName", this.f8140a);
        }
        if (this.f8141b != null) {
            bundle.putCharSequence("android.conversationTitle", this.f8141b);
        }
        if (!this.f8142c.isEmpty()) {
            bundle.putParcelableArray("android.messages", ce.m10943a(this.f8142c));
        }
    }
}
