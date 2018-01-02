package com.ushareit.listenit;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.ushareit.listenit.popupview.SharePopupView;
import java.io.File;

public class hij {
    public static void m23900a(glg com_ushareit_listenit_glg, Context context) {
        if (com_ushareit_listenit_glg != null) {
            Intent intent = new Intent("android.intent.action.SEND");
            String str = String.format(context.getResources().getString(C0349R.string.socialshare_discription), new Object[]{com_ushareit_listenit_glg.mo2562c(), com_ushareit_listenit_glg.f14339g}) + "https://play.google.com/store/apps/details?id=com.ushareit.listenit";
            intent.putExtra("SHARE_INFO", str);
            if (gyn.m23260p(com_ushareit_listenit_glg.f14342j)) {
                intent.setType("text/plain");
                intent.putExtra("android.intent.extra.TEXT", str);
            } else {
                intent.setType("audio/*");
                File file = new File(com_ushareit_listenit_glg.f14342j);
                if (file != null && file.exists()) {
                    intent.putExtra("android.intent.extra.STREAM", Uri.fromFile(file));
                }
            }
            gyn.m23197a((ak) context, new fyi(new SharePopupView(context, intent, 65536, -10001)));
        }
    }

    public static void m23901a(String str, String str2, Context context) {
        Intent intent = new Intent("android.intent.action.SEND");
        String str3 = String.format(context.getResources().getString(C0349R.string.video_share_text), new Object[]{str, str2}) + "https://play.google.com/store/apps/details?id=com.ushareit.listenit";
        intent.putExtra("SHARE_INFO", str3);
        intent.setType("text/plain");
        intent.putExtra("android.intent.extra.TEXT", str3);
        gyn.m23197a((ak) context, new fyi(new SharePopupView(context, intent, 65536, -10001)));
    }
}
