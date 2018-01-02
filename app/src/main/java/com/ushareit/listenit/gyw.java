package com.ushareit.listenit;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.inputmethod.InputMethodManager;
import java.util.LinkedList;
import java.util.List;

public class gyw implements OnGlobalLayoutListener {
    private View f14938a;
    private List<gyx> f14939b = new LinkedList();
    private boolean f14940c = false;
    private boolean f14941d = true;

    public gyw(View view) {
        this.f14938a = view;
        view.getViewTreeObserver().addOnGlobalLayoutListener(this);
    }

    public void onGlobalLayout() {
        Rect rect = new Rect();
        this.f14938a.getWindowVisibleDisplayFrame(rect);
        int height = this.f14938a.getRootView().getHeight() - rect.bottom;
        if (height > 100 && (this.f14941d || !this.f14940c)) {
            this.f14940c = true;
            this.f14941d = false;
            m23320a(height);
            exw.m18443a("SoftKeyboard", "VisibalRect=" + rect + ", height=" + this.f14938a.getRootView().getHeight());
        } else if (height >= 100) {
        } else {
            if (this.f14941d || this.f14940c) {
                this.f14940c = false;
                this.f14941d = false;
                m23322b();
                exw.m18443a("SoftKeyboard", "VisibalRect=" + rect + ", height=" + this.f14938a.getRootView().getHeight());
            }
        }
    }

    public static void m23321a(Context context, View view) {
        ((InputMethodManager) context.getSystemService("input_method")).showSoftInput(view, 1);
    }

    public static void m23323b(Context context, View view) {
        ((InputMethodManager) context.getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    public boolean m23325a() {
        return this.f14940c;
    }

    public void m23324a(gyx com_ushareit_listenit_gyx) {
        this.f14939b.add(com_ushareit_listenit_gyx);
    }

    private void m23320a(int i) {
        for (gyx com_ushareit_listenit_gyx : this.f14939b) {
            if (com_ushareit_listenit_gyx != null) {
                com_ushareit_listenit_gyx.mo2681a(i);
            }
        }
    }

    private void m23322b() {
        for (gyx com_ushareit_listenit_gyx : this.f14939b) {
            if (com_ushareit_listenit_gyx != null) {
                com_ushareit_listenit_gyx.mo2680a();
            }
        }
    }
}
