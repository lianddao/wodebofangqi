package com.ushareit.listenit.theme;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import com.mopub.volley.DefaultRetryPolicy;
import com.ushareit.listenit.C0349R;
import com.ushareit.listenit.fbb;
import com.ushareit.listenit.fii;
import com.ushareit.listenit.fjt;
import com.ushareit.listenit.gvj;
import com.ushareit.listenit.gwz;
import com.ushareit.listenit.gxa;
import com.ushareit.listenit.gxb;
import com.ushareit.listenit.gxc;
import com.ushareit.listenit.gxd;
import com.ushareit.listenit.gxe;
import com.ushareit.listenit.gxf;
import com.ushareit.listenit.gxg;
import com.ushareit.listenit.gxh;
import com.ushareit.listenit.gxj;
import com.ushareit.listenit.gyn;
import com.ushareit.listenit.gzc;
import com.ushareit.listenit.gzd;
import com.ushareit.listenit.hbk;
import com.ushareit.listenit.hhe;
import com.ushareit.listenit.widget.ColorPicker;
import java.util.ArrayList;
import java.util.List;

public class ThemeSettingsActivity extends fjt {
    private View f16589A;
    private View f16590B;
    private View f16591C;
    private ImageView f16592D;
    private View f16593E;
    private ImageView f16594F;
    private ImageView f16595G;
    private View f16596H;
    private int f16597I;
    private int f16598J;
    private OnClickListener f16599K = new gxb(this);
    private OnClickListener f16600L = new gxc(this);
    private OnClickListener f16601M = new gxd(this);
    private OnClickListener f16602N = new gxe(this);
    private hbk f16603O = new gxf(this);
    private OnClickListener f16604P = new gxg(this);
    private OnClickListener f16605Q = new gxh(this);
    private LinearLayout f16606n;
    private List<View> f16607o = new ArrayList();
    private List<Integer> f16608p = new ArrayList();
    private View f16609q;
    private View f16610r;
    private View f16611s;
    private int f16612t;
    private ColorPicker f16613y;
    private boolean f16614z = false;

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C0349R.layout.theme_setting_activity);
        m26299q();
        m26304v();
        m26291h();
        m26294j();
        m26300r();
        this.f16613y.post(new gwz(this));
        this.f16593E.post(new gxa(this));
        m26298p();
    }

    private void m26291h() {
        this.f16612t = gxj.m23083a(this);
        this.f16597I = gvj.ac(this);
        this.f16598J = this.f16597I;
    }

    private void m26294j() {
        int b = gzd.m23358b();
        gzc.m23346b(this, b);
        this.f16596H.setBackgroundColor(b);
        if (gyn.m23217b()) {
            gyn.m23237e(this.f16591C, fbb.m18766e(this));
        }
    }

    private void m26298p() {
        this.f16589A.setOnClickListener(this.f16604P);
        this.f16590B.setOnClickListener(this.f16605Q);
        this.f16611s.setOnClickListener(this.f16602N);
        this.f16613y.setOnColorChangedListener(this.f16603O);
    }

    public boolean mo540i() {
        return false;
    }

    private void m26299q() {
        this.f16608p.clear();
        for (String parseColor : getResources().getStringArray(C0349R.array.theme_color)) {
            this.f16608p.add(Integer.valueOf(Color.parseColor(parseColor)));
        }
    }

    private void m26300r() {
        LayoutParams layoutParams = new LayoutParams(-2, getResources().getDimensionPixelSize(C0349R.dimen.common_dimens_90dp));
        this.f16606n.addView(m26278a(C0349R.drawable.about_icon, 0, layoutParams, 1));
        int size = this.f16608p.size();
        int i = 0;
        while (i < size) {
            this.f16606n.addView(m26278a(((Integer) this.f16608p.get(i)).intValue(), i + 1, layoutParams, 2));
            i++;
        }
        this.f16606n.addView(m26278a(C0349R.drawable.any_color_item, i + 1, layoutParams, 3));
    }

    private void m26301s() {
        if (this.f16597I == gzd.m23368g()) {
            m26303u();
            ((View) this.f16607o.get(0)).setVisibility(0);
            return;
        }
        int size = this.f16608p.size();
        for (int i = 0; i < size; i++) {
            if (this.f16597I == ((Integer) this.f16608p.get(i)).intValue()) {
                ((View) this.f16607o.get(i + 1)).setVisibility(0);
                return;
            }
        }
        ((View) this.f16607o.get(this.f16607o.size() - 1)).setVisibility(0);
        this.f16613y.setColor(this.f16597I);
    }

    private void m26302t() {
        int measuredHeight = this.f16593E.getMeasuredHeight();
        float intrinsicWidth = (((float) this.f16592D.getDrawable().getIntrinsicWidth()) * DefaultRetryPolicy.DEFAULT_BACKOFF_MULT) / ((float) this.f16592D.getDrawable().getIntrinsicHeight());
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f16592D.getLayoutParams();
        layoutParams.height = measuredHeight - (getResources().getDimensionPixelSize(C0349R.dimen.common_dimens_25dp) * 2);
        layoutParams.width = (int) (((float) layoutParams.height) * intrinsicWidth);
        this.f16592D.setLayoutParams(layoutParams);
        this.f16592D.setBackgroundColor(this.f16598J);
        m26279a(layoutParams.width, layoutParams.height, (fbb.m18762c((Context) this) - layoutParams.width) / 2);
    }

    private void m26279a(int i, int i2, int i3) {
        int i4 = i3 + ((int) (((double) i) * 0.033d));
        int i5 = (int) (((double) i2) * 0.14d);
        int i6 = (int) (((double) i) * 0.1875d);
        int i7 = (int) (((((float) i6) * DefaultRetryPolicy.DEFAULT_BACKOFF_MULT) / 90.0f) * 71.0f);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f16594F.getLayoutParams();
        layoutParams.height = i7;
        layoutParams.width = i6;
        layoutParams.leftMargin = i4;
        layoutParams.topMargin = i5;
        this.f16594F.setLayoutParams(layoutParams);
        this.f16594F.setBackgroundDrawable(gzd.m23356a(this.f16598J));
        layoutParams = (RelativeLayout.LayoutParams) this.f16595G.getLayoutParams();
        layoutParams.height = (int) (((double) i7) * 0.14d);
        layoutParams.width = (int) (((double) i6) * 0.76d);
        layoutParams.leftMargin = i4;
        layoutParams.topMargin = i5 + i7;
        this.f16595G.setLayoutParams(layoutParams);
        this.f16595G.setBackgroundColor(this.f16598J);
    }

    private void m26303u() {
        for (View visibility : this.f16607o) {
            visibility.setVisibility(4);
        }
    }

    private void m26304v() {
        this.f16609q = findViewById(C0349R.id.template_color_panel);
        this.f16606n = (LinearLayout) findViewById(C0349R.id.theme_color_list);
        this.f16610r = findViewById(C0349R.id.any_color_panel);
        this.f16611s = findViewById(C0349R.id.any_color_panel_back);
        this.f16613y = (ColorPicker) findViewById(C0349R.id.color_picker);
        this.f16589A = findViewById(C0349R.id.btn_back);
        this.f16590B = findViewById(C0349R.id.btn_confirm);
        this.f16591C = findViewById(C0349R.id.action_bar);
        this.f16596H = findViewById(C0349R.id.actionbar_bg);
        this.f16593E = findViewById(C0349R.id.theme_content_view);
        this.f16592D = (ImageView) findViewById(C0349R.id.theme_preview);
        this.f16594F = (ImageView) findViewById(C0349R.id.theme_preview_album);
        this.f16595G = (ImageView) findViewById(C0349R.id.theme_preview_shadow);
    }

    private View m26278a(int i, int i2, LayoutParams layoutParams, int i3) {
        View inflate = View.inflate(this, C0349R.layout.color_panel_item, null);
        ImageView imageView = (ImageView) inflate.findViewById(C0349R.id.setting_color_item);
        ImageView imageView2 = (ImageView) inflate.findViewById(C0349R.id.setting_color_item_selected);
        inflate.setTag(Integer.valueOf(i2));
        inflate.setLayoutParams(layoutParams);
        imageView2.setBackgroundDrawable(hhe.m23348a(imageView2.getBackground(), this.f16597I));
        this.f16607o.add(imageView2);
        switch (i3) {
            case 1:
                inflate.setOnClickListener(this.f16599K);
                imageView.setImageResource(C0349R.drawable.default_theme_item);
                break;
            case 2:
                inflate.setOnClickListener(this.f16600L);
                imageView.setImageDrawable(new ColorDrawable(i));
                break;
            case 3:
                inflate.setOnClickListener(this.f16601M);
                imageView.setImageResource(i);
                break;
        }
        return inflate;
    }

    private void m26305w() {
        this.f16592D.setBackgroundColor(this.f16598J);
        this.f16594F.setBackgroundDrawable(gzd.m23356a(this.f16598J));
        this.f16595G.setBackgroundColor(this.f16598J);
    }

    private void m26284c(int i) {
        int indexOf = this.f16608p.indexOf(Integer.valueOf(i));
        indexOf = indexOf == -1 ? i == gzd.m23368g() ? 0 : this.f16608p.size() + 1 : indexOf + 1;
        fii.m19310c((Context) this, indexOf);
    }
}
