package com.ushareit.listenit;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;

public class fru extends fji {
    private RecyclerView f13313a;
    private fsa f13314b;
    private TextView f13315c;
    private SwipeRefreshLayout f13316d;
    private View f13317e;
    private boolean f13318f = false;
    private OnClickListener f13319g = new frx(this);
    private qa f13320h = new fry(this);
    private sk f13321i = new frz(this);

    public View mo2388a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View inflate = layoutInflater.inflate(C0349R.layout.discovery_fragment, viewGroup, false);
        this.f13316d = (SwipeRefreshLayout) inflate.findViewById(C0349R.id.pull_to_refresh_layout);
        this.f13316d.setOnRefreshListener(this.f13320h);
        this.f13316d.setColorSchemeColors(gzd.m23358b());
        hhf.m23856a(new frv(this));
        this.f13317e = inflate.findViewById(C0349R.id.progress_view);
        this.f13315c = (TextView) inflate.findViewById(C0349R.id.no_result);
        this.f13315c.setOnClickListener(this.f13319g);
        this.f13313a = (RecyclerView) inflate.findViewById(C0349R.id.recycler_view);
        this.f13313a.setLayoutManager(new LinearLayoutManager(m1326l()));
        this.f13314b = new fsa(m1326l());
        this.f13313a.setAdapter(this.f13314b);
        this.f13313a.m520a(this.f13321i);
        return inflate;
    }

    public void m20744b(boolean z) {
        boolean z2 = true;
        if (z || !this.f13318f) {
            this.f13318f = true;
            if (this.f13314b.getItemCount() <= 0) {
                z2 = false;
            }
            frj.m20711a(z2, new frw(this));
        }
    }

    public boolean mo2549b() {
        return false;
    }
}
