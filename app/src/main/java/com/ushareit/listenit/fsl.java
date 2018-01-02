package com.ushareit.listenit;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.mopub.volley.DefaultRetryPolicy;

class fsl implements OnTouchListener {
    final /* synthetic */ fsj f13386a;

    fsl(fsj com_ushareit_listenit_fsj) {
        this.f13386a = com_ushareit_listenit_fsj;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                erj.m17570a(this.f13386a.f13379s, 0.6f);
                erj.m17570a(this.f13386a.f13380t, 0.6f);
                break;
            case 1:
            case 3:
                erj.m17570a(this.f13386a.f13379s, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
                erj.m17570a(this.f13386a.f13380t, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
                break;
        }
        return false;
    }
}
