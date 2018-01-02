package com.ushareit.listenit;

import android.content.ComponentName;
import android.content.Intent;

final class chh {
    private final String f8300a;
    private final String f8301b;
    private final ComponentName f8302c = null;

    public chh(String str, String str2) {
        this.f8300a = cfi.m11082a(str);
        this.f8301b = cfi.m11082a(str2);
    }

    public Intent m11231a() {
        return this.f8300a != null ? new Intent(this.f8300a).setPackage(this.f8301b) : new Intent().setComponent(this.f8302c);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof chh)) {
            return false;
        }
        chh com_ushareit_listenit_chh = (chh) obj;
        return cff.m11078a(this.f8300a, com_ushareit_listenit_chh.f8300a) && cff.m11078a(this.f8302c, com_ushareit_listenit_chh.f8302c);
    }

    public int hashCode() {
        return cff.m11076a(this.f8300a, this.f8302c);
    }

    public String toString() {
        return this.f8300a == null ? this.f8302c.flattenToString() : this.f8300a;
    }
}
