package com.ushareit.listenit.popupview;

import android.content.Context;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import com.ushareit.listenit.C0349R;
import com.ushareit.listenit.gla;
import com.ushareit.listenit.gok;
import com.ushareit.listenit.gol;
import com.ushareit.listenit.gom;
import com.ushareit.listenit.gon;
import com.ushareit.listenit.goo;
import com.ushareit.listenit.gop;
import com.ushareit.listenit.theme.entry.CustomThemeCheckView;

public class ConfirmPopupView extends BasePopupView {
    private TextView f16145a;
    private TextView f16146b;
    private View f16147c;
    private View f16148d;
    private EditText f16149e;
    private View f16150f;
    private TextView f16151g;
    private CustomThemeCheckView f16152h;
    private TextView f16153i;
    private TextView f16154j;
    private TextView f16155k;
    private boolean f16156l;
    private gop f16157m;
    private OnClickListener f16158n = new gom(this);
    private Runnable f16159o = new gon(this);
    private TextWatcher f16160p = new goo(this);

    public ConfirmPopupView(Context context) {
        super(context);
        m25555a(context, (ViewGroup) this);
    }

    public void m25555a(Context context, ViewGroup viewGroup) {
        View inflate = View.inflate(context, C0349R.layout.popup_view_confirm, viewGroup);
        this.f16145a = (TextView) inflate.findViewById(C0349R.id.title);
        this.f16146b = (TextView) inflate.findViewById(C0349R.id.content);
        this.f16147c = inflate.findViewById(C0349R.id.select);
        this.f16148d = inflate.findViewById(C0349R.id.input);
        this.f16150f = inflate.findViewById(C0349R.id.underline);
        this.f16152h = (CustomThemeCheckView) inflate.findViewById(C0349R.id.checkbox);
        this.f16153i = (TextView) inflate.findViewById(C0349R.id.select_desc);
        this.f16149e = (EditText) inflate.findViewById(C0349R.id.edit);
        this.f16151g = (TextView) inflate.findViewById(C0349R.id.input_desc);
        this.f16154j = (TextView) inflate.findViewById(C0349R.id.ok);
        this.f16155k = (TextView) inflate.findViewById(C0349R.id.cancel);
        this.f16154j.setOnClickListener(new gok(this));
        this.f16155k.setOnClickListener(new gol(this));
        this.f16147c.setOnClickListener(this.f16158n);
    }

    public void setConfirmListener(gop com_ushareit_listenit_gop) {
        this.f16157m = com_ushareit_listenit_gop;
    }

    protected void onAttachedToWindow() {
        if (this.f16148d.getVisibility() == 0) {
            postDelayed(this.f16159o, 200);
        }
        super.onAttachedToWindow();
    }

    protected void onDetachedFromWindow() {
        m25553j();
        super.onDetachedFromWindow();
    }

    public int getGravity() {
        return 17;
    }

    public void setItem(gla com_ushareit_listenit_gla) {
    }

    public ConfirmPopupView m25554a() {
        this.f16145a.setVisibility(0);
        return this;
    }

    public ConfirmPopupView m25556d() {
        this.f16146b.setVisibility(0);
        return this;
    }

    public ConfirmPopupView m25557f() {
        this.f16147c.setVisibility(0);
        return this;
    }

    public ConfirmPopupView m25558g() {
        this.f16148d.setVisibility(0);
        this.f16149e.setFilters(new InputFilter[]{new LengthFilter(40)});
        this.f16149e.addTextChangedListener(this.f16160p);
        this.f16154j.setEnabled(false);
        this.f16154j.setTextColor(getResources().getColor(C0349R.color.common_text_color_gray));
        return this;
    }

    public void setHint(String str) {
        this.f16149e.setHint(str);
    }

    public void setTitle(String str) {
        this.f16145a.setText(str);
    }

    public void setTitle(int i) {
        this.f16145a.setText(getResources().getString(i));
    }

    public void setContent(String str) {
        this.f16146b.setText(str);
    }

    public void setContent(CharSequence charSequence) {
        this.f16146b.setText(charSequence);
    }

    public void setEditText(String str) {
        this.f16149e.setText(str);
        this.f16149e.setSelection(this.f16149e.getText().length());
    }

    public void setContent(int i) {
        this.f16146b.setText(getResources().getString(i));
    }

    public void setSelectDesc(String str) {
        this.f16153i.setText(str);
    }

    public void setSelectDesc(int i) {
        this.f16153i.setText(getResources().getString(i));
    }

    public void setInputDesc(String str) {
        this.f16151g.setText(str);
    }

    public void setInputDesc(int i) {
        this.f16151g.setText(getResources().getString(i));
    }

    public void setOk(String str) {
        this.f16154j.setText(str);
    }

    public void setOk(int i) {
        this.f16154j.setText(getResources().getString(i));
    }

    public void setCancel(String str) {
        this.f16155k.setText(str);
    }

    public void setCancel(int i) {
        this.f16155k.setText(getResources().getString(i));
    }

    public boolean m25559h() {
        return this.f16156l;
    }

    public String getInput() {
        return this.f16149e.getText().toString();
    }

    public void setDefaultCheck(boolean z) {
        this.f16156l = z;
        this.f16152h.setChecked(z);
    }

    public boolean m25560i() {
        return this.f16148d.getVisibility() == 0;
    }

    private void m25553j() {
        ((InputMethodManager) getContext().getSystemService("input_method")).hideSoftInputFromWindow(this.f16149e.getWindowToken(), 0);
    }
}
