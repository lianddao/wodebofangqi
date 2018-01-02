package com.ushareit.listenit;

import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.mopub.volley.DefaultRetryPolicy;
import java.util.WeakHashMap;

class jc implements jo {
    WeakHashMap<View, lj> f15601a = null;

    jc() {
    }

    public boolean mo2825a(View view, int i) {
        return (view instanceof iu) && m24224a((iu) view, i);
    }

    public boolean mo2829b(View view, int i) {
        return (view instanceof iu) && m24225b((iu) view, i);
    }

    public int mo2813a(View view) {
        return 2;
    }

    public void mo2819a(View view, gk gkVar) {
    }

    public boolean mo2828b(View view) {
        return false;
    }

    public boolean mo2832c(View view) {
        return false;
    }

    public void mo2833d(View view) {
        view.invalidate();
    }

    public void mo2816a(View view, int i, int i2, int i3, int i4) {
        view.invalidate(i, i2, i3, i4);
    }

    public void mo2821a(View view, Runnable runnable) {
        view.postDelayed(runnable, mo2858a());
    }

    public void mo2822a(View view, Runnable runnable, long j) {
        view.postDelayed(runnable, mo2858a() + j);
    }

    long mo2858a() {
        return 10;
    }

    public int mo2836e(View view) {
        return 0;
    }

    public void mo2831c(View view, int i) {
    }

    public float mo2839f(View view) {
        return DefaultRetryPolicy.DEFAULT_BACKOFF_MULT;
    }

    public void mo2817a(View view, int i, Paint paint) {
    }

    public int mo2841g(View view) {
        return 0;
    }

    public void mo2818a(View view, Paint paint) {
    }

    public int mo2842h(View view) {
        return 0;
    }

    public ViewParent mo2843i(View view) {
        return view.getParent();
    }

    public boolean mo2844j(View view) {
        Drawable background = view.getBackground();
        if (background == null || background.getOpacity() != -1) {
            return false;
        }
        return true;
    }

    public int mo2812a(int i, int i2, int i3) {
        return View.resolveSize(i, i2);
    }

    public int mo2845k(View view) {
        return 0;
    }

    public boolean mo2846l(View view) {
        return true;
    }

    public float mo2847m(View view) {
        return 0.0f;
    }

    public float mo2848n(View view) {
        return 0.0f;
    }

    public float mo2849o(View view) {
        return 0.0f;
    }

    public int mo2850p(View view) {
        return jp.m24326a(view);
    }

    public int mo2851q(View view) {
        return jp.m24328b(view);
    }

    public lj mo2852r(View view) {
        return new lj(view);
    }

    public void mo2815a(View view, float f) {
    }

    public void mo2827b(View view, float f) {
    }

    public void mo2830c(View view, float f) {
    }

    public void mo2834d(View view, float f) {
    }

    public void mo2837e(View view, float f) {
    }

    public void mo2840f(View view, float f) {
    }

    public float mo2853s(View view) {
        return 0.0f;
    }

    public void mo2824a(ViewGroup viewGroup, boolean z) {
    }

    public boolean mo2854t(View view) {
        return false;
    }

    public void mo2820a(View view, ij ijVar) {
    }

    public lz mo2814a(View view, lz lzVar) {
        return lzVar;
    }

    public lz mo2826b(View view, lz lzVar) {
        return lzVar;
    }

    public void mo2823a(View view, boolean z) {
    }

    public boolean mo2855u(View view) {
        if (view instanceof C0001if) {
            return ((C0001if) view).isNestedScrollingEnabled();
        }
        return false;
    }

    private boolean m24224a(iu iuVar, int i) {
        int computeHorizontalScrollOffset = iuVar.computeHorizontalScrollOffset();
        int computeHorizontalScrollRange = iuVar.computeHorizontalScrollRange() - iuVar.computeHorizontalScrollExtent();
        if (computeHorizontalScrollRange == 0) {
            return false;
        }
        if (i < 0) {
            if (computeHorizontalScrollOffset <= 0) {
                return false;
            }
            return true;
        } else if (computeHorizontalScrollOffset >= computeHorizontalScrollRange - 1) {
            return false;
        } else {
            return true;
        }
    }

    private boolean m24225b(iu iuVar, int i) {
        int computeVerticalScrollOffset = iuVar.computeVerticalScrollOffset();
        int computeVerticalScrollRange = iuVar.computeVerticalScrollRange() - iuVar.computeVerticalScrollExtent();
        if (computeVerticalScrollRange == 0) {
            return false;
        }
        if (i < 0) {
            if (computeVerticalScrollOffset <= 0) {
                return false;
            }
            return true;
        } else if (computeVerticalScrollOffset >= computeVerticalScrollRange - 1) {
            return false;
        } else {
            return true;
        }
    }

    public void mo2856v(View view) {
        if (view instanceof C0001if) {
            ((C0001if) view).stopNestedScroll();
        }
    }

    public boolean mo2857w(View view) {
        return jp.m24330c(view);
    }

    public void mo2835d(View view, int i) {
        jp.m24329b(view, i);
    }

    public void mo2838e(View view, int i) {
        jp.m24327a(view, i);
    }
}
