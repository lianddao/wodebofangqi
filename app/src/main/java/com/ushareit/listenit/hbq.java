package com.ushareit.listenit;

import android.os.Handler;
import android.os.Message;
import com.mopub.volley.DefaultRetryPolicy;

class hbq extends Handler {
    final /* synthetic */ hbp f15157a;

    hbq(hbp com_ushareit_listenit_hbp) {
        this.f15157a = com_ushareit_listenit_hbp;
    }

    public void handleMessage(Message message) {
        super.handleMessage(message);
        switch (this.f15157a.f15143g) {
            case 1:
                this.f15157a.f15142f = (float) (((double) this.f15157a.f15142f) + (((double) (DefaultRetryPolicy.DEFAULT_BACKOFF_MULT - this.f15157a.f15142f)) * 0.2d));
                if (((double) this.f15157a.f15142f) > 0.9d) {
                    this.f15157a.f15142f = DefaultRetryPolicy.DEFAULT_BACKOFF_MULT;
                    this.f15157a.m23527a(2);
                }
                this.f15157a.f15148l.invalidate();
                this.f15157a.m23528a(10);
                return;
            case 2:
                this.f15157a.m23527a(3);
                return;
            case 3:
                this.f15157a.f15142f = (float) (((double) this.f15157a.f15142f) - (((double) this.f15157a.f15142f) * 0.2d));
                if (((double) this.f15157a.f15142f) < 0.1d) {
                    this.f15157a.f15142f = 0.0f;
                    this.f15157a.m23527a(0);
                }
                this.f15157a.f15148l.invalidate();
                this.f15157a.m23528a(10);
                return;
            default:
                return;
        }
    }
}
