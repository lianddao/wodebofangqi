package com.ushareit.listenit;

import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.FacebookButtonBase;

public class aib implements OnClickListener {
    final /* synthetic */ FacebookButtonBase f4401a;

    public aib(FacebookButtonBase facebookButtonBase) {
        this.f4401a = facebookButtonBase;
    }

    public void onClick(View view) {
        if (this.f4401a.f449c != null) {
            this.f4401a.f449c.onClick(view);
        } else if (this.f4401a.f448b != null) {
            this.f4401a.f448b.onClick(view);
        }
    }
}
