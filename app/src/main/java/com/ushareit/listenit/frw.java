package com.ushareit.listenit;

import java.util.List;

class frw implements frt {
    final /* synthetic */ fru f13323a;

    frw(fru com_ushareit_listenit_fru) {
        this.f13323a = com_ushareit_listenit_fru;
    }

    public void mo2552a(List<fsc> list) {
        this.f13323a.f13314b.m20764a((List) list);
        this.f13323a.f13317e.setVisibility(8);
        this.f13323a.f13316d.setRefreshing(false);
        if (list.size() > 0) {
            fij.m19330c();
        }
    }

    public void mo2551a() {
        if (this.f13323a.f13314b.getItemCount() == 0) {
            this.f13323a.f13315c.setVisibility(0);
            this.f13323a.f13313a.setVisibility(4);
        } else {
            this.f13323a.f13314b.notifyDataSetChanged();
        }
        this.f13323a.f13317e.setVisibility(8);
        this.f13323a.f13316d.setRefreshing(false);
    }
}
