package com.ushareit.listenit;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class akq extends ako {
    private static final String f4599a = akq.class.getSimpleName();
    private final Context f4600b;
    private final String f4601c;
    private final Uri f4602d;
    private final Map<String, String> f4603e;

    public akq(Context context, String str, Uri uri, Map<String, String> map) {
        this.f4600b = context;
        this.f4601c = str;
        this.f4602d = uri;
        this.f4603e = map;
    }

    private Intent m5930a(auc com_ushareit_listenit_auc) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addFlags(268435456);
        if (!(TextUtils.isEmpty(com_ushareit_listenit_auc.m7180a()) || TextUtils.isEmpty(com_ushareit_listenit_auc.m7181b()))) {
            intent.setComponent(new ComponentName(com_ushareit_listenit_auc.m7180a(), com_ushareit_listenit_auc.m7181b()));
        }
        if (!TextUtils.isEmpty(com_ushareit_listenit_auc.m7182c())) {
            intent.setData(Uri.parse(com_ushareit_listenit_auc.m7182c()));
        }
        return intent;
    }

    private Intent m5931b(auc com_ushareit_listenit_auc) {
        if (TextUtils.isEmpty(com_ushareit_listenit_auc.m7180a())) {
            return null;
        }
        if (!atx.m7152a(this.f4600b, com_ushareit_listenit_auc.m7180a())) {
            return null;
        }
        CharSequence c = com_ushareit_listenit_auc.m7182c();
        if (!TextUtils.isEmpty(c) && (c.startsWith("tel:") || c.startsWith("telprompt:"))) {
            return new Intent("android.intent.action.CALL", Uri.parse(c));
        }
        PackageManager packageManager = this.f4600b.getPackageManager();
        if (TextUtils.isEmpty(com_ushareit_listenit_auc.m7181b()) && TextUtils.isEmpty(c)) {
            return packageManager.getLaunchIntentForPackage(com_ushareit_listenit_auc.m7180a());
        }
        Intent a = m5930a(com_ushareit_listenit_auc);
        List<ResolveInfo> queryIntentActivities = packageManager.queryIntentActivities(a, 65536);
        if (a.getComponent() == null) {
            for (ResolveInfo resolveInfo : queryIntentActivities) {
                if (resolveInfo.activityInfo.packageName.equals(com_ushareit_listenit_auc.m7180a())) {
                    a.setComponent(new ComponentName(resolveInfo.activityInfo.packageName, resolveInfo.activityInfo.name));
                    break;
                }
            }
        }
        return (queryIntentActivities.isEmpty() || a.getComponent() == null) ? null : a;
    }

    private List<auc> m5932f() {
        Object queryParameter = this.f4602d.getQueryParameter("appsite_data");
        if (TextUtils.isEmpty(queryParameter) || "[]".equals(queryParameter)) {
            return null;
        }
        List<auc> arrayList = new ArrayList();
        try {
            JSONArray optJSONArray = new JSONObject(queryParameter).optJSONArray("android");
            if (optJSONArray == null) {
                return arrayList;
            }
            for (int i = 0; i < optJSONArray.length(); i++) {
                auc a = auc.m7179a(optJSONArray.optJSONObject(i));
                if (a != null) {
                    arrayList.add(a);
                }
            }
            return arrayList;
        } catch (Throwable e) {
            Log.w(f4599a, "Error parsing appsite_data", e);
            return arrayList;
        }
    }

    public atr mo666a() {
        return atr.OPEN_STORE;
    }

    public void mo667b() {
        m5926a(this.f4600b, this.f4601c, this.f4603e);
        List<Intent> d = m5936d();
        if (d != null) {
            for (Intent startActivity : d) {
                try {
                    this.f4600b.startActivity(startActivity);
                    return;
                } catch (Throwable e) {
                    Log.d(f4599a, "Failed to open app intent, falling back", e);
                }
            }
        }
        m5937e();
    }

    protected Uri m5935c() {
        Object queryParameter = this.f4602d.getQueryParameter("store_url");
        if (!TextUtils.isEmpty(queryParameter)) {
            return Uri.parse(queryParameter);
        }
        String queryParameter2 = this.f4602d.getQueryParameter("store_id");
        return Uri.parse(String.format("market://details?id=%s", new Object[]{queryParameter2}));
    }

    protected List<Intent> m5936d() {
        List<auc> f = m5932f();
        List<Intent> arrayList = new ArrayList();
        if (f != null) {
            for (auc b : f) {
                Intent b2 = m5931b(b);
                if (b2 != null) {
                    arrayList.add(b2);
                }
            }
        }
        return arrayList;
    }

    public void m5937e() {
        try {
            atz.m7168a(this.f4600b, m5935c(), this.f4601c);
        } catch (Throwable e) {
            Log.d(f4599a, "Failed to open market url: " + this.f4602d.toString(), e);
            String queryParameter = this.f4602d.getQueryParameter("store_url_web_fallback");
            if (queryParameter != null && queryParameter.length() > 0) {
                try {
                    atz.m7168a(this.f4600b, Uri.parse(queryParameter), this.f4601c);
                } catch (Throwable e2) {
                    Log.d(f4599a, "Failed to open fallback url: " + queryParameter, e2);
                }
            }
        }
    }
}
