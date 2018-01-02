package com.ushareit.listenit;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnKeyListener;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager.LayoutParams;
import android.widget.TextView;
import java.util.LinkedHashMap;

public abstract class hje extends hjd {
    private Boolean aj = Boolean.valueOf(false);
    private Boolean ak = Boolean.valueOf(false);
    private Boolean al = Boolean.valueOf(false);
    private boolean am = true;
    private hjk ao = hjk.TWOBUTTON;
    private String ap;
    private String aq;
    private String ar;
    private String as = null;
    private String at = null;
    private TextView au;
    private View av;
    private OnKeyListener aw = new hji(this);

    public abstract void mo2309U();

    public abstract void mo2310V();

    public void mo2788g(boolean z) {
    }

    public final void mo168a(Bundle bundle) {
        super.mo168a(bundle);
        Bundle k = m1324k();
        if (k != null) {
            this.aq = k.getString("msg");
            this.ap = k.getString("title");
            this.as = k.getString("btn1");
            this.at = k.getString("btn2");
            m1343a(1, 16973839);
        }
    }

    public final View mo199a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(C0349R.layout.widget_confirm_dialog_fragment, viewGroup, false);
        this.au = (TextView) inflate.findViewById(C0349R.id.content);
        this.au.setText(Html.fromHtml(fak.m18716a(this.aq)));
        TextView textView = (TextView) inflate.findViewById(C0349R.id.title_text);
        if (this.ap != null) {
            textView.setText(this.ap);
        } else {
            textView.setVisibility(8);
        }
        textView = (TextView) inflate.findViewById(C0349R.id.quit_ok);
        TextView textView2 = (TextView) inflate.findViewById(C0349R.id.quit_cancel);
        switch (hjj.f15522a[this.ao.ordinal()]) {
            case 1:
                if (this.as != null) {
                    textView.setText(this.as);
                }
                textView2.setVisibility(8);
                break;
            case 2:
                if (this.as != null) {
                    textView.setText(this.as);
                }
                if (this.at != null) {
                    textView2.setText(this.at);
                    break;
                }
                break;
        }
        textView.setOnClickListener(new hjf(this));
        textView2.setOnClickListener(new hjg(this));
        if (this.ar != null) {
            ((TextView) inflate.findViewById(C0349R.id.checkinfo)).setText(this.ar);
        }
        View findViewById = inflate.findViewById(C0349R.id.check);
        findViewById.setVisibility(this.ak.booleanValue() ? 0 : 8);
        this.av = findViewById.findViewById(C0349R.id.checkbox);
        findViewById.setOnClickListener(new hjh(this));
        return inflate;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        super.onCancel(dialogInterface);
        mo2310V();
        m18403c("keycode_back");
    }

    public final void m18411a(hjk com_ushareit_listenit_hjk) {
        this.ao = com_ushareit_listenit_hjk;
    }

    public final void m18415h(boolean z) {
        this.ak = Boolean.valueOf(z);
    }

    public final void m18412a(boolean z, String str) {
        this.ak = Boolean.valueOf(z);
        this.ar = str;
    }

    public final boolean m18408Y() {
        return this.al.booleanValue();
    }

    public Dialog mo176c(Bundle bundle) {
        Dialog c = super.mo176c(bundle);
        if (this.aj.booleanValue() && c.getWindow() != null) {
            LayoutParams attributes = c.getWindow().getAttributes();
            if (attributes != null) {
                attributes.flags |= 1024;
                attributes.flags |= 128;
                c.getWindow().setAttributes(attributes);
            }
        }
        c.setCanceledOnTouchOutside(this.am);
        c.setCancelable(this.am);
        c.setOnKeyListener(this.aw);
        return c;
    }

    protected void mo2311X() {
        if (this.an != null) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("portal", fid.m19227a().toString());
            linkedHashMap.put("leave_way", this.an.m17871a("leave_way"));
            this.an.m17875a(linkedHashMap);
        }
    }

    private void m18403c(String str) {
        if (this.an != null) {
            this.an.m17873a("leave_way", str);
        }
    }
}
