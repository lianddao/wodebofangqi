package com.ushareit.listenit;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class efy {
    public static efy f11007a = new efy();
    private static BlockingQueue<Runnable> f11008b = new LinkedBlockingQueue(128);
    private static final ThreadPoolExecutor f11009c = new ThreadPoolExecutor(5, 5, 5, TimeUnit.SECONDS, f11008b, new efz("Command-"));
    private static BlockingQueue<Runnable> f11010d = new LinkedBlockingQueue(128);
    private static final ThreadPoolExecutor f11011e = new ThreadPoolExecutor(2, 2, 5, TimeUnit.SECONDS, f11010d, new efz("Upload-"));
    private static BlockingQueue<Runnable> f11012f = new LinkedBlockingQueue(128);
    private static final ThreadPoolExecutor f11013g = new ThreadPoolExecutor(3, 3, 5, TimeUnit.SECONDS, f11012f, new efz("Download-"));
    private static BlockingQueue<Runnable> f11014h = new LinkedBlockingQueue(128);
    private static final ThreadPoolExecutor f11015i = new ThreadPoolExecutor(1, 1, 5, TimeUnit.SECONDS, f11014h, new efz("Callbacks-"));

    static {
        f11009c.allowCoreThreadTimeOut(true);
        f11011e.allowCoreThreadTimeOut(true);
        f11013g.allowCoreThreadTimeOut(true);
        f11015i.allowCoreThreadTimeOut(true);
    }

    public static efy m17045a() {
        return f11007a;
    }

    public void m17046a(Runnable runnable) {
        f11009c.execute(runnable);
    }

    public void m17047b(Runnable runnable) {
        f11011e.execute(runnable);
    }

    public void m17048c(Runnable runnable) {
        f11013g.execute(runnable);
    }

    public void m17049d(Runnable runnable) {
        f11015i.execute(runnable);
    }
}
