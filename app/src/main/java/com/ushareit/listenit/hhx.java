package com.ushareit.listenit;

import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class hhx {
    private static HashMap<String, hhw> f15471a;
    private static HashMap<String, ExecutorService> f15472b;
    private static Handler f15473c = new hhz(Looper.getMainLooper());

    public static void m23867a(hhw com_ushareit_listenit_hhw) {
        m23869a(com_ushareit_listenit_hhw, 0, 0);
    }

    public static void m23869a(hhw com_ushareit_listenit_hhw, int i, int i2) {
        m23878d(com_ushareit_listenit_hhw);
        if (com_ushareit_listenit_hhw instanceof hib) {
            m23877c(com_ushareit_listenit_hhw, i2);
            return;
        }
        if (i == 0) {
            m23879d(com_ushareit_listenit_hhw, i2);
        } else {
            m23875b(com_ushareit_listenit_hhw, i, i2);
        }
        m23876c(com_ushareit_listenit_hhw);
    }

    private static void m23876c(hhw com_ushareit_listenit_hhw) {
        int i = 0;
        if (!(com_ushareit_listenit_hhw instanceof hib) && m23871a()) {
            String str;
            StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
            int length = stackTrace.length;
            int i2 = 0;
            while (i < length) {
                String className = stackTrace[i].getClassName();
                if (i2 != 0 && !fbb.m18763c(className) && !className.contains(hhx.class.getSimpleName())) {
                    i2 = i;
                    break;
                }
                if (!fbb.m18763c(className) && className.contains(hhx.class.getSimpleName())) {
                    i2 = 1;
                }
                i++;
            }
            i2 = -1;
            String str2 = "Not Find";
            if (i2 >= 0) {
                String className2 = stackTrace[i2].getClassName();
                str2 = m23881f(com_ushareit_listenit_hhw).toString();
                if (str2.contains("[") && str2.contains("]")) {
                    str2 = com_ushareit_listenit_hhw.mo2314a() + "ThreadPool" + str2.substring(str2.lastIndexOf("["), str2.lastIndexOf("]") + 1);
                }
                if (className2.contains(".")) {
                    str2 = str2 + ", " + className2.substring(className2.lastIndexOf(".") + 1, className2.length()) + "." + stackTrace[i2].getMethodName();
                } else {
                    str2 = str2 + ", " + className2;
                }
                str = str2 + ": " + stackTrace[i2].getLineNumber();
            } else {
                str = str2;
            }
            exw.m18454c("TaskHelper", "exec task: " + str);
        }
    }

    private static void m23875b(hhw com_ushareit_listenit_hhw, int i, int i2) {
        Message obtainMessage = f15473c.obtainMessage(1);
        obtainMessage.obj = com_ushareit_listenit_hhw;
        obtainMessage.arg1 = i2;
        f15473c.sendMessageDelayed(obtainMessage, (long) i);
    }

    private static void m23878d(hhw com_ushareit_listenit_hhw) {
        if (com_ushareit_listenit_hhw != null) {
            m23872b();
            synchronized (f15471a) {
                String taskId = com_ushareit_listenit_hhw.getTaskId();
                boolean containsKey = f15471a.containsKey(taskId);
                exw.m18454c("TaskHelper", "checknewTask: containsTask=" + containsKey + ", id=" + taskId);
                if (containsKey) {
                    hhw com_ushareit_listenit_hhw2 = (hhw) f15471a.remove(taskId);
                    com_ushareit_listenit_hhw2.cancel();
                    if (f15473c.hasMessages(1, com_ushareit_listenit_hhw2)) {
                        exw.m18454c("TaskHelper", "remove exec message, taskid=" + taskId);
                        f15473c.removeMessages(1, com_ushareit_listenit_hhw2);
                    }
                    if (f15473c.hasMessages(2, com_ushareit_listenit_hhw2)) {
                        exw.m18454c("TaskHelper", "remove callback message, taskid=" + taskId);
                        f15473c.removeMessages(2, com_ushareit_listenit_hhw2);
                    }
                }
                f15471a.put(taskId, com_ushareit_listenit_hhw);
            }
        }
    }

    public static void m23870a(String str) {
        m23872b();
        synchronized (f15471a) {
            if (f15471a.containsKey(str)) {
                ((hhw) f15471a.get(str)).cancel();
            }
        }
    }

    private static void m23877c(hhw com_ushareit_listenit_hhw, int i) {
        f15473c.sendMessageDelayed(f15473c.obtainMessage(2, com_ushareit_listenit_hhw), (long) i);
    }

    private static void m23879d(hhw com_ushareit_listenit_hhw, int i) {
        if (!com_ushareit_listenit_hhw.isCancelled()) {
            Future submit = m23881f(com_ushareit_listenit_hhw).submit(new hhy(com_ushareit_listenit_hhw.getPriority(), com_ushareit_listenit_hhw, i));
            m23872b();
            synchronized (f15471a) {
                if (!com_ushareit_listenit_hhw.isCancelled()) {
                    com_ushareit_listenit_hhw.setFuture(submit);
                }
                exw.m18443a("TaskHelper", "add new task.future=" + com_ushareit_listenit_hhw.getTaskId() + ", containsKey=" + f15471a.containsKey(com_ushareit_listenit_hhw.getTaskId()));
            }
        }
    }

    private static void m23880e(hhw com_ushareit_listenit_hhw) {
        if (!com_ushareit_listenit_hhw.isCancelled()) {
            try {
                com_ushareit_listenit_hhw.callback();
            } catch (Exception e) {
                exw.m18457e("TaskHelper", "callback error, " + e.getMessage());
            }
            synchronized (f15471a) {
                f15471a.remove(com_ushareit_listenit_hhw.getTaskId());
                exw.m18443a("TaskHelper", "callback finish remove task=" + com_ushareit_listenit_hhw.getTaskId());
            }
        }
    }

    private static synchronized void m23872b() {
        synchronized (hhx.class) {
            if (f15471a == null) {
                f15471a = new HashMap();
            }
        }
    }

    private static synchronized ExecutorService m23881f(hhw com_ushareit_listenit_hhw) {
        ExecutorService executorService;
        synchronized (hhx.class) {
            if (f15472b == null) {
                f15472b = new HashMap();
            }
            String a = com_ushareit_listenit_hhw.mo2314a();
            if (fbb.m18763c(a)) {
                throw new RuntimeException("no executor type");
            }
            if (f15472b.containsKey(a)) {
                executorService = (ExecutorService) f15472b.get(a);
            } else {
                executorService = com_ushareit_listenit_hhw.mo2315b();
                if (executorService != null) {
                    f15472b.put(a, executorService);
                } else {
                    int max = Math.max(1, Runtime.getRuntime().availableProcessors());
                    if (VERSION.SDK_INT >= 9) {
                        executorService = new hhi(max);
                    } else {
                        Object threadPoolExecutor = new ThreadPoolExecutor(max, max, 0, TimeUnit.SECONDS, new LinkedBlockingQueue());
                    }
                    f15472b.put(a, executorService);
                }
            }
        }
        return executorService;
    }

    public static boolean m23871a() {
        try {
            if ((eys.m18562a().getApplicationInfo().flags & 2) != 0) {
                return true;
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }
}
