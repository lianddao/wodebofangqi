package com.ushareit.listenit;

import android.view.View;
import com.ushareit.listenit.popupview.ConfirmPopupView;

class has implements gop {
    final /* synthetic */ ConfirmPopupView f15093a;
    final /* synthetic */ har f15094b;

    has(har com_ushareit_listenit_har, ConfirmPopupView confirmPopupView) {
        this.f15094b = com_ushareit_listenit_har;
        this.f15093a = confirmPopupView;
    }

    public boolean mo2508a(View view) {
        int i = 1;
        if (frd.m20610a(this.f15093a.getInput())) {
            heb.m23597a(this.f15094b.f15092a.o.getResources().getString(C0349R.string.toast_same_playlist_name), 0).show();
            return true;
        }
        this.f15094b.f15092a.m23468a(this.f15094b.f15092a.itemView);
        hap com_ushareit_listenit_hap = this.f15094b.f15092a;
        String input = this.f15093a.getInput();
        if (!this.f15093a.m25559h()) {
            i = 0;
        }
        com_ushareit_listenit_hap.m23497a(input, i);
        fis.m19424b(this.f15094b.f15092a.o, this.f15093a.getInput());
        fis.m19421a(this.f15094b.f15092a.o, "main_newname");
        fir.m19391d(this.f15093a.m25559h());
        return false;
    }

    public boolean mo2509b(View view) {
        return false;
    }
}
