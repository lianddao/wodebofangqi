package com.ushareit.listenit;

import android.view.WindowInsets;

class ma extends lz {
    private final WindowInsets f15889a;

    ma(WindowInsets windowInsets) {
        this.f15889a = windowInsets;
    }

    public int mo2887a() {
        return this.f15889a.getSystemWindowInsetLeft();
    }

    public int mo2889b() {
        return this.f15889a.getSystemWindowInsetTop();
    }

    public int mo2890c() {
        return this.f15889a.getSystemWindowInsetRight();
    }

    public int mo2891d() {
        return this.f15889a.getSystemWindowInsetBottom();
    }

    public boolean mo2892e() {
        return this.f15889a.isConsumed();
    }

    public lz mo2888a(int i, int i2, int i3, int i4) {
        return new ma(this.f15889a.replaceSystemWindowInsets(i, i2, i3, i4));
    }

    WindowInsets m24794f() {
        return this.f15889a;
    }
}
