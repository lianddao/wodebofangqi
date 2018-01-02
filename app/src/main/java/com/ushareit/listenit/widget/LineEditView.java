package com.ushareit.listenit.widget;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.IBinder;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView.OnEditorActionListener;
import com.ushareit.listenit.C0349R;
import com.ushareit.listenit.hbw;

public class LineEditView extends RelativeLayout {
    public EditText f16656a;
    public int f16657b;
    public int f16658c;
    public int f16659d;
    public int f16660e;
    public boolean f16661f;
    private View f16662g;
    private OnFocusChangeListener f16663h;
    private OnFocusChangeListener f16664i = new hbw(this);

    public LineEditView(Context context) {
        super(context);
        m26313a(context);
    }

    public LineEditView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m26313a(context);
    }

    public LineEditView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m26313a(context);
    }

    private void m26313a(Context context) {
        View inflate = View.inflate(context, C0349R.layout.edit_view, this);
        this.f16662g = inflate.findViewById(C0349R.id.underline);
        this.f16656a = (EditText) inflate.findViewById(C0349R.id.edit);
        this.f16657b = getResources().getColor(C0349R.color.stroke_color_normal);
        this.f16658c = getResources().getColor(C0349R.color.stroke_color_disabled);
        this.f16659d = getResources().getColor(C0349R.color.stroke_color_focused);
        this.f16660e = getResources().getColor(C0349R.color.stroke_color_error);
        if (isEnabled()) {
            setLineHeightAndBackground(2, this.f16657b);
        } else {
            setLineHeightAndBackground(2, this.f16658c);
        }
        this.f16656a.setOnFocusChangeListener(this.f16664i);
    }

    public EditText getEditText() {
        return this.f16656a;
    }

    public Editable getText() {
        return this.f16656a.getText();
    }

    public void setText(CharSequence charSequence) {
        this.f16656a.setText(charSequence);
    }

    public void setSelection(int i) {
        this.f16656a.setSelection(i);
    }

    public void setEnable(boolean z) {
        this.f16656a.setEnabled(z);
        this.f16656a.setTextColor(getResources().getColor(C0349R.color.common_text_color_gray_9));
    }

    public void setErrorState(boolean z) {
        if (z) {
            setLineHeightAndBackground(4, this.f16660e);
        } else {
            setLineHeightAndBackground(4, this.f16657b);
        }
    }

    public void setInputType(int i) {
        this.f16656a.setInputType(i);
    }

    public void setTextPaddingRight(int i) {
        int dimensionPixelSize = getResources().getDimensionPixelSize(C0349R.dimen.common_dimens_6dp);
        this.f16656a.setPadding(0, 0, i, dimensionPixelSize);
        if (VERSION.SDK_INT >= 16) {
            this.f16656a.setPaddingRelative(0, 0, i, dimensionPixelSize);
        }
    }

    public IBinder getWindowToken() {
        return this.f16656a.getWindowToken();
    }

    public void setHint(int i) {
        this.f16656a.setHint(i);
    }

    public void setHintTextColor(int i) {
        this.f16656a.setHintTextColor(i);
    }

    public void setLTR() {
        if (VERSION.SDK_INT >= 17) {
            this.f16656a.setLayoutDirection(0);
            this.f16656a.setTextDirection(3);
        }
    }

    public void setAction(int i) {
        this.f16656a.setImeOptions(i);
    }

    public void setSingleLine() {
        this.f16656a.setSingleLine();
    }

    public void m26314a() {
        this.f16656a.setPadding(0, 0, 0, 4);
    }

    public void m26316b() {
        this.f16656a.setGravity(81);
    }

    public void m26315a(TextWatcher textWatcher) {
        this.f16656a.addTextChangedListener(textWatcher);
    }

    public int m26317c() {
        return this.f16656a.length();
    }

    public void setMaxLength(int i) {
        this.f16656a.setFilters(new InputFilter[]{new LengthFilter(i)});
    }

    public void setOnFocusChangeListener(OnFocusChangeListener onFocusChangeListener) {
        this.f16663h = onFocusChangeListener;
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        this.f16656a.setOnClickListener(onClickListener);
    }

    public void setOnEditorActionListener(OnEditorActionListener onEditorActionListener) {
        this.f16656a.setOnEditorActionListener(onEditorActionListener);
    }

    public void setLineHeightAndBackground(int i, int i2) {
        LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, i);
        layoutParams.addRule(3, C0349R.id.edit);
        this.f16662g.setLayoutParams(layoutParams);
        this.f16662g.setBackgroundColor(i2);
    }
}
