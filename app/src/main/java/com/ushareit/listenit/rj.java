package com.ushareit.listenit;

import android.support.v7.widget.RecyclerView.LayoutParams;
import android.view.View;
import com.mopub.nativeads.MoPubNativeAdPositioning.MoPubClientPositioning;
import java.util.List;

public class rj {
    public boolean f16418a = true;
    public int f16419b;
    public int f16420c;
    public int f16421d;
    public int f16422e;
    public int f16423f;
    public int f16424g;
    public int f16425h = 0;
    public boolean f16426i = false;
    public int f16427j;
    public List<sv> f16428k = null;

    public boolean m25953a(ss ssVar) {
        return this.f16421d >= 0 && this.f16421d < ssVar.m26205e();
    }

    public View m25950a(sm smVar) {
        if (this.f16428k != null) {
            return m25949b();
        }
        View c = smVar.m26160c(this.f16421d);
        this.f16421d += this.f16422e;
        return c;
    }

    private View m25949b() {
        int size = this.f16428k.size();
        for (int i = 0; i < size; i++) {
            View view = ((sv) this.f16428k.get(i)).itemView;
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            if (!layoutParams.m205c() && this.f16421d == layoutParams.m207e()) {
                m25952a(view);
                return view;
            }
        }
        return null;
    }

    public void m25951a() {
        m25952a(null);
    }

    public void m25952a(View view) {
        View b = m25954b(view);
        if (b == null) {
            this.f16421d = -1;
        } else {
            this.f16421d = ((LayoutParams) b.getLayoutParams()).m207e();
        }
    }

    public View m25954b(View view) {
        int size = this.f16428k.size();
        View view2 = null;
        int i = MoPubClientPositioning.NO_REPEAT;
        int i2 = 0;
        while (i2 < size) {
            int i3;
            View view3;
            View view4 = ((sv) this.f16428k.get(i2)).itemView;
            LayoutParams layoutParams = (LayoutParams) view4.getLayoutParams();
            if (view4 != view) {
                if (layoutParams.m205c()) {
                    i3 = i;
                    view3 = view2;
                } else {
                    i3 = (layoutParams.m207e() - this.f16421d) * this.f16422e;
                    if (i3 < 0) {
                        i3 = i;
                        view3 = view2;
                    } else if (i3 < i) {
                        if (i3 == 0) {
                            return view4;
                        }
                        view3 = view4;
                    }
                }
                i2++;
                view2 = view3;
                i = i3;
            }
            i3 = i;
            view3 = view2;
            i2++;
            view2 = view3;
            i = i3;
        }
        return view2;
    }
}
