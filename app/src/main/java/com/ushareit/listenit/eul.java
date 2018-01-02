package com.ushareit.listenit;

import android.annotation.TargetApi;
import android.app.DownloadManager;
import android.app.DownloadManager.Request;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Environment;
import android.webkit.DownloadListener;
import android.webkit.MimeTypeMap;
import com.ushareit.browser.BrowserActivity;
import java.util.UUID;

public class eul implements DownloadListener {
    final /* synthetic */ BrowserActivity f11895a;

    public eul(BrowserActivity browserActivity) {
        this.f11895a = browserActivity;
    }

    @TargetApi(9)
    public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
        if (VERSION.SDK_INT <= 8 || (str.contains("https://") && VERSION.SDK_INT <= 11)) {
            this.f11895a.m4865a(str);
            return;
        }
        DownloadManager downloadManager = (DownloadManager) this.f11895a.getSystemService("download");
        Request request = new Request(Uri.parse(str));
        String b = this.f11895a.m4868b(str3);
        if (fbb.m18758a(b)) {
            b = UUID.randomUUID().toString() + "." + MimeTypeMap.getSingleton().getExtensionFromMimeType(str4);
        }
        if (b != null) {
            try {
                request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, b);
            } catch (Exception e) {
                exw.m18449b("BrowserActivity", "onDownloadStart exception, try to download use browser:" + e.toString());
                this.f11895a.m4865a(str);
                return;
            }
        }
        request.setVisibleInDownloadsUi(true);
        downloadManager.enqueue(request);
        this.f11895a.f3937q = true;
        heb.m23597a(this.f11895a.getResources().getString(C0349R.string.browser_operate_downloading), 0).show();
    }
}
