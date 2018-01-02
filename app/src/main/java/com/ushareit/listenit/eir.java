package com.ushareit.listenit;

import com.mopub.common.UrlAction;
import com.mopub.common.UrlHandler.ResultActions;

class eir implements ResultActions {
    final /* synthetic */ eip f11100a;

    eir(eip com_ushareit_listenit_eip) {
        this.f11100a = com_ushareit_listenit_eip;
    }

    public void urlHandlingSucceeded(String str, UrlAction urlAction) {
        if (this.f11100a.f11096e.wasClicked()) {
            this.f11100a.f11095d.onClicked();
            this.f11100a.f11096e.onResetUserClick();
        }
    }

    public void urlHandlingFailed(String str, UrlAction urlAction) {
    }
}
