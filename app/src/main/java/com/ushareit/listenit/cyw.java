package com.ushareit.listenit;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import android.os.Bundle;
import java.util.concurrent.atomic.AtomicBoolean;

@TargetApi(14)
public class cyw implements ActivityLifecycleCallbacks, ComponentCallbacks2 {
    private static final cyw f9384a = new cyw();
    private final AtomicBoolean f9385b = new AtomicBoolean();
    private boolean f9386c;

    private cyw() {
    }

    public static cyw m13438a() {
        return f9384a;
    }

    public static void m13439a(Application application) {
        application.registerActivityLifecycleCallbacks(f9384a);
        application.registerComponentCallbacks(f9384a);
        f9384a.f9386c = true;
    }

    public boolean m13440b() {
        return this.f9385b.get();
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
        if (this.f9385b.compareAndSet(true, false)) {
            eah.m16609a(false);
        }
    }

    public void onActivityDestroyed(Activity activity) {
    }

    public void onActivityPaused(Activity activity) {
    }

    public void onActivityResumed(Activity activity) {
        if (this.f9385b.compareAndSet(true, false)) {
            eah.m16609a(false);
        }
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public void onActivityStarted(Activity activity) {
    }

    public void onActivityStopped(Activity activity) {
    }

    public void onConfigurationChanged(Configuration configuration) {
    }

    public void onLowMemory() {
    }

    public void onTrimMemory(int i) {
        if (i == 20 && this.f9385b.compareAndSet(false, true)) {
            eah.m16609a(true);
        }
    }
}
