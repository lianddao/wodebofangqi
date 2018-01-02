package com.ushareit.listenit;

import com.facebook.internal.bo;
import com.facebook.share.model.SharePhoto;
import java.util.ArrayList;
import java.util.UUID;
import org.json.JSONObject;

final class bco implements bca {
    final /* synthetic */ UUID f5904a;
    final /* synthetic */ ArrayList f5905b;

    bco(UUID uuid, ArrayList arrayList) {
        this.f5904a = uuid;
        this.f5905b = arrayList;
    }

    public JSONObject mo848a(SharePhoto sharePhoto) {
        bo a = bcj.m7743b(this.f5904a, sharePhoto);
        if (a == null) {
            return null;
        }
        this.f5905b.add(a);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("url", a.m1493a());
            if (!sharePhoto.m1979d()) {
                return jSONObject;
            }
            jSONObject.put("user_generated", true);
            return jSONObject;
        } catch (Throwable e) {
            throw new aif("Unable to attach images", e);
        }
    }
}
