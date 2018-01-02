package com.ushareit.listenit;

import android.view.View;
import android.view.View.OnClickListener;
import com.ushareit.listenit.theme.ThemeSettingsActivity;

public class gxh implements OnClickListener {
    final /* synthetic */ ThemeSettingsActivity f14855a;

    public gxh(ThemeSettingsActivity themeSettingsActivity) {
        this.f14855a = themeSettingsActivity;
    }

    public void onClick(View view) {
        if (this.f14855a.f16597I != this.f14855a.f16598J) {
            gzd.m23367f(this.f14855a.f16598J == gzd.m23368g() ? 0 : 2);
            gzd.m23365e(this.f14855a.f16598J);
            gzc.m23346b(this.f14855a, this.f14855a.f16598J);
            hhf.m23855a();
            this.f14855a.m26284c(this.f14855a.f16598J);
        }
        this.f14855a.finish();
    }
}
