package com.ushareit.listenit;

import android.media.MediaScannerConnection.OnScanCompletedListener;
import android.net.Uri;

class gsc implements OnScanCompletedListener {
    final /* synthetic */ int f14631a;
    final /* synthetic */ grz f14632b;

    gsc(grz com_ushareit_listenit_grz, int i) {
        this.f14632b = com_ushareit_listenit_grz;
        this.f14631a = i;
    }

    public void onScanCompleted(String str, Uri uri) {
        if (uri != null) {
            hhx.m23867a(new gsd(this, uri));
        }
    }
}
