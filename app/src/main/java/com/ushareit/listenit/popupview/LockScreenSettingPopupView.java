package com.ushareit.listenit.popupview;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.TextView;
import com.ushareit.listenit.C0349R;
import com.ushareit.listenit.gla;
import com.ushareit.listenit.gpe;
import com.ushareit.listenit.gpf;
import com.ushareit.listenit.gpg;
import com.ushareit.listenit.gph;
import com.ushareit.listenit.gpi;
import com.ushareit.listenit.gvj;
import com.ushareit.listenit.gzd;

public class LockScreenSettingPopupView extends BasePopupView {
    private RadioButton f16196a;
    private RadioButton f16197b;
    private TextView f16198c;
    private TextView f16199d;
    private gpi f16200e;
    private boolean f16201f = true;
    private OnClickListener f16202g = new gpe(this);
    private OnClickListener f16203h = new gpf(this);
    private OnClickListener f16204i = new gpg(this);
    private OnClickListener f16205j = new gph(this);

    public void setSettingOkListener(gpi com_ushareit_listenit_gpi) {
        this.f16200e = com_ushareit_listenit_gpi;
    }

    public LockScreenSettingPopupView(Context context) {
        super(context);
        m25591a(context, (ViewGroup) this);
    }

    public void m25591a(Context context, ViewGroup viewGroup) {
        View inflate = View.inflate(context, C0349R.layout.popup_view_lock_screen_setting, viewGroup);
        this.f16196a = (RadioButton) inflate.findViewById(C0349R.id.radio_system);
        this.f16197b = (RadioButton) inflate.findViewById(C0349R.id.radio_custom);
        boolean f = gvj.m22953f();
        this.f16201f = f;
        if (f) {
            this.f16196a.setChecked(true);
        } else {
            this.f16197b.setChecked(true);
        }
        this.f16196a.setOnClickListener(this.f16204i);
        this.f16197b.setOnClickListener(this.f16205j);
        this.f16198c = (TextView) inflate.findViewById(C0349R.id.lock_ok);
        this.f16198c.setOnClickListener(this.f16202g);
        this.f16199d = (TextView) inflate.findViewById(C0349R.id.lock_cancel);
        this.f16199d.setOnClickListener(this.f16203h);
        if (gzd.m23364e() == 2) {
            this.f16198c.setTextColor(gzd.m23358b());
        }
    }

    public void setItem(gla com_ushareit_listenit_gla) {
    }

    public void setTitle(String str) {
    }

    public int getGravity() {
        return 17;
    }
}
