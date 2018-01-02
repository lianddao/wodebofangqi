package com.ushareit.listenit.sleep;

import android.content.Context;
import android.os.Build.VERSION;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.RadioButton;
import android.widget.TextView;
import com.umeng.analytics.C0154a;
import com.ushareit.listenit.C0349R;
import com.ushareit.listenit.ak;
import com.ushareit.listenit.fii;
import com.ushareit.listenit.gla;
import com.ushareit.listenit.gum;
import com.ushareit.listenit.gvj;
import com.ushareit.listenit.gwk;
import com.ushareit.listenit.gwn;
import com.ushareit.listenit.gwo;
import com.ushareit.listenit.gwp;
import com.ushareit.listenit.gwq;
import com.ushareit.listenit.gwr;
import com.ushareit.listenit.gws;
import com.ushareit.listenit.gwt;
import com.ushareit.listenit.gwu;
import com.ushareit.listenit.gzd;
import com.ushareit.listenit.heb;
import com.ushareit.listenit.popupview.BasePopupView;
import com.ushareit.listenit.widget.LineEditView;
import java.util.ArrayList;
import java.util.List;

public class SleepPopupView extends BasePopupView {
    private InputMethodManager f16495a;
    private LineEditView f16496b;
    private TextView f16497c;
    private TextView f16498d;
    private RadioButton f16499e;
    private RadioButton f16500f;
    private RadioButton f16501g;
    private RadioButton f16502h;
    private RadioButton f16503i;
    private RadioButton f16504j;
    private RadioButton f16505k;
    private Context f16506l;
    private gwu f16507m = gwu.RADIO10;
    private List<RadioButton> f16508n = new ArrayList(7);
    private OnFocusChangeListener f16509o = new gwn(this);
    private OnClickListener f16510p = new gwo(this);
    private OnClickListener f16511q = new gwp(this);
    private OnClickListener f16512r = new gwq(this);
    private OnClickListener f16513s = new gwr(this);
    private TextWatcher f16514t = new gws(this);
    private OnClickListener f16515u = new gwt(this);

    public SleepPopupView(Context context) {
        super(context);
        this.f16506l = context;
        this.f16495a = (InputMethodManager) this.f16506l.getSystemService("input_method");
        m26135a(context, (ViewGroup) this);
    }

    public void m26135a(Context context, ViewGroup viewGroup) {
        ((ak) context).getWindow().setSoftInputMode(32);
        View inflate = View.inflate(context, C0349R.layout.popup_view_sleep, viewGroup);
        this.f16499e = (RadioButton) inflate.findViewById(C0349R.id.radio_10);
        this.f16500f = (RadioButton) inflate.findViewById(C0349R.id.radio_20);
        this.f16501g = (RadioButton) inflate.findViewById(C0349R.id.radio_30);
        this.f16502h = (RadioButton) inflate.findViewById(C0349R.id.radio_60);
        this.f16503i = (RadioButton) inflate.findViewById(C0349R.id.radio_90);
        this.f16504j = (RadioButton) inflate.findViewById(C0349R.id.radio_custom);
        this.f16505k = (RadioButton) inflate.findViewById(C0349R.id.radio_close);
        this.f16497c = (TextView) inflate.findViewById(C0349R.id.sleep_ok);
        this.f16498d = (TextView) inflate.findViewById(C0349R.id.sleep_cancel);
        this.f16496b = (LineEditView) inflate.findViewById(C0349R.id.sleep_custom);
        this.f16499e.setTag(gwu.RADIO10);
        this.f16500f.setTag(gwu.RADIO20);
        this.f16501g.setTag(gwu.RADIO30);
        this.f16502h.setTag(gwu.RADIO60);
        this.f16503i.setTag(gwu.RADIO90);
        this.f16504j.setTag(gwu.RADIO_CUSTOM);
        this.f16505k.setTag(gwu.RADIO_COLSE);
        this.f16508n.add(this.f16499e);
        this.f16508n.add(this.f16500f);
        this.f16508n.add(this.f16501g);
        this.f16508n.add(this.f16502h);
        this.f16508n.add(this.f16503i);
        this.f16508n.add(this.f16504j);
        this.f16508n.add(this.f16505k);
        inflate.setOnClickListener(this.f16513s);
        this.f16499e.setOnClickListener(this.f16515u);
        this.f16500f.setOnClickListener(this.f16515u);
        this.f16501g.setOnClickListener(this.f16515u);
        this.f16502h.setOnClickListener(this.f16515u);
        this.f16503i.setOnClickListener(this.f16515u);
        this.f16504j.setOnClickListener(this.f16515u);
        this.f16505k.setOnClickListener(this.f16515u);
        this.f16497c.setOnClickListener(this.f16511q);
        this.f16498d.setOnClickListener(this.f16512r);
        m26126a();
        m26133d();
        fii.m19297a(context, "sleep", "from_navigation");
    }

    private void m26126a() {
        this.f16496b.setOnFocusChangeListener(this.f16509o);
        this.f16496b.setOnClickListener(this.f16510p);
        this.f16496b.m26315a(this.f16514t);
        this.f16496b.setHint(C0349R.string.sleep_edit_box_hint);
        if (gzd.m23364e() == 1) {
            this.f16496b.setHintTextColor(getResources().getColor(C0349R.color.common_text_color_gray_night));
        } else {
            this.f16496b.setHintTextColor(getResources().getColor(C0349R.color.common_text_color_gray));
        }
        this.f16496b.setInputType(2);
        this.f16496b.setSingleLine();
        this.f16496b.setMaxLength(3);
        this.f16496b.m26314a();
        this.f16496b.m26316b();
    }

    private void m26133d() {
        int e = gvj.m22936e();
        switch (e) {
            case 0:
                this.f16505k.setChecked(true);
                this.f16507m = gwu.RADIO_COLSE;
                return;
            case 10:
                this.f16499e.setChecked(true);
                this.f16507m = gwu.RADIO10;
                return;
            case 20:
                this.f16500f.setChecked(true);
                this.f16507m = gwu.RADIO20;
                return;
            case 30:
                this.f16501g.setChecked(true);
                this.f16507m = gwu.RADIO30;
                return;
            case C0154a.f2959o /*60*/:
                this.f16502h.setChecked(true);
                this.f16507m = gwu.RADIO60;
                return;
            case 90:
                this.f16503i.setChecked(true);
                this.f16507m = gwu.RADIO90;
                return;
            default:
                this.f16504j.setChecked(true);
                this.f16496b.setText(String.valueOf(e));
                this.f16507m = gwu.RADIO_CUSTOM;
                return;
        }
    }

    public void mo2995a(gum com_ushareit_listenit_gum) {
        super.mo2995a(com_ushareit_listenit_gum);
    }

    public void setItem(gla com_ushareit_listenit_gla) {
    }

    public void setTitle(String str) {
    }

    public int getGravity() {
        return 17;
    }

    public void mo2997c() {
        super.mo2997c();
    }

    protected void onDetachedFromWindow() {
        if (this.f16506l != null) {
            if (VERSION.SDK_INT >= 11) {
                ((ak) this.f16506l).getWindow().setSoftInputMode(48);
            } else {
                ((ak) this.f16506l).getWindow().setSoftInputMode(0);
            }
            super.onDetachedFromWindow();
        }
    }

    private void m26127a(RadioButton radioButton) {
        this.f16507m = (gwu) radioButton.getTag();
        radioButton.setChecked(true);
        int indexOf = this.f16508n.indexOf(radioButton);
        int size = (indexOf + 1) % this.f16508n.size();
        while (indexOf != size) {
            ((RadioButton) this.f16508n.get(size)).setChecked(false);
            size = (size + 1) % this.f16508n.size();
        }
        if (radioButton.getTag() != gwu.RADIO_CUSTOM) {
            this.f16495a.hideSoftInputFromWindow(this.f16496b.getWindowToken(), 0);
            this.f16497c.setEnabled(true);
        } else if (this.f16496b.getText() == null || this.f16496b.getText().toString().length() == 0) {
            this.f16497c.setEnabled(false);
        }
    }

    private void setSleepTime(int i) {
        gwk.m23063a().m23070a(i);
        gvj.m22904b(i);
        String string = getResources().getString(C0349R.string.sleep_toast_success_prefix);
        heb.m23597a(string + i + getResources().getString(C0349R.string.sleep_toast_success_suffix), 0).show();
        fii.m19303b(getContext(), i);
        mo3063e();
    }

    public void mo3063e() {
        super.mo3063e();
        this.f16495a.hideSoftInputFromWindow(this.f16496b.getWindowToken(), 0);
    }
}
