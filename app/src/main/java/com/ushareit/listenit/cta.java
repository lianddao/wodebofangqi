package com.ushareit.listenit;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class cta {
    private final List<String> f8922a = new ArrayList();
    private int f8923b = 0;

    private cta(cqq com_ushareit_listenit_cqq) {
        int i = 0;
        Iterator it = com_ushareit_listenit_cqq.iterator();
        while (it.hasNext()) {
            this.f8922a.add(((cwc) it.next()).m13144d());
        }
        this.f8923b = Math.max(1, this.f8922a.size());
        while (i < this.f8922a.size()) {
            this.f8923b = m12560a((CharSequence) this.f8922a.get(i)) + this.f8923b;
            i++;
        }
        m12566b();
    }

    private static int m12560a(CharSequence charSequence) {
        int i = 0;
        int length = charSequence.length();
        int i2 = 0;
        while (i < length) {
            char charAt = charSequence.charAt(i);
            if (charAt <= '') {
                i2++;
            } else if (charAt <= '߿') {
                i2 += 2;
            } else if (Character.isHighSurrogate(charAt)) {
                i2 += 4;
                i++;
            } else {
                i2 += 3;
            }
            i++;
        }
        return i2;
    }

    private String m12561a() {
        CharSequence charSequence = (String) this.f8922a.remove(this.f8922a.size() - 1);
        this.f8923b -= m12560a(charSequence);
        if (this.f8922a.size() > 0) {
            this.f8923b--;
        }
        return charSequence;
    }

    private static String m12562a(String str, List<String> list) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            if (i > 0) {
                stringBuilder.append(str);
            }
            stringBuilder.append((String) list.get(i));
        }
        return stringBuilder.toString();
    }

    public static void m12563a(cqq com_ushareit_listenit_cqq, Object obj) {
        new cta(com_ushareit_listenit_cqq).m12564a(obj);
    }

    private void m12564a(Object obj) {
        if (obj instanceof Map) {
            Map map = (Map) obj;
            for (String str : map.keySet()) {
                if (!str.startsWith(".")) {
                    m12565a(str);
                    m12564a(map.get(str));
                    m12561a();
                }
            }
        } else if (obj instanceof List) {
            List list = (List) obj;
            for (int i = 0; i < list.size(); i++) {
                m12565a(Integer.toString(i));
                m12564a(list.get(i));
                m12561a();
            }
        }
    }

    private void m12565a(String str) {
        if (this.f8922a.size() > 0) {
            this.f8923b++;
        }
        this.f8922a.add(str);
        this.f8923b += m12560a((CharSequence) str);
        m12566b();
    }

    private void m12566b() {
        if (this.f8923b > 768) {
            String valueOf = String.valueOf("Data has a key path longer than 768 bytes (");
            throw new ecf(new StringBuilder(String.valueOf(valueOf).length() + 13).append(valueOf).append(this.f8923b).append(").").toString());
        } else if (this.f8922a.size() > 32) {
            String valueOf2 = String.valueOf("Path specified exceeds the maximum depth that can be written (32) or object contains a cycle ");
            String valueOf3 = String.valueOf(m12567c());
            throw new ecf(valueOf3.length() != 0 ? valueOf2.concat(valueOf3) : new String(valueOf2));
        }
    }

    private String m12567c() {
        if (this.f8922a.size() == 0) {
            return "";
        }
        String valueOf = String.valueOf(m12562a("/", this.f8922a));
        return new StringBuilder(String.valueOf(valueOf).length() + 10).append("in path '").append(valueOf).append("'").toString();
    }
}
