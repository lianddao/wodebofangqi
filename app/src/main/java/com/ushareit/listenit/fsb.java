package com.ushareit.listenit;

import android.view.View;
import android.view.View.OnClickListener;

class fsb implements OnClickListener {
    final /* synthetic */ hbh f13334a;
    final /* synthetic */ fsc f13335b;
    final /* synthetic */ fsa f13336c;

    fsb(fsa com_ushareit_listenit_fsa, hbh com_ushareit_listenit_hbh, fsc com_ushareit_listenit_fsc) {
        this.f13336c = com_ushareit_listenit_fsa;
        this.f13334a = com_ushareit_listenit_hbh;
        this.f13335b = com_ushareit_listenit_fsc;
    }

    public void onClick(View view) {
        if (this.f13336c.f13332c != null) {
            this.f13336c.f13332c.onItemClick(null, this.f13334a.itemView, this.f13334a.getAdapterPosition(), (long) this.f13335b.m20765b());
        }
    }
}
