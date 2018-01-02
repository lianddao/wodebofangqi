package com.ushareit.listenit.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.mopub.volley.DefaultRetryPolicy;
import com.ushareit.listenit.C0349R;
import com.ushareit.listenit.erj;
import com.ushareit.listenit.fbb;
import com.ushareit.listenit.fjw;
import com.ushareit.listenit.gal;
import com.ushareit.listenit.gyn;
import com.ushareit.listenit.hbi;

public class ActionBarView extends FrameLayout {
    private View f17127a;
    private View f17128b;
    private ImageView f17129c;
    private TextView f17130d;
    private ImageView f17131e;
    private TextView f17132f;
    private View f17133g;
    private gal f17134h;
    private View f17135i;
    private View f17136j;
    private fjw f17137k = new hbi(this);

    public ActionBarView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m26786a(context);
    }

    public ActionBarView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m26786a(context);
    }

    public ActionBarView(Context context) {
        super(context);
        m26786a(context);
    }

    private void m26786a(Context context) {
        View inflate = View.inflate(context, C0349R.layout.action_bar_view, this);
        if (inflate != null) {
            this.f17127a = inflate.findViewById(C0349R.id.actionbar_bg);
            this.f17128b = inflate.findViewById(C0349R.id.actionbar_content);
            this.f17129c = (ImageView) inflate.findViewById(C0349R.id.home);
            this.f17130d = (TextView) inflate.findViewById(C0349R.id.title);
            this.f17131e = (ImageView) inflate.findViewById(C0349R.id.search);
            this.f17132f = (TextView) inflate.findViewById(C0349R.id.select_all);
            this.f17133g = inflate.findViewById(C0349R.id.app_logo);
            this.f17135i = inflate.findViewById(C0349R.id.action_bar_red_point);
            this.f17136j = inflate.findViewById(C0349R.id.partner_logo);
            if (gyn.m23217b()) {
                int e = fbb.m18766e(getContext());
                gyn.m23237e(this.f17128b, e);
                gyn.m23224c(this.f17127a, e + ((int) (((double) getResources().getDimension(C0349R.dimen.common_dimens_50dp)) + 0.5d)));
            }
        }
    }

    public boolean m26789a() {
        return false;
    }

    public void setHomeIcon(int i) {
        this.f17129c.setImageResource(i);
    }

    public void setHomeVisibility(int i) {
        this.f17129c.setVisibility(i);
    }

    public void setTitle(int i) {
        this.f17130d.setText(getResources().getString(i));
    }

    public void setTitle(String str) {
        this.f17130d.setText(str);
    }

    public void setSearchVisibility(int i) {
        if (i == 0) {
            this.f17131e.setVisibility(0);
            this.f17131e.setOnClickListener(this.f17137k);
            return;
        }
        this.f17131e.setVisibility(8);
        this.f17131e.setOnClickListener(null);
    }

    public void setPartnerLogoVisibility(int i) {
        this.f17136j.setVisibility(i);
    }

    public void setListParams(gal com_ushareit_listenit_gal) {
        this.f17134h = com_ushareit_listenit_gal;
    }

    public void setSearchIconColor(boolean z) {
        if (z) {
            this.f17131e.setImageResource(C0349R.drawable.actionbar_search_bg_white);
        }
    }

    public void setSelectAllVisibility(int i) {
        if (i == 0) {
            this.f17132f.setVisibility(0);
        } else {
            this.f17132f.setVisibility(8);
        }
    }

    public void setAppLogoVisibility(int i) {
        this.f17133g.setVisibility(i);
    }

    public void m26788a(String str, int i, int i2) {
        boolean z;
        this.f17132f.setVisibility(0);
        int i3 = (i != i2 || i2 == 0) ? C0349R.string.actionbar_view_select_all : C0349R.string.actionbar_view_unselect_all;
        this.f17132f.setText(getContext().getString(i3));
        TextView textView = this.f17132f;
        if (i2 != 0) {
            z = true;
        } else {
            z = false;
        }
        textView.setEnabled(z);
        this.f17130d.setText(str);
    }

    public int getActionBarHeight() {
        return getHeight();
    }

    public void m26787a(float f) {
        erj.m17570a(this.f17127a, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT - f);
    }

    public void setOnHomeClickListener(OnClickListener onClickListener) {
        this.f17129c.setOnClickListener(onClickListener);
    }

    public void setOnSelectAllClickListener(OnClickListener onClickListener) {
        this.f17132f.setOnClickListener(onClickListener);
    }
}
