package com.ushareit.listenit;

import android.net.Uri;
import com.ushareit.listenit.login.UserProfileActivity;
import java.io.File;

public class gfn implements gpb {
    final /* synthetic */ UserProfileActivity f14032a;

    public gfn(UserProfileActivity userProfileActivity) {
        this.f14032a = userProfileActivity;
    }

    public void mo2672a() {
        this.f14032a.f15788G = new File(gyn.m23244h());
        this.f14032a.f15789H = Uri.fromFile(this.f14032a.f15788G);
        gyj.m23144a(this.f14032a, this.f14032a.f15789H);
    }

    public void mo2673b() {
        gyj.m23151c(this.f14032a);
    }
}
