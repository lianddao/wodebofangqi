package com.ushareit.listenit;

import android.net.Uri;
import com.facebook.share.model.SharePhoto;
import org.json.JSONObject;

final class bcp implements bca {
    bcp() {
    }

    public JSONObject mo848a(SharePhoto sharePhoto) {
        Uri c = sharePhoto.m1978c();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("url", c.toString());
            return jSONObject;
        } catch (Throwable e) {
            throw new aif("Unable to attach images", e);
        }
    }
}
