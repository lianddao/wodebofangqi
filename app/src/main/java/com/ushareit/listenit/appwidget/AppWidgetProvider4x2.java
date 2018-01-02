package com.ushareit.listenit.appwidget;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;
import android.widget.RemoteViews;
import com.ushareit.listenit.C0349R;
import com.ushareit.listenit.eys;
import com.ushareit.listenit.fjb;
import com.ushareit.listenit.fjd;
import com.ushareit.listenit.fre;
import com.ushareit.listenit.fzi;
import com.ushareit.listenit.glg;
import com.ushareit.listenit.gum;
import com.ushareit.listenit.gvj;
import com.ushareit.listenit.gyn;
import com.ushareit.listenit.tv;

public class AppWidgetProvider4x2 extends fjd {
    private static RemoteViews f5146a;
    private static ImageView f5147b;

    protected String mo753a() {
        return "com.ushareit.listenit.action.widget4x2.update_all";
    }

    protected String mo754b() {
        return "com.ushareit.listenit.action.widget4x2.update_playmode";
    }

    protected String mo756c() {
        return "com.ushareit.listenit.action.widget4x2.update_favorite";
    }

    protected String mo758d() {
        return "com.ushareit.listenit.action.widget4x2.update_progress";
    }

    protected String mo760e() {
        return "com.ushareit.listenit.action.widget4x2.update_skin";
    }

    protected synchronized RemoteViews mo752a(Context context) {
        if (f5146a == null) {
            f5146a = new RemoteViews(context.getPackageName(), C0349R.layout.appwidget_layout_4x2);
        }
        return f5146a;
    }

    protected synchronized void mo755b(Context context) {
        f5146a = new RemoteViews(context.getPackageName(), C0349R.layout.appwidget_layout_4x2);
    }

    protected void mo757c(Context context) {
        gum h = fjd.m6642h(context);
        if (h == null || h.mo2465v() == null) {
            m6676a(context, null, null, 0, false, false);
            return;
        }
        int dimensionPixelSize = eys.m18562a().getResources().getDimensionPixelSize(C0349R.dimen.common_dimens_80dp);
        m6676a(context, null, h.mo2465v(), h.mo2463t(), h.mo2425a(), h.mo2453j());
        fzi.m21402a(context, h.mo2465v(), m6680j(context), tv.NORMAL, dimensionPixelSize, new fjb(this, context, h));
    }

    private void m6676a(Context context, Bitmap bitmap, glg com_ushareit_listenit_glg, int i, boolean z, boolean z2) {
        m6678b(context, bitmap, com_ushareit_listenit_glg, i, z, z2);
        m6679i(context);
        m6646a(context, AppWidgetProvider4x2.class);
    }

    protected void mo759d(Context context) {
        gum h = fjd.m6642h(context);
        if (h != null && h.mo2465v() != null) {
            int i = h.mo2465v().f14337e;
            int t = h.mo2463t();
            mo752a(context).setTextViewText(C0349R.id.appwidget_music_time, gyn.m23182a((long) t) + "/" + gyn.m23182a((long) i));
            mo752a(context).setProgressBar(C0349R.id.appwidget_progressbar, i, t, false);
            m6646a(context, AppWidgetProvider4x2.class);
        }
    }

    protected void mo761e(Context context) {
        gum h = fjd.m6642h(context);
        if (h != null) {
            mo752a(context).setImageViewResource(C0349R.id.appwidget_play_order, m6643a(h.mo2453j()));
            m6646a(context, AppWidgetProvider4x2.class);
        }
    }

    protected void mo762f(Context context) {
        gum h = fjd.m6642h(context);
        if (h != null && h.mo2465v() != null) {
            mo752a(context).setImageViewResource(C0349R.id.appwidget_favorite, fre.m20627a(h.mo2465v()) ? C0349R.drawable.desk_btn_loved_pressed : C0349R.drawable.desk_btn_loved_normal);
            m6646a(context, AppWidgetProvider4x2.class);
        }
    }

    protected void mo763g(Context context) {
        RemoteViews a = mo752a(context);
        switch (gvj.m23038v(context)) {
            case 0:
                a.setImageViewResource(C0349R.id.appwidget_skin, C0349R.drawable.desk_white_bg);
                gvj.m22972i(context, 1);
                break;
            case 1:
                a.setImageViewResource(C0349R.id.appwidget_skin, 17170445);
                gvj.m22972i(context, 2);
                break;
            case 2:
                a.setImageViewResource(C0349R.id.appwidget_skin, C0349R.drawable.desk_black2_bg);
                gvj.m22972i(context, 3);
                break;
            case 3:
                a.setImageViewResource(C0349R.id.appwidget_skin, C0349R.drawable.desk_black_bg);
                gvj.m22972i(context, 0);
                break;
        }
        m6646a(context, AppWidgetProvider4x2.class);
    }

    private void m6679i(Context context) {
        RemoteViews a = mo752a(context);
        a.setOnClickPendingIntent(C0349R.id.appwidget_album_art_btn, fjd.m6641b(context, "com.ushareit.listenit.action.WIDGET"));
        a.setOnClickPendingIntent(C0349R.id.appwidget_play_order, fjd.m6639a(context, 10));
        a.setOnClickPendingIntent(C0349R.id.appwidget_play_or_pause_btn, fjd.m6639a(context, 3));
        a.setOnClickPendingIntent(C0349R.id.appwidget_next, fjd.m6639a(context, 4));
        a.setOnClickPendingIntent(C0349R.id.appwidget_last, fjd.m6639a(context, 5));
        a.setOnClickPendingIntent(C0349R.id.appwidget_favorite, fjd.m6639a(context, 8));
        a.setOnClickPendingIntent(C0349R.id.appwidget_change_skin, fjd.m6640a(context, "com.ushareit.listenit.action.widget4x2.update_skin"));
    }

    private void m6678b(Context context, Bitmap bitmap, glg com_ushareit_listenit_glg, int i, boolean z, boolean z2) {
        int i2 = C0349R.drawable.desk_btn_loved_normal;
        RemoteViews a = mo752a(context);
        if (bitmap != null) {
            a.setImageViewBitmap(C0349R.id.appwidget_album_art_btn, bitmap);
        }
        if (com_ushareit_listenit_glg != null) {
            a.setTextViewText(C0349R.id.appwidget_music_name, com_ushareit_listenit_glg.f14338f);
            a.setTextViewText(C0349R.id.appwidget_music_artist, com_ushareit_listenit_glg.f14339g);
        } else {
            a.setTextViewText(C0349R.id.appwidget_music_name, eys.m18562a().getResources().getString(C0349R.string.app_name));
        }
        if (com_ushareit_listenit_glg == null || com_ushareit_listenit_glg.f14337e <= i || i < 0) {
            mo752a(context).setImageViewResource(C0349R.id.appwidget_favorite, C0349R.drawable.desk_btn_loved_normal);
            a.setTextViewText(C0349R.id.appwidget_music_time, "00:00/00:00");
        } else {
            int i3 = com_ushareit_listenit_glg.f14337e;
            a.setProgressBar(C0349R.id.appwidget_progressbar, i3, i, false);
            a.setTextViewText(C0349R.id.appwidget_music_time, gyn.m23182a((long) i) + "/" + gyn.m23182a((long) i3));
            boolean a2 = fre.m20627a(com_ushareit_listenit_glg);
            RemoteViews a3 = mo752a(context);
            if (a2) {
                i2 = C0349R.drawable.desk_btn_loved_pressed;
            }
            a3.setImageViewResource(C0349R.id.appwidget_favorite, i2);
        }
        if (m6656f()) {
            a.setImageViewResource(C0349R.id.appwidget_last, C0349R.drawable.appwidget_play_next_btn_bg);
            a.setImageViewResource(C0349R.id.appwidget_next, C0349R.drawable.appwidget_play_last_btn_bg);
        }
        a.setImageViewResource(C0349R.id.appwidget_play_or_pause_btn, z ? C0349R.drawable.appwidget_pause_btn_bg : C0349R.drawable.appwidget_play_btn_bg);
        a.setImageViewResource(C0349R.id.appwidget_play_order, m6643a(z2));
    }

    private ImageView m6680j(Context context) {
        if (f5147b == null) {
            f5147b = new ImageView(context);
        }
        return f5147b;
    }
}
