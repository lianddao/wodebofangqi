package com.ushareit.listenit;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;
import java.util.List;

public abstract class rx<VH extends sv> {
    private final ry f2654a = new ry();
    private boolean f2655b = false;

    public abstract int getItemCount();

    public abstract void onBindViewHolder(VH vh, int i);

    public abstract VH onCreateViewHolder(ViewGroup viewGroup, int i);

    public void onBindViewHolder(VH vh, int i, List<Object> list) {
        onBindViewHolder(vh, i);
    }

    public final VH createViewHolder(ViewGroup viewGroup, int i) {
        fj.m19509a("RV CreateView");
        VH onCreateViewHolder = onCreateViewHolder(viewGroup, i);
        onCreateViewHolder.f2668d = i;
        fj.m19508a();
        return onCreateViewHolder;
    }

    public final void bindViewHolder(VH vh, int i) {
        vh.f2665a = i;
        if (hasStableIds()) {
            vh.f2667c = getItemId(i);
        }
        vh.m3221a(1, 519);
        fj.m19509a("RV OnBindView");
        onBindViewHolder(vh, i, vh.m3242p());
        vh.m3241o();
        fj.m19508a();
    }

    public int getItemViewType(int i) {
        return 0;
    }

    public void setHasStableIds(boolean z) {
        if (hasObservers()) {
            throw new IllegalStateException("Cannot change whether this adapter has stable IDs while the adapter has registered observers.");
        }
        this.f2655b = z;
    }

    public long getItemId(int i) {
        return -1;
    }

    public final boolean hasStableIds() {
        return this.f2655b;
    }

    public void onViewRecycled(VH vh) {
    }

    public boolean onFailedToRecycleView(VH vh) {
        return false;
    }

    public void onViewAttachedToWindow(VH vh) {
    }

    public void onViewDetachedFromWindow(VH vh) {
    }

    public final boolean hasObservers() {
        return this.f2654a.m26028a();
    }

    public void registerAdapterDataObserver(rz rzVar) {
        this.f2654a.registerObserver(rzVar);
    }

    public void unregisterAdapterDataObserver(rz rzVar) {
        this.f2654a.unregisterObserver(rzVar);
    }

    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
    }

    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
    }

    public final void notifyDataSetChanged() {
        this.f2654a.m26029b();
    }

    public final void notifyItemChanged(int i) {
        this.f2654a.m26026a(i, 1);
    }

    public final void notifyItemChanged(int i, Object obj) {
        this.f2654a.m26027a(i, 1, obj);
    }

    public final void notifyItemRangeChanged(int i, int i2) {
        this.f2654a.m26026a(i, i2);
    }

    public final void notifyItemRangeChanged(int i, int i2, Object obj) {
        this.f2654a.m26027a(i, i2, obj);
    }

    public final void notifyItemInserted(int i) {
        this.f2654a.m26030b(i, 1);
    }

    public final void notifyItemMoved(int i, int i2) {
        this.f2654a.m26032d(i, i2);
    }

    public final void notifyItemRangeInserted(int i, int i2) {
        this.f2654a.m26030b(i, i2);
    }

    public final void notifyItemRemoved(int i) {
        this.f2654a.m26031c(i, 1);
    }

    public final void notifyItemRangeRemoved(int i, int i2) {
        this.f2654a.m26031c(i, i2);
    }
}
