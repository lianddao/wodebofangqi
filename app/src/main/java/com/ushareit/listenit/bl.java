package com.ushareit.listenit;

import android.graphics.Rect;
import android.transition.Transition;
import android.transition.Transition.EpicenterCallback;

final class bl extends EpicenterCallback {
    final /* synthetic */ bn f6826a;
    private Rect f6827b;

    bl(bn bnVar) {
        this.f6826a = bnVar;
    }

    public Rect onGetEpicenter(Transition transition) {
        if (this.f6827b == null && this.f6826a.f7127a != null) {
            this.f6827b = bi.m8548c(this.f6826a.f7127a);
        }
        return this.f6827b;
    }
}
