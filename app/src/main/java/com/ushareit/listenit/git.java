package com.ushareit.listenit;

import android.view.View;
import com.ushareit.listenit.main.MainActivity;

public class git implements kx {
    final /* synthetic */ MainActivity f14177a;
    private int f14178b = 0;

    public git(MainActivity mainActivity) {
        this.f14177a = mainActivity;
    }

    public void mo2620b(int i) {
        if (i == 0 && this.f14177a.f15909p.size() > 0 && this.f14178b == this.f14177a.f15909p.size() - 2) {
            fji com_ushareit_listenit_fji = (fji) this.f14177a.f15909p.remove(this.f14178b + 1);
            com_ushareit_listenit_fji.mo202y();
            this.f14177a.f15910q.m18882a(this.f14177a.f15909p);
            if (this.f14177a.f15909p.size() > 0) {
                ((fji) this.f14177a.f15909p.get(this.f14177a.f15909p.size() - 1)).mo201x();
            }
            exw.m18449b("UI.MainActivity", "remove isManagementMode=" + com_ushareit_listenit_fji.m19527a() + ", fragment=" + com_ushareit_listenit_fji.getClass().getSimpleName() + ", size=" + this.f14177a.f15909p.size());
            if (com_ushareit_listenit_fji.m19527a()) {
                gyn.m23194a((ak) this.f14177a.f15908o.getContext());
            }
        }
    }

    public void mo2619a(int i, float f, int i2) {
        View w = ((fji) this.f14177a.f15909p.get(i)).m1338w();
        if (w != null) {
            erj.m17574e(w, ((float) i2) * 0.5f);
        }
        if (this.f14177a.f15909p.size() > 1 && ((fji) this.f14177a.f15909p.get(this.f14177a.f15909p.size() - 1)).m19527a() && this.f14177a.f15907n != null && this.f14177a.f15907n.m1338w() != null) {
            erj.m17574e(this.f14177a.f15907n.m1338w(), ((float) (-i2)) * 0.5f);
        }
    }

    public void mo2618a(int i) {
        this.f14178b = i;
    }
}
