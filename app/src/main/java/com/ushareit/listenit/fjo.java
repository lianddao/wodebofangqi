package com.ushareit.listenit;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import com.ushareit.listenit.theme.entry.CustomThemeCheckView;

public class fjo extends fjh {
    private fjw aA = new fjq(this);
    private fjw aB = new fjr(this);
    private boolean aj = false;
    private boolean ak = false;
    private boolean al = false;
    private boolean am = false;
    private boolean an = false;
    private boolean ao = false;
    private String ap;
    private String aq;
    private String ar;
    private String as;
    private String at;
    private String au;
    private String av;
    private String aw;
    private CustomThemeCheckView ax;
    private fjs ay;
    private fjw az = new fjp(this);

    public final void mo168a(Bundle bundle) {
        super.mo168a(bundle);
    }

    public final View mo199a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(C0349R.layout.confirm_dialog_fragment, viewGroup, false);
        m19547a(inflate);
        return inflate;
    }

    private void m19547a(View view) {
        TextView textView;
        if (this.aj) {
            textView = (TextView) view.findViewById(C0349R.id.title);
            textView.setVisibility(0);
            if (!fbb.m18763c(this.ap)) {
                textView.setText(this.ap);
            }
        }
        if (this.ak) {
            textView = (TextView) view.findViewById(C0349R.id.content);
            textView.setVisibility(0);
            if (!fbb.m18763c(this.aq)) {
                textView.setText(this.aq);
            }
        }
        if (this.al) {
            view.findViewById(C0349R.id.input_view).setVisibility(0);
            EditText editText = (EditText) view.findViewById(C0349R.id.input);
            TextView textView2 = (TextView) view.findViewById(C0349R.id.input_desc);
            if (!fbb.m18763c(this.ar)) {
                editText.setText(this.ar);
            }
            if (!fbb.m18763c(this.as)) {
                editText.setHint(this.as);
            }
            if (!fbb.m18763c(this.at)) {
                textView2.setText(this.at);
            }
        }
        if (this.am) {
            view.findViewById(C0349R.id.check_view).setVisibility(0);
            this.ax = (CustomThemeCheckView) view.findViewById(C0349R.id.checkbox);
            this.ax.setOnClickListener(this.aB);
            textView = (TextView) view.findViewById(C0349R.id.check_info);
            textView.setOnClickListener(this.aB);
            if (!fbb.m18763c(this.au)) {
                textView.setText(this.au);
            }
        }
        if (this.an) {
            textView = (TextView) view.findViewById(C0349R.id.ok);
            textView.setVisibility(0);
            textView.setOnClickListener(this.az);
            if (!fbb.m18763c(this.av)) {
                textView.setText(this.av);
            }
        }
        if (this.ao) {
            textView = (TextView) view.findViewById(C0349R.id.cancel);
            textView.setVisibility(0);
            textView.setOnClickListener(this.aA);
            if (!fbb.m18763c(this.aw)) {
                textView.setText(this.aw);
            }
        }
    }

    public void m19557a(fjs com_ushareit_listenit_fjs) {
        this.ay = com_ushareit_listenit_fjs;
    }

    public fjo m19549U() {
        this.aj = true;
        return this;
    }

    public void m19558b(int i) {
        this.ap = eys.m18562a().getString(i);
    }

    public fjo m19550V() {
        this.ak = true;
        return this;
    }

    public void m19559c(int i) {
        this.aq = eys.m18562a().getString(i);
    }

    public fjo m19551W() {
        this.am = true;
        return this;
    }

    public void m19560d(int i) {
        this.au = eys.m18562a().getString(i);
    }

    public boolean m19552X() {
        return this.ax != null ? this.ax.isChecked() : false;
    }

    public fjo m19553Y() {
        this.an = true;
        return this;
    }

    public fjo m19554Z() {
        this.ao = true;
        return this;
    }
}
