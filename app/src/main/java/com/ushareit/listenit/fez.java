package com.ushareit.listenit;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.FrameLayout;
import com.ushareit.listenit.main.MainActivity;
import java.util.List;

public class fez implements fev {
    public static boolean f12566a = false;
    private Context f12567b;
    private FrameLayout f12568c;
    private FrameLayout f12569d;
    private List<fji> f12570e;
    private boolean f12571f = true;
    private boolean f12572g = false;
    private int f12573h = gyr.m23307a(51.0f);
    private int f12574i = gyr.m23307a(55.0f);

    public fez(Context context, List<fji> list) {
        this.f12567b = context;
        this.f12570e = list;
    }

    public void m19067a(View view) {
        this.f12568c = (FrameLayout) view.findViewById(C0349R.id.mini_player_container);
        this.f12569d = (FrameLayout) view.findViewById(C0349R.id.ad_container);
    }

    public void m19069b() {
        if (!this.f12572g && fem.m18975f()) {
            this.f12572g = true;
            m19070c();
        }
    }

    public void m19070c() {
        fet.m19036f(this.f12567b, new ffa(this, 30000));
    }

    private void m19063e() {
        for (fji d : this.f12570e) {
            d.mo2607d();
        }
    }

    private void m19065f() {
        eqy b = eqy.m17367b(this.f12573h, 0);
        b.mo2252c(500);
        b.m17274a(new ffd(this));
        b.m17384a(new ffe(this));
        b.mo2234a();
    }

    public void mo2365a() {
        this.f12571f = true;
        m19065f();
    }

    public static void m19058a(ViewGroup viewGroup, int i) {
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) viewGroup.getLayoutParams();
        marginLayoutParams.bottomMargin = i;
        viewGroup.setLayoutParams(marginLayoutParams);
    }

    public static fez m19056a(Context context) {
        return ((MainActivity) context).m24833j();
    }

    public static void m19057a(Context context, ViewGroup viewGroup) {
        if (context != null && (context instanceof MainActivity)) {
            m19056a(context).m19068a(viewGroup);
        }
    }

    public void m19068a(ViewGroup viewGroup) {
        int i;
        if (this.f12571f) {
            i = this.f12574i;
        } else {
            i = this.f12574i + this.f12573h;
        }
        m19058a(viewGroup, i);
    }

    public void m19071d() {
        if (f12566a) {
            this.f12571f = true;
            this.f12569d.removeAllViews();
            m19058a(this.f12568c, 0);
            m19063e();
            f12566a = false;
        }
    }
}
