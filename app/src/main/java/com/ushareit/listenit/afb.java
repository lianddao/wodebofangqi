package com.ushareit.listenit;

import android.widget.ImageView;
import com.mopub.volley.DefaultRetryPolicy;

public class afb extends afc<abo> {
    private int f4255b;
    private abo f4256c;

    public afb(ImageView imageView) {
        this(imageView, -1);
    }

    public afb(ImageView imageView, int i) {
        super(imageView);
        this.f4255b = i;
    }

    public void m5446a(abo com_ushareit_listenit_abo, aeq<? super abo> com_ushareit_listenit_aeq__super_com_ushareit_listenit_abo) {
        Object com_ushareit_listenit_afg;
        if (!com_ushareit_listenit_abo.mo568a()) {
            float intrinsicWidth = ((float) com_ushareit_listenit_abo.getIntrinsicWidth()) / ((float) com_ushareit_listenit_abo.getIntrinsicHeight());
            if (Math.abs((((float) ((ImageView) this.a).getWidth()) / ((float) ((ImageView) this.a).getHeight())) - DefaultRetryPolicy.DEFAULT_BACKOFF_MULT) <= 0.05f && Math.abs(intrinsicWidth - DefaultRetryPolicy.DEFAULT_BACKOFF_MULT) <= 0.05f) {
                com_ushareit_listenit_afg = new afg(com_ushareit_listenit_abo, ((ImageView) this.a).getWidth());
            }
        }
        super.mo582a(com_ushareit_listenit_afg, (aeq) com_ushareit_listenit_aeq__super_com_ushareit_listenit_abo);
        this.f4256c = com_ushareit_listenit_afg;
        com_ushareit_listenit_afg.mo567a(this.f4255b);
        com_ushareit_listenit_afg.start();
    }

    protected void m5445a(abo com_ushareit_listenit_abo) {
        ((ImageView) this.a).setImageDrawable(com_ushareit_listenit_abo);
    }

    public void mo578d() {
        if (this.f4256c != null) {
            this.f4256c.start();
        }
    }

    public void mo579e() {
        if (this.f4256c != null) {
            this.f4256c.stop();
        }
    }
}
