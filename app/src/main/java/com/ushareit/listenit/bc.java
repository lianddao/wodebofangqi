package com.ushareit.listenit;

import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;

public abstract class bc extends ik {
    private final ar f5887a;
    private bh f5888b = null;
    private ah f5889c = null;

    public abstract ah mo2351a(int i);

    public bc(ar arVar) {
        this.f5887a = arVar;
    }

    public void mo839a(ViewGroup viewGroup) {
        if (viewGroup.getId() == -1) {
            throw new IllegalStateException("ViewPager with adapter " + this + " requires a view id");
        }
    }

    public Object mo837a(ViewGroup viewGroup, int i) {
        if (this.f5888b == null) {
            this.f5888b = this.f5887a.mo797a();
        }
        long b = m7674b(i);
        ah a = this.f5887a.mo796a(m7666a(viewGroup.getId(), b));
        if (a != null) {
            this.f5888b.mo3102e(a);
        } else {
            a = mo2351a(i);
            this.f5888b.mo3091a(viewGroup.getId(), a, m7666a(viewGroup.getId(), b));
        }
        if (a != this.f5889c) {
            a.m1312e(false);
            a.m1315f(false);
        }
        return a;
    }

    public void mo840a(ViewGroup viewGroup, int i, Object obj) {
        if (this.f5888b == null) {
            this.f5888b = this.f5887a.mo797a();
        }
        this.f5888b.mo3100d((ah) obj);
    }

    public void mo843b(ViewGroup viewGroup, int i, Object obj) {
        ah ahVar = (ah) obj;
        if (ahVar != this.f5889c) {
            if (this.f5889c != null) {
                this.f5889c.m1312e(false);
                this.f5889c.m1315f(false);
            }
            if (ahVar != null) {
                ahVar.m1312e(true);
                ahVar.m1315f(true);
            }
            this.f5889c = ahVar;
        }
    }

    public void mo842b(ViewGroup viewGroup) {
        if (this.f5888b != null) {
            this.f5888b.mo3101d();
            this.f5888b = null;
        }
    }

    public boolean mo841a(View view, Object obj) {
        return ((ah) obj).m1338w() == view;
    }

    public Parcelable mo836a() {
        return null;
    }

    public void mo838a(Parcelable parcelable, ClassLoader classLoader) {
    }

    public long m7674b(int i) {
        return (long) i;
    }

    private static String m7666a(int i, long j) {
        return "android:switcher:" + i + ":" + j;
    }
}
