package com.ushareit.listenit;

import android.text.TextUtils;

final class bmz {
    public final String f7125a;
    public final boolean f7126b;

    public bmz(String str, boolean z) {
        this.f7125a = str;
        this.f7126b = z;
    }

    public int hashCode() {
        return (this.f7126b ? 1231 : 1237) + (((this.f7125a == null ? 0 : this.f7125a.hashCode()) + 31) * 31);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || obj.getClass() != bmz.class) {
            return false;
        }
        bmz com_ushareit_listenit_bmz = (bmz) obj;
        if (TextUtils.equals(this.f7125a, com_ushareit_listenit_bmz.f7125a) && this.f7126b == com_ushareit_listenit_bmz.f7126b) {
            return true;
        }
        return false;
    }
}
