package com.ushareit.listenit;

import android.content.Context;
import android.os.Process;
import java.lang.Thread.UncaughtExceptionHandler;

public class ann implements UncaughtExceptionHandler {
    private final UncaughtExceptionHandler f4958a;
    private final Context f4959b;

    public ann(UncaughtExceptionHandler uncaughtExceptionHandler, Context context) {
        this.f4958a = uncaughtExceptionHandler;
        if (context == null) {
            throw new IllegalArgumentException("Missing Context");
        }
        this.f4959b = context.getApplicationContext();
    }

    private void m6393a(Thread thread, Throwable th) {
        if (this.f4958a != null) {
            this.f4958a.uncaughtException(thread, th);
            return;
        }
        try {
            Process.killProcess(Process.myPid());
        } catch (Throwable th2) {
        }
        try {
            System.exit(10);
        } catch (Throwable th3) {
        }
    }

    public void uncaughtException(Thread thread, Throwable th) {
        String a = ate.m7118a(th);
        if (a != null && a.contains("com.facebook.ads")) {
            auj.m7201a(new apl(aop.m6484b(), aop.m6485c(), new aui(a, aor.f5091f)), this.f4959b);
        }
        m6393a(thread, th);
    }
}
