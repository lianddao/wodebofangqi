package com.ushareit.listenit.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.ushareit.listenit.C0349R;
import com.ushareit.listenit.ListenItApp;
import com.ushareit.listenit.epu;
import com.ushareit.listenit.fbb;
import com.ushareit.listenit.gyn;
import com.ushareit.listenit.gzd;
import com.ushareit.listenit.hec;
import com.ushareit.listenit.hed;

public class ViewPagerTabBar extends FrameLayout {
    private HorizontalScrollView f17406a;
    private LinearLayout f17407b;
    private View f17408c;
    private int f17409d;
    private int f17410e;
    private hed f17411f;

    public ViewPagerTabBar(Context context) {
        super(context);
        m27018a(context);
    }

    public ViewPagerTabBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m27018a(context);
    }

    public ViewPagerTabBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m27018a(context);
    }

    private void m27018a(Context context) {
        View.inflate(context, C0349R.layout.main_song_fragment_viewpager_titlebar, this);
        this.f17406a = (HorizontalScrollView) findViewById(C0349R.id.scrollview);
        this.f17407b = (LinearLayout) findViewById(C0349R.id.titles);
        this.f17408c = findViewById(C0349R.id.indicator);
        this.f17409d = (int) getContext().getResources().getDimension(C0349R.dimen.common_dimens_80dp);
        this.f17410e = this.f17409d;
    }

    public void setOnTabClickListener(hed com_ushareit_listenit_hed) {
        this.f17411f = com_ushareit_listenit_hed;
    }

    public int getTabSize() {
        return this.f17407b == null ? -1 : this.f17407b.getChildCount();
    }

    public void m27023a(String str) {
        View inflate = View.inflate(getContext(), C0349R.layout.main_song_fragment_viewpager_titlebar_tab, null);
        ((TextView) inflate.findViewById(C0349R.id.title)).setText(str);
        inflate.setBackgroundColor(0);
        this.f17407b.addView(inflate, -2, -1);
        m27017a();
        inflate.setOnClickListener(new hec(this, this.f17407b.getChildCount() - 1));
    }

    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        m27017a();
    }

    private void m27017a() {
        int childCount = this.f17407b.getChildCount();
        int a = m27015a(this.f17407b.getChildCount());
        for (int i = 0; i < childCount; i++) {
            gyn.m23213b(this.f17407b.getChildAt(i), a);
        }
    }

    private int m27015a(int i) {
        int c = fbb.m18762c(getContext());
        this.f17410e = this.f17409d * i > c ? this.f17409d : c / i;
        return this.f17410e;
    }

    public void m27022a(int i, float f) {
        m27019b(i, f);
        m27020c(i, f);
        m27021d(i, f);
    }

    private void m27019b(int i, float f) {
        int width = this.f17407b.getChildAt(i).getWidth();
        float f2 = ((float) width) * f;
        this.f17406a.smoothScrollTo((int) ((f2 + ((float) this.f17407b.getChildAt(i).getLeft())) - ((float) ((fbb.m18762c(getContext()) - width) / 2))), 0);
    }

    private void m27020c(int i, float f) {
        int color;
        int color2;
        int i2 = i + 1;
        epu com_ushareit_listenit_epu = new epu();
        switch (((ListenItApp) getContext().getApplicationContext()).m4934b()) {
            case 1:
                color = getResources().getColor(C0349R.color.common_text_color_black_night);
                color2 = getResources().getColor(C0349R.color.viewpager_title_text_color_night);
                break;
            case 2:
                color = getResources().getColor(C0349R.color.common_text_color_black);
                color2 = gzd.m23358b();
                break;
            default:
                color = getResources().getColor(C0349R.color.common_text_color_black);
                color2 = getResources().getColor(C0349R.color.viewpager_title_text_color);
                break;
        }
        int intValue = ((Integer) com_ushareit_listenit_epu.mo2240a(f, Integer.valueOf(color2), Integer.valueOf(color))).intValue();
        int intValue2 = ((Integer) com_ushareit_listenit_epu.mo2240a(f, Integer.valueOf(color), Integer.valueOf(color2))).intValue();
        int childCount = this.f17407b.getChildCount();
        for (color2 = 0; color2 < childCount; color2++) {
            ((TextView) this.f17407b.getChildAt(color2).findViewById(C0349R.id.title)).setTextColor(color);
        }
        ((TextView) this.f17407b.getChildAt(i).findViewById(C0349R.id.title)).setTextColor(intValue);
        if (i2 < this.f17407b.getChildCount() && i2 >= 0) {
            ((TextView) this.f17407b.getChildAt(i2).findViewById(C0349R.id.title)).setTextColor(intValue2);
        }
    }

    private void m27021d(int i, float f) {
        View childAt = this.f17407b.getChildAt(i);
        gyn.m23231d(this.f17408c, (int) (((float) childAt.getLeft()) + (((float) childAt.getWidth()) * f)));
        gyn.m23213b(this.f17408c, childAt.getWidth());
        this.f17408c.setVisibility(0);
    }
}
