package com.ushareit.listenit;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.mopub.volley.DefaultRetryPolicy;

class fsm implements OnTouchListener {
    final /* synthetic */ fsj f13387a;

    fsm(fsj com_ushareit_listenit_fsj) {
        this.f13387a = com_ushareit_listenit_fsj;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                erj.m17570a(this.f13387a.f13381u, 0.6f);
                break;
            case 1:
            case 3:
                erj.m17570a(this.f13387a.f13381u, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
                break;
        }
        return false;
    }
}
