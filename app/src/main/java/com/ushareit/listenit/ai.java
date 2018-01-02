package com.ushareit.listenit;

import android.view.View;

class ai extends ao {
    final /* synthetic */ ah f4400a;

    ai(ah ahVar) {
        this.f4400a = ahVar;
    }

    public View mo635a(int i) {
        if (this.f4400a.f1001S != null) {
            return this.f4400a.f1001S.findViewById(i);
        }
        throw new IllegalStateException("Fragment does not have a view");
    }

    public boolean mo636a() {
        return this.f4400a.f1001S != null;
    }
}
