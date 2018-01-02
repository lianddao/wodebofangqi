package com.ushareit.listenit;

import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.Context;

class fje extends gwy {
    final /* synthetic */ Context f12803a;
    final /* synthetic */ Class f12804b;
    final /* synthetic */ fjd f12805c;

    fje(fjd com_ushareit_listenit_fjd, Context context, Class cls) {
        this.f12805c = com_ushareit_listenit_fjd;
        this.f12803a = context;
        this.f12804b = cls;
    }

    public void e_() {
        AppWidgetManager.getInstance(this.f12803a).updateAppWidget(new ComponentName(this.f12803a, this.f12804b), this.f12805c.mo752a(this.f12803a));
    }
}
