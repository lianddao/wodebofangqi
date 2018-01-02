package com.ushareit.listenit;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.view.View.OnClickListener;
import java.util.HashMap;
import java.util.Map;

public class hip {
    public Context f15496a;
    public String f15497b;
    public int f15498c;
    public int f15499d;
    public OnClickListener f15500e = this.f15508h;
    public boolean f15501f = false;
    protected hik f15502g = null;

    public void m23908a(hik com_ushareit_listenit_hik) {
        this.f15502g = com_ushareit_listenit_hik;
    }

    public hip(Context context, String str, int i, int i2) {
        this.f15496a = context;
        this.f15497b = str;
        this.f15498c = i;
        this.f15499d = i2;
    }

    protected static final void m23907a(Context context, String str, String str2) {
        Intent intent = new Intent("android.intent.action.SEND");
        intent.putExtra("android.intent.extra.TEXT", str2);
        intent.setType("text/plain");
        intent.setClassName(str, (String) m23906a(context).get(str));
        try {
            ((Activity) context).startActivityForResult(intent, 1);
        } catch (ActivityNotFoundException e) {
        }
    }

    protected static final Map<String, String> m23906a(Context context) {
        Map<String, String> hashMap = new HashMap();
        PackageManager packageManager = context.getPackageManager();
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("text/plain");
        for (ResolveInfo resolveInfo : packageManager.queryIntentActivities(intent, 0)) {
            String str = resolveInfo.activityInfo.packageName;
            String str2 = resolveInfo.activityInfo.name;
            if (!(str2 == null || hashMap.containsKey(str))) {
                hashMap.put(str, str2);
            }
        }
        return hashMap;
    }
}
