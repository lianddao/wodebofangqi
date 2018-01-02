package com.ushareit.listenit.nearby.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.ushareit.listenit.C0349R;
import com.ushareit.listenit.erj;
import com.ushareit.listenit.fni;
import com.ushareit.listenit.gna;
import com.ushareit.listenit.gzd;
import com.ushareit.listenit.hhe;

public class NoLoginUserView extends LinearLayout {
    private ImageView f16026a;
    private TextView f16027b;
    private TextView f16028c;
    private TextView f16029d;
    private OnTouchListener f16030e = new gna(this);

    public NoLoginUserView(Context context) {
        super(context);
        m25210a(context);
    }

    public NoLoginUserView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m25210a(context);
    }

    private void m25210a(Context context) {
        Drawable drawable = getResources().getDrawable(C0349R.drawable.no_login_user_bg);
        if (gzd.m23364e() == 1) {
            drawable = hhe.m23348a(drawable, getResources().getColor(C0349R.color.common_text_color_gray_night));
        } else {
            drawable = hhe.m23347a(drawable);
        }
        setBackgroundDrawable(drawable);
        setPadding(m25209a(context, C0349R.dimen.common_dimens_22dp), m25209a(context, C0349R.dimen.common_dimens_19dp), m25209a(context, C0349R.dimen.common_dimens_22dp), 0);
        setOrientation(0);
        View.inflate(context, C0349R.layout.round_rect_view, this);
        setOnTouchListener(this.f16030e);
        this.f16026a = (ImageView) findViewById(C0349R.id.icon);
        this.f16027b = (TextView) findViewById(C0349R.id.title);
        this.f16028c = (TextView) findViewById(C0349R.id.sub_title2);
        this.f16029d = (TextView) findViewById(C0349R.id.sub_title3);
    }

    public void setData(fni com_ushareit_listenit_fni, float f) {
        if (com_ushareit_listenit_fni != null) {
            this.f16026a.setImageResource(Integer.parseInt(com_ushareit_listenit_fni.getId()));
            this.f16027b.setText(com_ushareit_listenit_fni.getNm());
            this.f16028c.setText(com_ushareit_listenit_fni.getPlN() + "");
            this.f16029d.setText(com_ushareit_listenit_fni.getSgN() + "");
            setScaleValue(f);
        }
    }

    public void setScaleValue(float f) {
        erj.m17572c(this, f);
        erj.m17573d(this, f);
    }

    private int m25209a(Context context, int i) {
        return (int) context.getResources().getDimension(i);
    }
}
