package com.ushareit.listenit;

import android.media.MediaScannerConnection.OnScanCompletedListener;
import android.net.Uri;

class gsa implements OnScanCompletedListener {
    final /* synthetic */ int f14627a;
    final /* synthetic */ grz f14628b;

    gsa(grz com_ushareit_listenit_grz, int i) {
        this.f14628b = com_ushareit_listenit_grz;
        this.f14627a = i;
    }

    public void onScanCompleted(String str, Uri uri) {
        if (uri != null) {
            hhx.m23867a(new gsb(this, uri));
        }
    }
}
