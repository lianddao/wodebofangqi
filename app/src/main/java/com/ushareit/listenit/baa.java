package com.ushareit.listenit;

import android.app.AlertDialog.Builder;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.AccessToken;
import com.facebook.C0006R;
import com.facebook.Profile;
import com.facebook.appevents.C0075a;
import com.facebook.internal.bl;
import com.facebook.login.C0136r;
import com.facebook.login.widget.LoginButton;

public class baa implements OnClickListener {
    final /* synthetic */ LoginButton f5763a;

    private baa(LoginButton loginButton) {
        this.f5763a = loginButton;
    }

    public void onClick(View view) {
        int i;
        this.f5763a.m721a(view);
        Context context = this.f5763a.getContext();
        AccessToken a = AccessToken.m671a();
        if (a == null) {
            C0136r loginManager = this.f5763a.getLoginManager();
            loginManager.m1884a(this.f5763a.getDefaultAudience());
            loginManager.m1885a(this.f5763a.getLoginBehavior());
            if (bl.PUBLISH.equals(this.f5763a.f1320e.f5759c)) {
                if (this.f5763a.getFragment() != null) {
                    loginManager.m1893b(this.f5763a.getFragment(), this.f5763a.f1320e.f5758b);
                } else {
                    loginManager.m1892b(this.f5763a.getActivity(), this.f5763a.f1320e.f5758b);
                }
            } else if (this.f5763a.getFragment() != null) {
                loginManager.m1887a(this.f5763a.getFragment(), this.f5763a.f1320e.f5758b);
            } else {
                loginManager.m1886a(this.f5763a.getActivity(), this.f5763a.f1320e.f5758b);
            }
        } else if (this.f5763a.f1317b) {
            CharSequence string;
            CharSequence string2 = this.f5763a.getResources().getString(C0006R.string.com_facebook_loginview_log_out_action);
            CharSequence string3 = this.f5763a.getResources().getString(C0006R.string.com_facebook_loginview_cancel_action);
            Profile a2 = Profile.m777a();
            if (a2 == null || a2.m780c() == null) {
                string = this.f5763a.getResources().getString(C0006R.string.com_facebook_loginview_logged_in_using_facebook);
            } else {
                string = String.format(this.f5763a.getResources().getString(C0006R.string.com_facebook_loginview_logged_in_as), new Object[]{a2.m780c()});
            }
            Builder builder = new Builder(context);
            builder.setMessage(string).setCancelable(true).setPositiveButton(string2, new bab(this)).setNegativeButton(string3, null);
            builder.create().show();
        } else {
            this.f5763a.getLoginManager().m1891b();
        }
        C0075a a3 = C0075a.m1174a(this.f5763a.getContext());
        Bundle bundle = new Bundle();
        String str = "logging_in";
        if (a != null) {
            i = 0;
        } else {
            i = 1;
        }
        bundle.putInt(str, i);
        a3.m1207a(this.f5763a.f1321f, null, bundle);
    }
}
