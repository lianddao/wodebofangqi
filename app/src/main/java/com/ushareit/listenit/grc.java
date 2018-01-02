package com.ushareit.listenit;

import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.umeng.analytics.pro.C0277j;
import com.ushareit.listenit.popupview.SelectAlbumPopupView;
import java.io.File;

public class grc implements fju {
    final /* synthetic */ SelectAlbumPopupView f14577a;

    public grc(SelectAlbumPopupView selectAlbumPopupView) {
        this.f14577a = selectAlbumPopupView;
    }

    public void mo2624a(int i, int i2, Intent intent) {
        switch (i) {
            case C0277j.f3691b /*160*/:
                if (i2 != -1 || intent == null || intent.getData() == null || fbb.m18763c(this.f14577a.f16265b)) {
                    this.f14577a.f16267d.m4857c(this.f14577a.f16272i);
                    return;
                }
                Uri a = gzh.m23374a(this.f14577a.f16267d, intent.getData());
                if (a == null || TextUtils.isEmpty(a.toString())) {
                    this.f14577a.f16267d.m4857c(this.f14577a.f16272i);
                    return;
                } else if (gyj.m23148a("com.android.camera.action.CROP", "image/*")) {
                    int a2 = this.f14577a.m25635a(a);
                    Object n = gyn.m23257n(this.f14577a.f16265b);
                    if (!TextUtils.isEmpty(n)) {
                        this.f14577a.f16268e = new File(n);
                        if (this.f14577a.f16268e.exists()) {
                            this.f14577a.f16268e.delete();
                        }
                        gyj.m23150b(this.f14577a.f16267d, a, Uri.fromFile(this.f14577a.f16268e), a2, a2);
                        return;
                    }
                    return;
                } else {
                    this.f14577a.f16267d.m4857c(this.f14577a.f16272i);
                    String path = a.getPath();
                    if (!TextUtils.isEmpty(path) && new File(path).exists()) {
                        intent.putExtra("extra_album_name", this.f14577a.f16265b);
                        this.f14577a.m25640a(path);
                        return;
                    }
                    return;
                }
            case 162:
                this.f14577a.f16267d.m4857c(this.f14577a.f16272i);
                if (this.f14577a.f16268e == null) {
                    return;
                }
                if (i2 == 0) {
                    if (this.f14577a.f16268e.exists()) {
                        this.f14577a.f16268e.delete();
                        return;
                    }
                    return;
                } else if (i2 == -1 && this.f14577a.f16268e.exists() && this.f14577a.f16268e.length() > 0) {
                    Object m = gyn.m23255m(this.f14577a.f16265b);
                    if (!TextUtils.isEmpty(m)) {
                        File file = new File(m);
                        if (file.exists()) {
                            file.delete();
                        }
                        this.f14577a.f16268e.renameTo(file);
                        intent.putExtra("extra_album_name", this.f14577a.f16265b);
                        this.f14577a.m25640a(file.getAbsolutePath());
                        return;
                    }
                    return;
                } else {
                    return;
                }
            default:
                return;
        }
    }
}
