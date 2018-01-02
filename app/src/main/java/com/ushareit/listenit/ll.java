package com.ushareit.listenit;

import android.view.View;
import java.util.WeakHashMap;

class ll implements lt {
    WeakHashMap<View, Runnable> f15629a = null;

    ll() {
    }

    public void mo2875a(lj ljVar, View view, long j) {
    }

    public void mo2874a(lj ljVar, View view, float f) {
        m24464d(ljVar, view);
    }

    public void mo2878b(lj ljVar, View view, float f) {
        m24464d(ljVar, view);
    }

    public void mo2879c(lj ljVar, View view, float f) {
        m24464d(ljVar, view);
    }

    public void mo2873a(lj ljVar, View view) {
        m24464d(ljVar, view);
    }

    public void mo2877b(lj ljVar, View view) {
        m24461a(view);
        m24463c(ljVar, view);
    }

    public void mo2876a(lj ljVar, View view, ly lyVar) {
        view.setTag(2113929216, lyVar);
    }

    private void m24463c(lj ljVar, View view) {
        ly lyVar;
        Object tag = view.getTag(2113929216);
        if (tag instanceof ly) {
            lyVar = (ly) tag;
        } else {
            lyVar = null;
        }
        Runnable a = ljVar.f15626c;
        Runnable b = ljVar.f15627d;
        ljVar.f15626c = null;
        ljVar.f15627d = null;
        if (a != null) {
            a.run();
        }
        if (lyVar != null) {
            lyVar.mo2880a(view);
            lyVar.mo2881b(view);
        }
        if (b != null) {
            b.run();
        }
        if (this.f15629a != null) {
            this.f15629a.remove(view);
        }
    }

    private void m24461a(View view) {
        if (this.f15629a != null) {
            Runnable runnable = (Runnable) this.f15629a.get(view);
            if (runnable != null) {
                view.removeCallbacks(runnable);
            }
        }
    }

    private void m24464d(lj ljVar, View view) {
        Runnable runnable;
        if (this.f15629a != null) {
            runnable = (Runnable) this.f15629a.get(view);
        } else {
            runnable = null;
        }
        if (runnable == null) {
            runnable = new lm(this, ljVar, view);
            if (this.f15629a == null) {
                this.f15629a = new WeakHashMap();
            }
            this.f15629a.put(view, runnable);
        }
        view.removeCallbacks(runnable);
        view.post(runnable);
    }
}
