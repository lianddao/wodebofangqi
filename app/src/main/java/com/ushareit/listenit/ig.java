package com.ushareit.listenit;

import android.view.View;
import android.view.ViewParent;

public class ig {
    private final View f15579a;
    private ViewParent f15580b;
    private boolean f15581c;
    private int[] f15582d;

    public ig(View view) {
        this.f15579a = view;
    }

    public void m24088a(boolean z) {
        if (this.f15581c) {
            ja.m24176v(this.f15579a);
        }
        this.f15581c = z;
    }

    public boolean m24089a() {
        return this.f15581c;
    }

    public boolean m24095b() {
        return this.f15580b != null;
    }

    public boolean m24092a(int i) {
        if (m24095b()) {
            return true;
        }
        if (m24089a()) {
            View view = this.f15579a;
            for (ViewParent parent = this.f15579a.getParent(); parent != null; parent = parent.getParent()) {
                if (lc.m24411a(parent, view, this.f15579a, i)) {
                    this.f15580b = parent;
                    lc.m24412b(parent, view, this.f15579a, i);
                    return true;
                }
                if (parent instanceof View) {
                    view = (View) parent;
                }
            }
        }
        return false;
    }

    public void m24096c() {
        if (this.f15580b != null) {
            lc.m24406a(this.f15580b, this.f15579a);
            this.f15580b = null;
        }
    }

    public boolean m24093a(int i, int i2, int i3, int i4, int[] iArr) {
        if (!m24089a() || this.f15580b == null) {
            return false;
        }
        if (i != 0 || i2 != 0 || i3 != 0 || i4 != 0) {
            int i5;
            int i6;
            if (iArr != null) {
                this.f15579a.getLocationInWindow(iArr);
                int i7 = iArr[0];
                i5 = iArr[1];
                i6 = i7;
            } else {
                i5 = 0;
                i6 = 0;
            }
            lc.m24407a(this.f15580b, this.f15579a, i, i2, i3, i4);
            if (iArr != null) {
                this.f15579a.getLocationInWindow(iArr);
                iArr[0] = iArr[0] - i6;
                iArr[1] = iArr[1] - i5;
            }
            return true;
        } else if (iArr == null) {
            return false;
        } else {
            iArr[0] = 0;
            iArr[1] = 0;
            return false;
        }
    }

    public boolean m24094a(int i, int i2, int[] iArr, int[] iArr2) {
        if (!m24089a() || this.f15580b == null) {
            return false;
        }
        if (i != 0 || i2 != 0) {
            int i3;
            int i4;
            if (iArr2 != null) {
                this.f15579a.getLocationInWindow(iArr2);
                i3 = iArr2[0];
                i4 = iArr2[1];
            } else {
                i4 = 0;
                i3 = 0;
            }
            if (iArr == null) {
                if (this.f15582d == null) {
                    this.f15582d = new int[2];
                }
                iArr = this.f15582d;
            }
            iArr[0] = 0;
            iArr[1] = 0;
            lc.m24408a(this.f15580b, this.f15579a, i, i2, iArr);
            if (iArr2 != null) {
                this.f15579a.getLocationInWindow(iArr2);
                iArr2[0] = iArr2[0] - i3;
                iArr2[1] = iArr2[1] - i4;
            }
            if (iArr[0] == 0 && iArr[1] == 0) {
                return false;
            }
            return true;
        } else if (iArr2 == null) {
            return false;
        } else {
            iArr2[0] = 0;
            iArr2[1] = 0;
            return false;
        }
    }

    public boolean m24091a(float f, float f2, boolean z) {
        if (!m24089a() || this.f15580b == null) {
            return false;
        }
        return lc.m24410a(this.f15580b, this.f15579a, f, f2, z);
    }

    public boolean m24090a(float f, float f2) {
        if (!m24089a() || this.f15580b == null) {
            return false;
        }
        return lc.m24409a(this.f15580b, this.f15579a, f, f2);
    }
}
