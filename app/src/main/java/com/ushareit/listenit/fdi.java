package com.ushareit.listenit;

import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;

public class fdi extends bc {
    private ar f12465a;
    private List<fji> f12466b = new ArrayList();

    public /* synthetic */ ah mo2351a(int i) {
        return m18885e(i);
    }

    public fdi(ar arVar, List<? extends fji> list) {
        super(arVar);
        this.f12465a = arVar;
        this.f12466b.addAll(list);
    }

    public void m18882a(List<fji> list) {
        this.f12466b.clear();
        this.f12466b.addAll(list);
        m7663c();
    }

    public int mo2352b() {
        return this.f12466b.size();
    }

    public fji m18885e(int i) {
        return (fji) this.f12466b.get(i);
    }

    public int mo2350a(Object obj) {
        if (this.f12466b.contains(obj)) {
            return super.mo2350a(obj);
        }
        return -2;
    }

    public void mo840a(ViewGroup viewGroup, int i, Object obj) {
        if (obj != null && i == this.f12466b.size()) {
            try {
                bh a = this.f12465a.mo797a();
                a.mo3092a((ah) obj);
                a.mo3098c();
            } catch (Exception e) {
            }
            super.mo840a(viewGroup, i, obj);
        }
    }

    public void mo843b(ViewGroup viewGroup, int i, Object obj) {
        try {
            super.mo843b(viewGroup, i, obj);
        } catch (Throwable e) {
            exw.m18450b("BaseFragmentPagerAdapter", "catch NullPointerException about performPendingDeferredStart", e);
        }
    }
}
