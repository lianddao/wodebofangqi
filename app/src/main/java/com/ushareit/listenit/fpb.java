package com.ushareit.listenit;

import android.util.Log;
import android.view.inputmethod.InputMethodManager;
import com.ushareit.listenit.cutter.RingEditActivity;
import com.ushareit.listenit.cutter.view.SetRingPopupView;
import com.ushareit.listenit.popupview.BasePopupView;
import java.io.File;

public class fpb extends hhw {
    final /* synthetic */ String f13134a;
    final /* synthetic */ RingEditActivity f13135b;

    public fpb(RingEditActivity ringEditActivity, String str) {
        this.f13135b = ringEditActivity;
        this.f13134a = str;
    }

    public void execute() {
        this.f13135b.f9047C = this.f13135b.m12803a(this.f13134a, this.f13135b.f9046B);
        if (this.f13135b.f9047C != null) {
            File file = new File(this.f13135b.f9047C);
            try {
                this.f13135b.f9045A.mo2514a(file, this.f13135b.f9057p.getStartFrame(), this.f13135b.f9057p.getTotalFrame());
                gkx com_ushareit_listenit_gkx = new gkx(this.f13135b.f9055n);
                com_ushareit_listenit_gkx.f14255b = this.f13134a;
                com_ushareit_listenit_gkx.f14260g = this.f13135b.getResources().getString(C0349R.string.app_name);
                com_ushareit_listenit_gkx.f14256c = this.f13135b.f9047C;
                com_ushareit_listenit_gkx.f14258e = this.f13135b.f9057p.getDuration() * 1000;
                fqz.m20502a(com_ushareit_listenit_gkx);
                grz.m22656a().m22664a(this.f13135b.f9047C, 1);
            } catch (Throwable e) {
                Log.e(hhw.TAG, "Error: Failed to create " + this.f13135b.f9047C, e);
                if (file.exists() && !file.delete()) {
                    Log.e(hhw.TAG, "Error: can't delete created damaged file.", e);
                }
            }
        }
    }

    public void callback() {
        InputMethodManager inputMethodManager = (InputMethodManager) this.f13135b.getSystemService("input_method");
        if (inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(this.f13135b.getWindow().getDecorView().getWindowToken(), 0);
        }
        if (this.f13135b.f9047C != null) {
            BasePopupView setRingPopupView = new SetRingPopupView(this.f13135b);
            setRingPopupView.setSetRingListener(this.f13135b.f9052H);
            gyn.m23197a(this.f13135b, new fyi(setRingPopupView));
            fii.m19302b(this.f13135b);
            this.f13135b.m12815d((int) C0349R.string.toast_save_clip);
        }
    }
}
