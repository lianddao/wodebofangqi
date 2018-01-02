package com.ushareit.listenit;

import android.view.View;
import android.view.View.OnClickListener;
import com.ushareit.listenit.popupview.BasePopupView;
import com.ushareit.listenit.popupview.ConfirmPopupView;
import com.ushareit.listenit.popupview.NormalPlayerMenu;

public class gqo implements OnClickListener {
    final /* synthetic */ NormalPlayerMenu f14563a;

    public gqo(NormalPlayerMenu normalPlayerMenu) {
        this.f14563a = normalPlayerMenu;
    }

    public void onClick(View view) {
        glg o = gyp.m23301o();
        if (o != null) {
            BasePopupView confirmPopupView = new ConfirmPopupView(this.f14563a.getContext());
            confirmPopupView.m25554a().setTitle(this.f14563a.getContext().getResources().getString(C0349R.string.cutter_dialog_title));
            confirmPopupView.m25556d().setContent(this.f14563a.getContext().getResources().getString(C0349R.string.cutter_dialog_content));
            confirmPopupView.setConfirmListener(new gqp(this, o));
            gyn.m23197a((ak) this.f14563a.getContext(), new fyi(confirmPopupView));
            this.f14563a.m25608a();
        }
    }
}
