package com.ushareit.listenit;

import android.graphics.Rect;
import android.transition.Transition;
import android.transition.Transition.EpicenterCallback;

final class bj extends EpicenterCallback {
    final /* synthetic */ Rect f6529a;

    bj(Rect rect) {
        this.f6529a = rect;
    }

    public Rect onGetEpicenter(Transition transition) {
        return this.f6529a;
    }
}
