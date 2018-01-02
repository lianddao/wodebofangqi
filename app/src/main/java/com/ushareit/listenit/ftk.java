package com.ushareit.listenit;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.View.OnClickListener;
import com.ushareit.listenit.main.MainActivity;

class ftk implements OnClickListener {
    final /* synthetic */ fsi f13477a;
    final /* synthetic */ ftj f13478b;

    ftk(ftj com_ushareit_listenit_ftj, fsi com_ushareit_listenit_fsi) {
        this.f13478b = com_ushareit_listenit_ftj;
        this.f13477a = com_ushareit_listenit_fsi;
    }

    public void onClick(View view) {
        Rect rect = new Rect();
        this.f13478b.f13474e.getGlobalVisibleRect(rect);
        m20913a(rect, view.getContext());
        Bitmap bitmap = null;
        Drawable drawable = this.f13478b.f13470a.getDrawable();
        if (drawable != null) {
            bitmap = fzi.m21394a(this.f13478b.f13470a);
        }
        ((MainActivity) this.f13478b.f13473d).m24828a(this.f13477a.f13362a, this.f13477a.f13363b, bitmap, drawable, rect);
        fij.m19335f();
    }

    private void m20913a(Rect rect, Context context) {
        if (rect.top == gyn.m23206b(context)) {
            rect.top = rect.bottom - this.f13478b.f13476g;
        }
        if (rect.bottom == gyr.m23309b() - gyr.m23307a(55.0f)) {
            rect.bottom = rect.top + this.f13478b.f13476g;
        }
    }
}
