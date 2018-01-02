package com.ushareit.listenit;

import android.text.SpannableStringBuilder;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.ushareit.listenit.login.LoginActivity;
import com.ushareit.listenit.widget.LineEditView;

public class gfx extends fjm {
    private LineEditView aj;
    private LineEditView ak;
    private LoginActivity al;
    private CheckBox am;
    private View an;
    private OnClickListener ao = new gfz(this);
    private ges ap = new gga(this);
    private OnCheckedChangeListener aq = new ggb(this);
    private TextWatcher ar = new ggc(this);
    private TextWatcher as = new ggd(this);
    private LineEditView f14052d;
    private TextView f14053e;
    private TextView f14054f;
    private TextView f14055g;
    private Button f14056h;
    private gge f14057i;

    public void mo2603U() {
        m19543d(C0349R.string.email_register_title);
        View c = m19541c((int) C0349R.layout.email_register_fragment);
        gyn.m23237e(c, m1328m().getResources().getDimensionPixelSize(C0349R.dimen.common_dimens_50dp));
        this.f14057i = new gge();
        this.al = (LoginActivity) m1328m();
        m21904a(c);
        m21899W();
        m21901Y();
    }

    public boolean mo2549b() {
        this.al.mo540i();
        return true;
    }

    private void m21904a(View view) {
        this.f14052d = (LineEditView) view.findViewById(C0349R.id.register_email_account);
        this.f14053e = (TextView) view.findViewById(C0349R.id.register_slogan);
        this.f14054f = (TextView) view.findViewById(C0349R.id.register_error_name);
        this.f14055g = (TextView) view.findViewById(C0349R.id.register_error_password);
        this.f14056h = (Button) view.findViewById(C0349R.id.register_button);
        this.aj = (LineEditView) view.findViewById(C0349R.id.register_user_name);
        this.an = view.findViewById(C0349R.id.register_title_password);
        this.ak = (LineEditView) view.findViewById(C0349R.id.register_password);
        this.am = (CheckBox) view.findViewById(C0349R.id.password_toggle);
    }

    private void m21899W() {
        if (m1324k() != null) {
            String string = m1324k().getString("email");
            if (string != null) {
                this.f14052d.setText(string.trim());
            }
        }
        this.f14052d.setLTR();
        this.f14052d.setEnable(false);
        this.aj.setSingleLine();
        this.aj.setAction(5);
        this.aj.m26315a(this.ar);
        this.al.showSoftKeyboard(this.aj);
        this.ak.setInputType(129);
        this.ak.setTextPaddingRight(m1329n().getDimensionPixelSize(C0349R.dimen.common_dimens_24dp));
        this.ak.setAction(6);
        this.ak.m26315a(this.as);
        m21900X();
    }

    private void m21900X() {
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(dw.m15880b(eys.m18562a(), C0349R.color.common_link));
        String string = m1329n().getString(C0349R.string.create_account_preamble);
        String string2 = m1329n().getString(C0349R.string.create_account_terms_of_service);
        CharSequence spannableStringBuilder = new SpannableStringBuilder(string + string2);
        int length = string.length();
        spannableStringBuilder.setSpan(foregroundColorSpan, length, string2.length() + length, 0);
        this.f14053e.setText(spannableStringBuilder);
        this.f14053e.setOnClickListener(new gfy(this));
    }

    private void m21901Y() {
        this.f14056h.setOnClickListener(this.ao);
        this.am.setOnCheckedChangeListener(this.aq);
    }

    private void m21902Z() {
        this.f14054f.setVisibility(0);
        this.f14054f.setText(C0349R.string.email_error_info_name_validator_1);
        LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(3, C0349R.id.register_error_name);
        layoutParams.topMargin = m1329n().getDimensionPixelSize(C0349R.dimen.common_dimens_15dp);
        this.an.setLayoutParams(layoutParams);
    }

    private void aa() {
        this.f14054f.setVisibility(8);
        this.f14054f.setText("");
        LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(3, C0349R.id.register_user_name);
        layoutParams.topMargin = m1329n().getDimensionPixelSize(C0349R.dimen.common_dimens_15dp);
        this.an.setLayoutParams(layoutParams);
    }
}
