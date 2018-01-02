package com.ushareit.listenit;

import com.mopub.common.CloseableLayout.OnCloseListener;

class eij implements OnCloseListener {
    final /* synthetic */ eii f11083a;

    eij(eii com_ushareit_listenit_eii) {
        this.f11083a = com_ushareit_listenit_eii;
    }

    public void onClose() {
        this.f11083a.finish();
    }
}
