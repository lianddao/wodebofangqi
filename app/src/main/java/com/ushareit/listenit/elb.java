package com.ushareit.listenit;

import android.webkit.ConsoleMessage;
import android.webkit.JsResult;
import com.mopub.common.CloseableLayout.ClosePosition;
import com.mopub.mraid.MraidBridge.MraidBridgeListener;
import com.mopub.mraid.MraidController;
import java.net.URI;

public class elb implements MraidBridgeListener {
    final /* synthetic */ MraidController f11196a;

    public elb(MraidController mraidController) {
        this.f11196a = mraidController;
    }

    public void onPageLoaded() {
        this.f11196a.m3106b();
    }

    public void onPageFailedToLoad() {
    }

    public void onVisibilityChanged(boolean z) {
        this.f11196a.f2588p.m3069a(z);
        this.f11196a.f2589q.m3069a(z);
    }

    public boolean onJsAlert(String str, JsResult jsResult) {
        return this.f11196a.m3105a(str, jsResult);
    }

    public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        return this.f11196a.m3103a(consoleMessage);
    }

    public void onResize(int i, int i2, int i3, int i4, ClosePosition closePosition, boolean z) {
        throw new ekx("Not allowed to resize from an expanded state");
    }

    public void onExpand(URI uri, boolean z) {
    }

    public void onClose() {
        this.f11196a.m3109c();
    }

    public void onUseCustomClose(boolean z) {
        this.f11196a.m3101a(z);
    }

    public void onSetOrientationProperties(boolean z, elw com_ushareit_listenit_elw) {
        this.f11196a.m3102a(z, com_ushareit_listenit_elw);
    }

    public void onOpen(URI uri) {
        this.f11196a.m3108b(uri.toString());
    }

    public void onPlayVideo(URI uri) {
        this.f11196a.m3099a(uri.toString());
    }
}
