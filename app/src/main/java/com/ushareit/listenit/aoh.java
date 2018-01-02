package com.ushareit.listenit;

import com.umeng.analytics.C0154a;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class aoh {
    public String f5033a;
    public String f5034b;
    public String f5035c;
    public Date f5036d;
    public boolean f5037e;

    public aoh(String str, String str2, String str3, Date date) {
        this.f5033a = str;
        this.f5034b = str2;
        this.f5035c = str3;
        this.f5036d = date;
        boolean z = (str2 == null || str3 == null) ? false : true;
        this.f5037e = z;
    }

    public aoh(JSONObject jSONObject) {
        this(jSONObject.optString("url"), jSONObject.optString("key"), jSONObject.optString("value"), new Date(jSONObject.optLong("expiration") * 1000));
    }

    public static List<aoh> m6454a(String str) {
        if (str == null) {
            return null;
        }
        JSONArray jSONArray;
        try {
            jSONArray = new JSONArray(str);
        } catch (JSONException e) {
            jSONArray = null;
        }
        if (jSONArray == null) {
            return null;
        }
        List<aoh> arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject;
            try {
                jSONObject = jSONArray.getJSONObject(i);
            } catch (JSONException e2) {
                jSONObject = null;
            }
            if (jSONObject != null) {
                aoh com_ushareit_listenit_aoh = new aoh(jSONObject);
                if (com_ushareit_listenit_aoh != null) {
                    arrayList.add(com_ushareit_listenit_aoh);
                }
            }
        }
        return arrayList;
    }

    public String m6455a() {
        Date date = this.f5036d;
        if (date == null) {
            date = new Date();
            date.setTime(date.getTime() + C0154a.f2954j);
        }
        DateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd-MMM-yyyy HH:mm:ss zzz");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        return simpleDateFormat.format(date);
    }

    public boolean m6456b() {
        return (this.f5034b == null || this.f5035c == null || this.f5033a == null) ? false : true;
    }
}
