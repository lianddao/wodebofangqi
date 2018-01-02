package com.ushareit.listenit;

import android.database.DataSetObserver;
import com.ushareit.listenit.widget.dragsortlistview.DragSortListView;

class hem extends DataSetObserver {
    final /* synthetic */ DragSortListView f15282a;
    final /* synthetic */ hel f15283b;

    hem(hel com_ushareit_listenit_hel, DragSortListView dragSortListView) {
        this.f15283b = com_ushareit_listenit_hel;
        this.f15282a = dragSortListView;
    }

    public void onChanged() {
        this.f15283b.notifyDataSetChanged();
    }

    public void onInvalidated() {
        this.f15283b.notifyDataSetInvalidated();
    }
}
