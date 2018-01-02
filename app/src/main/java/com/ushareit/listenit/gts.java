package com.ushareit.listenit;

import android.widget.ImageView;
import java.util.List;

class gts extends hhw {
    final /* synthetic */ String f14717a;
    final /* synthetic */ gta f14718b;

    gts(gta com_ushareit_listenit_gta, String str) {
        this.f14718b = com_ushareit_listenit_gta;
        this.f14717a = str;
    }

    public void execute() {
        this.f14718b.at.clear();
        if (!fbb.m18763c(this.f14717a) && this.f14718b.aE != null && this.f14718b.aE.equals(this.f14717a)) {
            this.f14718b.at.put(0, this.f14718b.f14692b.m22731a(0, this.f14717a));
            this.f14718b.at.put(1, this.f14718b.f14692b.m22731a(1, this.f14717a));
            this.f14718b.at.put(2, this.f14718b.f14692b.m22731a(2, this.f14717a));
            this.f14718b.at.put(3, this.f14718b.f14692b.m22731a(3, this.f14717a));
        }
    }

    public void callback() {
        int i = 0;
        if (this.f14718b.aE != null && this.f14718b.aE.equals(this.f14717a)) {
            this.f14718b.f14696f.m22698b();
            this.f14718b.f14696f.m22695a(0, (List) this.f14718b.at.get(0));
            if (this.f14718b.az) {
                this.f14718b.f14696f.m22694a();
            }
            this.f14718b.f14696f.m22695a(1, (List) this.f14718b.at.get(1));
            this.f14718b.f14696f.m22695a(2, (List) this.f14718b.at.get(2));
            this.f14718b.f14696f.m22695a(3, (List) this.f14718b.at.get(3));
            this.f14718b.f14696f.notifyDataSetChanged();
            if (this.f14718b.f14696f.m22701c() > 0) {
                this.f14718b.ar.setVisibility(8);
                this.f14718b.al.setVisibility(8);
                this.f14718b.f14693c.setVisibility(0);
                for (int i2 = 0; i2 < this.f14718b.f14696f.getGroupCount(); i2++) {
                    this.f14718b.f14693c.expandGroup(i2);
                }
            } else {
                this.f14718b.f14693c.setVisibility(8);
                if (fbb.m18763c(this.f14717a)) {
                    this.f14718b.ar.setVisibility(0);
                    this.f14718b.al.setVisibility(8);
                } else {
                    this.f14718b.ar.setVisibility(8);
                    this.f14718b.al.setVisibility(0);
                }
            }
            ImageView k = this.f14718b.aq;
            if (fbb.m18763c(this.f14717a)) {
                i = 8;
            }
            k.setVisibility(i);
        }
    }
}
