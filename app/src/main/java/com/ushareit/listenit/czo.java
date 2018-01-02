package com.ushareit.listenit;

import android.app.Activity;

class czo {
    private final Activity f9429a;
    private final Runnable f9430b;
    private final Object f9431c;

    public czo(Activity activity, Runnable runnable, Object obj) {
        this.f9429a = activity;
        this.f9430b = runnable;
        this.f9431c = obj;
    }

    public Activity m13517a() {
        return this.f9429a;
    }

    public Runnable m13518b() {
        return this.f9430b;
    }

    public Object m13519c() {
        return this.f9431c;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof czo)) {
            return false;
        }
        czo com_ushareit_listenit_czo = (czo) obj;
        return com_ushareit_listenit_czo.f9431c.equals(this.f9431c) && com_ushareit_listenit_czo.f9430b == this.f9430b && com_ushareit_listenit_czo.f9429a == this.f9429a;
    }

    public int hashCode() {
        return this.f9431c.hashCode();
    }
}
