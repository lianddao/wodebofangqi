package com.ushareit.listenit;

import android.support.v7.widget.RecyclerView.LayoutParams;
import android.view.View;

final class rq extends ro {
    rq(sh shVar) {
        super(shVar);
    }

    public int mo3034d() {
        return this.a.m325u() - this.a.m329y();
    }

    public int mo3036e() {
        return this.a.m325u();
    }

    public void mo3030a(int i) {
        this.a.mo61i(i);
    }

    public int mo3032c() {
        return this.a.m327w();
    }

    public int mo3033c(View view) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        return layoutParams.bottomMargin + (this.a.m301f(view) + layoutParams.topMargin);
    }

    public int mo3035d(View view) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        return layoutParams.rightMargin + (this.a.m295e(view) + layoutParams.leftMargin);
    }

    public int mo3031b(View view) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        return layoutParams.bottomMargin + this.a.m311j(view);
    }

    public int mo3029a(View view) {
        return this.a.m307h(view) - ((LayoutParams) view.getLayoutParams()).topMargin;
    }

    public int mo3037f() {
        return (this.a.m325u() - this.a.m327w()) - this.a.m329y();
    }

    public int mo3038g() {
        return this.a.m329y();
    }
}
