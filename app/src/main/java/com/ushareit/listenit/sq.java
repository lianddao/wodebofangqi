package com.ushareit.listenit;

import android.graphics.PointF;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

public abstract class sq {
    private int f5692a = -1;
    private RecyclerView f5693b;
    private sh f5694c;
    private boolean f5695d;
    private boolean f5696e;
    private View f5697f;
    private final sr f5698g = new sr(0, 0);

    protected abstract void mo812a();

    protected abstract void mo813a(int i, int i2, ss ssVar, sr srVar);

    protected abstract void mo814a(View view, ss ssVar, sr srVar);

    protected abstract void mo815b();

    void m7373a(RecyclerView recyclerView, sh shVar) {
        this.f5693b = recyclerView;
        this.f5694c = shVar;
        if (this.f5692a == -1) {
            throw new IllegalArgumentException("Invalid target position");
        }
        this.f5693b.f353f.f16533b = this.f5692a;
        this.f5696e = true;
        this.f5695d = true;
        this.f5697f = m7378e(m7383i());
        mo812a();
        this.f5693b.ab.m26211a();
    }

    public void m7377d(int i) {
        this.f5692a = i;
    }

    public sh m7379e() {
        return this.f5694c;
    }

    protected final void m7380f() {
        if (this.f5696e) {
            mo815b();
            this.f5693b.f353f.f16533b = -1;
            this.f5697f = null;
            this.f5692a = -1;
            this.f5695d = false;
            this.f5696e = false;
            this.f5694c.m221b(this);
            this.f5694c = null;
            this.f5693b = null;
        }
    }

    public boolean m7381g() {
        return this.f5695d;
    }

    public boolean m7382h() {
        return this.f5696e;
    }

    public int m7383i() {
        return this.f5692a;
    }

    private void m7367a(int i, int i2) {
        RecyclerView recyclerView = this.f5693b;
        if (!this.f5696e || this.f5692a == -1 || recyclerView == null) {
            m7380f();
        }
        this.f5695d = false;
        if (this.f5697f != null) {
            if (m7369a(this.f5697f) == this.f5692a) {
                mo814a(this.f5697f, recyclerView.f353f, this.f5698g);
                this.f5698g.m26181a(recyclerView);
                m7380f();
            } else {
                Log.e("RecyclerView", "Passed over target position while smooth scrolling.");
                this.f5697f = null;
            }
        }
        if (this.f5696e) {
            mo813a(i, i2, recyclerView.f353f, this.f5698g);
            boolean a = this.f5698g.m26186a();
            this.f5698g.m26181a(recyclerView);
            if (!a) {
                return;
            }
            if (this.f5696e) {
                this.f5695d = true;
                recyclerView.ab.m26211a();
                return;
            }
            m7380f();
        }
    }

    public int m7369a(View view) {
        return this.f5693b.m528c(view);
    }

    public int m7384j() {
        return this.f5693b.f362q.m323s();
    }

    public View m7378e(int i) {
        return this.f5693b.f362q.mo34b(i);
    }

    protected void m7376b(View view) {
        if (m7369a(view) == m7383i()) {
            this.f5697f = view;
        }
    }

    protected void m7372a(PointF pointF) {
        double sqrt = Math.sqrt((double) ((pointF.x * pointF.x) + (pointF.y * pointF.y)));
        pointF.x = (float) (((double) pointF.x) / sqrt);
        pointF.y = (float) (((double) pointF.y) / sqrt);
    }
}
