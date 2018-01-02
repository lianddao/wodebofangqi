package com.ushareit.listenit;

import com.ushareit.listenit.widget.MiniPlayerView;

public class hci implements hbv {
    final /* synthetic */ MiniPlayerView f15179a;

    public hci(MiniPlayerView miniPlayerView) {
        this.f15179a = miniPlayerView;
    }

    public void mo2745a(Boolean bool) {
    }

    public void mo2747b(Boolean bool) {
        if (this.f15179a.f17275f != null) {
            glg v = bool == null ? this.f15179a.f17275f.mo2465v() : bool.booleanValue() ? this.f15179a.f17275f.mo2467x() : this.f15179a.f17275f.mo2466w();
            if (v != null) {
                this.f15179a.m26874a(this.f15179a.f17277h.getNextView(), v, false);
            }
        }
    }

    public void mo2748c(Boolean bool) {
    }

    public void mo2746a(boolean z, boolean z2, boolean z3) {
        if (z && z2) {
            if (this.f15179a.f17275f != null) {
                if (z3) {
                    if (this.f15179a.f17275f.mo2467x() != null) {
                        this.f15179a.f17278i = this.f15179a.f17275f.mo2467x().f14334b;
                    }
                } else if (this.f15179a.f17275f.mo2466w() != null) {
                    this.f15179a.f17278i = this.f15179a.f17275f.mo2466w().f14334b;
                }
            }
            if (z3) {
                gyp.m23291e();
                fii.m19311c(this.f15179a.getContext(), "miniplayer");
                fit.m19435c(this.f15179a.getContext(), "next");
                fit.m19431a("miniplayer", "next");
            } else {
                gyp.m23279a(gvj.aj(this.f15179a.getContext()));
                fii.m19311c(this.f15179a.getContext(), "miniplayer");
                fit.m19435c(this.f15179a.getContext(), "prev");
                fit.m19431a("miniplayer", "prev");
            }
            gvj.m22900a(this.f15179a.getContext(), true);
        } else if (this.f15179a.f17275f != null) {
            this.f15179a.m26879c(this.f15179a.f17275f.mo2425a());
        }
    }
}
