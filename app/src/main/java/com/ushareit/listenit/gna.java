package com.ushareit.listenit;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.mopub.volley.DefaultRetryPolicy;
import com.ushareit.listenit.nearby.widget.NoLoginUserView;

public class gna implements OnTouchListener {
    final /* synthetic */ NoLoginUserView f14437a;

    public gna(NoLoginUserView noLoginUserView) {
        this.f14437a = noLoginUserView;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            erj.m17570a(this.f14437a, 0.5f);
        } else if (motionEvent.getAction() == 1) {
            erj.m17570a(this.f14437a, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
        }
        return false;
    }
}
