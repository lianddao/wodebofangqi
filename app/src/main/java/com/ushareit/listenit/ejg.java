package com.ushareit.listenit;

import android.content.Context;
import android.text.TextUtils;
import com.mopub.common.Preconditions;
import com.mopub.common.UrlAction;
import com.mopub.common.UrlHandler.Builder;
import com.mopub.mobileads.VastTracker;
import com.mopub.network.TrackingRequest;
import java.io.Serializable;
import java.util.List;

public class ejg implements Serializable {
    private final int f11120a;
    private final int f11121b;
    private final int f11122c;
    private final Integer f11123d;
    private final ejn f11124e;
    private final List<VastTracker> f11125f;
    private final String f11126g;
    private final List<VastTracker> f11127h;

    public ejg(int i, int i2, Integer num, Integer num2, ejn com_ushareit_listenit_ejn, List<VastTracker> list, String str, List<VastTracker> list2) {
        Preconditions.checkNotNull(com_ushareit_listenit_ejn);
        Preconditions.checkNotNull(list);
        Preconditions.checkNotNull(list2);
        this.f11120a = i;
        this.f11121b = i2;
        this.f11122c = num == null ? 0 : num.intValue();
        this.f11123d = num2;
        this.f11124e = com_ushareit_listenit_ejn;
        this.f11125f = list;
        this.f11126g = str;
        this.f11127h = list2;
    }

    public int m17105a() {
        return this.f11120a;
    }

    public int m17108b() {
        return this.f11121b;
    }

    public int m17109c() {
        return this.f11122c;
    }

    public Integer m17110d() {
        return this.f11123d;
    }

    public ejn m17111e() {
        return this.f11124e;
    }

    List<VastTracker> m17112f() {
        return this.f11125f;
    }

    public void m17106a(Context context, int i, String str) {
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(str);
        TrackingRequest.makeVastTrackingHttpRequest(this.f11127h, null, Integer.valueOf(i), str, context);
    }

    void m17107a(Context context, String str, String str2) {
        Preconditions.checkNotNull(context);
        Object correctClickThroughUrl = this.f11124e.getCorrectClickThroughUrl(this.f11126g, str);
        if (!TextUtils.isEmpty(correctClickThroughUrl)) {
            new Builder().withSupportedUrlActions(UrlAction.IGNORE_ABOUT_SCHEME, UrlAction.OPEN_NATIVE_BROWSER, UrlAction.OPEN_IN_APP_BROWSER).withResultActions(new ejh(this, str2, context)).withoutMoPubBrowser().build().handleUrl(context, correctClickThroughUrl);
        }
    }
}
