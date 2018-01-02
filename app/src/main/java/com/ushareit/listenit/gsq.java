package com.ushareit.listenit;

import android.os.Build.VERSION;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView.OnEditorActionListener;

public abstract class gsq extends fji {
    ImageView f14668a;
    private InputMethodManager aj;
    private View ak;
    private gsw al;
    private OnClickListener am = new gss(this);
    private OnClickListener an = new gst(this);
    private OnEditorActionListener ao = new gsu(this);
    private Runnable ap = new gsv(this);
    EditText f14669b;
    String f14670c = "";
    private ImageView f14671d;
    private View f14672e;
    private ImageView f14673f;
    private View f14674g;
    private ViewGroup f14675h;
    private boolean f14676i = false;

    public abstract void mo2740a(ViewGroup viewGroup);

    public View mo2388a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        m1328m().getWindow().setSoftInputMode(16);
        View view = (ViewGroup) layoutInflater.inflate(C0349R.layout.base_search_fragment, viewGroup, false);
        m22706a(view);
        mo2740a((ViewGroup) view.findViewById(C0349R.id.search_content));
        if (gyn.m23217b()) {
            gyn.m23224c(this.f14672e, fbb.m18766e(m1326l()));
        } else {
            view.removeView(this.f14672e);
        }
        mo2607d();
        return view;
    }

    private void m22706a(View view) {
        this.f14671d = (ImageView) view.findViewById(C0349R.id.back);
        this.f14672e = view.findViewById(C0349R.id.status_fake_bar);
        this.f14668a = (ImageView) view.findViewById(C0349R.id.search);
        this.f14669b = (EditText) view.findViewById(C0349R.id.edit);
        this.f14673f = (ImageView) view.findViewById(C0349R.id.search_delete);
        this.f14675h = (ViewGroup) view.findViewById(C0349R.id.container);
        this.f14669b.setHint(this.f14670c);
        this.f14669b.setFilters(new InputFilter[]{new LengthFilter(40)});
        this.f14669b.requestFocus();
        this.f14669b.setFocusable(true);
        this.f14669b.setOnEditorActionListener(this.ao);
        this.f14671d.setOnClickListener(this.am);
        this.f14673f.setVisibility(0);
        this.f14673f.setOnClickListener(this.an);
        this.f14668a.setOnClickListener(new gsr(this));
        this.ak = view.findViewById(C0349R.id.progress_view);
        this.f14674g = view.findViewById(C0349R.id.not_found_view);
    }

    public void mo201x() {
        this.f14676i = false;
        this.f14669b.postDelayed(this.ap, 400);
        super.mo201x();
    }

    public void mo2607d() {
        fez.m19057a(m1326l(), this.f14675h);
    }

    public boolean mo2549b() {
        fio.m19367b(m1326l(), "back");
        return false;
    }

    public void mo174g() {
        if (!this.f14676i) {
            m22707U();
        }
        super.mo174g();
    }

    public void mo171e() {
        m22707U();
        super.mo171e();
    }

    public void mo175h() {
        if (VERSION.SDK_INT >= 11) {
            m1328m().getWindow().setSoftInputMode(48);
        } else {
            m1328m().getWindow().setSoftInputMode(0);
        }
        super.mo175h();
    }

    public void m22713a(gsw com_ushareit_listenit_gsw) {
        this.al = com_ushareit_listenit_gsw;
    }

    public void m22715c(String str) {
        this.f14669b.setText(str);
        this.f14669b.setSelection(str.length());
    }

    void m22707U() {
        if (this.aj == null) {
            this.aj = (InputMethodManager) m1326l().getSystemService("input_method");
        }
        if (this.f14669b.getWindowToken() != null) {
            this.aj.hideSoftInputFromWindow(this.f14669b.getWindowToken(), 0);
        }
    }

    public void m22708V() {
        this.ak.setVisibility(0);
        this.f14674g.setVisibility(8);
    }

    public void m22709W() {
        this.ak.setVisibility(4);
        this.f14674g.setVisibility(8);
    }

    public void m22710X() {
        this.ak.setVisibility(8);
        this.f14674g.setVisibility(0);
    }
}
