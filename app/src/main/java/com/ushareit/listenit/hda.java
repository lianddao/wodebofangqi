package com.ushareit.listenit;

import android.view.ViewGroup;
import android.widget.ImageView;
import com.ushareit.listenit.widget.NormalPlayerView;

public class hda implements hbv {
    final /* synthetic */ NormalPlayerView f15199a;

    public hda(NormalPlayerView normalPlayerView) {
        this.f15199a = normalPlayerView;
    }

    public void mo2745a(Boolean bool) {
    }

    public void mo2747b(Boolean bool) {
        if (this.f15199a.f17294D != null) {
            gla v = bool == null ? this.f15199a.f17294D.mo2465v() : bool.booleanValue() ? this.f15199a.f17294D.mo2467x() : this.f15199a.f17294D.mo2466w();
            if (v != null) {
                ImageView imageView = (ImageView) ((ViewGroup) this.f15199a.f17293C.getNextView()).getChildAt(0);
                fzi.m21402a(this.f15199a.getContext(), v, imageView, tv.HIGH, imageView.getWidth() != 0 ? imageView.getWidth() : 480, (fzv) new hdb(this, System.currentTimeMillis(), imageView, v));
            }
        }
    }

    public void mo2748c(Boolean bool) {
        this.f15199a.m26904a(bool);
    }

    public void mo2746a(boolean z, boolean z2, boolean z3) {
        boolean z4 = true;
        if (z && z2) {
            if (this.f15199a.f17294D != null) {
                if (z3) {
                    if (this.f15199a.f17294D.mo2467x() != null) {
                        this.f15199a.f17299I = this.f15199a.f17294D.mo2467x().f14334b;
                    }
                } else if (this.f15199a.f17294D.mo2466w() != null) {
                    this.f15199a.f17299I = this.f15199a.f17294D.mo2466w().f14334b;
                }
            }
            if (z3) {
                boolean z5;
                ffh k = this.f15199a.f17316c;
                if (this.f15199a.f17293C.getDisplayedChild() != 0) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                k.m19096a(z5);
                gyp.m23291e();
                fit.m19431a("normalplayer", "next");
            } else {
                gyp.m23279a(false);
                fit.m19431a("normalplayer", "prev");
            }
        }
        ffh k2 = this.f15199a.f17316c;
        if (this.f15199a.f17293C.getDisplayedChild() != 0) {
            z4 = false;
        }
        k2.m19097b(z4);
    }
}
