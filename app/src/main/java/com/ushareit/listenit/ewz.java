package com.ushareit.listenit;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.res.Resources;
import android.os.Build;
import android.os.Build.VERSION;
import com.umeng.analytics.pro.C0321x;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import org.json.JSONException;
import org.json.JSONObject;

public class ewz {
    public String f12049a;
    public String f12050b;
    public String f12051c;
    public int f12052d;
    public String f12053e;
    public int f12054f;
    public String f12055g;
    public int f12056h;
    public int f12057i;
    public String f12058j;
    public String f12059k;
    public String f12060l;
    public String f12061m;
    public String f12062n;
    public String f12063o;
    public int f12064p;
    public String f12065q;
    public String f12066r;
    public String f12067s;
    public String f12068t;
    public long f12069u;
    public long f12070v;
    public String f12071w;
    public String f12072x;

    public ewz(JSONObject jSONObject) {
        if (jSONObject.has(C0321x.f3860u)) {
            this.f12049a = jSONObject.getString(C0321x.f3860u);
        } else {
            this.f12049a = "";
        }
        if (jSONObject.has("user_id")) {
            this.f12050b = jSONObject.getString("user_id");
        } else {
            this.f12050b = "";
        }
        if (jSONObject.has("app_id")) {
            this.f12051c = jSONObject.getString("app_id");
        } else {
            this.f12051c = "";
        }
        if (jSONObject.has("app_ver")) {
            this.f12052d = jSONObject.getInt("app_ver");
        } else {
            this.f12052d = 0;
        }
        if (jSONObject.has("app_ver_name")) {
            this.f12053e = jSONObject.getString("app_ver_name");
        } else {
            this.f12053e = "";
        }
        if (jSONObject.has("os_ver")) {
            this.f12054f = jSONObject.getInt("os_ver");
        } else {
            this.f12054f = 0;
        }
        if (jSONObject.has("os_type")) {
            this.f12055g = jSONObject.getString("os_type");
        } else {
            this.f12055g = "";
        }
        if (jSONObject.has("screen_width")) {
            this.f12056h = jSONObject.getInt("screen_width");
        } else {
            this.f12056h = 0;
        }
        if (jSONObject.has("screen_height")) {
            this.f12057i = jSONObject.getInt("screen_height");
        } else {
            this.f12057i = 0;
        }
        if (jSONObject.has("device_category")) {
            this.f12058j = jSONObject.getString("device_category");
        } else {
            this.f12058j = "";
        }
        if (jSONObject.has(C0321x.f3861v)) {
            this.f12059k = jSONObject.getString(C0321x.f3861v);
        } else {
            this.f12059k = "";
        }
        if (jSONObject.has("release_channel")) {
            this.f12060l = jSONObject.getString("release_channel");
        } else {
            this.f12060l = "";
        }
        if (jSONObject.has("lang")) {
            this.f12061m = jSONObject.getString("lang");
        } else {
            this.f12061m = "";
        }
        if (jSONObject.has(C0321x.f3820G)) {
            this.f12062n = jSONObject.getString(C0321x.f3820G);
        } else {
            this.f12062n = "";
        }
        if (jSONObject.has("manufacturer")) {
            this.f12063o = jSONObject.getString("manufacturer");
        } else {
            this.f12063o = "";
        }
        if (jSONObject.has("dpi")) {
            this.f12064p = jSONObject.getInt("dpi");
        } else {
            this.f12064p = 0;
        }
        if (jSONObject.has("net")) {
            this.f12065q = jSONObject.getString("net");
        } else {
            this.f12065q = "";
        }
        if (jSONObject.has("android_id")) {
            this.f12066r = jSONObject.getString("android_id");
        } else {
            this.f12066r = "";
        }
        if (jSONObject.has("mac")) {
            this.f12067s = jSONObject.getString("mac");
        } else {
            this.f12067s = "";
        }
        if (jSONObject.has("imei")) {
            this.f12068t = jSONObject.getString("imei");
        } else {
            this.f12068t = "";
        }
        if (jSONObject.has("last_manual_act_t")) {
            this.f12069u = jSONObject.getLong("last_manual_act_t");
        } else {
            this.f12069u = 0;
        }
        if (jSONObject.has("last_show_notify_t")) {
            this.f12070v = jSONObject.getLong("last_show_notify_t");
        } else {
            this.f12070v = 0;
        }
        if (jSONObject.has("mobile_net_type")) {
            this.f12071w = jSONObject.getString("mobile_net_type");
        } else {
            this.f12071w = "";
        }
        if (jSONObject.has("imsi")) {
            this.f12072x = jSONObject.getString("imsi");
        } else {
            this.f12072x = "";
        }
    }

    public JSONObject m18331a() {
        JSONObject jSONObject = new JSONObject();
        try {
            for (Entry entry : m18332b().entrySet()) {
                jSONObject.put((String) entry.getKey(), entry.getValue());
            }
        } catch (JSONException e) {
        }
        return jSONObject;
    }

    public Map<String, Object> m18332b() {
        Map<String, Object> hashMap = new HashMap();
        if (fbb.m18765d(this.f12049a)) {
            hashMap.put(C0321x.f3860u, this.f12049a);
        }
        if (fbb.m18765d(this.f12050b)) {
            hashMap.put("user_id", this.f12050b);
        }
        if (fbb.m18765d(this.f12051c)) {
            hashMap.put("app_id", this.f12051c);
        }
        if (this.f12052d != 0) {
            hashMap.put("app_ver", Integer.valueOf(this.f12052d));
        }
        if (fbb.m18765d(this.f12053e)) {
            hashMap.put("app_ver_name", this.f12053e);
        }
        if (this.f12054f != 0) {
            hashMap.put("os_ver", Integer.valueOf(this.f12054f));
        }
        if (fbb.m18765d(this.f12055g)) {
            hashMap.put("os_type", this.f12055g);
        }
        if (this.f12056h != 0) {
            hashMap.put("screen_width", Integer.valueOf(this.f12056h));
        }
        if (this.f12057i != 0) {
            hashMap.put("screen_height", Integer.valueOf(this.f12057i));
        }
        if (fbb.m18765d(this.f12058j)) {
            hashMap.put("device_category", this.f12058j);
        }
        if (fbb.m18765d(this.f12059k)) {
            hashMap.put(C0321x.f3861v, this.f12059k);
        }
        if (fbb.m18765d(this.f12060l)) {
            hashMap.put("release_channel", this.f12060l);
        }
        if (fbb.m18765d(this.f12061m)) {
            hashMap.put("lang", this.f12061m);
        }
        if (fbb.m18765d(this.f12062n)) {
            hashMap.put(C0321x.f3820G, this.f12062n);
        }
        if (fbb.m18765d(this.f12063o)) {
            hashMap.put("manufacturer", this.f12063o);
        }
        if (this.f12064p != 0) {
            hashMap.put("dpi", Integer.valueOf(this.f12064p));
        }
        if (fbb.m18765d(this.f12065q)) {
            hashMap.put("net", this.f12065q);
        }
        if (fbb.m18765d(this.f12066r)) {
            hashMap.put("android_id", this.f12066r);
        }
        if (fbb.m18765d(this.f12067s)) {
            hashMap.put("mac", this.f12067s);
        }
        if (fbb.m18765d(this.f12068t)) {
            hashMap.put("imei", this.f12068t);
        }
        if (this.f12069u != 0) {
            hashMap.put("last_manual_act_t", Long.valueOf(this.f12069u));
        }
        if (this.f12070v != 0) {
            hashMap.put("last_show_notify_t", Long.valueOf(this.f12070v));
        }
        if (fbb.m18765d(this.f12071w)) {
            hashMap.put("mobile_net_type", this.f12071w);
        }
        if (fbb.m18765d(this.f12072x)) {
            hashMap.put("imsi", this.f12072x);
        }
        return hashMap;
    }

    public String toString() {
        return m18331a().toString();
    }

    public static ewz m18329a(Context context) {
        ewz com_ushareit_listenit_ewz = new ewz();
        com_ushareit_listenit_ewz.f12049a = fah.m18702a(context);
        Resources resources = context.getResources();
        com_ushareit_listenit_ewz.f12051c = fac.m18685c(context);
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 16384);
            com_ushareit_listenit_ewz.f12052d = packageInfo.versionCode;
            com_ushareit_listenit_ewz.f12053e = packageInfo.versionName;
        } catch (Exception e) {
            com_ushareit_listenit_ewz.f12052d = 0;
            com_ushareit_listenit_ewz.f12053e = "";
        }
        com_ushareit_listenit_ewz.f12054f = VERSION.SDK_INT;
        com_ushareit_listenit_ewz.f12055g = "android";
        com_ushareit_listenit_ewz.f12056h = resources.getDisplayMetrics().widthPixels;
        com_ushareit_listenit_ewz.f12057i = resources.getDisplayMetrics().heightPixels;
        com_ushareit_listenit_ewz.f12058j = fbb.m18760b(context).toString();
        com_ushareit_listenit_ewz.f12059k = Build.MODEL;
        com_ushareit_listenit_ewz.f12060l = fac.m18682a();
        com_ushareit_listenit_ewz.f12061m = resources.getConfiguration().locale.getLanguage();
        com_ushareit_listenit_ewz.f12062n = resources.getConfiguration().locale.getCountry();
        com_ushareit_listenit_ewz.f12063o = Build.MANUFACTURER;
        com_ushareit_listenit_ewz.f12064p = resources.getDisplayMetrics().densityDpi;
        return com_ushareit_listenit_ewz;
    }

    public static ewz m18330b(Context context) {
        ewz a = m18329a(context);
        eve a2 = eve.m18153a();
        a.f12069u = a2.m18156b();
        a.f12070v = a2.m18158c();
        a.f12071w = eyx.m18571a(context).m18574a();
        a.f12072x = eyx.m18571a(context).m18578e();
        return a;
    }
}
