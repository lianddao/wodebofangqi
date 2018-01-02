package com.ushareit.listenit;

import android.graphics.Rect;
import android.os.Build.VERSION;
import android.view.View;
import com.umeng.analytics.C0154a;
import com.umeng.analytics.pro.C0277j;

public class mh {
    private static final mn f15943a;
    private final Object f15944b;

    static {
        if (VERSION.SDK_INT >= 24) {
            f15943a = new ml();
        } else if (VERSION.SDK_INT >= 22) {
            f15943a = new mk();
        } else if (VERSION.SDK_INT >= 21) {
            f15943a = new mj();
        } else if (VERSION.SDK_INT >= 19) {
            f15943a = new mr();
        } else if (VERSION.SDK_INT >= 18) {
            f15943a = new mq();
        } else if (VERSION.SDK_INT >= 17) {
            f15943a = new mp();
        } else if (VERSION.SDK_INT >= 16) {
            f15943a = new mo();
        } else if (VERSION.SDK_INT >= 14) {
            f15943a = new mm();
        } else {
            f15943a = new ms();
        }
    }

    static mh m24880a(Object obj) {
        if (obj != null) {
            return new mh(obj);
        }
        return null;
    }

    public mh(Object obj) {
        this.f15944b = obj;
    }

    public Object m24883a() {
        return this.f15944b;
    }

    public static mh m24879a(mh mhVar) {
        return m24880a(f15943a.mo2898a(mhVar.f15944b));
    }

    public void m24886a(View view) {
        f15943a.mo2914c(this.f15944b, view);
    }

    public void m24893b(View view) {
        f15943a.mo2901a(this.f15944b, view);
    }

    public int m24890b() {
        return f15943a.mo2905b(this.f15944b);
    }

    public void m24884a(int i) {
        f15943a.mo2899a(this.f15944b, i);
    }

    public boolean m24889a(mi miVar) {
        return f15943a.mo2904a(this.f15944b, miVar.f15967w);
    }

    public void m24891b(int i) {
        f15943a.mo2906b(this.f15944b, i);
    }

    public int m24897c() {
        return f15943a.mo2939r(this.f15944b);
    }

    public void m24899c(View view) {
        f15943a.mo2908b(this.f15944b, view);
    }

    public void m24885a(Rect rect) {
        f15943a.mo2900a(this.f15944b, rect);
    }

    public void m24892b(Rect rect) {
        f15943a.mo2913c(this.f15944b, rect);
    }

    public void m24898c(Rect rect) {
        f15943a.mo2907b(this.f15944b, rect);
    }

    public void m24903d(Rect rect) {
        f15943a.mo2919d(this.f15944b, rect);
    }

    public boolean m24905d() {
        return f15943a.mo2926g(this.f15944b);
    }

    public boolean m24907e() {
        return f15943a.mo2928h(this.f15944b);
    }

    public boolean m24909f() {
        return f15943a.mo2932k(this.f15944b);
    }

    public void m24888a(boolean z) {
        f15943a.mo2917c(this.f15944b, z);
    }

    public boolean m24911g() {
        return f15943a.mo2933l(this.f15944b);
    }

    public void m24896b(boolean z) {
        f15943a.mo2920d(this.f15944b, z);
    }

    public boolean m24913h() {
        return f15943a.mo2940s(this.f15944b);
    }

    public void m24902c(boolean z) {
        f15943a.mo2927h(this.f15944b, z);
    }

    public boolean m24915i() {
        return f15943a.mo2941t(this.f15944b);
    }

    public void m24904d(boolean z) {
        f15943a.mo2929i(this.f15944b, z);
    }

    public boolean m24916j() {
        return f15943a.mo2937p(this.f15944b);
    }

    public void m24906e(boolean z) {
        f15943a.mo2925g(this.f15944b, z);
    }

    public boolean m24917k() {
        return f15943a.mo2930i(this.f15944b);
    }

    public void m24908f(boolean z) {
        f15943a.mo2903a(this.f15944b, z);
    }

    public boolean m24918l() {
        return f15943a.mo2934m(this.f15944b);
    }

    public void m24910g(boolean z) {
        f15943a.mo2922e(this.f15944b, z);
    }

    public boolean m24919m() {
        return f15943a.mo2931j(this.f15944b);
    }

    public void m24912h(boolean z) {
        f15943a.mo2911b(this.f15944b, z);
    }

    public boolean m24920n() {
        return f15943a.mo2935n(this.f15944b);
    }

    public boolean m24921o() {
        return f15943a.mo2936o(this.f15944b);
    }

    public void m24914i(boolean z) {
        f15943a.mo2924f(this.f15944b, z);
    }

    public CharSequence m24922p() {
        return f15943a.mo2921e(this.f15944b);
    }

    public void m24887a(CharSequence charSequence) {
        f15943a.mo2915c(this.f15944b, charSequence);
    }

    public CharSequence m24923q() {
        return f15943a.mo2912c(this.f15944b);
    }

    public void m24894b(CharSequence charSequence) {
        f15943a.mo2902a(this.f15944b, charSequence);
    }

    public CharSequence m24924r() {
        return f15943a.mo2923f(this.f15944b);
    }

    public CharSequence m24925s() {
        return f15943a.mo2918d(this.f15944b);
    }

    public void m24900c(CharSequence charSequence) {
        f15943a.mo2909b(this.f15944b, charSequence);
    }

    public void m24926t() {
        f15943a.mo2938q(this.f15944b);
    }

    public String m24927u() {
        return f15943a.mo2942u(this.f15944b);
    }

    public void m24895b(Object obj) {
        f15943a.mo2910b(this.f15944b, ((mt) obj).f15968a);
    }

    public void m24901c(Object obj) {
        f15943a.mo2916c(this.f15944b, ((mu) obj).f15969a);
    }

    public int hashCode() {
        return this.f15944b == null ? 0 : this.f15944b.hashCode();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        mh mhVar = (mh) obj;
        if (this.f15944b == null) {
            if (mhVar.f15944b != null) {
                return false;
            }
            return true;
        } else if (this.f15944b.equals(mhVar.f15944b)) {
            return true;
        } else {
            return false;
        }
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.toString());
        Rect rect = new Rect();
        m24885a(rect);
        stringBuilder.append("; boundsInParent: " + rect);
        m24898c(rect);
        stringBuilder.append("; boundsInScreen: " + rect);
        stringBuilder.append("; packageName: ").append(m24922p());
        stringBuilder.append("; className: ").append(m24923q());
        stringBuilder.append("; text: ").append(m24924r());
        stringBuilder.append("; contentDescription: ").append(m24925s());
        stringBuilder.append("; viewId: ").append(m24927u());
        stringBuilder.append("; checkable: ").append(m24905d());
        stringBuilder.append("; checked: ").append(m24907e());
        stringBuilder.append("; focusable: ").append(m24909f());
        stringBuilder.append("; focused: ").append(m24911g());
        stringBuilder.append("; selected: ").append(m24916j());
        stringBuilder.append("; clickable: ").append(m24917k());
        stringBuilder.append("; longClickable: ").append(m24918l());
        stringBuilder.append("; enabled: ").append(m24919m());
        stringBuilder.append("; password: ").append(m24920n());
        stringBuilder.append("; scrollable: " + m24921o());
        stringBuilder.append("; [");
        int b = m24890b();
        while (b != 0) {
            int numberOfTrailingZeros = 1 << Integer.numberOfTrailingZeros(b);
            b &= numberOfTrailingZeros ^ -1;
            stringBuilder.append(m24881c(numberOfTrailingZeros));
            if (b != 0) {
                stringBuilder.append(", ");
            }
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    private static String m24881c(int i) {
        switch (i) {
            case 1:
                return "ACTION_FOCUS";
            case 2:
                return "ACTION_CLEAR_FOCUS";
            case 4:
                return "ACTION_SELECT";
            case 8:
                return "ACTION_CLEAR_SELECTION";
            case 16:
                return "ACTION_CLICK";
            case C0154a.f2957m /*32*/:
                return "ACTION_LONG_CLICK";
            case 64:
                return "ACTION_ACCESSIBILITY_FOCUS";
            case 128:
                return "ACTION_CLEAR_ACCESSIBILITY_FOCUS";
            case C0277j.f3694e /*256*/:
                return "ACTION_NEXT_AT_MOVEMENT_GRANULARITY";
            case C0277j.f3696g /*512*/:
                return "ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY";
            case 1024:
                return "ACTION_NEXT_HTML_ELEMENT";
            case 2048:
                return "ACTION_PREVIOUS_HTML_ELEMENT";
            case 4096:
                return "ACTION_SCROLL_FORWARD";
            case 8192:
                return "ACTION_SCROLL_BACKWARD";
            case 16384:
                return "ACTION_COPY";
            case 32768:
                return "ACTION_PASTE";
            case 65536:
                return "ACTION_CUT";
            case 131072:
                return "ACTION_SET_SELECTION";
            default:
                return "ACTION_UNKNOWN";
        }
    }
}
