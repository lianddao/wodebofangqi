package com.ushareit.listenit;

import android.webkit.ConsoleMessage;
import android.webkit.JsResult;
import com.mopub.common.CloseableLayout.ClosePosition;
import com.mopub.mraid.MraidBridge.MraidBridgeListener;
import com.mopub.mraid.MraidController;
import java.net.URI;

public class ela implements MraidBridgeListener {
    final /* synthetic */ MraidController f11195a;

    public ela(MraidController mraidController) {
        this.f11195a = mraidController;
    }

    public void onPageLoaded() {
        this.f11195a.m3096a();
    }

    public void onPageFailedToLoad() {
        if (this.f11195a.f2583k != null) {
            this.f11195a.f2583k.onFailedToLoad();
        }
    }

    public void onVisibilityChanged(boolean z) {
        if (!this.f11195a.f2589q.m3074d()) {
            this.f11195a.f2588p.m3069a(z);
        }
    }

    public boolean onJsAlert(String str, JsResult jsResult) {
        return this.f11195a.m3105a(str, jsResult);
    }

    public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        return this.f11195a.m3103a(consoleMessage);
    }

    public void onClose() {
        this.f11195a.m3109c();
    }

    public void onResize(int i, int i2, int i3, int i4, ClosePosition closePosition, boolean z) {
        this.f11195a.m3098a(i, i2, i3, i4, closePosition, z);
    }

    public void onExpand(URI uri, boolean z) {
        this.f11195a.m3100a(uri, z);
    }

    public void onUseCustomClose(boolean z) {
        this.f11195a.m3101a(z);
    }

    public void onSetOrientationProperties(boolean z, elw com_ushareit_listenit_elw) {
        this.f11195a.m3102a(z, com_ushareit_listenit_elw);
    }

    public void onOpen(URI uri) {
        this.f11195a.m3108b(uri.toString());
    }

    public void onPlayVideo(URI uri) {
        this.f11195a.m3099a(uri.toString());
    }
}
