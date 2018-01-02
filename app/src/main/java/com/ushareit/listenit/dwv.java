package com.ushareit.listenit;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.measurement.internal.EventParams;
import java.util.Iterator;

public class dwv {
    final String f10495a;
    final String f10496b;
    final String f10497c;
    final long f10498d;
    final long f10499e;
    final EventParams f10500f;

    dwv(dyf com_ushareit_listenit_dyf, String str, String str2, String str3, long j, long j2, Bundle bundle) {
        cfi.m11082a(str2);
        cfi.m11082a(str3);
        this.f10495a = str2;
        this.f10496b = str3;
        if (TextUtils.isEmpty(str)) {
            str = null;
        }
        this.f10497c = str;
        this.f10498d = j;
        this.f10499e = j2;
        if (this.f10499e != 0 && this.f10499e > this.f10498d) {
            com_ushareit_listenit_dyf.m16455f().m16262z().m16263a("Event created with reverse previous/current timestamps");
        }
        this.f10500f = m16158a(com_ushareit_listenit_dyf, bundle);
    }

    private dwv(dyf com_ushareit_listenit_dyf, String str, String str2, String str3, long j, long j2, EventParams eventParams) {
        cfi.m11082a(str2);
        cfi.m11082a(str3);
        cfi.m11080a((Object) eventParams);
        this.f10495a = str2;
        this.f10496b = str3;
        if (TextUtils.isEmpty(str)) {
            str = null;
        }
        this.f10497c = str;
        this.f10498d = j;
        this.f10499e = j2;
        if (this.f10499e != 0 && this.f10499e > this.f10498d) {
            com_ushareit_listenit_dyf.m16455f().m16262z().m16263a("Event created with reverse previous/current timestamps");
        }
        this.f10500f = eventParams;
    }

    static EventParams m16158a(dyf com_ushareit_listenit_dyf, Bundle bundle) {
        if (bundle == null || bundle.isEmpty()) {
            return new EventParams(new Bundle());
        }
        Bundle bundle2 = new Bundle(bundle);
        Iterator it = bundle2.keySet().iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            if (str == null) {
                com_ushareit_listenit_dyf.m16455f().m16242f().m16263a("Param name can't be null");
                it.remove();
            } else {
                Object b = com_ushareit_listenit_dyf.m16464o().m15960b(str, bundle2.get(str));
                if (b == null) {
                    com_ushareit_listenit_dyf.m16455f().m16262z().m16264a("Param value can't be null", str);
                    it.remove();
                } else {
                    com_ushareit_listenit_dyf.m16464o().m15947a(bundle2, str, b);
                }
            }
        }
        return new EventParams(bundle2);
    }

    dwv m16159a(dyf com_ushareit_listenit_dyf, long j) {
        return new dwv(com_ushareit_listenit_dyf, this.f10497c, this.f10495a, this.f10496b, this.f10498d, j, this.f10500f);
    }

    public String toString() {
        String str = this.f10495a;
        String str2 = this.f10496b;
        String valueOf = String.valueOf(this.f10500f);
        return new StringBuilder(((String.valueOf(str).length() + 33) + String.valueOf(str2).length()) + String.valueOf(valueOf).length()).append("Event{appId='").append(str).append("'").append(", name='").append(str2).append("'").append(", params=").append(valueOf).append("}").toString();
    }
}
