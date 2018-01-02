package com.ushareit.listenit;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.mopub.mobileads.BaseHtmlWebView;

public class eih implements OnTouchListener {
    final /* synthetic */ boolean f11081a;
    final /* synthetic */ BaseHtmlWebView f11082b;

    public eih(BaseHtmlWebView baseHtmlWebView, boolean z) {
        this.f11082b = baseHtmlWebView;
        this.f11081a = z;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        this.f11082b.f2331b.sendTouchEvent(motionEvent);
        return motionEvent.getAction() == 2 && !this.f11081a;
    }
}
