package com.ushareit.listenit;

import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.StaggeredGridLayoutManager.LayoutParams;
import android.support.v7.widget.StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem;
import android.view.View;
import java.util.ArrayList;

public class th {
    int f16583a;
    int f16584b;
    int f16585c;
    public final int f16586d;
    final /* synthetic */ StaggeredGridLayoutManager f16587e;
    private ArrayList<View> f16588f;

    public int m26260a(int i) {
        if (this.f16583a != Integer.MIN_VALUE) {
            return this.f16583a;
        }
        if (this.f16588f.size() == 0) {
            return i;
        }
        m26261a();
        return this.f16583a;
    }

    void m26261a() {
        View view = (View) this.f16588f.get(0);
        LayoutParams c = m26267c(view);
        this.f16583a = this.f16587e.f392a.mo3029a(view);
        if (c.f373f) {
            FullSpanItem f = this.f16587e.f397f.m572f(c.m207e());
            if (f != null && f.f375b == -1) {
                this.f16583a -= f.m557a(this.f16586d);
            }
        }
    }

    public int m26264b() {
        if (this.f16583a != Integer.MIN_VALUE) {
            return this.f16583a;
        }
        m26261a();
        return this.f16583a;
    }

    public int m26265b(int i) {
        if (this.f16584b != Integer.MIN_VALUE) {
            return this.f16584b;
        }
        if (this.f16588f.size() == 0) {
            return i;
        }
        m26268c();
        return this.f16584b;
    }

    void m26268c() {
        View view = (View) this.f16588f.get(this.f16588f.size() - 1);
        LayoutParams c = m26267c(view);
        this.f16584b = this.f16587e.f392a.mo3031b(view);
        if (c.f373f) {
            FullSpanItem f = this.f16587e.f397f.m572f(c.m207e());
            if (f != null && f.f375b == 1) {
                this.f16584b = f.m557a(this.f16586d) + this.f16584b;
            }
        }
    }

    public int m26270d() {
        if (this.f16584b != Integer.MIN_VALUE) {
            return this.f16584b;
        }
        m26268c();
        return this.f16584b;
    }

    public void m26262a(View view) {
        LayoutParams c = m26267c(view);
        c.f372e = this;
        this.f16588f.add(0, view);
        this.f16583a = Integer.MIN_VALUE;
        if (this.f16588f.size() == 1) {
            this.f16584b = Integer.MIN_VALUE;
        }
        if (c.m205c() || c.m206d()) {
            this.f16585c += this.f16587e.f392a.mo3033c(view);
        }
    }

    public void m26266b(View view) {
        LayoutParams c = m26267c(view);
        c.f372e = this;
        this.f16588f.add(view);
        this.f16584b = Integer.MIN_VALUE;
        if (this.f16588f.size() == 1) {
            this.f16583a = Integer.MIN_VALUE;
        }
        if (c.m205c() || c.m206d()) {
            this.f16585c += this.f16587e.f392a.mo3033c(view);
        }
    }

    public void m26263a(boolean z, int i) {
        int b;
        if (z) {
            b = m26265b(Integer.MIN_VALUE);
        } else {
            b = m26260a(Integer.MIN_VALUE);
        }
        m26272e();
        if (b != Integer.MIN_VALUE) {
            if (z && b < this.f16587e.f392a.mo3034d()) {
                return;
            }
            if (z || b <= this.f16587e.f392a.mo3032c()) {
                if (i != Integer.MIN_VALUE) {
                    b += i;
                }
                this.f16584b = b;
                this.f16583a = b;
            }
        }
    }

    public void m26272e() {
        this.f16588f.clear();
        m26273f();
        this.f16585c = 0;
    }

    void m26273f() {
        this.f16583a = Integer.MIN_VALUE;
        this.f16584b = Integer.MIN_VALUE;
    }

    public void m26269c(int i) {
        this.f16583a = i;
        this.f16584b = i;
    }

    public void m26274g() {
        int size = this.f16588f.size();
        View view = (View) this.f16588f.remove(size - 1);
        LayoutParams c = m26267c(view);
        c.f372e = null;
        if (c.m205c() || c.m206d()) {
            this.f16585c -= this.f16587e.f392a.mo3033c(view);
        }
        if (size == 1) {
            this.f16583a = Integer.MIN_VALUE;
        }
        this.f16584b = Integer.MIN_VALUE;
    }

    public void m26275h() {
        View view = (View) this.f16588f.remove(0);
        LayoutParams c = m26267c(view);
        c.f372e = null;
        if (this.f16588f.size() == 0) {
            this.f16584b = Integer.MIN_VALUE;
        }
        if (c.m205c() || c.m206d()) {
            this.f16585c -= this.f16587e.f392a.mo3033c(view);
        }
        this.f16583a = Integer.MIN_VALUE;
    }

    public int m26276i() {
        return this.f16585c;
    }

    LayoutParams m26267c(View view) {
        return (LayoutParams) view.getLayoutParams();
    }

    public void m26271d(int i) {
        if (this.f16583a != Integer.MIN_VALUE) {
            this.f16583a += i;
        }
        if (this.f16584b != Integer.MIN_VALUE) {
            this.f16584b += i;
        }
    }
}
