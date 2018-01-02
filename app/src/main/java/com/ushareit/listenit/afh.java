package com.ushareit.listenit;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;

class afh extends ConstantState {
    private final ConstantState f4260a;
    private final int f4261b;

    afh(afh com_ushareit_listenit_afh) {
        this(com_ushareit_listenit_afh.f4260a, com_ushareit_listenit_afh.f4261b);
    }

    afh(ConstantState constantState, int i) {
        this.f4260a = constantState;
        this.f4261b = i;
    }

    public Drawable newDrawable() {
        return newDrawable(null);
    }

    public Drawable newDrawable(Resources resources) {
        return new afg(this, null, resources);
    }

    public int getChangingConfigurations() {
        return 0;
    }
}
