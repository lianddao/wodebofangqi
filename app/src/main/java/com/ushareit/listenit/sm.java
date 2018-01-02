package com.ushareit.listenit;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.umeng.analytics.pro.C0277j;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class sm {
    final ArrayList<sv> f16516a = new ArrayList();
    final ArrayList<sv> f16517b = new ArrayList();
    final /* synthetic */ RecyclerView f16518c;
    private ArrayList<sv> f16519d = null;
    private final List<sv> f16520e = Collections.unmodifiableList(this.f16516a);
    private int f16521f = 2;
    private sl f16522g;
    private st f16523h;

    public sm(RecyclerView recyclerView) {
        this.f16518c = recyclerView;
    }

    public void m26146a() {
        this.f16516a.clear();
        m26161c();
    }

    public void m26147a(int i) {
        this.f16521f = i;
        for (int size = this.f16517b.size() - 1; size >= 0 && this.f16517b.size() > i; size--) {
            m26166d(size);
        }
    }

    public List<sv> m26155b() {
        return this.f16520e;
    }

    boolean m26153a(sv svVar) {
        if (svVar.m3238l()) {
            return this.f16518c.f353f.m26201a();
        }
        if (svVar.f2665a < 0 || svVar.f2665a >= this.f16518c.f361p.getItemCount()) {
            throw new IndexOutOfBoundsException("Inconsistency detected. Invalid view holder adapter position" + svVar);
        } else if (!this.f16518c.f353f.m26201a() && this.f16518c.f361p.getItemViewType(svVar.f2665a) != svVar.getItemViewType()) {
            return false;
        } else {
            if (!this.f16518c.f361p.hasStableIds() || svVar.getItemId() == this.f16518c.f361p.getItemId(svVar.f2665a)) {
                return true;
            }
            return false;
        }
    }

    public int m26154b(int i) {
        if (i >= 0 && i < this.f16518c.f353f.m26205e()) {
            return !this.f16518c.f353f.m26201a() ? i : this.f16518c.f349b.m25726b(i);
        } else {
            throw new IndexOutOfBoundsException("invalid position " + i + ". State " + "item count is " + this.f16518c.f353f.m26205e());
        }
    }

    public View m26160c(int i) {
        return m26143a(i, false);
    }

    View m26143a(int i, boolean z) {
        boolean z2 = true;
        if (i < 0 || i >= this.f16518c.f353f.m26205e()) {
            throw new IndexOutOfBoundsException("Invalid item position " + i + "(" + i + "). Item count:" + this.f16518c.f353f.m26205e());
        }
        sv f;
        boolean z3;
        sv svVar;
        boolean z4;
        int b;
        boolean z5;
        int b2;
        LayoutParams layoutParams;
        RecyclerView.LayoutParams layoutParams2;
        if (this.f16518c.f353f.m26201a()) {
            f = m26172f(i);
            sv svVar2 = f;
            z3 = f != null;
            svVar = svVar2;
        } else {
            svVar = null;
            z3 = false;
        }
        if (svVar == null) {
            svVar = m26144a(i, -1, z);
            if (svVar != null) {
                if (m26153a(svVar)) {
                    z4 = true;
                } else {
                    if (!z) {
                        svVar.m3228b(4);
                        if (svVar.m3230d()) {
                            this.f16518c.removeDetachedView(svVar.itemView, false);
                            svVar.m3231e();
                        } else if (svVar.m3232f()) {
                            svVar.m3233g();
                        }
                        m26159b(svVar);
                    }
                    svVar = null;
                    z4 = z3;
                }
                if (svVar == null) {
                    b = this.f16518c.f349b.m25726b(i);
                    if (b >= 0 || b >= this.f16518c.f361p.getItemCount()) {
                        throw new IndexOutOfBoundsException("Inconsistency detected. Invalid item position " + i + "(offset:" + b + ")." + "state:" + this.f16518c.f353f.m26205e());
                    }
                    int itemViewType = this.f16518c.f361p.getItemViewType(b);
                    if (this.f16518c.f361p.hasStableIds()) {
                        svVar = m26145a(this.f16518c.f361p.getItemId(b), itemViewType, z);
                        if (svVar != null) {
                            svVar.f2665a = b;
                            z4 = true;
                        }
                    }
                    if (svVar == null && this.f16523h != null) {
                        View a = this.f16523h.m26206a(this, i, itemViewType);
                        if (a != null) {
                            svVar = this.f16518c.m514a(a);
                            if (svVar == null) {
                                throw new IllegalArgumentException("getViewForPositionAndType returned a view which does not have a ViewHolder");
                            } else if (svVar.m3229c()) {
                                throw new IllegalArgumentException("getViewForPositionAndType returned a view that is ignored. You must call stopIgnoring before returning this view.");
                            }
                        }
                    }
                    if (svVar == null) {
                        svVar = m26171f().m26119a(itemViewType);
                        if (svVar != null) {
                            svVar.m3243q();
                            if (RecyclerView.f323i) {
                                m26142f(svVar);
                            }
                        }
                    }
                    if (svVar == null) {
                        f = this.f16518c.f361p.createViewHolder(this.f16518c, itemViewType);
                        z5 = z4;
                        if (z5 && !this.f16518c.f353f.m26201a() && f.m3226a(8192)) {
                            f.m3221a(0, 8192);
                            if (this.f16518c.f353f.f16539h) {
                                this.f16518c.m450a(f, this.f16518c.f352e.m25829a(this.f16518c.f353f, f, sb.m25827d(f) | 4096, f.m3242p()));
                            }
                        }
                        int i2;
                        if (!this.f16518c.f353f.m26201a() && f.m3237k()) {
                            f.f2669e = i;
                            i2 = 0;
                        } else if (f.m3237k() || f.m3236j() || f.m3235i()) {
                            b2 = this.f16518c.f349b.m25726b(i);
                            f.f2674j = this.f16518c;
                            this.f16518c.f361p.bindViewHolder(f, b2);
                            m26141d(f.itemView);
                            if (this.f16518c.f353f.m26201a()) {
                                f.f2669e = i;
                            }
                            z4 = true;
                        } else {
                            i2 = 0;
                        }
                        layoutParams = f.itemView.getLayoutParams();
                        if (layoutParams != null) {
                            layoutParams2 = (RecyclerView.LayoutParams) this.f16518c.generateDefaultLayoutParams();
                            f.itemView.setLayoutParams(layoutParams2);
                        } else if (this.f16518c.checkLayoutParams(layoutParams)) {
                            layoutParams2 = (RecyclerView.LayoutParams) layoutParams;
                        } else {
                            layoutParams2 = (RecyclerView.LayoutParams) this.f16518c.generateLayoutParams(layoutParams);
                            f.itemView.setLayoutParams(layoutParams2);
                        }
                        layoutParams2.f286a = f;
                        if (!z5 || r3 == 0) {
                            z2 = false;
                        }
                        layoutParams2.f289d = z2;
                        return f.itemView;
                    }
                }
                f = svVar;
                z5 = z4;
                f.m3221a(0, 8192);
                if (this.f16518c.f353f.f16539h) {
                    this.f16518c.m450a(f, this.f16518c.f352e.m25829a(this.f16518c.f353f, f, sb.m25827d(f) | 4096, f.m3242p()));
                }
                if (!this.f16518c.f353f.m26201a()) {
                }
                if (f.m3237k()) {
                }
                b2 = this.f16518c.f349b.m25726b(i);
                f.f2674j = this.f16518c;
                this.f16518c.f361p.bindViewHolder(f, b2);
                m26141d(f.itemView);
                if (this.f16518c.f353f.m26201a()) {
                    f.f2669e = i;
                }
                z4 = true;
                layoutParams = f.itemView.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams2 = (RecyclerView.LayoutParams) this.f16518c.generateDefaultLayoutParams();
                    f.itemView.setLayoutParams(layoutParams2);
                } else if (this.f16518c.checkLayoutParams(layoutParams)) {
                    layoutParams2 = (RecyclerView.LayoutParams) layoutParams;
                } else {
                    layoutParams2 = (RecyclerView.LayoutParams) this.f16518c.generateLayoutParams(layoutParams);
                    f.itemView.setLayoutParams(layoutParams2);
                }
                layoutParams2.f286a = f;
                z2 = false;
                layoutParams2.f289d = z2;
                return f.itemView;
            }
        }
        z4 = z3;
        if (svVar == null) {
            b = this.f16518c.f349b.m25726b(i);
            if (b >= 0) {
            }
            throw new IndexOutOfBoundsException("Inconsistency detected. Invalid item position " + i + "(offset:" + b + ")." + "state:" + this.f16518c.f353f.m26205e());
        }
        f = svVar;
        z5 = z4;
        f.m3221a(0, 8192);
        if (this.f16518c.f353f.f16539h) {
            this.f16518c.m450a(f, this.f16518c.f352e.m25829a(this.f16518c.f353f, f, sb.m25827d(f) | 4096, f.m3242p()));
        }
        if (!this.f16518c.f353f.m26201a()) {
        }
        if (f.m3237k()) {
        }
        b2 = this.f16518c.f349b.m25726b(i);
        f.f2674j = this.f16518c;
        this.f16518c.f361p.bindViewHolder(f, b2);
        m26141d(f.itemView);
        if (this.f16518c.f353f.m26201a()) {
            f.f2669e = i;
        }
        z4 = true;
        layoutParams = f.itemView.getLayoutParams();
        if (layoutParams != null) {
            layoutParams2 = (RecyclerView.LayoutParams) this.f16518c.generateDefaultLayoutParams();
            f.itemView.setLayoutParams(layoutParams2);
        } else if (this.f16518c.checkLayoutParams(layoutParams)) {
            layoutParams2 = (RecyclerView.LayoutParams) this.f16518c.generateLayoutParams(layoutParams);
            f.itemView.setLayoutParams(layoutParams2);
        } else {
            layoutParams2 = (RecyclerView.LayoutParams) layoutParams;
        }
        layoutParams2.f286a = f;
        z2 = false;
        layoutParams2.f289d = z2;
        return f.itemView;
    }

    private void m26141d(View view) {
        if (this.f16518c.m548i()) {
            if (ja.m24156e(view) == 0) {
                ja.m24151c(view, 1);
            }
            if (!ja.m24148b(view)) {
                ja.m24139a(view, this.f16518c.ag.m26222b());
            }
        }
    }

    private void m26142f(sv svVar) {
        if (svVar.itemView instanceof ViewGroup) {
            m26140a((ViewGroup) svVar.itemView, false);
        }
    }

    private void m26140a(ViewGroup viewGroup, boolean z) {
        for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = viewGroup.getChildAt(childCount);
            if (childAt instanceof ViewGroup) {
                m26140a((ViewGroup) childAt, true);
            }
        }
        if (!z) {
            return;
        }
        if (viewGroup.getVisibility() == 4) {
            viewGroup.setVisibility(0);
            viewGroup.setVisibility(4);
            return;
        }
        int visibility = viewGroup.getVisibility();
        viewGroup.setVisibility(4);
        viewGroup.setVisibility(visibility);
    }

    public void m26149a(View view) {
        sv b = RecyclerView.m459b(view);
        if (b.m3239m()) {
            this.f16518c.removeDetachedView(view, false);
        }
        if (b.m3230d()) {
            b.m3231e();
        } else if (b.m3232f()) {
            b.m3233g();
        }
        m26159b(b);
    }

    void m26161c() {
        for (int size = this.f16517b.size() - 1; size >= 0; size--) {
            m26166d(size);
        }
        this.f16517b.clear();
    }

    void m26166d(int i) {
        m26164c((sv) this.f16517b.get(i));
        this.f16517b.remove(i);
    }

    public void m26159b(sv svVar) {
        boolean z = true;
        int i = 0;
        if (svVar.m3230d() || svVar.itemView.getParent() != null) {
            StringBuilder append = new StringBuilder().append("Scrapped or attached views may not be recycled. isScrap:").append(svVar.m3230d()).append(" isAttached:");
            if (svVar.itemView.getParent() == null) {
                z = false;
            }
            throw new IllegalArgumentException(append.append(z).toString());
        } else if (svVar.m3239m()) {
            throw new IllegalArgumentException("Tmp detached view should be removed from RecyclerView before it can be recycled: " + svVar);
        } else if (svVar.m3229c()) {
            throw new IllegalArgumentException("Trying to recycle an ignored view holder. You should first call stopIgnoringView(view) before calling recycle.");
        } else {
            int i2;
            boolean c = svVar.m3219w();
            boolean z2 = this.f16518c.f361p != null && c && this.f16518c.f361p.onFailedToRecycleView(svVar);
            if (z2 || svVar.isRecyclable()) {
                if (!svVar.m3226a(14)) {
                    int size = this.f16517b.size();
                    if (size == this.f16521f && size > 0) {
                        m26166d(0);
                    }
                    if (size < this.f16521f) {
                        this.f16517b.add(svVar);
                        z2 = true;
                        if (z2) {
                            m26164c(svVar);
                            i = 1;
                            i2 = z2;
                        } else {
                            z = z2;
                        }
                    }
                }
                z2 = false;
                if (z2) {
                    z = z2;
                } else {
                    m26164c(svVar);
                    i = 1;
                    i2 = z2;
                }
            } else {
                i2 = 0;
            }
            this.f16518c.f351d.m26349e(svVar);
            if (i2 == 0 && r1 == 0 && c) {
                svVar.f2674j = null;
            }
        }
    }

    void m26164c(sv svVar) {
        ja.m24139a(svVar.itemView, null);
        m26170e(svVar);
        svVar.f2674j = null;
        m26171f().m26123a(svVar);
    }

    void m26158b(View view) {
        sv b = RecyclerView.m459b(view);
        b.f2677n = null;
        b.f2678o = false;
        b.m3233g();
        m26159b(b);
    }

    void m26163c(View view) {
        sv b = RecyclerView.m459b(view);
        if (!b.m3226a(12) && b.m3244r() && !this.f16518c.m475c(b)) {
            if (this.f16519d == null) {
                this.f16519d = new ArrayList();
            }
            b.m3224a(this, true);
            this.f16519d.add(b);
        } else if (!b.m3235i() || b.m3238l() || this.f16518c.f361p.hasStableIds()) {
            b.m3224a(this, false);
            this.f16516a.add(b);
        } else {
            throw new IllegalArgumentException("Called scrap view with an invalid view. Invalid views cannot be reused from scrap, they should rebound from recycler pool.");
        }
    }

    public void m26167d(sv svVar) {
        if (svVar.f2678o) {
            this.f16519d.remove(svVar);
        } else {
            this.f16516a.remove(svVar);
        }
        svVar.f2677n = null;
        svVar.f2678o = false;
        svVar.m3233g();
    }

    int m26165d() {
        return this.f16516a.size();
    }

    View m26168e(int i) {
        return ((sv) this.f16516a.get(i)).itemView;
    }

    void m26169e() {
        this.f16516a.clear();
        if (this.f16519d != null) {
            this.f16519d.clear();
        }
    }

    sv m26172f(int i) {
        int i2 = 0;
        if (this.f16519d != null) {
            int size = this.f16519d.size();
            if (size != 0) {
                sv svVar;
                int i3 = 0;
                while (i3 < size) {
                    svVar = (sv) this.f16519d.get(i3);
                    if (svVar.m3232f() || svVar.getLayoutPosition() != i) {
                        i3++;
                    } else {
                        svVar.m3228b(32);
                        return svVar;
                    }
                }
                if (this.f16518c.f361p.hasStableIds()) {
                    int b = this.f16518c.f349b.m25726b(i);
                    if (b > 0 && b < this.f16518c.f361p.getItemCount()) {
                        long itemId = this.f16518c.f361p.getItemId(b);
                        while (i2 < size) {
                            svVar = (sv) this.f16519d.get(i2);
                            if (svVar.m3232f() || svVar.getItemId() != itemId) {
                                i2++;
                            } else {
                                svVar.m3228b(32);
                                return svVar;
                            }
                        }
                    }
                }
                return null;
            }
        }
        return null;
    }

    sv m26144a(int i, int i2, boolean z) {
        int i3 = 0;
        int size = this.f16516a.size();
        int i4 = 0;
        while (i4 < size) {
            View a;
            sv svVar = (sv) this.f16516a.get(i4);
            if (svVar.m3232f() || svVar.getLayoutPosition() != i || svVar.m3235i() || (!this.f16518c.f353f.f16538g && svVar.m3238l())) {
                i4++;
            } else if (i2 == -1 || svVar.getItemViewType() == i2) {
                svVar.m3228b(32);
                return svVar;
            } else {
                Log.e("RecyclerView", "Scrap view for position " + i + " isn't dirty but has" + " wrong view type! (found " + svVar.getItemViewType() + " but expected " + i2 + ")");
                if (!z) {
                    a = this.f16518c.f350c.m25791a(i, i2);
                    if (a != null) {
                        svVar = RecyclerView.m459b(a);
                        this.f16518c.f350c.m25806e(a);
                        i3 = this.f16518c.f350c.m25799b(a);
                        if (i3 != -1) {
                            throw new IllegalStateException("layout index should not be -1 after unhiding a view:" + svVar);
                        }
                        this.f16518c.f350c.m25804d(i3);
                        m26163c(a);
                        svVar.m3228b(8224);
                        return svVar;
                    }
                }
                i4 = this.f16517b.size();
                while (i3 < i4) {
                    svVar = (sv) this.f16517b.get(i3);
                    if (svVar.m3235i() || svVar.getLayoutPosition() != i) {
                        i3++;
                    } else if (z) {
                        return svVar;
                    } else {
                        this.f16517b.remove(i3);
                        return svVar;
                    }
                }
                return null;
            }
        }
        if (z) {
            a = this.f16518c.f350c.m25791a(i, i2);
            if (a != null) {
                svVar = RecyclerView.m459b(a);
                this.f16518c.f350c.m25806e(a);
                i3 = this.f16518c.f350c.m25799b(a);
                if (i3 != -1) {
                    this.f16518c.f350c.m25804d(i3);
                    m26163c(a);
                    svVar.m3228b(8224);
                    return svVar;
                }
                throw new IllegalStateException("layout index should not be -1 after unhiding a view:" + svVar);
            }
        }
        i4 = this.f16517b.size();
        while (i3 < i4) {
            svVar = (sv) this.f16517b.get(i3);
            if (svVar.m3235i()) {
            }
            i3++;
        }
        return null;
    }

    sv m26145a(long j, int i, boolean z) {
        int size;
        for (size = this.f16516a.size() - 1; size >= 0; size--) {
            sv svVar = (sv) this.f16516a.get(size);
            if (svVar.getItemId() == j && !svVar.m3232f()) {
                if (i == svVar.getItemViewType()) {
                    svVar.m3228b(32);
                    if (!svVar.m3238l() || this.f16518c.f353f.m26201a()) {
                        return svVar;
                    }
                    svVar.m3221a(2, 14);
                    return svVar;
                } else if (!z) {
                    this.f16516a.remove(size);
                    this.f16518c.removeDetachedView(svVar.itemView, false);
                    m26158b(svVar.itemView);
                }
            }
        }
        for (size = this.f16517b.size() - 1; size >= 0; size--) {
            svVar = (sv) this.f16517b.get(size);
            if (svVar.getItemId() == j) {
                if (i == svVar.getItemViewType()) {
                    if (z) {
                        return svVar;
                    }
                    this.f16517b.remove(size);
                    return svVar;
                } else if (!z) {
                    m26166d(size);
                }
            }
        }
        return null;
    }

    void m26170e(sv svVar) {
        if (this.f16518c.f363r != null) {
            this.f16518c.f363r.m26177a(svVar);
        }
        if (this.f16518c.f361p != null) {
            this.f16518c.f361p.onViewRecycled(svVar);
        }
        if (this.f16518c.f353f != null) {
            this.f16518c.f351d.m26349e(svVar);
        }
    }

    public void m26150a(rx rxVar, rx rxVar2, boolean z) {
        m26146a();
        m26171f().m26122a(rxVar, rxVar2, z);
    }

    public void m26148a(int i, int i2) {
        int i3;
        int i4;
        int i5;
        if (i < i2) {
            i3 = -1;
            i4 = i2;
            i5 = i;
        } else {
            i3 = 1;
            i4 = i;
            i5 = i2;
        }
        int size = this.f16517b.size();
        for (int i6 = 0; i6 < size; i6++) {
            sv svVar = (sv) this.f16517b.get(i6);
            if (svVar != null && svVar.f2665a >= r3 && svVar.f2665a <= r2) {
                if (svVar.f2665a == i) {
                    svVar.m3223a(i2 - i, false);
                } else {
                    svVar.m3223a(i3, false);
                }
            }
        }
    }

    public void m26156b(int i, int i2) {
        int size = this.f16517b.size();
        for (int i3 = 0; i3 < size; i3++) {
            sv svVar = (sv) this.f16517b.get(i3);
            if (svVar != null && svVar.getLayoutPosition() >= i) {
                svVar.m3223a(i2, true);
            }
        }
    }

    public void m26157b(int i, int i2, boolean z) {
        int i3 = i + i2;
        for (int size = this.f16517b.size() - 1; size >= 0; size--) {
            sv svVar = (sv) this.f16517b.get(size);
            if (svVar != null) {
                if (svVar.getLayoutPosition() >= i3) {
                    svVar.m3223a(-i2, z);
                } else if (svVar.getLayoutPosition() >= i) {
                    svVar.m3228b(8);
                    m26166d(size);
                }
            }
        }
    }

    public void m26152a(st stVar) {
        this.f16523h = stVar;
    }

    public void m26151a(sl slVar) {
        if (this.f16522g != null) {
            this.f16522g.m26124b();
        }
        this.f16522g = slVar;
        if (slVar != null) {
            this.f16522g.m26121a(this.f16518c.getAdapter());
        }
    }

    public sl m26171f() {
        if (this.f16522g == null) {
            this.f16522g = new sl();
        }
        return this.f16522g;
    }

    public void m26162c(int i, int i2) {
        int i3 = i + i2;
        for (int size = this.f16517b.size() - 1; size >= 0; size--) {
            sv svVar = (sv) this.f16517b.get(size);
            if (svVar != null) {
                int layoutPosition = svVar.getLayoutPosition();
                if (layoutPosition >= i && layoutPosition < i3) {
                    svVar.m3228b(2);
                    m26166d(size);
                }
            }
        }
    }

    public void m26173g() {
        int size = this.f16517b.size();
        for (int i = 0; i < size; i++) {
            sv svVar = (sv) this.f16517b.get(i);
            if (svVar != null) {
                svVar.m3228b((int) C0277j.f3696g);
            }
        }
    }

    public void m26174h() {
        if (this.f16518c.f361p == null || !this.f16518c.f361p.hasStableIds()) {
            m26161c();
            return;
        }
        int size = this.f16517b.size();
        for (int i = 0; i < size; i++) {
            sv svVar = (sv) this.f16517b.get(i);
            if (svVar != null) {
                svVar.m3228b(6);
                svVar.m3225a(null);
            }
        }
    }

    public void m26175i() {
        int i;
        int i2 = 0;
        int size = this.f16517b.size();
        for (i = 0; i < size; i++) {
            ((sv) this.f16517b.get(i)).m3220a();
        }
        size = this.f16516a.size();
        for (i = 0; i < size; i++) {
            ((sv) this.f16516a.get(i)).m3220a();
        }
        if (this.f16519d != null) {
            i = this.f16519d.size();
            while (i2 < i) {
                ((sv) this.f16519d.get(i2)).m3220a();
                i2++;
            }
        }
    }

    public void m26176j() {
        int size = this.f16517b.size();
        for (int i = 0; i < size; i++) {
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) ((sv) this.f16517b.get(i)).itemView.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.f288c = true;
            }
        }
    }
}
