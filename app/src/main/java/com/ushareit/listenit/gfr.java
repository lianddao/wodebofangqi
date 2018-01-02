package com.ushareit.listenit;

import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;
import com.ushareit.listenit.login.LoginActivity;
import com.ushareit.listenit.widget.LineEditView;

public class gfr extends fjm {
    private LoginActivity aj;
    private CheckBox ak;
    private get al = new gfs(this);
    private OnClickListener am = new gft(this);
    private OnClickListener an = new gfu(this);
    private OnCheckedChangeListener ao = new gfv(this);
    private TextWatcher ap = new gfw(this);
    private LineEditView f14041d;
    private View f14042e;
    private LineEditView f14043f;
    private gge f14044g;
    private TextView f14045h;
    private TextView f14046i;

    public void mo2603U() {
        View c = m19541c((int) C0349R.layout.email_login_fragment);
        m19543d(C0349R.string.email_login_page_title);
        this.f14044g = new gge();
        this.aj = (LoginActivity) m1328m();
        m21888a(c);
        m21890b(c);
        m21886W();
    }

    public boolean mo2549b() {
        this.aj.m24635j();
        return true;
    }

    private void m21888a(View view) {
        this.f14041d = (LineEditView) view.findViewById(C0349R.id.login_email_input);
        this.f14042e = view.findViewById(C0349R.id.login_email_next);
        this.f14043f = (LineEditView) view.findViewById(C0349R.id.login_password);
        this.f14045h = (TextView) view.findViewById(C0349R.id.login_error_password);
        this.f14046i = (TextView) view.findViewById(C0349R.id.forgot_password);
        this.ak = (CheckBox) view.findViewById(C0349R.id.password_toggle);
    }

    private void m21890b(View view) {
        gyn.m23237e(view, gyn.m23206b(m1326l()));
        if (m1324k() != null) {
            String string = m1324k().getString("email");
            if (string != null) {
                this.f14041d.setText(string.trim());
            }
        }
        this.f14041d.setInputType(32);
        this.f14041d.setLTR();
        this.f14041d.setEnable(false);
        this.f14043f.setAction(5);
        this.f14043f.setFocusable(true);
        this.f14043f.requestFocus();
        this.f14043f.setInputType(129);
        this.f14043f.setTextPaddingRight(m1329n().getDimensionPixelSize(C0349R.dimen.common_dimens_24dp));
        this.f14043f.setAction(6);
        this.f14043f.m26315a(this.ap);
    }

    private void m21886W() {
        this.f14042e.setOnClickListener(this.am);
        this.f14046i.setOnClickListener(this.an);
        this.ak.setOnCheckedChangeListener(this.ao);
    }
}
