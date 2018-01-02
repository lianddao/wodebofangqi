package com.ushareit.listenit;

import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import com.ushareit.listenit.about.AboutActivity;

public class fdb implements OnChildClickListener {
    final /* synthetic */ AboutActivity f12453a;

    public fdb(AboutActivity aboutActivity) {
        this.f12453a = aboutActivity;
    }

    public boolean onChildClick(ExpandableListView expandableListView, View view, int i, int i2, long j) {
        if (((fdf) this.f12453a.f4056q.get(i)).f12459c != null) {
            this.f12453a.m5110a((fde) ((fdf) this.f12453a.f4056q.get(i)).f12459c.get(i2));
        }
        return true;
    }
}
