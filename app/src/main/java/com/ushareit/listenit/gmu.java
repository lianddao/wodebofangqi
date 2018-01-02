package com.ushareit.listenit;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.mopub.volley.DefaultRetryPolicy;
import com.ushareit.listenit.nearby.view.SongMenuActivity;

public class gmu implements OnTouchListener {
    final /* synthetic */ SongMenuActivity f14430a;

    public gmu(SongMenuActivity songMenuActivity) {
        this.f14430a = songMenuActivity;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                erj.m17570a(this.f14430a.f16002D, 0.4f);
                break;
            case 1:
            case 3:
                erj.m17570a(this.f14430a.f16002D, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
                break;
        }
        return false;
    }
}
