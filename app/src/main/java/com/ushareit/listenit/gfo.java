package com.ushareit.listenit;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.ushareit.listenit.login.LoginActivity;
import com.ushareit.listenit.widget.LineEditView;
import java.util.List;

public class gfo extends fjm {
    private geq aj = new gfq(this);
    private View f14033d;
    private LineEditView f14034e;
    private TextView f14035f;
    private gge f14036g;
    private LoginActivity f14037h;
    private OnClickListener f14038i = new gfp(this);

    public void mo2603U() {
        m19543d(C0349R.string.email_account_title);
        gef.m21805a().m21823a(this.aj);
        this.f14036g = new gge();
        this.f14037h = (LoginActivity) m1328m();
        View c = m19541c((int) C0349R.layout.email_account_fragment);
        m21874a(c);
        m21878b(c);
        m21872W();
    }

    private void m21874a(View view) {
        this.f14033d = view.findViewById(C0349R.id.login_email_next);
        this.f14034e = (LineEditView) view.findViewById(C0349R.id.login_email_input);
        this.f14035f = (TextView) view.findViewById(C0349R.id.login_error_container);
    }

    private void m21878b(View view) {
        gyn.m23237e(view, gyn.m23206b(m1326l()));
        this.f14034e.setInputType(32);
        this.f14034e.setLTR();
        this.f14034e.setAction(6);
        this.f14037h.showSoftKeyboard(this.f14034e.getEditText());
    }

    private void m21872W() {
        this.f14033d.setOnClickListener(this.f14038i);
    }

    public boolean mo2549b() {
        this.f14037h.mo539h();
        return true;
    }

    public void mo175h() {
        gef.m21805a().m21823a(null);
        super.mo175h();
    }

    private void m21876a(String str, List<String> list) {
        if (list == null || list.isEmpty()) {
            this.f14037h.m24629a(str);
            return;
        }
        for (String str2 : list) {
            if (str2.equalsIgnoreCase("password")) {
                this.f14037h.m24631b(str);
            } else if (str2.equalsIgnoreCase("google.com")) {
                this.f14037h.m24630a(m1328m().getResources().getString(C0349R.string.common_google), str);
            } else {
                this.f14037h.m24630a(m1328m().getResources().getString(C0349R.string.common_facebook), str);
            }
        }
    }
}
