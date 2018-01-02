package com.ushareit.listenit;

import android.text.TextUtils;
import com.umeng.analytics.pro.C0277j;
import java.util.Arrays;
import java.util.BitSet;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class dwm extends duy {
    dwm(dyf com_ushareit_listenit_dyf) {
        super(com_ushareit_listenit_dyf);
    }

    private Boolean m15996a(drg com_ushareit_listenit_drg, drr com_ushareit_listenit_drr, long j) {
        Boolean a;
        if (com_ushareit_listenit_drg.f10187e != null) {
            a = new dxq(com_ushareit_listenit_drg.f10187e).m16303a(j);
            if (a == null) {
                return null;
            }
            if (!a.booleanValue()) {
                return Boolean.valueOf(false);
            }
        }
        Set hashSet = new HashSet();
        for (drh com_ushareit_listenit_drh : com_ushareit_listenit_drg.f10185c) {
            if (TextUtils.isEmpty(com_ushareit_listenit_drh.f10192d)) {
                mo2096w().m16262z().m16264a("null or empty param name in filter. event", com_ushareit_listenit_drr.f10226b);
                return null;
            }
            hashSet.add(com_ushareit_listenit_drh.f10192d);
        }
        Map fqVar = new fq();
        for (drs com_ushareit_listenit_drs : com_ushareit_listenit_drr.f10225a) {
            if (hashSet.contains(com_ushareit_listenit_drs.f10231a)) {
                if (com_ushareit_listenit_drs.f10233c != null) {
                    fqVar.put(com_ushareit_listenit_drs.f10231a, com_ushareit_listenit_drs.f10233c);
                } else if (com_ushareit_listenit_drs.f10235e != null) {
                    fqVar.put(com_ushareit_listenit_drs.f10231a, com_ushareit_listenit_drs.f10235e);
                } else if (com_ushareit_listenit_drs.f10232b != null) {
                    fqVar.put(com_ushareit_listenit_drs.f10231a, com_ushareit_listenit_drs.f10232b);
                } else {
                    mo2096w().m16262z().m16265a("Unknown value for param. event, param", com_ushareit_listenit_drr.f10226b, com_ushareit_listenit_drs.f10231a);
                    return null;
                }
            }
        }
        for (drh com_ushareit_listenit_drh2 : com_ushareit_listenit_drg.f10185c) {
            boolean equals = Boolean.TRUE.equals(com_ushareit_listenit_drh2.f10191c);
            CharSequence charSequence = com_ushareit_listenit_drh2.f10192d;
            if (TextUtils.isEmpty(charSequence)) {
                mo2096w().m16262z().m16264a("Event has empty param name. event", com_ushareit_listenit_drr.f10226b);
                return null;
            }
            Object obj = fqVar.get(charSequence);
            if (obj instanceof Long) {
                if (com_ushareit_listenit_drh2.f10190b == null) {
                    mo2096w().m16262z().m16265a("No number filter for long param. event, param", com_ushareit_listenit_drr.f10226b, charSequence);
                    return null;
                }
                a = new dxq(com_ushareit_listenit_drh2.f10190b).m16303a(((Long) obj).longValue());
                if (a == null) {
                    return null;
                }
                if (((!a.booleanValue() ? 1 : 0) ^ equals) != 0) {
                    return Boolean.valueOf(false);
                }
            } else if (obj instanceof Double) {
                if (com_ushareit_listenit_drh2.f10190b == null) {
                    mo2096w().m16262z().m16265a("No number filter for double param. event, param", com_ushareit_listenit_drr.f10226b, charSequence);
                    return null;
                }
                a = new dxq(com_ushareit_listenit_drh2.f10190b).m16302a(((Double) obj).doubleValue());
                if (a == null) {
                    return null;
                }
                if (((!a.booleanValue() ? 1 : 0) ^ equals) != 0) {
                    return Boolean.valueOf(false);
                }
            } else if (obj instanceof String) {
                if (com_ushareit_listenit_drh2.f10189a == null) {
                    mo2096w().m16262z().m16265a("No string filter for String param. event, param", com_ushareit_listenit_drr.f10226b, charSequence);
                    return null;
                }
                a = new dwe(com_ushareit_listenit_drh2.f10189a).m15884a((String) obj);
                if (a == null) {
                    return null;
                }
                if (((!a.booleanValue() ? 1 : 0) ^ equals) != 0) {
                    return Boolean.valueOf(false);
                }
            } else if (obj == null) {
                mo2096w().m16235E().m16265a("Missing param for filter. event, param", com_ushareit_listenit_drr.f10226b, charSequence);
                return Boolean.valueOf(false);
            } else {
                mo2096w().m16262z().m16265a("Unknown param type. event, param", com_ushareit_listenit_drr.f10226b, charSequence);
                return null;
            }
        }
        return Boolean.valueOf(true);
    }

    private Boolean m15997a(drj com_ushareit_listenit_drj, drw com_ushareit_listenit_drw) {
        drh com_ushareit_listenit_drh = com_ushareit_listenit_drj.f10201c;
        if (com_ushareit_listenit_drh == null) {
            mo2096w().m16262z().m16264a("Missing property filter. property", com_ushareit_listenit_drw.f10274b);
            return null;
        }
        boolean equals = Boolean.TRUE.equals(com_ushareit_listenit_drh.f10191c);
        if (com_ushareit_listenit_drw.f10276d != null) {
            if (com_ushareit_listenit_drh.f10190b != null) {
                return m15998a(new dxq(com_ushareit_listenit_drh.f10190b).m16303a(com_ushareit_listenit_drw.f10276d.longValue()), equals);
            }
            mo2096w().m16262z().m16264a("No number filter for long property. property", com_ushareit_listenit_drw.f10274b);
            return null;
        } else if (com_ushareit_listenit_drw.f10278f != null) {
            if (com_ushareit_listenit_drh.f10190b != null) {
                return m15998a(new dxq(com_ushareit_listenit_drh.f10190b).m16302a(com_ushareit_listenit_drw.f10278f.doubleValue()), equals);
            }
            mo2096w().m16262z().m16264a("No number filter for double property. property", com_ushareit_listenit_drw.f10274b);
            return null;
        } else if (com_ushareit_listenit_drw.f10275c == null) {
            mo2096w().m16262z().m16264a("User property has no value, property", com_ushareit_listenit_drw.f10274b);
            return null;
        } else if (com_ushareit_listenit_drh.f10189a != null) {
            return m15998a(new dwe(com_ushareit_listenit_drh.f10189a).m15884a(com_ushareit_listenit_drw.f10275c), equals);
        } else {
            if (com_ushareit_listenit_drh.f10190b == null) {
                mo2096w().m16262z().m16264a("No string or number filter defined. property", com_ushareit_listenit_drw.f10274b);
                return null;
            }
            dxq com_ushareit_listenit_dxq = new dxq(com_ushareit_listenit_drh.f10190b);
            if (dwk.m15940n(com_ushareit_listenit_drw.f10275c)) {
                return m15998a(com_ushareit_listenit_dxq.m16304a(com_ushareit_listenit_drw.f10275c), equals);
            }
            mo2096w().m16262z().m16265a("Invalid user property value for Numeric number filter. property, value", com_ushareit_listenit_drw.f10274b, com_ushareit_listenit_drw.f10275c);
            return null;
        }
    }

    static Boolean m15998a(Boolean bool, boolean z) {
        return bool == null ? null : Boolean.valueOf(bool.booleanValue() ^ z);
    }

    void m15999a(String str, drf[] com_ushareit_listenit_drfArr) {
        cfi.m11080a((Object) com_ushareit_listenit_drfArr);
        for (drf com_ushareit_listenit_drf : com_ushareit_listenit_drfArr) {
            for (drg com_ushareit_listenit_drg : com_ushareit_listenit_drf.f10181c) {
                String str2 = (String) dur.f10335a.get(com_ushareit_listenit_drg.f10184b);
                if (str2 != null) {
                    com_ushareit_listenit_drg.f10184b = str2;
                }
                for (drh com_ushareit_listenit_drh : com_ushareit_listenit_drg.f10185c) {
                    str2 = (String) duu.f10336a.get(com_ushareit_listenit_drh.f10192d);
                    if (str2 != null) {
                        com_ushareit_listenit_drh.f10192d = str2;
                    }
                }
            }
            for (drj com_ushareit_listenit_drj : com_ushareit_listenit_drf.f10180b) {
                str2 = (String) duv.f10337a.get(com_ushareit_listenit_drj.f10200b);
                if (str2 != null) {
                    com_ushareit_listenit_drj.f10200b = str2;
                }
            }
        }
        mo2091r().m16104a(str, com_ushareit_listenit_drfArr);
    }

    drq[] m16000a(String str, drr[] com_ushareit_listenit_drrArr, drw[] com_ushareit_listenit_drwArr) {
        int intValue;
        BitSet bitSet;
        BitSet bitSet2;
        Map map;
        Map map2;
        Boolean a;
        Object obj;
        cfi.m11082a(str);
        Set hashSet = new HashSet();
        fq fqVar = new fq();
        Map fqVar2 = new fq();
        fq fqVar3 = new fq();
        Map f = mo2091r().m16120f(str);
        if (f != null) {
            for (Integer intValue2 : f.keySet()) {
                intValue = intValue2.intValue();
                drv com_ushareit_listenit_drv = (drv) f.get(Integer.valueOf(intValue));
                bitSet = (BitSet) fqVar2.get(Integer.valueOf(intValue));
                bitSet2 = (BitSet) fqVar3.get(Integer.valueOf(intValue));
                if (bitSet == null) {
                    bitSet = new BitSet();
                    fqVar2.put(Integer.valueOf(intValue), bitSet);
                    bitSet2 = new BitSet();
                    fqVar3.put(Integer.valueOf(intValue), bitSet2);
                }
                for (int i = 0; i < com_ushareit_listenit_drv.f10270a.length * 64; i++) {
                    if (dwk.m15933a(com_ushareit_listenit_drv.f10270a, i)) {
                        mo2096w().m16235E().m16265a("Filter already evaluated. audience ID, filter ID", Integer.valueOf(intValue), Integer.valueOf(i));
                        bitSet2.set(i);
                        if (dwk.m15933a(com_ushareit_listenit_drv.f10271b, i)) {
                            bitSet.set(i);
                        }
                    }
                }
                drq com_ushareit_listenit_drq = new drq();
                fqVar.put(Integer.valueOf(intValue), com_ushareit_listenit_drq);
                com_ushareit_listenit_drq.f10223d = Boolean.valueOf(false);
                com_ushareit_listenit_drq.f10222c = com_ushareit_listenit_drv;
                com_ushareit_listenit_drq.f10221b = new drv();
                com_ushareit_listenit_drq.f10221b.f10271b = dwk.m15934a(bitSet);
                com_ushareit_listenit_drq.f10221b.f10270a = dwk.m15934a(bitSet2);
            }
        }
        if (com_ushareit_listenit_drrArr != null) {
            fq fqVar4 = new fq();
            for (drr com_ushareit_listenit_drr : com_ushareit_listenit_drrArr) {
                dww com_ushareit_listenit_dww;
                dww a2 = mo2091r().m16090a(str, com_ushareit_listenit_drr.f10226b);
                if (a2 == null) {
                    mo2096w().m16262z().m16264a("Event aggregate wasn't created during raw event logging. event", com_ushareit_listenit_drr.f10226b);
                    com_ushareit_listenit_dww = new dww(str, com_ushareit_listenit_drr.f10226b, 1, 1, com_ushareit_listenit_drr.f10227c.longValue());
                } else {
                    com_ushareit_listenit_dww = a2.m16160a();
                }
                mo2091r().m16098a(com_ushareit_listenit_dww);
                long j = com_ushareit_listenit_dww.f10503c;
                map = (Map) fqVar4.get(com_ushareit_listenit_drr.f10226b);
                if (map == null) {
                    map = mo2091r().m16115d(str, com_ushareit_listenit_drr.f10226b);
                    if (map == null) {
                        map = new fq();
                    }
                    fqVar4.put(com_ushareit_listenit_drr.f10226b, map);
                    map2 = map;
                } else {
                    map2 = map;
                }
                for (Integer intValue22 : r7.keySet()) {
                    int intValue3 = intValue22.intValue();
                    if (hashSet.contains(Integer.valueOf(intValue3))) {
                        mo2096w().m16235E().m16264a("Skipping failed audience ID", Integer.valueOf(intValue3));
                    } else {
                        bitSet = (BitSet) fqVar2.get(Integer.valueOf(intValue3));
                        bitSet2 = (BitSet) fqVar3.get(Integer.valueOf(intValue3));
                        if (((drq) fqVar.get(Integer.valueOf(intValue3))) == null) {
                            drq com_ushareit_listenit_drq2 = new drq();
                            fqVar.put(Integer.valueOf(intValue3), com_ushareit_listenit_drq2);
                            com_ushareit_listenit_drq2.f10223d = Boolean.valueOf(true);
                            bitSet = new BitSet();
                            fqVar2.put(Integer.valueOf(intValue3), bitSet);
                            bitSet2 = new BitSet();
                            fqVar3.put(Integer.valueOf(intValue3), bitSet2);
                        }
                        for (drg com_ushareit_listenit_drg : (List) r7.get(Integer.valueOf(intValue3))) {
                            if (mo2096w().m16240a(2)) {
                                mo2096w().m16235E().m16266a("Evaluating filter. audience, filter, event", Integer.valueOf(intValue3), com_ushareit_listenit_drg.f10183a, com_ushareit_listenit_drg.f10184b);
                                mo2096w().m16235E().m16264a("Filter definition", dwk.m15917a(com_ushareit_listenit_drg));
                            }
                            if (com_ushareit_listenit_drg.f10183a == null || com_ushareit_listenit_drg.f10183a.intValue() > C0277j.f3694e) {
                                mo2096w().m16262z().m16264a("Invalid event filter ID. id", String.valueOf(com_ushareit_listenit_drg.f10183a));
                            } else if (bitSet.get(com_ushareit_listenit_drg.f10183a.intValue())) {
                                mo2096w().m16235E().m16265a("Event filter already evaluated true. audience ID, filter ID", Integer.valueOf(intValue3), com_ushareit_listenit_drg.f10183a);
                            } else {
                                a = m15996a(com_ushareit_listenit_drg, com_ushareit_listenit_drr, j);
                                dxi E = mo2096w().m16235E();
                                String str2 = "Event filter result";
                                if (a == null) {
                                    obj = "null";
                                } else {
                                    Boolean bool = a;
                                }
                                E.m16264a(str2, obj);
                                if (a == null) {
                                    hashSet.add(Integer.valueOf(intValue3));
                                } else {
                                    bitSet2.set(com_ushareit_listenit_drg.f10183a.intValue());
                                    if (a.booleanValue()) {
                                        bitSet.set(com_ushareit_listenit_drg.f10183a.intValue());
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        if (com_ushareit_listenit_drwArr != null) {
            Map fqVar5 = new fq();
            for (drw com_ushareit_listenit_drw : com_ushareit_listenit_drwArr) {
                map = (Map) fqVar5.get(com_ushareit_listenit_drw.f10274b);
                if (map == null) {
                    map = mo2091r().m16117e(str, com_ushareit_listenit_drw.f10274b);
                    if (map == null) {
                        map = new fq();
                    }
                    fqVar5.put(com_ushareit_listenit_drw.f10274b, map);
                    map2 = map;
                } else {
                    map2 = map;
                }
                for (Integer intValue222 : r7.keySet()) {
                    int intValue4 = intValue222.intValue();
                    if (hashSet.contains(Integer.valueOf(intValue4))) {
                        mo2096w().m16235E().m16264a("Skipping failed audience ID", Integer.valueOf(intValue4));
                    } else {
                        bitSet = (BitSet) fqVar2.get(Integer.valueOf(intValue4));
                        bitSet2 = (BitSet) fqVar3.get(Integer.valueOf(intValue4));
                        if (((drq) fqVar.get(Integer.valueOf(intValue4))) == null) {
                            com_ushareit_listenit_drq2 = new drq();
                            fqVar.put(Integer.valueOf(intValue4), com_ushareit_listenit_drq2);
                            com_ushareit_listenit_drq2.f10223d = Boolean.valueOf(true);
                            bitSet = new BitSet();
                            fqVar2.put(Integer.valueOf(intValue4), bitSet);
                            bitSet2 = new BitSet();
                            fqVar3.put(Integer.valueOf(intValue4), bitSet2);
                        }
                        for (drj com_ushareit_listenit_drj : (List) r7.get(Integer.valueOf(intValue4))) {
                            if (mo2096w().m16240a(2)) {
                                mo2096w().m16235E().m16266a("Evaluating filter. audience, filter, property", Integer.valueOf(intValue4), com_ushareit_listenit_drj.f10199a, com_ushareit_listenit_drj.f10200b);
                                mo2096w().m16235E().m16264a("Filter definition", dwk.m15918a(com_ushareit_listenit_drj));
                            }
                            if (com_ushareit_listenit_drj.f10199a == null || com_ushareit_listenit_drj.f10199a.intValue() > C0277j.f3694e) {
                                mo2096w().m16262z().m16264a("Invalid property filter ID. id", String.valueOf(com_ushareit_listenit_drj.f10199a));
                                hashSet.add(Integer.valueOf(intValue4));
                                break;
                            } else if (bitSet.get(com_ushareit_listenit_drj.f10199a.intValue())) {
                                mo2096w().m16235E().m16265a("Property filter already evaluated true. audience ID, filter ID", Integer.valueOf(intValue4), com_ushareit_listenit_drj.f10199a);
                            } else {
                                a = m15997a(com_ushareit_listenit_drj, com_ushareit_listenit_drw);
                                dxi E2 = mo2096w().m16235E();
                                String str3 = "Property filter result";
                                if (a == null) {
                                    obj = "null";
                                } else {
                                    bool = a;
                                }
                                E2.m16264a(str3, obj);
                                if (a == null) {
                                    hashSet.add(Integer.valueOf(intValue4));
                                } else {
                                    bitSet2.set(com_ushareit_listenit_drj.f10199a.intValue());
                                    if (a.booleanValue()) {
                                        bitSet.set(com_ushareit_listenit_drj.f10199a.intValue());
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        drq[] com_ushareit_listenit_drqArr = new drq[fqVar2.size()];
        int i2 = 0;
        for (Integer intValue2222 : fqVar2.keySet()) {
            intValue = intValue2222.intValue();
            if (!hashSet.contains(Integer.valueOf(intValue))) {
                com_ushareit_listenit_drq2 = (drq) fqVar.get(Integer.valueOf(intValue));
                com_ushareit_listenit_drq = com_ushareit_listenit_drq2 == null ? new drq() : com_ushareit_listenit_drq2;
                int i3 = i2 + 1;
                com_ushareit_listenit_drqArr[i2] = com_ushareit_listenit_drq;
                com_ushareit_listenit_drq.f10220a = Integer.valueOf(intValue);
                com_ushareit_listenit_drq.f10221b = new drv();
                com_ushareit_listenit_drq.f10221b.f10271b = dwk.m15934a((BitSet) fqVar2.get(Integer.valueOf(intValue)));
                com_ushareit_listenit_drq.f10221b.f10270a = dwk.m15934a((BitSet) fqVar3.get(Integer.valueOf(intValue)));
                mo2091r().m16100a(str, intValue, com_ushareit_listenit_drq.f10221b);
                i2 = i3;
            }
        }
        return (drq[]) Arrays.copyOf(com_ushareit_listenit_drqArr, i2);
    }

    protected void mo2080e() {
    }
}
