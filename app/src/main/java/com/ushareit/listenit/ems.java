package com.ushareit.listenit;

import com.mopub.common.VisibleForTesting;
import java.util.HashSet;
import java.util.Set;

enum ems {
    IMPRESSION_TRACKER("imptracker", true),
    CLICK_TRACKER("clktracker", true),
    TITLE("title", false),
    TEXT("text", false),
    MAIN_IMAGE("mainimage", false),
    ICON_IMAGE("iconimage", false),
    CLICK_DESTINATION("clk", false),
    FALLBACK("fallback", false),
    CALL_TO_ACTION("ctatext", false),
    STAR_RATING("starrating", false);
    
    @VisibleForTesting
    static final Set<String> f11275c = null;
    final String f11277a;
    final boolean f11278b;

    static {
        f11275c = new HashSet();
        ems[] values = values();
        int length = values.length;
        int i;
        while (i < length) {
            ems com_ushareit_listenit_ems = values[i];
            if (com_ushareit_listenit_ems.f11278b) {
                f11275c.add(com_ushareit_listenit_ems.f11277a);
            }
            i++;
        }
    }

    private ems(String str, boolean z) {
        this.f11277a = str;
        this.f11278b = z;
    }

    static ems m17186a(String str) {
        for (ems com_ushareit_listenit_ems : values()) {
            if (com_ushareit_listenit_ems.f11277a.equals(str)) {
                return com_ushareit_listenit_ems;
            }
        }
        return null;
    }
}
