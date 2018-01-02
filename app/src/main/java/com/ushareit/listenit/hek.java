package com.ushareit.listenit;

import android.database.DataSetObserver;
import com.ushareit.listenit.widget.dragsortlistview.DragSortListView;

public class hek extends DataSetObserver {
    final /* synthetic */ DragSortListView f15279a;

    public hek(DragSortListView dragSortListView) {
        this.f15279a = dragSortListView;
    }

    private void m23627a() {
        if (this.f15279a.f17468v == 4) {
            this.f15279a.m27085a();
        }
    }

    public void onChanged() {
        m23627a();
    }

    public void onInvalidated() {
        m23627a();
    }
}
