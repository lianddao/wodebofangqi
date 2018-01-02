package com.ushareit.listenit;

import android.net.Uri;
import java.io.File;
import java.io.InputStream;

class fzs implements fzu<InputStream> {
    final /* synthetic */ int f13787a;
    final /* synthetic */ int f13788b;
    final /* synthetic */ fzr f13789c;

    fzs(fzr com_ushareit_listenit_fzr, int i, int i2) {
        this.f13789c = com_ushareit_listenit_fzr;
        this.f13787a = i;
        this.f13788b = i2;
    }

    public vc<InputStream> mo2632a(Integer num) {
        exw.m18443a("MediaModelLoader", "getLocalFileFetcher, fromDefault");
        return this.f13789c.f13785b.mo546a(this.f13789c.m21433a(this.f13789c.f13786c, num), this.f13787a, this.f13788b);
    }

    public vc<InputStream> mo2634a(byte[] bArr) {
        exw.m18443a("MediaModelLoader", "getLocalFileFetcher, fromAudioFile");
        return this.f13789c.f13784a.mo546a(bArr, this.f13787a, this.f13788b);
    }

    public vc<InputStream> mo2633a(String str) {
        exw.m18443a("MediaModelLoader", "getLocalFileFetcher, path=" + str);
        return this.f13789c.f13785b.mo546a(Uri.fromFile(new File(str)), this.f13787a, this.f13788b);
    }

    public fzw mo2631a(Uri uri) {
        exw.m18443a("MediaModelLoader", "onUrlFetcher, url=" + uri);
        return new fzw(this.f13789c.f13785b.mo546a(uri, this.f13787a, this.f13788b));
    }
}
