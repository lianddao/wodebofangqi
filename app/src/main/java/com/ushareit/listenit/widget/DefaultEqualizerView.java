package com.ushareit.listenit.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.ushareit.listenit.C0349R;
import com.ushareit.listenit.fum;
import com.ushareit.listenit.gky;
import com.ushareit.listenit.hbm;
import com.ushareit.listenit.hbn;
import java.util.ArrayList;
import java.util.List;

public class DefaultEqualizerView extends LinearLayout {
    private List<TextView> f17203a = new ArrayList();
    private List<gky> f17204b = new ArrayList();
    private hbn f17205c;
    private OnClickListener f17206d = new hbm(this);

    public void setOnEqualizerClickListener(hbn com_ushareit_listenit_hbn) {
        this.f17205c = com_ushareit_listenit_hbn;
    }

    public DefaultEqualizerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m26813a(context);
    }

    public DefaultEqualizerView(Context context) {
        super(context);
        m26813a(context);
    }

    private void m26813a(Context context) {
        setOrientation(1);
        View inflate = View.inflate(context, C0349R.layout.default_equalizer_view, this);
        this.f17203a.add((TextView) inflate.findViewById(C0349R.id.equalizer0));
        this.f17203a.add((TextView) inflate.findViewById(C0349R.id.equalizer1));
        this.f17203a.add((TextView) inflate.findViewById(C0349R.id.equalizer2));
        this.f17203a.add((TextView) inflate.findViewById(C0349R.id.equalizer3));
        this.f17203a.add((TextView) inflate.findViewById(C0349R.id.equalizer4));
        this.f17203a.add((TextView) inflate.findViewById(C0349R.id.equalizer5));
        this.f17203a.add((TextView) inflate.findViewById(C0349R.id.equalizer6));
        this.f17203a.add((TextView) inflate.findViewById(C0349R.id.equalizer7));
        for (TextView onClickListener : this.f17203a) {
            onClickListener.setOnClickListener(this.f17206d);
        }
        this.f17204b.clear();
        this.f17204b.addAll(fum.m20996a().m21011d().subList(0, 6));
    }

    public gky m26819a(int i) {
        return (gky) this.f17204b.get(i);
    }

    public void m26821a(gky com_ushareit_listenit_gky) {
        for (gky a : this.f17204b) {
            a.m22269a(false);
        }
        com_ushareit_listenit_gky.m22269a(true);
        if (!this.f17204b.contains(com_ushareit_listenit_gky)) {
            if (this.f17204b.size() <= 6) {
                this.f17204b.add(com_ushareit_listenit_gky);
            } else {
                this.f17204b.set(6, com_ushareit_listenit_gky);
            }
        }
        m26815b();
    }

    public void m26820a() {
        m26816b(0);
    }

    public void setEnabled(boolean z) {
        TextView textView;
        super.setEnabled(z);
        int i = 0;
        while (i < this.f17204b.size()) {
            textView = (TextView) this.f17203a.get(i);
            textView.setEnabled(z);
            setButtonStyle(textView, ((gky) this.f17204b.get(i)).m22270a());
            i++;
        }
        textView = (TextView) this.f17203a.get(i);
        textView.setEnabled(z);
        setButtonStyle(textView, false);
    }

    private void m26816b(int i) {
        for (gky a : this.f17204b) {
            a.m22269a(false);
        }
        ((gky) this.f17204b.get(i)).m22269a(true);
        m26815b();
    }

    private void m26815b() {
        int i = 0;
        while (i < this.f17204b.size()) {
            gky com_ushareit_listenit_gky = (gky) this.f17204b.get(i);
            TextView textView = (TextView) this.f17203a.get(i);
            textView.setTextSize(0, getResources().getDimension(C0349R.dimen.common_dimens_12sp));
            textView.setText(com_ushareit_listenit_gky.m22273c());
            textView.setVisibility(0);
            textView.setTag(Integer.valueOf(i));
            setButtonStyle(textView, com_ushareit_listenit_gky.m22270a());
            i++;
        }
        TextView textView2 = (TextView) this.f17203a.get(i);
        textView2.setTextSize(0, getResources().getDimension(C0349R.dimen.common_dimens_4sp));
        textView2.setText(getResources().getString(C0349R.string.equalizer_default_item_more));
        textView2.setTag(Integer.valueOf(i));
        textView2.setVisibility(0);
        for (int i2 = i + 1; i2 < this.f17203a.size(); i2++) {
            ((TextView) this.f17203a.get(i2)).setVisibility(4);
        }
    }

    private void setButtonStyle(TextView textView, boolean z) {
        if (!z) {
            textView.setTextColor(getResources().getColorStateList(C0349R.color.equalizer_default_item_text_colors));
            textView.setBackgroundDrawable(getResources().getDrawable(C0349R.drawable.equalizer_default_item_bg));
        } else if (isEnabled()) {
            textView.setTextColor(getResources().getColor(C0349R.color.common_text_color_white));
            textView.setBackgroundDrawable(getResources().getDrawable(C0349R.drawable.equalizer_item_selected_bg));
        } else {
            textView.setTextColor(getResources().getColor(C0349R.color.equalizer_gray_text));
            textView.setBackgroundDrawable(getResources().getDrawable(C0349R.drawable.equalizer_disabled_item_bg));
        }
    }
}
