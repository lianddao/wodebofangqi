package com.ushareit.listenit;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.regex.Pattern;

public class cyt {
    private static final Pattern f9373a = Pattern.compile("[\\[\\]\\.#$]");
    private static final Pattern f9374b = Pattern.compile("[\\[\\]\\.#\\$\\/\\u0000-\\u001F\\u007F]");

    public static Map<cqq, cxa> m13394a(cqq com_ushareit_listenit_cqq, Map<String, Object> map) {
        Map treeMap = new TreeMap();
        for (Entry entry : map.entrySet()) {
            cqq com_ushareit_listenit_cqq2 = new cqq((String) entry.getKey());
            Object value = entry.getValue();
            cta.m12563a(com_ushareit_listenit_cqq.m12337a(com_ushareit_listenit_cqq2), value);
            String d = !com_ushareit_listenit_cqq2.m12347h() ? com_ushareit_listenit_cqq2.m12346g().m13144d() : "";
            if (d.equals(".sv") || d.equals(".value")) {
                String valueOf = String.valueOf(com_ushareit_listenit_cqq2);
                throw new ecf(new StringBuilder((String.valueOf(valueOf).length() + 40) + String.valueOf(d).length()).append("Path '").append(valueOf).append("' contains disallowed child name: ").append(d).toString());
            } else if (!d.equals(".priority") || cxg.m13290a(cxd.m13275a(value))) {
                m13396a(value);
                treeMap.put(com_ushareit_listenit_cqq2, cxd.m13275a(value));
            } else {
                String valueOf2 = String.valueOf(com_ushareit_listenit_cqq2);
                throw new ecf(new StringBuilder(String.valueOf(valueOf2).length() + 83).append("Path '").append(valueOf2).append("' contains invalid priority (must be a string, double, ServerValue, or null).").toString());
            }
        }
        cqq com_ushareit_listenit_cqq3 = null;
        for (cqq com_ushareit_listenit_cqq4 : treeMap.keySet()) {
            boolean z = com_ushareit_listenit_cqq3 == null || com_ushareit_listenit_cqq3.m12341c(com_ushareit_listenit_cqq4) < 0;
            cyr.m13387a(z);
            if (com_ushareit_listenit_cqq3 == null || !com_ushareit_listenit_cqq3.m12340b(com_ushareit_listenit_cqq4)) {
                com_ushareit_listenit_cqq3 = com_ushareit_listenit_cqq4;
            } else {
                valueOf2 = String.valueOf(com_ushareit_listenit_cqq3);
                d = String.valueOf(com_ushareit_listenit_cqq4);
                throw new ecf(new StringBuilder((String.valueOf(valueOf2).length() + 42) + String.valueOf(d).length()).append("Path '").append(valueOf2).append("' is an ancestor of '").append(d).append("' in an update.").toString());
            }
        }
        return treeMap;
    }

    public static void m13395a(cqq com_ushareit_listenit_cqq) {
        if (!m13399b(com_ushareit_listenit_cqq)) {
            String str = "Invalid write location: ";
            String valueOf = String.valueOf(com_ushareit_listenit_cqq.toString());
            throw new ecf(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
        }
    }

    public static void m13396a(Object obj) {
        if (obj instanceof Map) {
            Map map = (Map) obj;
            if (!map.containsKey(".sv")) {
                for (Entry entry : map.entrySet()) {
                    m13401d((String) entry.getKey());
                    m13396a(entry.getValue());
                }
            }
        } else if (obj instanceof List) {
            for (Object a : (List) obj) {
                m13396a(a);
            }
        }
    }

    public static void m13397a(String str) {
        if (!m13402e(str)) {
            throw new ecf(new StringBuilder(String.valueOf(str).length() + 101).append("Invalid Firebase Database path: ").append(str).append(". Firebase Database paths must not contain '.', '#', '$', '[', or ']'").toString());
        }
    }

    public static void m13398b(String str) {
        if (str.startsWith(".info")) {
            m13397a(str.substring(5));
        } else if (str.startsWith("/.info")) {
            m13397a(str.substring(6));
        } else {
            m13397a(str);
        }
    }

    private static boolean m13399b(cqq com_ushareit_listenit_cqq) {
        cwc d = com_ushareit_listenit_cqq.m12343d();
        return d == null || !d.m13144d().startsWith(".");
    }

    public static void m13400c(String str) {
        if (str != null && !m13404g(str)) {
            throw new ecf(new StringBuilder(String.valueOf(str).length() + 68).append("Invalid key: ").append(str).append(". Keys must not contain '/', '.', '#', '$', '[', or ']'").toString());
        }
    }

    public static void m13401d(String str) {
        if (!m13403f(str)) {
            throw new ecf(new StringBuilder(String.valueOf(str).length() + 68).append("Invalid key: ").append(str).append(". Keys must not contain '/', '.', '#', '$', '[', or ']'").toString());
        }
    }

    private static boolean m13402e(String str) {
        return !f9373a.matcher(str).find();
    }

    private static boolean m13403f(String str) {
        return str != null && str.length() > 0 && (str.equals(".value") || str.equals(".priority") || !(str.startsWith(".") || f9374b.matcher(str).find()));
    }

    private static boolean m13404g(String str) {
        return str.equals(".info") || !f9374b.matcher(str).find();
    }
}
