package com.ushareit.listenit;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;

public class sw extends gk {
    final RecyclerView f16549b;
    final gk f16550c = new sx(this);

    public sw(RecyclerView recyclerView) {
        this.f16549b = recyclerView;
    }

    private boolean m26219c() {
        return this.f16549b.m555p();
    }

    public boolean mo2863a(View view, int i, Bundle bundle) {
        if (super.mo2863a(view, i, bundle)) {
            return true;
        }
        if (m26219c() || this.f16549b.getLayoutManager() == null) {
            return false;
        }
        return this.f16549b.getLayoutManager().m257a(i, bundle);
    }

    public void mo2862a(View view, mh mhVar) {
        super.mo2862a(view, mhVar);
        mhVar.m24894b(RecyclerView.class.getName());
        if (!m26219c() && this.f16549b.getLayoutManager() != null) {
            this.f16549b.getLayoutManager().m247a(mhVar);
        }
    }

    public void mo2864d(View view, AccessibilityEvent accessibilityEvent) {
        super.mo2864d(view, accessibilityEvent);
        accessibilityEvent.setClassName(RecyclerView.class.getName());
        if ((view instanceof RecyclerView) && !m26219c()) {
            RecyclerView recyclerView = (RecyclerView) view;
            if (recyclerView.getLayoutManager() != null) {
                recyclerView.getLayoutManager().mo30a(accessibilityEvent);
            }
        }
    }

    gk m26222b() {
        return this.f16550c;
    }
}
