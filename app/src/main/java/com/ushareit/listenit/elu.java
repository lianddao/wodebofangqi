package com.ushareit.listenit;

import android.media.MediaScannerConnection;
import android.media.MediaScannerConnection.MediaScannerConnectionClient;
import android.net.Uri;

public class elu implements MediaScannerConnectionClient {
    private final String f11224a;
    private final String f11225b;
    private MediaScannerConnection f11226c;

    private elu(String str, String str2) {
        this.f11224a = str;
        this.f11225b = str2;
    }

    private void m17162a(MediaScannerConnection mediaScannerConnection) {
        this.f11226c = mediaScannerConnection;
    }

    public void onMediaScannerConnected() {
        if (this.f11226c != null) {
            this.f11226c.scanFile(this.f11224a, this.f11225b);
        }
    }

    public void onScanCompleted(String str, Uri uri) {
        if (this.f11226c != null) {
            this.f11226c.disconnect();
        }
    }
}
