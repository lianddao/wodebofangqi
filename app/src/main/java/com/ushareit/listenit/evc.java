package com.ushareit.listenit;

import android.content.Context;
import java.io.UnsupportedEncodingException;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class evc extends ewy {
    public static ezt m18135a(Context context, List<String> list, List<String> list2, ewz com_ushareit_listenit_ewz) {
        JSONArray jSONArray = new JSONArray(list);
        JSONArray jSONArray2 = new JSONArray(list2);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("support_cmd_types", jSONArray.toString());
        jSONObject.put("exist_cmd_ids", jSONArray2.toString());
        jSONObject.put("params", com_ushareit_listenit_ewz.toString());
        try {
            return ewy.m18133a(fan.m18728b() + "/1.0/cmds", jSONObject.toString().getBytes("UTF-8"), 1);
        } catch (UnsupportedEncodingException e) {
            throw new JSONException(e.getMessage());
        }
    }

    public static ezt m18134a(Context context, List<evp> list) {
        JSONArray jSONArray = new JSONArray();
        for (evp com_ushareit_listenit_evp : list) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("id", com_ushareit_listenit_evp.f11981a);
            jSONObject.put("status", com_ushareit_listenit_evp.f11982b);
            if (eve.m18154a(context)) {
                if (fbb.m18765d(com_ushareit_listenit_evp.f11983c)) {
                    jSONObject.put("detail", com_ushareit_listenit_evp.f11983c);
                }
                jSONObject.put("duration", com_ushareit_listenit_evp.f11984d);
            } else if ("showed".equalsIgnoreCase(com_ushareit_listenit_evp.f11982b) && fbb.m18765d(com_ushareit_listenit_evp.f11983c)) {
                jSONObject.put("detail", com_ushareit_listenit_evp.f11983c);
            }
            jSONArray.put(jSONObject);
        }
        try {
            return ewy.m18133a(fan.m18728b() + "/1.0/cmdreport", jSONArray.toString().getBytes("UTF-8"), 1);
        } catch (UnsupportedEncodingException e) {
            throw new JSONException(e.getMessage());
        }
    }
}
