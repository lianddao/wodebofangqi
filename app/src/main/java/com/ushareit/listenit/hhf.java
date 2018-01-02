package com.ushareit.listenit;

import java.util.ArrayList;
import java.util.List;

public class hhf {
    private static List<hhg> f15459a = new ArrayList();

    public static void m23856a(hhg com_ushareit_listenit_hhg) {
        if (com_ushareit_listenit_hhg != null && !f15459a.contains(com_ushareit_listenit_hhg)) {
            f15459a.add(com_ushareit_listenit_hhg);
            com_ushareit_listenit_hhg.setTheme(eys.m18562a());
        }
    }

    public static void m23857b(hhg com_ushareit_listenit_hhg) {
        if (com_ushareit_listenit_hhg != null && f15459a.contains(com_ushareit_listenit_hhg)) {
            f15459a.remove(com_ushareit_listenit_hhg);
        }
    }

    public static void m23855a() {
        for (hhg theme : f15459a) {
            theme.setTheme(eys.m18562a());
        }
    }
}
