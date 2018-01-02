package com.ushareit.listenit.main.navigation;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.ushareit.listenit.C0349R;
import com.ushareit.listenit.fhy;
import com.ushareit.listenit.fir;
import com.ushareit.listenit.fkb;
import com.ushareit.listenit.fkp;
import com.ushareit.listenit.fqk;
import com.ushareit.listenit.fxp;
import com.ushareit.listenit.gef;
import com.ushareit.listenit.gjg;
import com.ushareit.listenit.gjh;
import com.ushareit.listenit.gji;
import com.ushareit.listenit.gjj;
import com.ushareit.listenit.gjk;
import com.ushareit.listenit.gjl;
import com.ushareit.listenit.gjm;
import com.ushareit.listenit.gjn;
import com.ushareit.listenit.gjo;
import com.ushareit.listenit.gjp;
import com.ushareit.listenit.gjq;
import com.ushareit.listenit.gjr;
import com.ushareit.listenit.gjs;
import com.ushareit.listenit.gjt;
import com.ushareit.listenit.gju;
import com.ushareit.listenit.gvj;
import com.ushareit.listenit.gwk;
import com.ushareit.listenit.gwm;
import com.ushareit.listenit.gyn;
import com.ushareit.listenit.of;
import com.ushareit.listenit.theme.entry.CustomThemeLinearLayout;

public class NavigationView extends FrameLayout {
    public TextView f15917a;
    public CustomThemeLinearLayout f15918b;
    private Context f15919c;
    private View f15920d;
    private TextView f15921e;
    private ImageView f15922f;
    private TextView f15923g;
    private View f15924h;
    private View f15925i;
    private gju f15926j;
    private OnClickListener f15927k;
    private OnClickListener f15928l = new gjg(this);
    private OnClickListener f15929m = new gjm(this);
    private OnClickListener f15930n = new gjn(this);
    private OnClickListener f15931o = new gjo(this);
    private OnClickListener f15932p = new gjp(this);
    private OnClickListener f15933q = new gjq(this);
    private OnClickListener f15934r = new gjr(this);
    private OnClickListener f15935s = new gjs(this);
    private OnClickListener f15936t = new gjt(this);
    private OnClickListener f15937u = new gjh(this);
    private OnClickListener f15938v = new gji(this);
    private of f15939w = new gjj(this);
    private gwm f15940x = new gjk(this);
    private fkp f15941y = new gjl(this);

    public NavigationView(Context context) {
        super(context);
        m24865a(context);
    }

    public NavigationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m24865a(context);
    }

    public NavigationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m24865a(context);
    }

    public void m24865a(Context context) {
        this.f15919c = context;
        View inflate = View.inflate(this.f15919c, C0349R.layout.main_navigation_view, this);
        if (inflate != null) {
            if (fhy.m19213a()) {
                ((TextView) inflate.findViewById(C0349R.id.nearby_option_text)).setText(C0349R.string.nearby_guide_open_nearby_button_b);
            }
            View findViewById = inflate.findViewById(C0349R.id.equalizer);
            if (gyn.m23226c()) {
                findViewById.setVisibility(0);
                findViewById.setOnClickListener(this.f15930n);
            } else {
                findViewById.setVisibility(8);
            }
            inflate.findViewById(C0349R.id.sleep).setOnClickListener(this.f15931o);
            inflate.findViewById(C0349R.id.rateus).setOnClickListener(this.f15932p);
            inflate.findViewById(C0349R.id.setting).setOnClickListener(this.f15933q);
            inflate.findViewById(C0349R.id.invite_frd).setOnClickListener(this.f15934r);
            inflate.findViewById(C0349R.id.audio_cutter).setOnClickListener(this.f15935s);
            inflate.findViewById(C0349R.id.theme_setting).setOnClickListener(this.f15937u);
            inflate.findViewById(C0349R.id.night_mode).setOnClickListener(this.f15938v);
            this.f15917a = (TextView) inflate.findViewById(C0349R.id.navigation_countdown);
            this.f15918b = (CustomThemeLinearLayout) inflate.findViewById(C0349R.id.sleep_wrapper);
            this.f15920d = inflate.findViewById(C0349R.id.navigation_login_button);
            this.f15921e = (TextView) inflate.findViewById(C0349R.id.navigation_login_slogan);
            this.f15922f = (ImageView) inflate.findViewById(C0349R.id.navigation_head_photo);
            this.f15923g = (TextView) inflate.findViewById(C0349R.id.navigation_user_name);
            this.f15924h = inflate.findViewById(C0349R.id.nearbyList);
            this.f15925i = inflate.findViewById(C0349R.id.navigation_nearby_red_point);
            findViewById = inflate.findViewById(C0349R.id.listenit_word_login);
            gwk.m23063a().m23072a(this.f15940x);
            if (fqk.m20375a()) {
                findViewById.setVisibility(8);
                this.f15920d.setVisibility(0);
                this.f15921e.setVisibility(0);
                this.f15920d.setOnClickListener(this.f15929m);
                inflate.findViewById(C0349R.id.header_view).setOnClickListener(this.f15928l);
            } else {
                findViewById.setVisibility(0);
                this.f15920d.setVisibility(8);
                this.f15921e.setVisibility(8);
            }
            if (fqk.m20381g()) {
                this.f15924h.setOnClickListener(this.f15936t);
                if (gvj.aq(context)) {
                    this.f15925i.setVisibility(0);
                }
                fir.m19380b();
            } else {
                this.f15924h.setVisibility(8);
            }
            fkb.m19610a().m19640a(this.f15941y);
        }
    }

    protected void onDetachedFromWindow() {
        fkb.m19610a().m19644b(this.f15941y);
        super.onDetachedFromWindow();
    }

    public void m24864a() {
        if (gwk.m23063a().m23078f()) {
            m24858d();
        }
    }

    public void m24866b() {
        if (!fqk.m20375a()) {
            return;
        }
        if (gef.m21805a().m21835e()) {
            this.f15921e.setVisibility(8);
            this.f15920d.setVisibility(8);
            this.f15922f.setVisibility(0);
            Bitmap i = gyn.m23247i();
            if (i != null) {
                this.f15922f.setImageBitmap(i);
            } else {
                this.f15922f.setImageResource(C0349R.drawable.profile_photo_default);
            }
            this.f15923g.setVisibility(0);
            this.f15923g.setText(gef.m21805a().m21836f());
            return;
        }
        this.f15920d.setVisibility(0);
        this.f15921e.setVisibility(0);
        setSloganText();
        this.f15922f.setVisibility(8);
        this.f15923g.setVisibility(8);
    }

    private void setSloganText() {
        switch ((int) (Math.random() * 5.0d)) {
            case 0:
                this.f15921e.setText(this.f15919c.getString(C0349R.string.login_bar_slogan));
                return;
            case 1:
                this.f15921e.setText(this.f15919c.getString(C0349R.string.login_bar_slogan2));
                return;
            case 2:
                this.f15921e.setText(this.f15919c.getString(C0349R.string.login_bar_slogan3));
                return;
            case 3:
                this.f15921e.setText(this.f15919c.getString(C0349R.string.login_bar_slogan4));
                return;
            case 4:
                this.f15921e.setText(this.f15919c.getString(C0349R.string.login_bar_slogan5));
                return;
            default:
                return;
        }
    }

    public void setMainFragment(fxp com_ushareit_listenit_fxp) {
        com_ushareit_listenit_fxp.m21289a(this.f15939w);
    }

    public Rect getRectOfNearbyItem() {
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(C0349R.dimen.common_dimens_179dp);
        return new Rect(this.f15924h.getLeft(), this.f15924h.getTop() + dimensionPixelOffset, this.f15924h.getRight(), dimensionPixelOffset + this.f15924h.getBottom());
    }

    public void setNearbyClickListener(gju com_ushareit_listenit_gju) {
        this.f15926j = com_ushareit_listenit_gju;
    }

    public void m24867c() {
        this.f15926j = null;
    }

    public void setNightModeClickListener(OnClickListener onClickListener) {
        this.f15927k = onClickListener;
    }

    private void m24853a(Intent intent) {
        try {
            getContext().startActivity(intent);
        } catch (ActivityNotFoundException e) {
        }
    }

    private void m24858d() {
        this.f15917a.setText(gwk.m23063a().m23077e());
        this.f15917a.setTextSize(0, (float) getResources().getDimensionPixelSize(C0349R.dimen.common_dimens_15sp));
        this.f15918b.setBackgroundResource(C0349R.drawable.navigation_sleep_countdown_bg, C0349R.drawable.navigation_sleep_countdown_bg_night);
    }

    private void m24859e() {
        if (this.f15917a != null) {
            this.f15917a.setText(C0349R.string.sleep_mode);
            this.f15917a.setTextSize(0, this.f15919c.getResources().getDimension(C0349R.dimen.common_dimens_14sp));
            this.f15918b.setBackgroundColor(0);
        }
    }
}
