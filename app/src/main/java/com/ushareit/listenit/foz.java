package com.ushareit.listenit;

import android.view.View;
import android.view.View.OnClickListener;
import com.ushareit.listenit.cutter.RingEditActivity;
import com.ushareit.listenit.popupview.BasePopupView;
import com.ushareit.listenit.popupview.ConfirmPopupView;

public class foz implements OnClickListener {
    final /* synthetic */ RingEditActivity f13129a;

    public foz(RingEditActivity ringEditActivity) {
        this.f13129a = ringEditActivity;
    }

    public void onClick(View view) {
        if (this.f13129a.f9045A != null) {
            if (this.f13129a.f9058q.m12916a()) {
                this.f13129a.f9058q.m12917b();
            }
            if (((double) this.f13129a.f9057p.getDuration()) <= 0.5d) {
                this.f13129a.m12815d((int) C0349R.string.too_small_error);
                return;
            }
            BasePopupView confirmPopupView = new ConfirmPopupView(this.f13129a);
            confirmPopupView.m25554a().setTitle((int) C0349R.string.cutter_save_dialog_title);
            confirmPopupView.m25558g().setEditText(this.f13129a.f9055n.f14338f);
            fyi com_ushareit_listenit_fyi = new fyi(confirmPopupView);
            confirmPopupView.setConfirmListener(new fpa(this, confirmPopupView));
            gyn.m23197a(this.f13129a, com_ushareit_listenit_fyi);
        }
    }
}
