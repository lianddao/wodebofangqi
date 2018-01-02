package com.ushareit.listenit;

import android.view.View;

public class se {
    public int f16437a;
    public int f16438b;
    public int f16439c;
    public int f16440d;

    public se m26036a(sv svVar) {
        return m26037a(svVar, 0);
    }

    public se m26037a(sv svVar, int i) {
        View view = svVar.itemView;
        this.f16437a = view.getLeft();
        this.f16438b = view.getTop();
        this.f16439c = view.getRight();
        this.f16440d = view.getBottom();
        return this;
    }
}
