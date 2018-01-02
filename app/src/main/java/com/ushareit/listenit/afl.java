package com.ushareit.listenit;

import android.util.Log;
import android.view.ViewTreeObserver.OnPreDrawListener;
import java.lang.ref.WeakReference;

class afl implements OnPreDrawListener {
    private final WeakReference<afk> f4266a;

    public afl(afk com_ushareit_listenit_afk) {
        this.f4266a = new WeakReference(com_ushareit_listenit_afk);
    }

    public boolean onPreDraw() {
        if (Log.isLoggable("ViewTarget", 2)) {
            Log.v("ViewTarget", "OnGlobalLayoutListener called listener=" + this);
        }
        afk com_ushareit_listenit_afk = (afk) this.f4266a.get();
        if (com_ushareit_listenit_afk != null) {
            com_ushareit_listenit_afk.m5457a();
        }
        return true;
    }
}
