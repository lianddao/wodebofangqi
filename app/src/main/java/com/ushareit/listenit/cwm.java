package com.ushareit.listenit;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

class cwm {
    private StringBuilder f9268a = null;
    private Stack<cwc> f9269b = new Stack();
    private int f9270c = -1;
    private int f9271d;
    private boolean f9272e = true;
    private final List<cqq> f9273f = new ArrayList();
    private final List<String> f9274g = new ArrayList();
    private final cwo f9275h;

    public cwm(cwo com_ushareit_listenit_cwo) {
        this.f9275h = com_ushareit_listenit_cwo;
    }

    private cqq m13184a(int i) {
        cwc[] com_ushareit_listenit_cwcArr = new cwc[i];
        for (int i2 = 0; i2 < i; i2++) {
            com_ushareit_listenit_cwcArr[i2] = (cwc) this.f9269b.get(i2);
        }
        return new cqq(com_ushareit_listenit_cwcArr);
    }

    private void m13185a(cwc com_ushareit_listenit_cwc) {
        m13193d();
        if (this.f9272e) {
            this.f9268a.append(",");
        }
        m13190a(this.f9268a, com_ushareit_listenit_cwc);
        this.f9268a.append(":(");
        if (this.f9271d == this.f9269b.size()) {
            this.f9269b.add(com_ushareit_listenit_cwc);
        } else {
            this.f9269b.set(this.f9271d, com_ushareit_listenit_cwc);
        }
        this.f9271d++;
        this.f9272e = false;
    }

    private void m13189a(cwv<?> com_ushareit_listenit_cwv_) {
        m13193d();
        this.f9270c = this.f9271d;
        this.f9268a.append(com_ushareit_listenit_cwv_.mo1644a(cxc.V2));
        this.f9272e = true;
        if (this.f9275h.mo1651a(this)) {
            m13197g();
        }
    }

    private void m13190a(StringBuilder stringBuilder, cwc com_ushareit_listenit_cwc) {
        stringBuilder.append(cyr.m13390c(com_ushareit_listenit_cwc.m13144d()));
    }

    private void m13193d() {
        if (!m13198a()) {
            this.f9268a = new StringBuilder();
            this.f9268a.append("(");
            Iterator it = m13184a(this.f9271d).iterator();
            while (it.hasNext()) {
                m13190a(this.f9268a, (cwc) it.next());
                this.f9268a.append(":(");
            }
            this.f9272e = false;
        }
    }

    private void m13195e() {
        this.f9271d--;
        if (m13198a()) {
            this.f9268a.append(")");
        }
        this.f9272e = true;
    }

    private void m13196f() {
        cyr.m13388a(this.f9271d == 0, "Can't finish hashing in the middle processing a child");
        if (m13198a()) {
            m13197g();
        }
        this.f9274g.add("");
    }

    private void m13197g() {
        cyr.m13388a(m13198a(), "Can't end range without starting a range!");
        for (int i = 0; i < this.f9271d; i++) {
            this.f9268a.append(")");
        }
        this.f9268a.append(")");
        cqq a = m13184a(this.f9270c);
        this.f9274g.add(cyr.m13389b(this.f9268a.toString()));
        this.f9273f.add(a);
        this.f9268a = null;
    }

    public boolean m13198a() {
        return this.f9268a != null;
    }

    public int m13199b() {
        return this.f9268a.length();
    }

    public cqq m13200c() {
        return m13184a(this.f9271d);
    }
}
