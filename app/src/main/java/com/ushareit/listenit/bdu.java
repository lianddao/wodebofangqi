package com.ushareit.listenit;

import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.share.widget.ShareButton;

public class bdu implements OnClickListener {
    final /* synthetic */ ShareButton f5961a;

    public bdu(ShareButton shareButton) {
        this.f5961a = shareButton;
    }

    public void onClick(View view) {
        bdv com_ushareit_listenit_bdv;
        this.f5961a.m721a(view);
        if (this.f5961a.getFragment() != null) {
            com_ushareit_listenit_bdv = new bdv(this.f5961a.getFragment(), this.f5961a.getRequestCode());
        } else {
            com_ushareit_listenit_bdv = new bdv(this.f5961a.getActivity(), this.f5961a.getRequestCode());
        }
        com_ushareit_listenit_bdv.m1738a(this.f5961a.getShareContent());
    }
}
