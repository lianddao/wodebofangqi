package com.ushareit.listenit;

import android.os.Build.VERSION;
import android.view.View;
import android.view.View.OnSystemUiVisibilityChangeListener;
import com.umeng.analytics.pro.C0320w;
import com.ushareit.listenit.lockscreen.LockScreenActivity;

public class gca implements OnSystemUiVisibilityChangeListener {
    final /* synthetic */ View f13892a;
    final /* synthetic */ LockScreenActivity f13893b;

    public gca(LockScreenActivity lockScreenActivity, View view) {
        this.f13893b = lockScreenActivity;
        this.f13892a = view;
    }

    public void onSystemUiVisibilityChange(int i) {
        if (VERSION.SDK_INT >= 11 && (i & 4) == 0) {
            this.f13892a.setSystemUiVisibility(C0320w.f3807b);
        }
    }
}
