package com.ushareit.listenit;

import android.content.Context;

public class fiu {
    private static String f12783a = "UIAnalyticsRecommend";

    public static void m19439a(Context context) {
        exw.m18443a(f12783a, "collectShowRecommend");
        esr.m17807a(context, "UF_ShowRecommend");
    }

    public static void m19440a(Context context, boolean z) {
        exw.m18443a(f12783a, "collectRecommendResult");
        esr.m17808a(context, "UF_RecommendResult", z ? "success" : "failure");
    }

    public static void m19441b(Context context) {
        exw.m18443a(f12783a, "collectEnterRecommendList");
        esr.m17807a(context, "UF_EnterRecommendList");
    }
}
