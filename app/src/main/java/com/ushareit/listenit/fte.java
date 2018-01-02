package com.ushareit.listenit;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.mopub.volley.DefaultRetryPolicy;

class fte implements OnTouchListener {
    final /* synthetic */ ftc f13459a;

    fte(ftc com_ushareit_listenit_ftc) {
        this.f13459a = com_ushareit_listenit_ftc;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                erj.m17570a(this.f13459a.f13450s, 0.6f);
                erj.m17570a(this.f13459a.f13451t, 0.6f);
                break;
            case 1:
            case 3:
                erj.m17570a(this.f13459a.f13450s, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
                erj.m17570a(this.f13459a.f13451t, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
                break;
        }
        return false;
    }
}
