package com.ushareit.listenit;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;

public abstract class afc<Z> extends afj<ImageView, Z> implements aer {
    protected abstract void mo614a(Z z);

    public afc(ImageView imageView) {
        super(imageView);
    }

    public Drawable mo615b() {
        return ((ImageView) this.a).getDrawable();
    }

    public void mo613a(Drawable drawable) {
        ((ImageView) this.a).setImageDrawable(drawable);
    }

    public void mo577c(Drawable drawable) {
        ((ImageView) this.a).setImageDrawable(drawable);
    }

    public void mo574a(Exception exception, Drawable drawable) {
        ((ImageView) this.a).setImageDrawable(drawable);
    }

    public void mo575b(Drawable drawable) {
        ((ImageView) this.a).setImageDrawable(drawable);
    }

    public void mo582a(Z z, aeq<? super Z> com_ushareit_listenit_aeq__super_Z) {
        if (com_ushareit_listenit_aeq__super_Z == null || !com_ushareit_listenit_aeq__super_Z.mo612a(z, this)) {
            mo614a((Object) z);
        }
    }
}
