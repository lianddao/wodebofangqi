package com.ushareit.listenit;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;

@TargetApi(14)
class dvf implements ActivityLifecycleCallbacks {
    final /* synthetic */ dva f10402a;

    private dvf(dva com_ushareit_listenit_dva) {
        this.f10402a = com_ushareit_listenit_dva;
    }

    private boolean m15778a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        this.f10402a.m15756a("auto", "_ldl", (Object) str);
        return true;
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
        try {
            this.f10402a.mo2096w().m16235E().m16263a("onActivityCreated");
            Intent intent = activity.getIntent();
            if (intent != null) {
                Uri data = intent.getData();
                if (data != null && data.isHierarchical()) {
                    if (bundle == null) {
                        Bundle a = this.f10402a.mo2092s().m15942a(data);
                        if (a != null) {
                            this.f10402a.m15754a("auto", "_cmp", a);
                        }
                    }
                    String queryParameter = data.getQueryParameter("referrer");
                    if (!TextUtils.isEmpty(queryParameter)) {
                        if (queryParameter.contains("gclid")) {
                            this.f10402a.mo2096w().m16234D().m16264a("Activity created with referrer", queryParameter);
                            m15778a(queryParameter);
                            return;
                        }
                        this.f10402a.mo2096w().m16234D().m16263a("Activity created with data 'referrer' param without gclid");
                    }
                }
            }
        } catch (Throwable th) {
            this.f10402a.mo2096w().m16242f().m16264a("Throwable caught in onActivityCreated", th);
        }
    }

    public void onActivityDestroyed(Activity activity) {
    }

    public void onActivityPaused(Activity activity) {
        this.f10402a.mo2094u().m15858g();
    }

    public void onActivityResumed(Activity activity) {
        this.f10402a.mo2094u().m15857f();
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public void onActivityStarted(Activity activity) {
    }

    public void onActivityStopped(Activity activity) {
    }
}
