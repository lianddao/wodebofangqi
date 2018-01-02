package com.ushareit.listenit;

import android.support.v7.widget.RecyclerView;

public class ru implements tk {
    final /* synthetic */ RecyclerView f16434a;

    public ru(RecyclerView recyclerView) {
        this.f16434a = recyclerView;
    }

    public void mo3040a(sv svVar, se seVar, se seVar2) {
        this.f16434a.f348a.m26167d(svVar);
        this.f16434a.m465b(svVar, seVar, seVar2);
    }

    public void mo3041b(sv svVar, se seVar, se seVar2) {
        this.f16434a.m451a(svVar, seVar, seVar2);
    }

    public void mo3042c(sv svVar, se seVar, se seVar2) {
        svVar.setIsRecyclable(false);
        if (this.f16434a.f332H) {
            if (this.f16434a.f352e.mo3017a(svVar, svVar, seVar, seVar2)) {
                this.f16434a.m437C();
            }
        } else if (this.f16434a.f352e.mo3019c(svVar, seVar, seVar2)) {
            this.f16434a.m437C();
        }
    }

    public void mo3039a(sv svVar) {
        this.f16434a.f362q.m245a(svVar.itemView, this.f16434a.f348a);
    }
}
