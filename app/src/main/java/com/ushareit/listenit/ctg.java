package com.ushareit.listenit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class ctg implements cqi {
    static final /* synthetic */ boolean f8939b = (!ctg.class.desiredAssertionStatus());
    private static ctg f8940c = new ctg();
    final HashMap<cqh, List<cqh>> f8941a = new HashMap();

    private ctg() {
    }

    public static ctg m12603a() {
        return f8940c;
    }

    private void m12604d(cqh com_ushareit_listenit_cqh) {
        int i = 0;
        synchronized (this.f8941a) {
            List list = (List) this.f8941a.get(com_ushareit_listenit_cqh);
            int i2;
            if (list != null) {
                int i3;
                for (int i4 = 0; i4 < list.size(); i4++) {
                    if (list.get(i4) == com_ushareit_listenit_cqh) {
                        i3 = 1;
                        list.remove(i4);
                        break;
                    }
                }
                i3 = 0;
                if (list.isEmpty()) {
                    this.f8941a.remove(com_ushareit_listenit_cqh);
                }
                i2 = i3;
            } else {
                i2 = 0;
            }
            if (!f8939b && r0 == 0 && com_ushareit_listenit_cqh.m12301d()) {
                throw new AssertionError();
            }
            if (!com_ushareit_listenit_cqh.mo1582a().m13005d()) {
                cqh a = com_ushareit_listenit_cqh.mo1580a(cvg.m13000a(com_ushareit_listenit_cqh.mo1582a().m13002a()));
                list = (List) this.f8941a.get(a);
                if (list != null) {
                    while (i < list.size()) {
                        if (list.get(i) == com_ushareit_listenit_cqh) {
                            list.remove(i);
                            break;
                        }
                        i++;
                    }
                    if (list.isEmpty()) {
                        this.f8941a.remove(a);
                    }
                }
            }
        }
    }

    public void mo1588a(cqh com_ushareit_listenit_cqh) {
        m12604d(com_ushareit_listenit_cqh);
    }

    public void m12606b(cqh com_ushareit_listenit_cqh) {
        synchronized (this.f8941a) {
            List list = (List) this.f8941a.get(com_ushareit_listenit_cqh);
            if (list == null) {
                list = new ArrayList();
                this.f8941a.put(com_ushareit_listenit_cqh, list);
            }
            list.add(com_ushareit_listenit_cqh);
            if (!com_ushareit_listenit_cqh.mo1582a().m13005d()) {
                cqh a = com_ushareit_listenit_cqh.mo1580a(cvg.m13000a(com_ushareit_listenit_cqh.mo1582a().m13002a()));
                list = (List) this.f8941a.get(a);
                if (list == null) {
                    list = new ArrayList();
                    this.f8941a.put(a, list);
                }
                list.add(com_ushareit_listenit_cqh);
            }
            com_ushareit_listenit_cqh.m12296a(true);
            com_ushareit_listenit_cqh.m12293a((cqi) this);
        }
    }

    public void m12607c(cqh com_ushareit_listenit_cqh) {
        synchronized (this.f8941a) {
            List list = (List) this.f8941a.get(com_ushareit_listenit_cqh);
            if (!(list == null || list.isEmpty())) {
                if (com_ushareit_listenit_cqh.mo1582a().m13005d()) {
                    HashSet hashSet = new HashSet();
                    for (int size = list.size() - 1; size >= 0; size--) {
                        cqh com_ushareit_listenit_cqh2 = (cqh) list.get(size);
                        if (!hashSet.contains(com_ushareit_listenit_cqh2.mo1582a())) {
                            hashSet.add(com_ushareit_listenit_cqh2.mo1582a());
                            com_ushareit_listenit_cqh2.m12299b();
                        }
                    }
                } else {
                    ((cqh) list.get(0)).m12299b();
                }
            }
        }
    }
}
