package com.ushareit.listenit;

import com.facebook.share.model.ShareOpenGraphAction;
import com.facebook.share.model.ShareOpenGraphObject;
import com.facebook.share.model.SharePhoto;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class bbz {
    public static JSONObject m7643a(ShareOpenGraphAction shareOpenGraphAction, bca com_ushareit_listenit_bca) {
        JSONObject jSONObject = new JSONObject();
        for (String str : shareOpenGraphAction.m1973c()) {
            jSONObject.put(str, m7641a(shareOpenGraphAction.m1970a(str), com_ushareit_listenit_bca));
        }
        return jSONObject;
    }

    private static JSONObject m7644a(ShareOpenGraphObject shareOpenGraphObject, bca com_ushareit_listenit_bca) {
        JSONObject jSONObject = new JSONObject();
        for (String str : shareOpenGraphObject.m1973c()) {
            jSONObject.put(str, m7641a(shareOpenGraphObject.m1970a(str), com_ushareit_listenit_bca));
        }
        return jSONObject;
    }

    private static JSONArray m7642a(List list, bca com_ushareit_listenit_bca) {
        JSONArray jSONArray = new JSONArray();
        for (Object a : list) {
            jSONArray.put(m7641a(a, com_ushareit_listenit_bca));
        }
        return jSONArray;
    }

    public static Object m7641a(Object obj, bca com_ushareit_listenit_bca) {
        if (obj == null) {
            return JSONObject.NULL;
        }
        if ((obj instanceof String) || (obj instanceof Boolean) || (obj instanceof Double) || (obj instanceof Float) || (obj instanceof Integer) || (obj instanceof Long)) {
            return obj;
        }
        if (obj instanceof SharePhoto) {
            if (com_ushareit_listenit_bca != null) {
                return com_ushareit_listenit_bca.mo848a((SharePhoto) obj);
            }
            return null;
        } else if (obj instanceof ShareOpenGraphObject) {
            return m7644a((ShareOpenGraphObject) obj, com_ushareit_listenit_bca);
        } else {
            if (obj instanceof List) {
                return m7642a((List) obj, com_ushareit_listenit_bca);
            }
            throw new IllegalArgumentException("Invalid object found for JSON serialization: " + obj.toString());
        }
    }
}
