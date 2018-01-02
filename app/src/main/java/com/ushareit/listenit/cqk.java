package com.ushareit.listenit;

import java.util.List;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;

enum cqk implements cqs {
    INSTANCE;
    
    static ThreadFactory f8715b;
    static final csv f8716c = null;

    static {
        f8716c = new cql();
    }

    public static boolean m12303a() {
        return m12304c() != null;
    }

    private static ThreadFactory m12304c() {
        if (f8715b == null) {
            try {
                Class cls = Class.forName("com.google.appengine.api.ThreadManager");
                if (cls != null) {
                    f8715b = (ThreadFactory) cls.getMethod("backgroundThreadFactory", new Class[0]).invoke(null, new Object[0]);
                }
            } catch (ClassNotFoundException e) {
                return null;
            } catch (Throwable e2) {
                throw new RuntimeException(e2);
            } catch (Throwable e22) {
                throw new RuntimeException(e22);
            } catch (Throwable e222) {
                throw new RuntimeException(e222);
            }
        }
        return f8715b;
    }

    public cop mo1452a(cqd com_ushareit_listenit_cqd, col com_ushareit_listenit_col, con com_ushareit_listenit_con, coq com_ushareit_listenit_coq) {
        return new cor(com_ushareit_listenit_cqd.m12277h(), com_ushareit_listenit_con, com_ushareit_listenit_coq);
    }

    public cpw mo1453a(ScheduledExecutorService scheduledExecutorService) {
        throw new RuntimeException("Authentication is not implemented yet");
    }

    public cqj mo1454a(cqd com_ushareit_listenit_cqd) {
        return new csx(m12304c(), f8716c);
    }

    public ctu mo1455a(cqd com_ushareit_listenit_cqd, String str) {
        return null;
    }

    public cvz mo1456a(cqd com_ushareit_listenit_cqd, cwa com_ushareit_listenit_cwa, List<String> list) {
        return new cvw(com_ushareit_listenit_cwa, list);
    }

    public crt mo1457b(cqd com_ushareit_listenit_cqd) {
        return new cqn(this, com_ushareit_listenit_cqd.m12268a("RunLoop"));
    }

    public void m12311b() {
        cxs.m13318a(f8715b, new cqm(this));
    }

    public String mo1458c(cqd com_ushareit_listenit_cqd) {
        String str = "AppEngine";
        String property = System.getProperty("java.specification.version", "Unknown");
        return new StringBuilder((String.valueOf(property).length() + 1) + String.valueOf(str).length()).append(property).append("/").append(str).toString();
    }
}
