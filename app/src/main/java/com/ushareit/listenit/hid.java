package com.ushareit.listenit;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager.LayoutParams;
import android.widget.GridView;

public class hid extends hjd {
    private Context aj;
    private GridView ak;
    private hik al;
    private Boolean am = Boolean.valueOf(false);
    private hil ao = new hig(this);

    public void m23897c(String str) {
    }

    public void mo2309U() {
    }

    public final void mo168a(Bundle bundle) {
        super.mo168a(bundle);
        m1343a(1, 16973839);
        this.al = new hik(m1324k(), this.ao);
    }

    public final View mo199a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(C0349R.layout.socialshare_dialog_fragment, viewGroup, false);
        this.aj = m1328m();
        m23892a(inflate);
        return inflate;
    }

    public Dialog mo176c(Bundle bundle) {
        Dialog c = super.mo176c(bundle);
        if (c.getWindow() != null && this.am.booleanValue()) {
            LayoutParams attributes = c.getWindow().getAttributes();
            attributes.flags |= 1024;
            attributes.flags |= 128;
            c.getWindow().setAttributes(attributes);
        }
        return c;
    }

    public void onCancel(DialogInterface dialogInterface) {
        super.onCancel(dialogInterface);
        mo2309U();
    }

    private void m23892a(View view) {
        this.ak = (GridView) view.findViewById(C0349R.id.gridview);
        this.ak.setAdapter(new hih(this.aj, him.m23902a(this.aj, this.al)));
        this.ak.setSelector(C0349R.drawable.widget_sharedialog_item_bg);
        view.findViewById(C0349R.id.mask).setOnClickListener(new hie(this));
        view.findViewById(C0349R.id.content).setOnClickListener(new hif(this));
    }
}
