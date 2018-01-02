package com.ushareit.listenit;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;

public class aep<T extends Drawable> implements aeq<T> {
    private final aeq<T> f4244a;
    private final int f4245b;

    public aep(aeq<T> com_ushareit_listenit_aeq_T, int i) {
        this.f4244a = com_ushareit_listenit_aeq_T;
        this.f4245b = i;
    }

    public boolean m5416a(T t, aer com_ushareit_listenit_aer) {
        if (com_ushareit_listenit_aer.mo615b() != null) {
            Drawable transitionDrawable = new TransitionDrawable(new Drawable[]{com_ushareit_listenit_aer.mo615b(), t});
            transitionDrawable.setCrossFadeEnabled(true);
            transitionDrawable.startTransition(this.f4245b);
            com_ushareit_listenit_aer.mo613a(transitionDrawable);
            return true;
        }
        this.f4244a.mo612a(t, com_ushareit_listenit_aer);
        return false;
    }
}
