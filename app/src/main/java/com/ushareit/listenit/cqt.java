package com.ushareit.listenit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class cqt implements coq {
    static final /* synthetic */ boolean f8733b = (!cqt.class.desiredAssertionStatus());
    public long f8734a = 0;
    private final crr f8735c;
    private final cyo f8736d = new cyo(new cyi(), 0);
    private final cop f8737e;
    private crx f8738f;
    private cry f8739g;
    private cuo<List<crp>> f8740h;
    private boolean f8741i = false;
    private final cvb f8742j;
    private final cqd f8743k;
    private final cvy f8744l;
    private final cvy f8745m;
    private final cvy f8746n;
    private long f8747o = 1;
    private csd f8748p;
    private csd f8749q;
    private ecl f8750r;
    private boolean f8751s = false;
    private long f8752t = 0;

    cqt(crr com_ushareit_listenit_crr, cqd com_ushareit_listenit_cqd, ecl com_ushareit_listenit_ecl) {
        this.f8735c = com_ushareit_listenit_crr;
        this.f8743k = com_ushareit_listenit_cqd;
        this.f8750r = com_ushareit_listenit_ecl;
        this.f8744l = this.f8743k.m12268a("RepoOperation");
        this.f8745m = this.f8743k.m12268a("Transaction");
        this.f8746n = this.f8743k.m12268a("DataOperation");
        this.f8742j = new cvb(this.f8743k);
        this.f8737e = com_ushareit_listenit_cqd.m12267a(new con(com_ushareit_listenit_crr.f8825a, com_ushareit_listenit_crr.f8827c, com_ushareit_listenit_crr.f8826b), this);
        m12396a(new cqu(this));
    }

    private cqq m12350a(cqq com_ushareit_listenit_cqq) {
        cuo b = m12371b(com_ushareit_listenit_cqq);
        cqq b2 = b.m12771b();
        m12377b(m12379c(b), b2);
        return b2;
    }

    private cqq m12351a(cqq com_ushareit_listenit_cqq, int i) {
        cqq b = m12371b(com_ushareit_listenit_cqq).m12771b();
        if (this.f8745m.m13094a()) {
            cvy com_ushareit_listenit_cvy = this.f8744l;
            String valueOf = String.valueOf(com_ushareit_listenit_cqq);
            String valueOf2 = String.valueOf(b);
            com_ushareit_listenit_cvy.m13093a(new StringBuilder((String.valueOf(valueOf).length() + 44) + String.valueOf(valueOf2).length()).append("Aborting transactions for path: ").append(valueOf).append(". Affected: ").append(valueOf2).toString(), new Object[0]);
        }
        cuo a = this.f8740h.m12763a(com_ushareit_listenit_cqq);
        a.m12769a(new cqz(this, i));
        m12366a(a, i);
        a.m12766a(new cra(this, i));
        return b;
    }

    private cxa m12354a(cqq com_ushareit_listenit_cqq, List<Long> list) {
        cxa b = this.f8749q.m12522b(com_ushareit_listenit_cqq, (List) list);
        return b == null ? cwr.m13215j() : b;
    }

    private void m12356a(long j, cqq com_ushareit_listenit_cqq, ece com_ushareit_listenit_ece) {
        if (com_ushareit_listenit_ece == null || com_ushareit_listenit_ece.m16714a() != -25) {
            List a = this.f8749q.m12509a(j, !(com_ushareit_listenit_ece == null), true, this.f8736d);
            if (a.size() > 0) {
                m12350a(com_ushareit_listenit_cqq);
            }
            m12368a(a);
        }
    }

    private void m12364a(ctu com_ushareit_listenit_ctu) {
        List<csz> a = com_ushareit_listenit_ctu.mo1596a();
        Map a2 = cru.m12453a(this.f8736d);
        long j = Long.MIN_VALUE;
        for (csz com_ushareit_listenit_csz : a) {
            cph com_ushareit_listenit_crg = new crg(this, com_ushareit_listenit_csz);
            if (j >= com_ushareit_listenit_csz.m12551a()) {
                throw new IllegalStateException("Write ids were not in order.");
            }
            long a3 = com_ushareit_listenit_csz.m12551a();
            this.f8747o = com_ushareit_listenit_csz.m12551a() + 1;
            if (com_ushareit_listenit_csz.m12555e()) {
                if (this.f8744l.m13094a()) {
                    this.f8744l.m13093a("Restoring overwrite with id " + com_ushareit_listenit_csz.m12551a(), new Object[0]);
                }
                this.f8737e.mo1521a(com_ushareit_listenit_csz.m12552b().m12342c(), com_ushareit_listenit_csz.m12553c().mo1632a(true), com_ushareit_listenit_crg);
                this.f8749q.m12515a(com_ushareit_listenit_csz.m12552b(), com_ushareit_listenit_csz.m12553c(), cru.m12451a(com_ushareit_listenit_csz.m12553c(), a2), com_ushareit_listenit_csz.m12551a(), true, false);
            } else {
                if (this.f8744l.m13094a()) {
                    this.f8744l.m13093a("Restoring merge with id " + com_ushareit_listenit_csz.m12551a(), new Object[0]);
                }
                this.f8737e.mo1525a(com_ushareit_listenit_csz.m12552b().m12342c(), com_ushareit_listenit_csz.m12554d().m12241a(true), com_ushareit_listenit_crg);
                this.f8749q.m12512a(com_ushareit_listenit_csz.m12552b(), com_ushareit_listenit_csz.m12554d(), cru.m12449a(com_ushareit_listenit_csz.m12554d(), a2), com_ushareit_listenit_csz.m12551a(), false);
            }
            j = a3;
        }
    }

    private void m12365a(cuo<List<crp>> com_ushareit_listenit_cuo_java_util_List_com_ushareit_listenit_crp) {
        if (((List) com_ushareit_listenit_cuo_java_util_List_com_ushareit_listenit_crp.m12764a()) != null) {
            List<crp> c = m12379c((cuo) com_ushareit_listenit_cuo_java_util_List_com_ushareit_listenit_crp);
            if (f8733b || c.size() > 0) {
                Boolean valueOf;
                Boolean valueOf2 = Boolean.valueOf(true);
                for (crp d : c) {
                    if (d.f8809d != crq.RUN) {
                        valueOf = Boolean.valueOf(false);
                        break;
                    }
                }
                valueOf = valueOf2;
                if (valueOf.booleanValue()) {
                    m12369a((List) c, com_ushareit_listenit_cuo_java_util_List_com_ushareit_listenit_crp.m12771b());
                    return;
                }
                return;
            }
            throw new AssertionError();
        } else if (com_ushareit_listenit_cuo_java_util_List_com_ushareit_listenit_crp.m12773c()) {
            com_ushareit_listenit_cuo_java_util_List_com_ushareit_listenit_crp.m12772b(new crl(this));
        }
    }

    private void m12366a(cuo<List<crp>> com_ushareit_listenit_cuo_java_util_List_com_ushareit_listenit_crp, int i) {
        List list = (List) com_ushareit_listenit_cuo_java_util_List_com_ushareit_listenit_crp.m12764a();
        List arrayList = new ArrayList();
        if (list != null) {
            ece a;
            List<Runnable> arrayList2 = new ArrayList();
            if (i == -9) {
                a = ece.m16710a("overriddenBySet");
            } else {
                cyr.m13388a(i == -25, "Unknown transaction abort reason: " + i);
                a = ece.m16709a(-25);
            }
            int i2 = 0;
            int i3 = -1;
            while (i2 < list.size()) {
                int i4;
                crp com_ushareit_listenit_crp = (crp) list.get(i2);
                if (com_ushareit_listenit_crp.f8809d == crq.SENT_NEEDS_ABORT) {
                    i4 = i3;
                } else if (com_ushareit_listenit_crp.f8809d == crq.SENT) {
                    if (f8733b || i3 == i2 - 1) {
                        com_ushareit_listenit_crp.f8809d = crq.SENT_NEEDS_ABORT;
                        com_ushareit_listenit_crp.f8813h = a;
                        i4 = i2;
                    } else {
                        throw new AssertionError();
                    }
                } else if (f8733b || com_ushareit_listenit_crp.f8809d == crq.RUN) {
                    m12391a(new ctb(this, com_ushareit_listenit_crp.f8808c, cvg.m13000a(com_ushareit_listenit_crp.f8806a)));
                    if (i == -9) {
                        arrayList.addAll(this.f8749q.m12509a(com_ushareit_listenit_crp.f8814i, true, false, this.f8736d));
                    } else {
                        cyr.m13388a(i == -25, "Unknown transaction abort reason: " + i);
                    }
                    arrayList2.add(new crb(this, com_ushareit_listenit_crp, a));
                    i4 = i3;
                } else {
                    throw new AssertionError();
                }
                i2++;
                i3 = i4;
            }
            if (i3 == -1) {
                com_ushareit_listenit_cuo_java_util_List_com_ushareit_listenit_crp.m12768a(null);
            } else {
                com_ushareit_listenit_cuo_java_util_List_com_ushareit_listenit_crp.m12768a(list.subList(0, i3 + 1));
            }
            m12368a(arrayList);
            for (Runnable b : arrayList2) {
                m12403b(b);
            }
        }
    }

    private void m12367a(String str, cqq com_ushareit_listenit_cqq, ece com_ushareit_listenit_ece) {
        if (com_ushareit_listenit_ece != null && com_ushareit_listenit_ece.m16714a() != -1 && com_ushareit_listenit_ece.m16714a() != -25) {
            cvy com_ushareit_listenit_cvy = this.f8744l;
            String valueOf = String.valueOf(com_ushareit_listenit_cqq.toString());
            String valueOf2 = String.valueOf(com_ushareit_listenit_ece.toString());
            com_ushareit_listenit_cvy.m13090a(new StringBuilder(((String.valueOf(str).length() + 13) + String.valueOf(valueOf).length()) + String.valueOf(valueOf2).length()).append(str).append(" at ").append(valueOf).append(" failed: ").append(valueOf2).toString());
        }
    }

    private void m12368a(List<? extends cux> list) {
        if (!list.isEmpty()) {
            this.f8742j.m12976a((List) list);
        }
    }

    private void m12369a(List<crp> list, cqq com_ushareit_listenit_cqq) {
        List arrayList = new ArrayList();
        for (crp c : list) {
            arrayList.add(Long.valueOf(c.f8814i));
        }
        cxa a = m12354a(com_ushareit_listenit_cqq, arrayList);
        String str = "badhash";
        String d = a.mo1638d();
        for (crp c2 : list) {
            if (f8733b || c2.f8809d == crq.RUN) {
                c2.f8809d = crq.SENT;
                c2.f8812g = c2.f8812g + 1;
                a = a.mo1630a(cqq.m12333a(com_ushareit_listenit_cqq, c2.f8806a), c2.f8816k);
            } else {
                throw new AssertionError();
            }
        }
        Object a2 = a.mo1632a(true);
        m12381d();
        this.f8737e.mo1522a(com_ushareit_listenit_cqq.m12342c(), a2, d, new crm(this, com_ushareit_listenit_cqq, list, this));
    }

    private void m12370a(List<crp> list, cuo<List<crp>> com_ushareit_listenit_cuo_java_util_List_com_ushareit_listenit_crp) {
        List list2 = (List) com_ushareit_listenit_cuo_java_util_List_com_ushareit_listenit_crp.m12764a();
        if (list2 != null) {
            list.addAll(list2);
        }
        com_ushareit_listenit_cuo_java_util_List_com_ushareit_listenit_crp.m12772b(new cqy(this, list));
    }

    private cuo<List<crp>> m12371b(cqq com_ushareit_listenit_cqq) {
        cuo<List<crp>> com_ushareit_listenit_cuo_java_util_List_com_ushareit_listenit_crp = this.f8740h;
        while (!com_ushareit_listenit_cqq.m12347h() && com_ushareit_listenit_cuo_java_util_List_com_ushareit_listenit_crp.m12764a() == null) {
            com_ushareit_listenit_cuo_java_util_List_com_ushareit_listenit_crp = com_ushareit_listenit_cuo_java_util_List_com_ushareit_listenit_crp.m12763a(new cqq(com_ushareit_listenit_cqq.m12343d()));
            com_ushareit_listenit_cqq = com_ushareit_listenit_cqq.m12344e();
        }
        return com_ushareit_listenit_cuo_java_util_List_com_ushareit_listenit_crp;
    }

    private static ece m12373b(String str, String str2) {
        return str != null ? ece.m16711a(str, str2) : null;
    }

    private void m12375b(cuo<List<crp>> com_ushareit_listenit_cuo_java_util_List_com_ushareit_listenit_crp) {
        Object obj = (List) com_ushareit_listenit_cuo_java_util_List_com_ushareit_listenit_crp.m12764a();
        if (obj != null) {
            int i = 0;
            while (i < obj.size()) {
                int i2;
                if (((crp) obj.get(i)).f8809d == crq.COMPLETED) {
                    obj.remove(i);
                    i2 = i;
                } else {
                    i2 = i + 1;
                }
                i = i2;
            }
            if (obj.size() > 0) {
                com_ushareit_listenit_cuo_java_util_List_com_ushareit_listenit_crp.m12768a(obj);
            } else {
                com_ushareit_listenit_cuo_java_util_List_com_ushareit_listenit_crp.m12768a(null);
            }
        }
        com_ushareit_listenit_cuo_java_util_List_com_ushareit_listenit_crp.m12772b(new cro(this));
    }

    private void m12376b(cwc com_ushareit_listenit_cwc, Object obj) {
        if (com_ushareit_listenit_cwc.equals(cqc.f8691b)) {
            this.f8736d.m13379a(((Long) obj).longValue());
        }
        cqq com_ushareit_listenit_cqq = new cqq(cqc.f8690a, com_ushareit_listenit_cwc);
        try {
            cxa a = cxd.m13275a(obj);
            this.f8738f.m12461a(com_ushareit_listenit_cqq, a);
            m12368a(this.f8748p.m12513a(com_ushareit_listenit_cqq, a));
        } catch (Throwable e) {
            this.f8744l.m13091a("Failed to parse info update", e);
        }
    }

    private void m12377b(List<crp> list, cqq com_ushareit_listenit_cqq) {
        if (!list.isEmpty()) {
            List arrayList = new ArrayList();
            List arrayList2 = new ArrayList();
            for (crp c : list) {
                arrayList2.add(Long.valueOf(c.f8814i));
            }
            for (crp com_ushareit_listenit_crp : list) {
                cqq a = cqq.m12333a(com_ushareit_listenit_cqq, com_ushareit_listenit_crp.f8806a);
                ArrayList arrayList3 = new ArrayList();
                if (f8733b || a != null) {
                    Object obj;
                    ece k;
                    if (com_ushareit_listenit_crp.f8809d == crq.NEEDS_ABORT) {
                        obj = 1;
                        k = com_ushareit_listenit_crp.f8813h;
                        if (k.m16714a() != -25) {
                            arrayList3.addAll(this.f8749q.m12509a(com_ushareit_listenit_crp.f8814i, true, false, this.f8736d));
                        }
                    } else if (com_ushareit_listenit_crp.f8809d != crq.RUN) {
                        k = null;
                        obj = null;
                    } else if (com_ushareit_listenit_crp.f8812g >= 25) {
                        obj = 1;
                        k = ece.m16710a("maxretries");
                        arrayList3.addAll(this.f8749q.m12509a(com_ushareit_listenit_crp.f8814i, true, false, this.f8736d));
                    } else {
                        ecx a2;
                        cxa a3 = m12354a(com_ushareit_listenit_crp.f8806a, arrayList2);
                        com_ushareit_listenit_crp.f8815j = a3;
                        try {
                            a2 = com_ushareit_listenit_crp.f8807b.m16751a(eeh.m16844a(a3));
                            k = null;
                        } catch (Throwable th) {
                            ece a4 = ece.m16713a(th);
                            a2 = ecu.m16750a();
                            k = a4;
                        }
                        if (a2.m16753a()) {
                            Long valueOf = Long.valueOf(com_ushareit_listenit_crp.f8814i);
                            Map a5 = cru.m12453a(this.f8736d);
                            cxa b = a2.m16754b();
                            cxa a6 = cru.m12451a(b, a5);
                            com_ushareit_listenit_crp.f8816k = b;
                            com_ushareit_listenit_crp.f8817l = a6;
                            com_ushareit_listenit_crp.f8814i = m12381d();
                            arrayList2.remove(valueOf);
                            arrayList3.addAll(this.f8749q.m12515a(com_ushareit_listenit_crp.f8806a, b, a6, com_ushareit_listenit_crp.f8814i, com_ushareit_listenit_crp.f8811f, false));
                            arrayList3.addAll(this.f8749q.m12509a(valueOf.longValue(), true, false, this.f8736d));
                            k = null;
                            obj = null;
                        } else {
                            obj = 1;
                            arrayList3.addAll(this.f8749q.m12509a(com_ushareit_listenit_crp.f8814i, true, false, this.f8736d));
                        }
                    }
                    m12368a((List) arrayList3);
                    if (obj != null) {
                        com_ushareit_listenit_crp.f8809d = crq.COMPLETED;
                        ecb a7 = eeh.m16842a(eeh.m16843a(this, com_ushareit_listenit_crp.f8806a), cwt.m13242a(com_ushareit_listenit_crp.f8815j));
                        m12396a(new cqv(this, com_ushareit_listenit_crp));
                        arrayList.add(new cqw(this, com_ushareit_listenit_crp, k, a7));
                    }
                } else {
                    throw new AssertionError();
                }
            }
            m12375b(this.f8740h);
            for (int i = 0; i < arrayList.size(); i++) {
                m12403b((Runnable) arrayList.get(i));
            }
            m12386f();
        }
    }

    private List<crp> m12379c(cuo<List<crp>> com_ushareit_listenit_cuo_java_util_List_com_ushareit_listenit_crp) {
        List arrayList = new ArrayList();
        m12370a(arrayList, (cuo) com_ushareit_listenit_cuo_java_util_List_com_ushareit_listenit_crp);
        Collections.sort(arrayList);
        return arrayList;
    }

    private void m12380c() {
        this.f8743k.m12284o().mo1445a(new cqx(this));
        this.f8737e.mo1516a();
        ctu b = this.f8743k.m12270b(this.f8735c.f8825a);
        this.f8738f = new crx();
        this.f8739g = new cry();
        this.f8740h = new cuo();
        this.f8748p = new csd(this.f8743k, new ctt(), new crc(this));
        this.f8749q = new csd(this.f8743k, b, new cre(this));
        m12364a(b);
        m12376b(cqc.f8692c, Boolean.valueOf(false));
        m12376b(cqc.f8693d, Boolean.valueOf(false));
    }

    private long m12381d() {
        long j = this.f8747o;
        this.f8747o = 1 + j;
        return j;
    }

    private void m12384e() {
        cry a = cru.m12450a(this.f8739g, cru.m12453a(this.f8736d));
        List arrayList = new ArrayList();
        a.m12462a(cqq.m12332a(), new crk(this, arrayList));
        this.f8739g = new cry();
        m12368a(arrayList);
    }

    private void m12386f() {
        cuo com_ushareit_listenit_cuo = this.f8740h;
        m12375b(com_ushareit_listenit_cuo);
        m12365a(com_ushareit_listenit_cuo);
    }

    public void mo1557a() {
        m12394a(cqc.f8693d, Boolean.valueOf(true));
    }

    public void m12391a(cqh com_ushareit_listenit_cqh) {
        m12368a(cqc.f8690a.equals(com_ushareit_listenit_cqh.mo1582a().m13002a().m12343d()) ? this.f8748p.m12523b(com_ushareit_listenit_cqh) : this.f8749q.m12523b(com_ushareit_listenit_cqh));
    }

    public void m12392a(cqq com_ushareit_listenit_cqq, cpz com_ushareit_listenit_cpz, ecj com_ushareit_listenit_ecj, Map<String, Object> map) {
        if (this.f8744l.m13094a()) {
            cvy com_ushareit_listenit_cvy = this.f8744l;
            String valueOf = String.valueOf(com_ushareit_listenit_cqq);
            com_ushareit_listenit_cvy.m13093a(new StringBuilder(String.valueOf(valueOf).length() + 8).append("update: ").append(valueOf).toString(), new Object[0]);
        }
        if (this.f8746n.m13094a()) {
            com_ushareit_listenit_cvy = this.f8746n;
            valueOf = String.valueOf(com_ushareit_listenit_cqq);
            String valueOf2 = String.valueOf(map);
            com_ushareit_listenit_cvy.m13093a(new StringBuilder((String.valueOf(valueOf).length() + 9) + String.valueOf(valueOf2).length()).append("update: ").append(valueOf).append(" ").append(valueOf2).toString(), new Object[0]);
        }
        if (com_ushareit_listenit_cpz.m12248e()) {
            if (this.f8744l.m13094a()) {
                this.f8744l.m13093a("update called with no changes. No-op", new Object[0]);
            }
            m12395a(com_ushareit_listenit_ecj, null, com_ushareit_listenit_cqq);
            return;
        }
        cpz a = cru.m12449a(com_ushareit_listenit_cpz, cru.m12453a(this.f8736d));
        long d = m12381d();
        m12368a(this.f8749q.m12512a(com_ushareit_listenit_cqq, com_ushareit_listenit_cpz, a, d, true));
        this.f8737e.mo1525a(com_ushareit_listenit_cqq.m12342c(), (Map) map, new crj(this, com_ushareit_listenit_cqq, d, com_ushareit_listenit_ecj));
        m12350a(m12351a(com_ushareit_listenit_cqq, -9));
    }

    public void m12393a(cqq com_ushareit_listenit_cqq, cxa com_ushareit_listenit_cxa, ecj com_ushareit_listenit_ecj) {
        if (this.f8744l.m13094a()) {
            cvy com_ushareit_listenit_cvy = this.f8744l;
            String valueOf = String.valueOf(com_ushareit_listenit_cqq);
            com_ushareit_listenit_cvy.m13093a(new StringBuilder(String.valueOf(valueOf).length() + 5).append("set: ").append(valueOf).toString(), new Object[0]);
        }
        if (this.f8746n.m13094a()) {
            com_ushareit_listenit_cvy = this.f8746n;
            valueOf = String.valueOf(com_ushareit_listenit_cqq);
            String valueOf2 = String.valueOf(com_ushareit_listenit_cxa);
            com_ushareit_listenit_cvy.m13093a(new StringBuilder((String.valueOf(valueOf).length() + 6) + String.valueOf(valueOf2).length()).append("set: ").append(valueOf).append(" ").append(valueOf2).toString(), new Object[0]);
        }
        cxa a = cru.m12451a(com_ushareit_listenit_cxa, cru.m12453a(this.f8736d));
        long d = m12381d();
        m12368a(this.f8749q.m12515a(com_ushareit_listenit_cqq, com_ushareit_listenit_cxa, a, d, true, true));
        this.f8737e.mo1521a(com_ushareit_listenit_cqq.m12342c(), com_ushareit_listenit_cxa.mo1632a(true), new cri(this, com_ushareit_listenit_cqq, d, com_ushareit_listenit_ecj));
        m12350a(m12351a(com_ushareit_listenit_cqq, -9));
    }

    public void m12394a(cwc com_ushareit_listenit_cwc, Object obj) {
        m12376b(com_ushareit_listenit_cwc, obj);
    }

    void m12395a(ecj com_ushareit_listenit_ecj, ece com_ushareit_listenit_ece, cqq com_ushareit_listenit_cqq) {
        if (com_ushareit_listenit_ecj != null) {
            cwc g = com_ushareit_listenit_cqq.m12346g();
            ecg a = (g == null || !g.m13145e()) ? eeh.m16843a(this, com_ushareit_listenit_cqq) : eeh.m16843a(this, com_ushareit_listenit_cqq.m12345f());
            m12403b(new crh(this, com_ushareit_listenit_ecj, com_ushareit_listenit_ece, a));
        }
    }

    public void m12396a(Runnable runnable) {
        this.f8743k.m12272c();
        this.f8743k.m12281l().mo1459a(runnable);
    }

    public void mo1558a(List<String> list, Object obj, boolean z, Long l) {
        List a;
        cqq com_ushareit_listenit_cqq = new cqq((List) list);
        if (this.f8744l.m13094a()) {
            cvy com_ushareit_listenit_cvy = this.f8744l;
            String valueOf = String.valueOf(com_ushareit_listenit_cqq);
            com_ushareit_listenit_cvy.m13093a(new StringBuilder(String.valueOf(valueOf).length() + 14).append("onDataUpdate: ").append(valueOf).toString(), new Object[0]);
        }
        if (this.f8746n.m13094a()) {
            com_ushareit_listenit_cvy = this.f8744l;
            valueOf = String.valueOf(com_ushareit_listenit_cqq);
            String valueOf2 = String.valueOf(obj);
            com_ushareit_listenit_cvy.m13093a(new StringBuilder((String.valueOf(valueOf).length() + 15) + String.valueOf(valueOf2).length()).append("onDataUpdate: ").append(valueOf).append(" ").append(valueOf2).toString(), new Object[0]);
        }
        this.f8734a++;
        if (l != null) {
            try {
                csu com_ushareit_listenit_csu = new csu(l.longValue());
                if (z) {
                    Map hashMap = new HashMap();
                    for (Entry entry : ((Map) obj).entrySet()) {
                        hashMap.put(new cqq((String) entry.getKey()), cxd.m13275a(entry.getValue()));
                    }
                    a = this.f8749q.m12519a(com_ushareit_listenit_cqq, hashMap, com_ushareit_listenit_csu);
                } else {
                    a = this.f8749q.m12514a(com_ushareit_listenit_cqq, cxd.m13275a(obj), com_ushareit_listenit_csu);
                }
            } catch (Throwable e) {
                this.f8744l.m13091a("FIREBASE INTERNAL ERROR", e);
                return;
            }
        } else if (z) {
            Map hashMap2 = new HashMap();
            for (Entry entry2 : ((Map) obj).entrySet()) {
                hashMap2.put(new cqq((String) entry2.getKey()), cxd.m13275a(entry2.getValue()));
            }
            a = this.f8749q.m12518a(com_ushareit_listenit_cqq, hashMap2);
        } else {
            a = this.f8749q.m12513a(com_ushareit_listenit_cqq, cxd.m13275a(obj));
        }
        if (a.size() > 0) {
            m12350a(com_ushareit_listenit_cqq);
        }
        m12368a(a);
    }

    public void mo1559a(List<String> list, List<cpg> list2, Long l) {
        cqq com_ushareit_listenit_cqq = new cqq((List) list);
        if (this.f8744l.m13094a()) {
            cvy com_ushareit_listenit_cvy = this.f8744l;
            String valueOf = String.valueOf(com_ushareit_listenit_cqq);
            com_ushareit_listenit_cvy.m13093a(new StringBuilder(String.valueOf(valueOf).length() + 20).append("onRangeMergeUpdate: ").append(valueOf).toString(), new Object[0]);
        }
        if (this.f8746n.m13094a()) {
            com_ushareit_listenit_cvy = this.f8744l;
            valueOf = String.valueOf(com_ushareit_listenit_cqq);
            String valueOf2 = String.valueOf(list2);
            com_ushareit_listenit_cvy.m13093a(new StringBuilder((String.valueOf(valueOf).length() + 21) + String.valueOf(valueOf2).length()).append("onRangeMergeUpdate: ").append(valueOf).append(" ").append(valueOf2).toString(), new Object[0]);
        }
        this.f8734a++;
        List arrayList = new ArrayList(list2.size());
        for (cpg com_ushareit_listenit_cxh : list2) {
            arrayList.add(new cxh(com_ushareit_listenit_cxh));
        }
        List a = l != null ? this.f8749q.m12517a(com_ushareit_listenit_cqq, arrayList, new csu(l.longValue())) : this.f8749q.m12516a(com_ushareit_listenit_cqq, arrayList);
        if (a.size() > 0) {
            m12350a(com_ushareit_listenit_cqq);
        }
        m12368a(a);
    }

    public void mo1560a(Map<String, Object> map) {
        for (Entry entry : map.entrySet()) {
            m12376b(cwc.m13139a((String) entry.getKey()), entry.getValue());
        }
    }

    public void mo1561a(boolean z) {
        m12394a(cqc.f8692c, Boolean.valueOf(z));
    }

    public void mo1562b() {
        m12394a(cqc.f8693d, Boolean.valueOf(false));
        m12384e();
    }

    public void m12402b(cqh com_ushareit_listenit_cqh) {
        cwc d = com_ushareit_listenit_cqh.mo1582a().m13002a().m12343d();
        List a = (d == null || !d.equals(cqc.f8690a)) ? this.f8749q.m12510a(com_ushareit_listenit_cqh) : this.f8748p.m12510a(com_ushareit_listenit_cqh);
        m12368a(a);
    }

    public void m12403b(Runnable runnable) {
        this.f8743k.m12272c();
        this.f8743k.m12280k().mo1451a(runnable);
    }

    public String toString() {
        return this.f8735c.toString();
    }
}
