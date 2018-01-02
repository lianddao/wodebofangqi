package com.ushareit.listenit;

import android.support.v7.widget.RecyclerView;

public class so extends rz {
    final /* synthetic */ RecyclerView f16524a;

    private so(RecyclerView recyclerView) {
        this.f16524a = recyclerView;
    }

    public void onChanged() {
        this.f16524a.m521a(null);
        if (this.f16524a.f361p.hasStableIds()) {
            this.f16524a.f353f.f16537f = true;
            this.f16524a.setDataSetChangedAfterLayout();
        } else {
            this.f16524a.f353f.f16537f = true;
            this.f16524a.setDataSetChangedAfterLayout();
        }
        if (!this.f16524a.f349b.m25732d()) {
            this.f16524a.requestLayout();
        }
    }

    public void onItemRangeChanged(int i, int i2, Object obj) {
        this.f16524a.m521a(null);
        if (this.f16524a.f349b.m25725a(i, i2, obj)) {
            m26178a();
        }
    }

    public void onItemRangeInserted(int i, int i2) {
        this.f16524a.m521a(null);
        if (this.f16524a.f349b.m25728b(i, i2)) {
            m26178a();
        }
    }

    public void onItemRangeRemoved(int i, int i2) {
        this.f16524a.m521a(null);
        if (this.f16524a.f349b.m25731c(i, i2)) {
            m26178a();
        }
    }

    public void onItemRangeMoved(int i, int i2, int i3) {
        this.f16524a.m521a(null);
        if (this.f16524a.f349b.m25724a(i, i2, i3)) {
            m26178a();
        }
    }

    void m26178a() {
        if (this.f16524a.f329E && this.f16524a.f368w && this.f16524a.f367v) {
            ja.m24141a(this.f16524a, this.f16524a.f359n);
            return;
        }
        this.f16524a.f328D = true;
        this.f16524a.requestLayout();
    }
}
