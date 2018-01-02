package com.ushareit.listenit;

import android.support.v7.widget.RecyclerView.LayoutParams;
import android.view.View;

final class rp extends ro {
    rp(sh shVar) {
        super(shVar);
    }

    public int mo3034d() {
        return this.a.m324t() - this.a.m328x();
    }

    public int mo3036e() {
        return this.a.m324t();
    }

    public void mo3030a(int i) {
        this.a.mo60h(i);
    }

    public int mo3032c() {
        return this.a.m326v();
    }

    public int mo3033c(View view) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        return layoutParams.rightMargin + (this.a.m295e(view) + layoutParams.leftMargin);
    }

    public int mo3035d(View view) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        return layoutParams.bottomMargin + (this.a.m301f(view) + layoutParams.topMargin);
    }

    public int mo3031b(View view) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        return layoutParams.rightMargin + this.a.m309i(view);
    }

    public int mo3029a(View view) {
        return this.a.m304g(view) - ((LayoutParams) view.getLayoutParams()).leftMargin;
    }

    public int mo3037f() {
        return (this.a.m324t() - this.a.m326v()) - this.a.m328x();
    }

    public int mo3038g() {
        return this.a.m328x();
    }
}
