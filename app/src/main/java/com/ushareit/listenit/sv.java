package com.ushareit.listenit;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.util.Log;
import android.view.View;
import com.umeng.analytics.pro.C0277j;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class sv {
    private static final List<Object> f2664l = Collections.EMPTY_LIST;
    public int f2665a = -1;
    int f2666b = -1;
    long f2667c = -1;
    int f2668d = -1;
    int f2669e = -1;
    public sv f2670f = null;
    public sv f2671g = null;
    List<Object> f2672h = null;
    List<Object> f2673i = null;
    public final View itemView;
    RecyclerView f2674j;
    private int f2675k;
    private int f2676m = 0;
    private sm f2677n = null;
    private boolean f2678o = false;
    private int f2679p = 0;

    public sv(View view) {
        if (view == null) {
            throw new IllegalArgumentException("itemView may not be null");
        }
        this.itemView = view;
    }

    public void m3222a(int i, int i2, boolean z) {
        m3228b(8);
        m3223a(i2, z);
        this.f2665a = i;
    }

    public void m3223a(int i, boolean z) {
        if (this.f2666b == -1) {
            this.f2666b = this.f2665a;
        }
        if (this.f2669e == -1) {
            this.f2669e = this.f2665a;
        }
        if (z) {
            this.f2669e += i;
        }
        this.f2665a += i;
        if (this.itemView.getLayoutParams() != null) {
            ((LayoutParams) this.itemView.getLayoutParams()).f288c = true;
        }
    }

    public void m3220a() {
        this.f2666b = -1;
        this.f2669e = -1;
    }

    public void m3227b() {
        if (this.f2666b == -1) {
            this.f2666b = this.f2665a;
        }
    }

    public boolean m3229c() {
        return (this.f2675k & 128) != 0;
    }

    @Deprecated
    public final int getPosition() {
        return this.f2669e == -1 ? this.f2665a : this.f2669e;
    }

    public final int getLayoutPosition() {
        return this.f2669e == -1 ? this.f2665a : this.f2669e;
    }

    public final int getAdapterPosition() {
        if (this.f2674j == null) {
            return -1;
        }
        return this.f2674j.m476d(this);
    }

    public final int getOldPosition() {
        return this.f2666b;
    }

    public final long getItemId() {
        return this.f2667c;
    }

    public final int getItemViewType() {
        return this.f2668d;
    }

    boolean m3230d() {
        return this.f2677n != null;
    }

    void m3231e() {
        this.f2677n.m26167d(this);
    }

    boolean m3232f() {
        return (this.f2675k & 32) != 0;
    }

    void m3233g() {
        this.f2675k &= -33;
    }

    public void m3234h() {
        this.f2675k &= -257;
    }

    void m3224a(sm smVar, boolean z) {
        this.f2677n = smVar;
        this.f2678o = z;
    }

    public boolean m3235i() {
        return (this.f2675k & 4) != 0;
    }

    boolean m3236j() {
        return (this.f2675k & 2) != 0;
    }

    public boolean m3237k() {
        return (this.f2675k & 1) != 0;
    }

    public boolean m3238l() {
        return (this.f2675k & 8) != 0;
    }

    public boolean m3226a(int i) {
        return (this.f2675k & i) != 0;
    }

    public boolean m3239m() {
        return (this.f2675k & C0277j.f3694e) != 0;
    }

    boolean m3240n() {
        return (this.f2675k & C0277j.f3696g) != 0 || m3235i();
    }

    public void m3221a(int i, int i2) {
        this.f2675k = (this.f2675k & (i2 ^ -1)) | (i & i2);
    }

    public void m3228b(int i) {
        this.f2675k |= i;
    }

    public void m3225a(Object obj) {
        if (obj == null) {
            m3228b(1024);
        } else if ((this.f2675k & 1024) == 0) {
            mo2563s();
            this.f2672h.add(obj);
        }
    }

    private void mo2563s() {
        if (this.f2672h == null) {
            this.f2672h = new ArrayList();
            this.f2673i = Collections.unmodifiableList(this.f2672h);
        }
    }

    void m3241o() {
        if (this.f2672h != null) {
            this.f2672h.clear();
        }
        this.f2675k &= -1025;
    }

    public List<Object> m3242p() {
        if ((this.f2675k & 1024) != 0) {
            return f2664l;
        }
        if (this.f2672h == null || this.f2672h.size() == 0) {
            return f2664l;
        }
        return this.f2673i;
    }

    void m3243q() {
        this.f2675k = 0;
        this.f2665a = -1;
        this.f2666b = -1;
        this.f2667c = -1;
        this.f2669e = -1;
        this.f2676m = 0;
        this.f2670f = null;
        this.f2671g = null;
        m3241o();
        this.f2679p = 0;
    }

    private void m3216t() {
        this.f2679p = ja.m24156e(this.itemView);
        ja.m24151c(this.itemView, 4);
    }

    private void m3217u() {
        ja.m24151c(this.itemView, this.f2679p);
        this.f2679p = 0;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("ViewHolder{" + Integer.toHexString(hashCode()) + " position=" + this.f2665a + " id=" + this.f2667c + ", oldPos=" + this.f2666b + ", pLpos:" + this.f2669e);
        if (m3230d()) {
            stringBuilder.append(" scrap ").append(this.f2678o ? "[changeScrap]" : "[attachedScrap]");
        }
        if (m3235i()) {
            stringBuilder.append(" invalid");
        }
        if (!m3237k()) {
            stringBuilder.append(" unbound");
        }
        if (m3236j()) {
            stringBuilder.append(" update");
        }
        if (m3238l()) {
            stringBuilder.append(" removed");
        }
        if (m3229c()) {
            stringBuilder.append(" ignored");
        }
        if (m3239m()) {
            stringBuilder.append(" tmpDetached");
        }
        if (!isRecyclable()) {
            stringBuilder.append(" not recyclable(" + this.f2676m + ")");
        }
        if (m3240n()) {
            stringBuilder.append(" undefined adapter position");
        }
        if (this.itemView.getParent() == null) {
            stringBuilder.append(" no parent");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public final void setIsRecyclable(boolean z) {
        this.f2676m = z ? this.f2676m - 1 : this.f2676m + 1;
        if (this.f2676m < 0) {
            this.f2676m = 0;
            Log.e("View", "isRecyclable decremented below 0: unmatched pair of setIsRecyable() calls for " + this);
        } else if (!z && this.f2676m == 1) {
            this.f2675k |= 16;
        } else if (z && this.f2676m == 0) {
            this.f2675k &= -17;
        }
    }

    public final boolean isRecyclable() {
        return (this.f2675k & 16) == 0 && !ja.m24152c(this.itemView);
    }

    private boolean m3218v() {
        return (this.f2675k & 16) != 0;
    }

    private boolean m3219w() {
        return (this.f2675k & 16) == 0 && ja.m24152c(this.itemView);
    }

    public boolean m3244r() {
        return (this.f2675k & 2) != 0;
    }
}
