package com.ushareit.listenit;

import android.annotation.SuppressLint;
import java.util.HashMap;
import java.util.Map;

public enum ewr {
    SINGLE_MSG("single_msg"),
    NORMAL_MSG("normal_msg"),
    NORMAL_BTN_MSG("normal_btn_msg"),
    IMAGE_MSG("img_msg"),
    MULTI_IMAGE_MSG("multi_img_msg"),
    SINGLE_CONTENT("single_content"),
    MULTI_CONTENT("multi_content"),
    FLASH_MSG("flash_msg"),
    CUSTOM_MSG("custom_msg"),
    UNKNOWN("unknown");
    
    private static final Map<String, ewr> f12044l = null;
    private String f12046k;

    static {
        f12044l = new HashMap();
        ewr[] values = values();
        int length = values.length;
        int i;
        while (i < length) {
            ewr com_ushareit_listenit_ewr = values[i];
            f12044l.put(com_ushareit_listenit_ewr.f12046k, com_ushareit_listenit_ewr);
            i++;
        }
    }

    private ewr(String str) {
        this.f12046k = str;
    }

    @SuppressLint({"DefaultLocale"})
    public static ewr m18310a(String str) {
        ewr com_ushareit_listenit_ewr = (ewr) f12044l.get(str.toLowerCase());
        if (com_ushareit_listenit_ewr == null) {
            return UNKNOWN;
        }
        return com_ushareit_listenit_ewr;
    }

    public String toString() {
        return this.f12046k;
    }
}
