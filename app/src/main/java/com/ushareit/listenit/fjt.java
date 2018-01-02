package com.ushareit.listenit;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.FrameLayout;

public abstract class fjt extends fjf {
    private FrameLayout f4049n;
    private fyi f4050o;

    public abstract boolean mo540i();

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        super.setContentView(C0349R.layout.popup_fragment_activity);
        this.f4049n = (FrameLayout) findViewById(C0349R.id.content);
    }

    public void mo541k() {
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.f4050o != null && this.f4050o.mo2549b()) {
                gyn.m23196a((ak) this, this.f4050o);
                this.f4050o = null;
                return true;
            } else if (mo540i()) {
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    public void setContentView(int i) {
        View.inflate(this, i, this.f4049n);
    }

    public void m5099a(fyi com_ushareit_listenit_fyi) {
        this.f4050o = com_ushareit_listenit_fyi;
    }
}
