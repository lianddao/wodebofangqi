package com.ushareit.listenit;

import android.util.SparseIntArray;
import com.ushareit.listenit.widget.dragsortlistview.DragSortListView;
import java.util.ArrayList;

public class hev {
    final /* synthetic */ DragSortListView f15314a;
    private SparseIntArray f15315b;
    private ArrayList<Integer> f15316c;
    private int f15317d;

    public hev(DragSortListView dragSortListView, int i) {
        this.f15314a = dragSortListView;
        this.f15315b = new SparseIntArray(i);
        this.f15316c = new ArrayList(i);
        this.f15317d = i;
    }

    public void m23651a(int i, int i2) {
        int i3 = this.f15315b.get(i, -1);
        if (i3 != i2) {
            if (i3 != -1) {
                this.f15316c.remove(Integer.valueOf(i));
            } else if (this.f15315b.size() == this.f15317d) {
                this.f15315b.delete(((Integer) this.f15316c.remove(0)).intValue());
            }
            this.f15315b.put(i, i2);
            this.f15316c.add(Integer.valueOf(i));
        }
    }

    public int m23649a(int i) {
        return this.f15315b.get(i, -1);
    }

    public void m23650a() {
        this.f15315b.clear();
        this.f15316c.clear();
    }
}
