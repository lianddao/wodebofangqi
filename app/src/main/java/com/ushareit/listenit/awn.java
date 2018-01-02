package com.ushareit.listenit;

import android.net.Uri;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.facebook.ads.internal.view.p003d.p004b.C0033a.C0031a;

public class awn implements OnTouchListener {
    final /* synthetic */ C0031a f5582a;

    public awn(C0031a c0031a) {
        this.f5582a = c0031a;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() != 0) {
            return false;
        }
        if (!this.f5582a.f681g) {
            this.f5582a.m1007d();
        } else if (!TextUtils.isEmpty(this.f5582a.f676b)) {
            atz.m7168a(this.f5582a.getContext(), Uri.parse(this.f5582a.f676b), this.f5582a.f677c);
        }
        return true;
    }
}
