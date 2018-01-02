package com.ushareit.listenit;

import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnGroupClickListener;
import com.ushareit.listenit.about.AboutActivity;

public class fda implements OnGroupClickListener {
    final /* synthetic */ AboutActivity f12452a;

    public fda(AboutActivity aboutActivity) {
        this.f12452a = aboutActivity;
    }

    public boolean onGroupClick(ExpandableListView expandableListView, View view, int i, long j) {
        if (!((fdf) this.f12452a.f4056q.get(i)).f12458b) {
            this.f12452a.m5116e(i);
        } else if (this.f12452a.f4057r == i) {
            this.f12452a.f4054o.collapseGroup(i);
            this.f12452a.f4057r = -1;
        } else {
            this.f12452a.f4054o.expandGroup(i);
            this.f12452a.f4057r = i;
        }
        return true;
    }
}
