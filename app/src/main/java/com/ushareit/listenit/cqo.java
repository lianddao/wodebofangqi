package com.ushareit.listenit;

import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

enum cqo implements cqs {
    INSTANCE;

    public cop mo1452a(cqd com_ushareit_listenit_cqd, col com_ushareit_listenit_col, con com_ushareit_listenit_con, coq com_ushareit_listenit_coq) {
        return new cor(com_ushareit_listenit_cqd.m12277h(), com_ushareit_listenit_con, com_ushareit_listenit_coq);
    }

    public cpw mo1453a(ScheduledExecutorService scheduledExecutorService) {
        throw new RuntimeException("Authentication is not implemented yet");
    }

    public cqj mo1454a(cqd com_ushareit_listenit_cqd) {
        return new csx(Executors.defaultThreadFactory(), csv.f8718a);
    }

    public ctu mo1455a(cqd com_ushareit_listenit_cqd, String str) {
        return null;
    }

    public cvz mo1456a(cqd com_ushareit_listenit_cqd, cwa com_ushareit_listenit_cwa, List<String> list) {
        return new cvw(com_ushareit_listenit_cwa, list);
    }

    public crt mo1457b(cqd com_ushareit_listenit_cqd) {
        return new cqp(this, com_ushareit_listenit_cqd.m12268a("RunLoop"));
    }

    public String mo1458c(cqd com_ushareit_listenit_cqd) {
        String property = System.getProperty("java.vm.name", "Unknown JVM");
        String property2 = System.getProperty("java.specification.version", "Unknown");
        return new StringBuilder((String.valueOf(property2).length() + 1) + String.valueOf(property).length()).append(property2).append("/").append(property).toString();
    }
}
