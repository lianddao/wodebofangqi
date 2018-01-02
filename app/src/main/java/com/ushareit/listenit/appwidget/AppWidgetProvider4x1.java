package com.ushareit.listenit.appwidget;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.widget.ImageView;
import android.widget.RemoteViews;
import com.ushareit.listenit.C0349R;
import com.ushareit.listenit.eys;
import com.ushareit.listenit.fbb;
import com.ushareit.listenit.fja;
import com.ushareit.listenit.fjd;
import com.ushareit.listenit.fzi;
import com.ushareit.listenit.glg;
import com.ushareit.listenit.gum;
import com.ushareit.listenit.gvj;
import com.ushareit.listenit.tv;

public class AppWidgetProvider4x1 extends fjd {
    private static RemoteViews f5144a;
    private static ImageView f5145b;

    protected String mo753a() {
        return "com.ushareit.listenit.action.widget4x1.update_all";
    }

    protected String mo754b() {
        return "com.ushareit.listenit.action.widget4x1.update_playmode";
    }

    protected String mo756c() {
        return "com.ushareit.listenit.action.widget4x1.update_favorite";
    }

    protected String mo758d() {
        return "com.ushareit.listenit.action.widget4x1.update_progress";
    }

    protected String mo760e() {
        return "com.ushareit.listenit.action.widget4x1.update_skin";
    }

    protected synchronized RemoteViews mo752a(Context context) {
        if (f5144a == null) {
            f5144a = new RemoteViews(context.getPackageName(), C0349R.layout.appwidget_layout_4x1);
        }
        return f5144a;
    }

    protected synchronized void mo755b(Context context) {
        f5144a = new RemoteViews(context.getPackageName(), C0349R.layout.appwidget_layout_4x1);
    }

    protected void mo757c(Context context) {
        gum h = fjd.m6642h(context);
        if (h == null || h.mo2465v() == null) {
            m6659a(context, null, null, 0, false, false);
            return;
        }
        int dimensionPixelSize = eys.m18562a().getResources().getDimensionPixelSize(C0349R.dimen.common_dimens_64dp);
        m6659a(context, null, h.mo2465v(), h.mo2463t(), h.mo2425a(), h.mo2453j());
        fzi.m21402a(context, h.mo2465v(), m6663j(context), tv.NORMAL, dimensionPixelSize, new fja(this, context, h));
    }

    private void m6659a(Context context, Bitmap bitmap, glg com_ushareit_listenit_glg, int i, boolean z, boolean z2) {
        m6661b(context, bitmap, com_ushareit_listenit_glg, i, z, z2);
        m6662i(context);
        m6646a(context, AppWidgetProvider4x1.class);
    }

    protected void mo759d(Context context) {
        gum h = fjd.m6642h(context);
        if (h != null && h.mo2465v() != null) {
            mo752a(context).setProgressBar(C0349R.id.appwidget_progressbar, h.mo2465v().f14337e, h.mo2463t(), false);
            m6646a(context, AppWidgetProvider4x1.class);
        }
    }

    protected void mo761e(Context context) {
        gum h = fjd.m6642h(context);
        if (h != null) {
            mo752a(context).setImageViewResource(C0349R.id.appwidget_play_order, m6643a(h.mo2453j()));
            m6646a(context, AppWidgetProvider4x1.class);
        }
    }

    protected void mo762f(Context context) {
    }

    protected void mo763g(Context context) {
        RemoteViews a = mo752a(context);
        switch (gvj.m23036u(context)) {
            case 0:
                a.setImageViewResource(C0349R.id.appwidget_skin, C0349R.drawable.desk_white_bg);
                gvj.m22964h(context, 1);
                break;
            case 1:
                a.setImageViewResource(C0349R.id.appwidget_skin, 17170445);
                gvj.m22964h(context, 2);
                break;
            case 2:
                a.setImageViewResource(C0349R.id.appwidget_skin, C0349R.drawable.desk_black2_bg);
                gvj.m22964h(context, 3);
                break;
            case 3:
                a.setImageViewResource(C0349R.id.appwidget_skin, C0349R.drawable.desk_black_bg);
                gvj.m22964h(context, 0);
                break;
        }
        m6646a(context, AppWidgetProvider4x1.class);
    }

    private void m6662i(Context context) {
        RemoteViews a = mo752a(context);
        a.setOnClickPendingIntent(C0349R.id.appwidget_album_art_btn, fjd.m6641b(context, "com.ushareit.listenit.action.WIDGET"));
        a.setOnClickPendingIntent(C0349R.id.appwidget_play_order, fjd.m6639a(context, 10));
        a.setOnClickPendingIntent(C0349R.id.appwidget_play_or_pause_btn, fjd.m6639a(context, 3));
        a.setOnClickPendingIntent(C0349R.id.appwidget_next, fjd.m6639a(context, 4));
        a.setOnClickPendingIntent(C0349R.id.appwidget_last, fjd.m6639a(context, 5));
        a.setOnClickPendingIntent(C0349R.id.appwidget_change_skin, fjd.m6640a(context, "com.ushareit.listenit.action.widget4x1.update_skin"));
    }

    private void m6661b(Context context, Bitmap bitmap, glg com_ushareit_listenit_glg, int i, boolean z, boolean z2) {
        RemoteViews a = mo752a(context);
        if (bitmap != null) {
            a.setImageViewBitmap(C0349R.id.appwidget_album_art_btn, bitmap);
        }
        a.setTextViewText(C0349R.id.appwidget_music_info, m6658a(com_ushareit_listenit_glg));
        if (com_ushareit_listenit_glg != null && com_ushareit_listenit_glg.f14337e > i && i >= 0) {
            a.setProgressBar(C0349R.id.appwidget_progressbar, com_ushareit_listenit_glg.f14337e, i, false);
        }
        if (m6656f()) {
            a.setImageViewResource(C0349R.id.appwidget_last, C0349R.drawable.appwidget_play_next_btn_bg);
            a.setImageViewResource(C0349R.id.appwidget_next, C0349R.drawable.appwidget_play_last_btn_bg);
        }
        a.setImageViewResource(C0349R.id.appwidget_play_or_pause_btn, z ? C0349R.drawable.appwidget_pause_btn_bg : C0349R.drawable.appwidget_play_btn_bg);
        a.setImageViewResource(C0349R.id.appwidget_play_order, m6643a(z2));
    }

    private String m6658a(glg com_ushareit_listenit_glg) {
        if (com_ushareit_listenit_glg == null) {
            return eys.m18562a().getResources().getString(C0349R.string.app_name);
        }
        String str = com_ushareit_listenit_glg.f14338f;
        String str2 = com_ushareit_listenit_glg.f14339g;
        int length = str.length() + 2;
        int length2 = str2.length() + length;
        SpannableString spannableString = new SpannableString(str + "  " + str2);
        spannableString.setSpan(new ForegroundColorSpan(eys.m18562a().getResources().getColor(C0349R.color.common_text_color_gray)), length, length2, 33);
        spannableString.setSpan(new RelativeSizeSpan(0.77f), length, length2, 34);
        return !fbb.m18763c(spannableString.toString()) ? spannableString.toString() : eys.m18562a().getResources().getString(C0349R.string.app_name);
    }

    private ImageView m6663j(Context context) {
        if (f5145b == null) {
            f5145b = new ImageView(context);
        }
        return f5145b;
    }
}
