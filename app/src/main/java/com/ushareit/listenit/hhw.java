package com.ushareit.listenit;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public abstract class hhw {
    public static final String TAG = "Task";
    private String f3944a;
    private String f3945b;
    private int f3946c;
    private boolean f3947d;
    private Future<?> f3948e;

    public abstract void callback();

    public abstract void execute();

    public hhw() {
        this("");
    }

    public hhw(String str) {
        this(str, 0, "");
    }

    public hhw(String str, int i) {
        this(str, i, "");
    }

    public hhw(String str, int i, String str2) {
        this.f3944a = "";
        this.f3945b = "";
        this.f3946c = 0;
        this.f3947d = false;
        this.f3948e = null;
        if (fbb.m18763c(str)) {
            str = "" + hashCode();
        }
        this.f3944a = str;
        this.f3946c = i;
        this.f3945b = str2;
    }

    protected String mo2314a() {
        return hhw.class.getSimpleName();
    }

    protected ExecutorService mo2315b() {
        return null;
    }

    public void setTaskId(String str) {
        this.f3944a = str;
    }

    public String getTaskId() {
        return this.f3944a;
    }

    public int getPriority() {
        return this.f3946c;
    }

    public String getTaskName() {
        return this.f3945b;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void cancel() {
        /*
        r5 = this;
        r0 = 1;
        r4 = 0;
        r5.f3947d = r0;
        r0 = r5.f3948e;	 Catch:{ Throwable -> 0x0011 }
        if (r0 == 0) goto L_0x000e;
    L_0x0008:
        r0 = r5.f3948e;	 Catch:{ Throwable -> 0x0011 }
        r1 = 1;
        r0.cancel(r1);	 Catch:{ Throwable -> 0x0011 }
    L_0x000e:
        r5.f3948e = r4;
    L_0x0010:
        return;
    L_0x0011:
        r0 = move-exception;
        r1 = "Task";
        r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0031 }
        r2.<init>();	 Catch:{ all -> 0x0031 }
        r3 = "cancel failure, e=";
        r2 = r2.append(r3);	 Catch:{ all -> 0x0031 }
        r0 = r0.getMessage();	 Catch:{ all -> 0x0031 }
        r0 = r2.append(r0);	 Catch:{ all -> 0x0031 }
        r0 = r0.toString();	 Catch:{ all -> 0x0031 }
        com.ushareit.listenit.exw.m18457e(r1, r0);	 Catch:{ all -> 0x0031 }
        r5.f3948e = r4;
        goto L_0x0010;
    L_0x0031:
        r0 = move-exception;
        r5.f3948e = r4;
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ushareit.listenit.hhw.cancel():void");
    }

    public boolean isCancelled() {
        return this.f3947d;
    }

    public void setFuture(Future<?> future) {
        this.f3948e = future;
    }
}
