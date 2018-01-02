package com.ushareit.listenit.popupview;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import com.ushareit.listenit.C0349R;
import com.ushareit.listenit.fbb;
import com.ushareit.listenit.fee;
import com.ushareit.listenit.gla;
import com.ushareit.listenit.grd;
import com.ushareit.listenit.gre;
import com.ushareit.listenit.gum;
import com.ushareit.listenit.gxl;
import com.ushareit.listenit.gyn;
import com.ushareit.listenit.hhx;
import java.util.ArrayList;
import java.util.List;

public class SharePopupView extends BasePopupView {
    private List<gxl> f16273a = new ArrayList();
    private GridView f16274b;
    private View f16275c;
    private fee f16276d;
    private Intent f16277e;
    private int f16278f;
    private boolean f16279g = false;
    private int f16280h;
    private OnItemClickListener f16281i = new gre(this);

    public SharePopupView(Context context, Intent intent, int i, int i2) {
        super(context);
        this.f16277e = intent;
        this.f16278f = i;
        this.f16280h = i2;
        m25654a(context, (ViewGroup) this);
    }

    public void m25654a(Context context, ViewGroup viewGroup) {
        View inflate = View.inflate(context, C0349R.layout.popup_view_share, viewGroup);
        this.f16274b = (GridView) inflate.findViewById(C0349R.id.grid_view);
        this.f16275c = inflate.findViewById(C0349R.id.progress_view);
        this.f16276d = new fee();
        this.f16274b.setAdapter(this.f16276d);
        this.f16274b.setOnItemClickListener(this.f16281i);
    }

    public void mo2995a(gum com_ushareit_listenit_gum) {
        super.mo2995a(com_ushareit_listenit_gum);
    }

    private void m25647a() {
        hhx.m23867a(new grd(this));
    }

    public void mo2996b() {
        if (!this.f16279g) {
            this.f16279g = true;
            m25647a();
        }
        super.mo2996b();
    }

    public void mo2997c() {
        super.mo2997c();
    }

    protected void onMeasure(int i, int i2) {
        gyn.m23224c(this.f16274b, (int) (((float) fbb.m18764d(getContext())) * 0.55f));
        super.onMeasure(i, i2);
    }

    public int getGravity() {
        return 17;
    }

    public void setItem(gla com_ushareit_listenit_gla) {
    }

    public void setTitle(String str) {
    }
}
