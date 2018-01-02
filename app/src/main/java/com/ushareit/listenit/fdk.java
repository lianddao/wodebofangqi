package com.ushareit.listenit;

import android.view.View;
import android.view.View.OnClickListener;

class fdk implements OnClickListener {
    final /* synthetic */ hbh f12470a;
    final /* synthetic */ gjc f12471b;
    final /* synthetic */ fdj f12472c;

    fdk(fdj com_ushareit_listenit_fdj, hbh com_ushareit_listenit_hbh, gjc com_ushareit_listenit_gjc) {
        this.f12472c = com_ushareit_listenit_fdj;
        this.f12470a = com_ushareit_listenit_hbh;
        this.f12471b = com_ushareit_listenit_gjc;
    }

    public void onClick(View view) {
        if (this.f12472c.f12469c != null) {
            this.f12472c.f12469c.onItemClick(null, this.f12470a.itemView, this.f12470a.getAdapterPosition(), (long) this.f12471b.m20765b());
        }
    }
}
