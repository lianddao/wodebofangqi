package com.ushareit.listenit.popupview;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.ushareit.listenit.C0349R;
import com.ushareit.listenit.gla;
import com.ushareit.listenit.grf;
import com.ushareit.listenit.grg;
import com.ushareit.listenit.grh;

public class SyncTrafficAlertPopupView extends BasePopupView {
    private OnClickListener f16282a = new grf(this);
    private OnClickListener f16283b = new grg(this);
    private OnClickListener f16284c = new grh(this);

    public SyncTrafficAlertPopupView(Context context) {
        super(context);
        m25658a(context, this);
    }

    public void m25658a(Context context, ViewGroup viewGroup) {
        View inflate = View.inflate(context, C0349R.layout.popup_view_sync_traffic_alert, viewGroup);
        inflate.findViewById(C0349R.id.sync_all).setOnClickListener(this.f16282a);
        inflate.findViewById(C0349R.id.sync_part).setOnClickListener(this.f16283b);
        inflate.findViewById(C0349R.id.cancel).setOnClickListener(this.f16284c);
    }

    public void setItem(gla com_ushareit_listenit_gla) {
    }

    public void setTitle(String str) {
    }

    public int getGravity() {
        return 17;
    }
}
