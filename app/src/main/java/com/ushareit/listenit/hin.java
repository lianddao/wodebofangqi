package com.ushareit.listenit;

import android.content.Context;
import android.os.Bundle;
import android.view.View.OnClickListener;

public class hin extends hip {
    private static final String f15503h = ("http://" + fql.m20391c() + "/m.php");
    private String f15504i = "https://play.google.com/store/apps/details?id=com.ushareit.listenit";
    private final Bundle f15505j;
    private OnClickListener f15506k = new hio(this);

    public hin(Context context) {
        super(context, "facebook", C0349R.string.common_facebook, C0349R.drawable.invite_icon_facebook);
        this.f15501f = hip.m23906a(context).containsKey("com.facebook.katana");
        this.f15505j = m23910a();
        m23908a(new hik(this.f15505j));
    }

    public Bundle m23910a() {
        Bundle bundle = new Bundle();
        String string = this.a.getString(C0349R.string.invite_message, new Object[]{this.f15504i});
        bundle.putString("title", this.a.getString(C0349R.string.app_name));
        bundle.putString("description", this.a.getString(C0349R.string.invite_message_description));
        bundle.putString("msg", string);
        bundle.putString("webpage", this.f15504i);
        bundle.putString("image", "https://lh3.googleusercontent.com/N8kXaixBF8X2zPvXkuhE0VM_ewtphxl_yKQunGYQj9Czb0SoFZ_8dUYzCPV9vDnxPw=w100-rw");
        return bundle;
    }

    public Bundle m23911b() {
        return this.f15505j;
    }
}
