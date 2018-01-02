package com.ushareit.listenit;

import android.graphics.Bitmap;
import android.os.Bundle;

public class hik {
    public String f15488a;
    public String f15489b;
    public String f15490c;
    public String f15491d;
    public String f15492e;
    public String f15493f;
    public Bitmap f15494g;
    public hil f15495h = null;

    public hik(Bundle bundle, hil com_ushareit_listenit_hil) {
        this.f15489b = bundle.getString("msg");
        this.f15490c = bundle.getString("title");
        this.f15491d = bundle.getString("description");
        this.f15492e = bundle.getString("webpage");
        this.f15493f = bundle.getString("image");
        this.f15494g = (Bitmap) bundle.getParcelable("thumbnail");
        if (this.f15489b == null) {
            this.f15489b = "";
        }
        if (this.f15492e == null) {
            this.f15492e = "";
        }
        this.f15488a = "http://" + fql.m20391c() + "/m.php";
        this.f15495h = com_ushareit_listenit_hil;
    }

    public hik(Bundle bundle) {
        this.f15489b = bundle.getString("msg");
        this.f15490c = bundle.getString("title");
        this.f15491d = bundle.getString("description");
        this.f15492e = bundle.getString("webpage");
        this.f15493f = bundle.getString("image");
        this.f15494g = (Bitmap) bundle.getParcelable("thumbnail");
        if (this.f15489b == null) {
            this.f15489b = "";
        }
        if (this.f15492e == null) {
            this.f15492e = "";
        }
        this.f15488a = "http://" + fql.m20391c() + "/m.php";
    }
}
