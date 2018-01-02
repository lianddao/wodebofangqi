package com.ushareit.listenit;

import android.content.Context;
import com.facebook.AccessToken;

final class bar extends ahv {
    bar() {
    }

    protected void mo821a(AccessToken accessToken, AccessToken accessToken2) {
        Context f = ail.m5715f();
        if (accessToken2 == null) {
            bak.f5787i = (bak.f5787i + 1) % 1000;
            f.getSharedPreferences("com.facebook.LikeActionController.CONTROLLER_STORE_KEY", 0).edit().putInt("OBJECT_SUFFIX", bak.f5787i).apply();
            bak.f5781c.clear();
            bak.f5780b.m1409a();
        }
        bak.m7538d(null, "com.facebook.sdk.LikeActionController.DID_RESET");
    }
}
