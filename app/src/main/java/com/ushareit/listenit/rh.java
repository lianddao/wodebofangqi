package com.ushareit.listenit;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.view.View;

public class rh {
    public int f16410a;
    public int f16411b;
    public boolean f16412c;
    final /* synthetic */ LinearLayoutManager f16413d;

    public rh(LinearLayoutManager linearLayoutManager) {
        this.f16413d = linearLayoutManager;
    }

    public void m25944a() {
        this.f16410a = -1;
        this.f16411b = Integer.MIN_VALUE;
        this.f16412c = false;
    }

    public void m25946b() {
        this.f16411b = this.f16412c ? this.f16413d.f304k.mo3034d() : this.f16413d.f304k.mo3032c();
    }

    public String toString() {
        return "AnchorInfo{mPosition=" + this.f16410a + ", mCoordinate=" + this.f16411b + ", mLayoutFromEnd=" + this.f16412c + '}';
    }

    private boolean m25942a(View view, ss ssVar) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        return !layoutParams.m205c() && layoutParams.m207e() >= 0 && layoutParams.m207e() < ssVar.m26205e();
    }

    public void m25945a(View view) {
        int b = this.f16413d.f304k.m25969b();
        if (b >= 0) {
            m25947b(view);
            return;
        }
        this.f16410a = this.f16413d.m288d(view);
        int c;
        if (this.f16412c) {
            b = (this.f16413d.f304k.mo3034d() - b) - this.f16413d.f304k.mo3031b(view);
            this.f16411b = this.f16413d.f304k.mo3034d() - b;
            if (b > 0) {
                c = this.f16411b - this.f16413d.f304k.mo3033c(view);
                int c2 = this.f16413d.f304k.mo3032c();
                c -= c2 + Math.min(this.f16413d.f304k.mo3029a(view) - c2, 0);
                if (c < 0) {
                    this.f16411b = Math.min(b, -c) + this.f16411b;
                    return;
                }
                return;
            }
            return;
        }
        c = this.f16413d.f304k.mo3029a(view);
        c2 = c - this.f16413d.f304k.mo3032c();
        this.f16411b = c;
        if (c2 > 0) {
            b = (this.f16413d.f304k.mo3034d() - Math.min(0, (this.f16413d.f304k.mo3034d() - b) - this.f16413d.f304k.mo3031b(view))) - (c + this.f16413d.f304k.mo3033c(view));
            if (b < 0) {
                this.f16411b -= Math.min(c2, -b);
            }
        }
    }

    public void m25947b(View view) {
        if (this.f16412c) {
            this.f16411b = this.f16413d.f304k.mo3031b(view) + this.f16413d.f304k.m25969b();
        } else {
            this.f16411b = this.f16413d.f304k.mo3029a(view);
        }
        this.f16410a = this.f16413d.m288d(view);
    }
}
