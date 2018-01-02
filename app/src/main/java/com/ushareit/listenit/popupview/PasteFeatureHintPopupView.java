package com.ushareit.listenit.popupview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.ushareit.listenit.C0349R;
import com.ushareit.listenit.gla;
import com.ushareit.listenit.gqv;
import com.ushareit.listenit.gum;

public class PasteFeatureHintPopupView extends BasePopupView {
    public PasteFeatureHintPopupView(Context context) {
        super(context);
        m25619a(context, this);
    }

    public void m25619a(Context context, ViewGroup viewGroup) {
        View.inflate(context, C0349R.layout.popup_view_paste_feature_hint, viewGroup).findViewById(C0349R.id.ok).setOnClickListener(new gqv(this));
    }

    public void mo2995a(gum com_ushareit_listenit_gum) {
        super.mo2995a(com_ushareit_listenit_gum);
    }

    public void mo2996b() {
        super.mo2996b();
    }

    public void mo2997c() {
        super.mo2997c();
    }

    public int getGravity() {
        return 17;
    }

    public void setItem(gla com_ushareit_listenit_gla) {
    }

    public void setTitle(String str) {
    }
}
