package com.ushareit.listenit;

import android.view.View;
import android.view.View.OnClickListener;
import com.ushareit.browser.BrowserActivity;

public class euk implements OnClickListener {
    final /* synthetic */ BrowserActivity f11894a;

    public euk(BrowserActivity browserActivity) {
        this.f11894a = browserActivity;
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case C0349R.id.error_view:
                break;
            case C0349R.id.btn_back:
                this.f11894a.m4879q();
                return;
            case C0349R.id.btn_forward:
                this.f11894a.m4880r();
                return;
            case C0349R.id.btn_share:
                this.f11894a.m4888j();
                return;
            case C0349R.id.btn_refresh:
                this.f11894a.f3934n.reload();
                return;
            case C0349R.id.btn_open:
                this.f11894a.m4883u();
                return;
            case C0349R.id.return_view:
                this.f11894a.finish();
                break;
            default:
                return;
        }
        this.f11894a.f3923G.setVisibility(8);
        this.f11894a.m4878p();
    }
}
