package com.ushareit.listenit;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.Checkable;
import android.widget.ListAdapter;
import com.ushareit.listenit.widget.dragsortlistview.DragSortItemView;
import com.ushareit.listenit.widget.dragsortlistview.DragSortItemViewCheckable;
import com.ushareit.listenit.widget.dragsortlistview.DragSortListView;

public class hel extends BaseAdapter {
    final /* synthetic */ DragSortListView f15280a;
    private ListAdapter f15281b;

    public hel(DragSortListView dragSortListView, ListAdapter listAdapter) {
        this.f15280a = dragSortListView;
        this.f15281b = listAdapter;
        this.f15281b.registerDataSetObserver(new hem(this, dragSortListView));
    }

    public ListAdapter m23628a() {
        return this.f15281b;
    }

    public long getItemId(int i) {
        return this.f15281b.getItemId(i);
    }

    public Object getItem(int i) {
        return this.f15281b.getItem(i);
    }

    public int getCount() {
        return this.f15281b.getCount();
    }

    public boolean areAllItemsEnabled() {
        return this.f15281b.areAllItemsEnabled();
    }

    public boolean isEnabled(int i) {
        return this.f15281b.isEnabled(i);
    }

    public int getItemViewType(int i) {
        return this.f15281b.getItemViewType(i);
    }

    public int getViewTypeCount() {
        return this.f15281b.getViewTypeCount();
    }

    public boolean hasStableIds() {
        return this.f15281b.hasStableIds();
    }

    public boolean isEmpty() {
        return this.f15281b.isEmpty();
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        View childAt;
        View view2;
        if (view != null) {
            view = (DragSortItemView) view;
            childAt = view.getChildAt(0);
            view2 = this.f15281b.getView(i, childAt, this.f15280a);
            if (view2 != childAt) {
                if (childAt != null) {
                    view.removeViewAt(0);
                }
                view.addView(view2);
            }
        } else {
            view2 = this.f15281b.getView(i, null, this.f15280a);
            if (view2 instanceof Checkable) {
                childAt = new DragSortItemViewCheckable(this.f15280a.getContext());
            } else {
                childAt = new DragSortItemView(this.f15280a.getContext());
            }
            childAt.setLayoutParams(new LayoutParams(-1, -2));
            childAt.addView(view2);
            view = childAt;
        }
        this.f15280a.m27031a(this.f15280a.getHeaderViewsCount() + i, view, true);
        return view;
    }
}
