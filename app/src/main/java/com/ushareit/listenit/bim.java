package com.ushareit.listenit;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

final class bim extends bin {
    private long f6433b = -9223372036854775807L;

    public bim(bii com_ushareit_listenit_bii) {
        super(com_ushareit_listenit_bii);
    }

    public long m8594a() {
        return this.f6433b;
    }

    protected boolean mo978a(bss com_ushareit_listenit_bss) {
        return true;
    }

    protected void mo977a(bss com_ushareit_listenit_bss, long j) {
        if (m8586b(com_ushareit_listenit_bss) != 2) {
            throw new bfw();
        }
        if (!"onMetaData".equals(m8589e(com_ushareit_listenit_bss))) {
            return;
        }
        if (m8586b(com_ushareit_listenit_bss) != 8) {
            throw new bfw();
        }
        Map h = m8592h(com_ushareit_listenit_bss);
        if (h.containsKey("duration")) {
            double doubleValue = ((Double) h.get("duration")).doubleValue();
            if (doubleValue > 0.0d) {
                this.f6433b = (long) (doubleValue * 1000000.0d);
            }
        }
    }

    private static int m8586b(bss com_ushareit_listenit_bss) {
        return com_ushareit_listenit_bss.m9713g();
    }

    private static Boolean m8587c(bss com_ushareit_listenit_bss) {
        boolean z = true;
        if (com_ushareit_listenit_bss.m9713g() != 1) {
            z = false;
        }
        return Boolean.valueOf(z);
    }

    private static Double m8588d(bss com_ushareit_listenit_bss) {
        return Double.valueOf(Double.longBitsToDouble(com_ushareit_listenit_bss.m9722p()));
    }

    private static String m8589e(bss com_ushareit_listenit_bss) {
        int h = com_ushareit_listenit_bss.m9714h();
        int d = com_ushareit_listenit_bss.m9708d();
        com_ushareit_listenit_bss.m9709d(h);
        return new String(com_ushareit_listenit_bss.f7639a, d, h);
    }

    private static ArrayList<Object> m8590f(bss com_ushareit_listenit_bss) {
        int t = com_ushareit_listenit_bss.m9726t();
        ArrayList<Object> arrayList = new ArrayList(t);
        for (int i = 0; i < t; i++) {
            arrayList.add(m8585a(com_ushareit_listenit_bss, m8586b(com_ushareit_listenit_bss)));
        }
        return arrayList;
    }

    private static HashMap<String, Object> m8591g(bss com_ushareit_listenit_bss) {
        HashMap<String, Object> hashMap = new HashMap();
        while (true) {
            String e = m8589e(com_ushareit_listenit_bss);
            int b = m8586b(com_ushareit_listenit_bss);
            if (b == 9) {
                return hashMap;
            }
            hashMap.put(e, m8585a(com_ushareit_listenit_bss, b));
        }
    }

    private static HashMap<String, Object> m8592h(bss com_ushareit_listenit_bss) {
        int t = com_ushareit_listenit_bss.m9726t();
        HashMap<String, Object> hashMap = new HashMap(t);
        for (int i = 0; i < t; i++) {
            hashMap.put(m8589e(com_ushareit_listenit_bss), m8585a(com_ushareit_listenit_bss, m8586b(com_ushareit_listenit_bss)));
        }
        return hashMap;
    }

    private static Date m8593i(bss com_ushareit_listenit_bss) {
        Date date = new Date((long) m8588d(com_ushareit_listenit_bss).doubleValue());
        com_ushareit_listenit_bss.m9709d(2);
        return date;
    }

    private static Object m8585a(bss com_ushareit_listenit_bss, int i) {
        switch (i) {
            case 0:
                return m8588d(com_ushareit_listenit_bss);
            case 1:
                return m8587c(com_ushareit_listenit_bss);
            case 2:
                return m8589e(com_ushareit_listenit_bss);
            case 3:
                return m8591g(com_ushareit_listenit_bss);
            case 8:
                return m8592h(com_ushareit_listenit_bss);
            case 10:
                return m8590f(com_ushareit_listenit_bss);
            case 11:
                return m8593i(com_ushareit_listenit_bss);
            default:
                return null;
        }
    }
}
