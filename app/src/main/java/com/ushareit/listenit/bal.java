package com.ushareit.listenit;

import android.content.Intent;
import com.facebook.internal.cb;

final class bal implements bbb {
    final /* synthetic */ int f5803a;
    final /* synthetic */ int f5804b;
    final /* synthetic */ Intent f5805c;

    bal(int i, int i2, Intent intent) {
        this.f5803a = i;
        this.f5804b = i2;
        this.f5805c = intent;
    }

    public void mo823a(bak com_ushareit_listenit_bak, aif com_ushareit_listenit_aif) {
        if (com_ushareit_listenit_aif == null) {
            com_ushareit_listenit_bak.m7520b(this.f5803a, this.f5804b, this.f5805c);
        } else {
            cb.m1584a(bak.f5779a, (Exception) com_ushareit_listenit_aif);
        }
    }
}
