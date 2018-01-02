package com.ushareit.listenit;

import org.json.JSONArray;

public enum anl {
    APP_AD(0),
    LINK_AD(1),
    APP_AD_V2(2),
    LINK_AD_V2(3),
    APP_ENGAGEMENT_AD(4),
    AD_CHOICES(5),
    JS_TRIGGER(6),
    JS_TRIGGER_NO_AUTO_IMP_LOGGING(7),
    VIDEO_AD(8),
    INLINE_VIDEO_AD(9),
    BANNER_TO_INTERSTITIAL(10),
    NATIVE_CLOSE_BUTTON(11),
    UNIFIED_LOGGING(16),
    HTTP_LINKS(17);
    
    public static final anl[] f4950o = null;
    private static final String f4951q = null;
    private final int f4953p;

    static {
        f4950o = new anl[]{LINK_AD_V2, APP_ENGAGEMENT_AD, AD_CHOICES, JS_TRIGGER_NO_AUTO_IMP_LOGGING, NATIVE_CLOSE_BUTTON, UNIFIED_LOGGING, HTTP_LINKS};
        JSONArray jSONArray = new JSONArray();
        anl[] com_ushareit_listenit_anlArr = f4950o;
        int length = com_ushareit_listenit_anlArr.length;
        int i;
        while (i < length) {
            jSONArray.put(com_ushareit_listenit_anlArr[i].m6390a());
            i++;
        }
        f4951q = jSONArray.toString();
    }

    private anl(int i) {
        this.f4953p = i;
    }

    public static String m6389b() {
        return f4951q;
    }

    public int m6390a() {
        return this.f4953p;
    }

    public String toString() {
        return String.valueOf(this.f4953p);
    }
}
