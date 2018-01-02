package com.ushareit.listenit.popupview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.ushareit.listenit.fyw;
import com.ushareit.listenit.gla;
import com.ushareit.listenit.gum;

public abstract class BasePopupView extends FrameLayout {
    private fyw f9066a;

    public abstract int getGravity();

    public abstract void setItem(gla com_ushareit_listenit_gla);

    public abstract void setTitle(String str);

    public BasePopupView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public BasePopupView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public BasePopupView(Context context) {
        super(context);
    }

    public boolean getCancelable() {
        return true;
    }

    public final void setOnPopupNextListener(fyw com_ushareit_listenit_fyw) {
        this.f9066a = com_ushareit_listenit_fyw;
    }

    public final void m12832a(BasePopupView basePopupView) {
        if (this.f9066a != null) {
            this.f9066a.mo2625a(basePopupView);
        }
    }

    public void mo3063e() {
        if (this.f9066a != null) {
            this.f9066a.mo2625a(null);
        }
    }

    public void mo2996b() {
    }

    public void mo2997c() {
    }

    public void mo2995a(gum com_ushareit_listenit_gum) {
    }
}
