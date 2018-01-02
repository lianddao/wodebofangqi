package com.ushareit.listenit;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View.MeasureSpec;

public class ayu extends LinearLayoutManager {
    private final ayy f5684a;
    private final ayw f5685b;
    private final Context f5686c;
    private int[] f5687d;
    private int f5688e = 0;
    private float f5689f = 50.0f;
    private ayv f5690g;
    private int f5691h;

    public ayu(Context context, ayy com_ushareit_listenit_ayy, ayw com_ushareit_listenit_ayw) {
        super(context);
        this.f5686c = context;
        this.f5684a = com_ushareit_listenit_ayy;
        this.f5685b = com_ushareit_listenit_ayw;
        this.f5691h = -1;
        this.f5690g = new ayv(this, this.f5686c);
    }

    public void m7361a(double d) {
        if (d <= 0.0d) {
            d = 1.0d;
        }
        this.f5689f = (float) (50.0d / d);
        this.f5690g = new ayv(this, this.f5686c);
    }

    public void mo29a(RecyclerView recyclerView, ss ssVar, int i) {
        this.f5690g.m7377d(i);
        m254a(this.f5690g);
    }

    public void mo810a(sm smVar, ss ssVar, int i, int i2) {
        int mode = MeasureSpec.getMode(i);
        int mode2 = MeasureSpec.getMode(i2);
        if ((mode == 1073741824 && m392g() == 1) || (mode2 == 1073741824 && m392g() == 0)) {
            super.mo810a(smVar, ssVar, i, i2);
            return;
        }
        int[] a;
        int size = MeasureSpec.getSize(i);
        int size2 = MeasureSpec.getSize(i2);
        if (this.f5685b.m7406b(this.f5691h)) {
            a = this.f5685b.m7405a(this.f5691h);
        } else {
            a = new int[]{0, 0};
            if (ssVar.m26205e() >= 1) {
                for (int i3 = 0; i3 < 1; i3++) {
                    this.f5687d = this.f5684a.m7409a(smVar, i3, MeasureSpec.makeMeasureSpec(0, 0), MeasureSpec.makeMeasureSpec(0, 0));
                    if (m392g() == 0) {
                        a[0] = a[0] + this.f5687d[0];
                        if (i3 == 0) {
                            a[1] = (this.f5687d[1] + m327w()) + m329y();
                        }
                    } else {
                        a[1] = a[1] + this.f5687d[1];
                        if (i3 == 0) {
                            a[0] = (this.f5687d[0] + m326v()) + m328x();
                        }
                    }
                }
                if (this.f5691h != -1) {
                    this.f5685b.m7404a(this.f5691h, a);
                }
            }
        }
        if (mode == 1073741824) {
            a[0] = size;
        }
        if (mode2 == 1073741824) {
            a[1] = size2;
        }
        m281c(a[0], a[1]);
    }

    public void mo40d(int i) {
        super.m367a(i, this.f5688e);
    }

    public void mo811k(int i) {
        this.f5691h = i;
    }

    public void m7366l(int i) {
        this.f5688e = i;
    }
}
