package com.ushareit.listenit;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.ushareit.listenit.widget.ActionBarView;

public abstract class fjk extends fjt {
    private ActionBarView f4051n;
    private FrameLayout f4052o;

    public abstract boolean mo539h();

    public abstract boolean mo540i();

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        gzc.m23341a((Activity) this, (int) C0349R.color.common_actionbar_color);
        super.setContentView(C0349R.layout.common_activity_base);
        this.f4051n = (ActionBarView) findViewById(C0349R.id.actionbar_view);
        this.f4051n.setOnHomeClickListener(new fjl(this));
        this.f4052o = (FrameLayout) findViewById(C0349R.id.content_view);
        gyn.m23237e(this.f4052o, gyn.m23206b((Context) this));
    }

    public void mo541k() {
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && mo540i()) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    public void setContentView(int i) {
        View.inflate(this, i, this.f4052o);
    }

    public void setTitle(int i) {
        this.f4051n.setTitle(i);
    }

    public void m5102a(String str) {
        this.f4051n.setTitle(str);
    }

    public void m5103d(int i) {
        this.f4051n.setSearchVisibility(i);
    }
}
