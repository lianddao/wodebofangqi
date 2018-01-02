package com.ushareit.listenit;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.View.OnClickListener;
import com.ushareit.listenit.main.MainActivity;

class fth implements OnClickListener {
    final /* synthetic */ fsi f13467a;
    final /* synthetic */ ftg f13468b;

    fth(ftg com_ushareit_listenit_ftg, fsi com_ushareit_listenit_fsi) {
        this.f13468b = com_ushareit_listenit_ftg;
        this.f13467a = com_ushareit_listenit_fsi;
    }

    public void onClick(View view) {
        Rect rect = new Rect();
        this.f13468b.f13461a.getGlobalVisibleRect(rect);
        m20902a(rect, view.getContext());
        ((MainActivity) this.f13468b.f13466f.f13443k).m24828a(this.f13467a.f13362a, this.f13467a.f13363b, fzi.m21394a(this.f13468b.f13461a), this.f13468b.f13461a.getDrawable(), rect);
        fij.m19335f();
    }

    private void m20902a(Rect rect, Context context) {
        if (rect.top == gyn.m23206b(context)) {
            rect.top = rect.bottom - this.f13468b.f13466f.f13454w;
        }
        if (rect.bottom == gyr.m23309b() - context.getResources().getDimensionPixelSize(C0349R.dimen.common_dimens_55dp)) {
            rect.bottom = rect.top + this.f13468b.f13466f.f13454w;
        }
    }
}
