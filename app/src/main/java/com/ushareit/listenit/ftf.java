package com.ushareit.listenit;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.mopub.volley.DefaultRetryPolicy;

class ftf implements OnTouchListener {
    final /* synthetic */ ftc f13460a;

    ftf(ftc com_ushareit_listenit_ftc) {
        this.f13460a = com_ushareit_listenit_ftc;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                erj.m17570a(this.f13460a.f13452u, 0.6f);
                break;
            case 1:
            case 3:
                erj.m17570a(this.f13460a.f13452u, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
                break;
        }
        return false;
    }
}
