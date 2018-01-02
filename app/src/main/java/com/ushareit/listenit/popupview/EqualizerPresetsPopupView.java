package com.ushareit.listenit.popupview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import com.ushareit.listenit.C0349R;
import com.ushareit.listenit.fbb;
import com.ushareit.listenit.fdp;
import com.ushareit.listenit.fdr;
import com.ushareit.listenit.fum;
import com.ushareit.listenit.gky;
import com.ushareit.listenit.gla;
import com.ushareit.listenit.gpc;
import com.ushareit.listenit.gpd;
import com.ushareit.listenit.gyn;
import java.util.ArrayList;
import java.util.List;

public class EqualizerPresetsPopupView extends BasePopupView {
    private GridView f16191a;
    private gpd f16192b;
    private List<gky> f16193c = new ArrayList();
    private fdp f16194d;
    private fdr f16195e = new gpc(this);

    public EqualizerPresetsPopupView(Context context) {
        super(context);
        m25585a(context, this);
    }

    public void m25585a(Context context, ViewGroup viewGroup) {
        this.f16191a = (GridView) View.inflate(context, C0349R.layout.popup_view_equalizer_presets, viewGroup).findViewById(C0349R.id.grid_view);
        this.f16193c = fum.m20996a().m21011d();
        this.f16194d = new fdp(context);
        this.f16194d.m18910a(this.f16193c);
        this.f16191a.setAdapter(this.f16194d);
        this.f16194d.m18909a(this.f16195e);
    }

    public void setOnEqualizerPresetSelectListener(gpd com_ushareit_listenit_gpd) {
        this.f16192b = com_ushareit_listenit_gpd;
    }

    public gky m25584a(int i) {
        return (gky) this.f16193c.get(i);
    }

    protected void onMeasure(int i, int i2) {
        gyn.m23224c(this.f16191a, (int) (((float) fbb.m18764d(getContext())) * 0.7f));
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
