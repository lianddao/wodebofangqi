package com.ushareit.listenit;

import android.annotation.TargetApi;
import android.graphics.Point;
import android.os.Build.VERSION;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import java.util.ArrayList;
import java.util.List;

class afk {
    private final View f4262a;
    private final List<aff> f4263b = new ArrayList();
    private afl f4264c;
    private Point f4265d;

    public afk(View view) {
        this.f4262a = view;
    }

    private void m5458a(int i, int i2) {
        for (aff a : this.f4263b) {
            a.mo596a(i, i2);
        }
        this.f4263b.clear();
    }

    private void m5457a() {
        if (!this.f4263b.isEmpty()) {
            int c = m5462c();
            int b = m5461b();
            if (m5460a(c) && m5460a(b)) {
                m5458a(c, b);
                ViewTreeObserver viewTreeObserver = this.f4262a.getViewTreeObserver();
                if (viewTreeObserver.isAlive()) {
                    viewTreeObserver.removeOnPreDrawListener(this.f4264c);
                }
                this.f4264c = null;
            }
        }
    }

    public void m5464a(aff com_ushareit_listenit_aff) {
        int c = m5462c();
        int b = m5461b();
        if (m5460a(c) && m5460a(b)) {
            com_ushareit_listenit_aff.mo596a(c, b);
            return;
        }
        if (!this.f4263b.contains(com_ushareit_listenit_aff)) {
            this.f4263b.add(com_ushareit_listenit_aff);
        }
        if (this.f4264c == null) {
            ViewTreeObserver viewTreeObserver = this.f4262a.getViewTreeObserver();
            this.f4264c = new afl(this);
            viewTreeObserver.addOnPreDrawListener(this.f4264c);
        }
    }

    private int m5461b() {
        LayoutParams layoutParams = this.f4262a.getLayoutParams();
        if (m5460a(this.f4262a.getHeight())) {
            return this.f4262a.getHeight();
        }
        if (layoutParams != null) {
            return m5456a(layoutParams.height, true);
        }
        return 0;
    }

    private int m5462c() {
        LayoutParams layoutParams = this.f4262a.getLayoutParams();
        if (m5460a(this.f4262a.getWidth())) {
            return this.f4262a.getWidth();
        }
        if (layoutParams != null) {
            return m5456a(layoutParams.width, false);
        }
        return 0;
    }

    private int m5456a(int i, boolean z) {
        if (i != -2) {
            return i;
        }
        Point d = m5463d();
        return z ? d.y : d.x;
    }

    @TargetApi(13)
    private Point m5463d() {
        if (this.f4265d != null) {
            return this.f4265d;
        }
        Display defaultDisplay = ((WindowManager) this.f4262a.getContext().getSystemService("window")).getDefaultDisplay();
        if (VERSION.SDK_INT >= 13) {
            this.f4265d = new Point();
            defaultDisplay.getSize(this.f4265d);
        } else {
            this.f4265d = new Point(defaultDisplay.getWidth(), defaultDisplay.getHeight());
        }
        return this.f4265d;
    }

    private boolean m5460a(int i) {
        return i > 0 || i == -2;
    }
}
