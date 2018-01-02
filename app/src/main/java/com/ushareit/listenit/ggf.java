package com.ushareit.listenit;

import android.view.View;
import android.view.View.OnClickListener;
import com.ushareit.listenit.login.LoginActivity;
import com.ushareit.listenit.widget.LineEditView;

public class ggf extends fjm {
    private LineEditView f14064d;
    private View f14065e;
    private LoginActivity f14066f;
    private OnClickListener f14067g = new ggg(this);
    private get f14068h = new ggh(this);

    public void mo2603U() {
        this.f14066f = (LoginActivity) m1328m();
        View c = m19541c((int) C0349R.layout.reset_password_fragment);
        m19543d(C0349R.string.email_reset_password_page_title);
        m21925a(c);
        m21927b(c);
        m21923W();
    }

    public boolean mo2549b() {
        this.f14066f.m24638q();
        return true;
    }

    private void m21925a(View view) {
        this.f14064d = (LineEditView) view.findViewById(C0349R.id.reset_password_account);
        this.f14065e = view.findViewById(C0349R.id.reset_password_do);
    }

    private void m21927b(View view) {
        gyn.m23237e(view, gyn.m23206b(m1326l()));
        this.f14064d.setText(m1324k().getString("email"));
        this.f14064d.setEnabled(false);
    }

    private void m21923W() {
        this.f14065e.setOnClickListener(this.f14067g);
    }
}
