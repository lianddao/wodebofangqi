package com.ushareit.listenit;

public class ecp {
    static final /* synthetic */ boolean f10819d = (!ecp.class.desiredAssertionStatus());
    protected final cqt f10820a;
    protected final cqq f10821b;
    protected final cvd f10822c;
    private final boolean f10823e;

    ecp(cqt com_ushareit_listenit_cqt, cqq com_ushareit_listenit_cqq) {
        this.f10820a = com_ushareit_listenit_cqt;
        this.f10821b = com_ushareit_listenit_cqq;
        this.f10822c = cvd.f9184a;
        this.f10823e = false;
    }

    ecp(cqt com_ushareit_listenit_cqt, cqq com_ushareit_listenit_cqq, cvd com_ushareit_listenit_cvd, boolean z) {
        this.f10820a = com_ushareit_listenit_cqt;
        this.f10821b = com_ushareit_listenit_cqq;
        this.f10822c = com_ushareit_listenit_cvd;
        this.f10823e = z;
        cyr.m13388a(com_ushareit_listenit_cvd.m12997o(), "Validation of queries failed.");
    }

    private ecp m16717a(cxa com_ushareit_listenit_cxa, String str) {
        cyt.m13400c(str);
        if (!com_ushareit_listenit_cxa.mo1639e() && !com_ushareit_listenit_cxa.mo1635b()) {
            throw new IllegalArgumentException("Can only use simple values for startAt()");
        } else if (this.f10822c.m12983a()) {
            throw new IllegalArgumentException("Can't call startAt() or equalTo() multiple times");
        } else {
            cvd a = this.f10822c.m12982a(com_ushareit_listenit_cxa, str != null ? cwc.m13139a(str) : null);
            m16722b(a);
            m16720a(a);
            if (f10819d || a.m12997o()) {
                return new ecp(this.f10820a, this.f10821b, a, this.f10823e);
            }
            throw new AssertionError();
        }
    }

    private void mo2134a() {
        if (this.f10823e) {
            throw new IllegalArgumentException("You can't combine multiple orderBy calls!");
        }
    }

    private void m16719a(cqh com_ushareit_listenit_cqh) {
        ctg.m12603a().m12607c(com_ushareit_listenit_cqh);
        this.f10820a.m12396a(new ecr(this, com_ushareit_listenit_cqh));
    }

    private void m16720a(cvd com_ushareit_listenit_cvd) {
        if (com_ushareit_listenit_cvd.m12992j().equals(cwu.m13253d())) {
            cxa b;
            String str = "You must use startAt(String value), endAt(String value) or equalTo(String value) in combination with orderByKey(). Other type of values or using the version with 2 parameters is not supported";
            if (com_ushareit_listenit_cvd.m12983a()) {
                b = com_ushareit_listenit_cvd.m12984b();
                if (!(com_ushareit_listenit_cvd.m12985c() == cwc.m13138a() && (b instanceof cxi))) {
                    throw new IllegalArgumentException(str);
                }
            }
            if (com_ushareit_listenit_cvd.m12986d()) {
                b = com_ushareit_listenit_cvd.m12987e();
                if (com_ushareit_listenit_cvd.m12988f() != cwc.m13140b() || !(b instanceof cxi)) {
                    throw new IllegalArgumentException(str);
                }
            }
        } else if (!com_ushareit_listenit_cvd.m12992j().equals(cxf.m13282d())) {
        } else {
            if ((com_ushareit_listenit_cvd.m12983a() && !cxg.m13290a(com_ushareit_listenit_cvd.m12984b())) || (com_ushareit_listenit_cvd.m12986d() && !cxg.m13290a(com_ushareit_listenit_cvd.m12987e()))) {
                throw new IllegalArgumentException("When using orderByPriority(), values provided to startAt(), endAt(), or equalTo() must be valid priorities.");
            }
        }
    }

    private void m16721b(cqh com_ushareit_listenit_cqh) {
        ctg.m12603a().m12606b(com_ushareit_listenit_cqh);
        this.f10820a.m12396a(new ecs(this, com_ushareit_listenit_cqh));
    }

    private void m16722b(cvd com_ushareit_listenit_cvd) {
        if (com_ushareit_listenit_cvd.m12983a() && com_ushareit_listenit_cvd.m12986d() && com_ushareit_listenit_cvd.m12989g() && !com_ushareit_listenit_cvd.m12990h()) {
            throw new IllegalArgumentException("Can't combine startAt(), endAt() and limit(). Use limitToFirst() or limitToLast() instead");
        }
    }

    public ecp m16723a(double d) {
        return m16724a(d, null);
    }

    public ecp m16724a(double d, String str) {
        return m16717a(new cwq(Double.valueOf(d), cxg.m13288a()), str);
    }

    public ecp m16725a(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("Limit must be a positive integer!");
        } else if (!this.f10822c.m12989g()) {
            return new ecp(this.f10820a, this.f10821b, this.f10822c.m12980a(i), this.f10823e);
        } else {
            throw new IllegalArgumentException("Can't call limitToLast on query with previously set limit!");
        }
    }

    public void m16726a(ecy com_ushareit_listenit_ecy) {
        m16721b(new ctb(this.f10820a, new ecq(this, com_ushareit_listenit_ecy), m16730d()));
    }

    public ecp m16727b(String str) {
        if (str == null) {
            throw new NullPointerException("Key can't be null");
        } else if (str.equals("$key") || str.equals(".key")) {
            throw new IllegalArgumentException(new StringBuilder(String.valueOf(str).length() + 54).append("Can't use '").append(str).append("' as path, please use orderByKey() instead!").toString());
        } else if (str.equals("$priority") || str.equals(".priority")) {
            throw new IllegalArgumentException(new StringBuilder(String.valueOf(str).length() + 59).append("Can't use '").append(str).append("' as path, please use orderByPriority() instead!").toString());
        } else if (str.equals("$value") || str.equals(".value")) {
            throw new IllegalArgumentException(new StringBuilder(String.valueOf(str).length() + 56).append("Can't use '").append(str).append("' as path, please use orderByValue() instead!").toString());
        } else {
            cyt.m13397a(str);
            mo2134a();
            cqq com_ushareit_listenit_cqq = new cqq(str);
            if (com_ushareit_listenit_cqq.m12348i() == 0) {
                throw new IllegalArgumentException("Can't use empty path, use orderByValue() instead!");
            }
            return new ecp(this.f10820a, this.f10821b, this.f10822c.m12981a(new cxe(com_ushareit_listenit_cqq)), true);
        }
    }

    public void m16728b(ecy com_ushareit_listenit_ecy) {
        if (com_ushareit_listenit_ecy == null) {
            throw new NullPointerException("listener must not be null");
        }
        m16719a(new ctb(this.f10820a, com_ushareit_listenit_ecy, m16730d()));
    }

    public cqq m16729c() {
        return this.f10821b;
    }

    public cvg m16730d() {
        return new cvg(this.f10821b, this.f10822c);
    }
}
