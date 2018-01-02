package com.ushareit.listenit;

import android.database.Cursor;
import java.io.Serializable;

public abstract class gla implements hgw, Serializable {
    private boolean f13342a;

    public abstract String mo2557a();

    public abstract void mo2559a(int i);

    public abstract void mo2560a(Cursor cursor);

    public abstract int mo2561b();

    public abstract String mo2562c();

    public gla(Cursor cursor) {
        mo2560a(cursor);
    }

    public int mo2703e() {
        return 0;
    }

    public void m20775a(boolean z) {
        this.f13342a = z;
    }

    public boolean m20780f() {
        return this.f13342a;
    }

    public boolean equals(Object obj) {
        return obj != null ? ((gla) obj).mo2557a().equals(mo2557a()) : false;
    }

    public String mo2558g() {
        return "";
    }

    public long mo2702d() {
        return 0;
    }

    public void mo2701a(long j) {
    }
}
