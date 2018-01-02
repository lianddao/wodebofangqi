package com.ushareit.listenit;

import android.annotation.TargetApi;
import android.os.Handler;
import android.view.View;
import com.facebook.ads.internal.view.C0052n;
import com.mopub.volley.DefaultRetryPolicy;

@TargetApi(12)
public class awx implements axy {
    private final Handler f5596a;
    private View f5597b;
    private axg f5598c;
    private C0052n f5599d;
    private final avy f5600e = new awy(this);
    private final awa f5601f = new awz(this);
    private final avs f5602g = new axb(this);
    private final apo<awi> f5603h = new axc(this);

    public awx(View view, axg com_ushareit_listenit_axg) {
        this.f5597b = view;
        this.f5598c = com_ushareit_listenit_axg;
        this.f5596a = new Handler();
        this.f5597b.clearAnimation();
        if (com_ushareit_listenit_axg == axg.INVSIBLE) {
            this.f5597b.setAlpha(0.0f);
            this.f5597b.setVisibility(8);
            return;
        }
        this.f5597b.setAlpha(DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
        this.f5597b.setVisibility(0);
    }

    public void m7275a(View view, axg com_ushareit_listenit_axg) {
        this.f5597b = view;
        this.f5598c = com_ushareit_listenit_axg;
        this.f5597b.clearAnimation();
        if (com_ushareit_listenit_axg == axg.INVSIBLE) {
            this.f5597b.setAlpha(0.0f);
            this.f5597b.setVisibility(8);
            return;
        }
        this.f5597b.setAlpha(DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
        this.f5597b.setVisibility(0);
    }

    public void mo107a(C0052n c0052n) {
        c0052n.getEventBus().m6617a(this.f5600e);
        c0052n.getEventBus().m6617a(this.f5601f);
        c0052n.getEventBus().m6617a(this.f5603h);
        c0052n.getEventBus().m6617a(this.f5602g);
        this.f5599d = c0052n;
    }
}
