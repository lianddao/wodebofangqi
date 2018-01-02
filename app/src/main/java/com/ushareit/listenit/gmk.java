package com.ushareit.listenit;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.ushareit.listenit.widget.LoadMoreListView;

public class gmk extends fji {
    hby f14413a = new gmo(this);
    private fea f14414b;
    private LoadMoreListView f14415c;
    private View f14416d;
    private View f14417e;
    private long f14418f = 0;

    public View mo2388a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(m1326l()).inflate(C0349R.layout.nearby_fragment, null);
        m22445a(inflate);
        m22450U();
        return inflate;
    }

    private void m22445a(View view) {
        int dimension = (int) m1329n().getDimension(C0349R.dimen.common_dimens_50dp);
        if (gyn.m23217b()) {
            view.setPadding(0, dimension + fbb.m18766e(m1326l()), 0, 0);
        } else {
            view.setPadding(0, dimension, 0, 0);
        }
        this.f14415c = (LoadMoreListView) view.findViewById(C0349R.id.nearby_loadmore_lv);
        this.f14414b = new fea(m1328m());
        this.f14415c.setAdapter(this.f14414b);
        this.f14416d = view.findViewById(C0349R.id.progress_view);
        this.f14417e = view.findViewById(C0349R.id.nearby_no_people_area);
        this.f14415c.setOnLoadMoreListener(this.f14413a);
    }

    public void m22450U() {
        glp.m22391c(new gml(this));
    }

    public void m22451V() {
        glp.m22383a(new gmm(this, System.currentTimeMillis()));
        fir.m19398g();
    }

    private void m22443W() {
        this.f14416d.setVisibility(8);
    }

    public boolean mo2549b() {
        return false;
    }

    public void mo203z() {
        if (this.f14418f > 0) {
            fir.m19385c(System.currentTimeMillis() - this.f14418f);
        } else {
            fir.m19406j();
        }
        m22443W();
        super.mo203z();
    }
}
