package com.ushareit.listenit;

import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.share.widget.SendButton;

public class bdt implements OnClickListener {
    final /* synthetic */ SendButton f5960a;

    public bdt(SendButton sendButton) {
        this.f5960a = sendButton;
    }

    public void onClick(View view) {
        bdp com_ushareit_listenit_bdp;
        this.f5960a.m721a(view);
        if (this.f5960a.getFragment() != null) {
            com_ushareit_listenit_bdp = new bdp(this.f5960a.getFragment(), this.f5960a.getRequestCode());
        } else {
            com_ushareit_listenit_bdp = new bdp(this.f5960a.getActivity(), this.f5960a.getRequestCode());
        }
        com_ushareit_listenit_bdp.m1738a(this.f5960a.getShareContent());
    }
}
