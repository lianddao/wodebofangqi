package com.ushareit.listenit.cutter.view;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.RadioButton;
import com.ushareit.listenit.C0349R;
import com.ushareit.listenit.fps;
import com.ushareit.listenit.fpt;
import com.ushareit.listenit.fpu;
import com.ushareit.listenit.fpv;
import com.ushareit.listenit.gla;
import com.ushareit.listenit.popupview.BasePopupView;

public class SetRingPopupView extends BasePopupView {
    private RadioButton f9067a;
    private RadioButton f9068b;
    private RadioButton f9069c;
    private int f9070d;
    private fpv f9071e;
    private View f9072f;
    private View f9073g;
    private OnClickListener f9074h = new fps(this);
    private OnClickListener f9075i = new fpt(this);
    private OnClickListener f9076j = new fpu(this);

    public SetRingPopupView(Context context) {
        super(context);
        m12844a(context, (ViewGroup) this);
    }

    public void m12844a(Context context, ViewGroup viewGroup) {
        View inflate = View.inflate(context, C0349R.layout.popup_view_set_ring, viewGroup);
        this.f9067a = (RadioButton) inflate.findViewById(C0349R.id.radio_ringtone);
        this.f9068b = (RadioButton) inflate.findViewById(C0349R.id.radio_alarm);
        this.f9069c = (RadioButton) inflate.findViewById(C0349R.id.radio_notification);
        this.f9067a.setChecked(true);
        this.f9070d = 1;
        this.f9067a.setOnClickListener(this.f9074h);
        this.f9068b.setOnClickListener(this.f9074h);
        this.f9069c.setOnClickListener(this.f9074h);
        this.f9072f = inflate.findViewById(C0349R.id.set_ok);
        this.f9073g = inflate.findViewById(C0349R.id.set_cancel);
        this.f9072f.setOnClickListener(this.f9075i);
        this.f9073g.setOnClickListener(this.f9076j);
    }

    public void setSetRingListener(fpv com_ushareit_listenit_fpv) {
        this.f9071e = com_ushareit_listenit_fpv;
    }

    public void setItem(gla com_ushareit_listenit_gla) {
    }

    public void setTitle(String str) {
    }

    public int getGravity() {
        return 17;
    }

    private void m12837a() {
        this.f9067a.setChecked(false);
        this.f9068b.setChecked(false);
        this.f9069c.setChecked(false);
    }
}
