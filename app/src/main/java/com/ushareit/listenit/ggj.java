package com.ushareit.listenit;

import android.view.View;
import android.widget.TextView;
import com.mopub.mobileads.VastExtensionXmlManager;
import com.ushareit.listenit.login.LoginActivity;

public class ggj extends fjm {
    private View f14073d;
    private TextView f14074e;
    private LoginActivity f14075f;
    private String f14076g;
    private get f14077h = new ggl(this);

    public void mo2603U() {
        View c = m19541c((int) C0349R.layout.welcome_back_fragment);
        m19543d(C0349R.string.email_welcome_page_title);
        this.f14075f = (LoginActivity) m1328m();
        m21935a(c);
        m21937b(c);
        m21933W();
    }

    public boolean mo2549b() {
        this.f14075f.m24637p();
        return true;
    }

    private void m21935a(View view) {
        this.f14073d = view.findViewById(C0349R.id.welcome_back_idp_button);
        this.f14074e = (TextView) view.findViewById(C0349R.id.welcome_back_idp_prompt);
    }

    private void m21937b(View view) {
        gyn.m23237e(view, gyn.m23206b(m1326l()));
        this.f14076g = m1324k().getString(VastExtensionXmlManager.TYPE);
        String string = m1329n().getString(C0349R.string.email_welcome_back_second_line_text);
        String string2 = m1324k().getString("email");
        this.f14074e.setText(String.format(string, new Object[]{string2, this.f14076g}));
    }

    private void m21933W() {
        this.f14073d.setOnClickListener(new ggk(this));
    }
}
