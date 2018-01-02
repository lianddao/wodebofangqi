package com.ushareit.listenit;

import android.app.Activity;

public class doc {
    private final Object f10079a;

    public doc(Activity activity) {
        cfi.m11081a((Object) activity, (Object) "Activity must not be null");
        boolean z = ciu.m11404a() || (activity instanceof ak);
        cfi.m11090b(z, "This Activity is not supported before platform version 11 (3.0 Honeycomb). Please use FragmentActivity instead.");
        this.f10079a = activity;
    }

    public boolean m15148a() {
        return this.f10079a instanceof ak;
    }

    public Activity m15149b() {
        return (Activity) this.f10079a;
    }

    public ak m15150c() {
        return (ak) this.f10079a;
    }
}
