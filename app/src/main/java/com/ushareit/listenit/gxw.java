package com.ushareit.listenit;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

public class gxw {
    public static void m23113a(Context context, String str, String str2) {
        try {
            Intent intent = new Intent("android.intent.action.SENDTO", Uri.parse("mailto:" + str));
            intent.putExtra("android.intent.extra.SUBJECT", str2);
            StringBuilder stringBuilder = new StringBuilder("\n\n\n\n--------------------------------------------\n" + context.getString(C0349R.string.settings_feedback_attached_information) + "\n--------------------------------------------\n");
            stringBuilder.append(m23112a(context));
            intent.putExtra("android.intent.extra.TEXT", stringBuilder.toString());
            intent.addFlags(268435456);
            context.startActivity(intent);
        } catch (Exception e) {
            fad.m18687a(context, "486281904897348", "bestLISTENit");
        }
    }

    private static String m23112a(Context context) {
        ewz a = ewz.m18329a(context);
        return fbp.m18800a("%s\n%s\n%s\n%s\n%s\n%s\n%s\n", "App: LISTENit", "App Version: " + a.f12052d, "Model: " + a.f12059k, "Region: " + a.f12062n, "Language: " + a.f12061m, "OS Type: " + a.f12055g, "OS Version: " + a.f12054f);
    }
}
